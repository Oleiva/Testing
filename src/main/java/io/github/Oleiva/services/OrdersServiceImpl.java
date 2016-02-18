package io.github.Oleiva.services;

import io.github.Oleiva.dao.OrdersDao;
import io.github.Oleiva.dao.ShippingAddressesDao;
import io.github.Oleiva.entity.OrdersEntity;
import io.github.Oleiva.entity.ShippingAddressesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OleIva on 17.02.2016.
 */

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

   @Autowired
//    private ItemsDao itemsDao;
    private OrdersDao ordersDao;

    @Override
//    public ShippingAddressesEntity addItems(long CUSTOMERID, int POSTALCODE, String STREET, int HOUSE, int FLAT){
//        ShippingAddressesEntity shippingAddressesEntity = new ShippingAddressesEntity( CUSTOMERID,POSTALCODE,  STREET, HOUSE, FLAT);
//
////        return itemsDao.saveAndFlush(itemsEntity);
//        return shippingAddressesDao.saveAndFlush(shippingAddressesEntity);
//

      public OrdersEntity addOrder(long CUSTOMERID, long ADDRESSESID, String SKU, String STATUS, long AMOUNT){

        OrdersEntity ordersEntity = new OrdersEntity(CUSTOMERID, ADDRESSESID,  SKU,  STATUS,  AMOUNT);
        return  ordersDao.saveAndFlush(ordersEntity);
    }

}