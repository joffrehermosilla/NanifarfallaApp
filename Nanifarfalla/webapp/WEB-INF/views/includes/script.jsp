
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
<spring:url value="/resources" var="urlPublic" />

</head>

<script src="${urlPublic}/js/script.js" type="text/javascript"></script>

<script type="text/javascript">
	/// some script

	// jquery ready start
	$(document).ready(function() {
		// jQuery code

	});
	// jquery end
</script>

<script src="${urlPublic}/js/vendor.min.js"></script>
<script src="${urlPublic}/js/theme.min.js"></script>

<script src="${urlPublic}/js/Chart.min.js"></script>
<script src="${urlPublic}/js/tether.min.js"></script>
<script src="${urlPublic}/js/popper.min.js"></script>
<script src="${urlPublic}/js/popper.min.js"></script>
<script src="${urlPublic}/js/cookie.js"></script>
<script src="${urlPublic}/js/ceoshowing.js"></script>

<script src="${urlPublic}/js/popupmensaje.js"></script>
<script src="${urlPublic}/js/lazysizes.min.js"></script>
<script src="${urlPublic}/js/scripts.js?ver=1576164497"></script>
<script src="${urlPublic}/js/whishlist.js?ver=4.9.8"></script>

<script src="${urlPublic}/js/chart.bundle.min.js"></script>
<script src="${urlPublic}/js/calendar.js"></script>


<script type="text/javascript"
	src="https://www.google-analytics.com/analytics.js"></script>

<script src="${urlPublic}/js/owl.carousel.min.js"></script>








<script type="text/javascript" src="${urlPublic}/js/zoomwindow.js"></script>


<script type="text/javascript" src="${urlPublic}/js/twinmax.js"></script>

<script type="text/javascript" src="${urlPublic}/js/pen.js"></script>













<!--
<script src="${urlPublic}/js/vendor.min.js"></script>
<script src="${urlPublic}/js/theme.min.js"></script>
<script src="${urlPublic}/js/jquery.min.js"></script>
<script src="${urlPublic}/js/Chart.min.js"></script>
<script src="${urlPublic}/js/tether.min.js"></script>
<script src="${urlPublic}/js/popper.min.js"></script>
<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
<script src="${urlPublic}/js/popper.min.js"></script>
<script src="${urlPublic}/js/cookie.js"></script>
<script src="${urlPublic}/js/ceoshowing.js"></script>
<script src="${urlPublic}/js/popupmensaje.js"></script>
<script src="${urlPublic}/js/lazysizes.min.js"></script>
<script src="${urlPublic}/js/scripts.js?ver=1576164497"></script>
<script src="${urlPublic}/js/whishlist.js?ver=4.9.8"></script>

<script src="${urlPublic}/js/chart.bundle.min.js"></script>
<!--  <script type="text/javascript" src="${urlPublic}/js/jquery.js"></script>-->
<!-- 
<script type="text/javascript"
	src="${urlPublic}/js/jquery-migrate.min.js"></script> -->

<!--  <script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
<!-- <script type="text/javascript" src="${urlPublic}/js/utils.min.js"></script>
<script type="text/javascript"
	src="${urlPublic}/js/plupload.full.min.js"></script>
<script type="text/javascript" src="${urlPublic}/js/efectoletras.min.js"></script>

<!--  <script src="${urlPublic}/js/jqueryoldversion.js"></script>-->

<!--  <script
	src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>-->


<!-- The filemtime is to append a timestamp for the last time the stylesheet was updated to automate cache busting from CloudFlare -->