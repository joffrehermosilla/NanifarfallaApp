<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>

<!-- Titulo -->
<title>Nanifarfalla | Bienvenido</title>

<spring:url value="/resources" var="urlPublic" />

<!-- Styles CSS -->
<jsp:include page="../includes/link.jsp"></jsp:include>

<!-- custom javascript -->
<jsp:include page="../includes/script.jsp"></jsp:include>



</head>
<body>
<jsp:include page="../includes/calendario.jsp"></jsp:include>
</body>
</html>