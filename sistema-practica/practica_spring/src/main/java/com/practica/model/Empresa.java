package com.practica.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(max = 20)
	private String nombre;

	@NotNull
	@Size(max = 40)
	private String direccion;

	@NotNull
	private boolean convenio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comuna")
	private Comuna comuna;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Practica> practica = new ArrayList<>();





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
	* Returns value of direccion
	* @return
	*/
	public String getDireccion() {
		return direccion;
	}

	/**
	* Sets new value of direccion
	* @param
	*/
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	* Returns value of convenio
	* @return
	*/
	public boolean isConvenio() {
		return convenio;
	}

	/**
	* Sets new value of convenio
	* @param
	*/
	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}

	/**
	* Returns value of comuna
	* @return
	*/
	public Comuna getComuna() {
		return comuna;
	}

	/**
	* Sets new value of comuna
	* @param
	*/
	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	/**
	* Returns value of practica
	* @return
	*/
	public List<Practica> getPractica() {
		return practica;
	}

	/**
	* Sets new value of practica
	* @param
	*/
	public void setPractica(List<Practica> practica) {
		this.practica = practica;
	}
}
