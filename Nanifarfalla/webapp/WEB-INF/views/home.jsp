
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<!-- Titulo -->
<title>Nanifarfalla | Bienvenido</title>

<spring:url value="/resources" var="urlPublic" />
<!-- Styles CSS -->
<jsp:include page="includes/link.jsp"></jsp:include>
<!-- Styles CSS -->
<jsp:include page="includes/script.jsp"></jsp:include>





</head>

<body>

	<!--  Primer header comprende telefono - información importante - Boton de contacto e Idioma -->

	<jsp:include page="includes/estadoymenu.jsp"></jsp:include>


	<!--  Segundo NAVBAR PERMITE LA BUSQUEDA Y SELECCIONAR EL LOGEO -->
	<jsp:include page="includes/logeoybusqueda.jsp"></jsp:include>

	<!--  Carrusel promocional  -->
	<jsp:include page="includes/carruselpromocional.jsp"></jsp:include>



	<!-- Generar Container -->
	<div class="container theme-showcase" role="main" align="left"
		style="position: center;">

		<!-- Busqueda principal lineas   -->
		<jsp:include page="includes/busquedaprincipal.jsp"></jsp:include>




		<!-- Busqueda principal lineas   -->
		<jsp:include page="includes/carruselemprendedores.jsp"></jsp:include>


		<!-- Comentarios tutorial tinajero   -->
		<jsp:include page="includes/blog.jsp"></jsp:include>



		<!-- Products grid (Trending products)-->
		<jsp:include page="includes/catalogo.jsp"></jsp:include>

		<!-- Banners-->
		<jsp:include page="includes/banerpublicitario.jsp"></jsp:include>



		<!-- Featured category (Hoodie)-->
		<jsp:include page="includes/aleatoriocatalogo.jsp"></jsp:include>


		<!-- Shop by brand-->
		<jsp:include page="includes/shopbybrand.jsp"></jsp:include>

		<!-- Blog + Instagram info cards-->
		<jsp:include page="includes/followme.jsp"></jsp:include>

		<!-- Toast: Added to Cart-->
		<div class="toast-container toast-bottom-center">
			<div class="toast mb-3" id="cart-toast" data-delay="5000"
				role="alert" aria-live="assertive" aria-atomic="true">
				<div class="toast-header bg-success text-white">
					<i class="czi-check-circle mr-2"></i>
					<h6 class="font-size-sm text-white mb-0 mr-auto">Added to
						cart!</h6>
					<button class="close text-white ml-2 mb-1" type="button"
						data-dismiss="toast" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="toast-body">This item has been added to your cart.</div>
			</div>
		</div>

		<jsp:include page="includes/presentacioncreador.jsp"></jsp:include>

		<!-- Footer-->
		<jsp:include page="includes/footerblack.jsp"></jsp:include>
		<jsp:include page="includes/footerwhite.jsp"></jsp:include>
		<!-- FOOTER -->
	</div>


</Body>

</html>