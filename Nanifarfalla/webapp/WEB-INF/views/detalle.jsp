
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />

<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Nanifarfalla | Bienvenido</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/productos/index" var="urlForm"></spring:url>
<spring:url value="/productos/create" var="urlCreate" />
<spring:url value="/lineas/create" var="lineaCreate" />
<spring:url value="/" var="urlRoot" />

<jsp:include page="includes/link.jsp"></jsp:include>
<jsp:include page="includes/script.jsp"></jsp:include>
</head>
<body>

	<header class="section-header">

		<section class="section-content padding-y-sm">
			<div class="container">
				<jsp:include page="includes/presentacioncreador.jsp"></jsp:include>

			</div>
			<!-- container .//  -->
		</section>
		<jsp:include page="includes/estadoymenu.jsp"></jsp:include>

		<jsp:include page="includes/navbarheader.jsp"></jsp:include>

	</header>
	<!-- section-header.// -->



	<!-- ========================= SECTION PAGETOP ========================= -->
	<section class="section-pagetop bg">
		<div class="container">
			<h2 class="title-page">${linea.nombre_linea}</h2>
			<nav>
				<ol class="breadcrumb text-white">
					<li class="breadcrumb-item"><a href="#">Home</a></li>
					<li class="breadcrumb-item"><a href="#">Best category</a></li>
					<li class="breadcrumb-item active" aria-current="page">Great
						articles</li>
				</ol>
			</nav>
		</div>
		<!-- container //  -->
	</section>
	<!-- ========================= SECTION INTRO END// ========================= -->

	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content padding-y">
		<div class="container">

			<div class="row">
				<aside class="col-md-3">

					<div class="card">
						<article class="filter-group">
							<header class="card-header">
								<a href="#" data-toggle="collapse" data-target="#collapse_1"
									aria-expanded="true" class=""> <i
									class="icon-control fa fa-chevron-down"></i>
									<h6 class="title">Product type</h6>
								</a>
							</header>
							<div class="filter-content collapse show" id="collapse_1"
								style="">
								<div class="card-body">
									<form class="pb-3">
										<div class="input-group">
											<input type="text" class="form-control" placeholder="Search">
											<div class="input-group-append">
												<button class="btn btn-light" type="button">
													<i class="fa fa-search"></i>
												</button>
											</div>
										</div>
									</form>


									<c:forEach var="producto" items="${productos}">
										<c:set var="i" value="${linea.codigo_linea}" />
										<c:choose>
											<c:when test="${i eq producto.fkcodigo_linea}">
												<ul class="list-menu">
													<li><a href="../lineas/detalle">${producto.nombre_producto}</a></li>

												</ul>
											</c:when>
										</c:choose>
									</c:forEach>
								</div>
								<!-- card-body.// -->
							</div>
						</article>
						<!-- filter-group  .// -->
						<article class="filter-group">
							<header class="card-header">
								<a href="#" data-toggle="collapse" data-target="#collapse_2"
									aria-expanded="true" class=""> <i
									class="icon-control fa fa-chevron-down"></i>
									<h6 class="title">Brands</h6>
								</a>
							</header>
							<div class="filter-content collapse show" id="collapse_2"
								style="">
								<div class="card-body">
									<label class="custom-control custom-checkbox"> <input
										type="checkbox" checked="" class="custom-control-input">
										<div class="custom-control-label">
											Mercedes <b class="badge badge-pill badge-light float-right">120</b>
										</div>
									</label> <label class="custom-control custom-checkbox"> <input
										type="checkbox" checked="" class="custom-control-input">
										<div class="custom-control-label">
											Toyota <b class="badge badge-pill badge-light float-right">15</b>
										</div>
									</label> <label class="custom-control custom-checkbox"> <input
										type="checkbox" checked="" class="custom-control-input">
										<div class="custom-control-label">
											Mitsubishi <b
												class="badge badge-pill badge-light float-right">35</b>
										</div>
									</label> <label class="custom-control custom-checkbox"> <input
										type="checkbox" checked="" class="custom-control-input">
										<div class="custom-control-label">
											Nissan <b class="badge badge-pill badge-light float-right">89</b>
										</div>
									</label> <label class="custom-control custom-checkbox"> <input
										type="checkbox" class="custom-control-input">
										<div class="custom-control-label">
											Honda <b class="badge badge-pill badge-light float-right">30</b>
										</div>
									</label>
								</div>
								<!-- card-body.// -->
							</div>
						</article>
						<!-- filter-group .// -->
						<article class="filter-group">
							<header class="card-header">
								<a href="#" data-toggle="collapse" data-target="#collapse_3"
									aria-expanded="true" class=""> <i
									class="icon-control fa fa-chevron-down"></i>
									<h6 class="title">Price range</h6>
								</a>
							</header>
							<div class="filter-content collapse show" id="collapse_3"
								style="">
								<div class="card-body">
									<input type="range" class="custom-range" min="0" max="100"
										name="">
									<div class="form-row">
										<div class="form-group col-md-6">
											<label>Min</label> <input class="form-control"
												placeholder="$0" type="number">
										</div>
										<div class="form-group text-right col-md-6">
											<label>Max</label> <input class="form-control"
												placeholder="$1,0000" type="number">
										</div>
									</div>
									<!-- form-row.// -->
									<button class="btn btn-block btn-primary">Apply</button>
								</div>
								<!-- card-body.// -->
							</div>
						</article>
						<!-- filter-group .// -->
						<article class="filter-group">
							<header class="card-header">
								<a href="#" data-toggle="collapse" data-target="#collapse_4"
									aria-expanded="true" class=""> <i
									class="icon-control fa fa-chevron-down"></i>
									<h6 class="title">Sizes</h6>
								</a>
							</header>
							<div class="filter-content collapse show" id="collapse_4"
								style="">
								<div class="card-body">
									<label class="checkbox-btn"> <input type="checkbox">
										<span class="btn btn-light"> XS </span>
									</label> <label class="checkbox-btn"> <input type="checkbox">
										<span class="btn btn-light"> SM </span>
									</label> <label class="checkbox-btn"> <input type="checkbox">
										<span class="btn btn-light"> LG </span>
									</label> <label class="checkbox-btn"> <input type="checkbox">
										<span class="btn btn-light"> XXL </span>
									</label>
								</div>
								<!-- card-body.// -->
							</div>
						</article>
						<!-- filter-group .// -->
						<article class="filter-group">
							<header class="card-header">
								<a href="#" data-toggle="collapse" data-target="#collapse_5"
									aria-expanded="false" class=""> <i
									class="icon-control fa fa-chevron-down"></i>
									<h6 class="title">More filter</h6>
								</a>
							</header>
							<div class="filter-content collapse in" id="collapse_5" style="">
								<div class="card-body">
									<label class="custom-control custom-radio"> <input
										type="radio" name="myfilter_radio" checked=""
										class="custom-control-input">
										<div class="custom-control-label">Any condition</div>
									</label> <label class="custom-control custom-radio"> <input
										type="radio" name="myfilter_radio"
										class="custom-control-input">
										<div class="custom-control-label">Brand new</div>
									</label> <label class="custom-control custom-radio"> <input
										type="radio" name="myfilter_radio"
										class="custom-control-input">
										<div class="custom-control-label">Used items</div>
									</label> <label class="custom-control custom-radio"> <input
										type="radio" name="myfilter_radio"
										class="custom-control-input">
										<div class="custom-control-label">Very old</div>
									</label>
								</div>
								<!-- card-body.// -->
							</div>
						</article>
						<!-- filter-group .// -->
					</div>
					<!-- card.// -->

				</aside>
				<!-- col.// -->
				<main class="col-md-9">

					<header class="border-bottom mb-4 pb-3">
						<div class="form-inline">
							<span class="mr-md-auto">32 Items found </span> <select
								class="mr-2 form-control">
								<option>Latest items</option>
								<option>Trending</option>
								<option>Most Popular</option>
								<option>Cheapest</option>
							</select>
							<div class="btn-group">
								<a href="#" class="btn btn-outline-secondary active"
									data-toggle="tooltip" title="List view"> <i
									class="fa fa-bars"></i></a> <a href="#"
									class="btn  btn-outline-secondary" data-toggle="tooltip"
									title="Grid view"> <i class="fa fa-th"></i></a>
							</div>
						</div>
					</header>
					<!-- sect-heading -->

					<c:forEach var="producto" items="${productos}">
						<c:set var="i" value="${linea.codigo_linea}" />
						<c:choose>
							<c:when test="${i eq producto.fkcodigo_linea}">
								<article class="card card-product-list">
									<div class="row no-gutters">
										<aside class="col-md-3">
											<a href="#" class="img-wrap"> <span
												class="badge badge-danger"> NEW </span> <img
												src="${urlPublic}/images/lineas/nanifarfalla/${linea.foto_linea}">
											</a>
										</aside>
										<!-- col.// -->
										<div class="col-md-6">
											<div class="info-main">
												<a href="#" class="h5 title">${producto.nombre_producto}
												</a>
												<div class="rating-wrap mb-3">
													<ul class="rating-stars">
														<li style="width: 80%" class="stars-active"><i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i></li>
														<li><i class="fa fa-star"></i> <i class="fa fa-star"></i>
															<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i></li>
													</ul>
													<div class="label-rating">7/10</div>
												</div>
												<!-- rating-wrap.// -->

												<p>${producto.preparacion_producto}</p>
											</div>
											<!-- info-main.// -->
										</div>
										<!-- col.// -->
										<aside class="col-sm-3">
											<div class="info-aside">
												<div class="price-wrap">
													<span class="price h5"> $ ${producto.ppv_producto} </span>
													<del class="price-old"> $ ${producto.pvf_producto}</del>
												</div>
												<!-- info-price-detail // -->
												<p class="text-success">Free shipping</p>
												<br>
												<p>

													<a
														href="${urlRoot}productos/detalle?codigo_producto=${producto.codigo_producto}"
														class="btn btn-primary">Detalle del producto</a> <a
														href="#" class="btn btn-light btn-block"><i
														class="fa fa-heart"></i> <span class="text">Add to
															wishlist</span> </a>
												</p>
											</div>
											<!-- info-aside.// -->
										</aside>
										<!-- col.// -->
									</div>
									<!-- row.// -->
								</article>
								<!-- card-product .// -->
							</c:when>
						</c:choose>
					</c:forEach>





					<nav aria-label="Page navigation sample">
						<ul class="pagination">
							<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
							<li class="page-item active"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</ul>
					</nav>

				</main>
				<!-- col.// -->

			</div>

		</div>






	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->

	<!-- ========================= FOOTER ========================= -->
	<footer class="section-footer border-top padding-y">
		<div class="container">
			<p class="float-md-right">&copy Copyright 2019 All rights
				reserved</p>
			<p>
				<a href="#">Terms and conditions</a>
			</p>
		</div>
		<!-- //container -->





		<hr class="featurette-divider">
		<!-- /container -->
		<jsp:include page="includes/footer.jsp"></jsp:include>
		<!-- Bootstrap core JavaScript -->

		<!-- /container -->
</body>
</html>
