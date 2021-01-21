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

<style>
.password-verdict {
	color: #000;
}
</style>

<!--  <meta http-equiv="X-UA-Compatible" content="IE=edge">-->
<script th:src="@{/resources/js/pwstrength.js}"></script>
<title>Registrar Usuario</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/usuarios/save" var="urlForm"></spring:url>
<spring:url value="/usuarios/create" var="urlCreate"></spring:url>
<spring:url value="/usuarios/cargarPais" var="urlUbigeo"></spring:url>
<jsp:include page="../includes/link.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
<script type="text/javascript" src="${urlPublic}/js/jquery.min.js"></script>








<script type="text/javascript" src="${urlPublic}/js/pwstrength.js"></script>

<script type="text/javascript" src="${urlPublic}/js/registerpassword.js"></script>

<script type="text/javascript" src="${urlPublic}/js/cargarubigeo.js"></script>

<script type="text/javascript" src="${urlPublic}/js/ubicacion.js"></script>



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
				<c:if test="${mensaje!=null }">
					<div class='alert alert-success' role="alert">${ mensaje}</div>
				</c:if>
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
							<form:label path="email">Email</form:label>
							<span><form:input type="email" path="email"
									class="form-control" name="email" value="" required="required" /></span>
							<small class="form-text text-muted">We'll never share
								your email with anyone else.</small> <span id="emailError"
								class="alert alert-danger col-sm-4" style="display: none"></span>
						</div>


						<!-- form-group end.// -->

						<div class="form-group form-row">
							<label class="col-md-3 col-form-label">I am a</label>
							<div class="col-sm-9 pt-1">
								<label class="custom-control custom-radio custom-control-inline">
									<input class="custom-control-input" checked="" type="radio"
									id="1" name="role" value="1"> <span
									class="custom-control-label"> Buyer </span>
								</label> <label
									class="custom-control custom-radio custom-control-inline">
									<input class="custom-control-input" type="radio" id="2"
									name="role" value="2"> <span
									class="custom-control-label"> Seller </span>
								</label> <label
									class="custom-control custom-radio custom-control-inline">
									<input class="custom-control-input" type="radio" id="1"
									name="role" value="3"> <span
									class="custom-control-label"> Both </span>
								</label>
							</div>
						</div>
						<div class="form-row">

							<!--combo box ubicacion.js.// -->
							<div class=" myForm14 form-group col-md-6" hidden="true">

								<label for="pais">Pais</label> <select id="comboboxPais"
									class="form-control">
									<option value="-1">Seleccione Pais</option>
									<c:forEach items="${listapais}" var="pais" varStatus="t">

										<option value="${pais.codigo_pais}">${pais.nombre_pais}</option>

									</c:forEach>
								</select>
							</div>
							<!-- form-group end.// -->
							<div class="myForm15 form-group col-md-6" hidden="true">
								<label for="comboboxProvincia">Provincia</label> <select
									id="comboboxProvincia" class="form-control">
									<option value="-1">Seleccione Provincia</option>


								</select>
							</div>
							<div class="myForm16 form-group col-md-6" hidden="true">
								<label for="comboboxCiudad">Ciudad</label> <select
									id="comboboxCiudad" class="form-control">
									<option value="-1">Seleccione Ciudad</option>


								</select>
							</div>
							<!-- form-group end.// -->
							<div class=" form-group col-md-6" hidden="true">
								<label for="comboboxDistrito">Distrito</label> <select
									id="comboboxDistrito" class="form-control">
									<option value="-1">Seleccione Distrito</option>


								</select>
							</div>


							<!--combo box cargarubigeo.js.// -->
							<div class="form-group col-md-6">

								<label>Pais</label> <select id="idPais" name="idPais"
									class="form-control" onchange="buscarProvincias(this.value)">
									<option value="-1">Seleccione Pais</option>
									<c:forEach items="${listapais}" var="pais" varStatus="t">

										<option value="${pais.codigo_pais}">${pais.nombre_pais}</option>

									</c:forEach>
								</select>
							</div>
							<!-- form-group end.// -->
							<div class="form-group col-md-6">
								<label>Provincia</label> <select id="idProvincia"
									name="idProvincia" class="form-control"
									onchange="buscarCiudades(this.value)">
									<option value="-1">Seleccione Provincia</option>


								</select>
							</div>

							<!-- form-group end.// -->
							<div class="form-group col-md-6">
								<label>Ciudad</label> <select id="idCiudad" name="idCiudad"
									class="form-control" onchange="buscarDistritos(this.value)">
									<option value="-1">Seleccione Ciudad</option>


								</select>
							</div>

							<!-- form-group end.// -->
							<div class="form-group col-md-6">
								<label path="mDistrito">Distrito</label> <select id="idDistrito"
									name="idDistrito" class="form-control" path="mDistrito">
									<option value="-1">Seleccione Distrito</option>

								</select>
							</div>
							<!-- form-group end.// -->

						</div>
						<!-- form-row.// -->


						<div class="form-row">
							<div class="form-group col-md-6">
								<form:label for="password" path="password_usuario">Create password</form:label>
								<form:input path="password_usuario" id="password"
									class="form-control" name="password_usuario" value=""
									type="password" required="required" />

								<span id="passwordError" class="alert alert-danger col-sm-4"
									style="display: none"></span>
								<div class="col-sm-6 col-sm-offset-2" style="padding-top: 30px;">
									<div class="pwstrength_viewport_progress"></div>
								</div>
								<div class="row">
									<div id="messages" class="col-sm-12"></div>
								</div>

								<!-- form-group end.// -->
							</div>

							<div class="form-group col-md-6">
								<label>Repeat password</label> <input type="password"
									id="password-verify" name="matchingPassword"
									class="form-control" placeholder="Verify Password"
									required="required" /> <span id="globalError"
									class="alert alert-danger col-sm-4" style="display: none"></span>
								<button class="pswd_show passwordButton btn btn-warning">Show</button>
								<p class="incorrectMsg">passwords do not match!</p>
							</div>

							<div class="pswd_info">
								<h4 class="pswd_reqs">Password must meet the following
									requirements:</h4>
								<ul>
									<li id='letter' class='invalid'>Contains <strong>a
											lowercase letter</strong></li>

									<li id='capital' class='invalid'>Contains <strong>a
											capital letter</strong></li>

									<li id='number' class='invalid'>Contains <strong>a
											number</strong></li>

									<li id='special' class='invalid'>Contains <strong>a
											special character</strong></li>

									<li id='length' class='invalid'>Contains <strong>8
											characters</strong></li>
								</ul>
							</div>
							<iframe name="hiddenFrame" width="0" height="0" border="0"
								style="display: none;"></iframe>



							<div class="form-group" align="center">
								<div class="form-buttons">
									<div class="button">
										<button href="${urlRoot}"  type="submit" value="submit" class="btn btn-danger">Guardar</button>
									</div>
								</div>

							</div>

							<!-- form-group// -->

						</div>
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



	<script th:inline="javascript">
