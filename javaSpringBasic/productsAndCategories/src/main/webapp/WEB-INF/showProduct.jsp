<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html lang="en">
<head>
     <!-- 0.1) Meta Tags and Title -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Product</title>
    
    
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
	<link rel="stylesheet" type="text/css" href="../../css/style.css">
	
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
                    <a class="nav-link active" href="/dashboard">Dashboard</a>
                </li>
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
	
	<main class="mt-3">
	
	 	<h1><c:out value="${product.name}"/></h1>
		
		<div class="row">
		
			<!-- List of Categories linked to the Product -->
			<div class="col-6">
				<h4>Categories:</h4>
				<ul class="offset-1">
		        	<c:forEach items="${product.categories}" var="category">
		            	<li><c:out value="${category.name}"/></li>
		        	</c:forEach>
			    </ul>	
			</div>
			
			<!-- Add Category Form-->
			<div class="col-3">
				<form:form action="/products/addCategory" method="POST" modelAttribute="productCategory">
			    
 			    	<!--  Hidden input for Product ID -->
				    <form:input type="hidden" path="product" value="${ product.id }"/>
				    
					<!--  Category Selection Field -->
			        <div class="form-group col-9">
			        	<form:label class="col-form-label" path="category">Add Category:</form:label>
			        	<form:select class="form-control" path="category">
				        	<c:forEach items="${categoriesNotListed}" var="nonCat">
				        		<form:option value="${nonCat.id}">${nonCat.name}</form:option>
				        	</c:forEach>
			        	</form:select>
			        	<form:errors class="small" path="category"/>
			        </div>
				    
					<!--  Submit Button -->
				    <div class="form-group mx-0">
				    	<div class="col-3 offset-5">
				    		<input class = "btn btn-success" type="submit" value="Add"/>
				    	</div>	
			    	</div>
			    </form:form>	
			</div>
			
			<!-- Remove Category Form-->
			<div class="col-3">
				<form action="/products/removeCategory" method="POST">
			    
 			    	<!--  Hidden input for Product ID -->
				    <input type="hidden" name="product" value="${ product.id }"/>
				    
					<!--  Category Selection Field -->
			        
			        <div class="form-group col-9">
			        	<label class="col-form-label" for="category">Remove Category:</label>
			        	<select class="form-control" name="category" id="category">
				        	<c:forEach items="${categoriesListed}" var="cat">
				        		<option value="${cat.id}">${cat.name}</option>
				        	</c:forEach>
			        	</select>
			     
			        </div>
				    
					<!--  Submit Button -->
				    <div class="form-group mx-0">
				    	<div class="col-3 offset-4">
				    		<input class = "btn btn-danger" type="submit" value="Remove"/>
				    	</div>	
			    	</div>
			    </form>	
			</div>
			
		</div>
		
	</main>
	
</body>
</html>