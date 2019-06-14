/*$('#region').change(
  function() {
    $.getJSON("http://localhost:8080/alumno/comunas"),{
      idRegion : $(this).val(),
      ajax : 'true',
    }, function(data){
      console.log("hola");
      console.log(data);
      var html = '<option value=""> -- hola -- </option>';
      var len = data.length;
      for (var i=0; i<len ; i++){
        html += '<option value="' + data[i].id + '">'
                + data[i].nombre + '</option>';
      }
      html += '</option>';
      $('#comuna').html(html);
    };
  });*/


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
      }
    })
  };
