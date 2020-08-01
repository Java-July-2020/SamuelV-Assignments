<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Secret Code</title>
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<div id="main">
			<p id="errorMessageBox"> <c:out value="${errorMessage}"/></p>
			<form method="POST" action="/login">
    			<p> What is the code? </p>
    			<input type="password" name="password">
    			<button>Try Code</button>
			</form>
		</div>
	</div>
</body>

