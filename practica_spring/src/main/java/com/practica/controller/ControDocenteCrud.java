package com.practica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practica.repo.DocenteCrud;
import com.practica.repo.PracticaCrud;
import com.practica.model.Comuna;
import com.practica.model.Docente;
import com.practica.model.Practica;


@Controller		//Indica que es una clase controlador
@RequestMapping("/CrudDocente")	//Indica que el archivo raiz sera localhost:8080/CrudDocente
public class ControDocenteCrud {

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private DocenteCrud uc;
	

	/*Se ejecuta para listar los docentes.
	 * findAll() leera todos los registros de la tabla "docentes"
	 * El resultado se almacena en el ModelMap
	 * Modelmap es una clase que se utiliza para mandarle los valores a las vistas.
	 * En este caso se los manda a docentes y esta guarda los datos llamados de uc.finall()
	 * ListaDocentes es lo que retornara en formato .html
	 */
	@RequestMapping(value="/ListaDocente", method = RequestMethod.GET)
	public String ListaDocentes(@RequestParam(name="page", required=false, defaultValue="1") String page, Model mp) {
		 Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
		 Page<Docente> docen_page = uc.findAll(pageable);
		 mp.addAttribute("PageDocentes", docen_page);
		 mp.addAttribute("numPaginas", docen_page.getTotalPages());
		
		return "CrudDocente/ListaDocentes";
	}
	
	@RequestMapping(value="/ListaDocenPra", method = RequestMethod.GET)
	public String ListaDocenPra(@RequestParam(name="page", required=false, defaultValue="1") String page, Model mp) {
		 Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
		 Page<Docente> docen_page = uc.findAll(pageable, );
		 mp.addAttribute("PageDocentes", docen_page);
		 mp.addAttribute("numPaginas", docen_page.getTotalPages());
		
		return "CrudDocente/ListaDocenPracs";
	}
	
	/*
	 * Aca este metodo nos manda a la vista nuevoDoc.html con los valores de docente sin inicializar
	 * aca el put guarda el valor en la variable y el return recibe esa variable del ModelMap
	 */
	@RequestMapping(value="/nuevoDoc", method=RequestMethod.GET)
	public String nuevo(Docente docente) {
		return "CrudDocente/nuevoDoc";
	}

	/*
	 * Aca el metodo antes de agregar a la bd verifica si los valores que se le pasan son los correctos
	 * para eso se usa @valid que comprobara min max de caracteres y todas las restricciones ya existentes
	 * use bindingresult que es un metodo que si hay errores nos devolvera a la vista
	 * y si no hay errores guardara los datos en la base de datos
	 * usando el uc.save
	 */
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid Docente docente, BindingResult bindingResult, ModelMap mp) {
		if(bindingResult.hasErrors()) {
			return "CrudDocente/nuevoDoc";
		}
		if(permitirGuardaDocente(docente)){
			uc.save(docente);
		}
		return "CrudDocente/DocCreado";
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
		uc.deleteById(idDoc);
		return "redirect:/CrudDocente/ListaDocente";
	}

	/*
	 * Para Editar y actualizar!
	 */

	@RequestMapping(value="/editarDoc/{idDoc}", method = RequestMethod.GET)
	public String editar(@PathVariable("idDoc") Long idDoc, ModelMap mp) {
		mp.put("docente",uc.findById(idDoc));
		return "CrudDocente/editarDoc";
	}

	@RequestMapping(value="/actualizarDoc", method=RequestMethod.POST)
	public String actualizar(@Valid Docente docente, BindingResult bindingResult, ModelMap mp) {
		if(bindingResult.hasErrors()) {
			mp.put("docente",docente);
		return "CrudDocente/editarDoc/"+docente.getIdDoc().toString();
		}
		if(permitirGuardaDocente(docente)){
			uc.save(docente);
		}
		return "redirect:/CrudDocente/ListaDocente";
	}

 //Metodo que veifica si se puede guardar o no un docente de manera que el run se unico
	public boolean permitirGuardaDocente(Docente docente){
    boolean permitir = false;
    
    return permitir;
  }
	
/*
	//Robado al octavio xd Deberia mostrar todas las practicas que contempla el docente no??!?
	 //Funcion que es llamada por una funcion ajax para conseguir las Comunas
	  //que pertenecen a la region que corresponde el id
	  @RequestMapping(value="/practicas", method = RequestMethod.GET, produces="application/json")
	  public @ResponseBody List<Practica> listacomunas(@RequestParam(value = "idRegion", required = true) Long id_docente) {
	    List<Practica> practicas = null;
	    if (uc.existsById(id_docente)){
	      practicas = pc.findByDocente(uc.getOne(id_docente));
	    }
	    return practicas;
	  }
*/
}
