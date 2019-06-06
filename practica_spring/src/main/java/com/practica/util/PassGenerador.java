package com.practica.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassGenerador {
  /*
    public static void main(String ...args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //El String que mandamos al metodo encode es el password que queremos encriptar.
	       System.out.println(bCryptPasswordEncoder.encode("1234"));
    }
    */


    //Funcion que devuelve encriptado el string que entra
    public static String EncriptarContrasena(String contrasena){
      BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
      return bCryptPasswordEncoder.encode(contrasena);
    }
}
