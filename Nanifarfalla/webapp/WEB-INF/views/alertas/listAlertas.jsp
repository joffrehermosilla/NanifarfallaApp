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
<title>Administración de Alertas</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/alertas/index" var="urlForm"></spring:url>
<spring:url value="/alertas/create" var="urlCreate" />

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
			
	</header>
	
		<div class="container theme-showcase" role="main">
		<h3>Listado de Alertas</h3>
			<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert">${ mensaje}</div>
		</c:if>
	<a href="${urlCreate}" class="btn btn-success" role="button"
		title="Nueva Linea">Nuevo</a>
	<br>
	<br>
	
	
	
	<div class="table-responsive">
		<table class="table table-hover table-striped table-bordered">
			<tr>
				<th>Nombre Usuario</th>
				<th>Codigo Alerta</th>
				<th>fecha creacion</th>
				<th>Mensaje Alerta</th>
				<th>estado de la linea</th>
				<th>precio</th>
				<th>categoria</th>
				<th>fk categoria</th>
			</tr>

			<c:forEach var="alerta" items="${alertas}">
				<tr>
					<td>Tabla Alertas</td>
					<td>${alerta.codigo_alerta}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy"
							value="${alerta.version}" />
					<td>${alerta.mensaje_alerta}</td>
					<td>Renovar/Bloquear/Esperar</td>
					<td>${alerta.precio}</td>
					<td>${alerta.categoria}</td>
							<fmt:parseNumber var="i" value="${alerta.fkcodigo_tipoalerta}" />
						<c:choose>
							<c:when test="${alerta.fkcodigo_tipoalerta == 1}">
								<td align="center"><span
									class="badge badge-pill badge-danger">Importante</span></td>

							</c:when>
							<c:when test="${alerta.fkcodigo_tipoalerta == 2}">
								<td align="center"><span
									class="badge badge-pill badge-info">Info</span></td>
							</c:when>
							<c:when test="${alerta.fkcodigo_tipoalerta == 3}">
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
								<td><a href="#" class="btn btn-danger btn-sm" role="button"
									title="Eliminar"><span class="glyphicon glyphicon-trash">Eliminar
											<i class="fa fa-trash-o"></i>
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

	
	<!-- /container -->

</div>
<body>

</body>
</html>