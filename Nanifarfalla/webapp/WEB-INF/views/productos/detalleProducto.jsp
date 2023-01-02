<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de Productos</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/productos/detalle" var="urlDetalle" />
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<div class="container">
			<jsp:include page="../includes/presentacioncreador.jsp"></jsp:include>

		</div>
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>

	</header>
	<section class="section-content padding-y">
		<!-- container .//  -->

		<div class="card">
			<div class="row no-gutters">
				<aside class="col-md-6">
					<article class="gallery-wrap">
						<div class="img-big-wrap">
							<img id="main-img" src="${urlPublic}/images/tesis/foto5.jpg">
							<div id="zoom">
								<img id="zoom-img" />
							</div>
						</div>
						<!-- img-big-wrap.// -->






						<div class="thumbs-wrap">
							<a href="#" class="item-thumb"> <img
								src="../images/items/12-1.jpg"></a> <a href="#"
								class="item-thumb"> <img src="../images/items/12-2.jpg"></a>
							<a href="#" class="item-thumb"> <img
								src="../images/items/12.jpg"></a> <a href="#"
								class="item-thumb"> <img src="../images/items/4.jpg"></a>
						</div>
						<!-- thumbs-wrap.// -->
					</article>
					<!-- gallery-wrap .end// -->
				</aside>
				<main class="col-md-6 border-left">
					<article class="content-body">

						<h2 class="title">	utilizar ajax para que el JSON cargue la data 	<c:forEach var="producto" items="${productos}">
										<c:set var="i" value="${producto.codigo_producto}" />
										<c:choose>
											<c:when test="${i eq producto.codigo_producto}">
												<ul class="list-menu">
													<li><a href="../lineas/detalle">${producto.nombre_producto} </a></li>

												</ul>
											</c:when>
										</c:choose>
									</c:forEach></h2>



						<div class="rating-wrap my-3">
							<ul class="rating-stars">
								<li style="width: 80%" class="stars-active"><i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i></li>
								<li><i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i></li>
							</ul>
							<small class="label-rating text-muted">132 reviews</small> <small
								class="label-rating text-success"> <i
								class="fa fa-clipboard-check"></i> 154 orders
							</small>
						</div>
						<!-- rating-wrap.// -->

						<div class="mb-3">
							<var class="price h4">$815.00</var>
							<span class="text-muted">/per kg</span>
						</div>

						<p>Virgil Abloh’s Off-White is a streetwear-inspired
							collection that continues to break away from the conventions of
							mainstream fashion. Made in Italy, these black and brown
							Odsy-1000 low-top sneakers.</p>

						<dl class="row">
							<dt class="col-sm-3">Model#</dt>
							<dd class="col-sm-9">Odsy-1000</dd>

							<dt class="col-sm-3">Color</dt>
							<dd class="col-sm-9">Brown</dd>

							<dt class="col-sm-3">Delivery</dt>
							<dd class="col-sm-9">Russia, USA, and Europe</dd>
						</dl>

						<hr>
						<div class="form-row">
							<div class="form-group col-md flex-grow-0">
								<label>Quantity</label>
								<div class="input-group mb-3 input-spinner">
									<div class="input-group-prepend">
										<button class="btn btn-light" type="button" id="button-plus">
											+</button>
									</div>
									<input type="text" class="form-control" value="1">
									<div class="input-group-append">
										<button class="btn btn-light" type="button" id="button-minus">
											&minus;</button>
									</div>
								</div>
							</div>
							<!-- col.// -->
							<div class="form-group col-md">
								<label>Select size</label>
								<div class="mt-1">
									<label
										class="custom-control custom-radio custom-control-inline">
										<input type="radio" name="select_size" checked=""
										class="custom-control-input">
										<div class="custom-control-label">Small</div>
									</label> <label
										class="custom-control custom-radio custom-control-inline">
										<input type="radio" name="select_size"
										class="custom-control-input">
										<div class="custom-control-label">Medium</div>
									</label> <label
										class="custom-control custom-radio custom-control-inline">
										<input type="radio" name="select_size"
										class="custom-control-input">
										<div class="custom-control-label">Large</div>
									</label>

								</div>
							</div>
							<!-- col.// -->
						</div>
						<!-- row.// -->
						<a href="#" class="btn  btn-primary"> Buy now </a> <a href="#"
							class="btn  btn-outline-primary"> <span class="text">Add
								to cart</span> <i class="fas fa-shopping-cart"></i>
						</a>
					</article>
					<!-- product-info-aside .// -->
				</main>
				<!-- col.// -->
			</div>
			<!-- row.// -->
		</div>
		<!-- card.// -->






	</section>











	<!-- ========================= SECTION  END// ======================= -->




	<!-- ========================= FOOTER ========================= -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>

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

  TweenLite.set([zoom, zoomImg], { xPercent: -50, yPercent: -60 });
  TweenLite.set(zoom, { autoAlpha: 0, scale: 0 });

  enterTL.
  to(mainImg, 0.5, { filter: "grayscale(1)", "-webkit-filter": "grayscale(1)" }, 0).
  to(zoom, 0.5, { autoAlpha: 2.5, scale: 2.5 }, 0);

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