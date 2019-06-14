package com.practica.controller;


import java.util.List;

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

import com.practica.model.Alumno;
import com.practica.model.User;
import com.practica.model.Practica;
import com.practica.model.Region;
import com.practica.model.Comuna;
import com.practica.model.Empresa;

import com.practica.util.Sistema;
import com.practica.util.Roles;


import com.practica.repo.AlumnoRepo;
import com.practica.repo.UserRepo;
import com.practica.repo.RegionRepo;
import com.practica.repo.ComunaRepo;
import com.practica.repo.DocenteCrud;
import com.practica.repo.EmpresaRepo;

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
  public String inscripcionAlumno(Alumno alumno){
    return "alumno/formAlumno";
  }

  //Funcion que muestra que muestra el formulario para ingresar alumno y si no encuentra
  //la alumno a modificar vuelve al de mostrar alumno
  @RequestMapping(value="/modificarDatos", method = RequestMethod.GET)
  public String modificarAlumno(Model model, @RequestParam(name="idALUM", required=false, defaultValue="0")String idALUM){
    Long id_alumno = Long.parseLong(idALUM);
    String direccion;
    if(alumnorepo.existsById(id_alumno)){
      model.addAttribute("alumno", alumnorepo.getOne(id_alumno));
      direccion = "alumno/formAlumno";
    }else{
      direccion = "redirect:/alumno/mostrar";
    }
    return direccion;
  }

  //Funcion que valida si los datos ingresados sean correctos
  //Si son correctos los guarda en la base de datos
  @RequestMapping(value = "/validandoAlumno", method = RequestMethod.POST)
  public String validacionAlumno(@Valid Alumno alumno, BindingResult bindingResult, Model model){
    String direccion = "redirect:/alumno/mostrar";
    if (bindingResult.hasErrors() ){
      direccion = "alumno/formAlumno";
    }else{
      model.addAttribute("run_repetido", true);
      direccion = "alumno/formAlumno";
    }
    return direccion;
  }

  //Funcion que elimina una alumno mediante el id
  //y vuelve a la vista de mostrar alumno
  @RequestMapping(value="/eliminar", method= RequestMethod.GET)
  public String eliminacioAlumno(@RequestParam(name="idALUM", required=true, defaultValue="0")String idALUM){
    Long id_alumno = Long.parseLong(idALUM);
    if(alumnorepo.existsById(id_alumno)){
      alumnorepo.deleteById(id_alumno);
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
    }

    model.addAttribute("user", user);
    model.addAttribute("alumno", alumno);

    return "alumno/infoAlumno";
  }


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



    return "alumno/inscripcion";
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




}
