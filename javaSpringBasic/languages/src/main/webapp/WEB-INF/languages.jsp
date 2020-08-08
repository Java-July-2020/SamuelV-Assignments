<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Programming Languages</title>
    
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
</head>

<body>

	<div class="pb-2">
	 	<h1>Programming Languages</h1>
		<table class="table table-dark">
	    	<thead>
	        	<tr>
	            	<th>Name</th>
	            	<th>Creator</th>
	            	<th>Version</th>
	            	<th>Action</th>
	       		</tr>
	    	</thead>
	    	<tbody>
	        	<c:forEach items="${languages}" var="language">
	        	<tr>
	            	<td><c:out value="${language.name}"/></td>
	            	<td><c:out value="${language.creator}"/></td>
	            	<td><c:out value="${language.version}"/></td>
	            	<td> 
	            		<a href="/languages/${language.id}">Show</a> |
	            		<a href="/languages/edit/${language.id}">Edit</a> |
	            		<a href="/languages/delete/${language.id}">Delete</a>
	            	</td>
	        	</tr>
	        	</c:forEach>
	    	</tbody>
		</table>
	</div>
	
	<div class="border-top border-dark pt-3">
	
	<h2>Add New Language</h2>
	
		<form:form action="/languages" method="POST" modelAttribute="language">
		    <div class="form-group row mx-0">
		        <form:label class="col-sm-1 col-form-label" path="name">Name</form:label>
		        <div class="col-sm-4">
		        	<form:input class="form-control" path="name"/>
		        	<form:errors class="small" path="name"/>
		        </div>
		    </div>
		    <div class="form-group row mx-0">
		        <form:label class="col-sm-1 col-form-label" path="creator">Creator</form:label>
		        <div class="col-sm-4">
		        	<form:input class="form-control" path="creator"/>
		        	<form:errors class="small" path="creator"/>
		        </div>
		    </div>
		    <div class="form-group row mx-0">
		        <form:label class="col-sm-1 col-form-label" path="version">Version</form:label>
		        <div class="col-sm-4">
		        	<form:input class="form-control" path="version"/>
		        	<form:errors class="small" path="version"/>
		        </div>
		    </div>
		    <div class="form-group row mx-0">
		    	<div class="col-sm-4 offset-sm-1">
		    		<input class = "btn btn-success" type="submit" value="Submit"/>
		    	</div>	
		    </div>
	    
		</form:form>
	</div>
</body>
</html>