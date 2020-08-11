<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    
     <!-- 0.1) Meta Tags and Title -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Song Dashboard</title>
    
    
    <!-- 0.2) External Libraries for Styles-->
    
    <!-- CSS Bootstrap 4 (Uploaded by CDN with weblink)-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
	
	<!-- 0.3) External Libraries for Scripts -->
	
	<!-- JS JQuery (Uploaded by CDN with weblink)-->
    <script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <!-- JS Popper (Uploaded by CDN with weblink)-->
    <script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <!-- JS Bootstrap (Uploaded by CDN with weblink)-->
    <script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
	
	<!-- 0.4) Personal Styles and Scripts -->
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	
</head>

<body>
	
	<!-- ================================================================================================ -->
    <!-- 1) NAVBAR -->
    <!-- ================================================================================================ -->
	
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
	
		<!-- Company Name and Logo -->
        <a class="navbar-brand text-decoration-none" href="#">Lookify</a>
        
        <!-- Toggler Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="/songs/new">Add New Song</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/search/topSongs">Top Songs</a>
                </li>
            </ul>
            <form class="form-inline ml-2" action="/songs/search/${song.artist}">
    			<input class="form-control mr-sm-2" type="text" placeholder="Search" name="artist">
    			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  			</form>    
        </div>
        
	</nav>
	
	<!-- ================================================================================================ -->
    <!-- 2) MAIN -->
    <!-- ================================================================================================ -->
	
	<main>
	 	<h2>All Songs</h2>
		<table class="table table-dark mt-3">
	    	<thead>
	        	<tr>
	            	<th>Title</th>
	            	<th>Artist</th>
	            	<th>Rating</th>
	            	<th>Action</th>
	       		</tr>
	    	</thead>
	    	<tbody>
	        	<c:forEach items="${songs}" var="song">
	        	<tr>
	            	<td><c:out value="${song.title}"/></td>
	            	<td><c:out value="${song.artist}"/></td>
	            	<td><c:out value="${song.rating}"/></td>
	            	<td> 
	            		<a href="/songs/${song.id}">Show</a> |
	            		<a href="/songs/edit/${song.id}">Edit</a> |
	            		<a href="/songs/delete/${song.id}">Delete</a>
	            	</td>
	        	</tr>
	        	</c:forEach>
	    	</tbody>
		</table>
	</main>
	
</body>
</html>