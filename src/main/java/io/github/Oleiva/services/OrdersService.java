package io.github.Oleiva.services;

import io.github.Oleiva.entity.OrdersEntity;
import io.github.Oleiva.entity.TransactionsEntity;

import java.util.Collection;
import java.util.List;


public interface OrdersService {

    void addNewOrder(long customerId, long addressesId, long itemId, long amount);
    List<TransactionsEntity> getItemsByOrderId(long order);

//    OrdersEntity addNewsOrder(long customerId, long addressesId, long itemId, String status, long amount);

//    Collection<OrdersEntity> showOrder(long orderId);
//public OrdersEntity addItemToOrder(long order, long itemId, long amount);
//    long getOrderId(long order);

}
