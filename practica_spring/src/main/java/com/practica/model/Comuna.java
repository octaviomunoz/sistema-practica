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

	public Region get_region(){
		return region;
	}
	public void set_region(Region region){
		this.region = region;
	}

	public List<Empresa> get_empresa(){
		return empresa;
	}
}
