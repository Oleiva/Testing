package io.github.Oleiva.controllers;

import io.github.Oleiva.dto.pojo.ResponsePojo;
import io.github.Oleiva.services.CustomersService;
import io.github.Oleiva.services.ItemsService;
//import io.github.Oleiva.utils.DBInitializer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MainController {

   public final Logger LOG = Logger.getLogger(this.getClass());

  @Autowired
  private ItemsService itemsService;

  @Autowired
  private CustomersService customersService;


//  @Autowired
  private ResponsePojo responsePojo;

  @RequestMapping("/")
  @ResponseBody
  public ResponsePojo index(ResponsePojo responsePojo) {

    responsePojo.setMessage("Proudly handcrafted by " + "<a href='http://oleiva.github.io'>Ivasoft </a> :)");
    return responsePojo;
  }


  @RequestMapping(value = "/initializer", method = RequestMethod.GET)
  @ResponseBody
  public ResponsePojo DBInitializer (
          ResponsePojo responsePojo) {

    try{ /*add Items|--> |String SKU|String NAME| long PRICE| long AMOUN| */
      itemsService.addItems("10001-1290-S", "iron",  50000,30);
      itemsService.addItems("10002-1233-D", "sock",61000,30);
      itemsService.addItems("10031-1233-S", "pot",61000,30);
      itemsService.addItems("10003-1234-D", "pan",61000,30);
      itemsService.addItems("10303-1235-S", "scissors",8000,30);
      itemsService.addItems("10301-1236-M", "phone",600,30);
      itemsService.addItems("10031-1237-S", "pen",63000,30);
      itemsService.addItems("13005-1238-S", "notebook",61030,30);
      itemsService.addItems("10006-1239-S", "laptop",61032,30);
      itemsService.addItems("10404-1210-M", "board",61050,30);
      itemsService.addItems("10051-1220-M", "marker",61500,30);

      responsePojo.setMessage("All items added");

    }catch (Exception ex) {
      responsePojo.setMessage(" Items were not added. Probably, they were added previously ");
      LOG.info("LOG## Items were not added. Probably, they were added previously ");
    }

    try{ /*Customers|-->    |String USERNAME| String EMAIL| long AVAILABLECREDIT|*/

    customersService.addCustomers("Oleg","Oleg.Ivashko@yandex.ua",10000343);
    customersService.addCustomers("Andrey","854885@urk.net",103430);
    customersService.addCustomers("Max","8565j85@urk.net",103343);
    customersService.addCustomers("Sveta","8t458j85@urk.net",10);
    customersService.addCustomers("Yula","858u8445@urk.net",0);
    customersService.addCustomers("Evgen","85g8485@urk.net",10434300);
    customersService.addCustomers("Gana","85t8845f@urk.net",1003430);
    customersService.addCustomers("Dima","858482g325@urk.net",100343);
    customersService.addCustomers("Max","85gj885424@urk.net",1034344343);
    customersService.addCustomers("Oleg","858t485@4urk.net",100343430);
    customersService.addCustomers("Seaperl","852u8825@urk.net",10343400);
    customersService.addCustomers("Marina","858t845@urk.net",1000003430);

      responsePojo.setMessage(responsePojo.getMessage()+" All customers added. ");

    }catch (Exception ex) {
      responsePojo.setMessage(responsePojo.getMessage()+" Customers were not added. Probably, they were added previously");
      LOG.warn("LOG## Customers were not added. Probably, they were added previously ");
    }











    return responsePojo;

  }



}
