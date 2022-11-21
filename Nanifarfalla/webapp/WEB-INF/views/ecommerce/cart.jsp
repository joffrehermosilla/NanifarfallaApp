<c:set var="availableCount" value="${userModel.cart.cartLines}" />
<div class="container">


	<c:if test="${not empty message}">

		<div class="alert alert-info">
			<h3 class="text-center">${message}</h3>
		</div>

	</c:if>

	<c:choose>
		<c:when test="${not empty cartLines}">


			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartLines}" var="cartLine">
						<c:if test="${estadocart == 3}">
							<c:set var="availableCount" value="${availableCount - 1}" />
						</c:if>

						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img
											src="${images}/${cartLine.get(0).getmProducto().getNombre_producto()}.jpg"
											alt="${cartLine.get(0).getmProducto().getNombre_producto()}"
											class="img-responsive dataTableImg" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cartLine.get(0).getmProducto().getNombre_producto()}
											<c:if test="${estadocart == 3}">
												<strong style="color: red">(Not Available)</strong>
											</c:if>
										</h4>
										<p>Brand :
											${cartLine.get(0).getmProducto().getmLinea().getNombre_linea()}</p>
										<p>Description :
											${cartLine.get(0).getmProducto().getPreparacion_producto()}
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377;
								${cartLine.get(0).getValor_con_igv()} /-</td>
							<td data-th="Quantity"><input type="number"
								id="count_${cartLine.get(0).getCodigo_producto_por_pedido()}"
								class="form-control text-center"
								value="${cartLine.productCount}" min="1" max="3"></td>
							<td data-th="Subtotal" class="text-center">&#8377;
								${cartLine.total} /-</td>
							<td class="actions" data-th=""><c:if
									test="${cartLine.available == true}">
									<button type="button" name="refreshCart"
										class="btn btn-info btn-sm" value="${cartLine.id}">
										<span class="glyphicon glyphicon-refresh"></span>
									</button>
								</c:if> <a href="${contextRoot}/cart/${cartLine.id}/remove"
								class="btn btn-danger btn-sm"><span
									class="glyphicon glyphicon-trash"></span></a></td>
						</tr>







					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total &#8377;
								${userModel.cart.grandTotal}</strong></td>
					</tr>
					<tr>
						<td><a href="${contextRoot}/show/all/products"
							class="btn btn-warning"><span
								class="glyphicon glyphicon-chevron-left"></span> Continue
								Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								&#8377; ${userModel.cart.grandTotal}/-</strong></td>

						<c:choose>
							<c:when test="${availableCount != 0}">
								<td><a href="${contextRoot}/cart/validate"
									class="btn btn-success btn-block">Checkout <span
										class="glyphicon glyphicon-chevron-right"></span></a></td>
							</c:when>
							<c:otherwise>
								<td><a href="javascript:void(0)"
									class="btn btn-success btn-block disabled"><strike>Checkout
											<span class="glyphicon glyphicon-chevron-right"></span>
									</strike></a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</tfoot>
			</table>
			<!-- ========================= SECTION PAGETOP ========================= -->
			<section class="section-pagetop bg">
				<div class="container">
					<h2 class="title-page">Shopping cart</h2>
				</div>
				<!-- container //  -->
			</section>
			<!-- ========================= SECTION INTRO END// ========================= -->

			<!-- ========================= SECTION CONTENT ========================= -->
			<section class="section-content padding-y">
				<div class="container">

					<div class="row">
						<main class="col-md-9">
							<div class="card">

								<table class="table table-borderless table-shopping-cart">
									<thead class="text-muted">
										<tr class="small text-uppercase">
											<th scope="col">Product</th>
											<th scope="col" width="120">Quantity</th>
											<th scope="col" width="120">Price</th>
											<th scope="col" class="text-right" width="200"></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<figure class="itemside">
													<div class="aside">
														<img src="images/items/1.jpg" class="img-sm">
													</div>
													<figcaption class="info">
														<a href="#" class="title text-dark">Some name of item
															goes here nice</a>
														<p class="text-muted small">
															Size: XL, Color: blue, <br> Brand: Gucci
														</p>
													</figcaption>
												</figure>
											</td>
											<td><select class="form-control">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
											</select></td>
											<td>
												<div class="price-wrap">
													<var class="price">$1156.00</var>
													<small class="text-muted"> $315.20 each </small>
												</div> <!-- price-wrap .// -->
											</td>
											<td class="text-right"><a
												data-original-title="Save to Wishlist" title="" href=""
												class="btn btn-light" data-toggle="tooltip"> <i
													class="fa fa-heart"></i></a> <a href="" class="btn btn-light">
													Remove</a></td>
										</tr>
										<tr>
											<td>
												<figure class="itemside">
													<div class="aside">
														<img src="images/items/2.jpg" class="img-sm">
													</div>
													<figcaption class="info">
														<a href="#" class="title text-dark">Product name goes
															here nice</a>
														<p class="text-muted small">
															Size: XL, Color: blue, <br> Brand: Gucci
														</p>
													</figcaption>
												</figure>
											</td>
											<td><select class="form-control">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
											</select></td>
											<td>
												<div class="price-wrap">
													<var class="price">$149.97</var>
													<small class="text-muted"> $75.00 each </small>
												</div> <!-- price-wrap .// -->
											</td>
											<td class="text-right"><a
												data-original-title="Save to Wishlist" title="" href=""
												class="btn btn-light" data-toggle="tooltip"> <i
													class="fa fa-heart"></i></a> <a href=""
												class="btn btn-light btn-round"> Remove</a></td>
										</tr>
										<tr>
											<td>
												<figure class="itemside">
													<div class="aside">
														<img src="images/items/3.jpg" class="img-sm">
													</div>
													<figcaption class="info">
														<a href="#" class="title text-dark">Another name of
															some product goes just here</a>
														<p class="small text-muted">Size: XL, Color: blue,
															Brand: Tissot</p>
													</figcaption>
												</figure>
											</td>
											<td><select class="form-control">
													<option>1</option>
													<option>2</option>
													<option>3</option>
											</select></td>
											<td>
												<div class="price-wrap">
													<var class="price">$98.00</var>
													<small class="text-muted"> $578.00 each</small>
												</div> <!-- price-wrap .// -->
											</td>
											<td class="text-right"><a
												data-original-title="Save to Wishlist" title="" href=""
												class="btn btn-light" data-toggle="tooltip"> <i
													class="fa fa-heart"></i></a> <a href=""
												class="btn btn-light btn-round"> Remove</a></td>
										</tr>
									</tbody>
								</table>

								<div class="card-body border-top">
									<a href="#" class="btn btn-primary float-md-right"> Make
										Purchase <i class="fa fa-chevron-right"></i>
									</a> <a href="#" class="btn btn-light"> <i
										class="fa fa-chevron-left"></i> Continue shopping
									</a>
								</div>
							</div>
							<!-- card.// -->

							<div class="alert alert-success mt-3">
								<p class="icontext">
									<i class="icon text-success fa fa-truck"></i> Free Delivery
									within 1-2 weeks
								</p>
							</div>

						</main>
						<!-- col.// -->
						<aside class="col-md-3">
							<div class="card mb-3">
								<div class="card-body">
									<form>
										<div class="form-group">
											<label>Have coupon?</label>
											<div class="input-group">
												<input type="text" class="form-control" name=""
													placeholder="Coupon code"> <span
													class="input-group-append">
													<button class="btn btn-primary">Apply</button>
												</span>
											</div>
										</div>
									</form>
								</div>
								<!-- card-body.// -->
							</div>
							<!-- card .// -->
							<div class="card">
								<div class="card-body">
									<dl class="dlist-align">
										<dt>Total price:</dt>
										<dd class="text-right">USD 568</dd>
									</dl>
									<dl class="dlist-align">
										<dt>Discount:</dt>
										<dd class="text-right">USD 658</dd>
									</dl>
									<dl class="dlist-align">
										<dt>Total:</dt>
										<dd class="text-right  h5">
											<strong>$1,650</strong>
										</dd>
									</dl>
									<hr>
									<p class="text-center mb-3">
										<img src="images/misc/payments.png" height="26">
									</p>

								</div>
								<!-- card-body.// -->
							</div>
							<!-- card .// -->
						</aside>
						<!-- col.// -->
					</div>

				</div>
				<!-- container .//  -->
			</section>


			<!-- ========================= SECTION CONTENT ========================= -->
			<section class="section-content padding-y">
				<div class="container">

					<div class="row">
						<main class="col-md-9">
							<div class="card">

								<table class="table table-borderless table-shopping-cart">
									<thead class="text-muted">
										<tr class="small text-uppercase">
											<th scope="col">Product</th>
											<th scope="col" width="120">Quantity</th>
											<th scope="col" width="120">Price</th>
											<th scope="col" class="text-right" width="200"></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<figure class="itemside">
													<div class="aside">
														<img src="images/items/1.jpg" class="img-sm">
													</div>
													<figcaption class="info">
														<a href="#" class="title text-dark">Some name of item
															goes here nice</a>
														<p class="text-muted small">
															Size: XL, Color: blue, <br> Brand: Gucci
														</p>
													</figcaption>
												</figure>
											</td>
											<td><select class="form-control">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
											</select></td>
											<td>
												<div class="price-wrap">
													<var class="price">$1156.00</var>
													<small class="text-muted"> $315.20 each </small>
												</div> <!-- price-wrap .// -->
											</td>
											<td class="text-right"><a
												data-original-title="Save to Wishlist" title="" href=""
												class="btn btn-light" data-toggle="tooltip"> <i
													class="fa fa-heart"></i></a> <a href="" class="btn btn-light">
													Remove</a></td>
										</tr>
										<tr>
											<td>
												<figure class="itemside">
													<div class="aside">
														<img src="images/items/2.jpg" class="img-sm">
													</div>
													<figcaption class="info">
														<a href="#" class="title text-dark">Product name goes
															here nice</a>
														<p class="text-muted small">
															Size: XL, Color: blue, <br> Brand: Gucci
														</p>
													</figcaption>
												</figure>
											</td>
											<td><select class="form-control">
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
											</select></td>
											<td>
												<div class="price-wrap">
													<var class="price">$149.97</var>
													<small class="text-muted"> $75.00 each </small>
												</div> <!-- price-wrap .// -->
											</td>
											<td class="text-right"><a
												data-original-title="Save to Wishlist" title="" href=""
												class="btn btn-light" data-toggle="tooltip"> <i
													class="fa fa-heart"></i></a> <a href=""
												class="btn btn-light btn-round"> Remove</a></td>
										</tr>
										<tr>
											<td>
												<figure class="itemside">
													<div class="aside">
														<img src="images/items/3.jpg" class="img-sm">
													</div>
													<figcaption class="info">
														<a href="#" class="title text-dark">Another name of
															some product goes just here as a demo text </a>
														<p class="small text-muted">Size: XL, Color: blue,
															Brand: Tissot</p>
													</figcaption>
												</figure>
											</td>
											<td><select class="form-control">
													<option>1</option>
													<option>2</option>
													<option>3</option>
											</select></td>
											<td>
												<div class="price-wrap">
													<var class="price">$98.00</var>
													<small class="text-muted"> $578.00 each</small>
												</div> <!-- price-wrap .// -->
											</td>
											<td class="text-right"><a
												data-original-title="Save to Wishlist" title="" href=""
												class="btn btn-light" data-toggle="tooltip"> <i
													class="fa fa-heart"></i></a> <a href=""
												class="btn btn-light btn-round"> Remove</a></td>
										</tr>
									</tbody>
								</table>

								<div class="card-body border-top">
									<a href="#" class="btn btn-primary float-md-right"> Make
										Purchase <i class="fa fa-chevron-right"></i>
									</a> <a href="#" class="btn btn-light"> <i
										class="fa fa-chevron-left"></i> Continue shopping
									</a>
								</div>
							</div>
							<!-- card.// -->

							<div class="alert alert-success mt-3">
								<p class="icontext">
									<i class="icon text-success fa fa-truck"></i> Free Delivery
									within 1-2 weeks
								</p>
							</div>

						</main>
						<!-- col.// -->
						<aside class="col-md-3">
							<div class="card mb-3">
								<div class="card-body">
									<form>
										<div class="form-group">
											<label>Have coupon?</label>
											<div class="input-group">
												<input type="text" class="form-control" name=""
													placeholder="Coupon code"> <span
													class="input-group-append">
													<button class="btn btn-primary">Apply</button>
												</span>
											</div>
										</div>
									</form>
								</div>
								<!-- card-body.// -->
							</div>
							<!-- card .// -->
							<div class="card">
								<div class="card-body">
									<dl class="dlist-align">
										<dt>Total price:</dt>
										<dd class="text-right">USD 568</dd>
									</dl>
									<dl class="dlist-align">
										<dt>Discount:</dt>
										<dd class="text-right">USD 658</dd>
									</dl>
									<dl class="dlist-align">
										<dt>Total:</dt>
										<dd class="text-right  h5">
											<strong>$1,650</strong>
										</dd>
									</dl>
									<hr>
									<p class="text-center mb-3">
										<img src="images/misc/payments.png" height="26">
									</p>

								</div>
								<!-- card-body.// -->
							</div>
							<!-- card .// -->
						</aside>
						<!-- col.// -->
					</div>

				</div>
				<!-- container .//  -->
			</section>


		</c:when>

		<c:otherwise>

			<div class="jumbotron">

				<h3 class="text-center">Your Cart is Empty!</h3>

			</div>

		</c:otherwise>
	</c:choose>




</div>
