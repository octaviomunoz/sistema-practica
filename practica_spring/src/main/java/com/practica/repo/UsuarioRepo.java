package com.practica.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

}
