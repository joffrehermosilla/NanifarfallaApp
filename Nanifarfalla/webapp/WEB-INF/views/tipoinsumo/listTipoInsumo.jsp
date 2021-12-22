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
<title>Administración de Tipo Insumo</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/tipoinsumo/index" var="urlForm"></spring:url>
<spring:url value="/tipoinsumo/create" var="urlCreate" />

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>
	<div class="container theme-showcase" role="main">
		<h3>Listado de Tipo Insumo</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert">${ mensaje}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nuevo Tipo Insumo">Nuevo</a><br> <br>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Codigo Tipo Insumo</th>
					<th>Nombre Tipo Insumo</th>
					<th>Clave API</th>
					<th>version</th>
		
				</tr>
				<c:forEach var="tipoinsumoy" items="${tipoinsumoy}">
					<tr>
						<td>Tabla Tipo Insumo</td>
						<td>${tipoinsumoy.codigo_tipoinsumo}</td>
						<td>${tipoinsumoy.nombre_tipo_insumo}</td>
						<td>${tipoinsumoy.claveApi}</td>
						
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${tipoinsumoy.version}" /></td>

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