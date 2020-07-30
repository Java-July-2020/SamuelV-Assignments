<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Current Visit Count</title>
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		
		<div id="counterBox">
			<p>You have visited this page  <%= session.getAttribute("count") %></p>
			<p><a href="/">Test another visit?</a></p>
			<p id="reset"><a href="/reset">Reset</a></p>
		</div>
	</div>

</body>

</html>