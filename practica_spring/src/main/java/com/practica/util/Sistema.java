package com.practica.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

import com.practica.repo.UserRepo;
import com.practica.repo.AuthorityRepo;
import com.practica.repo.PracticaCrud;
import com.practica.repo.RegionRepo;

import com.practica.model.*;

import com.practica.util.Roles;

@Component
public class Sistema {

  @Autowired
  private UserRepo userrepo;
  @Autowired
  private AuthorityRepo authorepo;
  @Autowired
  private PracticaCrud practicarepo;
  @Autowired
  private RegionRepo regionrepo;

  // Metodo que recupera el nombre de usuario que se logeo
  public String RecuperarUsuarioLogeado() {
    String usuario = "";

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
      usuario = ((UserDetails) principal).getUsername();
    } else {
      usuario = principal.toString();
    }

    return usuario;
  }

  // Metodo que encripta la contraseña
  public String EncriptarContrasena(String contrasena) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    return bCryptPasswordEncoder.encode(contrasena);
  }

  // Metodo que guarda un usuario asignandole su rol
  public User GuardarUsuario(User usuario, Roles rol) {
    User guardado = null;

    if (userrepo.existsByUsername(usuario.getUsername())) {
      boolean encontrado = false;
      usuario = userrepo.findByUsername(usuario.getUsername());
      for (Authority autho : usuario.getAuthority()) {
        if (autho.getId() == rol.getId()) {
          encontrado = true;
        }
      }
      if (!encontrado) {
        usuario.addAuthority(authorepo.getOne(rol.getId()));
        guardado = userrepo.save(usuario);
      }
    } else if (usuario.getId() == null) {
      usuario.addAuthority(authorepo.getOne(rol.getId()));
      usuario.setPassword(EncriptarContrasena(usuario.getPassword()));
      guardado = userrepo.save(usuario);
    }

    return guardado;
  }

  public LocalDate transformarFechas(String fecha) {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localdate = LocalDate.parse(fecha);
    String text = localdate.format(formato);
    localdate = LocalDate.parse(text, formato);
    return localdate;
  }

  public List<Pares> regionesCantidadAlumnos(LocalDate inicio, LocalDate fin) {
    List<Pares> numRegiones = new ArrayList<Pares>();
    int i = 0, j = 0;
    boolean encontrado = false;
    List<Region> regiones = regionrepo.findAll();

    for (i = 0; i < regiones.size(); i++) {
      numRegiones.add(new Pares(regiones.get(i).getNombre()));
    }
    List<Practica> practicas = practicarepo.findAll();

    for (i = 0; i < practicas.size(); i++) {
      if (inicio.compareTo(practicas.get(i).getFechaPractica()) <= 0
          && fin.compareTo(practicas.get(i).getFechaPractica()) >= 0) {
        j = 0;
        encontrado = false;
        while (j < regiones.size() && !encontrado) {
          if (practicas.get(i).getEmpresa().getComuna().getRegion().getNombre() == numRegiones.get(j).getNombre()) {

            numRegiones.get(j).setCantidad(numRegiones.get(j).getCantidad() + 1);
            encontrado = true;
          }
          j++;
        }

      }
    }

    return numRegiones;
  }

}
