<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Even/Uneven Info</title>
	<style>
		body{
			background-color:yellow;
		}
		h2{
			color:orange;
		}
	</style>
</head>
<body>
	<h1>Checking if a number is even or not</h1>
	<%
	String numParam = request.getParameter("num");
    int number1 = Integer.parseInt(numParam);
    String rez = (number1 % 2 == 0) ? "PAR" : "IMPAR";
	%>
	<h2>Numarul <%= number1 %> este: <%= rez %></h2>
</body>
</html>