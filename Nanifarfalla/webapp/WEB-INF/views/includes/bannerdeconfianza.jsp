
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />

<article class="card card-body">


	<div class="row text-heading">
		<div class="col-md-4">
			<figure class="item-feature text-heading">
				<span class="text-primary"><i class="fa fa-2x fa-truck"></i></span>
				<figcaption class="pt-3">
					<a class="nav-link ">
						<h5>Fast delivery</h5>
						<p>Dolor sit amet, consectetur adipisicing elit, sed do
							eiusmod tempor incididunt ut labore</p>
					</a>
				</figcaption>
			</figure>
			<!-- iconbox // -->
		</div>
		<!-- col // -->
		<div class="col-md-4">
			<figure class="item-feature-ceo">
				<span class="text-primary"><i class="fa fa-2x fa-landmark"></i></span>
				<figcaption class="pt-3">
					<h5 class="title">Creative Strategy</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod</p>
				</figcaption>
			</figure>
			<!-- iconbox // -->
		</div>
		<!-- col // -->
		<div class="col-md-4">
			<figure class="item-feature">
				<span class="text-primary"><i class="fa fa-2x fa-lock"></i></span>
				<figcaption class="pt-3">
					<h5 class="title">High secured</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod</p>
				</figcaption>
			</figure>
			<!-- iconbox // -->
		</div>
		<!-- col // -->
	</div>

</article>
				
</html>