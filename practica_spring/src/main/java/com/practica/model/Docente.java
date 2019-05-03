package com.practica.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "docentes")
public class Docente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(max = 15)
  @Column(unique = true)
  private String run;

  @NotNull
  @Size(max = 20)
  private String nombre;

  @NotNull
  @Size
  private boolean director;

  @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
  private List<Alumno> alumno = new ArrayList<>();

  //setters, getters
  public Long get_id(){
    return id;
  }
  public void set_id(Long id){
    this.id = id;
  }

  public String get_run(){
    return run;
  }
  public void set_run(String run){
    this.run = run;
  }

  public String get_nombre(){
    return nombre;
  }
  public void set_nombre(String nombre){
    this.nombre = nombre;
  }

  public boolean get_director(){
    return director;
  }

  public List<Alumno> get_alumno(){
    return alumno;
  }

}
