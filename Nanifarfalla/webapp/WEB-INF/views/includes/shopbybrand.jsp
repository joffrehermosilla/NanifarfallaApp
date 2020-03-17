
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />



<section class="container py-lg-4 mb-4" style="align-self: center;">
	<h2 class="h3 text-center pb-4">Shop by brand</h2>

	<div class="row">
		<div class="col-md-3 col-sm-4 col-6">
			<a
				class="d-block bg-white box-shadow-sm rounded-lg py-3 py-sm-4 mb-grid-gutter"
				href="#"><img class="d-block mx-auto"
				src="img/shop/brands/01.png" style="width: 150px;" alt="Brand"></a>
		</div>
		
	</div>
</section>