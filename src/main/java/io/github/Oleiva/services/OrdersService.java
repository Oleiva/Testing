package io.github.Oleiva.services;

import io.github.Oleiva.entity.OrdersEntity;

import java.util.Collection;


public interface OrdersService {

    OrdersEntity addNewOrder(long customerId, long addressesId, long itemId, String status, long amount);

    OrdersEntity addNewsOrder(long customerId, long addressesId, long itemId, String status, long amount);

    Collection<OrdersEntity> showOrder(long orderId);

    long getOrderId(long order);

}
