<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submited Info</title>

    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <body>
        <div id="wrapper">
            <h2>Submitted Info</h2>

            <form action='/' method='GET'>
                <table align="left" cellpadding = "5">
                
                    <!-- {# First Name #}-->
                    <tr>
                        <td>First Name:</td>
                        <td><c:out value="${firstName}"/></td>
                    </tr>
                    
                    <!-- Last Name -->
                    <tr>
                        <td>Last Name:</td>
                        <td><c:out value="${lastName}"/></td>
                    </tr>
                    
                    <!-- Email -->
                    <tr>
                        <td>Email:</td>
                        <td><c:out value="${email}"/></td>
                    </tr>
                    
                    <!-- Date of Birthday -->
                    <tr>
                        <td>Birthday:</td>
                        <td><c:out value="${birthday}"/></td>
                    </tr>

                    <!-- Gender -->
	                <tr>
	                    <td>Gender:</td>
	                    <td><c:out value="${gender}"/></td>
	                </tr>
	                
	                <!-- A short Description about yourself -->
	                <tr>
	                    <td>Comments:</td>
	                    <td><c:out value="${comments}"/></td>
	                </tr>
	
	                <!-- Favorite Language -->
	                <tr>
	                    <td>Favorite Language:</td>
	                    <td><c:out value="${favoriteLanguage}"/></td>
	                </tr>
	                <!-- Frameworks and Libraries -->
	                <tr>
	                    <td>Frameworks and Libraries:</td>
	                    <td><c:out value="${frameworksAndLibraries}"/></td>
	                </tr>
	                <!-- Go Back -->
	                <tr>
                    	<td colspan="2" align="center">
                        <button type='submit'>Go back</button>
                    	</td>
                	</tr>
                </table>
      		</form>
    	</div>
    </body>
    
</body>
</html>