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
<title>Administración de Alertas</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/anuncios/index" var="urlForm"></spring:url>
<spring:url value="/anuncios/create" var="urlCreate" />
<spring:url value="/anuncios/delete" var="urlDelete" />
<spring:url value="/anuncios/update" var="urlEdit" />
<spring:url value="/anuncios/" var="urlPaginate"></spring:url>

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>

</head>
<body>

	<header class="section-header"> </header>
	<div class="container theme-showcase" role="main">
		<h3>Listado de Anuncios</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert" align="center">${mensaje}</div>
		</c:if>
		<c:if test="${mensajedelete!=null}">
			<div class='alert alert-danger' role="alert" align="center">${mensajedelete}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva Alerta">Nuevo Anuncio</a><br> <br>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Codigo Anuncio</th>
					<th>Mensaje de Anuncio</th>
					<th>Anuncio Principal</th>
					<th>Pie de Mensaje</th>
					<th>link de Mensaje</th>
					<th>ruta de Imagen</th>
					<th>precio</th>
					<th>Tipo de Alerta</th>
					<th>version</th>
					<th>Modificar</th>
				</tr>

				<c:forEach var="anunciosy" items="${anunciosx.content}">
					<tr>

						<td>${anunciosy.codigo_anuncio}</td>
						<td>${anunciosy.mensaje_anuncio}</td>
						<td>${anunciosy.anuncio_principal}</td>
						<td>${anunciosy.pie_mensaje}</td>
						<td>${anunciosy.link_mensaje}</td>
						<td>${anunciosy.ruta_imagen}</td>
						<td>${anunciosy.precio}</td>
						<fmt:parseNumber var="i"
							value="${anunciosy.mTipoAlerta.codigo_tipoalerta}" />
						<c:choose>
							<c:when test="${i == 1}">
								<td align="center"><span
									class="badge badge-pill badge-danger">${anunciosy.mTipoAlerta.nombre_tipoalerta}</span></td>

							</c:when>
							<c:when test="${i == 2}">
								<td align="center"><span
									class="badge badge-pill badge-info">${alertasy.mTipoAlerta.nombre_tipoalerta}</span></td>
							</c:when>
							<c:when test="${i == 3}">
								<td align="center"><span
									class="badge badge-pill badge-warning">${anunciosy.mTipoAlerta.nombre_tipoalerta}</span></td>
							</c:when>
							<c:otherwise>
								<td align="center"><span
									class="badge badge-pill badge-dark">${anunciosy.mTipoAlerta.nombre_tipoalerta}</span></td>
							</c:otherwise>
						</c:choose>



						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${anunciosy.version}" /></td>




						<td align="center">
							<table border="1">
								<tr>

									<td><a href="${urlEdit}/${anunciosy.codigo_anuncio} "
										class="btn btn-success btn-sm" role="button" title="Edit">

											<ul class="navbar-nav">
												<big>
													<li class="nav-item"><i class="fa fa-pen"></i></li>


												</big>
											</ul></td>
									</a>
									</td>


									<td><a href="${urlDelete}/${anunciosy.codigo_anuncio}"
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
									href="${urlPaginate}indexPaginate?page=${anunciosx.number - 1 }"><big>
											<li class="nav-item"><i
												class="fas fa-arrow-alt-circle-left"></i></li>


									</big></a></li>

							</ul>
						</td>
						<td>
							<ul class="navbar-nav">
								<li><a class="btn btn-right "
									href="${urlPaginate}indexPaginate?page=${anunciosx.number + 1 }"><big>
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