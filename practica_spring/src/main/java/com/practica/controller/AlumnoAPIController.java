package com.practica.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.model.Alumno;
import com.practica.repo.AlumnoRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlumnoAPIController{

  @Autowired
  AlumnoRepo alumnorepo;


  @GetMapping("/alumnos")
  public List<Alumno> getAllAlumnos(){
    System.out.println("Get a los alumnos");
    List<Alumno> alumnos = new ArrayList<>();
    alumnorepo.findAll().forEach(alumnos::add);

    return alumnos;
  }

  @PostMapping("/alumno")
  public Alumno postAlumno(@RequestBody Alumno alumno){
    Alumno _alumno = alumnorepo.save(new Alumno(alumno.getNombre(), alumno.getApellido_paterno(), alumno.getApellido_materno()));
    return _alumno;
  }

  @DeleteMapping("/alumno/{id}")
  public ResponseEntity<String> deleteAlumno(@PathVariable Long id){
    System.out.println("Eliminando Alumno");
    alumnorepo.deleteById(id);

    return new ResponseEntity<>("El alumon ha sido eliminado", HttpStatus.OK);
  }

  @PutMapping("/alumno/{id}")
  public ResponseEntity<Alumno> updateAlumno(@PathVariable("id") Long id, @RequestBody Alumno alumno){
    System.out.println("Update Alumno con ID " + id);

    Optional<Alumno> alumnoData = alumnorepo.findById(id);

    if(alumnoData.isPresent()){
      Alumno _alumno = alumnoData.get();
      _alumno.setNombre(alumno.getNombre());
      _alumno.setApellido_paterno(alumno.getApellido_paterno());
      _alumno.setApellido_materno(alumno.getApellido_materno());
      return new ResponseEntity<>(alumnorepo.save(_alumno), HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
