package com.practica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practica.model.DocenteCrud;
import com.practica.model.Docente;

@Controller
@RequestMapping("/CrudDocente")
public class ControDocenteCrud {
	
	@Autowired
	private DocenteCrud uc;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String ListaDocentes(ModelMap mp) {
		mp.put("Docentes", uc.findAll() );
		return "CrudDocente/ListaDocentes";
	}
	
	@RequestMapping(value="/crearDocente", method=RequestMethod.POST)
	public String crear(@Valid Docente docente, BindingResult bindingResult, ModelMap mp) {
		if(bindingResult.hasErrors()) {
			return "/CrudDocente/nuevo";
		} else {
			uc.save(docente);
			mp.put("Docentes", docente);
			return "CrudDocente/creado";
		}
	}
	
	@RequestMapping(value="/creado", method = RequestMethod.POST)
	public String creado(@RequestParam("Docentes") Docente docente) {
		return "/CrudDocente/creado";
	}
}
