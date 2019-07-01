package com.practica.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


import com.practica.model.Alumno;
import com.practica.model.Comuna;
import com.practica.model.Docente;
import com.practica.model.Practica;

import com.practica.model.User;

public interface PracticaCrud extends JpaRepository<Practica, Long> {

	//List<Practica> findByDocente(Docente docente);





}