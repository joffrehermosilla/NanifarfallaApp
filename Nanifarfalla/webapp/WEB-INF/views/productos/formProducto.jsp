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
<spring:url value="/productos/save" var="urlForm"></spring:url>
<spring:url value="/productos/create" var="urlCreate"></spring:url>
<spring:url value="/productos/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Productos</title>

</head>

<body>

	<header class="section-header"> </header>


	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nueva Regla de
				Producto </span>
		</h3>


		<spring:hasBindErrors name="InstanciaProducto">
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
			enctype="multipart/form-data" modelAttribute="InstanciaProducto">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>

						<c:forEach var="productoz" items="${productoz}">
							<c:set var="i" value="${productoz.codigo_producto}" />
						</c:forEach>

						<div class="col-sm-2">
							<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="codigo_producto"
								id="codigo_producto" required="required" value="${i + 1}" />
								-->
							<form:hidden path="codigo_producto" />
						</div>

						<div class="form-group">
							<form:label for="nombre_producto" path="nombre_producto"
								id="nombre_producto">Nombre de Producto</form:label>
							<form:input type="text" class="form-control"
								path="nombre_producto" required="required"></form:input>






						</div>
						<div class="form-group">
							<form:label for="ingreso_almacen_producto"
								path="ingreso_almacen_producto" id="ingreso_almacen_producto">Ingreso a Almacen</form:label>
							<form:input type="date" class="form-control"
								path="ingreso_almacen_producto" required="required"
								pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}"></form:input>

						</div>
						<div class="form-group">
							<form:label for="salida_almacen_producto"
								path="salida_almacen_producto" id="salida_almacen_producto">Salida de Almacen</form:label>
							<form:input type="date" class="form-control"
								path="salida_almacen_producto" required="required"
								pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}"></form:input>

						</div>

						<div class="form-group">
							<form:label for="stock_producto" path="stock_producto"
								id="stock_producto">Stock del Producto</form:label>
							<form:input type="text" class="form-control"
								path="stock_producto" required="required"></form:input>
							<div class="col-sm-2"></div>

							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="preparacion_producto">Preparacion del
											Producto</label>
										<form:textarea class="form-control"
											path="preparacion_producto" id="preparacion_producto"
											rows="10"></form:textarea>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="ruta_foto">Imagen1</label> <input type="file"
									id="archivoImagen" name="archivoImagen" />
								<p class="help-block">Imagen1</p>
							</div>
							<div class="form-group">
								<label for="ruta_foto1">Imagen1</label> <input type="file"
									id="archivoImagen1" name="archivoImagen1" />
								<p class="help-block">Imagen1</p>
							</div>
							<div class="form-group">
								<label for="ruta_foto2">Imagen2</label> <input type="file"
									id="archivoImagen2" name="archivoImagen2" />
								<p class="help-block">Imagen1</p>
							</div>
							<div class="form-group">
								<label for="ruta_foto3">Imagen1</label> <input type="file"
									id="archivoImagen3" name="archivoImagen3" />
								<p class="help-block">Imagen1</p>
							</div>
							<div class="form-group">
								<label for="ruta_foto4">Imagen1</label> <input type="file"
									id="archivoImagen4" name="archivoImagen4" />
								<p class="help-block">Imagen1</p>
							</div>
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
		// Configuracion de la barra de heramientas
		// https://www.tinymce.com/docs/get-started/basic-setup/
		tinymce
				.init({
					selector : '#preparacion_producto',
					plugins : "textcolor, table lists code",
					toolbar : " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
				});
	</script>

	<script>
		$(function() {
			$("#temporada_producto").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>





</body>



</html>