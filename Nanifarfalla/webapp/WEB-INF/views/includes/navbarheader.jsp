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
				<c:forEach items="${menus}" var="menu">
					<c:choose>
						<c:when test="${menu.id >= menu.mMenuV1.id}">

							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle pl-0" href="${menubase.ruta}"
								data-toggle="dropdown"><strong><i
										class="czi-view-grid mr-2"></i>${menu.nombre}</strong></a>
								<div class="dropdown-menu px-2 pl-0 pb-4">

									<div class="mega-dropdown-column pt-4 px-3">
										<div class="widget widget-links">
											<c:forEach items="${menus}" var="menubase">
												<c:choose>
													<c:when test="${menubase.lft == 1}">
														<a class="d-block overflow-hidden rounded-lg mb-3"
															href="${menubase.ruta}"><img src="${menubase.icon}"
															alt="${menubase.ruta}"></a>
														<h6 class="font-size-base mb-2">${menubase.nombre}</h6>
													</c:when>
												</c:choose>
											</c:forEach>
										</div>
									</div>
								</div></li>
						</c:when>
					</c:choose>
				</c:forEach>
			</ul>
		</div>


		<!-- collapse .// -->

	</div>
	<!-- container .// -->
</nav>
</html>