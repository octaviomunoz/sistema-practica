package com.practica.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.model.Alumno;

public interface IAlumnoRepo extends JpaRepository<Alumno, String>{

}
