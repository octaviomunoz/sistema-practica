package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

	@NotNull
	@Size(max = 15)
	@Column(unique = true)
	private String run;

	@NotNull
	@Size(min = 5, max = 15)
	private String password;

	@NotNull
	@Size(max = 30)
	private String nombre;

	@NotNull
	@Size(max = 15)
	private String apellido_paterno;

	@NotNull
	@Size(max = 15)
	private String apellido_materno;

	@NotNull
	@Size(max = 40)
	private String domicilio_procedencia;

	@NotNull
	@Size(max = 40)
	private String domicilio_actual;

	@NotNull
	@Size(max = 15)
	private String telefono;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_docente")
	private Docente docente;

	@OneToOne(mappedBy = "alumno", fetch = FetchType.LAZY)
	private Practica practica;

	//setters getters

	public Long get_id(){
		return id;
	}
	public void set_id(Long id){
		this.id = id;
	}

	public String get_run(){
		return run;
	}
	public void set_run(String run){
		this.run = run;
	}

	public String get_password(){
		return password;
	}
	public void set_password(String password){
		this.password = password;
	}

	public String get_nombre(){
		return nombre;
	}
	public void set_nombre(String nombre){
		this.nombre = nombre;
	}

	public String get_apellidoPaterno(){
		return apellido_paterno;
	}
	public void set_apellidoPaterno(String apellido_paterno){
		this.apellido_paterno = apellido_paterno;
	}

	public String get_apellidoMaterno(){
		return apellido_materno;
	}
	public void set_apellidoMaterno(String apellido_materno){
		this.apellido_materno = apellido_materno;
	}

	public String get_domicilioProcedencia(){
		return domicilio_procedencia;
	}
	public void set_domicilioProcedencia(String domicilio_procedencia){
		this.domicilio_procedencia = domicilio_procedencia;
	}

	public String get_domicilioActual(){
		return domicilio_actual;
	}
	public void set_domicilioActual(String domicilio_actual){
		this.domicilio_actual = domicilio_actual;
	}

	public String get_telefono(){
		return telefono;
	}
	public void set_telefono(String telefono){
		this.telefono = telefono;
	}

	public Docente get_docente(){
		return docente;
	}
	public void set_decente(Docente docente){
		this.docente = docente;
	}

	public Practica get_practica(){
		return practica;
	}
	public void set_practica(Practica practica){
		this.practica = practica;
	}

}
