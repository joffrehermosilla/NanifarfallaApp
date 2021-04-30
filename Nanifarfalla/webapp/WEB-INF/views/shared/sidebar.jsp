
<p class="lead">Shop Products</p>




<div class="list-group">


	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.codigo_linea}/products" class="list-group-item" id="a_${category.nombre_linea}">${category.nombre_linea}</a>
	</c:forEach>

	 
</div>