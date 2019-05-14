package com.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/magia")
public class ControladorIndex{
	
	@GetMapping(path = {"/saludo"}) //Para obtener el dato
	public String saludo() {
		return "index";
	}
}