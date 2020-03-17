
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">


<spring:url value="/resources" var="urlPublic" />

<section class="container pb-4 mb-md-3" >
	<div class="row">
		<div class="col-md-8 mb-4">

			<div class="containerdiv"> 	
				<div class="card">
					<div class="card-head">
						<img src="https://s5.postimg.cc/wy79025cz/nike_Logo_White.png"
							alt="logo" class="card-logo"> <img
							src="https://s5.postimg.cc/j9r8yf9gn/sws1.png" alt="Shoe"
							class="product-img">
						<div class="product-detail">
							<h2>Hartbeespoort</h2>
							Support and Nike Zoom Air come together for a more supportive
							feel with high-speed responsiveness
						</div>
						<span class="back-text"> NANIFARFALLA </span>
					</div>
					<div class="card-body">
						<div class="product-desc">
							<span class="product-title"> Hartbee<b>spoort</b> <span
								class="badge"> New </span>
							</span> <span class="product-caption"> Basket Ball Collection </span> <span
								class="product-rating"> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star grey"></i>
							</span>
						</div>
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
							</span> <span class="product-price"> USD<b>23,453</b>
							</span>
						</div>
					</div>
				</div>
			</div>





			<div class="yt">
				<a href="https://www.youtube.com/watch?v=jYAmKNOJ4Ck"
					target="_blank"> <img width="151"
					src="https://s5.postimg.cc/vzwuxmw87/template.png" alt="" />
				</a>
			</div>
		</div>
		<div class="col-md-4 mb-4">
			<div
				class="d-flex flex-column h-100 justify-content-center bg-size-cover bg-position-center rounded-lg"
				style="background-image: url(img/blog/banner-bg.jpg);">
				<div class="py-4 my-2 px-4 text-center">
					<div class="py-1">
						<h5 class="mb-2">Your Add Banner Here</h5>
						<p class="font-size-sm text-muted">  </p>
						<a class="btn btn-primary btn-shadow btn-sm" href="#">Contact
							us</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>