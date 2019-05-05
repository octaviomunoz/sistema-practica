package com.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import com.practica.model.Alumno;
import com.practica.repo.AlumnoRepo;



@Controller
public class inscripcionController {

  private final AlumnoRepo repository;

  public inscripcionController(AlumnoRepo repository){
    this.repository = repository;
  }

  @GetMapping("/inscripcion")
  public String inscripcion(Alumno alumno){

    return "formInscripcion";
  }

  @PostMapping("/inscripcion")
  public String validacion(@Valid Alumno alumno, BindingResult bindingResult){

    alumno.toString();

    if (bindingResult.hasErrors()){
      return "formInscripcion";
    }

    return "results";
  }





}
