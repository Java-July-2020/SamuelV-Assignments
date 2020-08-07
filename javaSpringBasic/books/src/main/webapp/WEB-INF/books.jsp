<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books</title>
    
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
</head>

<body>
 	<h1>All Books</h1>
	<table class="table table-dark">
    	<thead>
        	<tr>
            	<th>Title</th>
            	<th>Description</th>
            	<th>Language</th>
            	<th>Number of Pages</th>
       		</tr>
    	</thead>
    	<tbody>
        	<c:forEach items="${books}" var="book">
        	<tr>
            	<td><c:out value="${book.title}"/></td>
            	<td><c:out value="${book.description}"/></td>
            	<td><c:out value="${book.language}"/></td>
            	<td><c:out value="${book.numberOfPages}"/></td>
        		</tr>
        	</c:forEach>
    	</tbody>
	</table>
	<a href="/books/new">New Book</a>
</body>
</html>