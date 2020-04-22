<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<html lang="${cookie['lang'].value}">
<head>
<spring:url value="/resources" var="urlPublic" />
    <title>PhraseApp - i18n</title>
</head>
<body>
	<h2>
		<fmt:message key="label.welcome" />
	</h2>
	<p><fmt:message key="label.cookieLocaleContent" /></p>
	
	<button ><fmt:message key="label.back" /></button>
</body>
</html>