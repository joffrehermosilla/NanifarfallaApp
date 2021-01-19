$(document).ready(function(){
	$('.myForm14 #comboboxPais').on('change', function(){

	    var codigo_pais= $('.myForm14 select#comboboxPais option:selected').val();
	        alert(codigo_pais);
			$.ajax({
				type:'GET',
				url: 'cargarPais/'+ codigo_pais + '.html',
				
				success:function(result){
					
					var result = JSON.parse(result);
					var d = '';
					for(var i = 0; i< result.length; i++){
						d += '<option value="' + result[i].codigo_provincia + '">' + result[i].nombre_provincia + '</option>'
					}
					$('#comboboxProvincia').html(d);
				}
			});

	});
	
	$('.myForm15 #comboboxProvincia').on('change', function(){

	    var codigo_provincia= $('.myForm15 select#comboboxProvincia option:selected').val();
	        alert(codigo_provincia);
			$.ajax({
				type:'GET',
				url: 'cargarProvincia/'+ codigo_provincia + '.html',
				
				success:function(result){
					
					var result = JSON.parse(result);
					var d = '';
					for(var i = 0; i< result.length; i++){
						d += '<option value="' + result[i].codigo_ciudad + '">' + result[i].nombre_ciudad + '</option>'
					}
					$('#comboboxCiudad').html(d);
				}
			});

	});
	
	$('.myForm16 #comboboxCiudad').on('change', function(){

	    var codigo_ciudad= $('.myForm16 select#comboboxCiudad option:selected').val();
	        alert(codigo_ciudad);
			$.ajax({
				type:'GET',
				url: 'cargarCiudad/'+ codigo_ciudad + '.html',
				
				success:function(result){
					
					var result = JSON.parse(result);
					var d = '';
					for(var i = 0; i< result.length; i++){
						d += '<option value="' + result[i].codigo_distrito + '">' + result[i].nombre_distrito + '</option>'
					}
					$('#comboboxDistrito').html(d);
				}
			});

	});
	
	
});