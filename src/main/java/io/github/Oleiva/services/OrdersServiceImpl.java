package io.github.Oleiva.services;

import io.github.Oleiva.dao.OrdersDao;
import io.github.Oleiva.entity.OrdersEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    public final Logger LOG = Logger.getLogger(this.getClass());

   @Autowired
    private OrdersDao ordersDao;

    //@Autowired
    private OrdersEntity ordersEntity;


    @Override
    public OrdersEntity addNewOrder(long customerId, long addressesId, long itemId, String status, long amount){

        long indexOfID;

        try {
            indexOfID = ordersDao.findOne(ordersDao.findLastIndex()).getOrderId() +1;
        }catch (Exception e){
            indexOfID = 1; //if table do not exist --> exception
        }

        LOG.info("## indexOfID"+indexOfID);
        OrdersEntity ordersEntity = new OrdersEntity(indexOfID, customerId, addressesId,  itemId,  status,  amount);
        return  ordersDao.saveAndFlush(ordersEntity);
    }


    @Override
    public OrdersEntity addNewsOrder(long customerId, long addressesId, long itemId, String status, long amount){

        long indexOfID;

        try {
            indexOfID = ordersDao.findOne(ordersDao.findLastIndex()).getOrderId() +1;
        }catch (Exception e){
            indexOfID = 1; //if table do not exist --> exception
        }

        LOG.info("## indexOfID"+indexOfID);
        OrdersEntity ordersEntity = new OrdersEntity(indexOfID, customerId, addressesId,  itemId,  status,  amount);
        return  ordersDao.saveAndFlush(ordersEntity);
    }



    public OrdersEntity addItemToOrder(long order, long itemId, long amount){


        long indexOfID;

        try {
            indexOfID = ordersDao.findOne(ordersDao.findLastIndex()).getOrderId() +1;
        }catch (Exception e){
            indexOfID = 1; //if table do not exist --> exception
        }

        LOG.info("## indexOfID"+indexOfID);
//        OrdersEntity ordersEntity = new OrdersEntity(indexOfID, customerId, addressesId,  itemId,  status,  amount);
        return  ordersDao.saveAndFlush(ordersEntity);
    }

@Override
    public Collection<OrdersEntity> showOrder(long orderId){
      return   ordersDao.findByOrderId(orderId);
    }

    @Override
    public long getOrderId(long order){
      return ordersDao.findOne(order).getOrderId();
    }

    public long getCustomerIdFromOrder(long order){
      long id =  Integer.parseInt(ordersDao.findByOrderId(order).toString()) ;
        return id;
    }




}
