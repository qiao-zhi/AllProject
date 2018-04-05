function ltrim(str) {
	for ( var i = 0; str.charAt(i) == " "; i++)
		;
	return str.substring(i, str.length);
}

function rtrim(str) {
	for ( var i = str.length - 1; str.charAt(i) == " "; i--)
		;
	return str.substring(0, i + 1);
}

function trim(str) {
	return ltrim(rtrim(str));
}


function strim(s) {
	return s.replace("\xa0", "");
}
