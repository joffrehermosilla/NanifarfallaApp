<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<spring:url value="/resources" var="urlPublic" />
<spring:url var="css" value="/resources/ecommerce/assets/css" />
<spring:url var="js" value="/resources/ecommerce/assets/js" />
<spring:url var="images" value="/resources/ecommerce/assets/images" />


<spring:url value="/productos/indexPaginate?page=0" var="urlProducto"></spring:url>

<spring:url value="/estadousuario/indexPaginate?page=0"
	var="urlEstadoUsuario"></spring:url>

<spring:url value="/elaboracionproducto/indexPaginate?page=0"
	var="urlElaboracionProducto"></spring:url>
<spring:url value="/pais/indexPaginate?page=0" var="urlPais"></spring:url>

<spring:url value="/lineas/indexPaginate?page=0" var="urlLinea"></spring:url>

<spring:url value="/estadocatalogo/indexPaginate?page=0"
	var="urlEstadoCatalogo"></spring:url>

<spring:url value="/tipousuario/indexPaginate?page=0"
	var="urlTipoUsuario"></spring:url>


<spring:url value="/tipoalerta/indexPaginate?page=0" var="urlTipoAlerta"></spring:url>


<spring:url value="/estadocontrato/indexPaginate?page=0"
	var="urlEstadoContrato"></spring:url>


<spring:url value="/privilege/indexPaginate?page=0" var="urlPrivilege"></spring:url>

<spring:url value="/menus/indexPaginate?page=0" var="urlMenu"></spring:url>

<spring:url value="/roles/indexPaginate?page=0" var="urlRole"></spring:url>

<spring:url value="/alertas/indexPaginate?page=0" var="urlAlerta"></spring:url>

<spring:url value="/anuncios/indexPaginate?page=0" var="urlAnuncio"></spring:url>


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Online Shopping Nanifarfalla Website RESTFUL Using Spring MVC and JPA Hibernate">
<meta name="author" content="Joffre Hermosilla Salas">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Plain Page- ${title}</title>

<script>
	window.menux = '${title}';

	window.contextRoot = '${contextRoot}'
</script>
<script>

			var vista = document.getElementById('plainpage');
			document.getElementById('estadousuario').addEventListener('click', function(e) {
			e.preventDefault();
			vista.innerHTML = `
																		         
		     <iframe  src="${urlEstadoUsuario}" height="630" style="width: 100%" frameBorder="0" ></iframe>
																		          
		    `;
						
			});
									
			document.getElementById('elaboracionproducto').addEventListener('click', function(e) {
			e.preventDefault();

			vista.innerHTML = `
				<div class="embed-responsive embed-responsive-16by9">														      
	        <iframe src="${urlElaboracionProducto}" height="620" style="width: 100%" frameBorder="0" ></iframe></div>
	        `;
			});

			
			document.getElementById('pais').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlPais}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			
			
			
			document.getElementById('linea').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlLinea}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			
			
			document.getElementById('estadocatalogo').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlEstadoCatalogo}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			
			document.getElementById('tipousuario').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlTipoUsuario}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			
			document.getElementById('tipoalerta').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlTipoAlerta}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			
			document.getElementById('estadocontrato').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlEstadoContrato}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			
			document.getElementById('privilege').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlPrivilege}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			
			document.getElementById('menu').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlMenu}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			document.getElementById('roles').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlRole}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			document.getElementById('producto').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlProducto}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			document.getElementById('alertas').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlAlerta}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			document.getElementById('anuncios').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlAnuncio}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});
			
</script>




</head>

<body>





	<div class="se-pre-con"></div>
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="../shared/navbar.jsp"%>

		<!-- Page Content -->


		Aqui debe funcionar el js

		<div class="content">

			<!-- Load only when user clicks about -->
			<c:if test="${userClickEstadoUsuario == true }">
				<%@include file="../estadousuario/listEstadoUsuario.jsp"%>
			</c:if>
			<c:if test="${userClickElaboracionProducto == true }">
				<%@include file="../elaboracionproducto/listElaboracionProducto.jsp"%>
			</c:if>
			<c:if test="${userClickDemoA==true}">
				<title>${contextRoot}-${title}|<fmt:message
						key="welcome.lang" />

				</title>
			</c:if>
			<c:if test="${userClickPais == true }">
				<%@include file="../pais/listPais.jsp"%>
			</c:if>

		</div>




		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded javascript -->
		<script src="${urlPublic}/js/regla5.js"></script>

	</div>

</body>

</html>