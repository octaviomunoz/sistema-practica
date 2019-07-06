package com.practica.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practica.repo.DocenteCrud;
import com.practica.repo.PracticaCrud;
import com.practica.repo.UserRepo;
import com.practica.util.*;
import com.practica.model.Comuna;
import com.practica.model.Docente;
import com.practica.model.Evaluacionpractica;
import com.practica.model.Practica;
import com.practica.model.User;


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
		if(permitirGuardaDocente(docente)){
			 docenterepo.save(docente);
		}
		return "redirect:/CrudDocente/ListaDocente";
	}

 //Metodo que veifica si se puede guardar o no un docente de manera que el run se unico
	public boolean permitirGuardaDocente(Docente docente){
    boolean permitir = false;

    return permitir;
  }


	public String informesRegion(){

		return "alumnosRegion";
	}

}
