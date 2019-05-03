package com.practica.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
public class EvaluacionPractica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Date fecha;

	@NotNull
	private int[] tabla1 = new int[10];

	@NotNull
	private int[] tabla2 = new int[5];

	@NotNull
	@Size(min = 1, max = 200)
	private String pregunta1;

	@NotNull
	@Size(min = 1, max = 200)
	private String pregunta2;

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

		public int[] get_tabla1(){
			return tabla1;
		}
		public void set_tabla1(int[] tabla1){
			this.tabla1 = tabla1;
		}

		public int[] get_tabla2(){
			return tabla2;
		}
		public void set_tabla2(int[] tabla2){
			this.tabla2 = tabla2;
		}

		public Practica get_practica(){
			return practica;
		}
		public void set_practica(Practica practica){
			this.practica = practica;
		}
}
