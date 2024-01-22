package com.formacionbdi.springboot.app.item.springboot.app.item.models;

import java.util.Date;

public class Producto {
  
  private Long id;
  private String typeProduct;
  private String nameProduct;
  private Double price;
  //private Integer port;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getTypeProduct() {
    return typeProduct;
  }
  public void setTypeProduct(String typeProduct) {
    this.typeProduct = typeProduct;
  }
  public String getNameProduct() {
    return nameProduct;
  }
  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  /* public Integer getPort() {
    return port;
  }
  public void setPort(Integer port) {
    this.port = port;
  } */
  
}
