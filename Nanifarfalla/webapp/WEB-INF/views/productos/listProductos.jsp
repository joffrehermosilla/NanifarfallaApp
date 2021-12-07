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
<title>Administración de Productos</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/productos/index" var="urlForm"></spring:url>
<spring:url value="/productos/create" var="urlCreate" />
<spring:url value="/lineas/create" var="lineaCreate" />
<spring:url value="/productos" var="urlProductopaginate" />
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>
	<div class="container theme-showcase" role="main">
		<h3>Listado de Productos</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert">${ mensaje}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nuevo Producto">Nuevo</a> <a href="${lineaCreate}"
			class="btn btn-success" role="button" title="Crear Linea">Crear
			Linea</a> <br> <br>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>


					<th>Nombre Usuario</th>
					<th>Codigo Producto</th>
					<th>Nombre Producto</th>
					<th>Ingreso Almacen</th>
					<th>Salida Almacen</th>
					<th>Stock del Producto</th>
					<th>Preparacion del Producto</th>
					<th>Imagen del Producto</th>
					<th>Colores</th>
					<th>Qr Producto</th>
					<th>precio original</th>
					<th>precio final</th>
					<th>Clave Api</th>
					<th>version</th>
					<th>codigo Linea</th>
				</tr>
				<c:forEach var="producto" items="${productos}">
					<tr>
						<td>Tabla Usuario</td>
						<td>${producto.codigo_producto}</td>
						<td>${producto.nombre_producto}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${producto.ingreso_almacen_producto}" />
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${producto.salida_almacen_producto}" /></td>

						<td>${producto.stock_producto}</td>
						<td>${producto.preparacion_producto}</td>
						<td>${producto.foto_ruta}</td>
						<td>${producto.colores_producto}</td>
						<td>${producto.qr_producto}</td>
						<td>${producto.pvv_producto}</td>
						<td>${producto.pvf_producto}</td>
						<td>${producto.claveApi}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${producto.version}" /></td>
						<td>${producto.mLinea.nombre_linea}</td>


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
		<nav aria-label="Pagination">
			<ul class="pagination justify-content-center font-weight-bold">
				<li class="page-item"><a
					href="${urlProductopaginate}/indexPaginate?page=${productox.number - 1 }">[    Anterior   ] </a></li>
				
				<li class="page-item"><a
					href="${urlProductopaginate}/indexPaginate?page=${productox.number + 1 }">[   Siguiente   ]  </a></li>
			</ul>
		</nav>
		<hr class="featurette-divider">
		<!-- /container -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>
		<!-- Bootstrap core JavaScript -->
	</div>
	<!-- /container -->
</body>
</html>