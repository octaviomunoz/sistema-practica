package com.practica.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.model.Alumno;

public interface AlumnoRepo extends JpaRepository<Alumno, Long>{

  Alumno findByRun(String run);

  Boolean existsByRun(String run);
}
