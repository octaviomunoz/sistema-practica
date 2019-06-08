package com.practica.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.model.Alumno;
import com.practica.model.User;

public interface AlumnoRepo extends JpaRepository<Alumno, Long>, PagingAndSortingRepository<Alumno, Long>{



  Alumno findByUsuario(User user);

}
