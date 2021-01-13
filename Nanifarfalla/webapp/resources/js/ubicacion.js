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
					$('comboboxDepartamento').html(d);
				}
			});

	});
});