<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />
<spring:url value="/menus/index" var="urlForm"></spring:url>
<spring:url value="/" var="urlRoot" />
<nav
	class="navbar navbar-preview navbar-dark navbar-expand p-0 bg-primary fixed-bottom">
	<div class="container">
		<ul class="navbar-nav d-none d-md-flex mr-auto">
			<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Delivery</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Payment</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item"><a href="#" class="nav-link"><small>
						<i class="fa fa-phone-square"></i> Call: +99812345678
				</small></a></li>

			<li class="nav-item"><a href="#" class="nav-link"><small>
						<i class="fa fa-truck-loading"></i> Order Tracking
				</small></a></li>
		</ul>
		<!-- list-inline //  -->

		<ul>

		</ul>
		<ul>
			<li class="nav-item dropdown">
				<div class="col-xs-12 col-sm-6 col-md-3">
					<a class="nav-link dropdown-toggle" href="?sessionLocale=en"
						id="navbarDropdown" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <fmt:message
							key="label.tituloidioma" /><small> <i
							class="fa fa-language"></i>
					</small></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="?lang=en"><img
							src="${urlPublic}/images/frontend/iconos/mainsite/banderas/usa.svg"
							width="20" height="20" alt=""> <fmt:message
								key="label.lang.en" /></a> <a class="dropdown-item" href="?lang=es"><img
							src="${urlPublic}/images/frontend/iconos/mainsite/banderas/spain.svg"
							width="20" height="20" alt=""> <fmt:message
								key="label.lang.es" /></a> <a class="dropdown-item" href="?lang=zh"><img
							src="${urlPublic}/images/frontend/iconos/mainsite/banderas/China.svg"
							width="20" height="20" alt=""> <fmt:message
								key="label.lang.cn" /></a>

						<div class="dropdown-divider"></div>
						<a class="dropdown-divider" href="?lang=jp"><img
							src="${urlPublic}/images/frontend/iconos/mainsite/banderas/nihongo.jpg"
							width="20" height="20" alt=""> <fmt:message
								key="label.lang.jp" /></a>
					</div>
				</div>
			</li>

		</ul>



	</div>
	<!-- navbar-collapse .// -->

	<!-- container //  -->
</nav>
<!-- header-top-light.// -->

<section class="header-main border-bottom">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-2 col-6 " align="center">
				<a href="${urlRoot}" class="brand-wrap"> <img class=""
					width="193" align="middle" height="198"
					src="${urlPublic}/images/frontend/iconos/mainsite/logos/LOGO-PAPELERIA.png">
				</a>
				<!-- brand-wrap.// -->
			</div>
			<div class="col-lg-6 col-12 col-sm-6">
				<form action="#" class="search">
					<div class="input-group w-100">
						<input type="text" class="form-control" placeholder="Search">
						<div class="input-group-append">
							<button class="btn btn-primary" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</form>
				<!-- search-wrap .end// -->
			</div>
			<!-- col.// -->
			<div class="col-lg-4 col-sm-6 col-12">
				<div class="widgets-wrap float-md-right">
					<div class="widget-header  mr-3">
						<a href="#" class="icon icon-sm rounded-circle border"><i
							class="fa fa-shopping-cart"></i></a> <span
							class="badge badge-pill badge-danger notify">0</span>
					</div>
					<div class="widget-header icontext">
						<a href="#" class="icon icon-sm rounded-circle border"><i
							class="fa fa-user"></i></a>
						<div class="text">
							<span class="text-muted">Welcome!</span>
							<div>
								<a href="#">Sign in</a> | <a href="#"> Register</a>
							</div>
						</div>
					</div>
				</div>
				<!-- widgets-wrap.// -->
			</div>
			<!-- col.// -->
		</div>
		<!-- row.// -->
	</div>
	<!-- container.// -->
</section>
<!-- header-main .// -->

<!-- section-header.// -->




