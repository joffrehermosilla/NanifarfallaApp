
 
	// Variable Javascript que guardar el contextPath para formar la URL a la cual haremos la peticion
 
	
	function buscarProvincias(idPais) {
 
		var select = $("#idProvincia"); // Referencia al <select> de ciudades.
		$.ajax({
		   method:'GET',
	 		data: {"idPais": idPais}, // Aqui mandamos al controlador el idPais seleccionado
		    url: "buscarPorPais?idPais ="+idPais,
		    success : function(data) {
		   	select.empty(); // Vaciamos el <select> de ciudades.	
		   	select.append('<option value=""></option>');
		   	select.prop('selectedIndex', 0);
		   	$.each(data, function (key, entry) {
		   		select.append($('<option></option>').attr('value', entry.codigo_provincia).text(entry.nombre_provincia));
		   	});
		   }
	  });
	}

	function buscarCiudades(idProvincia) {
		 
		var select = $("#idCiudad"); // Referencia al <select> de ciudades.
		$.ajax({
		   method:'GET',
	 		data: {"idProvincia": idProvincia}, // Aqui mandamos al controlador el idPais seleccionado
		    url: "buscarPorProvincia?idProvincia ="+idProvincia,
		    success : function(data) {
		   	select.empty(); // Vaciamos el <select> de ciudades.	
		   	select.append('<option value=""></option>');
		   	select.prop('selectedIndex', 0);
		   	$.each(data, function (key, entry) {
		   		select.append($('<option></option>').attr('value', entry.codigo_ciudad).text(entry.nombre_ciudad));
		   	});
		   }
	  });
	}
	
	function buscarDistritos(idCiudad) {
		 
		var select = $("#idDistrito"); // Referencia al <select> de ciudades.
		$.ajax({
		   method:'GET',
	 		data: {"idCiudad": idCiudad}, // Aqui mandamos al controlador el idPais seleccionado
		    url: "buscarPorCiudad?idCiudad ="+idCiudad,
		    success : function(data) {
		   	select.empty(); // Vaciamos el <select> de ciudades.	
		   	select.append('<option value=""></option>');
		   	select.prop('selectedIndex', 0);
		   	$.each(data, function (key, entry) {
		   		select.append($('<option></option>').attr('value', entry.codigo_distrito).text(entry.nombre_distrito));
		   	});
		   }
	  });
	}
	
	