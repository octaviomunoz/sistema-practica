package com.practica.controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.practica.model.*;
import com.practica.repo.*;
import com.practica.util.*;

@Controller		//Indica que es una clase controlador
@RequestMapping("/CrudEvaluacionEmpresa")	//Indica que el archivo raiz sera localhost:8080/CrudEvaluacionEmpresa
public class EvaluacionEmpresaCrud {

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private EvaluacionEmpresaRepo  uc;


	@Autowired
	private PracticaCrud practicarepo;

	@Autowired
	private Sistema sistema;

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private AlumnoRepo alumnorepo;

	/*Se ejecuta para listar las evaluaciones de empresas.
	 * findAll() leera todos los registros de la tabla "evaluacion empresa"
	 * El resultado se almacena en el ModelMap
	 * Modelmap es una clase que se utiliza para mandarle los valores a las vistas.
	 * En este caso se los manda a evaluacionempresas y esta guarda los datos llamados de uc.finall()
	 * Listaempresa es lo que retornara en formato .html
	 */
	@RequestMapping(value="/ListaEvaluacionEmpresa", method = RequestMethod.GET)
	public String ListaEvaluacionEmpresa(ModelMap mp) {
		mp.put("Evaluacionempresas", uc.findAll() );
		return "CrudEvaluacionEmpresa/ListaEvaluacionEmpresas";
	}

	/*
	 * Aca este metodo nos manda a la vista nuevoDoc.html con los valores de evaluacion de empresa sin inicializar
	 * aca el put guarda el valor en la variable y el return recibe esa variable del ModelMap
	 */
	@RequestMapping(value="/nuevoEvaEmpresa", method=RequestMethod.GET)
	public String nuevo(Evaluacionempresa evaluacionempresa) {
		return "CrudEvaluacionEmpresa/nuevoEvaEmpresa";
	}

	/*
	 * Aca el metodo antes de agregar a la bd verifica si los valores que se le pasan son los correctos
	 * para eso se usa @valid que comprobara min max de caracteres y todas las restricciones ya existentes
	 * use bindingresult que es un metodo que si hay errores nos devolvera a la vista
	 * y si no hay errores guardara los datos en la base de datos
	 * usando el uc.save
	 */
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid Evaluacionempresa evaluacionempresa, BindingResult bindingResult, ModelMap mp) {
		System.out.println(evaluacionempresa);
		if(bindingResult.hasErrors()) {
			return "CrudEvaluacionEmpresa/nuevoEvaEmpresa";
		}
		User user = userrepo.findByUsername(sistema.RecuperarUsuarioLogeado());
    Alumno alumno = alumnorepo.findByUsuario(user);
		Practica practica = alumno.getPractica();
		evaluacionempresa.setPractica(practica);
		uc.save(evaluacionempresa);
		return "redirect:/alumno/info";
	}

	/*
	 * Se usa request param para que la vista espere una instancia de la clase evaluacion empresa
	 * la vista recibe con el metodo post para mostrar los valores.
	 */
	@RequestMapping(value="/EvaluacionEmpresaCreado", method = RequestMethod.POST)
	public String creado(@RequestParam("Evaluacionempresas") Evaluacionempresa evaluacionempresa) {
		return "CrudEvaluacionEmpresa/EvaluacionEmpresaCreado";
	}
	/*
	 * Para Elimnar!
	 */
	@RequestMapping(value="/borrar/{id}", method = RequestMethod.GET)
	public String borrar(@PathVariable("id") Long id) {
		System.out.println(id);
		uc.deleteById(id);
		return "redirect:/CrudEvaluacionEmpresa/ListaEvaluacionEmpresa";
	}

	/*
	 * Para Editar y actualizar!
	 */

	@RequestMapping(value="/editarEvaluacionEmpresa/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") Long id, ModelMap mp) {
		mp.put("evaluacionempresa",uc.findById(id));
		return "CrudEvaluacionEmpresa/editarEvaluacionEmpresa";
	}

	@RequestMapping(value="/actualizarEvaluacionEmpresa", method=RequestMethod.POST)
	public String actualizar(@Valid Evaluacionempresa evaluacionempresa, BindingResult bindingResult, ModelMap mp) {
		if(bindingResult.hasErrors()) {
			mp.put("evaluacionempresa",evaluacionempresa);
		return "CrudEvaluacionEmpresa/editarEvaluacionEmpresa/"+evaluacionempresa.getId().toString();
		}
		uc.save(evaluacionempresa);
		return "redirect:/CrudEvaluacionEmpresa/ListaEvaluacionEmpresa";
	}

	@RequestMapping(value="/mostrarInfo", method=RequestMethod.GET)
	public String mostrarInfo(@RequestParam(name="IDpractica", required=true)String id_practica, Model model){
		Practica practica = practicarepo.getOne(Long.parseLong(id_practica));
		Alumno alumno = practica.getAlumno();
		Evaluacionempresa evaEmpresa = practica.getEvaluacionEmpresa();
		model.addAttribute("evaEmpresa", evaEmpresa);
		model.addAttribute("alumno", alumno);
		return "CrudEvaluacionEmpresa/info";
	}


}
