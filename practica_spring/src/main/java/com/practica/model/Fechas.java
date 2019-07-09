package com.practica.model;


import javax.persistence.*;

@Entity
public class Fechas{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  private String fechaInicio;
  private String fechaFin;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFechaInicio(){
    return fechaInicio;
  }

  public void setFechaInicio(String fechaInicio){
    this.fechaInicio = fechaInicio;
  }


  public String getFechaFin(){
    return fechaFin;
  }

  public void setFechaFin(String fechaFin){
    this.fechaFin = fechaFin;
  }

  @Override
	public String toString() {
    return "Inicio : " + fechaInicio + " , Fin : " + fechaFin;
  }


}
