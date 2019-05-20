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

import com.practica.repo.PracticaCrud;
import com.practica.model.Practica;

@Controller		//Indica que es una clase controlador
@RequestMapping("/CrudPractica")	//Indica que el archivo raiz sera localhost:8080/CrudDocente
public class ControPracticaCrud {

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private PracticaCrud uc;

	/*Se ejecuta para listar los docentes.
	 * findAll() leera todos los registros de la tabla "docentes"
	 * El resultado se almacena en el ModelMap
	 * Modelmap es una clase que se utiliza para mandarle los valores a las vistas.
	 * En este caso se los manda a docentes y esta guarda los datos llamados de uc.finall()
	 * ListaDocentes es lo que retornara en formato .html
	 */
	@RequestMapping(value="/ListaPractica", method = RequestMethod.GET)
	public String ListaPracticas(ModelMap mp) {
		mp.put("Practicas", uc.findAll() );
		return "CrudPractica/ListaPracticas";
	}

	/*
	 * Aca este metodo nos manda a la vista nuevoDoc.html con los valores de docente sin inicializar
	 * aca el put guarda el valor en la variable y el return recibe esa variable del ModelMap
	 */
	@RequestMapping(value="/nuevoPra", method=RequestMethod.GET)
	public String nuevo(Practica practica) {
		System.out.println("Estoy funcionando");
		return "CrudPractica/nuevoPra";
	}

	/*
	 * Aca el metodo antes de agregar a la bd verifica si los valores que se le pasan son los correctos
	 * para eso se usa @valid que comprobara min max de caracteres y todas las restricciones ya existentes
	 * use bindingresult que es un metodo que si hay errores nos devolvera a la vista
	 * y si no hay errores guardara los datos en la base de datos
	 * usando el uc.save
	 */
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid Practica practica, BindingResult bindingResult, ModelMap mp) {
		System.out.println(practica);
		if(bindingResult.hasErrors()) {
			System.out.println("hola soy un error");
			return "CrudPractica/nuevoPra";
		}
		uc.save(practica);
		return "CrudPractica/PraCreado";
	}

	/*
	 * Se usa request param para que la vista espere una instancia de la clase docente
	 * la vista recibe con el metodo post para mostrar los valores.
	 */
	@RequestMapping(value="/PraCreado", method = RequestMethod.POST)
	public String creado(@RequestParam("Practicas") Practica practica) {
		return "CrudPractica/PraCreado";
	}
	/*
	 * Para Elimnar!
	 */
	@RequestMapping(value="/borrar/{idPractica}", method = RequestMethod.GET)
	public String borrar(@PathVariable("idPractica") Long idPractica) {
		System.out.println(idPractica);
		uc.deleteById(idPractica);
		return "redirect:/CrudPractica/ListaPractica";
	}

	/*
	 * Para Editar y actualizar!
	 */

	@RequestMapping(value="/editarPra/{idPractica}", method = RequestMethod.GET)
	public String editar(@PathVariable("idPractica") Long idPractica, ModelMap mp) {
		mp.put("practica",uc.findById(idPractica));
		return "CrudPractica/editarPra";
	}

	@RequestMapping(value="/actualizarPra", method=RequestMethod.POST)
	public String actualizar(@Valid Practica practica, BindingResult bindingResult, ModelMap mp) {
		if(bindingResult.hasErrors()) {
			mp.put("practica",practica);
		return "CrudPractica/editarPra/"+practica.getIdPractica().toString();
		}
		uc.save(practica);
		/*Docente doc = uc.findOne();
		doc.setNombreDoc(docente.getNombreDoc());
		doc.setRunDoc(docente.getRunDoc());
		doc.setEmailDoc(docente.getEmailDoc());
		doc.setDirector(doc.getDirector());
		uc.save(doc);
		mp.put("docente", doc);*/
		return "redirect:/CrudPractica/ListaPractica";
	}

}
