<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de Lineas</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/lineas/save" var="urlForm"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>

	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Datos del Anuncio</span>
		</h3>

		<form:form action="${urlForm}" method="post"
			enctype="multipart/form-data" modelAttribute="linea">
			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="codigo_anuncio">Codigo Linea</label>
							<c:forEach var="linea" items="${lineas}">
								<c:set var="i" value="${linea.codigo_linea}" />
							</c:forEach>
							<div class="col-sm-2">
								<form:input width="4" type="text" class="form-control"
									hidden="true" path="codigo_linea" id="codigo_linea"
									required="required" value="${i + 1}" />
							</div>
						</div>

						<div class="form-group">
							<label for="nombre_linea">Nombre de Linea</label>
							<form:input type="text" class="form-control" path="nombre_linea"
								id="nombre_linea" required="required" />
							<div class="col-sm-6">
								<div class="form-group">
									<label for="fechacreacion">Fecha Creacion</label>
									<form:input type="date" class="form-control"
										path="fechacreacion" id="version" required="required"
										pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" />
								</div>
							</div>

							<label for="claveApi">Clave API </label>
							<form:input type="text" class="form-control" path="claveApi"
								id="claveApi" required="required" />
						</div>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	<!-- /container -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
<script>
		$(function() {
			$("#version").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>


	<spring:hasBindErrors name="anuncios">
		<div class='alert alert-danger' role='alert'>
			Por favor corrija los siguientes errores:
			<ul>
				<c:forEach var="error" items="${errors.allErrors}">
					<li><spring:message message="${error}" /></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>



</body>
</html>