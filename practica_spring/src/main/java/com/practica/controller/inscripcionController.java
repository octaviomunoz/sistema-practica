package com.practica.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import com.practica.model.Alumno;
import com.practica.model.Empresa;
import com.practica.repo.AlumnoRepo;



@Controller
@RequestMapping("inscripcion")
public class inscripcionController {

  private final AlumnoRepo repository;
  private Alumno alumnoIngresado;
  private Empresa empresaIngresado;

  public inscripcionController(AlumnoRepo repository){
    this.repository = repository;
  }

  //
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
      return "formInscripcion";
    }
    alumnoIngresado = alumno;
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


}
