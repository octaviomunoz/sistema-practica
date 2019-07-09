package com.practica.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.time.LocalDate;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.practica.repo.*;
import com.practica.util.*;
import com.practica.model.*;


@Controller		//Indica que es una clase controlador
@RequestMapping("/CrudDocente")	//Indica que el archivo raiz sera localhost:8080/CrudDocente
public class ControDocenteCrud {

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private DocenteCrud docenterepo;

	@Autowired
	private PracticaCrud practicarepo;

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private Sistema sistema;



	/*Se ejecuta para listar los docentes.
	 * findAll() leera todos los registros de la tabla "docentes"
	 * El resultado se almacena en el ModelMap
	 * Modelmap es una clase que se utiliza para mandarle los valores a las vistas.
	 * En este caso se los manda a docentes y esta guarda los datos llamados de docenterepo.finall()
	 * ListaDocentes es lo que retornara en formato .html
	 */
	@RequestMapping(value="/ListaDocente", method = RequestMethod.GET)
	public String ListaDocentes(@RequestParam(name="page", required=false, defaultValue="1") String page, Model mp) {
		 Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
		 Page<Docente> docen_page = docenterepo.findAll(pageable);
		 mp.addAttribute("PageDocentes", docen_page);
		 mp.addAttribute("numPaginas", docen_page.getTotalPages());
		return "CrudDocente/ListaDocentes";
	}
/*
	@RequestMapping(value="/ListaDocentePractica", method = RequestMethod.GET)
	public String Listadocepracticas(@RequestParam(name="page", required=false, defaultValue="1") String page, Model mp) {
		 Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
		 Page<Docente> docen_page = docenterepo.findAll(pageable);
		 mp.addAttribute("PageDocentes", docen_page);
		 mp.addAttribute("numPaginas", docen_page.getTotalPages());
	     return "CrudDocente/ListaDocentePracticas";
	}

	*/

	@RequestMapping(value="/Listapracticadocente", method = RequestMethod.GET)
	public String Listapracticasdocente(@RequestParam(name="page", required=false, defaultValue="1") String page, Model mp) {
		 Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
		 User user = userrepo.findByUsername(sistema.RecuperarUsuarioLogeado());
		 Docente docente = docenterepo.findByUsuario(user);
		 //Page<Practica> docen_pra = practicarepo.findAll(pageable);
		 Page<Practica> docen_pra = practicarepo.findByDocente(docente, pageable);
		 mp.addAttribute("usuario", user);
		 mp.addAttribute("PagePracticas", docen_pra);
		 mp.addAttribute("numPaginas", docen_pra.getTotalPages());
	     return "CrudDocente/ListaPracticasDocentes";
	}

	/*
	@RequestMapping(value="/ListaDocenPra", method = RequestMethod.GET)
	public String ListaDocenPra(@RequestParam(name="page", required=false, defaultValue="1") String page, Model mp) {
		 Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
		 Page<Docente> docen_page = docenterepo.findAll(pageable, ); //Tengo que mostrar en pantalla todas las practicas que tiene en comun la misma id. getpractica()
		 mp.addAttribute("PageDocentes", docen_page);
		 mp.addAttribute("numPaginas", docen_page.getTotalPages());

		return "CrudDocente/ListaDocenPracs";
	}
	*/
	/*
	 * Aca este metodo nos manda a la vista nuevoDoc.html con los valores de docente sin inicializar
	 * aca el put guarda el valor en la variable y el return recibe esa variable del ModelMap
	 */
	@RequestMapping(value="/nuevoDoc", method=RequestMethod.GET)
	public String nuevo(Docente docente, User user) {
		return "CrudDocente/nuevoDoc";
	}

	/*
	 * Aca el metodo antes de agregar a la bd verifica si los valores que se le pasan son los correctos
	 * para eso se usa @valid que comprobara min max de caracteres y todas las restricciones ya existentes
	 * use bindingresult que es un metodo que si hay errores nos devolvera a la vista
	 * y si no hay errores guardara los datos en la base de datos
	 * usando el docenterepo.save
	 */
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid Docente docente, User user) {
		String direccion = "redirect:/";
    User usuario = sistema.GuardarUsuario(user, Roles.ROLE_DOCENTE);
    if (usuario != null){
        docente.setUsuario(usuario);
        docenterepo.save(docente);
    }else if(userrepo.existsById(user.getId())){
          docente.setUsuario(userrepo.getOne(user.getId()));
          docenterepo.save(docente);
    }else {
        direccion = "/CrudDocente/nuevoDoc";
    }
    return direccion;
	}

	/*
	 * Se usa request param para que la vista espere una instancia de la clase docente
	 * la vista recibe con el metodo post para mostrar los valores.
	 */
	@RequestMapping(value="/DocCreado", method = RequestMethod.POST)
	public String creado(@RequestParam("Docentes") Docente docente) {
		return "CrudDocente/DocCreado";
	}

	/*
	 * Para Elimnar!
	 */
	@RequestMapping(value="/borrar/{idDoc}", method = RequestMethod.GET)
	public String borrar(@PathVariable("idDoc") Long idDoc) {
		 docenterepo.deleteById(idDoc);
		return "redirect:/CrudDocente/ListaDocente";
	}

	/*
	 * Para Editar y actualizar!
	 */

	@RequestMapping(value="/editarDoc/{idDoc}", method = RequestMethod.GET)
	public String editar(@PathVariable("idDoc") Long idDoc, ModelMap mp) {
		mp.put("docente", docenterepo.findById(idDoc));
		return "CrudDocente/editarDoc";
	}

	@RequestMapping(value="/actualizarDoc", method=RequestMethod.POST)
	public String actualizar(@Valid Docente docente, BindingResult bindingResult, ModelMap mp) {
		if(bindingResult.hasErrors()) {
			mp.put("docente",docente);
		return "CrudDocente/editarDoc/"+docente.getIdDoc().toString();
		}
		return "redirect:/CrudDocente/ListaDocente";
	}




	@RequestMapping(value = "/alumnoRegion", method=RequestMethod.GET)
	public String alumnoRegion(Model model){

		model.addAttribute("fechas", new Fechas());
		return "CrudDocente/alumnosRegion";
	}

	@RequestMapping(value = "/alumnoRegionTable", method=RequestMethod.GET)
	public String mostraralumnosRegion(Fechas fechas, Model model){
		String direccion = "CrudDocente/infoAlumnoRegion";
		LocalDate inicio = sistema.transformarFechas(fechas.getFechaInicio());
		LocalDate fin = sistema.transformarFechas(fechas.getFechaFin());
		if(fin.compareTo(inicio) >= 0){
			List<Pares> cantidadAlumno = sistema.regionesCantidadAlumnos(inicio, fin);
			model.addAttribute("cantidadAlumno", cantidadAlumno);
		}else{
			direccion = "redirect:/CrudDocente/alumnoRegion";
		}
		return direccion;
	}



}
