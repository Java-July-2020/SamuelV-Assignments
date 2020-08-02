<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dojo Survey</title>
    
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
    <div id="wrapper">
        <h2> Dojo Registration Form</h2>
        <form action="submit" method="POST">

            <table align="left" cellpadding = "5">
                
                <!-- First Name -->
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName"></td>
                </tr>
                
                <!-- Last Name -->
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName"></td>
                </tr>
                
                <!-- Email -->
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email"></td>
                </tr>
                
                <!-- Date of Birthday -->
                <tr>
                    <td>Birthday:</td>
                    <td><input type="date" name="birthday"></td>
                </tr>
                
                <!-- Gender -->
                <tr>
                    <td colspan="2" align="left">
                        Male<input type="radio" name="gender" value="male"> 
                        Female<input type="radio" name="gender" value="female">
                        Other<input type="radio" name="gender" value="decline">
                    </td>
                </tr>
                
                <!-- A short Description about yourself -->
                <tr>
                    <td colspan="2" align="left">
                        <p>Comments:</p>
                        <textarea name="comments" rows="10" cols="45"></textarea>
                    </td>
                </tr>
                
                <!-- Favorite Language -->
                <tr>
                    <td>Favorite Language:</td>
                    <td>
                        <select name="favoriteLanguage" id="favorite_language">
                            <option value="-1">Language:</option>
                            <option value="HTML">HTML</option>
                            <option value="CSS">CSS</option>
                            <option value="JavaScript">JavaScript</option>
                            <option value="Python">Python</option>
                            <option value="Ruby">Ruby</option>
                            <option value="SQL">SQL</option>
                        </select>
                    </td>
                </tr>
                <!-- Frameworks and Libraries -->
                <tr>
                    <td colspan="2" align="left">
                        <p>Frameworks and Libraries:</p>
                        JQuery<input type="checkbox" name="frameworksAndLibraries" value="JQuery"> 
                        Django<input type="checkbox" name="frameworksAndLibraries" value="Django">
                        Flask<input type="checkbox" name="frameworksAndLibraries" value="Flask">
                        Rails<input type="checkbox" name="frameworksAndLibraries" value="Rails">
                    </td>
                </tr>
                <!-- Submit -->
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Submit">
                    </td>
                </tr>
            </table>
        </form>

    </div>
</body>
</html>