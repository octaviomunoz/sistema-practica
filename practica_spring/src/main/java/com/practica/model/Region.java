package com.practica.model;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "regiones")
public class Region {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(max = 15)
  private String nombre;

  @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
  private List<Comuna> comuna = new ArrayList<>();

  //setters, getters

  public Long get_id(){
    return id;
  }
  public void set_id(Long id){
    this.id = id;
  }

  public String get_nombre(){
    return nombre;
  }
  public void set_nombre(String nombre){
    this.nombre = nombre;
  }

  public List<Comuna> get_comuna(){
    return comuna;
  }
}
