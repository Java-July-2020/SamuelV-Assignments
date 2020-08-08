<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Language</title>
    
  
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	
</head>

<body>
 	<h1><c:out value="${language.name}"/></h1>
	<p>Creator: <c:out value="${language.creator}"/></p>
	<p>Version: <c:out value="${language.version}"/></p>
	<br>
	<p> <a href="/languages/edit/${language.id}">Edit Language</a> | <a href="/languages/delete/${language.id}">Delete language</a> </p>
	<br>
	<a href="/languages">Go back!</a>
	
</body>
</html>