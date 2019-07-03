package com.practica.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.practica.model.Docente;
import com.practica.model.Evaluacionpractica;
import com.practica.model.User;

public interface EvaluacionPracticaRepo extends JpaRepository<Evaluacionpractica, Long> {


	
}