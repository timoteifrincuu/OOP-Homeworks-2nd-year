<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VocalsForm</title>
	<style>
		body{
			background-color:brown;
			color: white;
		}
	</style>
</head>
<body>
	<form action="vocaleInfo.jsp">
		<div>
			<label>Enter the text:</label>
			<input name="text" type="text" />
		</div>	
		<div>
			<input type="submit" value="Send" />
		</div>
	</form>
</body>
</html>