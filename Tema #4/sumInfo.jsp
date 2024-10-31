<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SumInfo</title>
	<style>
		body{
			background-color:pink;
		}
	</style>
</head>
<body>
	<h1>Informatii introduse</h1>
	
	<%
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");

    int number1 = Integer.parseInt(num1);
    int number2 = Integer.parseInt(num2);

    int sum = number1 + number2;
	%>
	
	<div>
	    Num1: <b><%= num1 %></b>
	</div>
	<div>
	    Num2: <b><%= num2 %></b>
	</div>
	<div>
	    Sum: <b><%= sum %></b>
	</div>
</body>
</html>