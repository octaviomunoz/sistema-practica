package com.practica.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DocenteCrud extends JpaRepository<Docente, Long> {

}