var serverContext = [[@{/}]];

$(document).ready(function () {
	$('form').submit(function(event) {
		register(event);
	});
	
	$(":password").keyup(function(){
		if($("#password_usuario").val() != $("#matchPassword").val()){
	        $("#globalError").show().html(/*[[${PasswordMatches.user}]]*/);
	    }else{
	    	$("#globalError").html("").hide();
	    }
	});
	
	options = {
		    common: {minChar:8},
		    ui: {
		    	showVerdictsInsideProgressBar:true,
		    	showErrors:true,
		    	errorMessages:{
		    		  wordLength: /*[[${error.wordLength}]]*/,
		    		  wordNotEmail: /*[[${error.wordNotEmail}]]*/,
		    		  wordSequences: /*[[${error.wordSequences}]]*/,
		    		  wordLowercase: /*[[${error.wordLowercase}]]*/,
		    		  wordUppercase: /*[[${error.wordUppercase}]]*/,
		    	          wordOneNumber: /*[[${error.wordOneNumber}]]*/,
		    		  wordOneSpecialChar: /*[[${error.wordOneSpecialChar}]]*/
		    		}
		    	}
		};
	 $('#password').pwstrength(options);
});

function register(event){
	event.preventDefault();
    $(".alert").html("").hide();
    $(".error-list").html("");
    if($("#password_usuario").val() != $("#matchPassword").val()){
    	$("#globalError").show().html(/*[[${PasswordMatches.user}]]*/);
    	return;
    }
    var formData= $('form').serialize();
    $.post(serverContext + "usuarios/registration",formData ,function(data){
        if(data.message == "success"){
            window.location.href = serverContext + "/login/successRegister.html";
        }
        
    })
    .fail(function(data) {
        if(data.responseJSON.error.indexOf("MailError") > -1)
        {
            window.location.href = serverContext + "/login/emailError.html";
        }
        else if(data.responseJSON.error == "UserAlreadyExist"){
            $("#emailError").show().html(data.responseJSON.message);
        }
        else if(data.responseJSON.error.indexOf("InternalError") > -1){
            window.location.href = serverContext + "login?message=" + data.responseJSON.message;
        }
        else{
        	var errors = $.parseJSON(data.responseJSON.message);
            $.each( errors, function( index,item ){
            	if (item.field){
            		$("#"+item.field+"Error").show().append(item.defaultMessage+"<br/>");
            	}
            	else {
            		$("#globalError").show().append(item.defaultMessage+"<br/>");
            	}
               
            });
        }
    });
}

</script>
</body>
</html>