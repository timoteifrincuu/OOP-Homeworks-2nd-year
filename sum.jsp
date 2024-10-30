<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
String num1Str = request.getParameter("num1");
String num2Str = request.getParameter("num2");

if (num1Str != null && num2Str != null) {
    try {
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        int sum = num1 + num2;
%>

<!DOCTYPE html>
<html>
<head>
<title>Suma 2 nr trimise ca parametrii</title>
    <style>
    body{
    	background-color:pink;
    }
    </style>
</head>
<body>
	 <h2>Suma numarului <%= num1 %> si <%= num2 %> este: <%= sum %></h2>
</body>
</html>

<%
        } catch (NumberFormatException e) {
            out.println("Parametrii invalizi, asigura-te ca sunt numere intregi.");
        }
    } else {
        out.println("Furnizeaza valori pentru parametrii num1 si num2");
    }
%>