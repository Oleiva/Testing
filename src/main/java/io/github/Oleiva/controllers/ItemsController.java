package io.github.Oleiva.controllers;


import io.github.Oleiva.dao.ItemsDao;
//import io.github.Oleiva.dto.pojo.ResponseDTO;
import io.github.Oleiva.entity.CustomersEntity;
import io.github.Oleiva.entity.ItemsEntity;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController  {


    @Autowired
    private ItemsDao itemsDao;

    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public List<ItemsEntity> getAll() {
        return itemsDao.findAll();
    }

    @RequestMapping(value="/get-by-id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ItemsEntity getById(@PathVariable long id) {
//    String userId;
        if (id ==0) {
            System.out.print("bad idea");
        }
        return itemsDao.findOne(id);
    }

//    @RequestMapping(value="/get-by-id/{id}")
//    @ResponseBody
//    public List<ItemsEntity> getById(@PathVariable long id) {
//
//        List<ItemsEntity> ListOfItems = null;
//        try {
//            ListOfItems = (List<ItemsEntity>) itemsDao.findOne(id);
//        } catch (Exception ex) {
////            responseDTO.setMessage("Some problem occured! User was not added");
//        }
//
//        return ListOfItems;
//    }


}
