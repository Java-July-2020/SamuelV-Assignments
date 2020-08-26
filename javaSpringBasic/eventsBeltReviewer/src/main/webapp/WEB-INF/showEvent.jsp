<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true" %>  

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
	<link rel="stylesheet" type="text/css" href="../../css/style.css">
	
</head>

<body>
	
	<!-- ================================================================================================ -->
    <!-- 1) NAVBAR -->
    <!-- ================================================================================================ -->
	
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	
		<!-- Company Name and Logo -->
        <a class="navbar-brand text-decoration-none" href="#">Events Belt Reviewer</a>
        
        <!-- Toggler Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
            	<li class="nav-item">
                    <a class="nav-link active" href="/events">Dashboard</a>
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
		
		
		<h3><c:out value="${event.name}"/></h3>
		<hr>
		
		<section class="mt-3 ml-3" >
			<div class="row justify-content-around">
			
				<!-- Details of Events and Attendees -->
				<div class="col-5">
		
					<!-- Event Details -->
					<h5 class="mb-1"> Event Details</h5>
					<p>Host: <c:out value="${event.planner.firstName} ${event.planner.lastName}"/></p>			            		
					<p>Date:
						<fmt:setLocale value = "en_US" scope="session"/>
						<fmt:formatDate value="${event.date}" pattern="MMMM dd, yyyy"/>
					</p>
					<p>Location: <c:out value="${event.city}, ${event.state}"/></p>
					<p>People who are attending this event: <c:out value="${event.attendees.size()}"/></p>
				
					<!-- People Attending -->
					<h5 class="mt-4 mb-2"> People Attending</h5>
					<table class="table table-dark table-sm mt-1 p-1">
				    	<thead>
				        	<tr>
				            	<th class="pl-3">Name</th>
								<th>Location</th>
				           	</tr>
				    	</thead>
				    	<tbody>
				        	<c:forEach items="${event.attendees}" var="attendee">
					        	<tr>
									<!-- Name Field -->
					            	<td class="pl-3"><c:out value="${attendee.firstName} ${attendee.lastName}"/></td>
					            	<!-- Location Field -->
					            	<td><c:out value="${attendee.city}"/></td>
					        	</tr>
				        	</c:forEach>
				    	</tbody>
					</table>
				</div>
				
				<!-- Message Wall and Comments-->
				<div class="col-5">
		
					<!-- Message Wall -->
					<div>
						<h5 class="mb-1"> Message Wall</h5>
						<div id="messageBox" class="px-2 py-3">
							<c:forEach items="${event.messages}" var="comment">
						        <p><c:out value="${comment.author.firstName} ${comment.author.lastName} says: ${comment.content}"/></p>
						        <p> --------------------- </p>
					        </c:forEach>
						</div>	
					</div>            		
					
				
					<!-- Add Comments Form-->
					<div>
						<h5 class="mt-4 mb-2"> Add Comment</h5>
						<form action="/events/${event.id}/comment" method="POST">
							<!-- Comment Field -->
				        	<div class="form-group row">
					        	<div class="col-10">
					        		<textarea class="form-control" rows="5" name="comment"></textarea>
					        		<span id="errors">${ error }</span>
					        	</div>
					    	</div>
					    	
					    	<!-- Submit Button -->
					    	<div class="form-group row">
				    			<div class="col-3 offset-7">
				    				<input class = "btn btn-success" type="submit" value="Comment"/>
				    			</div>	
				    		</div>
						</form>
					</div>
					
				</div>
			</div>
		
		</section>
		
	</main>
	
</body>
</html>