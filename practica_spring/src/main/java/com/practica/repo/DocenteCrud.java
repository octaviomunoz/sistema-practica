package com.practica.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.practica.model.Docente;
import com.practica.model.User;

public interface DocenteCrud extends JpaRepository<Docente, Long>,PagingAndSortingRepository<Docente,Long> {

	 Docente findByUsuario(User user);
}
