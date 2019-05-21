package com.practica.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.model.Docente;

public interface DocenteCrud extends JpaRepository<Docente, Long> {

  Docente findByRunDoc(String runDoc);

  Boolean existsByRunDoc(String runDoc);
}
