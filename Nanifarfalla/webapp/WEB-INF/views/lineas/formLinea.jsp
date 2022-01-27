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
<spring:url value="/lineas/save" var="urlForm"></spring:url>
<spring:url value="/lineas/create" var="urlCreate"></spring:url>
<spring:url value="/lineas/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Lineas por Administrador</title>

</head>

<body>

	<header class="section-header"> </header>


	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nueva Linea </span>
		</h3>


		<spring:hasBindErrors name="InstanciaLinea">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


		${InstanciaLinea}
		<form:form action="${urlForm}" method="post" id="form" class="form"
			enctype="multipart/form-data" modelAttribute="InstanciaLinea">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>

						<c:forEach var="lineaz" items="${lineaz}">
							<c:set var="i" value="${lineaz.codigo_linea}" />
						</c:forEach>

						<div class="col-sm-2">
							<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="codigo_linea"
								id="codigo_estadousuario" required="required" value="${i + 1}" />
								-->
							<form:hidden path="codigo_linea" />
						</div>

						<div class="form-group">
							<form:label for="nombre_linea" path="nombre_linea"
								id="nombre_linea">Nombre de Linea	</form:label>
							<form:input type="text" class="form-control" path="nombre_linea"
								required="required"></form:input>
						</div>
						<div class="form-group">
							<label for="foto_linea">Foto de la Linea</label> <input
								type="file" id="foto_linea" name="archivoImagen" />
							<p class="help-block">Imagen de Servicio</p>
						</div>
						<div class="form-group">
							<label for="foto_ruta" class="form-label">Segunda Foto </label> <input
								class="form-control" type="file" id="foto_ruta" multiple>
						</div>
						<div class="form-group form-row">
							<label class="col-md-3 col-form-label">Autorizar la Linea</label>
							<div class="col-sm-9 pt-1">
								<label class="custom-control custom-radio custom-control-inline">
									<input class="custom-control-input" checked="" type="radio"
									id="1" name="isActive" value="1"> <span
									class="custom-control-label"> Activado </span>
								</label> <label
									class="custom-control custom-radio custom-control-inline">
									<input class="custom-control-input" type="radio" id="2"
									name="isActive" value="2"> <span
									class="custom-control-label"> Desactivado </span>
								</label>
							</div>
						</div>



						<div class="col-sm-2"></div>
						<div>
							<select id="nombre_linea" class="form-control">
								<option value="-1">Confirme Linea Existente
									existente</option>
								<c:forEach var="lineaz"
									items="${lineaz}">
									<option value="-1">${lineaz.nombre_linea}</option>
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

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="${urlPublic}/tinymce/tinymce.min.js"></script>

	<script>
		$(function() {
			$("#temporada_producto").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>





</body>



</html>