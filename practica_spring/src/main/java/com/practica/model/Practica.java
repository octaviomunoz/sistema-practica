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
	private String fechaPractica;

	@NotNull
	@Size(max = 150)
	private String actividades_realizarPractica;


	private Boolean activo = false;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_alumno")
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_evaluador")
	private Evaluador evaluador;

	@OneToOne(mappedBy = "practica", fetch = FetchType.LAZY)
	private Evaluacionempresa evaluacionEmpresa;

	@OneToOne(mappedBy = "practica", fetch = FetchType.LAZY)
	private Evaluacionpractica evaluacionPractica;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_docente")
	private Docente docente;

	@OneToOne(mappedBy = "practica", fetch = FetchType.LAZY)
	private Horario horario;


	public Boolean getActivo(){
		return activo;
	}

	public void setActivo(Boolean activo){
		this.activo = activo;
	}

	public Alumno getAlumno(){
		return alumno;
	}

	public void setAlumno(Alumno alumno){
		this.alumno = alumno;
	}

	public Empresa getEmpresa(){
		return empresa;
	}
	public void setEmpresa(Empresa empresa){
		this.empresa = empresa;
	}
	public Evaluador getEvaluador(){
		return evaluador;
	}
	public void setEvaluador(Evaluador evaluador){
		this.evaluador = evaluador;
	}
	public Evaluacionempresa getEvaluacionEmpresa(){
		return evaluacionEmpresa;
	}
	public void setEvaluacionEmpresa(Evaluacionempresa evaluacionEmpresa){
		this.evaluacionEmpresa = evaluacionEmpresa;
	}
	public Evaluacionpractica getEvaluacionpractica(){
		return evaluacionPractica;
	}
	public void setEvaluacionpractica(Evaluacionpractica evaluacionpractica){
		this.evaluacionPractica = evaluacionpractica;
	}
	public Docente getDocente(){
		return docente;
	}
	public void setDocente(Docente docente){
		this.docente = docente;
	}
	public Horario getHorario(){
		return horario;
	}
	public void setHorario(Horario horario){
		this.horario = horario;
	}


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



	public String getActividades_realizarPractica() {
		return actividades_realizarPractica;
	}

	public void setActividades_realizarPractica(String actividades_realizarPractica) {
		this.actividades_realizarPractica = actividades_realizarPractica;
	}


	public Practica(Long idPractica, @NotNull String fechaPractica,
			@NotNull @Size(max = 20) String nombre_evaluadorPractica,
			@NotNull @Size(max = 15) String telefono_evaluadorPractica,
			@NotNull @Size(max = 150) String actividades_realizarPractica,
			@NotNull @Size(max = 40) @Pattern(regexp = "[A-Za-z0-9]+", message = "Solo admite letras y numeros") String domicilio_actualPractica) {
		this.idPractica = idPractica;
		this.fechaPractica = fechaPractica;
		this.actividades_realizarPractica = actividades_realizarPractica;
	}

	public Practica() {
	}


}
