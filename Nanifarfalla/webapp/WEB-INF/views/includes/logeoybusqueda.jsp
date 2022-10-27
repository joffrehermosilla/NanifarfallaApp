	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
	<html lang="en" xmlns:th="http://www.thymeleaf.org">

	
	<spring:url value="/resources" var="urlPublic" />


<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="${flowExecutionUrl}&_eventId_home"> <img
			src="${urlPublic}/images/nanifarfalla.jpeg" width="30" height="30"
			class="d-inline-block align-top" alt=""> Nani <span
			class="badge badge-pill badge-warning">far</span> <span
			class="badge badge-pill badge-danger">fa</span> <span
			class="badge badge-pill badge-success">lla</span>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<nav class="navbar navbar-light bg-light">
			<form class="form-inline">
				<div class="col-xs-72 col-sm-36 col-md-48" style="width: 48rem"
					align="left">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" style="width: 32rem">

					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</div>
			</form>
		</nav>
		<ul class="navbar-nav mr-auto">
			<li><a class="navbar-brand" href="#"> <img
					src="${urlPublic}/images/nanifarfalla.jpeg" width="30" height="30"
					class="d-inline-block align-top" alt="">Login

			</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button></li>
		</ul>
		<ul class="navbar-nav mr-auto">
			<li><a class="navbar-brand" href="#"> <img
					src="${urlPublic}/images/nanifarfalla.jpeg" width="30" height="30"
					class="d-inline-block align-top" alt="">My Cart

			</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button></li>

		</ul>
	</nav>