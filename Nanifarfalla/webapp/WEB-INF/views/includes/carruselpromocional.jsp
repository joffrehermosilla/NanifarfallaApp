
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



</head>



<section class="cz-carousel cz-controls-lg">
	<nav class="navbar  navbar-expand-lg fixed top navbar-preview">

		<c:set var="carruselcat1" value="${1}" />
		<c:set var="carruselcat2" value="${2}" />
		<c:set var="carruselcat3" value="${3}" />
		<c:set var="carruselcat4" value="${4}" />


		<div id="carousel1_indicator" class="carousel slide"
			data-ride="carousel">

			<%!String test = new String();%>

			<ol class="carousel-indicators">
				<c:forEach items="${anuncios}" var="anuncios">

					<fmt:parseNumber var="i" value="${anuncios.codigo_anuncio}" />


					<li data-target="#carousel1_indicator" data-slide-to="${i}"
						class="active"></li>
				</c:forEach>
				<!-- 	<li data-target="#carousel1_indicator" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel1_indicator" data-slide-to="1"></li>
				<li data-target="#carousel1_indicator" data-slide-to="2"></li>
				<li data-target="#carousel1_indicator" data-slide-to="3"></li> -->
			</ol>


			<div class="carousel-inner" align="center">
				<c:forEach items="${anuncios}" var="anuncios">
					<c:choose>
						<c:when test="${anuncios.fkcodigo_tipoalerta==carruselcat1}">
							<div class="carousel-item active">
								<div class="px-lg-5 tns-item tns-normal"
									style="background-color: rgb(235, 161, 112);" id="tns2-item0"
									aria-hidden="true" tabindex="-1">
									<div
										class="d-lg-flex justify-content-between align-items-center pl-lg-4">


										<img class="d-block order-lg-2 mr-lg-n5 flex-shrink-0"
											src="${urlPublic}/images/yellowbutterfly.png"
											alt="Summer Collection">
										<figure class="snip0016">
											<img class="d-block order-lg-2 mr-lg-n5 flex-shrink-0"
												src="${urlPublic}/images/yellowbutterfly.png"
												alt="Summer Collection">
											<figcaption>
												<h2>${fechabusqueda}</h2>
												<p>
													<b>${anuncios.anuncio_principal }</b>
												</p>
												<a href="#"></a>
											</figcaption>

										</figure>




										<div
											class="position-relative mx-auto mr-lg-n5 py-5 px-4 mb-lg-5 order-lg-1"
											style="max-width: 42rem; z-index: 10;">
											<div
												class="pb-lg-5 mb-lg-5 text-center text-lg-left text-lg-nowrap">
												<h2 class="text-light font-weight-light pb-1 from-left">
													<fmt:message key="label.carrusel.encabezado1" />

													<div class="divefectomovimiento">
														<ol>
															<span>${anuncios.mensaje_anuncio}</span>
														</ol>
													</div>

												</h2>
												<h1 class="text-light display-4 from-bottom delay-1">${anuncios.anuncio_principal }
												</h1>
												<p class="font-size-lg text-light pb-3 from-left delay-2">
												<h3 class="font-size-lg text-light pb-3 from-left delay-2">

													<fmt:message key="label.carrusel.pie1" />
													<ol></ol>
													<div class="divefectomovimiento">
														<span>${anuncios.pie_mensaje}</span>
													</div>
													</ol>
												</h3>
												</p>
												<a class="btn btn-primary scale-up delay-4"
													href="shop-grid-ls.html">Shop Now<i
													class="czi-arrow-right ml-2 mr-n1"></i></a>
											</div>
										</div>

									</div>
								</div>
							</div>

						</c:when>
						<c:when test="${anuncios.fkcodigo_tipoalerta==carruselcat2}">

							<div class="carousel-item">
								<div class="px-lg-5 tns-item tns-normal"
									style="background-color: rgb(112, 224, 161);" id="tns2-item0"
									aria-hidden="true" tabindex="-1">
									<div
										class="d-lg-flex justify-content-between align-items-center pl-lg-4">





										<img class="d-block order-lg-2 mr-lg-n5 flex-shrink-0"
											src="${urlPublic}/images/yellowbutterfly.png"
											alt="Summer Collection">
										<figure class="snip0016">
											<img class="d-block order-lg-2 mr-lg-n5 flex-shrink-0"
												src="${urlPublic}/images/yellowbutterfly.png"
												alt="Summer Collection">
											<figcaption>
												<h2>${fechabusqueda}</h2>
												<p>
													<b>${anuncios.anuncio_principal }</b>
												</p>
												<a href="#"></a>
											</figcaption>

										</figure>




										<div
											class="position-relative mx-auto mr-lg-n5 py-5 px-4 mb-lg-5 order-lg-1"
											style="max-width: 42rem; z-index: 10;">
											<div
												class="pb-lg-5 mb-lg-5 text-center text-lg-left text-lg-nowrap">
												<h2 class="text-light font-weight-light pb-1 from-left">
													<fmt:message key="label.carrusel.encabezado2" />
													<ol>
														<div class="divefectomovimiento">
															<span>${anuncios.mensaje_anuncio}</span>
														</div>
													</ol>
												</h2>
												<h1 class="text-light display-4 from-bottom delay-1">${anuncios.anuncio_principal }
												</h1>
												<p class="font-size-lg text-light pb-3 from-left delay-2">
												<h3 class="font-size-lg text-light pb-3 from-left delay-2">

													<fmt:message key="label.carrusel.pie2" />
													<ol>
														<div class="divefectomovimiento">
															<span>${anuncios.pie_mensaje}</span>
														</div>
													</ol>
												</h3>
												</p>
												<a class="btn btn-primary scale-up delay-4"
													href="shop-grid-ls.html">Shop Now<i
													class="czi-arrow-right ml-2 mr-n1"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:when>
						<c:when test="${anuncios.fkcodigo_tipoalerta==carruselcat3}">
							<div class="carousel-item">
								<div class="px-lg-5 tns-item tns-normal"
									style="background-color: rgb(58, 175, 210);" id="tns2-item0"
									aria-hidden="true" tabindex="-1">
									<div
										class="d-lg-flex justify-content-between align-items-center pl-lg-4">
										<img class="d-block order-lg-2 mr-lg-n5 flex-shrink-0"
											src="${urlPublic}/images/yellowbutterfly.png"
											alt="Summer Collection">
										<figure class="snip0016">
											<img class="d-block order-lg-2 mr-lg-n5 flex-shrink-0"
												src="${urlPublic}/images/yellowbutterfly.png"
												alt="Summer Collection">
											<figcaption>
												<h2>${fechabusqueda}</h2>
												<p>
													<b>${anuncios.anuncio_principal }</b>
												</p>
												<a href="#"></a>
											</figcaption>

										</figure>
										<div
											class="position-relative mx-auto mr-lg-n5 py-5 px-4 mb-lg-5 order-lg-1"
											style="max-width: 42rem; z-index: 10;">
											<div
												class="pb-lg-5 mb-lg-5 text-center text-lg-left text-lg-nowrap">
												<h2 class="text-light font-weight-light pb-1 from-left">
													<fmt:message key="label.carrusel.encabezado3" />
													<ol>
														<div class="divefectomovimiento">
															<span>${anuncios.mensaje_anuncio}</span>
														</div>
													</ol>
												</h2>
												<h1 class="text-light display-4 from-bottom delay-1">${anuncios.anuncio_principal }
												</h1>
												<p class="font-size-lg text-light pb-3 from-left delay-2">
												<h3 class="font-size-lg text-light pb-3 from-left delay-2">

													<fmt:message key="label.carrusel.pie3" />
													<ol>
														<div class="divefectomovimiento">
															<span>${anuncios.pie_mensaje}</span>
														</div>
													</ol>
												</h3>

												<a class="btn btn-primary scale-up delay-4"
													href="shop-grid-ls.html">Shop Now<i
													class="czi-arrow-right ml-2 mr-n1"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:when>
						<c:when test="${anuncios.fkcodigo_tipoalerta==carruselcat4}">
							<div class="carousel-item">
								<div class="px-lg-5 tns-item tns-normal"
									style="background-color: rgb(245, 177, 176);" id="tns2-item0"
									aria-hidden="true" tabindex="-1">
									<div
										class="d-lg-flex justify-content-between align-items-center pl-lg-4">
										<img class="d-block order-lg-2 mr-lg-n5 flex-shrink-0"
											src="${urlPublic}/images/yellowbutterfly.png"
											alt="Summer Collection">
										<figure class="snip0016">
											<img class="d-block order-lg-2 mr-lg-n5 flex-shrink-0"
												src="${urlPublic}/images/yellowbutterfly.png"
												alt="Summer Collection">
											<figcaption>
												<h2>${fechabusqueda}</h2>
												<p>
													<b>${anuncios.anuncio_principal }</b>
												</p>
												<a href="#"></a>
											</figcaption>

										</figure>
										<div
											class="position-relative mx-auto mr-lg-n5 py-5 px-4 mb-lg-5 order-lg-1"
											style="max-width: 42rem; z-index: 10;">
											<div
												class="pb-lg-5 mb-lg-5 text-center text-lg-left text-lg-nowrap">
												<h2 class="text-light font-weight-light pb-1 from-left">
													<fmt:message key="label.carrusel.encabezado3" />
													<ol>
														<div class="divefectomovimiento">
															<span>${anuncios.mensaje_anuncio}</span>
														</div>
													</ol>
												</h2>
												<h1 class="text-light display-4 from-bottom delay-1">${anuncios.anuncio_principal }
												</h1>
												<p class="font-size-lg text-light pb-3 from-left delay-2">
												<h3 class="font-size-lg text-light pb-3 from-left delay-2">

													<fmt:message key="label.carrusel.pie3" />
													<ol>
														<div class="divefectomovimiento">
															<span>${anuncios.pie_mensaje}</span>
														</div>
													</ol>
												</h3>

												<a class="btn btn-primary scale-up delay-4"
													href="shop-grid-ls.html">Shop Now<i
													class="czi-arrow-right ml-2 mr-n1"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:when>


					</c:choose>
				</c:forEach>

			</div>
			<a class="carousel-control-prev" href="#carousel1_indicator"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carousel1_indicator"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>












	</nav>
</section>