
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />

<jsp:include page="../includes/link.jsp"></jsp:include>

<!-- custom javascript -->
<jsp:include page="../includes/script.jsp"></jsp:include>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<div class="popup" onclick="myFunction()"></div>
<nav class="navbar navbar-preview fixed-top">
	<div
		class="container-fluid d-flex justify-content-between align-items-center w-100">
		<div class="popup" onclick="myFunction()">
			<span class="popuptext" id="myPopup">Rights Reserved®</span><a
				class="my-lg-0 text-gray-soft"
				href="https://www.facebook.com/nanifarfalla/" target="_blank"><i
				class="fab fa-facebook"> </i> <span class="d-none d-sm-inline">Nanifarfalla
					Facebook</span></a>
		</div>
		<div class="form-inline">
			<div class="btn-group d-none d-sm-flex">
				<a class="dropdown-toggle text-gray-soft" js-price-dropdown="true"
					href="#" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Made by Joffre Hermosilla Salas </a> <i
					class="fa fa-power-off"> </i>
				<div
					class="dropdown-menu dropdown-menu--xl dropdown-menu--centered dropdown-menu--has-triangle">
					<button class="dropdown-block-item switch_price_prod"
						data-type="Standard License" data-price="Read before You Buy"
						data-price_label="" data-label=" ">
						<div
							class="d-flex justify-content-between align-items-center mb-2">
							<span>Arquitectura del Sitio Web </span><span
								class="d-flex align-items-center"></span>
						</div>
						<ul class="fs-13 text-gray-soft mb-2">
							<li>FrontEnd: Bootstrap 4.3x</li>
							<li>BackEnd: SpringBoot MVC 5.xx</li>
							<li>BackEnd: SpringSecurity 2.xx</li>
							<li>ApiRest: Swagger{ } 3.xx</li>
							<li>Database: MySQL 5.xx</li>
							<li>Android: Graddle 5.xx</li>
							<li>Package: Maven 3.5x</li>
						</ul>
						<p class="fs-11 text-gray-soft">
							Contact with me <a
								href="https://www.projectmanagement.com/profile/JoffreHermosillaSalas"
								target="_blank">Personal Site</a>
						</p>
					</button>
					<div class="dropdown-divider"></div>
					<button class="dropdown-block-item switch_price_prod" data-type=""
						data-price="" data-price_label="$" data-label="">
						<div
							class="d-flex justify-content-between align-items-center mb-2">
							<span>Catalogo Venta</span><span
								class="d-flex align-items-center">App Ventas</span>
						</div>
						<ul class="fs-13 text-gray-soft mb-2">
							<li>Java |jsp |json|js |css |html |xml |i18n |apache
								|ReactXD |thymeleaf</li>
						</ul>
					</button>
				</div>
			</div>
		</div>
		<div class="form-inline">
			<div class="btn-group d-none d-sm-flex">
				<a class="dropdown-toggle text-gray-soft" js-price-dropdown="true"
					href="#" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <fmt:message key="quality.lang" />

				</a>
				<div
					class="dropdown-menu dropdown-menu--xl dropdown-menu--centered dropdown-menu--has-triangle">
					<button class="dropdown-block-item switch_price_prod"
						data-type="Standard License" data-price="Read before You Buy"
						data-price_label="" data-label=" ">
						<div
							class="d-flex justify-content-between align-items-center mb-2">
							<span> <fmt:message key="demo.lang" /></span><span
								class="d-flex align-items-center"></span>
						</div>
						<ul class="fs-13 text-gray-soft mb-2">
							<li id="usuarioa"><a href="${contextRoot}/demoa"><fmt:message
										key="benefita.lang" /></a></li>
							<li id="usuariob"><a href="${contextRoot}/demob"><fmt:message
										key="benefitb.lang" /></a></li>
							<li id="usuarioc"><a href="${contextRoot}/democ"><fmt:message
										key="benefitc.lang" /></a></li>
						</ul>
						<p class="fs-11 text-gray-soft">
							Read the full <a href="">© Copyright 2020 All rights reserved</a>
						</p>
					</button>
					<div class="dropdown-divider"></div>
					<button class="dropdown-block-item switch_price_prod"
						data-type="© Copyright 2020 All rights reserved" data-price=""
						data-price_label="$"
						data-label="© Copyright 2020 All rights reserved">
						<div
							class="d-flex justify-content-between align-items-center mb-2">
							<span> Nanifarfalla</span><span class="d-flex align-items-center">Terminos
								y Condiciones</span>
						</div>
						<ul class="fs-13 text-gray-soft mb-2">
							<li>Use for a single product</li>
							<li>Paying users allowed</li>
						</ul>
					</button>
				</div>
			</div>
			<form action="" method="POST" class=" btn-block inline-block">
				<input type="hidden" js-license-type="license_type"
					name="license_type" value="Standard License"> <input
					type="hidden" name="add-to-cart" value="">
				<button type="submit" class=" btn btn-brand btn-block btn-checkout">
					<span class="btn-text"> Show Your Own Products<span
						class="btn__label btn__label--right"
						js-price-value="main_price_div"> <b id="price_val"> </b></span></span>
				</button>
			</form>
			<a class="text-gray ml-3" href=""> <small> <i
					class="fa fa-gifts"></i>
			</small>
			</a>
		</div>
	</div>


</nav>