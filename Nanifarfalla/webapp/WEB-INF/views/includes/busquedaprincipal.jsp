
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />




<div class="row page-header" style="align-self: center;">
	<div class="col-lg-12">
		<h2 class="text text-center">
			<span class="badge badge-success">NANIFARFALLA OFERTAS</span>
			<!-- <span class="label label-success">NANIFARFALLA OFERTAS</span> -->
		</h2>
		<form class="form-inline" action="${urlRoot}search" method="post">
			<div class="form-group">
				<label for="fecha">Fecha: </label> 
				<select id="fecha" name="fecha"
					class="form-control">
					<c:forEach items="${fechas}" var="fecha">
						<c:choose>
							<c:when test="${fechaBusqueda eq fecha}">
								<option value="${fecha}" selected>${fecha}</option>
							</c:when>
							<c:otherwise>
								<option value="${fecha}">${fecha}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Filtrar</button>
		</form>
	</div>

</div>

<div class="col">

	<div class="card-deck">
		<c:forEach items="${lineas}" var="linea">
			<div class="col-xs-12 col-sm-6 col-md-3">

				<div class="card" style="width: 18rem;">
					<figure class="snip0015">
						<img
							src="${urlPublic}/images/lineas/nanifarfalla/${linea.foto_linea}" />
						<figcaption>
							<h2><b>${linea.nombre_linea}</b>
								<span>${linea.codigo_linea}</span> ${fechabusqueda}
							</h2>
							<p><b>That everyone has his price, or that the price is always
								so low.</b></p>
							<a href="#"></a>
						</figcaption>

					</figure>
					<div class="card-body">
						<%--
						<a href="detail/${linea.codigo_linea}/${fechabusqueda}" class="btn btn-primary">Go somewhere</a>
			 --%>


						<a
							href="detail?codigo_linea=${linea.codigo_linea}&fecha=${fechabusqueda}"
							class="btn btn-primary">Go somewhere</a>

					</div>

					<div class="card-footer">
						<small class="text-muted">Last updated 3 mins ago</small>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>


</div>