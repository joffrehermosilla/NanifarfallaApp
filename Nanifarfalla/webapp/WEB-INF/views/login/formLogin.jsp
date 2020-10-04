
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<!-- Titulo
<title>Nanifarfalla | Bienvenido</title> -->
<title th:text="${label.pages.home.title}"></title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot"></spring:url>
<!-- Styles CSS -->
<jsp:include page="../includes/link.jsp"></jsp:include>
<!-- Styles CSS -->
<jsp:include page="../includes/script.jsp"></jsp:include>





<script th:inline="javascript">
	function validate() {
		if (document.f.username.value == "" && document.f.password.value == "") {
			alert(/*[[${message.username} + ${message.password}]]*/);
			document.f.username.focus();
			return false;
		}
		if (document.f.username.value == "") {
			alert(/*[[${message.username}]]*/);
			document.f.username.focus();
			return false;
		}
		if (document.f.password.value == "") {
			alert(/*[[${message.password}]]*/);
			document.f.password.focus();
			return false;
		}
	}
</script>
<style type="text/css">
.wrapper {
	width: 500px;
	margin-left: auto;
	margin-right: auto
}

label {
	padding-left: 0 !important
}
</style>
</head>

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


	<section class="section-content padding-y bg">
		<div class="container">
			<div class="row">
				<aside class="col-md-4">

					<!-- ============================ COMPONENT LOGIN 1  ================================= -->

					<!-- ============================ COMPONENT LOGIN 1  END.// ================================= -->

				</aside>
				<aside class="col-md-4">

					<!-- ============================ COMPONENT LOGIN 2  ================================= -->

					<div class="card">
						<div class="card-body">
							<h4 class="card-title mb-4"></h4>
							<form name='form' action='${urlRoot}login' method='POST'>



								<div class="card" align="center">
									<div class="card-body" align="center">

										<h4 class="card-title mb-4">Sign in</h4>
										<c:if test="${param.error != null}">
											<img src="${urlPublic}/images/error.png" width="48"
												height="48" class="center">
											<h4 class="form-signin-heading" style="color: red">Acceso
												denegado</h4>
										</c:if>
										<a href="#" class="btn btn-facebook btn-block mb-2"> <i
											class="fab fa-facebook-f"></i> &nbsp Sign in with Facebook
										</a> <a href="#" class="btn btn-google btn-block mb-4"> <i
											class="fab fa-google"></i> &nbsp Sign in with Google
										</a>
										<div class="form-group">
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="fa fa-user"></i>
													</span>
												</div>
												<input name="username" class="form-control"
													placeholder="Username" type="text">
											</div>
											<!-- input-group.// -->
										</div>
										<!-- form-group// -->
										<div class="form-group">
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="fa fa-lock"></i>
													</span>
												</div>
												<input name="password" class="form-control"
													placeholder="Password" type="password"> <input
													type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}" />
											</div>
											<!-- input-group.// -->
										</div>
										<!-- form-group// -->
										<div class="form-group">
											<label class="custom-control custom-checkbox"> <input
												type="checkbox" class="custom-control-input" checked="">
												<div class="custom-control-label">Remember</div>
											</label>
										</div>
										<!-- form-group form-check .// -->
										<div class="form-group">

											<button type="submit" class="btn btn-primary btn-block">Login</button>
										</div>
										<!-- form-group// -->



									</div>
									<!-- card-body.// -->
								</div>
								<!-- card .// -->

							</form>
						</div>
						<!-- card-body.// -->
					</div>
					<!-- card .// -->

					<!-- ============================ COMPONENT LOGIN 2 END.// ================================= -->

				</aside>

			</div>
		</div>
		<!-- container .//  -->
	</section>


<div th:if="${param.message != null}" class="alert alert-info" th:text="${param.message[0]}">message</div>


<div th:if="${param.error != null}" class="alert alert-danger" th:text="${session[SPRING_SECURITY_LAST_EXCEPTION]}">error</div>

    <div class="container">
        <div class="row wrapper">
            <h1 th:text="${label.form.loginTitle}">Header</h1>
             <a href="?lang=en" th:text="${label.form.loginEnglish}">login</a> | 
             <a href="?lang=es_ES" th:text="${label.form.loginSpanish}">login</a>
            <br/><br/>
            
            <form name='f' action="login" method='POST' onsubmit="return validate();">
                 <span id="welcometext">&nbsp;</span>
                 
                 <br /><br />
                 <label class="col-sm-4" th:text="${label.form.loginEmail}">Email</label>
                 <span class="col-sm-8"><input class="form-control" type='text' name='username' value=''/></span>
                
                <br/><br/>        
                 <label class="col-sm-4" th:text="${label.form.loginPass}">password</label>
                 <span class="col-sm-8"><input class="form-control" type='password' name='password' /></span>
                
                <br/><br/>        
                 <label class="col-sm-4" th:text="${label.form.login2fa}">Google Authenticator Verification Code</label>
                 <span class="col-sm-8"><input class="form-control" type='text' name='code' /></span>
                
                <br/><br/>
                 <input class="btn btn-primary" name="submit" type="submit" th:value="${label.form.submit}" />
 
            </form>
            <br/> Current Locale :  <span th:text="${locale}"></span><br/><br/> 
             <a class="btn btn-default" th:href="@{/registration.html}" th:text="${label.form.loginSignUp}">signup</a>
             <br/>
             <a class="btn btn-default" th:href="@{/registrationCaptcha.html}" th:text="${label.form.loginSignUpCaptcha}">captcha signup</a>
             <br/><br/>
            <a class="btn btn-default" th:href="@{/forgetPassword.html}" th:text="${message.resetPassword}">reset</a>
        </div>
    </div>



</Body>

</html>