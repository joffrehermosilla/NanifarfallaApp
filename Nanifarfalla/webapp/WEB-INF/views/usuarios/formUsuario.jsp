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
<!--  <meta http-equiv="X-UA-Compatible" content="IE=edge">-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta http-equiv="Content-Type" content="text/html">
<title>Registrar Usuario</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/usuarios/registration" var="urlForm"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="../includes/estadoymenu.jsp"></jsp:include>
	<header class="section-header">
		<jsp:include page="../includes/navbarheader.jsp"></jsp:include>
	</header>





	<!-- ========================= SECTION CONTENT ========================= -->
	<section class="section-content padding-y">

		<!-- ============================ COMPONENT REGISTER   ================================= -->
		<div class="card mx-auto" style="max-width: 520px; margin-top: 40px;">
			<article class="card-body">
				<header class="mb-4">
					<h4 class="card-title">Sign up</h4>
				</header>
				<form:form action="${urlForm}" method="post"
					enctype="multipart/form-data" modelAttribute="usuario">
					<fieldset>
						<div class="form-group">
							<label for="codigo_usuario" path="codigo_usuario">Codigo
								Usuario</label>
							<c:forEach var="usuario" items="${usuarios}">
								<c:set var="i" value="${usuario.codigo_usuario}" />
							</c:forEach>
							<div class="col-sm-2">
								<input width="4" type="text" class="form-control" hidden="true"
									path="codigo_usuario" id="codigo_usuario" required="required"
									value="${i + 1}" />
							</div>
						</div>
						<div class="form-row">
							<div class="col form-group">
								<form:label for="nombre_usuario" path="nombre_usuario">Nombre de Usuario</form:label>
								<form:input type="text" class="form-control"
									path="nombre_usuario" id="nombre_usuario" required="required" />
								<span id="firstNameError" class="alert alert-danger col-sm-4"
									style="display: none"></span>
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<form:label for="apellido_usuario" path="apellido_usuario">Apellidos de Usuario</form:label>
								<form:input type="text" class="form-control"
									path="apellido_usuario" id="apellido_usuario"
									required="required" />
								<span id="lastNameError" class="alert alert-danger col-sm-4"
									style="display: none"></span>
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row end.// -->
						<div class="form-group">
							<form:label path="email">Email</form:label> <span><form:input
								type="email" path="email" class="form-control" name="email" value=""
								required="required" /></span> <small class="form-text text-muted">We'll
								never share your email with anyone else.</small> <span id="emailError"
								class="alert alert-danger col-sm-4" style="display: none"></span>
						</div>


						<!-- form-group end.// -->

						<div class="form-group form-row">
							<label class="col-md-3 col-form-label">I am a</label>
							<div class="col-sm-9 pt-1">
								<label class="custom-control custom-radio custom-control-inline">
									<input class="custom-control-input" checked="" type="radio"
									name="account_type" value="option1"> <span
									class="custom-control-label"> Buyer </span>
								</label> <label
									class="custom-control custom-radio custom-control-inline">
									<input class="custom-control-input" type="radio"
									name="account_type" value="option2"> <span
									class="custom-control-label"> Seller </span>
								</label> <label
									class="custom-control custom-radio custom-control-inline">
									<input class="custom-control-input" type="radio"
									name="account_type" value="option3"> <span
									class="custom-control-label"> Both </span>
								</label>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>City</label> <input type="text" class="form-control">
							</div>
							<!-- form-group end.// -->
							<div class="form-group col-md-6">
								<label>Country</label> <select id="inputState"
									class="form-control">
									<option>Choose...</option>
									<option>Uzbekistan</option>
									<option>Russia</option>
									<option selected="">United States</option>
									<option>India</option>
									<option>Afganistan</option>
								</select>
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row.// -->
						<div class="form-row">
							<div class="form-group col-md-6">
								<form:label for="password_usuario" path="password_usuario">Create password</form:label>
								<form:input path="password_usuario" id="password"
									class="form-control" name="password_usuario" value=""
									type="password" required="required" />

								<span id="passwordError" class="alert alert-danger col-sm-4"
									style="display: none"></span>
							</div>
							<!-- form-group end.// -->
							<div class="form-group col-md-6">
								<label>Repeat password</label> <input id="matchPassword"
									class="form-control" name="matchingPassword" value=""
									type="password" required="required" /> <span id="globalError"
									class="alert alert-danger col-sm-4" style="display: none"></span>
							</div>
							<!-- form-group end.// -->
						</div>
						<div class="form-group">
							<div class="form-buttons">
								<div class="button">
									<button type="submit" class="btn btn-danger">Guardar</button>
								</div>
							</div>
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<label class="custom-control custom-checkbox"> <input
								type="checkbox" class="custom-control-input" checked="">
								<div class="custom-control-label">
									I am agree with <a href="#">terms and contitions</a>
								</div>
							</label>
						</div>
					</fieldset>
					<!-- form-group end.// -->
				</form:form>
			</article>
			<!-- card-body.// -->
		</div>
		<!-- card .// -->
		<p class="text-center mt-4">
			Have an account? <a href="">Log In</a>
		</p>
		<br> <br>
		<!-- ============================ COMPONENT REGISTER  END.// ================================= -->


	</section>
	<!-- ========================= SECTION CONTENT END// ========================= -->

	<!-- /container -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script>
		$(function() {
			$("#version").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>


	<spring:hasBindErrors name="usuario">
		<div class='alert alert-danger' role='alert'>
			Por favor corrija los siguientes errores:
			<ul>
				<c:forEach var="error" items="${errors.allErrors}">
					<li><spring:message message="${error}" /></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<script>
		var serverContext = "\/";

		$(document).ready(function() {
			$('form').submit(function(event) {
				register(event);
			});

			$(":password").keyup(function() {
				if ($("#password_usuario").val() != $("#matchPassword").val()) {
					$("#globalError").show().html("${PasswordMatches.user}");
				} else {
					$("#globalError").html("").hide();
				}
			});

			options = {
				common : {
					minChar : 8
				},
				ui : {
					showVerdictsInsideProgressBar : true,
					showErrors : true,
					errorMessages : {
						wordLength : "${error.wordLength}",
						wordNotEmail : "${error.wordNotEmail}",
						wordSequences : "${error.wordSequences}",
						wordLowercase : "${error.wordLowercase}",
						wordUppercase : "${error.wordUppercase}",
						wordOneNumber : "${error.wordOneNumber}",
						wordOneSpecialChar : "${error.wordOneSpecialChar}"
					}
				}
			};

			$(':password').pwstrength(options);
		});

		function register(event) {
			event.preventDefault();
			$(".alert").html("").hide();
			$(".error-list").html("");
			if ($("#password_usuario").val() != $("#matchPassword").val()) {
				$("#globalError").show().html("Password does not match!");
				return;
			}
			var formData = $('form').serialize();
			$
					.post(serverContext + "usuarios/registration", formData,
							function(data) {
								if (data.message == "success") {
									window.location.href = serverContext + "/login/successRegister";
								}

							})
					.fail(
							function(data) {
								if (data.responseJSON.error
										.indexOf("MailError") > -1) {
									window.location.href = serverContext
											+ "/login/emailError.html";
								} else if (data.responseJSON.error == "UserAlreadyExist") {
									$("#emailError").show().html(
											data.responseJSON.message);
								} else if (data.responseJSON.error
										.indexOf("InternalError") > -1) {
									window.location.href = serverContext
											+ "login?message="
											+ data.responseJSON.message;
								} else {
									var errors = $
											.parseJSON(data.responseJSON.message);
									$.each(errors, function(index, item) {
										if (item.field) {
											$("#" + item.field + "Error")
													.show().append(
															item.defaultMessage
																	+ "<br/>");
										} else {
											$("#globalError").show().append(
													item.defaultMessage
															+ "<br/>");
										}

									});
								}
							});
		}
	</script>
</body>
</html>