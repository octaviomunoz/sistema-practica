package com.practica.model;

import javax.validation.constraints.Pattern;
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


	private Date fecha;

	@Size(max = 20)
	private String nombre_evaluador;

	@Size(max = 15)
	private String telefono_evaluador;

	@Size(max = 150)
	private String actividades_realizar;


	@Size(max = 40)
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Solo admite letras y numeros")
	private String domicilio_actual;

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
	* Returns value of horario
	* @return
	*/
	public Horario getHorario() {
		return horario;
	}

	/**
	* Sets new value of horario
	* @param
	*/
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
}
