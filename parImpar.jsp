<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String numStr = request.getParameter("num");

    if (numStr != null) {
        try {
            int num = Integer.parseInt(numStr);
            String rezultat = (num % 2 == 0) ? "par" : "impar";

%>

<!DOCTYPE html>
<html>
<head>
    <title>Verificare par/impar</title>
    <style>
    body{
    	background-color:cyan;
    }
    </style>
</head>
<body>
    <h2>Numarul <%= num %> este: <%= rezultat %></h2>
</body>
</html>

<%
        } catch (NumberFormatException e) {
            out.println("Parametrul nu este valid. Asigurați-vă că ați introdus un număr întreg.");
        }
    } else {
        out.println("Te rog da valoare parametrului num.");
    }
%>
