package com.practica.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.model.Authority;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {



}
