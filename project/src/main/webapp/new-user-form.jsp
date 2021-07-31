<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Managing System</title>
</head>

<body>
<form action="insert" method ="post">
	<h2>Insert Employee</h2>
	<label>Name:</label>
	<input type="text" name="name"> <br>
	
	<label>Employee ID:</label>
	<input type="number" name="id"> <br>
	
	<label>Salary:</label>
	<input type="number" name="salary"> <br><br>
	
	<input type='submit' value="Submit">
</form>
</body>

</html>