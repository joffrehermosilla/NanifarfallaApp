<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/estadousuario/save" var="urlForm"></spring:url>
<spring:url value="/estadousuario/create" var="urlCreate"></spring:url>
<spring:url value="/estadousuario/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Nueva Regla Estado Usuario</title>

</head>

<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>
	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nueva Regla de Estado
				del Usuario</span>
		</h3>


		<spring:hasBindErrors name="estadousuario">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


${InstanciaEstadoUsuario}
		<form:form action="${urlForm}" method="post" id="form" class="form"
			enctype="multipart/form-data" modelAttribute="InstanciaEstadoUsuario">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>
						<c:forEach var="estadousuarioz" items="${estadousuarioz}">
							<c:set var="i" value="${estadousuarioz.codigo_estadousuario}" />
						</c:forEach>
						<div class="col-sm-2">
							<input width="4" type="text" class="form-control" hidden="true"
								path="codigo_estadousuario" id="codigo_estadousuario"
								required="required" value="${i + 1}" />
						</div>

						<div class="form-group">
							<label for="nombre_estadousuario" path="nombre_estadousuario"
								id="nombre_estadousuario">Regla del estado Usuario Crear
								un nuevo Estado de Usuario</label> <input type="text"
								class="form-control" path="nombre_estadousuario"
								required="required"></input>






						</div>
						<div>
							<select id="nombre_estadousuario" class="form-control">
								<option value="-1">Confirme Estado Usuario</option>
								<c:forEach var="estadousuarioz" items="${estadousuarioz}">
									<option value="-1">${estadousuarioz.nombre_estadousuario}</option>
								</c:forEach>
							</select>
						</div>
					</div>

				</div>

				<div class="form-buttons">
					<div class="button">
						<button type="submit" value="submit" class="btn btn-danger href="${urlStart}">Guardar</button>
					</div>
					
						
				</div>
			</fieldset>
		</form:form>


		<hr class="featurette-divider">
	</div>
	<!-- /container -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="${urlPublic}/tinymce/tinymce.min.js"></script>

	<script>
		$(function() {
			$("#version").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>





</body>



</html>