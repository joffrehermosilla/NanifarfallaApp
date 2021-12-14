<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<title>Administración de Tipo Impuesto</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/estadousuario/index" var="urlForm"></spring:url>
<spring:url value="/estadousuario/create" var="urlCreate" />

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>
	<div class="container theme-showcase" role="main">
		<h3>Listado de Tipo Impuesto</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert">${ mensaje}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nuevo Anuncio">Nuevo</a><br> <br>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Nombre Usuario</th>
					<th>Codigo Anuncio</th>
					<th>fecha inicio</th>
					<th>fecha fin</th>
					<th>Estatus</th>	
					<th>Precio</th>
					<th>Mensaje Superior</th>
					<th>Mensaje Inferior</th>
					<th>Imagen 1</th>
					<th>Imagen 2</th>
					<th>estado del Mensaje</th>
					<th>Link del Mensaje</th>
					<th>Mensaje Principal</th>
					<th>Tipo de Mensaje</th>
					<th>Opciones</th>
				</tr>
				<c:forEach var="anuncio" items="${anuncios}">
					<tr>
						<td>Tabla Usuario</td>
						<td>${anuncio.codigo_anuncio}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${anuncio.version}" />
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${anuncio.version}" /></td>

						<td>${anuncio.fkcodigo_tipoalerta}</td>
						<td>${anuncio.precio}</td>
						<td>${anuncio.mensaje_anuncio}</td>
						<td>${anuncio.pie_mensaje}</td>
						<td>Ruta 1</td>
						<td>Ruta 2</td>

						<td>Renovar/Bloquear/Esperar</td>
						<td>Link de la ruta a donde va</td>
						<td>${anuncio.anuncio_principal}</td>

						<fmt:parseNumber var="i" value="${anuncio.fkcodigo_tipoalerta}" />
						<c:choose>
							<c:when test="${anuncio.fkcodigo_tipoalerta == 1}">
								<td align="center"><span
									class="badge badge-pill badge-danger">Importante</span></td>

							</c:when>
							<c:when test="${anuncio.fkcodigo_tipoalerta == 2}">
								<td align="center"><span
									class="badge badge-pill badge-info">Info</span></td>
							</c:when>
							<c:when test="${anuncio.fkcodigo_tipoalerta == 3}">
								<td align="center"><span
									class="badge badge-pill badge-warning">Alerta</span></td>
							</c:when>
							<c:otherwise>
								<td align="center"><span
									class="badge badge-pill badge-dark">Evento</span></td>
							</c:otherwise>
						</c:choose>
						<td align="center">
							<table border="1">
								<tr>
									<td><a href="#" class="btn btn-success btn-sm"
										role="button" title="Edit"> <span
											class="glyphicon glyphicon-trash">Actualizar<i
												class="fa fa-pencil"></i></span></a></td>
								</tr>
								<tr>
									<td><a href="#" class="btn btn-danger btn-sm"
										role="button" title="Eliminar"><span
											class="glyphicon glyphicon-trash">Eliminar <i
												class="fa fa-trash-o"></i>
										</span></a></td>
								</tr>

							</table>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<hr class="featurette-divider">
		<!-- /container -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>
		<!-- Bootstrap core JavaScript -->
	</div>
	<!-- /container -->
</body>
</html>