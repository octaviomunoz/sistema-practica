package com.practica.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comunas")
public class Comuna {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(max = 15)
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private Region region;

	@OneToMany(mappedBy = "comuna", cascade = CascadeType.ALL)
	private List<Empresa> empresa = new ArrayList<>();




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
	* Returns value of region
	* @return
	*/
	public Region getRegion() {
		return region;
	}

	/**
	* Sets new value of region
	* @param
	*/
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	* Returns value of empresa
	* @return
	*/
	public List<Empresa> getEmpresa() {
		return empresa;
	}

	/**
	* Sets new value of empresa
	* @param
	*/
	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}
}
