<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
	window.userRole = '${userModel.role}';
</script>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/anuncios/save" var="urlForm"></spring:url>
<nav class="navbar navbar-inverse " role="navigation">

	<div class="container">

		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home"> <span><img
					src="${urlPublic}/images/nanifarfalla.jpeg" width="80" height="80"
					class="d-inline-block align-top" alt=""></img></span>Nanifarfalla Online
				Shopping
			</a>

		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="about"><a href="${contextRoot}/about">About</a></li>

				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>

				<li id="listProducts"><a
					href="${contextRoot}/show/all/products">View Products</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li id="login"><a href="${contextRoot}/formLogin">Login </a></li>
					<li id="listProducts"><a href="${contextRoot}/register">Sign
							Up </a></li>
				</security:authorize>
				<li class="dropdown" id="userModel"><a
					class="btn btn-default dropdown-toggle" href="javascript:void(0)"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> ${userModel.fullName} <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<security:authorize access="hasAuthority('ROLE_ADMIN')">
							<li id="cart"><form:form action="${urlForm}" method="post"
									id="form" class="form" enctype="multipart/form-data"
									modelAttribute="InstanciaClienteTienePedido">
									<a href="${contextRoot}/cart/show" class="myForm22"
										id="crearPedido"> <span
										class="glyphicon glyphicon-shopping-cart"></span> &#160;<span
										class="badge">${userModel.cart.cartLines}</span> -
										${userModel.cart.grandTotal} &#36;
									</a>
									<div class="form-buttons">
										<div class="button">
											<button href="${urlRoot}" type="submit" value="submit"
												id="guardar" class="btn btn-danger"
												title="Crear Carrito de Compras"
												onclick='return confirm("¿ DESEA COMPRAR ?").submit()'>create
												New Cart</button>
										</div>
									</div>
								</form:form></li>
							<li role="separator" class="divider"></li>
						</security:authorize>
						<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
					</ul></li>
			</ul>


		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

<script type="text/javascript">
	function submitform() {
		document.forms["myform"].submit();
	}
	

</script>


<script type="text/javascript">
var serverContext = '${contextRoot}';

		function register() {
		

			var formData = $('form').serialize();
			$.post(serverContext + "/clientetienepedido/save", formData, function(data) {
				document.forms["form"].submit();
			});

			</script>

<script src="${urlPublic}/js/crearpedidoporusuario.js"></script>

