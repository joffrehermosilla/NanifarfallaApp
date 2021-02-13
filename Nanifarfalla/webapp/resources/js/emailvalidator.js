var password = [];
var password2 = [];

var email = [];
var verifica = [];


function buscarPorCorreo(email) {

	var span = $("#form_error"); // Referencia al <select> de ciudades.
	$.ajax({
		method: 'GET',
		data: { "email": email }, // Aqui mandamos al controlador el idPais seleccionado
		url: "buscarPorCorreo?email =" + email,
		success: function(data) {
			span.empty();




			if (data == "true") {
	span.empty();
				$('#form_error').append('<span  class=" incorrectMsg alert alert-danger " role="alert" id= "email" >' + 'Email Already Exist change another one' + '</span>');

			} else {
	span.empty();
				$('#form_error').append('<span  class="alert alert-success" role="alert" id= "email" >' + 'Email doesnt exists...continue ' + '</span>');
			}



		}
	});
}



$(document).ready(function() {
	password = $('#password');
	password2 = $('#password-verify');
	email = $('#email');


	var ruleValidator = function() {
		var pswd = $(this).val();
		//gets what is being input in the field and sets as variable

		// character
		if (pswd.match(/[a-z0-9_\.][a-z0-9][@][a-z]/)) {
			$('#specialx').removeClass('invalid').addClass('valid');
			console.log('log: ' + pswd);
		} else {
			$('#specialx').removeClass('valid').addClass('invalid');
		}

	}



	email.focus(function() {
		// (triggers whenever the password field is selected by the user)
		$('.email_info').fadeIn('low');

	});


	email.blur(function() {
		// (triggers whenever the password field is unselected)
		$('.email_info').fadeOut('low');
	});
	$('.email').on('blur', function(e) {
		e.preventDefault();
		if (data == "true") {
			$('.incorrectMsg').show();
			email.addClass('shake').addClass('invalidPass');
			email.blur(function() {
				// (triggers whenever the password field is unselected)
				email.trigger('reset');
				$('.incorrectMsg').hide();
				email.removeClass('shake').removeClass('invalidPass');
			});
		} else {
			$('.incorrectMsg').hide();
		}

	});


	$('.email_show').click(function() {
		console.log('click');
		email.toggleClass('email_show');

		if (email.hasClass('showPswd')) {
			email.attr('type', 'text');
			console.log("text");
			$('.email_show').html('Cambia Correo');
		} else {
			console.log("pswd");
			email.attr('type', 'password');
			$('.email_show').html('Show correo');
		}
	});

	email.keyup(ruleValidator);
});












