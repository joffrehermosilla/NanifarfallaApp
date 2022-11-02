<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script>
	window.userRole = '${userModel.role}';
</script>
<spring:url value="/resources" var="urlPublic" />
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
				<li id="login"><a href="${contextRoot}/login">Login
				</a></li>
				<li id="listProducts"><a href="${contextRoot}/register">Sign
						Up </a></li>
				<li class="dropdown" id="userModel"><a
					class="btn btn-default dropdown-toggle" href="javascript:void(0)"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"> ${userModel.fullName} <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<security:authorize access="hasAuthority('ROLE_BUYER')">
							<li id="cart"><a href="${contextRoot}/cart/show"> <span
									class="glyphicon glyphicon-shopping-cart"></span>&#160;<span
									class="badge">${userModel.cart.cartLines}</span> - &#8377;
									${userModel.cart.grandTotal}
							</a></li>
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


