package com.practica.controller;




import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.practica.model.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import com.practica.model.Alumno;
import com.practica.model.Empresa;
import com.practica.repo.AlumnoRepo;
import com.practica.repo.EmpresaRepo;
import com.practica.repo.RegionRepo;



@Controller
@RequestMapping("inscripcion")
public class inscripcionController {

	@Autowired
  private AlumnoRepo alumnorepo;
	@Autowired
  private EmpresaRepo empresarepo;

  private Alumno alumnoIngresado;
  private Empresa empresaIngresado;


	@GetMapping("")
	public String inicioInscripcion(Alumno alumno){

		return "inscripcion/inscripcionInicio";
	}

	//Comprueba que el run ingresado sea exista o no en la base de datos
	@PostMapping("/comprobando")
	public String comprabandoExistenciaAlumno(Alumno alumno){
		String direccion;
		if(alumnorepo.existsByRun(alumno.getRun())){
			direccion = "redirect:/inscripcion/alumno";
			alumnoIngresado = alumnorepo.findByRun(alumno.getRun());
		}else{
			direccion = "redirect:/inscripcion/ingresarAlumno";
			alumnoIngresado = alumno;
		}
		return direccion;
	}

	@GetMapping("/alumno")
	public String infoAlumno(Model model){
		String direccion;
		if(alumnoIngresado.getId() != null){
			model.addAttribute("alumno", alumnoIngresado);
			direccion = "inscripcion/infoAlumno";
		}else{
			direccion = "redirect:/";
		}
		return direccion;
	}

	//Genera el formulario para crear un nuevo alumno
  @GetMapping("/ingresarAlumno")
  public String crearNuevoAlumno(Alumno alumno, Model model){
		model.addAttribute("alumno", alumnoIngresado);
    return "inscripcion/formInscripcion";
  }

  @PostMapping("/validandoAlumno")
  public String validacionAlumno(@Valid Alumno alumno, BindingResult bindingResult){

		System.out.println(alumno);
    //Verifica que los datos que se ingresaron sigan las restricciones
    //de el objeto en el paquete model.
    if (bindingResult.hasErrors()){
			System.out.println("Error al ingresar datos");
      return "inscripcion/formInscripcion";
    }
    alumnorepo.save(alumno);
    alumnoIngresado = alumno;
    return "redirect:/inscripcion/alumno";
  }

  @GetMapping("/empresa")
  public String inscripcionEmpresa(Empresa empresa, Model model){
		List<Empresa> nombreEmpresas =  new ArrayList<>();

		System.out.println(nombreEmpresas);



    return "formInscripcionEmpresa";
  }

  @PostMapping("/validandoEmpresa")
  public String validacionEmpresa(@Valid Empresa empresa, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
      return "formInscripcionEmpresa";
    }

    return "results";
  }




	//HttpServletRequest Donde se guarda los datos del ajax

	//@ResponseBody : informará a Spring que intenta convertir su valor de retorno y escribirlo en la respuesta http automáticamente.
	//@RequestBody : informará a Spring que intente convertir el contenido del cuerpo de la solicitud entrante en su objeto de parámetro sobre la marcha.

	//Funcion que retorna un Objeto Alumno Para el autocompletado de los campos del formulario
	@RequestMapping(method = RequestMethod.POST, value = "/conseguirAlumno", produces="application/json")
	public @ResponseBody Alumno conseguirAlumno(HttpServletRequest request){

		String run = request.getParameter("dato"); //Asigno el valor entregado por el ajax
		Alumno alumnoAux = new Alumno();

		if (alumnorepo.existsByRun(run)){
			alumnoAux = alumnorepo.findByRun(run);
		}
		return alumnoAux;
	}


}
