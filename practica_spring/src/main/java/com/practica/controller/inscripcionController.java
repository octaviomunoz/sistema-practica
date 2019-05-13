package com.practica.controller;




import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
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
	@Autowired
  private RegionRepo regionrepo;

  private Alumno alumnoIngresado;
  private Empresa empresaIngresado;
  private Region regiones;


  @GetMapping("/alumno")
  public String inscripcionAlumno(Alumno alumno){

    return "formInscripcion";
  }

  @PostMapping("/validandoAlumno")
  public String validacionAlumno(@Valid Alumno alumno, BindingResult bindingResult){

    //System.out.println( alumno.toString());

    //Verifica que los datos que se ingresaron sigan las restricciones
    //de el objeto en el paquete model.
    if (bindingResult.hasErrors()){
			System.out.println("Error al ingresar datos");
      return "formInscripcion";
    }
    alumnorepo.save(alumno);
    alumnoIngresado = alumno;

		regiones = regionrepo.getOne(1L);
		System.out.println(regiones.toString());
    return "redirect:/inscripcion/empresa";
  }

  @GetMapping("/empresa")
  public String inscripcionEmpresa(Empresa empresa){
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
	//HttpServletResponse Donde se envian los datos al ajax
  
  	//@ResponseBody : informará a Spring que intenta convertir su valor de retorno y escribirlo en la respuesta http automáticamente.
  	//@RequestBody : informará a Spring que intente convertir el contenido del cuerpo de la solicitud entrante en su objeto de parámetro sobre la marcha.
	@RequestMapping(method = RequestMethod.POST, value = "/conseguirAlumno", produces="application/json")
	public @ResponseBody Alumno conseguirAlumno(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getParameter("dato") + alumnorepo.existsByRun("dato"));
		String run = request.getParameter("dato");
		Alumno alumnoAux = new Alumno();
		
		if (alumnorepo.existsByRun(run)){
			alumnoAux = alumnorepo.findByRun(run);
		}
		return alumnoAux;

	}

	/*@RequestMapping(value = "/myPage")
    public void myController(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String myItem = request.getParameter("item");

    ...

    response.getWriter().println(myItem + "bla bla bla");
    }*/

}
