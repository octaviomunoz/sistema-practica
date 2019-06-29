package com.practica.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.practica.model.Comuna;
import com.practica.model.Docente;
import com.practica.model.Practica;
import com.practica.model.Region;

public interface PracticaCrud extends JpaRepository<Practica, Long> {

	//List<Practica> findByDocente(Docente docente);
}