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
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			 <div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" id="fornavn"
					onkeyup="fornavnSjekk()" /> <font color="red" id="fn"></font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" id="etternavn"
					onkeyup="etternavnSjekk()" /> <font color="red" id="en"></font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" id="mobil"
					onkeyup="mobilSjekk()" /> <font id="mob" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" id="passord"
					onkeyup="passordSjekk()" /> <font id="pass" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Repeter Passord:</label> <input
					type="password" id="passordRep" name="passordRepetert"
					onkeyup="passordRepSjekk()" /> <font
					color="red" id="passRep"></font>
			</div>
			 <div class="pure-control-group">
                <label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
                    value="Mann"
                     />Mann
                <input type="radio" name="kjonn" value="Kvinne"
                     />Kvinne
                <font color="red"></font>
            </div>
				
            <div class="pure-controls">
                <button type="submit" class="pure-button pure-button-primary">Meld meg på</button>
            </div>
        </fieldset>
    </form>
    
    <script src="validator.js"></script>
</body>
</html>