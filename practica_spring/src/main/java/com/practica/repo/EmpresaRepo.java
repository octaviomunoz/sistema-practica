package com.practica.repo;

import com.practica.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpresaRepo extends JpaRepository<Empresa, Long>{

}
