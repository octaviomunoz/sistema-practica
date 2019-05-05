package com.practica.repo;

import com.practica.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlumnoRepo extends JpaRepository<Alumno, Long>{

}
