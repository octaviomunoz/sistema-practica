package com.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControladorIndex{
	
	@GetMapping //Para obtener el dato
	public String principal() {
		return "index";
	}
}