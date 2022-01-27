

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<spring:url value="/resources" var="urlPublic" />
<spring:url var="css" value="/resources/ecommerce/assets/css" />
<spring:url var="js" value="/resources/ecommerce/assets/js" />
<spring:url var="images" value="/resources/ecommerce/assets/images" />

<spring:url value="/estadousuario/indexPaginate?page=0"
	var="urlEstadoUsuario"></spring:url>

<spring:url value="/elaboracionproducto/indexPaginate?page=0"
	var="urlElaboracionProducto"></spring:url>
<spring:url value="/pais/indexPaginate?page=0"
	var="urlPais"></spring:url>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Online Shopping Nanifarfalla Website RESTFUL Using Spring MVC and JPA Hibernate">
<meta name="author" content="Joffre Hermosilla Salas">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Plain Page- ${title}</title>

<script>
	window.menux = '${title}';

	window.contextRoot = '${contextRoot}'
</script>
<script>

			var vista = document.getElementById('plainpage');
			document.getElementById('estadousuario').addEventListener('click', function(e) {
			e.preventDefault();
			vista.innerHTML = `
																		         
		     <iframe src="${urlEstadoUsuario}" height="630" style="width: 100%" frameBorder="0"></iframe>
																		          
		    `;
						
			});
									
			document.getElementById('elaboracionproducto').addEventListener('click', function(e) {
			e.preventDefault();

			vista.innerHTML = `
																		      
	        <iframe src="${urlElaboracionProducto}" height="620" style="width: 100%" frameBorder="0" ></iframe>
	        `;
			});

			
			document.getElementById('pais').addEventListener('click', function(e) {
				e.preventDefault();

				vista.innerHTML = `
																			      
		        <iframe src="${urlPais}" height="620" style="width: 100%" frameBorder="0" ></iframe>
		        `;
				});

</script>




</head>

<body>





	<div class="se-pre-con"></div>
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="../shared/navbar.jsp"%>

		<!-- Page Content -->




		<div class="content">

			<!-- Load only when user clicks about -->
			<c:if test="${userClickEstadoUsuario == true }">
				<%@include file="../estadousuario/listEstadoUsuario.jsp"%>
			</c:if>
			<c:if test="${userClickElaboracionProducto == true }">
				<%@include file="../elaboracionproducto/listElaboracionProducto.jsp"%>
			</c:if>
			<c:if test="${userClickDemoA==true}">
				<title>${contextRoot}-${title}|<fmt:message
						key="welcome.lang" />

				</title>
			</c:if>
		</div>


		<!-- Footer comes here -->


		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- DataTable Bootstrap Script -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>