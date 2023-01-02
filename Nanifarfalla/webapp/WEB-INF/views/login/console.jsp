<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/admin/logout" var="urlForm"></spring:url>
<spring:url value="http://localhost:8080" var="local"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>



<spring:url value="/productos/indexPaginate?page=0" var="urlProducto"></spring:url>

<spring:url value="/estadousuario/indexPaginate?page=0"
	var="urlEstadoUsuario"></spring:url>

<spring:url value="/elaboracionproducto/indexPaginate?page=0"
	var="urlElaboracionProducto"></spring:url>
<spring:url value="/pais/indexPaginate?page=0" var="urlPais"></spring:url>

<spring:url value="/lineas/indexPaginate?page=0" var="urlLinea"></spring:url>

<spring:url value="/estadocatalogo/indexPaginate?page=0"
	var="urlEstadoCatalogo"></spring:url>

<spring:url value="/tipousuario/indexPaginate?page=0"
	var="urlTipoUsuario"></spring:url>

<spring:url value="/estadousuario/indexPaginate?page=0"
	var="urlEstadoUsuario"></spring:url>

<spring:url value="/tipoalerta/indexPaginate?page=0" var="urlTipoAlerta"></spring:url>


<spring:url value="/estadocontrato/indexPaginate?page=0"
	var="urlEstadoContrato"></spring:url>


<spring:url value="/privilege/indexPaginate?page=0" var="urlPrivilege"></spring:url>

<spring:url value="/menus/indexPaginate?page=0" var="urlMenu"></spring:url>

<spring:url value="/roles/indexPaginate?page=0" var="urlRole"></spring:url>

<spring:url value="/alertas/indexPaginate?page=0" var="urlAlerta"></spring:url>

<spring:url value="/anuncios/indexPaginate?page=0" var="urlAnuncio"></spring:url>



<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!-- Titulo -->
<title>${contextRoot}-${title}|<fmt:message key="welcome.lang" /></title>






<!-- Bootstrap -->
<link href="${urlPublic}/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="${urlPublic}/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="${urlPublic}/vendors/nprogress/nprogress.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${urlPublic}/build/css/custom.min.css" rel="stylesheet">


<script src="${urlPublic}/js/menuconsole.js" type="text/javascript"></script>
<script type="text/javascript" src="${urlPublic}/js/regla2.js"></script>
</head>
<header class="section-header">

	<section class="section-content padding-y-sm">
		<div class="container">
			<jsp:include page="../includes/presentacioncreador.jsp"></jsp:include>

		</div>
		<!-- container .//  -->
	</section>


	<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<c:if test="${mensajelogeo!=null }">
		<div class='alert alert-success' role="alert" align="center">${ mensajelogeo}</div>
	</c:if>

	<script>
		function abrir(url) {
			open(url, '', 'top=300,left=300,width=300,height=300');
		}
	</script>

</header>

