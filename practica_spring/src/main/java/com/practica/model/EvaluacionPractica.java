package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "evaluacionpracticas")
public class EvaluacionPractica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Date fecha;

	@NotNull
	private int tabla1_pregunata1;

	@NotNull
	private int tabla1_pregunata2;
/*
	@NotNull
	private int tabla1_pregunata3;

	@NotNull
	private int tabla1_pregunata4;

	@NotNull
	private int tabla1_pregunata5;

	@NotNull
	private int tabla1_pregunata6;

	@NotNull
	private int tabla1_pregunata7;

	@NotNull
	private int tabla1_pregunata8;

	@NotNull
	private int tabla1_pregunata9;

	@NotNull
	private int tabla1_pregunata0;
*/
	@NotNull
	private int tabla2_pregunata1;

	@NotNull
	private int tabla2_pregunata2;
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
/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_practica")
	private Practica practica;
*/





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
	* Returns value of tabla1_pregunata1
	* @return
	*/
	public int getTabla1_pregunata1() {
		return tabla1_pregunata1;
	}

	/**
	* Sets new value of tabla1_pregunata1
	* @param
	*/
	public void setTabla1_pregunata1(int tabla1_pregunata1) {
		this.tabla1_pregunata1 = tabla1_pregunata1;
	}

	/**
	* Returns value of tabla1_pregunata2
	* @return
	*/
	public int getTabla1_pregunata2() {
		return tabla1_pregunata2;
	}

	/**
	* Sets new value of tabla1_pregunata2
	* @param
	*/
	public void setTabla1_pregunata2(int tabla1_pregunata2) {
		this.tabla1_pregunata2 = tabla1_pregunata2;
	}

	/**
	* Returns value of tabla1_pregunata3
	* @return
	*//*
	public int getTabla1_pregunata3() {
		return tabla1_pregunata3;
	}

	/**
	* Sets new value of tabla1_pregunata3
	* @param
	*//*
	public void setTabla1_pregunata3(int tabla1_pregunata3) {
		this.tabla1_pregunata3 = tabla1_pregunata3;
	}

	/**
	* Returns value of tabla1_pregunata4
	* @return
	*//*
	public int getTabla1_pregunata4() {
		return tabla1_pregunata4;
	}

	/**
	* Sets new value of tabla1_pregunata4
	* @param
	*//*
	public void setTabla1_pregunata4(int tabla1_pregunata4) {
		this.tabla1_pregunata4 = tabla1_pregunata4;
	}

	/**
	* Returns value of tabla1_pregunata5
	* @return
	*//*
	public int getTabla1_pregunata5() {
		return tabla1_pregunata5;
	}

	/**
	* Sets new value of tabla1_pregunata5
	* @param
	*//*
	public void setTabla1_pregunata5(int tabla1_pregunata5) {
		this.tabla1_pregunata5 = tabla1_pregunata5;
	}

	/**
	* Returns value of tabla1_pregunata6
	* @return
	*//*
	public int getTabla1_pregunata6() {
		return tabla1_pregunata6;
	}

	/**
	* Sets new value of tabla1_pregunata6
	* @param
	*//*
	public void setTabla1_pregunata6(int tabla1_pregunata6) {
		this.tabla1_pregunata6 = tabla1_pregunata6;
	}

	/**
	* Returns value of tabla1_pregunata7
	* @return
	*//*
	public int getTabla1_pregunata7() {
		return tabla1_pregunata7;
	}

	/**
	* Sets new value of tabla1_pregunata7
	* @param
	*//*
	public void setTabla1_pregunata7(int tabla1_pregunata7) {
		this.tabla1_pregunata7 = tabla1_pregunata7;
	}

	/**
	* Returns value of tabla1_pregunata8
	* @return
	*//*
	public int getTabla1_pregunata8() {
		return tabla1_pregunata8;
	}

	/**
	* Sets new value of tabla1_pregunata8
	* @param
	*//*
	public void setTabla1_pregunata8(int tabla1_pregunata8) {
		this.tabla1_pregunata8 = tabla1_pregunata8;
	}

	/**
	* Returns value of tabla1_pregunata9
	* @return
	*//*
	public int getTabla1_pregunata9() {
		return tabla1_pregunata9;
	}

	/**
	* Sets new value of tabla1_pregunata9
	* @param
	*//*
	public void setTabla1_pregunata9(int tabla1_pregunata9) {
		this.tabla1_pregunata9 = tabla1_pregunata9;
	}

	/**
	* Returns value of tabla1_pregunata0
	* @return
	*//*
	public int getTabla1_pregunata0() {
		return tabla1_pregunata0;
	}

	/**
	* Sets new value of tabla1_pregunata0
	* @param
	*//*
	public void setTabla1_pregunata0(int tabla1_pregunata0) {
		this.tabla1_pregunata0 = tabla1_pregunata0;
	}

	/**
	* Returns value of tabla2_pregunata1
	* @return
	*/
	public int getTabla2_pregunata1() {
		return tabla2_pregunata1;
	}

	/**
	* Sets new value of tabla2_pregunata1
	* @param
	*/
	public void setTabla2_pregunata1(int tabla2_pregunata1) {
		this.tabla2_pregunata1 = tabla2_pregunata1;
	}

	/**
	* Returns value of tabla2_pregunata2
	* @return
	*/
	public int getTabla2_pregunata2() {
		return tabla2_pregunata2;
	}

	/**
	* Sets new value of tabla2_pregunata2
	* @param
	*/
	public void setTabla2_pregunata2(int tabla2_pregunata2) {
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
	/*
	public Practica getPractica() {
		return practica;
	}

	/**
	* Sets new value of practica
	* @param
	*/
	/*
	public void setPractica(Practica practica) {
		this.practica = practica;
	}*/
}
