

// Variable Javascript que guardar el contextPath para formar la URL a la cual haremos la peticion


function buscarProvincias(idPais) {

	var select = $("#idProvincia"); // Referencia al <select> de ciudades.
	$.ajax({
		method: 'GET',
		data: { "idPais": idPais }, // Aqui mandamos al controlador el idPais seleccionado
		url: "buscarPorPais?idPais =" + idPais,
		success: function(data) {
			select.empty(); // Vaciamos el <select> de ciudades.	
			select.append('<option value=""></option>');
			select.prop('selectedIndex', 0);
			$.each(data, function(key, entry) {
				select.append($('<option></option>').attr('value', entry.codigo_provincia).text(entry.nombre_provincia));
			});
		}
	});
}

function buscarCiudades(idProvincia) {

	var select = $("#idCiudad"); // Referencia al <select> de ciudades.
	$.ajax({
		method: 'GET',
		data: { "idProvincia": idProvincia }, // Aqui mandamos al controlador el idPais seleccionado
		url: "buscarPorProvincia?idProvincia =" + idProvincia,
		success: function(data) {
			select.empty(); // Vaciamos el <select> de ciudades.	
			select.append('<option value=""></option>');
			select.prop('selectedIndex', 0);
			$.each(data, function(key, entry) {
				select.append($('<option></option>').attr('value', entry.codigo_ciudad).text(entry.nombre_ciudad));
			});
		}
	});
}

function buscarDistritos(idCiudad) {

	var select = $("#idDistrito"); // Referencia al <select> de ciudades.
	$.ajax({
		method: 'GET',
		data: { "idCiudad": idCiudad }, // Aqui mandamos al controlador el idPais seleccionado
		url: "buscarPorCiudad?idCiudad =" + idCiudad,
		success: function(data) {
			select.empty(); // Vaciamos el <select> de ciudades.	
			select.append('<option value=""></option>');
			select.prop('selectedIndex', 0);
			$.each(data, function(key, entry) {
				select.append($('<option></option>').attr('value', entry.codigo_distrito).text(entry.nombre_distrito));
			});
		}
	});
}




 $('#email').click(function() {
    $.ajax({
        type: 'GET',
        url : "buscarPorMail?email =" + email,
        dataType: "json",
        data : {
            email : document.getElementById('email').value
        },
        success:function(){
            $('#emailError').html( "usuario ya existe" );
        }
    });
  });





function checkExist(){
                var xmlhttp = new XMLHttpRequest();
                var username = document.forms["regF"]["email                                                                                                                                                      "].value;
                var url = "buscarPorEmail?email =" + email;
                xmlhttp.onreadystatechange = function(){
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                        if(xmlhttp.responseText == "\n\n\n\n\nUser already exists")
                            document.getElementById("isE").style.color = "red";
                        else
                            document.getElementById("isE").style.color = "green";
                        document.getElementById("isE").innerHTML = xmlhttp.responseText;
                    }
                    
                };
                try{
                xmlhttp.open("GET",url,true);
                xmlhttp.send();
            }catch(e){alert("unable to connect to server");
            }






}


$('#email').on('blur', function(){
 	var email = $('#email').val();
 	if (email == '') {
 		email_state = false;
 		return;
 	}
 	$.ajax({
      url: "buscarPorEmail?email =" + email,
      type: 'GET',
      data: {
      	'email_check' : 1,
      	'email' : email,
      },
      success: function(response){
      	if (response == 'taken' ) {
          email_state = false;
          $('#email').parent().removeClass();
          $('#email').parent().addClass("form_error");
          $('#email').siblings("span").text('Sorry... Email already taken');
      	}else if (response == 'not_taken') {
      	  email_state = true;
      	  $('#email').parent().removeClass();
      	  $('#email').parent().addClass("form_success");
      	  $('#email').siblings("span").text('Email available');
      	}
      }
 	});
 });












