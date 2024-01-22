package com.formacionbdi.springboot.app.item.springboot.app.item.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
  
  @GetMapping("/listar")
  public List<Producto> listar();

  @GetMapping("/listar/{typeProduct}")
  public List<Producto> listarTypeProduct(@PathVariable String typeProduct);

  @GetMapping("/listar/price/{price}")
  public List<Producto> listarPriceOfRange(@PathVariable Double price);

  @GetMapping("/listar/byName/{name}")
  public List<Producto> listarByName(@PathVariable String name);

  @GetMapping("/ver/{id}")
  public Producto detalle(@PathVariable Long id);
}
