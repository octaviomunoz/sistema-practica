package com.practica.controller;


import java.util.List;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.practica.model.*;
import com.practica.util.*;
import com.practica.repo.*;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

  @Autowired
  private UserRepo userrepo;

  @Autowired
  private AlumnoRepo alumnorepo;

  @Autowired
  private RegionRepo regionrepo;

  @Autowired
  private ComunaRepo comunarepo;

  @Autowired
  private DocenteCrud docenterepo;

  @Autowired
  private EmpresaRepo empresarepo;

  @Autowired
  private PracticaCrud practicarepo;

  @Autowired
  private Sistema sistema;

  //Funcion que consigue las alumnos para mostrar en la vista
  @RequestMapping(value = "/mostrar", method = RequestMethod.GET)
  public String mostrarAlumno(@RequestParam(name="page", required=false, defaultValue="1")String page, Model model){
    Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
    Page<Alumno> alum_page = alumnorepo.findAll(pageable);
    model.addAttribute("PageAlumnos", alum_page);
    model.addAttribute("numPaginas", alum_page.getTotalPages());
    return "alumno/mostrarAlumno";
  }

  //Fucion que muestra la vista con el formulario para ingresar una alumno
  @RequestMapping(value = "/ingresarDatos", method = RequestMethod.GET)
  public String inscripcionAlumno(Alumno alumno, User user, Model model){
    model.addAttribute("modificar", false);
    return "alumno/formAlumno";
  }

  //Funcion que muestra que muestra el formulario para ingresar alumno y si no encuentra
  //la alumno a modificar vuelve al de mostrar alumno
  @RequestMapping(value="/modificarDatos", method = RequestMethod.GET)
  public String modificarAlumno(Model model, @RequestParam(name="idALUM", required=false, defaultValue="0")String idALUM){
    Long id_alumno = Long.parseLong(idALUM);
    String direccion;
    if(alumnorepo.existsById(id_alumno)){
      Alumno alumno = alumnorepo.getOne(id_alumno);
      User usuario = alumno.getUsuario();
      usuario.setPassword("");
      model.addAttribute("alumno", alumno);
      model.addAttribute("user", usuario);
      model.addAttribute("modificar", true);
      direccion = "alumno/formAlumno";
    }else{
      direccion = "redirect:/alumno/mostrar";
    }
    return direccion;
  }

  //Funcion que valida si los datos ingresados sean correctos
  //Si son correctos los guarda en la base de datos
  @RequestMapping(value = "/validandoAlumno", method = RequestMethod.POST)
  public String validacionAlumno(Alumno alumno, User user){
    String direccion = "redirect:/alumno/mostrar";
    User usuario = sistema.GuardarUsuario(user, Roles.ROLE_ALUMNO);
    System.out.println(user);
    if (usuario != null){
        alumno.setUsuario(usuario);
        alumnorepo.save(alumno);
    }else if(userrepo.existsById(user.getId())){
          alumno.setUsuario(userrepo.getOne(user.getId()));
          alumnorepo.save(alumno);
    }else {
        direccion = "/alumno/formAlumno";
    }
    return direccion;
  }

  //Funcion que elimina una alumno mediante el id
  //y vuelve a la vista de mostrar alumno
  @RequestMapping(value="/eliminar", method= RequestMethod.GET)
  public String eliminacioAlumno(@RequestParam(name="idALUM", required=true, defaultValue="0")String idALUM){
    Long id_alumno = Long.parseLong(idALUM);
    if(alumnorepo.existsById(id_alumno)){
      Alumno alumno = alumnorepo.getOne(id_alumno);
      User usuario = alumno.getUsuario();
      alumnorepo.delete(alumno);
      userrepo.delete(usuario);
    }
    return "redirect:/alumno/mostrar";
  }





  //Metodo que muestra los datos del alumno por la pantalla
  @RequestMapping(value="/info", method = RequestMethod.GET)
  public String infoAlumno(Model model){

    User user = userrepo.findByUsername(sistema.RecuperarUsuarioLogeado());
    Alumno alumno = alumnorepo.findByUsuario(user);
    Practica practica = alumno.getPractica();
    if (practica != null){
      model.addAttribute("practica", practica);
      model.addAttribute("docente", practica.getDocente());
    }

    model.addAttribute("user", user);
    model.addAttribute("alumno", alumno);

    return "alumno/infoAlumno";
  }

