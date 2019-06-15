function direccionEmpresa(x){
  console.log(x);
  document.getElementById('dirEmpresa').innerText=x;
};

function agregandoSelectEmpresa(result){
  var html = '<option disabled="disabled" selected="selected"> Empresa </option>';
  if (result != null){
    var len = result.length;
    for (var i=0; i<len ; i++){
      html += '<option th:value="'+ result[i] + '" value="'+result[i].direccion+'">'
              + result[i].nombre + '</option>';
    }
    html += '</option>';
  }
  $('#empresa').html(html);
};


  function cargarComunas(){
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
        direccionEmpresa('');
        agregandoSelectEmpresa(null);
      }
    })
  };


  function cargarEmpresas(){
    var dato = $("#comuna").val();
    var json = {"idComuna" : dato};
    $.ajax({
      type: "GET",
      url: "/alumno/empresas",
      data: json,
      datatype: 'JSON',
      success: function(result){
        agregandoSelectEmpresa(result)
      }
    })
  };



  function cambioRegion(){

  };
