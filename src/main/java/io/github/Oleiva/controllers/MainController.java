package io.github.Oleiva.controllers;

import io.github.Oleiva.services.ItemsService;
import io.github.Oleiva.utils.DBInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

//  @Autowired
  private   DBInitializer dbInitializer;

  @Autowired
  private ItemsService itemsService;

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Proudly handcrafted by " +
        "<a href='http://oleiva.github.io'>Ivasoft </a> :)";
  }


  @RequestMapping("/initializer")
  @ResponseBody
  public void DBInitializer() {

    try{
      itemsService.addItems("dd", "NAME",232323,323);
      itemsService.addItems("dd", "NAME",232323,323);
      itemsService.addItems("dd", "NAME",232323,323);
      itemsService.addItems("dd", "NAME",232323,323);
      itemsService.addItems("dd", "NAME",232323,323);
      itemsService.addItems("dd", "NAME",232323,323);
      itemsService.addItems("dd", "NAME",232323,323);
      itemsService.addItems("dd", "NAME",232323,323);
      itemsService.addItems("dd", "NAME",232323,323);


    }catch (Exception ex) {
    System.out.println("#dederedfedededed");
    }




  }


}
