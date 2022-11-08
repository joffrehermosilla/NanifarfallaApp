$(document).ready(function() {
	$('.myForm22 #crearPedido').on('click', function() {


		$.ajax({
			type: 'POST',
			url: 'clientetienepedido/save' + '.html',

			success: function(result) {

				var result = JSON.parse(result);
				var d = '';

				d += '<div class="alert alert-success" role="alert" align="center">${mensaje} GUARDADO EXITOSO</div>'


				$('#mensajejavascriptajax').html(d);
			}
		});

	});



});