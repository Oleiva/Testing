package io.github.Oleiva.controllers;

import io.github.Oleiva.dao.CustomersDao;
import io.github.Oleiva.dao.ItemsDao;
import io.github.Oleiva.dao.OrdersDao;
import io.github.Oleiva.dao.ShippingAddressesDao;
import io.github.Oleiva.dto.pojo.OrderPojo;
import io.github.Oleiva.dto.pojo.ResponsePojo;
import io.github.Oleiva.entity.OrdersEntity;
import io.github.Oleiva.services.CustomersService;
import io.github.Oleiva.services.ItemsService;
import io.github.Oleiva.services.OrdersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrdersController {
    public final Logger LOG = Logger.getLogger(this.getClass());


    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private CustomersDao customersDao;

    @Autowired
    private ItemsDao itemsDao;

    @Autowired
    private ShippingAddressesDao shippingAddressesDao;

//    @Autowired
    ResponsePojo responsePojo;

    OrderPojo orderPojo;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private CustomersService customersService;

    @Autowired
    private OrdersService ordersService;


    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public List<OrdersEntity> getAll() {
//        return itemsDao.findAll();
        return ordersDao.findAll();
    }

    @RequestMapping(value="/get-by-id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public OrdersEntity getById(@PathVariable long id) {

        if (ordersDao.findOne(id) == null) {
            LOG.warn("Number of orders does not exist");
        }
//        return itemsDao.findOne(id);
        return ordersDao.findOne(id);
    }

//    id -->orderid
    @RequestMapping(value="/test/{id}",method = RequestMethod.GET)
    @ResponseBody
    public long test(@PathVariable long id) {

        if (ordersDao.findOne(id) == null) {
            LOG.warn("Number of orders does not exist");
        }
//        return itemsDao.findOne(id);
        return ordersService.getOrderId(id);
    }

/// Get by ORder
@RequestMapping(value="/get-by-order/{id}",method = RequestMethod.GET)
@ResponseBody
public Collection<OrdersEntity> getByOrderId(@PathVariable long id,
                                             OrderPojo orderPojo) {

    if (ordersDao.findOne(id) == null) {
        LOG.warn("Number of orders does not exist");
    }
        return ordersService.showOrder(id);

}


//    @RequestMapping(value="/get-by-order/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public Collection<OrdersEntity> getByOrderId(@PathVariable long id) {
//
//        if (ordersDao.findOne(id) == null) {
//            LOG.warn("Number of orders does not exist");
//        }
////        return ordersDao.findByOrderId(id);
//        return ordersService.showOrder(id);
//    }


    @RequestMapping(value="/add-new/{cust}/{adress}/{item}/{amount}",method = RequestMethod.POST)
    @ResponseBody
    public ResponsePojo  addItemToNewOrder(@PathVariable(value = "cust")   long cust,
                                          @PathVariable(value = "adress") long adress,
                                          @PathVariable(value = "item")   long item,
                                          @PathVariable(value = "amount") long amount,
                                           ResponsePojo responsePojo){
        int swither = 0;

        try{
            if(customersDao.findOne(cust) !=null){
                swither ++;
                LOG.info("cust was found");
            }else {
                LOG.info("cust not found");
                responsePojo.setMessage(responsePojo.getMessage()+" Cust.. not found. ");
            }
        }catch (Exception ex){
            responsePojo.setMessage(responsePojo.getMessage()+" Exeption cust");
        }

       try{
           if (shippingAddressesDao.findOne(adress)!= null){
               swither ++;
               LOG.info("adress was found");

           }else {
               LOG.info("cust not found");
               responsePojo.setMessage(responsePojo.getMessage()+" Cust.. not found. ");
           }
       }catch (Exception ex){
           responsePojo.setMessage(responsePojo.getMessage()+"Exeption ADress ");
       }

       try{
           if (itemsDao.findOne(item)!=null){
               swither++;
               LOG.info("item was found");
           }else{
               LOG.info("item not found");
               responsePojo.setMessage(responsePojo.getMessage()+" Item.. not found. ");
           }
       }catch (Exception ex){
           responsePojo.setMessage(responsePojo.getMessage()+" Exeption item ");
       }

     try{
         if (swither == 3) {
             if ( itemsService.amountItemInStock(item)>= amount ) {

//                 if(customersDao.findOne(cust).getAVAILABLE_CREDIT() > itemsDao.findOne(item).getPRICE() *amount ){
                 long ante = itemsService.getAnte(item,amount);
                 if(customersDao.findOne(cust).getAVAILABLE_CREDIT() > ante ) {

//                     В один этап, без резервирования  +
//                     Отнять столько позиций           +
//                     Отнять столко денег              +
//                     Создать плетеж

                     itemsService.removeFromStock(item,amount);
                     customersService.removeFromCredit(cust,ante);
//                                          |long      |long       |String |String|long  |
//                                          |CUSTOMERID|ADDRESSESID|SKU    |STATUS|AMOUNT|
//                     ordersService.addOrder(cust,adress,item,"STATUS_OK",amount);
                     ordersService.addNewOrder(cust,adress,item,"STATUS_OK",amount);

                     responsePojo.setMessage("AlL OK. Try to bay");
                 }else {
                     LOG.info("There is not enough money");
                     responsePojo.setMessage(responsePojo.getMessage() + " There is not enough money ");
                 }

             }else {
                 LOG.info("This position is not enough in stock");
                 responsePojo.setMessage(responsePojo.getMessage() + " This position is not enough in stock ");
             }
         }else{
             responsePojo.setMessage("Some Errors occupied "+responsePojo.getMessage());
         }

     }catch (Exception ex){
         responsePojo.setMessage(responsePojo.getMessage()+"Exeption swither ");
     }

//        responsePojo.setMessage("OK");
        return responsePojo;
    }


    @RequestMapping(value="/add-item-to-order/{order}/{item}/{amount}",method = RequestMethod.POST)
    @ResponseBody
    public ResponsePojo  addItemToOrder(@PathVariable(value = "order")   long order,
                                        @PathVariable(value = "item")   long item,
                                        @PathVariable(value = "amount") long amount,
                                        ResponsePojo responsePojo){


        int swither = 0;

        try{
            long orderId = ordersService.getOrderId(order);
            swither ++;
        }catch (Exception e){
            LOG.info("This order not found");
            responsePojo.setMessage(responsePojo.getMessage()+" This order not found ");
        }

        try{
            if (itemsDao.findOne(item)!=null){
                swither++;
                LOG.info("item was found");
            }else{
                LOG.info("item not found");
                responsePojo.setMessage(responsePojo.getMessage()+" Item.. not found. ");
            }
        }catch (Exception ex){
            responsePojo.setMessage(responsePojo.getMessage()+" Exeption item ");
        }

        try{
            if (swither == 2) {
                if ( itemsService.amountItemInStock(item)>= amount ) {

//                 if(customersDao.findOne(cust).getAVAILABLE_CREDIT() > itemsDao.findOne(item).getPRICE() *amount ){
                    long ante = itemsService.getAnte(item,amount);
                    // get customers
                    // get customer adress

                    long cust = 500;
                    long adress = 2;

//                    ordersService.

                    if(customersDao.findOne(cust).getAVAILABLE_CREDIT() > ante ) {

//                     В один этап, без резервирования  +
//                     Отнять столько позиций           +
//                     Отнять столко денег              +
//                     Создать плетеж

                        itemsService.removeFromStock(item,amount);
                        customersService.removeFromCredit(cust,ante);
//                                          |long      |long       |String |String|long  |
//                                          |CUSTOMERID|ADDRESSESID|SKU    |STATUS|AMOUNT|
//                     ordersService.addOrder(cust,adress,item,"STATUS_OK",amount);
                        ordersService.addNewOrder(cust,adress,item,"STATUS_OK",amount);

                        responsePojo.setMessage("AlL OK. Try to bay");
                    }else {
                        LOG.info("There is not enough money");
                        responsePojo.setMessage(responsePojo.getMessage() + " There is not enough money ");
                    }

                }else {
                    LOG.info("This position is not enough in stock");
                    responsePojo.setMessage(responsePojo.getMessage() + " This position is not enough in stock ");
                }
            }else{
                responsePojo.setMessage("Some Errors occupied "+responsePojo.getMessage());
            }

        }catch (Exception ex){
            responsePojo.setMessage(responsePojo.getMessage()+"Exeption swither ");
        }

//        responsePojo.setMessage("OK");
        return responsePojo;
    }





}
