package io.github.Oleiva.services;

import io.github.Oleiva.dao.ItemsDao;
import io.github.Oleiva.entity.ItemsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    @Override
    public ItemsEntity addItems(String SKU, String NAME, long PRICE, long AMOUN){
        ItemsEntity itemsEntity = new ItemsEntity(SKU,  NAME, PRICE, AMOUN);

        return itemsDao.saveAndFlush(itemsEntity);
    }


}
