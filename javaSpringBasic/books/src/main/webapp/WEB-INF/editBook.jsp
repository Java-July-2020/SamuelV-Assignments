<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Book</title>
    
   	
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="../../css/style.css">
	
</head>

<body>
 	
 	<h1>Edit Book</h1>
	<div>
		<form:form action="/books/edit/${book.id}" method="POST" modelAttribute="book">
		    <div class="form-group row mx-0">
		        <form:label class="col-sm-1 col-form-label" path="title">Title</form:label>
		        <div class="col-sm-4">
		        	<form:input class="form-control" path="title"/>
		        	<form:errors class="small" path="title"/>
		        </div>
		    </div>
		    <div class="form-group row mx-0">
		        <form:label class="col-sm-1 col-form-label" path="description">Description</form:label>
		        <div class="col-sm-4">
		        	
		        	<form:textarea class="form-control" path="description"/>
		        	<form:errors class="small" path="description"/>
		        </div>
		    </div>
		    <div class="form-group row mx-0">
		        <form:label class="col-sm-1 col-form-label" path="language">Language</form:label>
		        <div class="col-sm-4">
		        	
		        	<form:input class="form-control" path="language"/>
		        	<form:errors class="small" path="language"/>
		        </div>
		    </div>
		    <div class="form-group row mx-0">
		        <form:label class="col-sm-1 col-form-label" path="numberOfPages">Pages</form:label>
		        <div class="col-sm-4">
		        	    
		        	<form:input class="form-control" type="number" path="numberOfPages"/>
		        	<form:errors class="small" path="numberOfPages"/> 
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