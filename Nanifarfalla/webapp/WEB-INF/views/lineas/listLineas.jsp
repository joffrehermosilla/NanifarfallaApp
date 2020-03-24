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
<title>Administración de Lineas</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/lineas/index" var="urlForm"></spring:url>
<spring:url value="/lineas/create" var="urlCreate" />

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>
	<a href="${urlCreate}" class="btn btn-success" role="button"
		title="Nueva Linea">Nuevo</a>
	<br>
	<br>
	<div class="table-responsive">
		<table class="table table-hover table-striped table-bordered">
			<tr>
				<th>Nombre Usuario</th>
				<th>Codigo Linea</th>
				<th>fecha creacion</th>
				<th>Nombre de Linea</th>
				<th>estado del Mensaje</th>
				<th>Link del Mensaje</th>
				<th>Clave API</th>
			</tr>

			<c:forEach var="linea" items="${lineas}">
				<tr>
					<td>Tabla Usuario</td>
					<td>${linea.codigo_linea}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy"
							value="${anuncio.version}" />
					<td>${linea.nombre_linea}</td>
					<td>Renovar/Bloquear/Esperar</td>
					<td>${linea.foto_linea}</td>
					<td>${linea.claveApi}</td>
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
</head>
<body>

</body>
</html>