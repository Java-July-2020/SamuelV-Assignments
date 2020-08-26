<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
</head>

<body>
	
	<!-- ================================================================================================ -->
    <!-- 1) NAVBAR -->
    <!-- ================================================================================================ -->
	
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	
		<!-- Company Name and Logo -->
        <a class="navbar-brand text-decoration-none" href="#">Events Belt Reviewer</a>
        
	</nav>
	
	<!-- ================================================================================================ -->
    <!-- 2) MAIN -->
    <!-- ================================================================================================ -->
	
	<main>
		
		<div class="container my-5">
		 	<div class="row justify-content-around">
		        
		        <!-- 2.1) Register Form -->
		        <div class="col-5 border border-dark pl-5">
					
					<h2 class="my-3">Register</h2>
			         
			        <form:form action="/register" method="POST" modelAttribute="user">
			        	
						<!-- First Name Field -->
			        	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="firstName">First Name</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="text" path="firstName"/>
				        		<form:errors class="small" path="firstName"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Last Name Field -->
				    	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="lastName">Last Name</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="text" path="lastName"/>
				        		<form:errors class="small" path="lastName"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Email Field -->
			        	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="email">Email</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="email" path="email"/>
				        		<form:errors class="small" path="email"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Location Field -->
				    	<div class ="row ">
				    	
					    	<div class ="col-7">
					        	<div class="form-group row">
						        	<form:label class="col-3 col-form-label" path="city">City</form:label>
						       		 <div class="col-9">
						        		<form:input class="form-control" type="text" path="city"/>
						        		<form:errors class="small" path="city"/>
						        	</div>
						    	</div>
					    	</div>
					    	
					    	<div class ="col-4">
						    	<div class="form-group row">
						    		<form:label class="col-4 col-form-label" path="state">State</form:label>
						       		 <div class="col-8">
						        		<form:select class="form-control" type="text" path="state">
						        			<c:forEach items="${ states }" var="state">
												<option value="${ state }">${ state }</option>
											</c:forEach>
										</form:select>
						        		<form:errors class="small" path="state"/>
						        	</div>
						    	</div>
					    	</div>
			
				    	</div>
				    	
				    	<!-- Password Field -->
				    	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="password">Password</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="password" path="password"/>
				        		<form:errors class="small" path="password"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Password Confirmation Field -->
				    	<div class="form-group row">
				        	<form:label class="col-3 col-form-label" path="passwordConfirmation">Password Confirm</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="password" path="passwordConfirmation"/>
				        		<form:errors class="small" path="passwordConfirmation"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Submit Button -->
				    	<div class="form-group row">
			    			<div class="col-3 offset-3">
			    				<input class = "btn btn-success" type="submit" value="Register"/>
			    			</div>	
			    		</div>
				    	
			    	</form:form>
		        
		        </div>
		
		        <!-- 2.2) Log-in Form -->
		        <div class="col-5 border border-dark pl-5">
		            
		            <h2 class="my-3">Login</h2>
			        
					<p id="errors" class="mb-3"><c:out value="${error}" /></p>
					
			        <form action="/login" method="POST">
			        	
						<!-- Email Field -->
			        	<div class="form-group row">
				        	<label class="col-3 col-form-label" for="email">Email</label>
				       		 <div class="col-8">
				        		<input class="form-control" type="email" id="email" name="email"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Password Field -->
				    	<div class="form-group row">
				        	<label class="col-3 col-form-label" for="password">Password</label>
				       		 <div class="col-8">
				        		<input class="form-control" type="password" id="password" name="password"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Submit Button -->
				    	<div class="form-group row">
			    			<div class="col-3 offset-3">
			    				<input class = "btn btn-success" type="submit" value="Log In"/>
			    			</div>	
			    		</div>
			    		
			    	</form>
			    	
		        </div>
		    </div>
		
		</div> <!-- End container class -->
	</main>
	
</body>
</html>