package com.formacionbdi.springboot.app.item.springboot.app.item.models;

public class Item {

  private Producto producto;

  public Item() {
  }

  public Item(Producto producto) {
    this.producto = producto;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

}
