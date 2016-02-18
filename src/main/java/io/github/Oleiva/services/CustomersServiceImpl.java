package io.github.Oleiva.services;

import io.github.Oleiva.dao.CustomersDao;
import io.github.Oleiva.dao.ItemsDao;
import io.github.Oleiva.entity.CustomersEntity;
import io.github.Oleiva.entity.ItemsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersDao customersDao;

    @Autowired
    private ItemsDao itemsDao;

//    @Override
//    public ItemsEntity addItems(String SKU, String NAME, long PRICE, long AMOUN){
//        ItemsEntity itemsEntity = new ItemsEntity(SKU,  NAME, PRICE, AMOUN);
//
//        return itemsDao.saveAndFlush(itemsEntity);
//    }

    public CustomersEntity addCustomers(String USERNAME, String EMAIL, long AVAILABLECREDIT){
        CustomersEntity customersEntity = new CustomersEntity(USERNAME, EMAIL, AVAILABLECREDIT);

        return customersDao.saveAndFlush(customersEntity);
    }


    public boolean isEnoughMoney (long cust, long item, long amount){
        boolean isEnoughMoney = false;
       if(customersDao.findOne(cust).getAVAILABLE_CREDIT() > itemsDao.findOne(item).getPRICE() *amount ){
         isEnoughMoney = true;
       }
        return isEnoughMoney;
    }


}
