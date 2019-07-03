package com.practica.controller;

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

import com.practica.repo.EvaluadorRepo;
import com.practica.repo.PracticaCrud;
import com.practica.repo.UserRepo;
import com.practica.repo.AlumnoRepo;

import com.practica.util.*;
import com.practica.model.Docente;
import com.practica.model.Evaluador;
import com.practica.model.Practica;
import com.practica.model.User;
import com.practica.model.Alumno;

@Controller		//Indica que es una clase controlador
@RequestMapping("/InscripcionEvaluador")	//Indica que el archivo raiz sera localhost:8080/CrudDocente
public class EvaluadorCrud {

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private EvaluadorRepo uc;

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private PracticaCrud pc;

	/////////

	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private UserRepo userrepo;


	@Autowired	//Es un atributo que se encarga de crea en caso de ser necesario.
	private Sistema sistema;
	/////////
	@Autowired
	private AlumnoRepo alumnorepo;


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




	///////////////////////////
	@RequestMapping(value="/ListaPracticaAlumno", method = RequestMethod.GET)
	public String Listapracticasdocente(@RequestParam(name="page", required=false, defaultValue="1") String page, Model mp) {
		 Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, 10);
		 User user = userrepo.findByUsername(sistema.RecuperarUsuarioLogeado());
		 Evaluador evaluador = uc.findByUsuario(user);
		 //Page<Practica> docen_pra = pc.findAll(pageable);
		 Page<Practica> eva_pra = pc.findByEvaluador(evaluador, pageable);
// pag 2

		 mp.addAttribute("usuario", user);
		 mp.addAttribute("PagePracticas", eva_pra);
		 mp.addAttribute("numPaginas", eva_pra.getTotalPages());
	     return "InscripcionEvaluador/ListaPracticasAlumnos";
	}


	////////////////////////////



	/*
	 * Aca este metodo nos manda a la vista nuevoDoc.html con los valores de docente sin inicializar
	 * aca el put guarda el valor en la variable y el return recibe esa variable del ModelMap
	 */
	@RequestMapping(value="/nuevoEvaluador", method=RequestMethod.GET)
	public String nuevo(Evaluador evaluador, User user) {
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
	public String crear(Evaluador evaluador, User user) {
		String direccion = "redirect:/";
    User usuario = sistema.GuardarUsuario(user, Roles.ROLE_EMPRESA);
    System.out.println(user);
    if (usuario != null){
        evaluador.setUsuario(usuario);
        uc.save(evaluador);
    }else if(userrepo.existsById(user.getId())){
          evaluador.setUsuario(userrepo.getOne(user.getId()));
          uc.save(evaluador);
    }else {
        direccion = "/InscripcionEvaluador/nuevoEvaluador";
    }
    return direccion;
	}

	/*
	 * Se usa request param para que la vista espere una instancia de la clase docente
	 * la vista recibe con el metodo post para mostrar los valores.
	 */
	@RequestMapping(value="/evaluadorCreado", method = RequestMethod.POST)
	public String creado(@RequestParam("Evaluadores") Evaluador evaluador) {
		return "InscripcionEvaluador/evaluadorCreado";
	}

	@RequestMapping(value="/buscarAlumno", method = RequestMethod.GET)
	public String buscandoAlumno(Alumno alumno){
		return "InscripcionEvaluador/seleccionAlumno";
	}

	@RequestMapping(value = "/guardandoAlumno", method = RequestMethod.POST)
	public String guardandoAlumno(Alumno alumno){
		Evaluador evaluador = uc.findByUsuario(userrepo.findByUsername(sistema.RecuperarUsuarioLogeado()));
		System.out.println(alumno);
		Practica practica = alumnorepo.getOne(alumno.getId()).getPractica();
		practica.setEvaluador(evaluador);
		pc.save(practica);  

		return "redirect:/InscripcionEvaluador/ListaPracticaAlumno";
	}





}
