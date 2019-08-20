package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "evaluacionempresas")
public class Evaluacionempresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private float nota;

	private String pregunta1;
	
	private String pregunta2;
	
	private String pregunta3;
			

	@Size(max = 250)
	private String comentario;

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
	* Returns value of nota
	* @return
	*/
	public float getNota() {
		return nota;
	}

	/**
	* Sets new value of nota
	* @param
	*/
	public void setNota(float nota) {
		this.nota = nota;
	}

	/**
	* Returns value of comentario
	* @return
	*/
	public String getComentario() {
		return comentario;
	}

	/**
	* Sets new value of comentario
	* @param
	*/
	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public String getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public String getPregunta2() {
		return pregunta2;
	}

	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}

	public String getPregunta3() {
		return pregunta3;
	}

	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}
	

}