<body class="nav-md">

	<div class="content"></div>
	<div class="container body">
		<div class="main_container">


			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-home"></i>
							<span>Nanifarfalla</span></a>
					</div>
					<c:if test="${mensajelogeo!=null }">
						<div class='alert alert-success' role="alert" align="center">${ mensajelogeo}</div>
					</c:if>
					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="${urlRoot}${urlPublic}/gentelella/images/img.jpg"
								alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>John Doe</h2>
						</div>
						<div class="clearfix"></div>
					</div>
					<!-- /menu profile quick info -->

					<br /> <a name="arriba"></a>
					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> Home <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="index.html">Dashboard</a></li>
										<li><a href="index2.html">Dashboard2</a></li>
										<li><a href="index3.html">Dashboard3</a></li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i> Contratos<span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li class="estadocontrato" id="estadocontrato"><a
											href="${local}${urlEstadoContrato}" id="estadocontrato">ESTADO
												CONTRATO</a></li>

										<li><a href="form_validation.html">Form Validation</a></li>
										<li><a href="form_wizards.html">Form Wizard</a></li>
										<li><a href="form_upload.html">Form Upload</a></li>
										<li><a href="form_buttons.html">Form Buttons</a></li>
									</ul></li>
								<li><a><i class="fa fa-desktop"></i> UI Elements <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li class="menu" id="menu"><a href="${local}${urlMenu}" id="menu">MENU</a></li>
										<li><a href="media_gallery.html">Media Gallery</a></li>
										<li><a href="typography.html">Typography</a></li>
										<li><a href="icons.html">Icons</a></li>
										<li><a href="glyphicons.html">Glyphicons</a></li>
										<li><a href="widgets.html">Widgets</a></li>
										<li><a href="invoice.html">Invoice</a></li>
										<li><a href="inbox.html">Inbox</a></li>
										<li><a href="calendar.html">Calendar</a></li>
									</ul></li>
								<li><a><i class="fa fa-table"></i> Tables <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tables.html">Tables</a></li>
										<li><a href="tables_dynamic.html">Table Dynamic</a></li>
									</ul></li>
								<li><a><i class="fa fa-bar-chart-o"></i> Data
										Presentation <span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="chartjs.html">Chart JS</a></li>
										<li><a href="chartjs2.html">Chart JS2</a></li>
										<li><a href="morisjs.html">Moris JS</a></li>
										<li><a href="echarts.html">ECharts</a></li>
										<li><a href="other_charts.html">Other Charts</a></li>
									</ul></li>
								<li><a><i class="fa fa-clone"></i>Layouts <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
										<li><a href="fixed_footer.html">Fixed Footer</a></li>
									</ul></li>
							</ul>
						</div>
						<div class="menu_section">
							<h3>Live On</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-bug"></i> Additional Pages <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="e_commerce.html">E-commerce</a></li>
										<li><a href="projects.html">Projects</a></li>
										<li><a href="project_detail.html">Project Detail</a></li>
										<li><a href="contacts.html">Contacts</a></li>
										<li><a href="profile.html">Profile</a></li>
									</ul></li>
								<li><a><i class="fa fa-windows"></i> Extras <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="page_403.html">403 Error</a></li>
										<li><a href="page_404.html">404 Error</a></li>
										<li><a href="page_500.html">500 Error</a></li>
										<li><a href="plain_page.html">Plain Page</a></li>
										<li><a href="login.html">Login Page</a></li>
										<li><a href="pricing_tables.html">Pricing Tables</a></li>
									</ul></li>
								<li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a>REGLAS<span class="fa fa-chevron-down"></span></a>
											<ul class="nav child_menu">
												<!-- JavaScript Id Estado Usuario /resources/js/menuconsole.js -->
												<li class="privilege" id="privilege"><a href="${local}${urlPrivilege}"
													id="privilege">PRIVILEGIOS</a></li>
												<li class="roles" id="roles"><a href="${local}${urlRole}"
													id="roles">ROLES</a></li>
											</ul></li>



										<li><a>STAKEHOLDERS<span class="fa fa-chevron-down"></span></a>
											<ul class="nav child_menu">
												<!-- JavaScript Id Estado Usuario /resources/js/menuconsole.js -->
												<li class="estadousuario" id="estadousuario"><a
													href="${local}${urlEstadoUsuario}" id="estadousuario">ESTADO USUARIO </a></li>
												<li class="linea" id="linea"><a href="${local}${urlLinea}"
													id="linea">LINEA </a></li>
												<li class="tipousuario" id="tipousuario"><a
													href="${local}${urlTipoUsuario}" id="tipousuario">TIPO USUARIO </a></li>

											</ul></li>



										<li><a>MERCADERIA-SERVICIO<span
												class="fa fa-chevron-down"></span></a>
											<ul class="nav child_menu">
												<li class="elaboracionproducto" id="elaboracionproducto"><a
													href="${local}${urlElaboracionProducto}" id="elaboracionproducto">ELABORACION DEL
														PRODUCTO </a></li>
												<li class="producto" id="producto"><a href="${local}${urlProducto}"
													id="producto"> PRODUCTO </a></li>
												<li class="estadocatalogo" id="estadocatalogo"><a
													href="${local}${urlEstadoCatalogo}" id="estadocatalogo">ESTADO DE CATALOGO </a></li>
												<li class="tipoalerta" id="tipoalerta"><a
													href="#arriba" id="tipoalerta">TIPO ALERTA </a></li>

												<li class="anuncios" id="anuncios"><a href="#arriba"
													id="anuncios">ANUNCIO </a></li>

												<li class="alertas" id="alertas"><a href="#arriba"
													id="alertas">ALERTA </a></li>


											</ul></li>
										<li><a>GEOLOCALIZACION<span
												class="fa fa-chevron-down"></span></a>
											<ul class="nav child_menu">
												<li class="pais" id="pais"><a href="#arriba" id="pais">PAIS
												</a></li>
												<li><a href="#level2_1">Level Two</a></li>
												<li><a href="#level2_2">Level Two</a></li>
											</ul></li>
									</ul></li>
								<li><a href="javascript:void(0)"><i
										class="fa fa-laptop"></i> Landing Page <span
										class="label label-success pull-right">Coming Soon</span></a></li>
							</ul>
						</div>

					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="login.html"> <span class="glyphicon glyphicon-off"
							aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>
					<nav class="nav navbar-nav">
						<ul class=" navbar-right">
							<li class="nav-item dropdown open" style="padding-left: 15px;">
								<a href="javascript:;" class="user-profile dropdown-toggle"
								aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown"
								aria-expanded="false"> <img
									src="${urlPublic}/gentelella/images/img.jpg" alt="">John
									Doe
							</a>
								<div class="dropdown-menu dropdown-usermenu pull-right"
									aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="javascript:;"> Profile</a> <a
										class="dropdown-item" href="javascript:;"> <span
										class="badge bg-red pull-right">50%</span> <span>Settings</span>
									</a> <a class="dropdown-item" href="">Help</a> <a
										class="dropdown-item" href="${urlForm}"><i
										class="fa fa-sign-out pull-right"></i> Log Out</a>
								</div>
							</li>

							<li role="presentation" class="nav-item dropdown open"><a
								href="javascript:;" class="dropdown-toggle info-number"
								id="navbarDropdown1" data-toggle="dropdown"
								aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span
									class="badge bg-green">6</span>
							</a>
								<ul class="dropdown-menu list-unstyled msg_list" role="menu"
									aria-labelledby="navbarDropdown1">
									<li class="nav-item"><a class="dropdown-item"> <span
											class="image"><img
												src="${urlPublic}/gentelella/images/img.jpg"
												alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li class="nav-item"><a class="dropdown-item"> <span
											class="image"><img
												src="${urlPublic}/gentelella/images/img.jpg"
												alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li class="nav-item"><a class="dropdown-item"> <span
											class="image"><img
												src="${urlPublic}/gentelella/images/img.jpg"
												alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li class="nav-item"><a class="dropdown-item"> <span
											class="image"><img
												src="${urlPublic}/gentelella/images/img.jpg"
												alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li class="nav-item">
										<div class="text-center">
											<a class="dropdown-item"> <strong>See All Alerts</strong>
												<i class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Plain Page</h3>
						</div>

						<div class="title_right">
							<div class="col-md-5 col-sm-5   form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search for..."> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="clearfix"></div>


					<div class="row">
						<div class="col-md-12 col-sm-12  ">
							<div class="x_panel">

								<div class="wrapper">
									<%--Wrapper --%>

									<div class="x_title" style="height: 100%">
										<h2>Plain Page</h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i
													class="fa fa-chevron-up"></i></a></li>
											<li class="dropdown"><a href="#" class="dropdown-toggle"
												data-toggle="dropdown" role="button" aria-expanded="false"><i
													class="fa fa-wrench"></i></a>
												<div class="dropdown-menu"
													aria-labelledby="dropdownMenuButton">
													<a class="dropdown-item" href="#">Settings 1</a> <a
														class="dropdown-item" href="#">Settings 2</a>
												</div></li>
											<li><a class="close-link"><i class="fa fa-close"></i></a>
											</li>
										</ul>
										<div class="clearfix"></div>
									</div>





									<div class="embed-responsive embed-responsive-16by9"
										id="plainpage">
										Add content to the page ...
										<!-- Carga la pagina plainPAGE donde habra condicionales que discriminaran los ID de <li id=""> en menuconsole.js -->
									<!--  <%@include file="../login/plainpage.jsp"%>-->	

										<!-- Loading the home content -->
									




									</div>
								</div>
								<%--Wrapper --%>



							</div>
						</div>
					</div>






				</div>
			</div>
			<!-- /page content -->




			<!-- footer content -->
			<footer>
				<div class="pull-right">
					Nanifarfalla - ECOMMERCE <a href="">designed by Joffre
						Hermosilla Salas</a>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
		<jsp:include page="../includes/footer.jsp"></jsp:include>
	</div>




	<!-- jQuery -->
	<script src="${urlPublic}/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${urlPublic}/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<!-- FastClick -->
	<script src="${urlPublic}/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="${urlPublic}/vendors/nprogress/nprogress.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="${urlPublic}/build/js/custom.min.js"></script>

	<script src="${urlPublic}/js/regla5.js"></script>

	<script src="${js}/myapp.js"></script>
	<!-- ========================= FOOTER ========================= -->

</body>
</html>

