<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="max-age=604800" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">






<!-- Titulo -->
<title>Nanifarfalla | Bienvenido</title>

<spring:url value="/resources" var="urlPublic" />

<!-- Styles CSS -->
<jsp:include page="includes/link.jsp"></jsp:include>

<!-- custom javascript -->
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
													<a href="#" class="btn btn-primary btn-block"> Details
													</a> <a href="#" class="btn btn-light btn-block"><i
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
		
		
		<!-- container .//  -->
		
		<div class="card">
	<div class="row no-gutters">
		<aside class="col-md-6">
<article class="gallery-wrap"> 
	<div class="img-big-wrap">
	  <img id="main-img" src="${urlPublic}/images/items/12.jpg">
	   <div id="zoom">
  <img id="zoom-img" />
</div>
	</div> <!-- img-big-wrap.// -->
	


	
	
	
	<div class="thumbs-wrap">
	  <a href="#" class="item-thumb"> <img src="../images/items/12-1.jpg"></a>
	  <a href="#" class="item-thumb"> <img src="../images/items/12-2.jpg"></a>
	  <a href="#" class="item-thumb"> <img src="../images/items/12.jpg"></a>
	  <a href="#" class="item-thumb"> <img src="../images/items/4.jpg"></a>
	</div> <!-- thumbs-wrap.// -->
</article> <!-- gallery-wrap .end// -->
		</aside>
		<main class="col-md-6 border-left">
<article class="content-body">

<h2 class="title">Off-White Odsy-1000 Low-Top Sneakers</h2>

<div class="rating-wrap my-3">
	<ul class="rating-stars">
		<li style="width:80%" class="stars-active"> 
			<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
			<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
			<i class="fa fa-star"></i> 
		</li>
		<li>
			<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
			<i class="fa fa-star"></i> <i class="fa fa-star"></i> 
			<i class="fa fa-star"></i> 
		</li>
	</ul>
	<small class="label-rating text-muted">132 reviews</small>
	<small class="label-rating text-success"> <i class="fa fa-clipboard-check"></i> 154 orders </small>
</div> <!-- rating-wrap.// -->

<div class="mb-3"> 
	<var class="price h4">$815.00</var> 
	<span class="text-muted">/per kg</span> 
</div> 

<p>Virgil Abloh’s Off-White is a streetwear-inspired collection that continues to break away from the conventions of mainstream fashion. Made in Italy, these black and brown Odsy-1000 low-top sneakers.</p>

<dl class="row">
  <dt class="col-sm-3">Model#</dt>
  <dd class="col-sm-9">Odsy-1000</dd>

  <dt class="col-sm-3">Color</dt>
  <dd class="col-sm-9">Brown</dd>

  <dt class="col-sm-3">Delivery</dt>
  <dd class="col-sm-9">Russia, USA, and Europe </dd>
</dl>

<hr>
	<div class="form-row">
		<div class="form-group col-md flex-grow-0">
			<label>Quantity</label>
			<div class="input-group mb-3 input-spinner">
			  <div class="input-group-prepend">
			    <button class="btn btn-light" type="button" id="button-plus"> + </button>
			  </div>
			  <input type="text" class="form-control" value="1">
			  <div class="input-group-append">
			    <button class="btn btn-light" type="button" id="button-minus"> &minus; </button>
			  </div>
			</div>
		</div> <!-- col.// -->
		<div class="form-group col-md">
				<label>Select size</label>
				<div class="mt-1">
					<label class="custom-control custom-radio custom-control-inline">
					  <input type="radio" name="select_size" checked="" class="custom-control-input">
					  <div class="custom-control-label">Small</div>
					</label>

					<label class="custom-control custom-radio custom-control-inline">
					  <input type="radio" name="select_size" class="custom-control-input">
					  <div class="custom-control-label">Medium</div>
					</label>

					<label class="custom-control custom-radio custom-control-inline">
					  <input type="radio" name="select_size" class="custom-control-input">
					  <div class="custom-control-label">Large</div>
					</label>

				</div>
		</div> <!-- col.// -->
	</div> <!-- row.// -->
	<a href="#" class="btn  btn-primary"> Buy now </a>
	<a href="#" class="btn  btn-outline-primary"> <span class="text">Add to cart</span> <i class="fas fa-shopping-cart"></i>  </a>
</article> <!-- product-info-aside .// -->
		</main> <!-- col.// -->
	</div> <!-- row.// -->
</div> <!-- card.// -->
		
		

		
		
		
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
	</footer>


	<jsp:include page="includes/footer.jsp"></jsp:include>

	<!-- ========================= FOOTER END // ========================= -->



</body>


<script id="INLINE_PEN_JS_ID">
    var zoom = document.querySelector("#zoom");
var zoomImg = document.querySelector("#zoom-img");
var mainImg = document.querySelector("#main-img");
var enterTL = new TimelineMax({ paused: true });
var timer = TweenLite.delayedCall(1, () => enterTL.reverse()).pause();

var cx, cy, ratio;

window.addEventListener("load", init);

function init() {

  zoomImg.src = mainImg.src;
  ratio = mainImg.naturalWidth / mainImg.width;
  resize();

  TweenLite.set([zoom, zoomImg], { xPercent: -50, yPercent: -50 });
  TweenLite.set(zoom, { autoAlpha: 0, scale: 0 });

  enterTL.
  to(mainImg, 0.5, { filter: "grayscale(1)", "-webkit-filter": "grayscale(1)" }, 0).
  to(zoom, 0.5, { autoAlpha: 1, scale: 1 }, 0);

  window.addEventListener("resize", resize);
  mainImg.addEventListener("mouseleave", leaveAction);
  mainImg.addEventListener("mousemove", moveAction);
}

function leaveAction() {
  enterTL.reverse();
}

function moveAction(e) {
  enterTL.play();
  timer.restart(true);
  TweenLite.set(zoom, { x: e.x, y: e.y });
  TweenLite.set(zoomImg, { x: (cx - e.x) * ratio, y: (cy - e.y) * ratio });
}

function resize() {
  var rect = mainImg.getBoundingClientRect();
  cx = rect.left + rect.width / 2;
  cy = rect.top + rect.height / 2;
}
    //# sourceURL=pen.js
  </script>

</html>

