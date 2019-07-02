package com.practica.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.model.Evaluador;
import com.practica.model.User;

public interface EvaluadorRepo extends JpaRepository<Evaluador, Long>{
	Evaluador findByUsuario(User user);

}
