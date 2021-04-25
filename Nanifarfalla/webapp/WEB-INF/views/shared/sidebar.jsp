
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<p class="lead">Shop Products</p>

<spring:url value="/" var="urlRoot" />


<div class="list-group">


	<c:forEach items="${lineas}" var="category">
		<a href="${contextRoot}/show/category/${category.codigo_linea}/products" class="list-group-item" id="a_${category.nombre_linea}">${category.nombre_linea}</a>
	</c:forEach>

	 
</div>