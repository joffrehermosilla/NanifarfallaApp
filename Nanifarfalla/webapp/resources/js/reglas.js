




function cargarlogeo(inicioregistro) {

	var span = $("#logaparece"); //
	var span1 = $("#loginRegister");
	var span2 = $("#logoutaparece");

	$.ajax({
		method: 'GET',
		data: { "inicioregistro": inicioregistro }, //
		url: "admin/index",
		success: function(data) {
			span.empty();
			span2.empty();

			if (inicioregistro == "true") {



				$('#logoutaparece').append('<span2 class="logoutaparece" id="logoutaparece" ><a class="big-link3" href="admin/logout">' + 'Salida ' + '</a></span2>');

			} else {
				span.empty();
				span1.empty();

				span2.empty();

				$('#logaparece').append('<span class="logaparece" id="logaparece" ><a class="big-link" href="formLogin">' + 'Sign in ' + '</a></span>');



				$('#loginRegister').append('<span1 class="loginRegister" id="loginRegister" ><a class="big-link2" href="usuarios/create">' + 'Register' + '</a></span1>');
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
				$('#loginRegister').append('<a class="link2" href="usuarios/create">' + 'Register' + '</a>');

			});


			$('.big-link3').click(function(e) {
				$('#logoutaparece').append('<a class="link3" href="admin/logout">' + 'Salida' + '</a>');
				span2.empty();
			});

			$('#logoutaparece').on('click', '.link3', function(e) {
				alert("clicked");
				$('#logoutaparece').append('<a class="link3" href="admin/logout">' + 'Salida' + '</a>');

			});




		}



	});
}








