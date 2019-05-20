package com.practica.model;

import javax.validation.constraints.Pattern;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
// import java.util.Date;

@Entity
@Table(name = "practicas")
public class Practica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPractica;

	@NotNull
	@Size

<<<<<<< HEAD
	private String fechaPractica;
=======
	
	private String fechaPractica;
	
>>>>>>> cb20ee885d1fd901bdfbade92f47e9dec0dde3e0

	@NotNull
	@Size(max = 20)
	private String nombre_evaluadorPractica;

	@NotNull
	@Size(max = 15)
	private String telefono_evaluadorPractica;

	@NotNull
	@Size(max = 150)
	private String actividades_realizarPractica;

	@NotNull
	@Size(max = 40)
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Solo admite letras y numeros")
	private String domicilio_actualPractica;

	public Long getIdPractica() {
		return idPractica;
	}

	public void setIdPractica(Long idPractica) {
		this.idPractica = idPractica;
	}

	public String getFechaPractica() {
		return fechaPractica;
	}

	public void setFechaPractica(String fechaPractica) {
		this.fechaPractica = fechaPractica;
	}

	public String getNombre_evaluadorPractica() {
		return nombre_evaluadorPractica;
	}

	public void setNombre_evaluadorPractica(String nombre_evaluadorPractica) {
		this.nombre_evaluadorPractica = nombre_evaluadorPractica;
	}

	public String getTelefono_evaluadorPractica() {
		return telefono_evaluadorPractica;
	}

	public void setTelefono_evaluadorPractica(String telefono_evaluadorPractica) {
		this.telefono_evaluadorPractica = telefono_evaluadorPractica;
	}

	public String getActividades_realizarPractica() {
		return actividades_realizarPractica;
	}

	public void setActividades_realizarPractica(String actividades_realizarPractica) {
		this.actividades_realizarPractica = actividades_realizarPractica;
	}

	public String getDomicilio_actualPractica() {
		return domicilio_actualPractica;
	}

	public void setDomicilio_actualPractica(String domicilio_actualPractica) {
		this.domicilio_actualPractica = domicilio_actualPractica;
	}

	public Practica(Long idPractica, @NotNull String fechaPractica,
			@NotNull @Size(max = 20) String nombre_evaluadorPractica,
			@NotNull @Size(max = 15) String telefono_evaluadorPractica,
			@NotNull @Size(max = 150) String actividades_realizarPractica,
			@NotNull @Size(max = 40) @Pattern(regexp = "[A-Za-z0-9]+", message = "Solo admite letras y numeros") String domicilio_actualPractica) {
		this.idPractica = idPractica;
		this.fechaPractica = fechaPractica;
		this.nombre_evaluadorPractica = nombre_evaluadorPractica;
		this.telefono_evaluadorPractica = telefono_evaluadorPractica;
		this.actividades_realizarPractica = actividades_realizarPractica;
		this.domicilio_actualPractica = domicilio_actualPractica;
	}

	public Practica() {
	}
<<<<<<< HEAD
=======



>>>>>>> cb20ee885d1fd901bdfbade92f47e9dec0dde3e0
	/*
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_alumno")
	private Alumno alumno;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@OneToOne(mappedBy = "practica", fetch = FetchType.LAZY)
	private EvaluacionEmpresa evaluacionEmpresa;

	@OneToOne(mappedBy = "practica", fetch = FetchType.LAZY)
	private EvaluacionPractica evaluacionPractica;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_docente")
	private Docente docente;

	@OneToOne(mappedBy = "practica", fetch = FetchType.LAZY)
	private Horario horario;
<<<<<<< HEAD



	*/
=======



	
	
	
	*/

>>>>>>> cb20ee885d1fd901bdfbade92f47e9dec0dde3e0



}
