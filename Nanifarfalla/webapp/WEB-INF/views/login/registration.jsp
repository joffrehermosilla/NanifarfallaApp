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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<style>
.password-verdict {
	color: #000;
}
</style>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script th:src="@{/resources/pwstrength.js}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title th:text="${label.form.title}">form</title>

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

	<div class="container">
		<div>
			<h1 th:text="${label.form.title}">form</h1>
			<br />
			<form action="${urlForm}" method="POST" enctype="utf8" enctype="multipart/form-data" modelAttribute="usuario">
				<div class="form-group row">
					<label class="col-sm-3" th:text="${label.user.firstName}">first</label>
					<span class="col-sm-5"><input class="form-control"
						name="firstName" value="" required="required" /></span> <span
						id="firstNameError" class="alert alert-danger col-sm-4"
						style="display: none"></span>

				</div>
				<div class="form-group row">
					<label class="col-sm-3" th:text="${label.user.lastName}">last</label>
					<span class="col-sm-5"><input class="form-control"
						name="lastName" value="" required="required" /></span> <span
						id="lastNameError" class="alert alert-danger col-sm-4"
						style="display: none"></span>

				</div>
				<div class="form-group row">
					<label class="col-sm-3" th:text="${label.user.email}">email</label>
					<span class="col-sm-5"><input type="email"
						class="form-control" name="email" value="" required="required" /></span>
					<span id="emailError" class="alert alert-danger col-sm-4"
						style="display: none"></span>

				</div>
				<div class="form-group row">
					<label class="col-sm-3" th:text="${label.user.password}">password</label>
					<span class="col-sm-5"><input id="password"
						class="form-control" name="password" value="" type="password"
						required="required" /></span> <span id="passwordError"
						class="alert alert-danger col-sm-4" style="display: none"></span>
				</div>
				<div class="form-group row">
					<label class="col-sm-3" th:text="${label.user.confirmPass}">confirm</label>
					<span class="col-sm-5"><input id="matchPassword"
						class="form-control" name="matchingPassword" value=""
						type="password" required="required" /></span> <span id="globalError"
						class="alert alert-danger col-sm-4" style="display: none"></span>
				</div>
				<div class="form-group row">
					<label class="col-sm-3">Use Two
						Step Verification</label> <span class="col-sm-5"><input
						type="checkbox" name="using2FA" value="true" /></span>
				</div>
				<br />
				<button type="submit" class="btn btn-primary"
					th:text="${label.form.submit}">submit</button>
			</form>
			<br /> <a th:href="@{/login}" th:text="${label.form.loginLink}">login</a>
		</div>
	</div>

	<script th:inline="javascript">
var serverContext ='${contextRoot}';

$(document).ready(function () {
	$('form').submit(function(event) {
		register(event);
	});
	
	$(":password").keyup(function(){
		if($("password").val() != $("matchPassword").val()){
	        $("globalError").show().html(/*[[${PasswordMatches.user}]]*/);
	    }else{
	    	$("globalError").html("").hide();
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
		    	          wordOneNumber: /*[$[{error.wordOneNumber}]]*/,
		    		  wordOneSpecialChar: /*[[${error.wordOneSpecialChar}]]*/
		    		}
		    	}
		};
	 $('password').pwstrength(options);
});

function register(event){
	event.preventDefault();
    $(".alert").html("").hide();
    $(".error-list").html("");
    if($("password").val() != $("matchPassword").val()){
    	$("globalError").show().html(/*[[{PasswordMatches.user}]]*/);
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
            window.location.href = serverContext + "emailError.html";
        }
        else if(data.responseJSON.error == "UserAlreadyExist"){
            $("emailError").show().html(data.responseJSON.message);
        }
        else if(data.responseJSON.error.indexOf("InternalError") > -1){
            window.location.href = serverContext + "login?message=" + data.responseJSON.message;
        }
        else{
        	var errors = $.parseJSON(data.responseJSON.message);
            $.each( errors, function( index,item ){
            	if (item.field){
            		$(item.field+"Error").show().append(item.defaultMessage+"<br/>");
            	}
            	else {
            		$("globalError").show().append(item.defaultMessage+"<br/>");
            	}
               
            });
        }
    });
}

</script>
</body>

</html>
