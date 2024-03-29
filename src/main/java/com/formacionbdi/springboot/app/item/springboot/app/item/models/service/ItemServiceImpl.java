package com.formacionbdi.springboot.app.item.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.springboot.app.item.models.Producto;
import com.formacionbdi.springboot.app.item.springboot.app.item.util.ProductNotFoundException;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

  @Autowired
  private RestTemplate clienteRest;

  @Override
  public List<Item> findAll() {
    List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
    return productos.stream().map(p -> new Item(p)).collect(Collectors.toList());
  }

  @Override
  public List<Item> findByTypeProduct(String typeProduct) {
    Map<String, String> pathVariable = new HashMap<String, String>();
    pathVariable.put("typeProduct", typeProduct);
    List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar/{typeProduct}", Producto[].class, pathVariable));
    List<Item> productsList = productos.stream()
    .filter(producto -> producto.getTypeProduct().equalsIgnoreCase(typeProduct))
    .map(p -> new Item(p)).collect(Collectors.toList());
    if (productsList.isEmpty()) {
      throw new ProductNotFoundException("No se encontraron productos para el tipo: " + typeProduct);
    }
    return productsList;
  }

  @Override
  public List<Item> findByRangeOfPrice(Double price) {
    Map<String, String> pathVariable = new HashMap<String, String>();
    pathVariable.put("price", price.toString());
    List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar/precio/{price}", Producto[].class, pathVariable));
    return productos.stream()
    .filter(producto -> producto.getPrice() > price)
    .map(p -> new Item(p)).collect(Collectors.toList());
  }

  @Override
  public List<Item> findByName(String name) {
    Map<String, String> pathVariable = new HashMap<String, String>();
    pathVariable.put("name", name.toString());
    List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar/byName/{name}", Producto[].class, pathVariable));
    return productos.stream()
    .filter(producto -> producto.getNameProduct().toLowerCase().contains(name.toLowerCase()))
    .map(p -> new Item(p)).collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id) {
    Map<String, String> pathVariable = new HashMap<String, String>();
    pathVariable.put("id", id.toString());
    Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariable);
    if (producto == null) {
      throw new ProductNotFoundException("No se encontro el producto con el id: " + id);
    }
    return new Item(producto);
  }


}
