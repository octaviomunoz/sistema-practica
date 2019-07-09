package com.practica.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import com.practica.model.Docente;
import com.practica.model.Evaluador;
import com.practica.model.Practica;

public interface PracticaCrud extends JpaRepository<Practica, Long>{

	Page<Practica> findByDocente(Docente docente, Pageable pageable);
	Page<Practica> findByEvaluador(Evaluador evaluador, Pageable pageable);
}
