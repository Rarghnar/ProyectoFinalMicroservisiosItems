package com.formacionbdi.springboot.app.item.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {
  
  @Autowired
  /* @Qualifier("serviceFeign") */
  @Qualifier("serviceRestTemplate")
  private ItemService itemService;

  @GetMapping("/listar")
  public List<Item> listar() {
    return itemService.findAll();
  }

  @GetMapping("/listar/{typeProduct}")
  public List<Item> listarTypeProduct(@PathVariable String typeProduct) {
    return itemService.findByTypeProduct(typeProduct);
  }

  @GetMapping("/listar/precio/{price}")
  public List<Item> listarRangeOfPrice(@PathVariable Double price) {
    return itemService.findByRangeOfPrice(price);
  }

  @GetMapping("/listar/byName/{name}")
  public List<Item> listarByName(@PathVariable String name) {
    return itemService.findByName(name);
  }

  @GetMapping("/ver/{id}")
  public Item detalle(@PathVariable Long id) {
    return itemService.findById(id);
  }
}
