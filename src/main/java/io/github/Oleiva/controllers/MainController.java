package io.github.Oleiva.controllers;

import io.github.Oleiva.dto.pojo.ResponsePojo;
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

//  @Autowired
  private ResponsePojo responsePojo;

  @RequestMapping("/")
  @ResponseBody
  public ResponsePojo index(ResponsePojo responsePojo) {

    responsePojo.setMessage("Proudly handcrafted by \" + \"<a href='http://oleiva.github.io'>Ivasoft </a> :)\"");
    return responsePojo;
  }


  @RequestMapping(value = "/initializer", method = RequestMethod.GET)
  @ResponseBody
  public ResponsePojo DBInitializer (
          ResponsePojo responsePojo) {

    try{ /*add Items|--> |String SKU|String NAME| long PRICE| long AMOUN| */
      itemsService.addItems("10001-1290-S", "Oleg",  50000,30);
      itemsService.addItems("10002-1233-D", "Andrey",61000,30);
      itemsService.addItems("10031-1233-S", "Max",61000,30);
      itemsService.addItems("10003-1234-D", "Bill",61000,30);
      itemsService.addItems("10303-1235-S", "Mask",8000,30);
      itemsService.addItems("10301-1236-M", "Alf",600,30);
      itemsService.addItems("10031-1237-S", "Evgen",63000,30);
      itemsService.addItems("13005-1238-S", "Allon",61030,30);
      itemsService.addItems("10006-1239-S", "Dima",61032,30);
      itemsService.addItems("10404-1210-M", "Sveta",61050,30);
      itemsService.addItems("10051-1220-M", "Sveta",61500,30);

      responsePojo.setMessage("All items added");

    }catch (Exception ex) {
      responsePojo.setMessage(" Items were not added. Probably, they were added previously ");
      LOG.info("LOG## Items were not added. Probably, they were added previously ");
    }

    try{ //Customers
      //(String SKU, String NAME, long PRICE, long AMOUN);
      itemsService.addItems("10001-1290-S", "Oleg",  50000,30);
      itemsService.addItems("10002-1233-D", "Andrey",61000,30);

      responsePojo.setMessage(responsePojo.getMessage()+" All customers added. ");

    }catch (Exception ex) {
      responsePojo.setMessage(responsePojo.getMessage()+" All customers added ");
      LOG.info("LOG## Customers were not added. Probably, they were added previously ");
    }











    return responsePojo;

  }



}
