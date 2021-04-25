
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
<!-- DataTable Bootstrap Script -->
<script src="${js}/angular.js"></script>

<!-- DataTable Bootstrap Script -->
<script src="${urlPublic}/ecommerce/assests/js/productsController.js"></script>
	<%@include file="../shared/navbar.jsp"%>
<div class="container" ng-app="ShoppingApp"
	ng-controller="ProductController as pCtrl">

	<div class="row" ng-init="pCtrl.fetchProducts()">

		<div class="col-md-3">
			<%@include file="../shared/sidebar.jsp"%>
				
		</div>

		<div class="col-md-9">

			<div class="row carousel-holder">

				<div class="col-md-12">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						</ol>
						<div class="carousel-inner">

							<div class="item active">
								<img class="slide-image" src="${images}/banner1.jpg" alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/banner2.jpg" alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/banner3.jpg" alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/banner4.jpg" alt="">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-xs-12">
					<h3>Our Most Viewed Products</h3>
					<hr />
				</div>
			</div>

			<div class="row is-table-row">

				<div class="col-sm-4" ng-repeat="product in pCtrl.mvProducts">
					<div class="thumbnail">
						<img ng-src="${images}/{{product.codigo_producto}}.jpg"
							alt="${product.nombre_producto}" class="landingImg">
						<h5>${product.nombre_producto}</h5>
						<hr />
						<div class="caption">
							<h4 class="pull-right">&#8377; ${product.pvf_producto}</h4>
							<p>${product.preparacion_producto}</p>
							<a ng-href="${contextRoot}/show/{{productos.codig_producto}}/product"
								class="btn btn-primary pull-right">View</a>
						</div>
					</div>

				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>Checkout more products!</h4>
					<hr />
					<a class="btn btn-primary" href="${contextRoot}/show/all/products">More
						Products</a>
				</div>

			</div>

			<div class="row">
				<div class="col-xs-12">
					<h3>Our Most Purchased Products</h3>
					<hr />
				</div>
			</div>
			<div class="row is-table-row">

				<div class="col-sm-4" ng-repeat="product in pCtrl.mpProducts">
					<div class="thumbnail">
						<img ng-src="${images}/{{product.codidgo_producto}}.jpg"
							alt="${product.nombre_producto}" class="landingImg">
						<h5>${product.nombre_producto}</h5>
						<hr />
						<div class="caption">
							<h4 class="pull-right">&#8377; ${product.pvf_producto}</h4>
							<p>${product.preparacion_producto}</p>
							<a ng-href="${contextRoot}/show/{{product.codigo_producto}}/product"
								class="btn btn-primary pull-right">View</a>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>Checkout more products!</h4>
					<hr />
					<a class="btn btn-primary" href="${contextRoot}/show/all/products">More
						Products</a>
				</div>

			</div>

		</div>

	</div>

</div>
<!-- /.container -->

</html>