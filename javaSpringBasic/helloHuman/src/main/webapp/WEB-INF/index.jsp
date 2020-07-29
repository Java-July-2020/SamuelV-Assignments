<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Hello Human</title>
</head>
<body>
	<h1>Hello <c:out value="${firstName}"/> <c:out value="${lastName}"/>!</h1>
	<p>Welcome to SpringBoot</p>

</body>

</html>