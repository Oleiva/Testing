package io.github.Oleiva.services;

import io.github.Oleiva.dao.ItemsDao;
import io.github.Oleiva.dao.ShippingAddressesDao;
import io.github.Oleiva.entity.ItemsEntity;
import io.github.Oleiva.entity.ShippingAddressesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OleIva on 16.02.2016.
 */

@Service
@Transactional
public class ShippingAddressesServiceImpl implements ShippingAddressesService{

    @Autowired
//    private ItemsDao itemsDao;
    private ShippingAddressesDao shippingAddressesDao;

    @Override
    public ShippingAddressesEntity addItems(long CUSTOMERID, int POSTALCODE, String STREET, int HOUSE, int FLAT){
        ShippingAddressesEntity shippingAddressesEntity = new ShippingAddressesEntity( CUSTOMERID,POSTALCODE,  STREET, HOUSE, FLAT);

//        return itemsDao.saveAndFlush(itemsEntity);
        return shippingAddressesDao.saveAndFlush(shippingAddressesEntity);
    }

}
