

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
<div class="container">

	<div class="row">


		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="../shared/sidebar.jsp"%>
			<div class="list-group">


	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.codigo_linea}/products" class="list-group-item" id="a_${category.nombre_linea}">${category.nombre_linea}</a>
	</c:forEach>

	 
</div>

		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">


							<li><a href="${contextRoot}">Home/</a></li>
							<li class="active">All Products/</li>


						</ol>
					</c:if>


					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.codigo_linea}';
						</script>

						<ol class="breadcrumb">


							<li><a href="${contextRoot}">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.nombre_linea}</li>


						</ol>
					</c:if>


				</div>


			</div>


			<div class="row">

				<div class="col-xs-12">


					<table id="productListTable"
						class="table table-striped table-borderd">


						<thead>

							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>

						</thead>


						<tfoot>

							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>

						</tfoot>
					</table>

				</div>

			</div>


		</div>



	</div>






</div>


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
		
		