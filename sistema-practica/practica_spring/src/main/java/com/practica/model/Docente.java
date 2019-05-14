package com.practica.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "docentes")
public class Docente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(max = 15)
  @Column(unique = true)
  private String run;

  @NotNull
  @Size(max = 20)
  private String nombre;

  @NotNull
  @Size
  private boolean director;

  @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
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
	* Returns value of run
	* @return
	*/
	public String getRun() {
		return run;
	}

	/**
	* Sets new value of run
	* @param
	*/
	public void setRun(String run) {
		this.run = run;
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
	* Returns value of director
	* @return
	*/
	public boolean isDirector() {
		return director;
	}

	/**
	* Sets new value of director
	* @param
	*/
	public void setDirector(boolean director) {
		this.director = director;
	}

	/**
	* Returns value of alumno
	* @return
	*/
	public List<Practica> getPractica() {
		return practica;
	}

	/**
	* Sets new value of alumno
	* @param
	*/
	public void setPractica(List<Practica> practica) {
		this.practica = practica;
	}
}
