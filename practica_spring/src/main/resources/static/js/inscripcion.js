
//Funcion que busca un alumno con su rut y autocompleta los demas
//campos con los datos seleccionados.
function BuscarAlumno(){
  var dato = $("#Run").val();
  var json = { "RUN" : dato};
  $.ajax({
    type: "POST",
    url: "/inscripcion/conseguirAlumno",
    data: {dato : dato},
    success: function(result){
      console.log(result);
      if (result.id != null){
        $("#Nombre").val(result.nombre);
        $("#ApellidoPaterno").val(result.apellido_paterno);
        $("#ApellidoMaterno").val(result.apellido_materno);
      }
    }
  });
}
