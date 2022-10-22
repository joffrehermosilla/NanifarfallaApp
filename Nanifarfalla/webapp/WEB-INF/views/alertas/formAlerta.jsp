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
<spring:url value="/alertas/save" var="urlForm"></spring:url>
<spring:url value="/alertas/create" var="urlCreate"></spring:url>
<spring:url value="/alertas/index" var="urlStart"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<title>Creacion de Nueva Regla de Alerta</title>

</head>

<body>

	<header class="section-header"> </header>


	<div class="container theme-showcase" role="main">
		<h3 class="blog-title">
			<span class="label label-success">Crear Nueva Regla de Alerta
			</span>
		</h3>


		<spring:hasBindErrors name="InstanciaAlerta">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


		${InstanciaAlerta}
		<form:form action="${urlForm}" method="post" id="form" class="form"
			enctype="multipart/form-data" modelAttribute="InstanciaAlerta">

			<fieldset>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group"></div>

						<c:forEach var="alertasz" items="${alertasz}">
							<c:set var="i" value="${alertasz.codigo_alerta}" />
						</c:forEach>

						<div class="col-sm-2">
							<!--  	<form:input width="4" type="text" class="form-control"
								hidden="true" path="codigo_alerta"
								id="codigo_alerta" required="required" value="${i + 1}" />
								-->
							<form:hidden path="codigo_alerta" />
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="mensaje_alerta">Mensaje Alerta</label>
									<form:textarea class="form-control" path="mensaje_alerta"
										id="mensaje_alerta" rows="10"></form:textarea>
								</div>
							</div>
						</div>



						<div class="form-group">
							<form:label for="precio" path="precio" id="precio">Precio</form:label>
							<form:input type="text" class="form-control" path="precio"
								required="required"></form:input>
						</div>

						<div class="form-group">
							<form:label for="categoria" path="precio" id="categoria">Categoria</form:label>
							<form:input type="text" class="form-control" path="categoria"
								required="required"></form:input>
						</div>


						<div class="col-sm-2"></div>
						<div>
							<select name="tipo" class="form-control"">
								<option value="-1">Seleccione Tipo de Alerta</option>

								<c:forEach var="menuz" items="${menuz}">
									<option value="${alertasz.mTipoAlerta.codigo_tipoalerta}">${alertasz.mTipoAlerta.nombre_tipoalerta}</option>
								</c:forEach>

							</select>
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
					selector : '#mensaje_alerta',
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