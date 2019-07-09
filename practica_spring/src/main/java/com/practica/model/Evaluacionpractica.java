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

	private String tabla1_pregunta1;

	private String tabla1_pregunta2;

	private String tabla1_pregunta3;

	private String tabla1_pregunta4;

	private String tabla1_pregunta5;

	private String tabla1_pregunta6;

	private String tabla1_pregunta7;

	private String tabla1_pregunta8;

	private String tabla1_pregunta9;

	private String tabla1_pregunta10;

	private String tabla2_pregunta1;
	
	private String tabla2_pregunta2;
	
	private String tabla2_pregunta3;
	
	private String tabla2_pregunta4;
	
	private String tabla2_pregunta5;


	@Size(min = 1, max = 200)
	private String pregunta1;

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
	
	public String getTabla2_pregunta1() {
		return tabla2_pregunta1;
	}

	public void setTabla2_pregunta1(String tabla2_pregunta1) {
		this.tabla2_pregunta1 = tabla2_pregunta1;
	}

	public String getTabla2_pregunta2() {
		return tabla2_pregunta2;
	}

	public void setTabla2_pregunta2(String tabla2_pregunta2) {
		this.tabla2_pregunta2 = tabla2_pregunta2;
	}

	public String getTabla2_pregunta3() {
		return tabla2_pregunta3;
	}

	public void setTabla2_pregunta3(String tabla2_pregunta3) {
		this.tabla2_pregunta3 = tabla2_pregunta3;
	}

	public String getTabla2_pregunta4() {
		return tabla2_pregunta4;
	}

	public void setTabla2_pregunta4(String tabla2_pregunta4) {
		this.tabla2_pregunta4 = tabla2_pregunta4;
	}

	public String getTabla2_pregunta5() {
		return tabla2_pregunta5;
	}

	public void setTabla2_pregunta5(String tabla2_pregunta5) {
		this.tabla2_pregunta5 = tabla2_pregunta5;
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
