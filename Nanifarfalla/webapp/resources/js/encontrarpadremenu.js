$(document).ready(function() {
	$('.myFormPadre #comboboxMenu').on('change', function() {

		var id = $('.myForm14 select#comboboxMenu option:selected').val();
		alert(id);
		$.ajax({
			type: 'GET',
			url: 'cargarPadre/' + id + '.html',

			success: function(result) {

				var result = JSON.parse(result);
				var d = '';
				for (var i = 0; i < result.length; i++) {
					d += '<option value="' + result[i].id + '">' + result[i].nombre + '</option>'
				}
				$('#comboboxProvincia').html(d);
			}
		});

	});
	
});
	