package com.practica.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.practica.model.Evaluacionpractica;

public interface EvaluacionPracticaRepo extends JpaRepository<Evaluacionpractica, Long> {

}