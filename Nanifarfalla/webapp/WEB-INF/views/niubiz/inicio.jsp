


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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>NIUBIZ</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/estadoproducto/index" var="urlForm"></spring:url>
<spring:url value="/estadoproducto/create" var="urlCreate" />

<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<script type="text/javascript" src="https://static-content-qas.vnforapps.com/v2/js/checkout.js?qa=true"></script>




</head>


<body>
	<div>
		<h1>Nanifarlla</h1>
<!-- 			<input type="button" value="Comprar" id="niubiz" > -->
		
		<a class="btn btn-lg btn-primary" id="niubiz"> PAGAR</a>
		<p th:text="${sesionResponse.sessionKey}" />	
	</div>
</body>

</html>
<script type="text/javascript">
	$(function() {
		console.log(window.globalVar);
		$("#niubiz").click(function() {
			var codigoComercio = "${codigoComercio}";
			var sesionKey = "${sesionResponse.sessionKey}";
			var canalSesion = "${canalSesion}";
			var montoTotal = "${montoTotal}";
			VisanetCheckout.configure({
				sessiontoken : sesionKey,
				channel : canalSesion,
				merchantid : codigoComercio,
				purchasenumber : '2020100901',
				amount : montoTotal,
				expirationminutes : '5',
				timeouturl : 'about:blank',
				merchantlogo : 'img/comercio.png',
				formbuttoncolor : '#000000',
				action : '/confirmacion',
				complete : function(params) {					
					alert(JSON.stringify(params));
				}
			});
			VisanetCheckout.open();
		});
	});
</script>
