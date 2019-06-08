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

  @NotNull
  @Size(max = 20)
  private String nombreDoc;

  @NotNull
  @Email			//Para indicar que el valor es una cadena de email.
  private String emailDoc;

  @NotNull

  @Size
  private String director; //Lo ideal es que de un yes or not.

  @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private User usuario;

  @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
	private List<Practica> practica = new ArrayList<>();

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

	public Docente() {
	}

	public Docente(Long idDoc, @NotNull @Size(max = 15) String runDoc, @NotNull @Size(max = 20) String nombreDoc,
			@NotNull @Email String emailDoc, @NotNull @Size String director) {
		this.idDoc = idDoc;
		this.nombreDoc = nombreDoc;
		this.emailDoc = emailDoc;
		this.director = director;
	}


}
