package com.practica.model;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DocenteCrud extends JpaRepository<Docente, Long> {

}
