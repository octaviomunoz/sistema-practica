package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class EvaluacionEmpresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private int nota;

	@NotNull
	@Size(max = 150)
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
	public int getNota() {
		return nota;
	}

	/**
	* Sets new value of nota
	* @param
	*/
	public void setNota(int nota) {
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
}
// no se que onda xD 