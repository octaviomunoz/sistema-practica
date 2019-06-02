package com.practica.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController{

	@GetMapping //Para obtener el dato
	public String principal() {
		return "index";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
  public String loginUsuario(){
    return "login";
  }


  @RequestMapping(value="/validado", method = RequestMethod.POST)
  public String hola(){
    return "results";
  }


}
