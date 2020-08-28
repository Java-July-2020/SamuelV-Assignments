<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    
     <!-- 0.1) Meta Tags and Title -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shows Dashboard</title>
    
    
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
                    <a class="nav-link active" href="/logout">Logout</a>
                </li>

            </ul> 
        </div>
        
	</nav>
	
	<!-- ================================================================================================ -->
    <!-- 2) MAIN -->
    <!-- ================================================================================================ -->
	
	<main>
		
		<div class="ml-4">
		
			<h3>Welcome <c:out value="${user.firstName}"/>!</h3>
			<hr>
			
			<!-- TV Shows-->
			<div class = "mt-3 mb-4">
				<h5> Here are the TV Shows that are being rated by the users:</h5>
				<div class="row">
					<div class="col-9">
						<table class="table table-dark mt-1">
					    	<thead>
					        	<tr>
					            	<th>Name</th>
					            	<th>Network</th>
					            	<th>Added by</th>
					            	<th>Average Rating</th>
					            	<th>Status</th>
					            	<th>Actions</th>
					       		</tr>
					    	</thead>
					    	<tbody>
					        	<c:forEach items="${shows}" var="show">
					        	<tr>
									<!-- Name Field -->
					            	<td>
					            		<a href="/shows/${show.id}"><c:out value="${show.name}"/></a>
					            	</td>
					            	
					            	<!-- Network Field -->
					            	<td><c:out value="${show.network}"/></td>
					            	
					            	<!-- Creator Field -->
					            	<td><c:out value="${show.creator.firstName} ${show.creator.lastName}"/></td>

									<!-- Rating Field -->
					            	<td>
					            		<fmt:setLocale value = "en_US" scope="session"/>
										<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${show.getAverageRating()}"/>
					            	</td>
					            	
					            	<!-- Status Field -->
					            	<td>
						            	<c:choose>
						            		<c:when test="${ !show.usersAlreadyRate.contains(user)}">
						               			<a href="/shows/${show.id}">Give a Rate</a>
					            			</c:when>
					            			<c:otherwise>
							            		<p> Already given a rate! </p>
							            	</c:otherwise>
					            		</c:choose>
				            		</td>
					            	
					            	<!-- Action Field -->
					            	<td>
						            	<c:choose>
						            		<c:when test="${ show.creator.id == user.id }">
						               			<a href="/shows/${show.id}/edit">Edit</a> |
						            			<a href="/shows/${show.id}/delete">Delete</a> 
					            			</c:when>
					            			<c:otherwise>
							            		<p> ------</p>
							            	</c:otherwise>
					            		</c:choose>
				            		</td>
					        	</tr>
					        	</c:forEach>
					    	</tbody>
						</table>
					</div>
				</div>
			</div>
			
			<!-- Add new Tv Show Button -->
	    	<div>
    			<a class= "btn btn-success text-decoration-none" href="/shows/new">Add a Show</a>
    		</div>
			
		</div>	
	</main>
	
</body>
</html>