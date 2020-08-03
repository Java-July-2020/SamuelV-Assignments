<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.Collections"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ninja Gold</title>
    

     <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <p>Your Gold: </p>
            <p id='totalAmount'><%= session.getAttribute("amountOfGold") %></p>
        </div>
        <div id="main">
            <!-- Farm -->
            <div class="box">
                <form action="/process_money" method="POST">
                    <h4>Farm</h4>
                    <p>(earns 10-20 golds)</p>
                    <button type='submit' name="place" value="farm">Find Gold!</button>
                </form>
            </div>
            <!-- Cave -->
            <div class="box">
                <form action="/process_money" method="POST">
                    <h4>Cave</h4>
                    <p>(earns 5-10 golds)</p>
                    <button type='submit' name="place" value="cave">Find Gold!</button>
                </form>
            </div>
            <!-- House -->
            <div class="box">
                <form action="/process_money" method="POST">
                    <h4>House</h4>
                    <p>(earns 2-5 golds)</p>
                    <button type='submit' name="place" value="house">Find Gold!</button>
                </form>
            </div>
            <!-- Casino -->
            <div class="box">
                <form action="/process_money" method="POST">
                    <h4>Casino</h4>
                    <p>(earns/takes 0-50 golds)</p>
                    <button type='submit' name="place" value="casino">Find Gold!</button>
                </form>
            </div>
        </div>
        <div id="footer">
            <h5>Activities:</h5>
            <div id='activities'styles="overflow: scroll;">
               
               <% 
               ArrayList<String> activityLog = (ArrayList<String>) session.getAttribute("activityLog");
               Collections.reverse(activityLog);
               
               for (String log : activityLog) { 
               		if (log.contains("lost")){
               		%>
               		<p class="lose"><%=log%></p>
               		<% }
               		else{ 
               		%>
       				<p class="win"><%=log%></p>
       				<%}
                } %>
               

            </div>
        </div>
        <form action="/reset">
            <input type="submit" value="Reset">
        </form>
    </div>
</body>
</html>