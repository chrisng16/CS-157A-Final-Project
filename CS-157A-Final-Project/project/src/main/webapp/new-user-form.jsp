<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Managing System</title>
</head>

<body>
	<div>
		<c:if test="${employee != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${employee == null}">
			<form action="insert" method="post">
		</c:if>

		<h2>
			<c:if test="${employee != null}">Edit Employee</c:if>
			<c:if test="${employee == null}">Add New Employee</c:if>
		</h2>

		<c:if test="${employee != null}">
			<input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
		</c:if>

		<fieldset class="form-group">
			<label>Name</label>
			<input type="text" value="<c:out value='${employee.name}'/>" name="name" required="required">
		</fieldset>

		<fieldset class="form-group">
			<label>ID</label>
			<input type="text" value="<c:out value='${employee.id}'/>" name="id">
		</fieldset>

		<fieldset class="form-group">
			<label>Salary</label>
			<input type="text" value="<c:out value='${employee.salary}'/>" name="salary">
		</fieldset>
		
		<input type='submit' value="Submit">
		</form>
	</div>
	<br>
	<a href="index.jsp"><button>Back to Main</button></a>
</body>

</html>