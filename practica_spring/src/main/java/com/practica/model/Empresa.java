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

	public Empresa(){
		convenio = false;
	}

	//setters getters

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

	public String get_direccion(){
		return direccion;
	}
	public void set_direccion(String direccion){
		this.direccion = direccion;
	}

	public boolean get_convenio(){
		return convenio;
	}
	public void set_convenio(boolean convenio){
		this.convenio = convenio;
	}

	public Comuna get_comuna(){
		return comuna;
	}
	public void set_comuna(Comuna comuna){
		this.comuna = comuna;
	}

	public List<Practica> get_practica(){
		return practica;
	}



}
