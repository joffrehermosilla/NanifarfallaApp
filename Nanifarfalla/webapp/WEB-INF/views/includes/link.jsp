
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />


<link href="${urlPublic}/images/frontend/iconos/mainsite/logos/MARIPOSAS.ico" rel="shortcut icon"
	type="image/x-icon">

<!-- jQuery -->
<script src="${urlPublic}/js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap4 files-->
<script src="${urlPublic}/js/bootstrap.bundle.min.js"
	type="text/javascript"></script>
<link href="${urlPublic}/css/bootstrap.css" rel="stylesheet"
	type="text/css" />

<!-- Font awesome 5 -->
<link href="${urlPublic}/fonts/fontawesome/css/all.min.css"
	type="text/css" rel="stylesheet">

<!-- custom style -->
<link href="${urlPublic}/css/ui.css" rel="stylesheet" type="text/css" />
<link href="${urlPublic}/css/responsive.css" rel="stylesheet"
	media="only screen and (max-width: 1200px)" />

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<link rel="profile" href="http://gmpg.org/xfn/11">

<link rel="apple-touch-icon" sizes="180x180"
	href="${urlPublic}/images/frontend/iconos/mainsite/logos/MARIPOSAS.ico">
<link rel="icon" type="image/png" sizes="32x32"
	href="${urlPublic}/images/frontend/iconos/mainsite/logos/MARIPOSAS.ico">
<link rel="icon" type="image/png" sizes="16x16"
	href="${urlPublic}/images/frontend/iconos/mainsite/logos/MARIPOSAS.ico">
<link rel="manifest"
	href="${urlPublic}/images/frontend/iconos/mainsite/logos/MARIPOSAS.ico">
<link rel="shortcut icon" href="${urlPublic}/images/frontend/iconos/mainsite/logos/MARIPOSAS.ico">
<meta name="msapplication-config"
	content="${urlPublic}/images/icons/nanifarfalllaicon.ico">

<link rel="stylesheet" id="buttons-css"
	href="${urlPublic}/css/buttons.min.css" type="text/css" media="all">
<link rel="stylesheet" id="dashicons-css"
	href="${urlPublic}/css/dashicons.min.css" type="text/css" media="all">

<link rel="stylesheet" id="dokan-opensans-css"
	href="https://fonts.googleapis.com/css?family=Open+Sans%3A400%2C700&amp;ver=4.8.4"
	type="text/css" media="all">

<link rel="stylesheet" id="flexslider-css"
	href="${urlPublic}/css/flexslider.css" type="text/css" media="all">

<link rel="stylesheet" id="dokan-theme-skin-css"
	href="${urlPublic}/css/purple.css" type="text/css" media="all">

<link rel="" id="strip" href="${urlPublic}/css/efectoletras.css"
	type="text/css" media="all">
	


<link rel="stylesheet" id="letrasmovibles-css"
	href="${urlPublic}/css/letrasmovimiento.css" type="text/css"
	media="all">

<link rel="stylesheet" id="animate-css"
	href="${urlPublic}/css/animate.css" type="text/css" media="all">

<link rel="stylesheet" id="letrasmovibles-css"
	href="${urlPublic}/css/popupcontainer.css" type="text/css" media="all">


<link rel="stylesheet" id="margin-css"
	href="${urlPublic}/css/margin.css" type="text/css" media="all">


<link rel="stylesheet" id="catalogo-aleatorio-css"
	href="${urlPublic}/css/catalogoaleatorio.css" type="text/css"
	media="all">


<link rel="profile" href="http://gmpg.org/xfn/11">


<link rel="stylesheet" id="animate-css"
	href="${urlPublic}/css/animate.css" type="text/css" media="all">


<link rel="stylesheet" id="buttons-css"
	href="${urlPublic}/css/buttons.min.css" type="text/css" media="all">
<link rel="stylesheet" id="dashicons-css"
	href="${urlPublic}/css/dashicons.min.css" type="text/css" media="all">
<link rel="stylesheet" id="mediaelement-css"
	href="${urlPublic}/css/mediaelementplayer.min.css" type="text/css"
	media="all">
<link rel="stylesheet" id="wp-mediaelement-css"
	href="${urlPublic}/css/wp-mediaelement.min.css" type="text/css"
	media="all">
<link rel="stylesheet" id="media-views-css"
	href="${urlPublic}/css/media-views.min.css" type="text/css" media="all">


<link rel="stylesheet" id="owl-carousel-css"
	href="${urlPublic}/css/owl.carousel.min.css" type="text/css"
	media="all">
	<link rel="stylesheet" id="ceoshowing-css"
	href="${urlPublic}/css/ceoshowing.css" type="text/css">
	
	




<link rel="stylesheet" id="woocommerce-layout-css"
	href="${urlPublic}/css/woocommerce-layout.css?ver=3.8.1"
	type="text/css" media="all">


<link rel="stylesheet" id="woocommerce-smallscreen-css"
	href="${urlPublic}/css/woocommerce-smallscreen.css?ver=3.8.1"
	type="text/css" media="only screen and (max-width: 768px)">
<link rel="stylesheet" id="woocommerce-general-css"
	href="${urlPublic}/css/woocommerce.css?ver=3.8.1" type="text/css"
	media="all">


<link rel="stylesheet" id="imgareaselect-css"
	href="${urlPublic}/css/imgareaselect.css" type="text/css" media="all">

<link rel="stylesheet" id="margin-css"
	href="${urlPublic}/css/margin.css" type="text/css" media="all">
		


	
<link rel="stylesheet" href="${urlPublic}/css/style.css?ver=1576164497">

<link rel="stylesheet" id="figuracaption-css"
	href="${urlPublic}/css/figuracaption.css" type="text/css" media="all">
	
	<link rel="stylesheet" id="calendar-css"
	href="${urlPublic}/css/calendar.css" type="text/css" media="all">

		<link rel="stylesheet" id="zoom-css"
	href="${urlPublic}/css/zoom.css" type="text/css" media="all">