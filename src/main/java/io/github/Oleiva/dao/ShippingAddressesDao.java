package io.github.Oleiva.dao;

import io.github.Oleiva.entity.CustomersEntity;
import io.github.Oleiva.entity.ShippingAddressesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OleIva on 16.02.2016.
 */
public interface ShippingAddressesDao extends JpaRepository<ShippingAddressesEntity, Long> {


}
