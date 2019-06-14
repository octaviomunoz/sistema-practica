package com.practica.repo;

import java.util.List;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.model.Empresa;
import com.practica.model.Comuna;



public interface EmpresaRepo extends JpaRepository<Empresa, Long>, PagingAndSortingRepository<Empresa, Long>{

  List<Empresa> findByComuna(Comuna comuna);

}
