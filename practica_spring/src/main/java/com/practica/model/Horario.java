package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Horario{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private Date fecha_presentacion;

  @NotNull
  private int modulo;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_practica")
  private Practica practica;



	/**
	* Returns value of id
	* @return
	*/
	public Long getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(Long id) {
		this.id = id;
	}

	/**
	* Returns value of fecha_presentacion
	* @return
	*/
	public Date getFecha_presentacion() {
		return fecha_presentacion;
	}

	/**
	* Sets new value of fecha_presentacion
	* @param
	*/
	public void setFecha_presentacion(Date fecha_presentacion) {
		this.fecha_presentacion = fecha_presentacion;
	}

	/**
	* Returns value of modulo
	* @return
	*/
	public int getModulo() {
		return modulo;
	}

	/**
	* Sets new value of modulo
	* @param
	*/
	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	/**
	* Returns value of alumno
	* @return
	*/
	public Practica getPractica() {
		return practica;
	}

	/**
	* Sets new value of alumno
	* @param
	*/
	public void setPractica(Practica practica) {
		this.practica = practica;
	}
}
