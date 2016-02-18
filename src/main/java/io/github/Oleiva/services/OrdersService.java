package io.github.Oleiva.services;

import io.github.Oleiva.entity.OrdersEntity;

/**
 * Created by OleIva on 17.02.2016.
 */
public interface OrdersService {
//    public OrdersEntity addOrder(long CUSTOMERID, long ADDRESSESID, String SKU, String STATUS, long AMOUNT);
//    OrdersEntity addOrder(long customerId, long addressesId, long itemId, String status, long amount);
//public OrdersEntity addNewOrder(long orderid, long customerId, long addressesId, long itemId, String status, long amount);
public OrdersEntity addNewOrder(long customerId, long addressesId, long itemId, String status, long amount);

}
