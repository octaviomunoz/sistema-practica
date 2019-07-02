package com.practica.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  public User findByUsername(String username);

  public boolean existsByUsername(String username);


}
