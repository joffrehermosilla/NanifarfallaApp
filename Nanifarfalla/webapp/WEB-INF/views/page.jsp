
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources" var="urlPublic" />
<spring:url var="css" value="${urlPublic}/ecommerce/assests/css" />
<spring:url var="js" value="${urlPublic}/ecommerce/assests/js" />
<spring:url var="images" value="/${urlPublic}/ecommerce/assests/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<jsp:include page="./includes/link.jsp"></jsp:include>

<!-- custom javascript -->
<jsp:include page="./includes/script.jsp"></jsp:include>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Online Shopping Website Using Spring MVC and HibernateJPA">
<meta name="author" content=" Joffre Hermosilla Salas">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}'
	
</script>

<!-- Bootstrap Core CSS -->
<link href="${urlPublic}/ecommerce/assests/css/bootstrap.min.css" rel="stylesheet">

<link href="${urlPublic}/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${urlPublic}/ecommerce/assests/css/bootstrap-readable-theme.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="${urlPublic}/ecommerce/assests/css/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${urlPublic}/ecommerce/assests/css/myapp.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	
	<div class="se-pre-con"></div>
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">
			
			<!-- Loading the home content -->
			<c:if test="${userClickHome == true }">
				<%@include file="page-index-1.jsp"%>
			</c:if>

			<!-- Load only when user clicks about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="./ecommerce/about.jsp"%>
			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContact == true }">
				<%@include file="./ecommerce/contact.jsp"%>
			</c:if>
			
			<!-- Load only when user clicks contact -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true }">
				<%@include file="./ecommerce/listProducts.jsp"%>
			</c:if>	
			
			
			<!-- Load only when user clicks show product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="./ecommerce/singleProduct.jsp"%>
			</c:if>								

			<!-- Load only when user clicks manage product -->
			<c:if test="${userClickManageProduct == true}">
				<%@include file="./ecommerce/manageProduct.jsp"%>
			</c:if>	

			<!-- Load only when user clicks manage product -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="./ecommerce/cart.jsp"%>
			</c:if>	

		</div>


		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${urlPublic}/ecommerce/assests/js/jquery.js"></script>

		<script src="${urlPublic}/ecommerce/assests/js/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${urlPublic}/ecommerce/assests/js/bootstrap.min.js"></script>
		
		<!-- DataTable Plugin -->
		<script src="${urlPublic}/ecommerce/assests/js/jquery.dataTables.js"></script>
		
		<!-- DataTable Bootstrap Script -->
		<script src="${urlPublic}/ecommerce/assests/js/dataTables.bootstrap.js"></script>
		
		<!-- DataTable Bootstrap Script -->
		<script src="${urlPublic}/ecommerce/assests/js/bootbox.min.js"></script>
		
		<!-- Self coded javascript -->
		<script src="${urlPublic}/js/myapp.js"></script>
		
		
		

	</div>
	
	
	
	
	

</body>

</html>