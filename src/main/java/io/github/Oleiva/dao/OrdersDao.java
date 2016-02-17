package io.github.Oleiva.dao;

import io.github.Oleiva.entity.CustomersEntity;
import io.github.Oleiva.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OleIva on 17.02.2016.
 */
public interface OrdersDao  extends JpaRepository<OrdersEntity, Long> {

}
