<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Creacion de Anuncios</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/productos/save" var="urlForm"></spring:url>
<spring:url value="/lineas/create" var="lineaCreate" />
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>
	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Datos del Producto</span>
		</h3>
		<form:form action="${urlForm}" method="post"
			enctype="multipart/form-data" modelAttribute="producto">
			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<a href="${lineaCreate}" class="btn btn-success" role="button"
							title="Crear Linea">Crear Linea</a> <br> <br>


						<div class="form-group">
							<label for="codigo_producto">Codigo Producto</label>
							<c:forEach var="producto" items="${productos}">
								<c:set var="i" value="${producto.codigo_producto}" />
							</c:forEach>
							<div class="col-sm-2">
								<form:input width="4" type="text" class="form-control"
									hidden="true" path="codigo_producto" id="codigo_producto"
									required="required" value="${i + 1}" />
							</div>
						</div>
						<div class="form-group">
							<label for="nombre_producto">Nombre del Producto</label>
							<form:input type="text" class="form-control"
								path="nombre_producto" id="nombre_producto" required="required" />
								
							<div class="col-sm-6">
								<div class="form-group">
									<label for="ingreso_almacen">Ingreso Almacen</label>
									<form:input type="date" class="form-control" path="ingreso_almacen"
										id="ingreso_almacen" required="required"
										pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" />
								</div>
							</div>
	                       <div class="col-sm-6">
								<div class="form-group">
									<label for="salida_almacen">Salida Almacen</label>
									<form:input type="date" class="form-control" path="salida_almacen"
										id="version" required="required"
										pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" />
								</div>
							</div>
							<label for="stock_producto">Stock del Producto </label>
							<form:input type="text" class="form-control" path="stock_producto"
								id="stock_producto" required="required" />
								
								
								<label for="colores_producto">Colores del Producto </label>
							<form:input type="text" class="form-control" path="colores_producto"
								id="colores_producto" required="required" />
								
									<label for="qr_producto">QR del Producto </label>
							<form:input type="text" class="form-control" path="qr_producto"
								id="colores_producto" required="required" />
								
								<label for="ppv_producto">PPV Producto </label>
							<form:input type="text" class="form-control" path="ppv_producto"
								id="ppv_producto" required="required" />
								
								
									<label for="pvf_producto">PVF Producto </label>
							<form:input type="text" class="form-control" path="pvf_producto"
								id="pvf_producto" required="required" />
								
								<label for="claveApi">Clave Api </label>
							<form:input type="text" class="form-control" path="claveApi"
								id="claveApi" required="required" />		
								
										<div class="form-group">
									<label for="version">Version</label>
									<form:input type="date" class="form-control" path="version"
										id="version" required="required"
										pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" />
								</div>
						</div>

						<div class="form-group">
							<label for="ruta_imagen">Foto Ruta</label> <input type="file"
								id="archivoImagen" name="archivoImagen" />
							<p class="help-block">Imagen del Anuncio</p>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="form-group">
						 <label for="fkcodigo_linea">Elegir Linea: </label>
							<form:select id="fkcodigo_linea" path="fkcodigo_linea"
								class="form-control">
								<c:forEach items="${lineas}" var="linea">

									<c:set var="i" value="${linea.codigo_linea}" />
									
											<option value="${i}">${linea.nombre_linea}<option>
									
									
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<label for="preparacion_producto">Preparacion del Producto</label>
							<form:textarea class="form-control" path="preparacion_producto"
								id="preparacion_producto" rows="10"></form:textarea>
						</div>
					</div>
				</div>
				<div class="form-buttons">
					<div class="button">
						<button type="submit" class="btn btn-danger">Guardar</button>
					</div>
				</div>
			</fieldset>
		</form:form>
		<hr class="featurette-divider">
	</div>
	<!-- /container -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>
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
			$("#version").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>


	<spring:hasBindErrors name="anuncios">
		<div class='alert alert-danger' role='alert'>
			Por favor corrija los siguientes errores:
			<ul>
				<c:forEach var="error" items="${errors.allErrors}">
					<li><spring:message message="${error}" /></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>


</body>



</html>