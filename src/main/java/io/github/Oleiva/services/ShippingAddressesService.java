package io.github.Oleiva.services;

import io.github.Oleiva.entity.ShippingAddressesEntity;

/**
 * Created by OleIva on 16.02.2016.
 */
public interface ShippingAddressesService {
    public ShippingAddressesEntity addItems(long CUSTOMERID, int POSTALCODE, String STREET, int HOUSE, int FLAT);
}
