<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />

<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<title><fmt:message key="label.pages.home.title" /></title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" th:href="@{/homepage.html}"> <fmt:message
						key="label.pages.home.title" /> 
						  <a class="navbar-brand" th:href="@{/homepage.html}" th:text="${label.pages.home.title}">home</a>
				</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a th:href="@{/logout}"> <fmt:message
							key="label.pages.logout" /> 
				</a></li>
				  <li><a th:href="@{/logout}" th:text="${label.pages.logout}">logout</a> </li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<p sec:authorize="!hasAuthority('ROLE_BUYER')">
			<fmt:message key="message.unauth" />
			
		</p>

		<h1 sec:authorize="hasAuthority('ROLE_SELLER')">
			<fmt:message key="label.pages.admin.message" />
			
		</h1>
		
		 <p sec:authorize="!hasAuthority('ROLE_BUYER')" th:text="${message.unauth}">unauth</p>   
        
     <h1 sec:authorize="hasAuthority('ROLE_SELLER')" th:text="${label.pages.admin.message}">admin</h1>
	</div>
</body>
</html>