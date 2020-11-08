<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Ferdig</title>
</head>
<body>
	<h1>Ferdig</h1>
	<p>Du er n� logget ut.</p>
	
	<form action="logginn">
    	<div class="pure-controls">
    		<input type="submit" value="Logg inn igjen" class="pure-button pure-button-primary"/>
    	</div>
    </form>
</body>
</html>