// Javascript que permitirá cambiar el contenido  de la pagina JSP
	
	$(function(){
	switch (menux) {

	case 'Estado Usuario':
		$('#estadousuario').addClass('active');
			$('#estadousuario').load('estadousuario/listEstadoUsuario.jsp');
		break;
	case 'Elaboracion Producto"':
		$('#elaboracionproducto').addClass('active');
			$('#elaboracionproducto').load('elaboracionproducto/listElaboracionProducto.jsp');
		break;
	default:
		$('#Home').addClass('active');
		break;
	}
	
	});
	
