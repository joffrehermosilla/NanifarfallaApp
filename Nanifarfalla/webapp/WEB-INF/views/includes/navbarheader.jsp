<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<jsp:useBean id="now" class="java.util.Date" />

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
							class="fa fa-user"></i> </a>
						<div class="text">
							<span class="text-muted">Welcome!  </span>
							<div>
								<a href="${urlRoot}login">Sign in</a> <a href="${urlRoot}admin/logout">Salida</a>| <a href="#"> Register</a>
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
								data-toggle="dropdown"> <strong><i
										class="czi-view-grid mr-2">${menux.icon}</i>${menux.nombre} </strong></a> <c:choose>
									<c:when test="${menux.nombre == 'Todo' }">

										<ul class="navbar-nav mega-nav pr-lg-2 mr-lg-2">
											<li class="nav-item dropdown"><a
												class="nav-link dropdown-toggle pl-0" href="#"
												data-toggle="dropdown"><i class="czi-view-grid mr-2">
												</i></a>
												<div class="dropdown-menu px-2 pl-0 pb-4">
													<div class="d-flex flex-wrap flex-md-nowrap">
														<div class="d-flex flex-wrap flex-md-nowrap">
															<div class="mega-dropdown-column pt-4 px-3">
																<c:forEach items="${menus}" var="menunietos"
																	varStatus="i">
																	<c:choose>
																		<c:when test="${menunietos.lft == menux.id}">
																			<div class="widget widget-links">
																				<a class="d-block overflow-hidden rounded-lg mb-3"
																					href="#"><img src="img/shop/departments/01.jpg"
																					alt="Imagen"></a>
																				<h6 class="font-size-base mb-2"></h6>
																				<ul class="widget-list">
																					<li class="nav-item dropdown"><a
																						class="widget-list-link"
																						href="${urlRoot}${menunietos.ruta}">${menunietos.nombre}</a>
																						<div class="mega-dropdown-column pt-4 px-3">
																							<c:forEach items="${menus}" var="menubis"
																								varStatus="i">
																								<c:choose>
																									<c:when test="${menubis.lft == menunietos.id}">
																										<div class="widget widget-links">
																											<a
																												class="d-block overflow-hidden rounded-lg mb-3"
																												href="#"><img
																												src="img/shop/departments/01.jpg"
																												alt="Imagen"></a>
																											<h6 class="font-size-base mb-2"></h6>
																											<ul class="widget-list">
																												<li class="nav-item dropdown"><a
																													class="widget-list-link"
																													href="${urlRoot}${menubis.ruta}">${menubis.nombre}</a>



																													<fmt:parseNumber
																														value="${ now.time / (1000*60*60*24) }"
																														integerOnly="true" var="nowDays"
																														scope="request" /> <fmt:parseNumber
																														value="${ menubis.version.time / (1000*60*60*24) }"
																														integerOnly="true" var="otherDays"
																														scope="page" /> <c:set
																														value="${nowDays - otherDays}"
																														var="dateDiff" /> <c:choose>




																														<c:when test="${ dateDiff le 7}">
																															<div class="ml-2">
																																<span class="d-block text-heading">
																																	Descuento/Informe/Usuario/Permiso 	${ dateDiff}
																																	<span class="badge badge-success ml-2">New</span>
																																</span><small class="d-block text-muted">Regular
																																	updates</small>
																															</div>
																														</c:when>
																													</c:choose></li>
																											</ul>
																										</div>
																									</c:when>
																								</c:choose>
																							</c:forEach>
																						</div></li>
																				</ul>
																			</div>
																		</c:when>
																	</c:choose>
																</c:forEach>
															</div>
														</div>
													</div>
												</div></li>
										</ul>
									</c:when>
									<c:when test="${menux.rgt % 2 == 0 }">
										<ul class="dropdown-menu">
											<c:choose>
												<c:when test="${menunietos.lft == menux.id}">
												
												
													<li><a class="dropdown-item"
														href="docs/dev-setup.html">
															<div class="d-flex">
																<div class="lead text-muted pt-1">
																	<i class="czi-book"></i>
																</div>
																<div class="ml-2">
																	<span class="d-block text-heading">Documentation</span><small
																		class="d-block text-muted">Kick-start
																		customization</small>
																</div>
															</div>
													</a></li>
												</c:when>
											</c:choose>
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
										</ul>
									</c:when>
									<c:otherwise>
										<div class="dropdown-menu px-2 pl-0 pb-4">
											<div class="d-flex flex-wrap flex-md-nowrap">
												<div class="mega-dropdown-column pt-4 px-3">
													<div class="widget widget-links">
														<a class="d-block overflow-hidden rounded-lg mb-3"
															href="#"><img src="img/shop/departments/01.jpg"
															alt="Shoes"></a>
														<h6 class="font-size-base mb-2">Clothing</h6>
														<ul class="widget-list">
															<li class="widget-list-item"><a
																class="widget-list-link" href="#">Women's clothing</a></li>
															<li class="widget-list-item"><a
																class="widget-list-link" href="#">Men's clothing</a></li>
															<li class="widget-list-item"><a
																class="widget-list-link" href="#">Kid's clothing</a></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</c:otherwise>
								</c:choose></li>
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