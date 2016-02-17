package io.github.Oleiva.controllers;

import io.github.Oleiva.dao.ItemsDao;
import io.github.Oleiva.dao.OrdersDao;
import io.github.Oleiva.entity.ItemsEntity;
import io.github.Oleiva.entity.OrdersEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrdersController {
    public final Logger LOG = Logger.getLogger(this.getClass());


    @Autowired
    private OrdersDao ordersDao;


    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public List<OrdersEntity> getAll() {
//        return itemsDao.findAll();
        return ordersDao.findAll();
    }

    @RequestMapping(value="/get-by-id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public OrdersEntity getById(@PathVariable long id) {

        if (ordersDao.findOne(id) == null) {
            LOG.warn("Number of orders does not exist");
        }
//        return itemsDao.findOne(id);
        return ordersDao.findOne(id);
    }

}
