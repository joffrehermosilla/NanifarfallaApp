<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />

<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title><fmt:message key="label.pages.home.title" /></title>
<spring:url value="/clienteTienePedido/" var="buscarPedido"></spring:url>
<link rel="stylesheet" href="https://kit-free.fontawesome.com/releases/latest/css/free.min.css">


</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="http://localhost:8080/Nanifarfalla/"> <fmt:message
						key="label.pages.home.title" /> 
				</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="navbar-brand" href="http://localhost:8080/Nanifarfalla/formLogin"> <fmt:message
							key="label.pages.logout" />
				</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container">
<!-- 		<p sec:authorize="!hasAuthority('ROLE_BUYER','ROLE_SELLER')"> -->
<%-- 			<fmt:message key="message.unauth" /> --%>
<!-- 			Mensaje de ROLES comprador y vendedor -->
<!-- 		</p> -->

		<h1 sec:authorize="hasAuthority('ROLE_ADMIN')">
			<fmt:message key="label.pages.admin.message" />
<!-- 			COmprador Vendedor -->
		</h1>

		<p sec:authorize="!hasAuthority('ROLE_ADMIN')"
			th:text="${message.unauth}">Administración de Cuenta </p>

<!-- 		<h1 sec:authorize="hasAuthority('ROLE_BUYER','ROLE_SELLER')" -->
<%-- 			th:text="${label.pages.admin.message}">admin</h1> --%>
	</div>
</body>
</html>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="max-age=604800" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Sesion Usuario</title>

<link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">

<!-- jQuery -->
<script src="js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap4 files-->
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

<!-- Font awesome 5 -->
<link href="fonts/fontawesome/css/all.min.css" type="text/css"
	rel="stylesheet">

<!-- custom style -->
<link href="css/ui.css" rel="stylesheet" type="text/css" />
<link href="css/responsive.css" rel="stylesheet"
	media="only screen and (max-width: 1200px)" />

<!-- custom javascript -->
<script src="js/script.js" type="text/javascript"></script>


<script type="text/javascript">
	/// some script

	// jquery ready start
	$(document).ready(function() {
		// jQuery code

	});
	// jquery end
</script>

</head>
<body>


<!-- 	<header class="section-header"> -->
<%-- 		<section class="header-main border-bottom"> --%>
<!-- 			<div class="container"> -->
<!-- 				<div class="row align-items-center"> -->
<!-- 					<div class="col-lg-2 col-4"> -->
<!-- 						<a href="http://bootstrap-ecommerce.com" class="brand-wrap"> <img -->
<!-- 							class="logo" src="images/logo.png"> -->
<!-- 						</a> -->
<!-- 						brand-wrap.// -->
<!-- 					</div> -->
<!-- 					<div class="col-lg-6 col-sm-12"> -->
<!-- 						<form action="#" class="search"> -->
<!-- 							<div class="input-group w-100"> -->
<!-- 								<input type="text" class="form-control" placeholder="Search"> -->
<!-- 								<div class="input-group-append"> -->
<!-- 									<button class="btn btn-primary" type="submit"> -->
<!-- 										<i class="fa fa-search"></i> -->
<!-- 									</button> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 						search-wrap .end// -->
<!-- 					</div> -->
					<!-- col.// -->
<!-- 					<div class="col-lg-4 col-sm-6 col-12"> -->
<!-- 						<div class="widgets-wrap float-md-right"> -->
<!-- 							<div class="widget-header  mr-3"> -->
<!-- 								<a href="#" class="icon icon-sm rounded-circle border"><i -->
<!-- 									class="fa fa-shopping-cart"></i></a> <span -->
<!-- 									class="badge badge-pill badge-danger notify">0</span> -->
<!-- 							</div> -->
<!-- 							<div class="widget-header icontext"> -->
<!-- 								<a href="#" class="icon icon-sm rounded-circle border"><i -->
<!-- 									class="fa fa-user"></i></a> -->
<!-- 								<div class="text"> -->
<!-- 									<span class="text-muted">Welcome!</span> -->
<!-- 									<div> -->
<!-- 										<a href="#">Sign in</a> | <a href="#"> Register</a> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->

<!-- 						</div> -->
						<!-- widgets-wrap.// -->
<!-- 					</div> -->
					<!-- col.// -->
<!-- 				</div> -->
				<!-- row.// -->
<!-- 			</div> -->
			<!-- container.// -->
<%-- 		</section> --%>
		<!-- header-main .// -->
<!-- 	</header> -->
	<!-- section-header.// -->



	<!-- ========================= SECTION PAGETOP ========================= -->
	<section class="section-pagetop bg">
		<c:if test="${mensajelogeo!=null }">
			<div class='alert alert-success' role="alert" align="center">${ mensajelogeo}</div>
		</c:if>
