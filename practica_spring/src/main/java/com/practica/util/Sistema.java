package com.practica.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Sistema{

  //Metodo que  recupera el nombre de usuario que se logeo
  public static String RecuperarUsuarioLogeado(){
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
  public static String EncriptarContrasena(String contrasena){
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    return bCryptPasswordEncoder.encode(contrasena);
  }

  //Metodo que verificia si el run del usuario esta presente
  public static boolean existeUsuario(String runUsuario){
    boolean existe = true;


    return existe;
  }
}
