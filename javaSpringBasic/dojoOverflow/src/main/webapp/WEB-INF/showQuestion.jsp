<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html lang="en">
<head>
     <!-- 0.1) Meta Tags and Title -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Question</title>
    
    
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
        <a class="navbar-brand text-decoration-none" href="#">Dojo Overflow</a>
        
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
                    <a class="nav-link active" href="/questions/new">Add New Question</a>
                </li>
            </ul> 
        </div>
        
	</nav>
	
	<!-- ================================================================================================ -->
    <!-- 2) MAIN -->
    <!-- ================================================================================================ -->
	
	<main class="mt-3">
	
	 	<h2><c:out value="${question.questionText}"/></h2>
		
		<!-- List of Categories linked to the Product -->
		<p class= d-inline>Tags:</p>
		<ul class="list-group list-group-horizontal d-inline"> 
        	<c:forEach items="${question.tags}" var="tag">
            	<li class="list-group-item py-0 mx-1 d-inline"><c:out value="${tag.subject}"/></li>
        	</c:forEach>
	    </ul>	
		
		<section class="mt-3">
			<div class="row">
				
				<!-- Show List of Answers-->
				<div class="col-6">
				
					<table class="table table-light table-striped table-sm">
				    	<thead class="thead-dark">
				        	<tr class="d-flex">
				            	<th class="col-10 pl-3">Answers</th>
				            	<th class="col-2">Action</th>
				       		</tr>
				    	</thead>
				    	<tbody>
				        	<c:forEach items="${question.answers}" var="answer">
				        	<tr class="d-flex">
				            	<td class="col-10 pl-3"><c:out value="${answer.answerText}"/></td>
				   
				            	<td class="col-2"> 
				            		<a href="/answers/delete/${answer.id}">Delete</a> 
				            	</td>
				        	</tr>
				        	</c:forEach>
				    	</tbody>
					</table>
				
				</div>
				
				
				
				<!-- Add Answer Form-->
				<div class="col-5">
					<form:form action="/questions/addAnswer" method="POST" modelAttribute="answer"> 
					    
					    <!--  Hidden input for question ID -->
					    <form:input type="hidden" path="question" value="${ question.id }"/>
					    
						<!--  Category Selection Field -->
				        <div class="form-group row">
					        	<form:label class="col-2 col-form-label" path="answerText">Answer:</form:label>
					        	<form:textarea class="col-10 form-control" rows="5" type="text" path="answerText"/>
			        			<form:errors class="small" path="answerText"/>
				        </div>
					
						<!--  Submit Button -->
						<div class="form-group row">
						    <div class="ml-auto">
						    	<input class = "btn btn-success" type="submit" value="Add"/>
					    	</div>
				    	</div>
					</form:form>
				</div>
				
			</div>
			
		</section>	
		
	</main>
	
</body>
</html>