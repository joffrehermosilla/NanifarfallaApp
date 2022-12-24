
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/alertax" var="urlAlertax"></spring:url>
</head>

<section class="cz-carousel cz-controls-lg">

		<nav class="navbar  navbar-dark bg-dark  navbar-expand p-0 bg-primary ">


		<div class="col-xs-32 col-sm-36 col-md-33" style="width: 380rem"
			align="center">
			<div id="carouselExampleControlsx" class="carousel slide"
				data-ride="carousel" align="center">

				<div class="col-xs-32 col-sm-36 col-md-33" align="center">

					<c:forEach items="${anuncios}" var="anuncios" varStatus="loop">
						<c:choose>
							<c:when test="${loop.index==0}">
								<li data-target="#carouselExampleControlsx"
									data-slide-to="${loop.index}" class="active"></li>
							</c:when>
							<c:otherwise>
								<li data-target="#carouselExampleControlsx"
									data-slide-to="${loop.index}"></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>





					<div class="carousel-inner">


						<c:forEach items="${anuncios}" var="anuncios">

							<fmt:parseNumber var="i"
								value="${anuncios.mTipoAlerta.codigo_tipoalerta}" />



							<c:choose>


								<c:when test="${i==1}">
									<div class="carousel-item active">
										<span class="badge badge-pill badge-info">${anuncios.mensaje_anuncio}
										</span>
									</div>
								</c:when>
								<c:when test="${i==2}">
									<div class="carousel-item">
										<span class="badge badge-pill badge-warning">${anuncios.mensaje_anuncio}
										</span>
									</div>
								</c:when>
								<c:when test="${i==3}">
									<div class="carousel-item">
										<span class="badge badge-pill badge-danger">${anuncios.mensaje_anuncio}
										</span>
									</div>
								</c:when>
								<c:otherwise>
									<div class="carousel-item">
										<span class="badge badge-pill badge-dark">${anuncios.mensaje_anuncio}</span>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleControlsx"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleControlsx"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>


	</nav>
</section>