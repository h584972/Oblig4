let passord;
function fornavnSjekk() {
	let fn = document.getElementById("fn");
	let fornavn = document.getElementById("fornavn").value;
	if (fornavn.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,20}$")){
		fn.innerHTML = "";
		document.getElementById("fornavn").style.borderColor = "green";
	} else {
		fn.innerHTML = "Ugyldig fornavn";
		document.getElementById("fornavn").style.borderColor = "red";
	}
}

function etternavnSjekk() {
	let en = document.getElementById("en");
	let etternavn = document.getElementById("etternavn").value;
	if (etternavn.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,20}$")) {
		en.innerHTML = "";
		document.getElementById("etternavn").style.borderColor = "green";
	} else {
		en.innerHTML = "Ugyldig etternavn";
		document.getElementById("etternavn").style.borderColor = "red";
	}
}
function mobilSjekk() {
	let mob = document.getElementById("mob");
	let mobil = document.getElementById("mobil").value;
	if (mobil.match("^[\\d]{8}$")) {
		mob.innerHTML = "";
		document.getElementById("mobil").style.borderColor = "green";
	} else {
		mob.innerHTML = "Ugyldig tlfnummer";
		document.getElementById("mobil").style.borderColor = "red";
	}
}
function passordSjekk() {
	let pass = document.getElementById("pass");
	let passord = document.getElementById("passord").value;
	if (passord.match("(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")) {
		pass.innerHTML = "";
		document.getElementById("passord").style.borderColor = "green";
	} else {
		pass.innerHTML = "Ugyldig passord";
		document.getElementById("passord").style.borderColor = "red";
	}
}
function passordRepSjekk() {
	let passRep = document.getElementById("passRep");
	let passordRep = document.getElementById("passordRep").value;
	if (passordRep === passord) {
		passRep.innerHTML = "";
		document.getElementById("passordRep").style.borderColor = "green";
	} else {
		passRep.innerHTML = "Passord matcher ikke";
		document.getElementById("passordRep").style.borderColor = "red";
	}
}