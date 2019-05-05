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

	

	/**
	* Create string representation of Alumno for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", run=" + run + ", password=" + password + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", domicilio_procedencia=" + domicilio_procedencia + ", domicilio_actual=" + domicilio_actual + ", telefono=" + telefono + ", docente=" + docente + ", practica=" + practica + "]";
	}

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
	* Returns value of password
	* @return
	*/
	public String getPassword() {
		return password;
	}

	/**
	* Sets new value of password
	* @param
	*/
	public void setPassword(String password) {
		this.password = password;
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
	* Returns value of apellido_paterno
	* @return
	*/
	public String getApellido_paterno() {
		return apellido_paterno;
	}

	/**
	* Sets new value of apellido_paterno
	* @param
	*/
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	/**
	* Returns value of apellido_materno
	* @return
	*/
	public String getApellido_materno() {
		return apellido_materno;
	}

	/**
	* Sets new value of apellido_materno
	* @param
	*/
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	/**
	* Returns value of domicilio_procedencia
	* @return
	*/
	public String getDomicilio_procedencia() {
		return domicilio_procedencia;
	}

	/**
	* Sets new value of domicilio_procedencia
	* @param
	*/
	public void setDomicilio_procedencia(String domicilio_procedencia) {
		this.domicilio_procedencia = domicilio_procedencia;
	}

	/**
	* Returns value of domicilio_actual
	* @return
	*/
	public String getDomicilio_actual() {
		return domicilio_actual;
	}

	/**
	* Sets new value of domicilio_actual
	* @param
	*/
	public void setDomicilio_actual(String domicilio_actual) {
		this.domicilio_actual = domicilio_actual;
	}

	/**
	* Returns value of telefono
	* @return
	*/
	public String getTelefono() {
		return telefono;
	}

	/**
	* Sets new value of telefono
	* @param
	*/
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	* Returns value of docente
	* @return
	*/
	public Docente getDocente() {
		return docente;
	}

	/**
	* Sets new value of docente
	* @param
	*/
	public void setDocente(Docente docente) {
		this.docente = docente;
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
