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

	//setters getters

	public Long get_id(){
		return id;
	}
	public void set_id(Long id){
		this.id = id;
	}

	public Date get_fecha(){
		return fecha;
	}
	public void set_fecha(Date fecha){
		this.fecha = fecha;
	}

	public String get_nombreEvaluador(){
		return nombre_evaluador;
	}
	public void set_nombreEvaluador(String nombre_evaluador){
		this.nombre_evaluador = nombre_evaluador;
	}

	public String get_telefonoEvaluador(){
		return telefono_evaluador;
	}
	public void set_telefonoEvaluador(String telefono_evaluador){
		this.telefono_evaluador = telefono_evaluador;
	}

	public String get_actividades(){
		return actividades_realizar;
	}
	public void set_actividades(String actividades_realizar){
		this.actividades_realizar = actividades_realizar;
	}

	public Alumno get_alumno(){
		return alumno;
	}
	public void set_alumno(Alumno alumno){
		this.alumno = alumno;
	}

	public Empresa get_empresa(){
		return empresa;
	}
	public void set_empresa(Empresa empresa){
		this.empresa = empresa;
	}

	public EvaluacionEmpresa get_evaluacionEmpresa(){
		return evaluacionEmpresa;
	}
	/*
	public void set_evalucionEmpresa(EvaluacionEmpresa evaluacionEmpresa){
		this.evaluacionEmpresa = evaluacionEmpresa;
	}*/

	public EvaluacionPractica get_evaluacionPractica(){
		return evaluacionPractica;
	}
	/*
	public void set_evaluacionPractica(EvaluacionPractica evaluacionPractica){
		this.evaluacionPractica = evaluacionPractica;
	}*/


}
