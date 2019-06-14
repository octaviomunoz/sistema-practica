package com.practica.repo;


import java.util.List;
import com.practica.model.Comuna;
import com.practica.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComunaRepo extends JpaRepository<Comuna, Long>{

  List<Comuna> findByRegion(Region region);
}
