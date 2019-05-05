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
	* Returns value of nombre
	* @return
	*/
	public String getNombre() {
		return nombre;
	}

	/**
	* Sets new value of nombre
	* @param
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	* Returns value of comuna
	* @return
	*/
	public List<Comuna> getComuna() {
		return comuna;
	}

	/**
	* Sets new value of comuna
	* @param
	*/
	public void setComuna(List<Comuna> comuna) {
		this.comuna = comuna;
	}
}
