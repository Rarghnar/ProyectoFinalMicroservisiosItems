package com.formacionbdi.springboot.app.item.springboot.app.item.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.item.springboot.app.item.models.Item;

public interface ItemService {
  
  public List<Item> findAll();
  public List<Item> findByTypeProduct(String typeProduct);
  public List<Item> findByRangeOfPrice(Double price);
  public List<Item> findByName(String name);
  public Item findById(Long id);
}
