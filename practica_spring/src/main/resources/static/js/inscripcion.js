
//Funcion que busca un alumno con su rut y autocompleta los demas
//campos con los datos seleccionados.
function BuscarAlumno(){
  var dato = $("#Run").val();
  var json = { "RUN" : dato};
  $.ajax({
    type: "GET",
    url: "/alumno/conseguirAlumno",
    data: json,
    dataType: 'JSON',
    success: function(result){
      console.log(result);
      if (result.id > 0){
        $("#Id").val(result.id)
        $("#Nombre").val(result.nombre);
        $("#Apellido").val(result.apellido_paterno);
        $("#boton").removeAttr("disabled");
      }
      if(result.id == -1){
        $("#Id").val('')
        $("#Nombre").val('');
        $("#Apellido").val('');
        $("#boton").attr("disabled", 'disabled');
      }
    }
  });
}

/*function cargarComunas(){
  var dato = $("#region").val();
  var json = {"idRegion": dato};
  $.ajax({
    type: "GET",
    url: "/alumno/comunas",
    data: json,
    dataType : 'JSON',
    success: function(result){
      var html = '<option disabled="disabled" selected="selected"> Comuna </option>';
      var len = result.length;
      for (var i=0; i<len ; i++){
        html += '<option value="' + result[i].id + '">'
                + result[i].nombre + '</option>';
      }
      html += '</option>';
      $('#comuna').html(html);
      agregandoSelectEmpresa(null);
    }
  })
};*/
