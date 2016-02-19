package io.github.Oleiva.dao;

import io.github.Oleiva.entity.CustomersEntity;
import io.github.Oleiva.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;


/**
 * Created by OleIva on 17.02.2016.
 */
public interface OrdersDao  extends JpaRepository<OrdersEntity, Long> {


//    http://stackoverflow.com/questions/23456197/spring-data-jpa-repository-underscore-on-entity-column-name/23475349#23475349
    Collection<OrdersEntity> findByOrderId(long order);


//    List<OrdersEntity> findByORDER_ID(long ORDER_ID);
//
//    @Query(value = findByORDER, nativeQuery = true)  long  findByOrderId(long orderId);
//    String findByORDER = "SELECT * FROM orders where ORDER_ID =";

//    List <OrdersEntity> findByOrderId (long ORDER_ID);
//    List <OrdersEntity> findByAmount (long amount);



    @Query(value = findLastIndex, nativeQuery = true)  long  findLastIndex();
    String findLastIndex = "SELECT max(id) FROM orders";
//    String findLastIndex = "SELECT max(order_id) FROM orders";

}
