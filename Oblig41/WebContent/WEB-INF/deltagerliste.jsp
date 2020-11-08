<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		
		<c:forEach var="deltager" items="${deltagerliste}" varStatus="loop">
		
		<tr>

				<td align="center">
					<c:choose>
    					<c:when test="${deltager.getKjonn()=='KVINNE'}">
       				 	&#9792;</c:when>
    					<c:otherwise>&#9794;</c:otherwise>
					</c:choose>
				</td>
				
				<td><c:out value="${deltager.getFornavn()} ${deltager.getEtternavn()}" /></td>
				<td><c:out value="${deltager.getMobil()}" /></td>
			</tr>

		</c:forEach>
	</table>
	<form action="ferdig">
    	<div class="pure-controls">
    		<input type="submit" value="Logg ut" class="pure-button pure-button-primary"/>
    	</div>
    </form>
</body>
</html>