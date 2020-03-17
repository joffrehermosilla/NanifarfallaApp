
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<spring:url value="/resources" var="urlPublic" />


<section class="container pb-4 mb-md-3" style="align-self: left;">
	<section class="container mb-4 pb-3 pb-sm-0 mb-sm-5">
		<div class="row">
			<!-- Banner with controls-->
			<div class="col-md-5">
				<div class="d-flex flex-column h-100 overflow-hidden rounded-lg"
					style="background-color: #e2e9ef;">
					<div
						class="d-flex justify-content-between px-grid-gutter py-grid-gutter"
						style="align-self: center;">
						<div>
							<h3 class="mb-1">Hoodie day</h3>
							<a class="font-size-md" href="shop-grid-ls.html">Shop hoodies<i
								class="czi-arrow-right font-size-xs align-middle ml-1"></i>
							</a>
						</div>


						<div class="owl-controls">
							<div class="owl-nav">
								<div class="owl-prev" style="display: none;">prev</div>
								<div class="owl-next" style="display: none;">next</div>
							</div>
							<div class="owl-dots" style="display: none;"></div>
						</div>
						<div class="atw_slider_controls">
							<span class="fa-heart"></span> <span class="fa-heart"></span>
						</div>
					</div>
					<a class="d-none d-md-block mt-auto" href="shop-grid-ls.html"><img
						class="d-block w-100" src="${urlPublic}/images/nanifarfalla.jpeg"
						alt="For Women"></a>
				</div>
			</div>
			<!-- Product grid (carousel)-->
			<div class="col-md-7 pt 12 pt-md-0" style="align-self: center;">


				<!-- Generar carrusel-->
				<div class="cz-carousel">
					<div class="tns-outer" id="tns3-ow">
						<div class="tns-liveregion tns-visually-hidden" aria-live="polite"
							aria-atomic="true">
							slide <span class="current">3</span> of 2
						</div>
						<div class="atw_wrapper">
							<div class="atw_container">
								<div class="atw_row">
									<div class="col-md-24">
										<div id="atw_style9">
											<div class="atw_slider_wrapper">
												<div
													class="atw_slider atw--slider1827011033 owl-carousel owl-theme owl-loaded">

													<!-- Ends: .atw_single_slide -->

													<div class="owl-stage-outer">
														<div class="owl-stage"
															style="transform: translate3d(-3120px, 0px, 0px); transition: all 4s ease 0s; width: 4320px;">
															<div class="owl-item cloned"
																style="width: 120px; margin-right: 30px;">
																<div class="tns-item" aria-hidden="true" tabindex="-1">
																	<div class="atw_single_slide">
																		<div class="atw_item atw--single_item atw_card">
																			<div class="atw_item_top">
																				<img
																					src="https://aazztech.com/demos/plugins/wp-content/uploads/2015/10/hoodie_3_front2-300x300.jpg"
																					class="wpcsp-thumb" alt="Happy Ninja">
																				<div class="atw_item_view">
																					<a href="" data-featherlight="#f53">Quick View</a>
																				</div>
																				<div class="atw_floated_badge badge--left">
																					<a href="" class="float-d-ratio">Sale</a>
																				</div>
																			</div>
																			<div class="atw_item_bottom">
																				<div class="atw_item_header">
																					<h4 class="atw_item_title">
																						<a
																							href="https://aazztech.com/demos/plugins/product/happy-ninja-2/">Happy
																							Ninja</a>
																					</h4>
																				</div>
																				<div class="atw_item_info">
																					<span class="atw_price"> <span
																						class="woocommerce-Price-amount amount"><span
																							class="woocommerce-Price-currencySymbol">$</span>35.00</span></span>
																				</div>
																				<ul class="atw_product_actions2">

																					<li>
																						<p class="product woocommerce add_to_cart_inline "
																							style="border: 4px solid #ccc; padding: 12px;">
																							<span class="woocommerce-Price-amount amount"><span
																								class="woocommerce-Price-currencySymbol">$</span>35.00</span><a
																								href="/demos/plugins/woocommerce-product-carousel-slider-and-grid-ultimate-demo-slider/?add-to-cart=53"
																								data-quantity="1"
																								class="button product_type_simple add_to_cart_button ajax_add_to_cart"
																								data-product_id="53" data-product_sku=""
																								aria-label="Add “Happy Ninja” to your cart"
																								rel="nofollow">Add to cart</a>
																						</p>
																					</li>
																				</ul>
																			</div>
																		</div>
																		<!-- end .atw--single_item -->
																	</div>
																</div>
															</div>

															<div class="owl-item cloned"
																style="width: 420px; margin-right: 30px;">
																<div class="atw_single_slide">
																	<div class="atw_item atw--single_item atw_card">
																		<div class="atw_item_top">
																			<img
																				src="https://aazztech.com/demos/plugins/wp-content/uploads/2015/10/T_3_front2-300x300.jpg"
																				class="wpcsp-thumb" alt="Ship Your Idea">
																			<div class="atw_item_view">
																				<a href="" data-featherlight="#f104">Quick View</a>
																			</div>
																			<section style="display: none">
																				<div class="lightbox" style="display: flex;"
																					id="f104">
																					<div class="atw_image_l"
																						style="margin-right: 30px;">
																						<img
																							src="https://aazztech.com/demos/plugins/wp-content/uploads/2015/10/T_3_front2-300x300.jpg"
																							class="wpcsp-thumb" alt="Ship Your Idea">
																					</div>
																					<div class="atw_product_desc">
																						<h1 style="font-size: 40px; margin-bottom: 30px">Ship
																							Your Idea</h1>
																						<span class="atw_product_price"
																							style="display: block; margin-bottom: 30px; color: red; font-size: 20px;"><span
																							class="woocommerce-Price-amount amount"><span
																								class="woocommerce-Price-currencySymbol">$</span>20.00</span></span>
																						<p>Pellentesque habitant morbi tristique
																							senectus et netus et malesuada fames ac turpis
																							egestas. Vestibulum tortor quam, feugiat vitae,
																							ultricies eget, tempor sit amet, ante. Donec eu
																							libero sit amet quam egestas semper. Aenean
																							ultricies mi vitae est. Mauris placerat eleifend
																							leo.</p>
																						<p class="product woocommerce add_to_cart_inline "
																							style="border: 4px solid #ccc; padding: 12px;">
																							<a
																								href="/demos/plugins/woocommerce-product-carousel-slider-and-grid-ultimate-demo-slider/?add-to-cart=104"
																								data-quantity="1"
																								class="button product_type_simple add_to_cart_button ajax_add_to_cart"
																								data-product_id="104" data-product_sku=""
																								aria-label="Add “Ship Your Idea” to your cart"
																								rel="nofollow">Add to cart</a>
																						</p>
																					</div>
																				</div>
																			</section>
																			<div class="atw_floated_badge badge--left">
																				<a href="" class="float-d-ratio">Sale</a>
																			</div>
																		</div>
																		<div class="atw_item_bottom">
																			<div class="atw_item_header">
																				<h4 class="atw_item_title">
																					<a
																						href="https://aazztech.com/demos/plugins/product/ship-your-idea/">Ship
																						Your Idea</a>
																				</h4>
																			</div>
																			<div class="atw_item_info">
																				<span class="atw_price"> <span
																					class="woocommerce-Price-amount amount"><span
																						class="woocommerce-Price-currencySymbol">$</span>20.00</span></span>
																				<div class="atw_rating woocommerce"></div>
																			</div>
																			<ul class="atw_product_actions2">

																				<li>
																					<p class="product woocommerce add_to_cart_inline "
																						style="border: 4px solid #ccc; padding: 12px;">
																						<span class="woocommerce-Price-amount amount"><span
																							class="woocommerce-Price-currencySymbol">$</span>20.00</span><a
																							href="/demos/plugins/woocommerce-product-carousel-slider-and-grid-ultimate-demo-slider/?add-to-cart=104"
																							data-quantity="1"
																							class="button product_type_simple add_to_cart_button ajax_add_to_cart"
																							data-product_id="104" data-product_sku=""
																							aria-label="Add “Ship Your Idea” to your cart"
																							rel="nofollow">Add to cart</a>
																					</p>
																				</li>

																			</ul>
																		</div>
																	</div>
																	<!-- end .atw--single_item -->
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</section>

