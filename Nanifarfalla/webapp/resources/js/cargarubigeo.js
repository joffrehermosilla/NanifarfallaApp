
 
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
