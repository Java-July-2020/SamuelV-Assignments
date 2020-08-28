<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    
     <!-- 0.1) Meta Tags and Title -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show TV Show</title>
    
    
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
	
			<h5 class="mb-2"> Details:</h5>
			<p>Network: <c:out value="${show.network}"/></p>
			<p>Added by: <c:out value="${show.creator.firstName} ${show.creator.lastName}"/></p>           		
			<p>
				Average Rating: 
				<fmt:setLocale value = "en_US" scope="session"/>
				<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${show.getAverageRating()}"/>
			</p>
			
			<h5 class="mt-4 mb-2"> Users who rated this show:</h5>
			<div class="row">
				<div class="col-9">
					<table class="table table-dark mt-1">
				    	<thead>
				        	<tr>
				            	<th>Name</th>
				            	<th>Rating</th>
				       		</tr>
				    	</thead>
				    	<tbody>
				        	<c:forEach items="${ratingsofShowInDescOrder}" var="rating">
				        	<tr>
								<!-- Name Field -->
				            	<td><c:out value="${rating.rater.firstName} ${rating.rater.lastName}"/></td>
				            	
				            	<!-- Rating Field -->
				            	<td><c:out value="${rating.score}"/></td>
				          	</tr>
				        	</c:forEach>
				    	</tbody>
					</table>
				</div>
			</div>

			<!-- Edit TV Show Button -->
	    	<div>
	    		<c:if test="${ show.creator.id == user.id }">
    				<a class= "btn btn-success text-decoration-none" href="/shows/${show.id}/edit">Edit Show</a>
    			</c:if>
    		</div>
    		
    		<!-- Leave a Rating -->
    		<div>
    			
    			<h5 class="mt-4 mb-2"> Leave a Rating:</h5>
    			<c:choose>
    				<c:when test="${ show.usersAlreadyRate.contains(user) }">
    					<p> You already gave a rate for this TV Show!!! Please give as feedback for another one! </p>
    				</c:when>
    				
    				<c:otherwise>
		    			<form action="/shows/${show.id}/rate" method="POST">
							<div class="form-row">
				   	        	<div class="col-1">
					        		<input class="form-control" type="number" step="0.01" name="rate">
					          	</div>				  
					    		<div class="col-2">
				    				<input class = "btn btn-success" type="submit" value="Rate"/>
				    			</div>	
				    		</div>
				    		<p>
				    			<span id="errors">${ error }</span>
				    		</p>
						</form>
					</c:otherwise>
				</c:choose>
    		</div>
    		
		</div>
		
		<hr>
		
	</main>

	
</body>
</html>