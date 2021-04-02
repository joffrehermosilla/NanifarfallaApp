
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII"/>
<title th:text="#{label.pages.home.title}">home</title>
</head>
<body>
<div>

<h1 class="alert alert-info" th:text="#{message.regSucc}">success</h1>
<br/>
<span th:if="${param.token != null}" th:text="#{token.message}">token</span>
<span th:text="${param.token}">token</span>
<br/>
<a class="btn btn-primary" th:href="@{/login}" th:text="#{label.login}">login</a>
</div>          
</body>
</html>