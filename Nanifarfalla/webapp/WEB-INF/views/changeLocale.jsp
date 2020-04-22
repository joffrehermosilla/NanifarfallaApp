<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${param.lang}">
<head>
<spring:url value="/resources" var="urlPublic" />
    <title>PhraseApp - i18n</title>
</head>
<body>
	<h2>
		<fmt:message key="label.chooseSessionLocale" />
	</h2>
	<ul>
		<li><a href="?sessionLocale=en"><fmt:message key="label.lang.en" /></a></li>
		<li><a href="?sessionLocale=de"><fmt:message key="label.lang.de" /></a></li>
		<li><a href="?sessionLocale=fr"><fmt:message key="label.lang.fr" /></a></li>
		<li><a href="?sessionLocale=zh"><fmt:message key="label.lang.cn" /></a></li>
	</ul>
	<c:if test="${not empty param.sessionLocale}">

		<fmt:message key="label.cookieChangeSuccess" />
		<a href="sessionLocale.jsp"></a> 
		<button ><fmt:message key="label.viewPage" />	</button>
	</c:if>
	
	<h2>
		<fmt:message key="label.chooseCookieLocale" />
	</h2>
	<ul>
		<li><a href="?cookieLocale=en"><fmt:message key="label.lang.en" /></a></li>
		<li><a href="?cookieLocale=de"><fmt:message key="label.lang.de" /></a></li>
		<li><a href="?cookieLocale=fr"><fmt:message key="label.lang.fr" /></a></li>
		<li><a href="?cookieLocale=zh"><fmt:message key="label.lang.cn" /></a></li>
	</ul>
	<c:if test="${not empty param.cookieLocale}">
		<fmt:message key="label.cookieChangeSuccess" />
		<a href="cookieLocale.jsp"></a>
		<button><fmt:message key="label.viewPage" /></button>
	</c:if>
	
</body>
</html>