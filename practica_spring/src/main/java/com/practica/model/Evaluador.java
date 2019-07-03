package com.practica.model;


import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "evaluadores")
public class Evaluador{

  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

  private String nombre;

  private String email;

  private String telefono;

  @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private User usuario;

  @OneToMany(mappedBy = "evaluador", cascade = CascadeType.ALL)
	private List<Practica> practica = new ArrayList<>();

  public Long getId(){
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }

  public String getNombre(){
    return nombre;
  }
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }

  public String getTelefono(){
    return telefono;
  }
  public void setTelefono(String telefono){
    this.telefono = telefono;
  }

  public List<Practica> getPractica(){
    return practica;
  }

  public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

}
