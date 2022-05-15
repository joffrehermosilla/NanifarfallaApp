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
<spring:url value="/tipoalerta/save" var="urlForm"></spring:url>
<spring:url value="/tipoalerta/create" var="urlCreate"></spring:url>
<spring:url value="/tipoalerta/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Nuevo Tipo Alerta</title>

</head>

<body>

	<header class="section-header"> </header>


	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nuevo Tipo Alerta</span>
		</h3>


		<spring:hasBindErrors name="tipoalerta">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


		${InstanciaTipoAlerta}
		<form:form action="${urlForm}" method="post" id="form" class="form"
			enctype="multipart/form-data" modelAttribute="InstanciaTipoAlerta">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>
						<c:forEach var="tipoalertaz" items="${tipoalertaz}">
							<c:set var="i" value="${tipoalertaz.codigo_tipoalerta}" />
						</c:forEach>
						<div class="col-sm-2">
							<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="codigo_tipoalerta"
								id="codigo_tipoalerta" required="required" value="${i + 1}" />
								-->
							<form:hidden path="codigo_tipoalerta" />
						</div>

						<div class="form-group">
							<form:label for="nombre_tipoalerta" path="nombre_tipoalerta"
								id="nombre_tipoalerta">Regla de TipoAlertaCrear
								un nuevo Tipo Alerta</form:label>
							<form:input type="text" class="form-control"
								path="nombre_tipoalerta" required="required"></form:input>






						</div>
						<div class="col-sm-2"></div>
						<div>
							<select id="nombre_tipoalerta" class="form-control">
								<option value="-1">Confirme Tipo Alerta</option>
								<c:forEach var="tipoalertaz" items="${tipoalertaz}">
									<option value="-1">${tipoalertaz.nombre_tipoalerta}</option>
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