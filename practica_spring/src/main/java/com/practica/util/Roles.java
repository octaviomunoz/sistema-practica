package com.practica.util;


public enum Roles{

  ROLE_ADMIN(1L),
  ROLE_DOCENTE(2L),
  ROLE_DIRECTOR(3L),
  ROLE_ALUMNO(4L),
  ROLE_EMPRESA(5L);


  private Long id;

  Roles(Long id){
    this.id = id;
  }


  public Long getId(){
    return id;
  }
}
