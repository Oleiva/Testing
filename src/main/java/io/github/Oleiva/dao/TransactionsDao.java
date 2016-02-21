package io.github.Oleiva.dao;

import io.github.Oleiva.entity.ShippingAddressesEntity;
import io.github.Oleiva.entity.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by OleIva on 20.02.2016.
 */
public interface TransactionsDao  extends JpaRepository<TransactionsEntity, Long> {

    List<TransactionsEntity> findByOrderId (long order);
//    List<TransactionsEntity> getItemsByOrderId(long order);
//    List <OrdersEntity> findByAmount (long amount);
}
