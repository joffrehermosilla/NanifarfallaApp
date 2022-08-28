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
<spring:url value="/roles/save" var="urlForm"></spring:url>
<spring:url value="/roles/create" var="urlCreate"></spring:url>
<spring:url value="/roles/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Nueva Regla ROLES</title>

</head>

<body>

	<header class="section-header"> </header>


	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nueva Regla de ROLES</span>
		</h3>


		<spring:hasBindErrors name="InstanciaRole">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


		${InstanciaRole}
		<form:form action="${urlForm}" method="post" id="form" class="form"
			enctype="multipart/form-data" modelAttribute="InstanciaRole">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>
						<c:forEach var="rolez" items="${rolez}">
							<c:set var="i" value="${rolez.codigo_role}" />
						</c:forEach>
						<div class="col-sm-2">
							<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="codigo_role"
								id="codigo_estadousuario" required="required" value="${i + 1}" />
								-->
							<form:hidden path="codigo_role" />
						</div>

						<div class="form-group">
							<form:label for="name" path="name" id="name">Regla del Nombre Crear
								un nuevo ROL de Usuarios</form:label>
							<form:input type="text" class="form-control" path="name"
								required="required"></form:input>






						</div>
						<div class="col-sm-2"></div>
						<div>
							<select id="name" class="form-control">
								<option value="-1">Confirme ROLES</option>
								<c:forEach var="rolez" items="${rolez}">
									<option value="-1">${rolez.name}</option>
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
			$("#version").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>





</body>



</html>