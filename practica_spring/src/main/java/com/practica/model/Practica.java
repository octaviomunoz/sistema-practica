package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "practicas")
public class Practica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Date fecha;

	@NotNull
	@Size(max = 20)
	private String nombre_evaluador;

	@NotNull
	@Size(max = 15)
	private String telefono_evaluador;

	@NotNull
	@Size(max = 150)
	private String actividades_realizar;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_alumno")
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@OneToOne(mappedBy = "practica", fetch = FetchType.LAZY)
	private EvaluacionEmpresa evaluacionEmpresa;

	@OneToOne(mappedBy = "practica", fetch = FetchType.LAZY)
	private EvaluacionPractica evaluacionPractica;





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
	* Returns value of nombre_evaluador
	* @return
	*/
	public String getNombre_evaluador() {
		return nombre_evaluador;
	}

	/**
	* Sets new value of nombre_evaluador
	* @param
	*/
	public void setNombre_evaluador(String nombre_evaluador) {
		this.nombre_evaluador = nombre_evaluador;
	}

	/**
	* Returns value of telefono_evaluador
	* @return
	*/
	public String getTelefono_evaluador() {
		return telefono_evaluador;
	}

	/**
	* Sets new value of telefono_evaluador
	* @param
	*/
	public void setTelefono_evaluador(String telefono_evaluador) {
		this.telefono_evaluador = telefono_evaluador;
	}

	/**
	* Returns value of actividades_realizar
	* @return
	*/
	public String getActividades_realizar() {
		return actividades_realizar;
	}

	/**
	* Sets new value of actividades_realizar
	* @param
	*/
	public void setActividades_realizar(String actividades_realizar) {
		this.actividades_realizar = actividades_realizar;
	}

	/**
	* Returns value of alumno
	* @return
	*/
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	* Sets new value of alumno
	* @param
	*/
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/**
	* Returns value of empresa
	* @return
	*/
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	* Sets new value of empresa
	* @param
	*/
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	* Returns value of evaluacionEmpresa
	* @return
	*/
	public EvaluacionEmpresa getEvaluacionEmpresa() {
		return evaluacionEmpresa;
	}

	/**
	* Sets new value of evaluacionEmpresa
	* @param
	*/
	public void setEvaluacionEmpresa(EvaluacionEmpresa evaluacionEmpresa) {
		this.evaluacionEmpresa = evaluacionEmpresa;
	}

	/**
	* Returns value of evaluacionPractica
	* @return
	*/
	public EvaluacionPractica getEvaluacionPractica() {
		return evaluacionPractica;
	}

	/**
	* Sets new value of evaluacionPractica
	* @param
	*/
	public void setEvaluacionPractica(EvaluacionPractica evaluacionPractica) {
		this.evaluacionPractica = evaluacionPractica;
	}
}
