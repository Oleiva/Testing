package io.github.Oleiva.services;

import io.github.Oleiva.dao.ItemsDao;
import io.github.Oleiva.dao.OrdersDao;
import io.github.Oleiva.dao.TransactionsDao;
import io.github.Oleiva.entity.OrdersEntity;
import io.github.Oleiva.entity.TransactionsEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    public final Logger LOG = Logger.getLogger(this.getClass());

   @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private TransactionsDao transactionsDao;

    @Override
    public void addNewOrder(long customerId, long addressesId, long itemId, long amount){



        OrdersEntity ordersEntity = new OrdersEntity(customerId,  addressesId, "PAID");

//        LOG.warn("## orderId" +orderId);
        ordersDao.saveAndFlush(ordersEntity);
        long orderId = ordersEntity.getID();

        LOG.info("## orderId = "+ orderId);


//        long orderId, long itemId, long amount

        TransactionsEntity transactionsEntity = new TransactionsEntity(orderId, itemId, amount);
        transactionsDao.saveAndFlush(transactionsEntity);


    }

    @Override
    public void addExistOrder(long orderId, long itemId, long amount){



//        OrdersEntity ordersEntity = new OrdersEntity(customerId,  addressesId, "PAID");

//        LOG.warn("## orderId" +orderId);
//        ordersDao.saveAndFlush(ordersEntity);

//        long orderId = ordersEntity.getID();

//        LOG.warn("## orderId = "+ orderId);


//        long orderId, long itemId, long amount

        TransactionsEntity transactionsEntity = new TransactionsEntity( orderId,  itemId,  amount);
        transactionsDao.saveAndFlush(transactionsEntity);


    }








//!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    @Override
//    public OrdersEntity addItemToOrder(long order, long itemId, long amount){
//
//
//        long indexOfID;
//
//        try {
//            indexOfID = ordersDao.findOne(ordersDao.findLastIndex()).getOrderId() +1;
//        }catch (Exception e){
//            indexOfID = 1; //if table do not exist --> exception
//        }
//
//        LOG.info("## indexOfID"+indexOfID);
////        OrdersEntity ordersEntity = new OrdersEntity(indexOfID, customerId, addressesId,  itemId,  status,  amount);
//        return  ordersDao.saveAndFlush(ordersEntity);
//    }
//
//
//








//    @Override
//    public Collection<OrdersEntity> showOrder(long orderId){
//      return   ordersDao.findByOrderId(orderId);
//    }
//
//
//    public long getCustomerIdFromOrder(long order){
//      long id =  Integer.parseInt(ordersDao.findByOrderId(order).toString()) ;
//        return id;
//    }

    @Override
    public List<TransactionsEntity> getItemsByOrderId(long order){

        return transactionsDao.findByOrderId(order);

    }

    @Override
    public long getLastOrder() {
        long LastOrder =1;
        if(ordersDao.findLastIndex() != 0){
            LastOrder =  ordersDao.findLastIndex();
        }else {
            LastOrder = 1;
        }
        return LastOrder;
    }

    @Override
    public long getCustomerFromOrder(long order) {
        return ordersDao.findOne(order).getCUSTOMER_ID();
    }

    @Override
    public long getCustomerAddress(long order){
        long getCustomer = ordersDao.findOne(order).getADDRESSES_ID();
        LOG.info("getCustomerAddress = "+getCustomer);

        return getCustomer;

    }



}
