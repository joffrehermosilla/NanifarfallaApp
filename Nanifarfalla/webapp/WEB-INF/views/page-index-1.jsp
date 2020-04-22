<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

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



	<!-- ========================= SECTION INTRO ========================= -->
	<section class="section-intro padding-y-sm">
		<div class="container conainer-fluid">

			<div>

			<jsp:include page="includes/carruselpromocional.jsp"></jsp:include> 
			</div>

		</div>
		<!-- container //  -->
	</section>

	
	
	<!-- ========================= SECTION INTRO END// ========================= -->


	<!-- ========================= SECTION FEATURE ========================= -->
	<section class="section-content padding-y-sm ">
		<div class="container">

			<jsp:include page="includes/bannerdeconfianza.jsp"></jsp:include>
		</div>
		<!-- container .//  -->
	</section>
	<!-- ========================= SECTION FEATURE END// ========================= -->
	<!-- Busqueda principal lineas   -->

	<section class="section-content padding-y-sm">
		<div class="container">

			<jsp:include page="includes/busquedaprincipal.jsp"></jsp:include>
		</div>
		<!-- container .//  -->
	</section>
	<!-- Busqueda principal lineas   -->


	<section class="section-content padding-y-sm">
		<div class="container">
			<jsp:include page="includes/carruselemprendedores.jsp"></jsp:include>

		</div>
		<!-- container .//  -->
	</section>
	

	
	<!-- ========================= SECTION CONTENT ========================= -->

	<section class="section-content">
		<div class="container">

			<header class="section-heading">
				<h3 class="section-title">Popular products</h3>
			</header>
			<!-- sect-heading -->


			<div class="row">
				<div class="col-md-3">
					<div  class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/1.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Just another product name</a>

							<div class="rating-wrap">
								<ul class="rating-stars">
									<li style="width: 80%" class="stars-active"><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
								</ul>
								<span class="label-rating text-muted"> 34 reviws</span>
							</div>
							<div class="price mt-1">$179.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/2.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Some item name here</a>

							<div class="rating-wrap">
								<ul class="rating-stars">
									<li style="width: 80%" class="stars-active"><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
								</ul>
								<span class="label-rating text-muted"> 34 reviws</span>
							</div>
							<div class="price mt-1">$280.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/3.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Great product name here</a>

							<div class="rating-wrap">
								<ul class="rating-stars">
									<li style="width: 80%" class="stars-active"><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
								</ul>
								<span class="label-rating text-muted"> 34 reviws</span>
							</div>
							<div class="price mt-1">$56.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/4.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Just another product name</a>

							<div class="rating-wrap">
								<ul class="rating-stars">
									<li style="width: 80%" class="stars-active"><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
								</ul>
								<span class="label-rating text-muted"> 34 reviws</span>
							</div>
							<div class="price mt-1">$179.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
			</div>
			<!-- row.// -->

		</div>
		<!-- container .//  -->
	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->



	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content">
		<div class="container">

			<header class="section-heading">
				<h3 class="section-title">New arrived</h3>
			</header>
			<!-- sect-heading -->

			<div class="row">
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/5.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Just another product name</a>

							<div class="rating-wrap">
								<ul class="rating-stars">
									<li style="width: 80%" class="stars-active"><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
								</ul>
								<span class="label-rating text-muted"> 34 reviws</span>
							</div>
							<div class="price mt-1">$179.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/6.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Some item name here</a>

							<div class="rating-wrap">
								<ul class="rating-stars">
									<li style="width: 80%" class="stars-active"><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
								</ul>
								<span class="label-rating text-muted"> 34 reviws</span>
							</div>
							<div class="price mt-1">$280.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/7.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Great product name here</a>

							<div class="rating-wrap">
								<ul class="rating-stars">
									<li style="width: 80%" class="stars-active"><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
								</ul>
								<span class="label-rating text-muted"> 34 reviws</span>
							</div>
							<div class="price mt-1">$56.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/9.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Just another product name</a>

							<div class="rating-wrap">
								<ul class="rating-stars">
									<li style="width: 80%" class="stars-active"><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
									<li><i class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i><i class="fa fa-star"></i><i
										class="fa fa-star"></i></li>
								</ul>
								<span class="label-rating text-muted"> 34 reviws</span>
							</div>
							<div class="price mt-1">$179.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
			</div>
			<!-- row.// -->

		</div>
		<!-- container .//  -->
	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->



	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content padding-bottom-sm">
		<div class="container">

			<header class="section-heading">
				<a href="#" class="btn btn-outline-primary float-right">See all</a>
				<h3 class="section-title">Recommended</h3>
			</header>
			<!-- sect-heading -->

			<div class="row">
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/1.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Just another product name</a>
							<div class="price mt-1">$179.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/2.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Some item name here</a>
							<div class="price mt-1">$280.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/3.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Great product name here</a>
							<div class="price mt-1">$56.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
				<div class="col-md-3">
					<div href="#" class="card card-product-grid">
						<a href="#" class="img-wrap"> <img
							src="${urlPublic}/images/items/4.jpg">
						</a>
						<figcaption class="info-wrap">
							<a href="#" class="title">Just another product name</a>
							<div class="price mt-1">$179.00</div>
							<!-- price-wrap.// -->
						</figcaption>
					</div>
				</div>
				<!-- col.// -->
			</div>
			<!-- row.// -->

		</div>
		<!-- container .//  -->
	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->

	<!-- ========================= SECTION  ========================= -->
	<section class="section-name bg padding-y-sm">
		<div class="container">
			<header class="section-heading">
				<h3 class="section-title">Our Brands</h3>
			</header>
			<!-- sect-heading -->

			<div class="row">
				<div class="col-md-2 col-6">
					<figure class="box item-logo">
						<a href="#"><img src="${urlPublic}/images/logos/logo1.png"></a>
						<figcaption class="border-top pt-2">36 Products</figcaption>
					</figure>
					<!-- item-logo.// -->
				</div>
				<!-- col.// -->
				<div class="col-md-2  col-6">
					<figure class="box item-logo">
						<a href="#"><img src="${urlPublic}/images/logos/logo2.png"></a>
						<figcaption class="border-top pt-2">980 Products</figcaption>
					</figure>
					<!-- item-logo.// -->
				</div>
				<!-- col.// -->
				<div class="col-md-2  col-6">
					<figure class="box item-logo">
						<a href="#"><img src="${urlPublic}/images/logos/logo3.png"></a>
						<figcaption class="border-top pt-2">25 Products</figcaption>
					</figure>
					<!-- item-logo.// -->
				</div>
				<!-- col.// -->
				<div class="col-md-2  col-6">
					<figure class="box item-logo">
						<a href="#"><img src="${urlPublic}/images/logos/logo4.png"></a>
						<figcaption class="border-top pt-2">72 Products</figcaption>
					</figure>
					<!-- item-logo.// -->
				</div>
				<!-- col.// -->
				<div class="col-md-2  col-6">
					<figure class="box item-logo">
						<a href="#"><img src="${urlPublic}/images/logos/logo5.png"></a>
						<figcaption class="border-top pt-2">41 Products</figcaption>
					</figure>
					<!-- item-logo.// -->
				</div>
				<!-- col.// -->
				<div class="col-md-2  col-6">
					<figure class="box item-logo">
						<a href="#"><img src="${urlPublic}/images/logos/logo2.png"></a>
						<figcaption class="border-top pt-2">12 Products</figcaption>
					</figure>
					<!-- item-logo.// -->
				</div>
				<!-- col.// -->
			</div>
			<!-- row.// -->
		</div>
		<!-- container // -->
	</section>
	<!-- ========================= SECTION  END// ========================= -->



	<!-- ========================= SECTION  ========================= -->
	<section class="section-name padding-y">
		<div class="container">

			<h3 class="mb-3">Download app demo text</h3>

			<a href="#"><img src="${urlPublic}/images/misc/appstore.png"
				height="40"></a> <a href="#"><img
				src="${urlPublic}/images/misc/appstore.png" height="40"></a>

		</div>
		<!-- container // -->
	</section>
	<!-- ========================= SECTION  END// ======================= -->




	<!-- ========================= FOOTER ========================= -->
	  <jsp:include page="includes/footer.jsp"></jsp:include>

	<!-- ========================= FOOTER END // ========================= -->


</body>
</html>