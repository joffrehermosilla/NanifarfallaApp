
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />

<!--  tamaño de lista
${fn:length(usuarios)}

-->

<!--   verdadero o falso
<c:set var="rand"><%=java.lang.Math.round(java.lang.Math.random() * 2)%></c:set>
${rand mod 2 == 0} and ${rand mod 2 == 1}-->

<jsp:useBean id="random" class="java.util.Random" scope="application" />


<c:set var="ceocentral"
	value="${random.nextInt(fn:length(usuarios)) +1}" />
<c:set var="ceosize" value="${fn:length(usuarios)}" />
<table>

	<c:forEach var="usuario" items="${usuarios}" varStatus="counter">
		<c:choose>
			<c:when test="${usuario.codigo_usuario==ceocentral-1}">
				<c:set var="ceolcodigo" value="${usuario.codigo_usuario}" />
				<c:set var="ceolnombre" value="${usuario.nombre_usuario}" />
				<c:set var="ceolpaterno" value="${usuario.apellido_usuario}" />
				
				<c:set var="ceolmensaje" value="${usuario.mensaje_usuario}" />
				<c:set var="ceolfoto" value="${usuario.foto_usuario}" />

			</c:when>

			<c:when test="${usuario.codigo_usuario==ceocentral}">
				<c:set var="ceocodigo" value="${usuario.codigo_usuario}" />
				<c:set var="ceonombre" value="${usuario.nombre_usuario}" />
				<c:set var="ceopaterno" value="${usuario.apellido_usuario}" />
			
				<c:set var="ceomensaje" value="${usuario.mensaje_usuario}" />
				<c:set var="ceofoto" value="${usuario.foto_usuario}" />
			</c:when>

			<c:when test="${usuario.codigo_usuario==ceocentral+1}">
				<c:set var="ceorcodigo" value="${usuario.codigo_usuario}" />
				<c:set var="ceornombre" value="${usuario.nombre_usuario}" />
				<c:set var="ceorpaterno" value="${usuario.apellido_usuario}" />
		
				<c:set var="ceormensaje" value="${usuario.mensaje_usuario}" />
				<c:set var="ceorfoto" value="${usuario.foto_usuario}" />
			</c:when>
			<c:when test="${usuario.codigo_usuario==fn:length(usuarios)+1}">

				<c:set var="ceorcodigo" value="${ceocodigo}" />
				<c:set var="ceornombre" value="${ceonombre}" />
				<c:set var="ceorpaterno" value="${ceopaterno}" />
				
				<c:set var="ceormensaje" value="${ceomensaje}" />
				<c:set var="ceorfoto" value="${ceofoto}" />
			</c:when>

			<c:otherwise>



			</c:otherwise>
		</c:choose>
		<tr>

		</tr>
	</c:forEach>

	<section class="container pt-md-3 pb-5 mb-md-3"style="align-content: center;">
		<div class="customer-feedback" style="align-content: center;">
			<div class="container text-center" align="center">
				<div class="row" align="center">
					<div class="col-md-offset-13 col-md-66 col-sm-offset-22 col-sm-12">
						<div>
							<h2 class="section-title">Conoce a los emprendedores</h2>
						</div>
					</div>
					<!-- /End col -->
				</div>
				<!-- /End row -->

				<div class="row" align="center"
					style="align-content: align-self: center;">
					<div class="col-md-offset-13 col-md-66 col-sm-offset-22 col-sm-12">
						<div class="owl-carousel feedback-slider">


							<!-- slider item -->
							<div class="feedback-slider-item">
								<div class="col-xs-12 col-sm-6 col-md-3">
									<img src="${urlPublic}/images/${ceofoto}"
										class="center-block img-circle" alt="Nanifarfalla Customer">
									<h3 class="customer-name">${ceonombre}${ceopaterno}
										</h3>
									<p>${ceomensaje}</p>
									<span class="light-bg customer-rating"
										data-rating="${ceocodigo}"> ${ceocodigo}
										 <i class="fa fa-star	"></i>
										 </span>
								</div>
							</div>
							<!-- /slider item -->

							<!-- slider item -->
							<div class="feedback-slider-item">
								<div class="col-xs-12 col-sm-6 col-md-3">
									<img src="${urlPublic}/images/${ceolfoto}"
										class="center-block img-circle" alt="Nanifarfalla Customer">
									<h3 class="customer-name">${ceolnombre}${ceolpaterno}
										</h3>
									<p>${ceolmensaje}</p>
									<span class="light-bg customer-rating"
										data-rating="${ceorcodigo}"> ${ceolcodigo} 
										 <i class="fa fa-star"></i>
										</span>
								</div>
							</div>
							<!-- /slider item -->




							<!-- slider item -->

							<!-- slider item -->
							<div class="feedback-slider-item">
								<div class="col-xs-12 col-sm-6 col-md-3">
									<img src="${urlPublic}/images/${ceorfoto}}"
										class="center-block  img-circle" alt="Nanifarfalla Customer">
									<h3 class="customer-name">${ceornombre}${ceorpaterno}
									</h3>
									<p>${ceormensaje}</p>
									<span class="light-bg customer-rating"
										data-rating="${ceorcodigo}"> <i class="fa fa-star"></i>
									</span>
								</div>
							</div>
							<!-- /slider item -->


							<!-- /End feedback-slider -->



							<!-- /side thumbnail -->
						</div>
						<div class="feedback-slider-thumb hidden-xs">
							<div class="thumb-prev">
								<span> <img src="${urlPublic}/images/${ceolfoto}"
									alt="Nanifarfalla Customer">
								</span> <span class="light-bg customer-rating"
									data-rating="${ceolcodigo}"> ${ceolcodigo}<i
									class="fa fa-star"></i>
								</span>
							</div>

							<div class="thumb-next">
								<span> <img src="${urlPublic}/images/${ceorfoto}"
									alt="Nanifarfalla Customer">
								</span> <span class="light-bg customer-rating"
									data-rating="${ceorcodigo}"> ${ceorcodigo} <i
									class="fa fa-star"></i>
								</span>
							</div>
						</div>


					</div>
					<!-- /End col -->
				</div>
				<!-- /End row -->
			</div>
			<!-- /End container -->

		</div>
		<!-- /End customer-feedback -->
	</section>


</table>


</html>