<!-- Featured category (Hoodie)-->
<section class="container mb-4 pb-3 pb-sm-0 mb-sm-5">
	<div class="row">
		<!-- Banner with controls-->
		<div class="col-md-5">
			<div class="d-flex flex-column h-100 overflow-hidden rounded-lg "
				style="background-color: #e2e9ef;">
				<div
					class="d-flex justify-content-between px-grid-gutter py-grid-gutter">
					<div>
						<h3 class="mb-1">Hoodie day</h3>
						<a class="font-size-md" href="shop-grid-ls.html">Shop hoodies<i
							class="czi-arrow-right font-size-xs align-middle ml-1"></i></a>
					</div>
					<div class="" id="hoodie-day" aria-label="Carousel Navigation"
						tabindex="0">
						<button type="button" aria-controls="tns3" tabindex="-1"
							data-controls="prev">
							<i class="fa-heart"></i>
						</button>
						<button type="button" aria-controls="tns3" tabindex="-1"
							data-controls="next">
							<i class="fa-heart"></i>
						</button>
					</div>
				</div>
				<a class="d-none d-md-block mt-auto" href="shop-grid-ls.html"><img
					class="d-block w-100" src="img/home/categories/cat-lg04.jpg"
					alt="For Women"></a>
			</div>
		</div>
		<!-- Product grid (carousel)-->
		<div class="col-md-7 pt-4 pt-md-0">
			<div class="cz-carousel">
				<div class="tns-outer" id="tns3-ow">
					<div class="tns-liveregion tns-visually-hidden" aria-live="polite"
						aria-atomic="true">
						slide <span class="current">3</span> of 2
					</div>
					<div id="tns3-mw" class="tns-ovh">
						<div class="tns-inner" id="tns3-iw">
							<div
								class="cz-carousel-inner  tns-slider tns-carousel tns-subpixel tns-calc tns-horizontal"
								data-carousel-options="{&quot;nav&quot;: false, &quot;controlsContainer&quot;: &quot;#hoodie-day&quot;}"
								id="tns3"
								style="transition-duration: 0s; transform: translate3d(-33.3333%, 0px, 0px);">
								<div class="tns-item" aria-hidden="true" tabindex="-1">
									<div class="row mx-n2">
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/20.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/21.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$26.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<span class="badge badge-danger badge-shadow">Sale</span>
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/23.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$17.<small>99</small></span>
															<del class="font-size-sm text-muted">
																24.<small>99</small>
															</del>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i><i class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/51.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/24.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/54.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tns-item" aria-hidden="true" tabindex="-1">
									<div class="row mx-n2">
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/53.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/52.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Printed Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$25.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/22.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/56.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Printed Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$25.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/55.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/57.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$23.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i><i class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- Carousel item-->
								<div class="tns-item tns-slide-active" id="tns3-item0">
									<div class="row mx-n2">
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/20.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/21.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$26.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<span class="badge badge-danger badge-shadow">Sale</span>
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/23.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$17.<small>99</small></span>
															<del class="font-size-sm text-muted">
																24.<small>99</small>
															</del>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i><i class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/51.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/24.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/54.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- Carousel item-->
								<div class="tns-item" id="tns3-item1" aria-hidden="true"
									tabindex="-1">
									<div class="row mx-n2">
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/53.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/52.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Printed Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$25.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/22.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/56.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Printed Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$25.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/55.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/57.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$23.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i><i class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tns-item" aria-hidden="true" tabindex="-1">
									<div class="row mx-n2">
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/20.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/21.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$26.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<span class="badge badge-danger badge-shadow">Sale</span>
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/23.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$17.<small>99</small></span>
															<del class="font-size-sm text-muted">
																24.<small>99</small>
															</del>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i><i class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/51.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/24.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/54.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tns-item" aria-hidden="true" tabindex="-1">
									<div class="row mx-n2">
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/53.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Mono Color Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$21.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div
											class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4 d-none d-lg-block">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/52.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Printed Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$25.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/22.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/56.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Printed Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$25.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/55.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$24.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-6 px-0 px-sm-2 mb-sm-4">
											<div class="card product-card card-static">
												<button class="btn-wishlist btn-sm" type="button"
													data-toggle="tooltip" data-placement="left" title=""
													data-original-title="Add to wishlist">
													<i class="czi-heart"></i>
												</button>
												<a class="card-img-top d-block overflow-hidden"
													href="shop-single-v1.html"><img
													src="img/shop/catalog/57.jpg" alt="Product"></a>
												<div class="card-body py-2">
													<a class="product-meta d-block font-size-xs pb-1" href="#">Hoodies
														&amp; Sweatshirts</a>
													<h3 class="product-title font-size-sm">
														<a href="shop-single-v1.html">Block-colored Hooded Top</a>
													</h3>
													<div class="d-flex justify-content-between">
														<div class="product-price">
															<span class="text-accent">$23.<small>99</small></span>
														</div>
														<div class="star-rating">
															<i class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star-filled active"></i><i
																class="sr-star czi-star"></i><i class="sr-star czi-star"></i>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<div class="wsite-multicol">
	<div class="wsite-multicol-table-wrap" style="margin: 0 -15px;">
		<table class="wsite-multicol-table">
			<tbody class="wsite-multicol-tbody">
				<tr class="wsite-multicol-tr">
					<td class="wsite-multicol-col" style="width: 25%; padding: 0 15px;">



						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla plegable estándar</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/co-300-silla-marroqui_1_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-estandar.html" target="_blank"> <span
								class="wsite-button-inner">ver más info</span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<div>
							<div style="height: 20px; overflow: hidden; width: 100%;"></div>
							<hr class="styled-hr" style="width: 100%;">
							<div style="height: 20px; overflow: hidden; width: 100%;"></div>
						</div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla traumatológica</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/co-304-silla-traumatologica_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-traumatoloacutegica.html" target="_blank">
								<span class="wsite-button-inner"><span
									style="color: rgb(255, 255, 255)">VER MÁS INFO</span></span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla eléctrica con llantas grandes</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0px; margin-right: 0px; text-align: center">
								<a
									href="/silla-de-ruedas-electrica-con-llantas-grandes-neumaticas.html"
									target="_blank"> <img
									src="/uploads/4/5/3/7/4537905/editor/silla-de-ruedas-electrica-plegable.jpg?1523495329"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-electrica-con-llantas-grandes-neumaticas.html"
								target="_blank"> <span class="wsite-button-inner">ver
									más info</span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<div class="wsite-spacer" style="height: 50px;"></div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<strong><font size="2">Silla eléctrica
									neurológica</font></strong>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/sin-t-tulo-2_14_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-electrica-neurologica.html"
								target="_blank"> <span class="wsite-button-inner">VER
									MÁS INFO</span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>



					</td>
					<td class="wsite-multicol-col" style="width: 25%; padding: 0 15px;">



						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla estándar de lona</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/co-301-silla-estandar-de-lona_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-estandar-de-lona.html" target="_blank">
								<span class="wsite-button-inner"><span
									style="color: rgb(255, 255, 255)">VER MÁS INFO</span></span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<div>
							<div style="height: 20px; overflow: hidden; width: 100%;"></div>
							<hr class="styled-hr" style="width: 100%;">
							<div style="height: 20px; overflow: hidden; width: 100%;"></div>
						</div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla neurológica </font><font size="2">de
								niños</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/neurologia-para-ni-os_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-pediaacutetrica-neuroloacutegica-de-aluminio.html"
								target="_blank"> <span class="wsite-button-inner"><span
									style="color: rgb(255, 255, 255)">VER MÁS INFO</span></span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla eléctrica con llantas pequeñas&nbsp;</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0px; margin-right: 0px; text-align: center">
								<a href="/silla-de-ruedas-electrica-con-llantas-pequenas.html"
									target="_blank"> <img
									src="/uploads/4/5/3/7/4537905/editor/silla.jpg?1524507268"
									alt="Imagen" style="width: 225; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-electrica-con-llantas-pequenas.html"
								target="_blank"> <span class="wsite-button-inner">ver
									más info</span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>



					</td>
					<td class="wsite-multicol-col" style="width: 25%; padding: 0 15px;">



						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla de aluminio para paseo</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/co-302-silla-de-aluminio-para-paseo_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-estandar-de-aluminio-para-paseo.html"
								target="_blank"> <span class="wsite-button-inner"><span
									style="color: rgb(255, 255, 255)">VER MÁS INFO</span></span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<div>
							<div style="height: 20px; overflow: hidden; width: 100%;"></div>
							<hr class="styled-hr" style="width: 100%;">
							<div style="height: 20px; overflow: hidden; width: 100%;"></div>
						</div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla 5 en 1</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/sila-cinco-en-una_1_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-5-en-1.html" target="_blank"> <span
								class="wsite-button-inner"><span
									style="color: rgb(255, 255, 255)">VER MÁS INFO</span></span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Scooter eléctrico de paseo</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0px; margin-right: 0px; text-align: center">
								<a> <img src="/uploads/4/5/3/7/4537905/scooter-3_1_orig.jpg"
									alt="Imagen" style="width: 224; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/scooter-electrico-coche-de-paseo.html" target="_blank">
								<span class="wsite-button-inner">ver más info</span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>



					</td>
					<td class="wsite-multicol-col" style="width: 25%; padding: 0 15px;">



						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla </font><font size="2">con r</font><font
								size="2">uedas neumáticas</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/co-303-silla-estandar-con-llantas-neumaticas_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-estaacutendar-con-llantas-neumaacuteticas-modelo-care.html"
								target="_blank"> <span class="wsite-button-inner"><span
									style="color: rgb(255, 255, 255)">VER MÁS INFO</span></span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<div>
							<div style="height: 20px; overflow: hidden; width: 100%;"></div>
							<hr class="styled-hr" style="width: 100%;">
							<div style="height: 20px; overflow: hidden; width: 100%;"></div>
						</div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<font size="2">Silla con sanitario</font>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/co-307-silla-sena-con-sanitario_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-con-sanitario.html" target="_blank">
								<span class="wsite-button-inner"><span
									style="color: rgb(255, 255, 255)">VER MÁS INFO</span></span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>

						<h2 class="wsite-content-title" style="text-align: center;">
							<strong><font size="2">Silla eléctrica bipidestal</font></strong><br>
						</h2>

						<div>
							<div class="wsite-image wsite-image-border-none "
								style="padding-top: 10px; padding-bottom: 10px; margin-left: 0; margin-right: 0; text-align: center">
								<a> <img
									src="/uploads/4/5/3/7/4537905/sin-t-tulo-1_15_orig.jpg"
									alt="Imagen" style="width: auto; max-width: 100%">
								</a>
								<div style="display: block; font-size: 90%"></div>
							</div>
						</div>

						<div style="text-align: center;">
							<div style="height: 10px; overflow: hidden;"></div>
							<a class="wsite-button wsite-button-small wsite-button-highlight"
								href="/silla-de-ruedas-electrica-bipidestal.html"
								target="_blank"> <span class="wsite-button-inner">VER
									MÁS INFO</span>
							</a>
							<div style="height: 10px; overflow: hidden;"></div>
						</div>



					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>