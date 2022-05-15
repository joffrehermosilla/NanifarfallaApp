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
<title>Administración de Tipo Alerta</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/tipoalerta/index" var="urlForm"></spring:url>
<spring:url value="/tipoalerta/create" var="urlCreate" />
<spring:url value="/tipoalerta/delete" var="urlDelete" />
<spring:url value="/tipoalerta/update" var="urlEdit" />
<spring:url value="/tipoalerta/" var="urlPaginate"></spring:url>

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>

</head>
<body>
	
	<header class="section-header"> </header>
	<div class="container theme-showcase" role="main">
		<h3>Listado de Tipo Alerta</h3>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert" align="center">${ mensaje}</div>
		</c:if>
		<c:if test="${mensajedelete!=null }">
			<div class='alert alert-danger' role="alert" align="center">${mensajedelete}</div>
		</c:if>
		<a href="${urlCreate}" class="btn btn-success" role="button"
<<<<<<< HEAD
			title="Nuevo Tipo Alerta">Nuevo Tipo Alerta</a><br> <br>
=======
			title="Nuevo Estado Usuario">Nuevo Tipo Alerta</a><br> <br>
>>>>>>> 97a582c3e446088999d8b732618856df8c483747
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Codigo Tipo Alerta</th>
					<th>Nombre Tipo Alerta</th>

					<th>Version</th>
					<th>Modificar</th>

				</tr>

				<c:forEach var="tipoalertay" items="${tipoalertax.content}">
					<tr>

						<td>${tipoalertay.codigo_tipoalerta}</td>
						<td>${tipoalertay.nombre_tipoalerta}</td>

						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${tipoalertay.version}" /></td>




						<td align="center">
							<table border="1">
								<tr>

									<td><a
										href="${urlEdit}/${tipoalertay.codigo_tipoalerta} "
										class="btn btn-success btn-sm" role="button" title="Edit">

											<ul class="navbar-nav">
												<big>
													<li class="nav-item"><i class="fa fa-pen"></i></li>


												</big>
											</ul></td>
									</a>
									</td>


									<td><a
										href="${urlDelete}/${tipoalertay.codigo_tipoalerta}"
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
									href="${urlPaginate}indexPaginate?page=${tipoalertax.number - 1 }"><big>
											<li class="nav-item"><i
												class="fas fa-arrow-alt-circle-left"></i></li>


									</big></a></li>

							</ul>
						</td>
						<td>
							<ul class="navbar-nav">
								<li><a class="btn btn-right "
									href="${urlPaginate}indexPaginate?page=${tipoalertax.number + 1 }"><big>
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