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
<spring:url value="/estadocontrato/save" var="urlForm"></spring:url>
<spring:url value="/estadocontrato/create" var="urlCreate"></spring:url>
<spring:url value="/estadocontrato/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Nuevo Estado Contrato</title>

</head>

<body>

	<header class="section-header"> </header>


	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nuevo Estado Contrato</span>
		</h3>


		<spring:hasBindErrors name="estadocontrato">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


		${InstanciaEstadoContrato}
		<form:form action="${urlForm}" method="post" id="form" class="form"
			enctype="multipart/form-data" modelAttribute="InstanciaEstadoContrato">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>
						<c:forEach var="estadocontratoz" items="${estadocontratoz}">
							<c:set var="i" value="${estadocontratoz.codigo_estadoContrato}" />
						</c:forEach>
						<div class="col-sm-2">
							<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="codigo_estadoContrato"
								id="codigo_estadoContrato" required="required" value="${i + 1}" />
								-->
							<form:hidden path="codigo_estadoContrato" />
						</div>

						<div class="form-group">
							<form:label for="descripcion" path="descripcion"
								id="descripcion">Regla de EstadoContrato
								un nuevo Estado Contrato</form:label>
							<form:input type="text" class="form-control"
								path="descripcion" required="required"></form:input>






						</div>
						<div class="col-sm-2"></div>
						<div>
							<select id="descripcion" class="form-control">
								<option value="-1">Confirme Estado Contrato</option>
								<c:forEach var="estadocontratoz" items="${estadocontratoz}">
									<option value="-1">${estadocontratoz.descripcion}</option>
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