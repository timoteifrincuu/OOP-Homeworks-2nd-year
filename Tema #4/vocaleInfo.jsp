<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info Vocals</title>
	<style>
		body{
			background-color:brown;
			color: white;
		}
	</style>
</head>
<body>
<%
	String text = request.getParameter("text");
	int nrVocals = 0;
	
	text = text.toLowerCase();
	for(char c : text.toCharArray()){
		if("aeiou".indexOf(c) != -1){
			nrVocals++;
		}
	}
%>

<h2>Text "<%= text %>" contains <%= nrVocals %> vocals.</h2>

</body>
</html>