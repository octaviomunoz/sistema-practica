package com.practica.model;


import javax.persistence.*;

@Entity
public class Pares{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private int cantidad;

  public Pares (String nombre){
    this.nombre = nombre;
    this.cantidad = 0;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre(){
    return nombre;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public int getCantidad(){
    return cantidad;
  }

  public void setCantidad(int cantidad){
    this.cantidad = cantidad;
  }

}
