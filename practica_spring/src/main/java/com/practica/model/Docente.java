package com.practica.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;


@Entity  //Esto ya le dice que una entidad de la base de datos.
@Table(name = "docentes")
public class Docente {

  @Id		//Primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementable.
  private Long idDoc;

  private String nombreDoc;

  private String emailDoc;

  private String director = "false"; 

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private User usuario;

	@OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
	private List<Practica> practica = new ArrayList<>();


  public Docente(Long idDoc, @NotNull @Size(max = 20) String nombreDoc, @NotNull @Email String emailDoc,
		@NotNull @Size String director, User usuario) {
	this.idDoc = idDoc;
	this.nombreDoc = nombreDoc;
	this.emailDoc = emailDoc;
	this.director = director;
	this.usuario = usuario;
  }

  public Docente() {
	}

  @Override
	public String toString() {
    return "Docente [id="+ idDoc +", nombre= " + nombreDoc +"]";
  }


  public User getUsuario(){
    return usuario;
  }
  public void setUsuario(User usuario){
    this.usuario = usuario;
  }
  public List<Practica> getPractica(){
    return practica;
  }
  public void setPractica(List<Practica> practica){
    this.practica = practica;
  }


	public Long getIdDoc() {
		return idDoc;
	}

  public void setIdDoc(Long idDoc){
    this.idDoc = idDoc;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
