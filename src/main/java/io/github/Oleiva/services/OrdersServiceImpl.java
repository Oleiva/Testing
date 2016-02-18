package io.github.Oleiva.services;

import io.github.Oleiva.dao.OrdersDao;
import io.github.Oleiva.dao.ShippingAddressesDao;
import io.github.Oleiva.entity.OrdersEntity;
import io.github.Oleiva.entity.ShippingAddressesEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OleIva on 17.02.2016.
 */

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    public final Logger LOG = Logger.getLogger(this.getClass());

   @Autowired
//    private ItemsDao itemsDao;
    private OrdersDao ordersDao;
//@Autowired
    private OrdersEntity ordersEntity;

//    @Override
//    public ShippingAddressesEntity addItems(long CUSTOMERID, int POSTALCODE, String STREET, int HOUSE, int FLAT){
//        ShippingAddressesEntity shippingAddressesEntity = new ShippingAddressesEntity( CUSTOMERID,POSTALCODE,  STREET, HOUSE, FLAT);
//
////        return itemsDao.saveAndFlush(itemsEntity);
//        return shippingAddressesDao.saveAndFlush(shippingAddressesEntity);
//

//      public OrdersEntity addOrder(long customerId, long addressesId, long itemId, String status, long amount){
//
//        OrdersEntity ordersEntity = new OrdersEntity(customerId, addressesId,  itemId,  status,  amount);
////        OrdersEntity ordersEntity = new OrdersEntity(customerId, addressesId, itemId,  status,  amount);
//        return  ordersDao.saveAndFlush(ordersEntity);
//    }

    @Override
    public OrdersEntity addNewOrder(long customerId, long addressesId, long itemId, String status, long amount){

        long indexOfID;

        try {
            indexOfID = ordersDao.findOne(ordersDao.findLastIndex()).getORDER_ID() +1;
        }catch (Exception e){
        }

        LOG.info("## indexOfID"+indexOfID);
        OrdersEntity ordersEntity = new OrdersEntity(indexOfID, customerId, addressesId,  itemId,  status,  amount);
        return  ordersDao.saveAndFlush(ordersEntity);
    }

}
