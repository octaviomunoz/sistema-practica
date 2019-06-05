package com.practica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class IndexController{

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String principal() {
		return "index";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
  public String loginUsuario(){
    return "login";
  }


}
