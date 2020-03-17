<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenidos a NANIFARFALLA</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
	



</head>
<body>

	<%--
	<h1>LINEAS DE PROMOCIÓN</h1>
	<ol>
		<c:forEach items="${lineas}" var="linea">
			<li>${linea}</li>
		</c:forEach>
	</ol>
	 --%>


	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Lineas Nanifarfalla</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lineas}" var="linea">
				<tr align="center">
					<td align="center">

						<div class="card" style="width: 18rem;">
							<img src="${urlPublic}/images/lineas/${linea.foto_linea}"
								class="card-img-top" alt="..." width="150" height="200">
							<h1 class="card-title">${linea.codigo_linea}</h1>

							<h5 class="card-title">

								<c:choose>
									<c:when test="${linea.nombre_linea =='carteras'}">
										<span class="label label-success">CARTERA</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">${linea.nombre_linea}</span>
									</c:otherwise>
								</c:choose>

							</h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<p class="card-text">${linea.fechacreacion}</p>
							<p>
								<fmt:formatDate value="${linea.fechacreacion}"
									pattern="dd-MM-yyyy" />
							</p>
							<a href="#" class="btn btn-primary">Go somewhere</a>
						</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>