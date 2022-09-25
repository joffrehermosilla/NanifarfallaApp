<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<spring:url value="/productos/delete" var="urlDelete" />
<spring:url value="/productos/update" var="urlEdit" />
<spring:url value="/productos/" var="urlPaginate"></spring:url>

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>

</head>
<body>

	<header class="section-header"> </header>
	<div class="container theme-showcase" role="main">
		<h3>Listado de Productos</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert" align="center">${ mensaje}</div>
		</c:if>
		<c:if test="${mensajedelete!=null }">
			<div class='alert alert-danger' role="alert" align="center">${mensajedelete}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nuevo Producto">Nuevo Producto</a><br> <br>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Codigo Producto</th>
					<th>Nombre Producto</th>
					<th>Ingreso Almacen</th>
					<th>Salida Almacen</th>
					<th>Stock del Producto</th>
					<th>Preparacion del Producto</th>
					<th>Imagen del Producto</th>
					<th>Imagen del Producto1</th>
					<th>Imagen del Producto2</th>
					<th>Imagen del Producto3</th>
					<th>Imagen del Producto4</th>
					<th>Colores</th>
					<th>Qr Producto</th>
					<th>precio original</th>
					<th>precio final</th>
					<th>Clave Api</th>
					<th>version</th>
					<th>views</th>
					<th>purchases</th>
					<th>codigo Linea</th>
				</tr>

				<c:forEach var="productoy" items="${productox.content}">
					<tr>
						<td>${productoy.codigo_producto}</td>
						<td>${productoy.nombre_producto}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${productoy.ingreso_almacen_producto}" />
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${productoy.salida_almacen_producto}" /></td>

						<td>${productoy.stock_producto}</td>
						<td>${productoy.preparacion_producto}</td>
						<td>${productoy.foto_ruta}</td>
						<td>${productoy.foto_ruta1}</td>
						<td>${productoy.foto_ruta2}</td>
						<td>${productoy.foto_ruta3}</td>
						<td>${productoy.foto_ruta4}</td>
						<td>${productoy.colores_producto}</td>
						<td>${productoy.qr_producto}</td>
						<td>${productoy.pvv_producto}</td>
						<td>${productoy.pvf_producto}</td>
						<td>${productoy.claveApi}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${productoy.version}" /></td>
								<td>${productoy.views}</td>
									<td>${productoy.purchases}</td>
						<td>${productoy.mLinea.nombre_linea}</td>
						<td align="center">
							<table border="1">
								<tr>

									<td><a href="${urlEdit}/${productoy.codigo_producto} "
										class="btn btn-success btn-sm" role="button" title="Edit">

											<ul class="navbar-nav">
												<big>
													<li class="nav-item"><i class="fa fa-pen"></i></li>


												</big>
											</ul></td>
									</a>
									</td>


									<td><a href="${urlDelete}/${productoy.codigo_producto}"
										onclick='return confirm("¿ Estás Seguro ?")'
										class="btn btn-danger btn-sm" role="button" type="submit"
										value="submit" title="Eliminar">
											<ul class="navbar-nav">
												<big>
													<li class="nav-item"><i class="fa fa-trash"></i></li>


												</big>
											</ul></td>
									</a>


								</tr>

							</table>

						</td>
					</tr>
				</c:forEach>
			</table>
			<div align="center">

				<table border="0" align="center">
					<tr>
						<td>
							<ul class="navbar-nav">
								<li><a class="btn btn-left "
									href="${urlPaginate}indexPaginate?page=${productox.number - 1 }"><big>
											<li class="nav-item"><i
												class="fas fa-arrow-alt-circle-left"></i></li>


									</big></a></li>

							</ul>
						</td>
						<td>
							<ul class="navbar-nav">
								<li><a class="btn btn-right "
									href="${urlPaginate}indexPaginate?page=${productox.number + 1 }"><big>
											<li class="nav-item"><i
												class="fas fa-arrow-alt-circle-right"></i></li>


									</big></a></li>
							</ul>
						</td>
					</tr>
				</table>


			</div>

		</div>

		<hr class="featurette-divider">
		<!-- /container -->

		<!-- Bootstrap core JavaScript -->
	</div>


	<!-- /container -->
</body>
</html>