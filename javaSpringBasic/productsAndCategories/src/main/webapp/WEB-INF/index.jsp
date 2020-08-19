<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    
     <!-- 0.1) Meta Tags and Title -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
    
    
    <!-- 0.2) External Libraries for Styles-->
    
    <!-- CSS Bootstrap 4 (Uploaded by CDN with weblink)-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
	
	<!-- 0.3) External Libraries for Scripts -->
	
	<!-- JS JQuery (Uploaded by CDN with weblink)-->
    <script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <!-- JS Popper (Uploaded by CDN with weblink)-->
    <script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <!-- JS Bootstrap (Uploaded by CDN with weblink)-->
    <script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
	
	<!-- 0.4) Personal Styles and Scripts -->
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	
</head>

<body>
	
	<!-- ================================================================================================ -->
    <!-- 1) NAVBAR -->
    <!-- ================================================================================================ -->
	
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	
		<!-- Company Name and Logo -->
        <a class="navbar-brand text-decoration-none" href="#">Products and Categories</a>
        
        <!-- Toggler Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="/products/new">Add New Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/categories/new">Add New Category</a>
                </li>
            </ul> 
        </div>
        
	</nav>
	
	<!-- ================================================================================================ -->
    <!-- 2) MAIN -->
    <!-- ================================================================================================ -->
	
	<main>
	 	<h2>All Products and related Categories</h2>
		<div class="row">
			<div class="col-9">
				<table class="table table-dark table-small mt-3">
			    	<thead>
			        	<tr>
			            	<th>Product Name</th>
			            	<th>Price</th>
			            	<th>Categories</th>
			            	<th>Action</th>
			       		</tr>
			    	</thead>
			    	<tbody>
			        	<c:forEach items="${products}" var="product">
			        	<tr>
			            	<td><c:out value="${product.name}"/></td>
			            	<td>$ <c:out value="${product.price}"/></td>
			            	<td>
			            		<ul>
				            		<c:forEach items="${product.categories}" var="category">
				            			<li> <c:out value="${category.name}"/> </li>
				            		</c:forEach>
			            		</ul>
			            	</td>
			            	<td> 
			            		<a href="/products/${product.id}">Show</a> |
			            		<a href="/products/delete/${product.id}">Delete</a> 
			            	</td>
			        	</tr>
			        	</c:forEach>
			    	</tbody>
				</table>
			</div>
		</div>
		
		<h2>All Categories and related Products</h2>
		<div class="row">
			<div class="col-9">
				<table class="table table-dark table-small mt-3">
			    	<thead>
			        	<tr>
			            	<th>Category Name</th>
			            	<th>Products</th>
			            	<th>Action</th>
			       		</tr>
			    	</thead>
			    	<tbody>
			        	<c:forEach items="${categories}" var="category">
			        	<tr>
			            	<td><c:out value="${category.name}"/></td>
			            	<td>
			            	<ul>
			            		<c:forEach items="${category.products}" var="product">
			            			<li> <c:out value="${product.name}"/> </li>
			            		</c:forEach>
			            	</ul>
			            	</td>
			            	
			            	<td> 
			            		<a href="/categories/${category.id}">Show</a> |
			            		<a href="/categories/delete/${category.id}">Delete</a> 
			            	</td>
			        	</tr>
			        	</c:forEach>
			    	</tbody>
				</table>
			</div>
		</div>
	</main>
	
</body>
</html>