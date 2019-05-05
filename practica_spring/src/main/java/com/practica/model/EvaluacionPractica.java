package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
public class EvaluacionPractica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Date fecha;

	@NotNull
	private int[] tabla1 = new int[10];

	@NotNull
	private int[] tabla2 = new int[5];

	@NotNull
	@Size(min = 1, max = 200)
	private String pregunta1;

	@NotNull
	@Size(min = 1, max = 200)
	private String pregunta2;

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
	* Returns value of fecha
	* @return
	*/
	public Date getFecha() {
		return fecha;
	}

	/**
	* Sets new value of fecha
	* @param
	*/
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	* Returns value of t
	* @return
	*/
	public int[] getTabla1() {
		return tabla1;
	}

	/**
	* Sets new value of t
	* @param
	*/
	public void setTabla1(int[] tabla1) {
		this.tabla1 = tabla1;
	}

	/**
	* Returns value of t
	* @return
	*/
	public int[] getTabla2() {
		return tabla2;
	}

	/**
	* Sets new value of t
	* @param
	*/
	public void setTabla2(int[] tabla2) {
		this.tabla2 = tabla2;
	}

	/**
	* Returns value of pregunta1
	* @return
	*/
	public String getPregunta1() {
		return pregunta1;
	}

	/**
	* Sets new value of pregunta1
	* @param
	*/
	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}

	/**
	* Returns value of pregunta2
	* @return
	*/
	public String getPregunta2() {
		return pregunta2;
	}

	/**
	* Sets new value of pregunta2
	* @param
	*/
	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}

	/**
	* Returns value of practica
	* @return
	*/
	public Practica getPractica() {
		return practica;
	}

	/**
	* Sets new value of practica
	* @param
	*/
	public void setPractica(Practica practica) {
		this.practica = practica;
	}
}
