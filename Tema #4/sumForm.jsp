<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sum form</title>
	<style>
		body{
			background-color:pink;
		}
	</style>
</head>
<body>
	<form action="sumInfo.jsp">
		<div>
			<label>Primul Numar</label>
			<input name="num1" type="number" />
		</div>	
		<div>
			<label>Al Doilea Numar</label>
			<input name="num2" type="number" />
		</div>
		<div>
			<input type="submit" value="Send" />
		</div>
	</form>
</body>
</html>