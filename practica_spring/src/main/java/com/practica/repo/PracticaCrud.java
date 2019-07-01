package com.practica.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import com.practica.model.Docente;
import com.practica.model.Practica;

public interface PracticaCrud extends JpaRepository<Practica, Long> {

	Page<Practica> findByDocente(Docente docente, Pageable pageable);

}
