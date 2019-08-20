package com.practica.model;

import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String nombre;

	private String apellido_paterno;


	private String apellido_materno;


	private String domicilio;

	public Alumno(){
		
	}

	public Alumno(String nombre, String apellido_paterno, String apellido_materno){
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
	}

	@NotEmpty(message = "Este Campo no puede estar vacio")
	@Size(max = 15)
	private String telefono;

	private String email;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private User usuario;

	@JsonIgnore
	@OneToOne(mappedBy = "alumno", fetch = FetchType.LAZY)
	private Practica practica;


	/**
	* Create string representation of Alumno for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", domicilio=" + domicilio + ", telefono=" + telefono +"]";
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
	* Returns value of domicilio
	* @return
	*/
	public String getDomicilio() {
		return domicilio;
	}

	/**
	* Sets new value of domicilio
	* @param
	*/
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
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


	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

}
