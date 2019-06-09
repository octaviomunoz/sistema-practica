package com.practica.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;


import com.practica.repo.UserRepo;
import com.practica.repo.AuthorityRepo;

import com.practica.model.User;
import com.practica.model.Authority;

import com.practica.util.Roles;

@Component
public class Sistema{

  @Autowired
  private UserRepo userrepo;
  @Autowired
  private AuthorityRepo authorepo;

  //Metodo que  recupera el nombre de usuario que se logeo
  public String RecuperarUsuarioLogeado(){
    String usuario = "";

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
      usuario = ((UserDetails)principal).getUsername();
    } else {
      usuario = principal.toString();
    }

    return usuario;
  }

  //Metodo que encripta la contraseña
  public String EncriptarContrasena(String contrasena){
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    return bCryptPasswordEncoder.encode(contrasena);
  }

  //Metodo que guarda un usuario asignandole su rol
  public User GuardarUsuario(User usuario, Roles rol){
    User guardado = null;

    if (userrepo.existsByUsername(usuario.getUsername())){
      boolean encontrado = false;
      usuario = userrepo.findByUsername(usuario.getUsername());
      for (Authority autho : usuario.getAuthority()){
        if(autho.getId() == rol.getId()){
          encontrado = true;
        }
      }
      if (!encontrado){
        usuario.addAuthority(authorepo.getOne(rol.getId()));
        guardado = userrepo.save(usuario);
      }
    }else if(usuario.getId() == null){
      usuario.addAuthority(authorepo.getOne(rol.getId()));
      usuario.setPassword(EncriptarContrasena(usuario.getPassword()));
      guardado = userrepo.save(usuario);
    }

    return guardado;
  }

}
