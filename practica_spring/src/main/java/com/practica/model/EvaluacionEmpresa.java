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

	//setters getters

	public Long get_id(){
		return id;
	}
	public void set_id(Long id){
		this.id = id;
	}

	public int get_nota(){
		return nota;
	}
	public void set_nota(int nota){
		this.nota = nota;
	}

	public String get_comentario(){
		return comentario;
	}
	public void set_comentario(String comentario){
		this.comentario = comentario;
	}

	public Practica get_practica(){
		return practica;
	}
	public void set_practica(Practica practica){
		this.practica = practica;
	}

}
