<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String text = request.getParameter("text");
    int numarVocale = 0;
 
    if (text != null) {
        text = text.toLowerCase();
        for (char c : text.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                numarVocale++;
            }
        }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Numarare vocale</title>
        <style>
    body{
    	background-color:purple;
    }
    </style>
</head>
<body>
    <h2>Textul "<%= text %>" conține <%= numarVocale %> vocale.</h2>
</body>
</html>

<%
    } else {
        out.println("Vă rugăm să furnizați parametrul 'text' în URL.");
    }
%>
