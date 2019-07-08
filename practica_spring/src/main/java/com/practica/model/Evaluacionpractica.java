package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "evaluacionpracticas")
public class Evaluacionpractica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String fecha;

	@NotNull
	private String tabla1_pregunta1;

	@NotNull
	private String tabla1_pregunta2;
	
	@NotNull
	private String tabla1_pregunta3;
	
	@NotNull
	private String tabla1_pregunta4;
	
	@NotNull
	private String tabla1_pregunta5;
	
	@NotNull
	private String tabla1_pregunta6;
	


	@NotNull
	private String tabla1_pregunta7;
	
	@NotNull
	private String tabla1_pregunta8;
	
	@NotNull
	private String tabla1_pregunta9;
	
	@NotNull
	private String tabla1_pregunta10;
	
	
	@NotNull
	private String tabla2_pregunata1;

	@NotNull
	private String tabla2_pregunata2;
/*
	@NotNull
	private int tabla2_pregunata3;
/*
	@NotNull
	private int tabla2_pregunata4;

	@NotNull
	private int tabla2_pregunata5;
*/
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
	public String getFecha() {
		return fecha;
	}

	/**
	* Sets new value of fecha
	* @param
	*/
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getTabla2_pregunata1() {
		return tabla2_pregunata1;
	}

	/**
	* Sets new value of tabla2_pregunata1
	* @param
	*/
	public void setTabla2_pregunata1(String tabla2_pregunata1) {
		this.tabla2_pregunata1 = tabla2_pregunata1;
	}

	/**
	* Returns value of tabla2_pregunata2
	* @return
	*/
	public String getTabla2_pregunata2() {
		return tabla2_pregunata2;
	}

	/**
	* Sets new value of tabla2_pregunata2
	* @param
	*/
	public void setTabla2_pregunata2(String tabla2_pregunata2) {
		this.tabla2_pregunata2 = tabla2_pregunata2;
	}

	/**
	* Returns value of tabla2_pregunata3
	* @return
	*//*
	public int getTabla2_pregunata3() {
		return tabla2_pregunata3;
	}

	/**
	* Sets new value of tabla2_pregunata3
	* @param
	*//*
	public void setTabla2_pregunata3(int tabla2_pregunata3) {
		this.tabla2_pregunata3 = tabla2_pregunata3;
	}

	/**
	* Returns value of tabla2_pregunata4
	* @return
	*//*
	public int getTabla2_pregunata4() {
		return tabla2_pregunata4;
	}

	/**
	* Sets new value of tabla2_pregunata4
	* @param
	*//*
	public void setTabla2_pregunata4(int tabla2_pregunata4) {
		this.tabla2_pregunata4 = tabla2_pregunata4;
	}

	/**
	* Returns value of tabla2_pregunata5
	* @return
	*//*
	public int getTabla2_pregunata5() {
		return tabla2_pregunata5;
	}

	/**
	* Sets new value of tabla2_pregunata5
	* @param
	*//*
	public void setTabla2_pregunata5(int tabla2_pregunata5) {
		this.tabla2_pregunata5 = tabla2_pregunata5;
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
	public String getTabla1_pregunta1() {
		return tabla1_pregunta1;
	}

	public void setTabla1_pregunta1(String tabla1_pregunta1) {
		this.tabla1_pregunta1 = tabla1_pregunta1;
	}

	public String getTabla1_pregunta2() {
		return tabla1_pregunta2;
	}

	public void setTabla1_pregunta2(String tabla1_pregunta2) {
		this.tabla1_pregunta2 = tabla1_pregunta2;
	}

	public String getTabla1_pregunta3() {
		return tabla1_pregunta3;
	}

	public void setTabla1_pregunta3(String tabla1_pregunta3) {
		this.tabla1_pregunta3 = tabla1_pregunta3;
	}

	public String getTabla1_pregunta4() {
		return tabla1_pregunta4;
	}

	public void setTabla1_pregunta4(String tabla1_pregunta4) {
		this.tabla1_pregunta4 = tabla1_pregunta4;
	}

	public String getTabla1_pregunta5() {
		return tabla1_pregunta5;
	}

	public void setTabla1_pregunta5(String tabla1_pregunta5) {
		this.tabla1_pregunta5 = tabla1_pregunta5;
	}

	public String getTabla1_pregunta6() {
		return tabla1_pregunta6;
	}

	public void setTabla1_pregunta6(String tabla1_pregunta6) {
		this.tabla1_pregunta6 = tabla1_pregunta6;
	}

	public String getTabla1_pregunta7() {
		return tabla1_pregunta7;
	}

	public void setTabla1_pregunta7(String tabla1_pregunta7) {
		this.tabla1_pregunta7 = tabla1_pregunta7;
	}

	public String getTabla1_pregunta8() {
		return tabla1_pregunta8;
	}

	public void setTabla1_pregunta8(String tabla1_pregunta8) {
		this.tabla1_pregunta8 = tabla1_pregunta8;
	}

	public String getTabla1_pregunta9() {
		return tabla1_pregunta9;
	}

	public void setTabla1_pregunta9(String tabla1_pregunta9) {
		this.tabla1_pregunta9 = tabla1_pregunta9;
	}

	public String getTabla1_pregunta10() {
		return tabla1_pregunta10;
	}

	public void setTabla1_pregunta10(String tabla1_pregunta10) {
		this.tabla1_pregunta10 = tabla1_pregunta10;
	}

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
