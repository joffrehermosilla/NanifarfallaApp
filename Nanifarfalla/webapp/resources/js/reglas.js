




function cargarlogeo(inicioregistro) {

	var span = $("#logaparece"); //
	var span1 = $("#loginRegister");
	var span2 = $("#logoutaparece");



	$.ajax({
		method: 'GET',
		data: { "inicioregistro": inicioregistro }, //
		url: "admin/index",
		success: function(data) {


			if (inicioregistro == "true") {
				console.warn(inicioregistro + " " + ' Sesion Cerrada Cargado desde javscript debe aparecer true');
				span.empty();
				span1.empty();


				$('#logaparece').append('<span class="logaparece" id="logaparece" ><a class="big-link" href="formLogin">' + 'Sign in | ' + '</a></span>');



				$('#loginRegister').append('<span1 class="loginRegister" id="loginRegister" ><a class="big-link2" href="usuarios/create">' + ' Register' + '</a></span1>');







			} else {

				span.empty();
				span1.empty();
				span2.empty();
				console.log(inicioregistro + " " + ' Inicio de Sesion Cargado desde javscript debe aparecer false');


				switch (inicioregistro) {
					case "true":
						$('#logoutaparece').append('<span2 class="logoutaparece" id="logoutaparece" ><a class="big-link3" href="admin/logout">' + 'Logout | ' + '</a></span2>');

						break;
					case "false":
						$('#logaparece').append('<span class="logaparece" id="logaparece" ><a class="big-link" href="formLogin">' + 'Sign in | ' + '</a></span>');


						break;

					default:
						$('#logoutaparece').append('<span2 class="logoutaparece" id="logoutaparece" ><a class="big-link3" href="admin/logout">' + 'Login | ' + '</a></span2>');

				}




				$('#loginRegister').append('<span1 class="loginRegister" id="loginRegister" ><a class="big-link2" href="usuarios/create">' + ' Register' + '</a></span1>');


			}







			$('.big-link').click(function(e) {
				$('#logaparece').append('<a class="link" href="formLogin">' + 'Sign in ' + '</a>');
				span.empty();
			});

			$('#logaparece').on('click', '.link', function(e) {
				alert("clicked");
				$('#logaparece').append('<a class="link" href="formLogin">' + 'Sign in ' + '</a>');

			});


			$('.big-link2').click(function(e) {
				$('#loginRegister').append('<a class="link2" href="usuarios/create">' + 'Register' + '</a>');
				span1.empty();
			});

			$('#loginRegister').on('click', '.link2', function(e) {
				alert("clicked");
				$('#loginRegister').append('<a class="link2" href="usuarios/create">' + ' Register' + '</a>');

			});


			$('.big-link3').click(function(e) {
				$('#logoutaparece').append('<a class="link3" href="admin/logout">' + 'Login' + '</a>');
				span2.empty();
			});

			$('#logoutaparece').on('click', '.link3', function(e) {
				alert("clicked");
				$('#logoutaparece').append('<a class="link3" href="admin/logout">' + 'Login' + '</a>');

			});




		}



	});
}








