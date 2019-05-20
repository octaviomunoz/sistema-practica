package com.practica.controller;

import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import com.practica.repo.EmpresaRepo;
import com.practica.model.Empresa;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/empresa")
public class empresaController {

  @Autowired
  private EmpresaRepo empresarepo;

  //Funcion que consigue las empresas para mostrar en la vista
  @RequestMapping(value = "/mostrar", method = RequestMethod.GET)
  public String mostrarEmpresa(@RequestParam(name="page", required=false, defaultValue="1")String page, Model model){
    Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
    Page<Empresa> empe_page = empresarepo.findAll(pageable);
    model.addAttribute("PageEmpresas", empe_page);
    model.addAttribute("numPaginas", empe_page.getTotalPages());
    return "empresa/mostrarEmpresa";
  }

  //Fucion que muestra la vista con el formulario para ingresar una empresa
  @RequestMapping(value = "/ingresarDatos", method = RequestMethod.GET)
  public String inscripcionEmpresa(Empresa empresa){
    return "empresa/formEmpresa";
  }

  //Funcion que muestra que muestra el formulario para ingresar empresa y si no encuentra
  //la empresa a modificar vuelve al de mostrar empresa
  @RequestMapping(value="/modificarDatos", method = RequestMethod.GET)
  public String modificarEmpresa(Model model, @RequestParam(name="idEMP", required=false, defaultValue="0")String idEMP){
    Long id_empresa = Long.parseLong(idEMP);
    String direccion;
    if(empresarepo.existsById(id_empresa)){
      model.addAttribute("empresa", empresarepo.getOne(id_empresa));
      direccion = "empresa/formEmpresa";
    }else{
      direccion = "redirect:/empresa/mostrar";
    }
    return direccion;
  }

  //Funcion que valida si los datos ingresados sean correctos
  //Si son correctos los guarda en la base de datos
  @RequestMapping(value = "/validandoEmpresa", method = RequestMethod.POST)
  public String validacionEmpresa(@Valid Empresa empresa, BindingResult bindingResult){

    if (bindingResult.hasErrors()){
      return "empresa/formEmpresa";
    }
    empresarepo.save(empresa);
    return "redirect:/empresa/mostrar";
  }

  //Funcion que elimina una empresa mediante el id
  //y vuelve a la vista de mostrar empresa
  @RequestMapping(value="/eliminar", method= RequestMethod.GET)
  public String eliminacioEmpresa(@RequestParam(name="idEMP", required=true, defaultValue="0")String idEMP){
    Long id_empresa = Long.parseLong(idEMP);
    if(empresarepo.existsById(id_empresa)){
      empresarepo.deleteById(id_empresa);
    }
    return "redirect:/empresa/mostrar";
  }
















}
