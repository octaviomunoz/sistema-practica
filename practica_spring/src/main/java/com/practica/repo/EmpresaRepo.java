package com.practica.repo;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.model.Empresa;



public interface EmpresaRepo extends JpaRepository<Empresa, Long>, PagingAndSortingRepository<Empresa, Long>{

  //@Query("select e from empresas e where e.id = ?1")
  //Collection<Empresa> getEmpresa(int id);

}
