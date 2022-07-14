<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/menus/save" var="urlForm"></spring:url>
<spring:url value="/menus/create" var="urlCreate"></spring:url>
<spring:url value="/menus/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Nueva Regla de Menu</title>

</head>

<body>

	<header class="section-header"> </header>


	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nueva Regla de Menu</span>
		</h3>


		<spring:hasBindErrors name="menu">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


		${InstanciaMenuV1}
		<form:form action="${urlForm}" method="post" id="form" class="form"
			enctype="multipart/form-data" modelAttribute="InstanciaMenuV1">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>
						<c:forEach var="menuz" items="${menuz}">
							<c:set var="i" value="${menuz.id}" />
						</c:forEach>
						<div class="col-sm-2">
							<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="id" id="id"
								required="required" value="${i + 1}" />-->

							<form:hidden path="id" />
						</div>

						<div class="form-group">
							<form:label for="nombre" path="nombre" id="nombre">Regla del estado Usuario Crear
								un nuevo Menu</form:label>
							<form:input type="text" class="form-control" path="nombre"
								required="required"></form:input>
						</div>


						<div class="col-sm-2"></div>
						<div>
							<select name="padre" class="form-control"">
								<option value="-1">Seleccione padre</option>

								<c:forEach var="menuz" items="${menuz}">
									<option value="${menuz.id}">${menuz.nombre}</option>
								</c:forEach>

							</select>
						</div>
						<div class="form-group">
							<form:label for="ruta" path="ruta" id="ruta">Ruta EndPoint
								en nuevo Menu</form:label>
							<form:input type="text" class="form-control" path="ruta"
								required="required"></form:input>
						</div>

					</div>
					<div class="form-group">
						<label for="ruta">Imagen Menu</label> <input type="file"
							id="archivoImagen" name="archivoImagen" />
						<p class="help-block">Elige Imagen</p>
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