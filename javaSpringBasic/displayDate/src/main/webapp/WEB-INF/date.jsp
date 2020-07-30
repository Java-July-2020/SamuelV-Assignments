<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Date</title>
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script defer type="text/javascript" src="js/date.js"></script>
</head>
<body>
	<div id="container">
		<div id="dateBox">
			<p><c:out value="${date}"/></p>
		</div>
	</div>
</body>

</html>