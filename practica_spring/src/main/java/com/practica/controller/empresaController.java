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

  private Empresa empresaIngresada;

  //Funcion que consigue las empresas para mostrar en la vista
  @RequestMapping(value = "/mostrar", method = RequestMethod.GET)
  public String mostrarEmpresa(@RequestParam(name="page", required=false, defaultValue="1")String page, Model model){
    Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
    Page<Empresa> empe_page = empresarepo.findAll(pageable);
    model.addAttribute("PageEmpresas", empe_page);
    model.addAttribute("numPaginas", empe_page.getTotalPages());
    return "empresa/mostrarEmpresa";
  }


  @RequestMapping(value = "/ingresarDatos", method = RequestMethod.GET)
  public String inscripcionEmpresa(Empresa empresa){
    return "empresa/formEmpresa";
  }

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

  @RequestMapping(value = "/validandoEmpresa", method = RequestMethod.POST)
  public String validacionEmpresa(@Valid Empresa empresa, BindingResult bindingResult){

    System.out.println(empresa);

    if (bindingResult.hasErrors()){
      return "empresa/formEmpresa";
    }
    empresarepo.save(empresa);
    return "redirect:/empresa/mostrar";
  }


  @RequestMapping(value="/eliminar", method= RequestMethod.GET)
  public String eliminacioEmpresa(@RequestParam(name="idEMP", required=true, defaultValue="0")String idEMP){
    Long id_empresa = Long.parseLong(idEMP);
    if(empresarepo.existsById(id_empresa)){
      empresarepo.deleteById(id_empresa);
    }
    return "redirect:/empresa/mostrar";
  }
















}
