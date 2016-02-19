package io.github.Oleiva.dto.pojo;

import io.github.Oleiva.entity.OrdersEntity;

import java.util.List;

/**
 * Created by OleIva on 19.02.2016.
 */
public class OrderPojo {

    private List<OrdersEntity> orders;

    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }
}
