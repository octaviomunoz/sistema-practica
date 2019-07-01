package com.practica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practica.repo.EvaluadorRepo;
import com.practica.model.Evaluador;

@Controller		//Indica que es una clase controlador
@RequestMapping("/InscripcionEvaluador")	//Indica que el archivo raiz sera localhost:8080/CrudDocente
public class EvaluadorCrud {

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private EvaluadorRepo uc;

	/*Se ejecuta para listar los docentes.
	 * findAll() leera todos los registros de la tabla "docentes"
	 * El resultado se almacena en el ModelMap
	 * Modelmap es una clase que se utiliza para mandarle los valores a las vistas.
	 * En este caso se los manda a docentes y esta guarda los datos llamados de uc.finall()
	 * ListaDocentes es lo que retornara en formato .html
	 */
	@RequestMapping(value="/ListaEvaluador", method = RequestMethod.GET)
	public String ListaEvaluadores(ModelMap mp) {
		mp.put("Evaluadores", uc.findAll() );
		return "InscripcionEvaluador/ListaEvaluadores";
	}

	/*
	 * Aca este metodo nos manda a la vista nuevoDoc.html con los valores de docente sin inicializar
	 * aca el put guarda el valor en la variable y el return recibe esa variable del ModelMap
	 */
	@RequestMapping(value="/nuevoEvaluador", method=RequestMethod.GET)
	public String nuevo(Evaluador evaluador) {
		System.out.println("Estoy funcionando");
		return "InscripcionEvaluador/nuevoEvaluador";
	}

	/*
	 * Aca el metodo antes de agregar a la bd verifica si los valores que se le pasan son los correctos
	 * para eso se usa @valid que comprobara min max de caracteres y todas las restricciones ya existentes
	 * use bindingresult que es un metodo que si hay errores nos devolvera a la vista
	 * y si no hay errores guardara los datos en la base de datos
	 * usando el uc.save
	 */
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid Evaluador evaluador, BindingResult bindingResult, ModelMap mp) {
		System.out.println(evaluador);
		if(bindingResult.hasErrors()) {
			System.out.println("hola soy un error");
			return "InscripcionEvaluador/nuevoEvaluador";
		}
		uc.save(evaluador);
		return "InscripcionEvaluador/evaluadorCreado";
	}

	/*
	 * Se usa request param para que la vista espere una instancia de la clase docente
	 * la vista recibe con el metodo post para mostrar los valores.
	 */
	@RequestMapping(value="/evaluadorCreado", method = RequestMethod.POST)
	public String creado(@RequestParam("Evaluadores") Evaluador evaluador) {
		return "InscripcionEvaluador/evaluadorCreado";
	}



}