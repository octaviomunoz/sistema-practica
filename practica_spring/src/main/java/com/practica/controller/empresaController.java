package com.practica.controller;

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


  @RequestMapping(value = "/mostrar", method = RequestMethod.GET)
  public String mostrarEmpresa(@RequestParam(name="page", required=false, defaultValue="1")String page, Model model){
    Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
    Page<Empresa> empe_page = empresarepo.findAll(pageable);
    model.addAttribute("PageEmpresas", empe_page);
    model.addAttribute("numPaginas", empe_page.getTotalPages());
    //model.addAttribute("Empresas", empe_page.getContent());
  //  System.out.println(empe_page);
    return "empresa/mostrarEmpresa";
  }
















}
