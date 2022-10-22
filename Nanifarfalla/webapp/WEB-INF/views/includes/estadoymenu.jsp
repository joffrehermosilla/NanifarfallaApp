	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
	<html lang="en" xmlns:th="http://www.thymeleaf.org">

	
	<spring:url value="/resources" var="urlPublic" />
	<nav
		class="navbar  navbar-dark bg-dark  navbar-expand p-0 bg-primary ">
		
		
				<div class="col-xs-32 col-sm-36 col-md-33" style="width: 380rem"
					align="center">
					<div id="carouselExampleControls" class="carousel slide"
						data-ride="carousel" align="center">
						<c:set var="categoria1" value="importante" />
						<c:set var="categoria2" value="alerta" />
						<c:set var="categoria3" value="eventos" />
						<c:set var="categoria4" value="info" />
						<div class="col-xs-32 col-sm-36 col-md-33" align="center">
							<div class="carousel-inner">
								<c:forEach items="${alertas}" var="alerta">

									<c:choose>
										<c:when test="${alerta.categoria==categoria1}">
											<div class="carousel-item">
												<span class="badge badge-pill badge-danger">${alerta.mensaje_alerta}
												</span>
											</div>
										</c:when>
										<c:when test="${alerta.categoria==categoria4}">
											<div class="carousel-item active">
												<span class="badge badge-pill badge-info">${alerta.mensaje_alerta}
												</span>
											</div>
										</c:when>
										<c:when test="${alerta.categoria==categoria2}">
											<div class="carousel-item">
												<span class="badge badge-pill badge-warning">${alerta.mensaje_alerta}
												</span>
											</div>
										</c:when>
										<c:when test="${alerta.categoria==categoria3}">
											<div class="carousel-item">
												<span class="badge badge-pill badge-dark">${alerta.mensaje_alerta}</span>
											</div>
										</c:when>
									</c:choose>
								</c:forEach>
							</div>
							<a class="carousel-control-prev" href="#carouselExampleControls"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#carouselExampleControls"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
	
		
	</nav>
