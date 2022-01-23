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
<title>Administración de Elaboracion del Producto</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/elaboracionproducto/index" var="urlForm"></spring:url>
<spring:url value="/elaboracionproducto/create" var="urlCreate" />
<spring:url value="/elaboracionproducto/delete" var="urlDelete" />
<spring:url value="/elaboracionproducto/update" var="urlEdit" />
<spring:url value="/elaboracionproducto/" var="urlPaginate"></spring:url>

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>

</head>
<body>
	
	<header class="section-header">

	</header>
	<div class="container theme-showcase" role="main">
		<h3>Listado de Elaboracion de Producto</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert" align="center">${ mensaje}</div>
		</c:if>
		<c:if test="${mensajedelete!=null }">
			<div class='alert alert-danger' role="alert" align="center">${mensajedelete}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nuevo Elaboracion Producto">Nuevo Elaboración Producto</a><br>
		<br>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Codigo Elaboracion del Producto</th>
					<th>Modelo de Producto</th>

					<th>Temporada Producto</th>
					<th>version</th>
					<th>Modificar</th>
				</tr>

				<c:forEach var="elaboracionproductoy"
					items="${elaboracionproductox.content}">
					<tr>

						<td>${elaboracionproductoy.codigo_elaboracionproducto}</td>
						<td>${elaboracionproductoy.modelo_producto}</td>
						<td>${elaboracionproductoy.temporada_producto}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${elaboracionproductoy.version}" /></td>




						<td align="center">
							<table border="1">
								<tr>

									<td><a
										href="${urlEdit}/${elaboracionproductoy.codigo_elaboracionproducto} "
										class="btn btn-success btn-sm" role="button" title="Edit">

											<ul class="navbar-nav">
												<big>
													<li class="nav-item"><i class="fa fa-pen"></i></li>


												</big>
											</ul></td>
									</a>
									</td>


									<td><a
										href="${urlDelete}/${elaboracionproductoy.codigo_elaboracionproducto}"
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
									href="${urlPaginate}indexPaginate?page=${elaboracionproductox.number - 1 }"><big>
											<li class="nav-item"><i
												class="fas fa-arrow-alt-circle-left"></i></li>


									</big></a></li>

							</ul>
						</td>
						<td>
							<ul class="navbar-nav">
								<li><a class="btn btn-right "
									href="${urlPaginate}indexPaginate?page=${elaboracionproductox.number + 1 }"><big>
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