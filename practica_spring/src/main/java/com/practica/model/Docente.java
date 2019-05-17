package com.practica.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;


@Entity  //Esto ya le dice que una entidad de la base de datos.
public class Docente {

  @Id		//Primary key
  @GeneratedValue(strategy = GenerationType.AUTO) //Autoincrementable.
  private Long idDoc;

  @NotNull
  @Size(max = 15)
  @Column(unique = true)
  private String runDoc;

  @NotNull
  @Size(max = 20)
  private String nombreDoc;
  
  @NotNull
  @Email			//Para indicar que el valor es una cadena de email.
  private String emailDoc;
  
  

  @NotNull
  @Size
  private boolean director; //Lo ideal es que de un yes or not.


	public Long getId() {
		return idDoc;
	}
		
	public void setId(Long idDoc) {
		this.idDoc = idDoc;
	}
		
	public String getRunDoc() {
		return runDoc;
	}
			
	public void setRunDoc(String runDoc) {
		this.runDoc = runDoc;
	}
		
	public String getNombreDoc() {
		return nombreDoc;
	}
			
	public void setNombreDoc(String nombreDoc) {
		this.nombreDoc = nombreDoc;
	}
		
	public String getEmailDoc() {
		return emailDoc;
	}
		
	public void setEmailDoc(String emailDoc) {
		this.emailDoc = emailDoc;
	}
		
	public boolean isDirector() {
		return director;
	}
		
	public void setDirector(boolean director) {
		this.director = director;
	}

  /*	 
  @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
  private List<Practica> practica = new ArrayList<>();
*/
	
	/**
	* Returns value of alumno
	* @return
	*/
	/* 		Atributos de otras tablas.
	public List<Practica> getPractica() {
		return practica;
	}

	/**
	* Sets new value of alumno
	* @param
	
	public void setPractica(List<Practica> practica) {
		this.practica = practica;
	}
	*/
}
