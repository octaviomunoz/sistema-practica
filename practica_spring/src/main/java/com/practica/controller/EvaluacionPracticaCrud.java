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

import com.practica.repo.EvaluacionPracticaRepo;
import com.practica.model.EvaluacionPractica;

@Controller		//Indica que es una clase controlador
@RequestMapping("/CrudEvaluacionPractica")	//Indica que el archivo raiz sera localhost:8080/CrudEvaluacionPractica
public class EvaluacionPracticaCrud {

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private EvaluacionPracticaRepo  uc;

	/*Se ejecuta para listar las evaluaciones de practica.
	 * findAll() leera todos los registros de la tabla "evaluacion practica"
	 * El resultado se almacena en el ModelMap
	 * Modelmap es una clase que se utiliza para mandarle los valores a las vistas.
	 * En este caso se los manda a evaluacionempresas y esta guarda los datos llamados de uc.finall()
	 * Listaempresa es lo que retornara en formato .html
	 */
	@RequestMapping(value="/ListaEvaPractica", method = RequestMethod.GET)
	public String ListaPractica(ModelMap mp) {
		mp.put("Evaluacionpracticas", uc.findAll() );
		return "CrudEvaluacionPractica/ListaEvaPracticas";
	}

	/*
	 * Aca este metodo nos manda a la vista nuevoDoc.html con los valores de evaluacion de practica sin inicializar
	 * aca el put guarda el valor en la variable y el return recibe esa variable del ModelMap
	 */
	@RequestMapping(value="/nuevoEvaPractica", method=RequestMethod.GET)
	public String nuevo(EvaluacionPractica evaluacionPractica) {
		System.out.println("Estoy funcionando");
		return "CrudEvaluacionPractica/nuevoEvaPractica";
	}

	/*
	 * Aca el metodo antes de agregar a la bd verifica si los valores que se le pasan son los correctos
	 * para eso se usa @valid que comprobara min max de caracteres y todas las restricciones ya existentes
	 * use bindingresult que es un metodo que si hay errores nos devolvera a la vista
	 * y si no hay errores guardara los datos en la base de datos
	 * usando el uc.save
	 */
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid EvaluacionPractica evaluacionPractica, BindingResult bindingResult, ModelMap mp) {
		System.out.println(evaluacionPractica);
		if(bindingResult.hasErrors()) {
			return "CrudEvaluacionPractica/nuevoEvaPractica";
		}
		uc.save(evaluacionPractica);
		return "CrudEvaluacionPractica/EvaPracticaCreado";
	}

	/*
	 * Se usa request param para que la vista espere una instancia de la clase evaluacion practica
	 * la vista recibe con el metodo post para mostrar los valores.
	 */
	@RequestMapping(value="/EvaPracticaCreado", method = RequestMethod.POST)
	public String creado(@RequestParam("Evaluacionpracticas") EvaluacionPractica evaluacionPractica) {
		return "EvaluacionPracticaRepo/EvaPracticaCreado";
	}

}