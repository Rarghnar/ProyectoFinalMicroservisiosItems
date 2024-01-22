package com.formacionbdi.springboot.app.item.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.springboot.app.item.cliente.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.springboot.app.item.models.Item;

/* @Primary */
@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {

  @Autowired
  private ProductoClienteRest clienteFeign;

  @Override
  public List<Item> findAll() {
    return clienteFeign.listar().stream().map(p -> new Item(p)).collect(Collectors.toList());
  }

  @Override
  public List<Item> findByTypeProduct(String typeProduct) {
    return clienteFeign.listarTypeProduct(typeProduct).stream().map(p -> new Item(p)).collect(Collectors.toList());
  }

  @Override
  public List<Item> findByRangeOfPrice(Double price) {
    return clienteFeign.listarPriceOfRange(price).stream().map(p -> new Item(p)).collect(Collectors.toList());
  }

  @Override
  public List<Item> findByName(String name) {
    return clienteFeign.listarByName(name).stream().map(p -> new Item(p)).collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id) {
    return new Item(clienteFeign.detalle(id));
  }
  
}
