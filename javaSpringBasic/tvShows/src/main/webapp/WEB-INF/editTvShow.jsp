<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    
     <!-- 0.1) Meta Tags and Title -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Show</title>
    
    
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
        <a class="navbar-brand text-decoration-none" href="#">TV Shows</a>
        
        <!-- Toggler Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
            	<li class="nav-item">
                    <a class="nav-link active" href="/shows">Dashboard</a>
                </li>
             	<li class="nav-item">
                    <a class="nav-link active" href="/logout">Logout</a>
                </li>

            </ul> 
        </div>
        
	</nav>
	
	<!-- ================================================================================================ -->
    <!-- 2) MAIN -->
    <!-- ================================================================================================ -->
	
	<main>
		<h3><c:out value="${show.name}"/></h3>
			
		<hr>
		
		<div class="ml-3" >
	
			<h5 class="mb-4"> Edit show</h5>

			<!-- Add Event Form -->
			<div class="row">
				<div class="col-6">
					<form:form action="/shows/${show.id}/edit" method="POST" modelAttribute="show">
						<input type="hidden" name="_method" value="put"/>
												
						<!-- Passing user_id for relating the event created with the user -->
						<form:hidden value="${ user.id }" path="creator"/>
						        	
						<!-- Name Field -->
			        	<div class="form-group row">
				        	<form:label class="col-2 col-form-label" path="name">Name</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="text" path="name"/>
				        		<form:errors class="small" path="name"/>
				        	</div>
				    	</div>
				    	
				    	<!-- Network Field -->
				    	<div class="form-group row">
				        	<form:label class="col-2 col-form-label" path="network">Network</form:label>
				       		 <div class="col-8">
				        		<form:input class="form-control" type="text" path="network"/>
				        		<form:errors class="small" path="network"/>
				        	</div>
				    	</div>
				    		    	
				    	<!-- Submit Button -->
				    	<div class="form-group row">
			    			<div class="col-1 offset-2">
			    				<input class = "btn btn-success" type="submit" value="Edit"/>
			    			</div>
			    			<div class="col-1 ml-2">
    							<a class= "btn btn-danger text-decoration-none" href="/shows/${show.id}/delete">Delete</a>
    						</div>
			    		</div>
			    		
			    		<p id="errors" class="mb-3"><c:out value="${error}" /></p>
				    	
				    </form:form>
		    	
		    	</div>
		    </div>
		</div>
		
		<hr>
		
	</main>

	
</body>
</html>