
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />


<section class="container pt-md-3 pb-5 mb-md-3"
	style="align-self: center;">
	<h2 class="h3 text-center">Trending products</h2>
	
		<!-- Product-->
		<div class="col-lg-3 col-md-4 col-sm-6 px-2 mb-4">
			<div class="card product-card">



				<button class="customer-rating fa "  data-rating="4" type="button"
					data-toggle="tooltip" data-placement="left" title=""
					data-original-title="Add to wishlist">
					<i class="fa fa-heart" ></i><b>500</b>
				</button>
				<span class="badge"> New</span><span
					class="badge badge-danger badge-shadow">Sale</span> <a
					class="card-img-top d-block overflow-hidden"
					href="shop-single-v1.html"><img
					src="${urlPublic}/images/image35.jpg" alt="Product"></a> <span
					class="product-title"> Hartbee<b>spoort</b>
					<h3 class="product-title font-size-sm">
						<a href="shop-single-v1.html">Women Colorblock Sneakers</a>
					</h3>
					<div class="d-flex justify-content-between">
						<div class="product-price">
							<span class="text-accent">$154.<small>00</small> <del
									class="font-size-sm text-muted">
									$38.<small>50</small>
								</del>

							</span>
							
							<span class="text-muted font-size-sm">Out of stock</span>
						
						</div>

					</div>

				</span>
				<div class="card-body">
					<div class="product-desc">
						<div class="product-properties">
							<span class="product-size">
								<h4>Size</h4>
								<ul class="ul-size">
									<li><a href="#">7</a></li>
									<li><a href="#">8</a></li>
									<li><a href="#">9</a></li>
									<li><a href="#" class="active">10</a></li>
									<li><a href="#">11</a></li>
								</ul>
							</span> <span class="product-color">
								<h4>Colour</h4>
								<ul class="ul-color">
									<li><a href="#" class="orange active"></a></li>
									<li><a href="#" class="green"></a></li>
									<li><a href="#" class="yellow"></a></li>
								</ul>
							</span>
							<div class="d-flex mb-2">
								<select class="custom-select custom-select-sm mr-2">
									<option>XS</option>
									<option>S</option>
									<option>M</option>
									<option>L</option>
									<option>XL</option>
								</select>
							</div>
						</div>
						<div class="card-body card-body-hidden">

							<button class="btn btn-primary btn-sm btn-block mb-2"
								type="button" data-toggle="toast" data-target="#cart-toast">
								<i class="czi-cart font-size-sm mr-1"></i>Add to Cart
							</button>
							<div class="text-center">
								<a class="nav-link-style font-size-ms" href="#quick-view"
									data-toggle="modal"><i class="czi-eye align-middle mr-1"></i>Quick
									view</a>
							</div>
						</div>
					</div>
					<hr class="d-sm-none">
				</div>
			</div>
		</div>




</section>