<!-- 		<div class="container"> -->
<!-- 			<h2 class="title-page">Mi cuenta</h2> -->
<!-- 		</div> -->
		<!-- container //  -->
	</section>
	<!-- ========================= SECTION INTRO END// ========================= -->

	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content padding-y">
		<div class="container">

			<div class="row" style="height: 100%;">
				<aside class="col-md-3">
					<ul class="list-group">
						<a class="list-group-item" href="#">Descripción de cuenta</a>
						<a class="list-group-item active" href="#"> Mis Ordenes </a>
						<a class="list-group-item" href="#"> Mi lista de deseos </a>
						<a class="list-group-item" href="#"> Devoluciones y reembolsos </a>
						<a class="list-group-item" href="#"> Ajustes </a>
<!-- 						<a class="list-group-item" href="#"> My Selling Items </a> -->
<!-- 						<a class="list-group-item" href="#"> Received orders </a> -->
					</ul>
				</aside>
				
				<!-- col.// -->
				<main class="col-md-9">

					<article class="card mb-3" style="display: none">
						<div class="card-body">

							<figure class="icontext">
								<div class="icon">
									<img class="rounded-circle img-sm border"
										src="images/avatars/avatar3.jpg">
								</div>
								<div class="text">
									<strong> Sr. Joffre Hermosilla </strong> <br>
									alhux2@gmail.com <br> <a href="#">Editar</a>
								</div>
							</figure>
							<hr>
							<p>
								<i class="fa fa-map-marker text-muted"></i> &nbsp; My address: <br>
								Tashkent city, Street name, Building 123, House 321 &nbsp <a
									href="#" class="btn-link"> Edit</a>
							</p>



							<article class="card-group">
								<figure class="card bg">
									<div class="p-3">
										<h5 class="card-title">38</h5>
										<span>Orders</span>
									</div>
								</figure>
								<figure class="card bg">
									<div class="p-3">
										<h5 class="card-title">5</h5>
										<span>Wishlists</span>
									</div>
								</figure>
								<figure class="card bg">
									<div class="p-3">
										<h5 class="card-title">12</h5>
										<span>Awaiting delivery</span>
									</div>
								</figure>
								<figure class="card bg">
									<div class="p-3">
										<h5 class="card-title">50</h5>
										<span>Delivered items</span>
									</div>
								</figure>
							</article>


						</div>
						<!-- card-body .// -->
					</article>
					<!-- card.// -->
			<div id="right-panel" class="right-panel" style="background: #f1f2f7;height: 100%;">

			        <div class="content" style="padding-top: 23px;">
			            <div class="animated fadeIn">
			                <div class="">
			
			                    <div class="col-md-12">
			                        <div class="card">
			                            <div class="card-header">
			                                <strong class="card-title">Pedidos Realizados</strong>
			                            </div>
			                            <div class="card-body">
			                                <table id="bootstrap-data-table" class="table table-striped table-bordered" style="font-size: 13px">
			                                    <thead>
			                                        <tr>
												    	<th style="display: none;">Codigo</th>
												    	<th>Numero</th>
												    	<th>Estado</th>
												    	<th>Precio</th>
												    	<th>Cantidad</th>
												        <th>Fecha Pedido</th>
												        <th>Fecha Entrega</th> 
												        <th ></th>
			                                        </tr>
			                                    </thead>
			                                    <tbody>
													<c:forEach items="${listVentas}" var="ls">
													    <tr>
													    	<td style="display: none;"><c:out value="${ls.codigo_pedido_web}"/></td>
													    	<td><c:out value="${ls.mFactura_cliente_tiene_pedido.nombre_factura_cliente_tiene_pedido}"/></td>
													    	<td><c:out value="${ls.mEstadoClienteTienePedido.nombre_estado_cliente_tiene_pedido}"/></td>
													    	<td><c:out value="${ls.precio_uni_desc_igv}"/></td>
													    	<td><c:out value="${ls.cantidad_producto}"/></td>
													        <td><c:out value="${ls.fecha_pedido}"/></td>
													        <td><c:out value="${ls.fecha_entrega}"/></td>
													        <td><button type="button" class="btn btn-warning" style="font-size: 13px"><i class="far fa-eye"></i> Ver Detalle</button></td> 
													    </tr>    
													</c:forEach>							        
			                                    </tbody>
			                                </table>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			        </div>
			
					</div>
				</main>
			</div>
		</div>
	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->


	<!-- ========================= FOOTER ========================= -->
	<footer class="section-footer border-top padding-y" style="position: fixed;bottom: 0px;width: 100%;
		background: #f1f2f7;">
		<div class="container">
			<p class="float-md-right">&copy Copyright 2022 All rights
				reserved</p>
			<p>
				<a href="#">Terms and conditions</a>
			</p>
		</div>
		<!-- //container -->
	</footer>
	<!-- ========================= FOOTER END // ========================= -->



</body>
</html>