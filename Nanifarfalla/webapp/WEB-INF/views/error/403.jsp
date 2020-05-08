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
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<meta name="description" content="">
	<meta name="author" content="">
<title>Nanifarfalla | Bienvenido</title>
	
<spring:url value="/resources" var="urlPublic" />

<spring:url value="/resources" var="urlPublic" />

<!-- Styles CSS -->
<jsp:include page="../includes/link.jsp"></jsp:include>

<!-- custom javascript -->
<jsp:include page="../includes/script.jsp"></jsp:include>



</head>
<body>
	<header class="section-header">
	
		<section class="section-content padding-y-sm">
		<div class="container">
			<jsp:include page="../includes/presentacioncreador.jsp"></jsp:include>

		</div>
		<!-- container .//  -->
	</section>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>

	</header>
<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title">Error 403.</h3>
			</div>
			<div class="panel-body">
				<img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
				<h4>Permiso denegado!</h4>				
				<br>
				<button class="btn btn-success" onclick="goBack()">REGRESAR</button>
			</div>
		</div>

		<jsp:include page="../includes/footer.jsp"></jsp:include>		

	</div> <!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
		
	<script>
		function goBack() {
		    window.history.back();
		}
	</script>
	
</body>
</html>