<nav
	class="navbar navbar-main navbar-expand-lg navbar-light border-bottom">
	<div class="container">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#main_nav" aria-controls="main_nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="main_nav">
			<ul class="navbar-nav mega-nav pr-lg-2 mr-lg-2">

				<c:forEach items="${menus}" var="menux" varStatus="i">
					<c:choose>
						<c:when test="${menux.lft == 1}">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle pl-0" href="${menux.ruta}"
								data-toggle="dropdown"><strong><i
										class="czi-view-grid mr-2">${menux.icon}</i>${menux.nombre} </strong></a>


								<div class="dropdown-menu px-2 pl-0 pb-4">

									<div class="mega-dropdown-column pt-4 px-3">
										<c:forEach items="${menus}" var="menulegado" varStatus="x">
											<c:choose>
												<c:when test="${menulegado.lft == menux.id}">
													<div class="widget widget-links">


														<a class="d-block overflow-hidden rounded-lg mb-3"
															href="${menulegado.ruta}"><img src="${menulegado.icon}" alt=""></a>
														<h6 class="font-size-base mb-2">${menulegado.nombre}</h6>







													</div>
												</c:when>

											</c:choose>
										</c:forEach>

									</div>
								</div></li>

						</c:when>

					</c:choose>
				</c:forEach>





				


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Shop</a>
					<div class="dropdown-menu p-0">
						<div class="d-flex flex-wrap flex-md-nowrap px-2">
							<div class="mega-dropdown-column py-4 px-3">
								<div class="widget widget-links mb-3">
									<h6 class="font-size-base mb-3">Shop layouts</h6>
									<ul class="widget-list">
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-grid-ls.html">Shop
												Grid - Left Sidebar</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-grid-rs.html">Shop
												Grid - Right Sidebar</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-grid-ft.html">Shop
												Grid - Filters on Top</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-list-ls.html">Shop
												List - Left Sidebar</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-list-rs.html">Shop
												List - Right Sidebar</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-list-ft.html">Shop
												List - Filters on Top</a></li>
									</ul>
								</div>
								<div class="widget widget-links">
									<h6 class="font-size-base mb-3">Marketplace</h6>
									<ul class="widget-list">
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="marketplace-category.html">Category
												Page</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="marketplace-single.html">Single
												Item Page</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="marketplace-vendor.html">Vendor
												Page</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="marketplace-cart.html">Cart</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="marketplace-checkout.html">Checkout</a></li>
									</ul>
								</div>
							</div>
							<div class="mega-dropdown-column py-4 px-3">
								<div class="widget widget-links">
									<h6 class="font-size-base mb-3">Shop pages</h6>
									<ul class="widget-list">
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-categories.html">Shop
												Categories</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-single-v1.html">Product
												Page v.1</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-single-v2.html">Product
												Page v.2</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="shop-cart.html">Cart</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="checkout-details.html">Checkout
												- Details</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="checkout-shipping.html">Checkout
												- Shipping</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="checkout-payment.html">Checkout
												- Payment</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="checkout-review.html">Checkout
												- Review</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="checkout-complete.html">Checkout
												- Complete</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="order-tracking.html">Order
												Tracking</a></li>
										<li class="widget-list-item pb-1"><a
											class="widget-list-link" href="comparison.html">Product
												Comparison</a></li>
									</ul>
								</div>
							</div>
							<div class="mega-dropdown-column py-4 pr-3">
								<a class="d-block" href="#"><img
									src="img/shop/menu-banner.jpg" alt="Promo banner"></a>
							</div>
						</div>
					</div></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle pl-0" href="#"
					data-toggle="dropdown"><i class="czi-view-grid mr-2"></i>Pendientes</a>
					<div class="dropdown-menu px-2 pl-0 pb-4">
						<div class="d-flex flex-wrap flex-md-nowrap">
							<div class="mega-dropdown-column pt-4 px-3">
								<div class="widget widget-links">
									<a class="d-block overflow-hidden rounded-lg mb-3" href="#"><img
										src="img/shop/departments/01.jpg" alt="Servicio Publicitario"></a>
									<h6 class="font-size-base mb-2">Mensajes Publicitarios</h6>
									<ul class="widget-list">
										<li class="widget-list-item"><a class="widget-list-link"
											href="${urlRoot}alertas/index">Alertas</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="${urlRoot}lineas/index">Lineas</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="${urlRoot}anuncios/index">Banner</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="${urlRoot}menus/index">Menu</a></li>
									</ul>
								</div>
							</div>
							<div class="mega-dropdown-column pt-4 px-3">
								<div class="widget widget-links">
									<a class="d-block overflow-hidden rounded-lg mb-3" href="#"><img
										src="img/shop/departments/02.jpg" alt="Shoes"></a>
									<h6 class="font-size-base mb-2">Shoes</h6>
									<ul class="widget-list">
										<li class="widget-list-item"><a class="widget-list-link"
											href="${urlRoot}productos/indexPaginate?page=0">Productos</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Men's shoes</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Kid's shoes</a></li>
									</ul>
								</div>
							</div>
							<div class="mega-dropdown-column pt-4 px-3">
								<div class="widget widget-links">
									<a class="d-block overflow-hidden rounded-lg mb-3" href="#"><img
										src="img/shop/departments/03.jpg" alt="Shoes"></a>
									<h6 class="font-size-base mb-2">Gadgets</h6>
									<ul class="widget-list">
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Smartphones &amp; Tablets</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Wearable gadgets</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">E-book readers</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="d-flex flex-wrap flex-md-nowrap">
							<div class="mega-dropdown-column pt-4 px-3">
								<div class="widget widget-links">
									<a class="d-block overflow-hidden rounded-lg mb-3" href="#"><img
										src="img/shop/departments/04.jpg" alt="Shoes"></a>
									<h6 class="font-size-base mb-2">Furniture &amp; Decor</h6>
									<ul class="widget-list">
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Home furniture</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Office furniture</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Lighting and decoration</a></li>
									</ul>
								</div>
							</div>
							<div class="mega-dropdown-column pt-4 px-3">
								<div class="widget widget-links">
									<a class="d-block overflow-hidden rounded-lg mb-3" href="#"><img
										src="img/shop/departments/05.jpg" alt="Shoes"></a>
									<h6 class="font-size-base mb-2">Accessories</h6>
									<ul class="widget-list">
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Hats</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Sunglasses</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Bags</a></li>
									</ul>
								</div>
							</div>
							<div class="mega-dropdown-column pt-4 px-3">
								<div class="widget widget-links">
									<a class="d-block overflow-hidden rounded-lg mb-3" href="#"><img
										src="img/shop/departments/06.jpg" alt="Shoes"></a>
									<h6 class="font-size-base mb-2">Entertainment</h6>
									<ul class="widget-list">
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Kid's toys</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Video games</a></li>
										<li class="widget-list-item"><a class="widget-list-link"
											href="#">Outdoor / Camping</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Pages</a>
					<ul class="dropdown-menu">
						<li class="dropdown"><a class="dropdown-item dropdown-toggle"
							href="#" data-toggle="dropdown">Navbar Variants</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item"
									href="navbar-1-level-light.html">1 Level Light</a></li>
								<li><a class="dropdown-item"
									href="navbar-1-level-dark.html">1 Level Dark</a></li>
								<li><a class="dropdown-item"
									href="navbar-2-level-light.html">2 Level Light</a></li>
								<li><a class="dropdown-item"
									href="navbar-2-level-dark.html">2 Level Dark</a></li>
								<li><a class="dropdown-item"
									href="navbar-3-level-light.html">3 Level Light</a></li>
								<li><a class="dropdown-item"
									href="navbar-3-level-dark.html">3 Level Dark</a></li>
								<li><a class="dropdown-item"
									href="navbar-electro-store.html">Electronics Store</a></li>
								<li><a class="dropdown-item" href="navbar-marketplace.html">Marketplace</a></li>
							</ul></li>
						<li class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="about.html">About Us</a></li>
						<li><a class="dropdown-item" href="contacts.html">Contacts</a></li>
						<li class="dropdown"><a class="dropdown-item dropdown-toggle"
							href="#" data-toggle="dropdown">Help Center</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="help-topics.html">Help
										Topics</a></li>
								<li><a class="dropdown-item" href="help-single-topic.html">Single
										Topic</a></li>
								<li><a class="dropdown-item"
									href="help-submit-request.html">Submit a Request</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-item dropdown-toggle"
							href="#" data-toggle="dropdown">404 Not Found</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="404-simple.html">404
										- Simple Text</a></li>
								<li><a class="dropdown-item" href="404-illustration.html">404
										- Illustration</a></li>
							</ul></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Blog</a>
					<ul class="dropdown-menu">
						<li class="dropdown"><a class="dropdown-item dropdown-toggle"
							href="#" data-toggle="dropdown">Blog List Layouts</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="blog-list-sidebar.html">List
										with Sidebar</a></li>
								<li><a class="dropdown-item" href="blog-list.html">List
										no Sidebar</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-item dropdown-toggle"
							href="#" data-toggle="dropdown">Blog Grid Layouts</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="blog-grid-sidebar.html">Grid
										with Sidebar</a></li>
								<li><a class="dropdown-item" href="blog-grid.html">Grid
										no Sidebar</a></li>
							</ul></li>
						<li><a class="dropdown-item" href="blog-single.html">Single
								Post</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Docs
						/ Components</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="docs/dev-setup.html">
								<div class="d-flex">
									<div class="lead text-muted pt-1">
										<i class="czi-book"></i>
									</div>
									<div class="ml-2">
										<span class="d-block text-heading">Documentation</span><small
											class="d-block text-muted">Kick-start customization</small>
									</div>
								</div>
						</a></li>
						<li class="dropdown-divider"></li>
						<li><a class="dropdown-item"
							href="components/typography.html">
								<div class="d-flex">
									<div class="lead text-muted pt-1">
										<i class="czi-server"></i>
									</div>
									<div class="ml-2">
										<span class="d-block text-heading">Components<span
											class="badge badge-info ml-2">40+</span></span><small
											class="d-block text-muted">Faster page building</small>
									</div>
								</div>
						</a></li>
						<li class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="docs/changelog.html">
								<div class="d-flex">
									<div class="lead text-muted pt-1">
										<i class="czi-edit"></i>
									</div>
									<div class="ml-2">
										<span class="d-block text-heading">Changelog<span
											class="badge badge-success ml-2">v1.2</span></span><small
											class="d-block text-muted">Regular updates</small>
									</div>
								</div>
						</a></li>
						<li class="dropdown-divider"></li>
						<li><a class="dropdown-item"
							href="mailto:contact@createx.studio">
								<div class="d-flex">
									<div class="lead text-muted pt-1">
										<i class="czi-help"></i>
									</div>
									<div class="ml-2">
										<span class="d-block text-heading">Support</span><small
											class="d-block text-muted">contact@createx.studio</small>
									</div>
								</div>
						</a></li>
					</ul></li>
		

	




		</ul>
	</div>


	<!-- collapse .// -->

	</div>
	<!-- container .// -->
</nav>
</html>