//Controlador que llama para la inscripcion de una practica
  @RequestMapping(value="/inscripcion", method = RequestMethod.GET)
  public String inscripcionPractica(Model model){
    User user = userrepo.findByUsername(sistema.RecuperarUsuarioLogeado());
    Alumno alumno = alumnorepo.findByUsuario(user);

    model.addAttribute("user", user);
    model.addAttribute("alumno", alumno);
    model.addAttribute("regiones", regionrepo.findAll());
    model.addAttribute("docentes", docenterepo.findAll());
    model.addAttribute("empresa", new Empresa());
    model.addAttribute("comuna", new Comuna());
    model.addAttribute("docente", new Docente());

    return "alumno/inscripcion";
  }

  //Controlador que valida la Practica
  @RequestMapping(value="/inscripcion_validando", method=RequestMethod.POST)
  public String validarPractica(Docente docente, Empresa empresa){
    Alumno alumno = alumnorepo.findByUsuario(userrepo.findByUsername(sistema.RecuperarUsuarioLogeado()));
    Practica practica = new Practica();
    System.out.println(LocalDate.now());
    practica.setFechaPractica(LocalDate.now());
    practica.setDocente(docenterepo.getOne(docente.getIdDoc()));
    practica.setEmpresa(empresarepo.getOne(empresa.getId()));
    practica.setAlumno(alumno);

    practicarepo.save(practica);
    return "redirect:/alumno/info";
  }

  //Controlador que finaliza la practica
  @RequestMapping(value="/finalizarPractica", method= RequestMethod.GET)
  public String finalizarPractica(){
    Alumno alumno = alumnorepo.findByUsuario(userrepo.findByUsername(sistema.RecuperarUsuarioLogeado()));
    Practica practica = alumno.getPractica();
    practica.setActivo(true);
    practicarepo.save(practica);
    return "redirect:/alumno/info";
  }

  //Realiza la evaluacion de empresa
  @RequestMapping(value="/realizarEvaluacionEmpresa", method=RequestMethod.GET)
  public String evaluarEmpresa(){
    String redireccion = "redirect:/alumno/info";
    Alumno alumno = alumnorepo.findByUsuario(userrepo.findByUsername(sistema.RecuperarUsuarioLogeado()));
    Practica practica = alumno.getPractica();
    if(practica.getEvaluacionEmpresa() == null){
      redireccion = "redirect:/CrudEvaluacionEmpresa/nuevoEvaEmpresa";
    }
    return redireccion;
  }





  //Funcion que es llamada por una funcion ajax para conseguir las Comunas
  //que pertenecen a la region que corresponde el id
  @RequestMapping(value="/comunas", method = RequestMethod.GET, produces="application/json")
  public @ResponseBody List<Comuna> listacomunas(@RequestParam(value = "idRegion", required = true) Long id_region) {
    List<Comuna> comunas = null;
    if (regionrepo.existsById(id_region)){
      comunas = comunarepo.findByRegion(regionrepo.getOne(id_region));
    }
    return comunas;
  }


  //Funcion que es llamada por una funcion ajax para conseguir las Empresas
  //que pertenecen a la comuna que corresponde el id
  @RequestMapping(value="/empresas", method = RequestMethod.GET, produces="application/json")
  public @ResponseBody List<Empresa> listaempresas(@RequestParam(value = "idComuna", required = true) Long id_comuna) {
    List<Empresa> empresa = null;
    if (comunarepo.existsById(id_comuna)){
      empresa = empresarepo.findByComuna(comunarepo.getOne(id_comuna));
    }
    return empresa;
  }


  //Consigue al alumno para que se muestre en la vista de buscar alumno del rol del evaluador
  @RequestMapping(value="/conseguirAlumno", method = RequestMethod.GET, produces="application/json")
  public @ResponseBody Alumno conseguirAlumno(@RequestParam(value = "RUN", required = true) String username) {
    Alumno alumno = new Alumno();
    alumno.setId(-1L);

    if(userrepo.existsByUsername(username)){
      alumno = alumnorepo.findByUsuario(userrepo.findByUsername(username));
      Practica practica = alumno.getPractica();
      if (practica != null){
        Evaluador evaluador = practica.getEvaluador();
        if (evaluador != null){
          alumno.setId(-1L);
        }
      }else{
        alumno.setId(-1L);
      }
    }
    return alumno;
  }



}
