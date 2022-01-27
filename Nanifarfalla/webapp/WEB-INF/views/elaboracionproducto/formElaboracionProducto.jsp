<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/elaboracionproducto/save" var="urlForm"></spring:url>
<spring:url value="/elaboracionproducto/create" var="urlCreate"></spring:url>
<spring:url value="/elaboracionproducto/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Nueva Regla Elaboracion Productos</title>

</head>

<body>

	<header class="section-header"> </header>


	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nueva Regla de
				Elaboracion Producto </span>
		</h3>


		<spring:hasBindErrors name="InstanciaElaboracionProducto">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


		${InstanciaElaboracionProducto}
		<form:form action="${urlForm}" method="post" id="form" class="form"
			enctype="multipart/form-data"
			modelAttribute="InstanciaElaboracionProducto">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>

						<c:forEach var="elaboracionproductoz"
							items="${elaboracionproductoz}">
							<c:set var="i"
								value="${elaboracionproductoz.codigo_elaboracionproducto}" />
						</c:forEach>

						<div class="col-sm-2">
							<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="codigo_elaboracionproducto"
								id="codigo_estadousuario" required="required" value="${i + 1}" />
								-->
							<form:hidden path="codigo_elaboracionproducto" />
						</div>

						<div class="form-group">
							<form:label for="modelo_producto" path="modelo_producto"
								id="modelo_producto">Modelo de Producto</form:label>
							<form:input type="text" class="form-control"
								path="modelo_producto" required="required"></form:input>






						</div>
						<div class="form-group">
							<form:label for="temporada_producto" path="temporada_producto"
								id="temporada_producto">Temporada</form:label>
							<form:input type="date" class="form-control"
								path="temporada_producto" required="required"
								pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}"></form:input>

						</div>



						<div class="col-sm-2"></div>
						<div>
							<select id="modelo_producto" class="form-control">
								<option value="-1">Confirme Modelo de Producto
									existente</option>
								<c:forEach var="elaboracionproductoz"
									items="${elaboracionproductoz}">
									<option value="-1">${elaboracionproductoz.modelo_producto}</option>
								</c:forEach>
							</select>
						</div>
					</div>

				</div>

				<div class="form-buttons">
					<div class="button">
						<button type="submit" value="submit" class="btn btn-danger href="${urlStart}">Guardar</button>
					</div>


				</div>
			</fieldset>
		</form:form>


		<hr class="featurette-divider">
	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="${urlPublic}/tinymce/tinymce.min.js"></script>

	<script>
		$(function() {
			$("#temporada_producto").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>





</body>



</html>