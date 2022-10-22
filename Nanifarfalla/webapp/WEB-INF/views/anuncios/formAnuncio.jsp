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
<spring:url value="/anuncios/save" var="urlForm"></spring:url>
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
			<span class="label label-success">Datos del Anuncio</span>
		</h3>
		<form:form action="${urlForm}" method="post"
			enctype="multipart/form-data" modelAttribute="InstanciaAnuncio">
			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="codigo_anuncio">Codigo Anuncio</label>
							<c:forEach var="anuncio" items="${anunciosz}">
								<c:set var="i" value="${anuncio.codigo_anuncio}" />
							</c:forEach>
							<div class="col-sm-2">
								<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="codigo_anuncio"
								id="codigo_anuncio" required="required" value="${i + 1}" />
								-->
								<form:hidden path="codigo_anuncio" />
							</div>
							<div class="form-group">
								<label for="mensaje_anuncio">Mensaje del Anuncio</label>
								<form:input type="text" class="form-control"
									path="mensaje_anuncio" id="mensaje_anuncio" required="required" />
								<div class="col-sm-6">
									<div class="form-group">
										<label for="version">Version</label>
										<form:input type="date" class="form-control" path="version"
											id="version" required="required"
											pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" />
									</div>
								</div>

								<label for="pie_mensaje">Pie de Mensaje </label>
								<form:input type="text" class="form-control" path="pie_mensaje"
									id="pie_mensaje" required="required" />
							</div>

							<div class="form-group">
								<label for="ruta_imagen">Imagen</label> <input type="file"
									id="archivoImagen" name="archivoImagen" />
								<p class="help-block">Imagen del Anuncio</p>
							</div>
						</div>
						<div class="col-sm-2">
							<div class="form-group">
								<label for="estatus">Estatus</label> <select id="estatus"
									name="estatus" class="form-control">
									<option value="importante">importante</option>
									<option value="info">info</option>
									<option value="alerta">alerta</option>
									<option value="eventos">eventos</option>
								</select> <label for="fkcodigo_tipoalerta">Categoria Anuncio: </label>
								<form:select id="fkcodigo_tipoalerta" path="fkcodigo_tipoalerta"
									class="form-control">
									<c:forEach items="${anuncios}" var="anuncio">

										<c:set var="i" value="${anuncio.fkcodigo_tipoalerta}" />
										<c:choose>
											<c:when test="${i eq 1}">
												<form:option value="${i}">importante</form:option>
											</c:when>
											<c:when test="${i eq 2}">
												<form:option value="${i}">info</form:option>
											</c:when>
											<c:when test="${i eq 3}">
												<form:option value="${i}">alerta</form:option>
											</c:when>
											<c:otherwise>
												<form:option value="${i}">eventos</form:option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="anuncio_prinicipal">Anuncio Principal</label>
								<form:textarea class="form-control" path="anuncio_principal"
									id="anuncio_principal" rows="10"></form:textarea>
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
					selector : '#anuncio_principal',
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