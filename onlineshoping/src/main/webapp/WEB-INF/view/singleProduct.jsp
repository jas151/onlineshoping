<div class="container" id="minimum-height">
	<!-- Breadcrum -->

	<div class="row">
		<div class="col-xs-12">

			<ul class="breadcrumb ">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home </a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products </a></li>
				<li class="breadcrumb-item active">${product.name}</li>

			</ul>


		</div>
	</div>



	<div class="row">

		<!--Display the product image-->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsiv"
					style="height: 203px; width: 250px;" />
			</div>
		</div>

		<!--Display the product description-->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />
			<p>${product.description}</p>

			<h4>
				Price: <strong> &#8377; ${product.unitPrice} /-</strong>
			</h4>
			<hr />

			<h6>Qty. Available: ${product.quantity}</h6>
			
			<c:choose>
			<c:when test="${product.quantity< 1}">
			    <h6>Qty.Available: <span style="color:red">Out of Stock</span></h6>
			    
			</c:when>
			
			<c:otherwise>
			    <h6>Qty. Available: ${product.quantity}</h6>
			 </c:otherwise>   
		
			</c:choose>
			
			
			<c:choose>
			<c:when test="${product.quantity< 1}">
			   <a href="javascript:void(0)"class="btn btn-success disabled"><strike>
			    <i class="fas fa-shopping-cart"></i>Add to cart</strike></a>
			    
			</c:when>
			
			<c:otherwise>
			    <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"> 
			    <i class="fas fa-shopping-cart"></i>Add to cart
			</a>
			 </c:otherwise>   
		
			</c:choose> 

			<%-- <a href="${contextRoot}/cart/add/${product.id}/product"
				class="btn btn-success"> <i class="fas fa-shopping-cart"></i>Add
				to cart
			</a> --%>
			 <a href="${contextRoot}/show/all/products" class="btn btn-primary">
				Back</a>

		</div>
	</div>

</div>





"