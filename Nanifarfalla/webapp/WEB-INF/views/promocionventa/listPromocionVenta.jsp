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
<title>Administración de Promocion de Venta</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/promocionventa/index" var="urlForm"></spring:url>
<spring:url value="/promocionventa/create" var="urlCreate" />

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>
	<div class="container theme-showcase" role="main">
		<h3>Listado de Promocion de Venta</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert">${ mensaje}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva Promocion de Venta">Nuevo</a><br> <br>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Codigo Promocion de Venta</th>
					<th>Cantidad Pedido</th>
					<th>Descuento Pedido</th>
					<th>Fecha Inicio Promocion</th>
					<th>Fecha Expiracion Promocion</th>
					<th>Descripcion Promocion</th>
					<th>Clave API</th>
					<th>version</th>
		
				</tr>
				<c:forEach var="promocionventay" items="${promocionventay}">
					<tr>
						<td>Tabla Promocion de Venta</td>
						<td>${promocionventay.codigo_promocion_venta}</td>
						<td>${promocionventay.cantidad_sku_pedido}</td>
						<td>${promocionventay.descuento_sku_pedido}</td>
						<td>${promocionventay.fecha_inicio_promocion}</td>
						<td>${promocionventay.fecha_expiracion_promocion}</td>
						<td>${promocionventay.descripcion_promocion}</td>										
						<td>${promocionventay.claveApi}</td>
						
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${promocionventay.version}" /></td>

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