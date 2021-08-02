<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Managing System</title>
</head>

<body>
	<div>
		<c:if test="${product != null}">
			<form action="update_product" method="post">
		</c:if>
		<c:if test="${product == null}">
			<form action="insert_product" method="post">
		</c:if>

		<h2>
			<c:if test="${product != null}">Edit Product</c:if>
			<c:if test="${product == null}">Add New Product</c:if>
		</h2>

		<c:if test="${product != null}">
			<input type="hidden" name="id" value="<c:out value='${product.id}' />" />
		</c:if>

		<fieldset class="form-group">
			<label>Name</label>
			<input type="text" value="<c:out value='${product.name}'/>" name="name" required="required">
		</fieldset>

		<fieldset class="form-group">
			<label>ID</label>
			<input type="text" value="<c:out value='${product.id}'/>" name="id">
		</fieldset>

		<fieldset class="form-group">
			<label>Price</label>
			<input type="text" value="<c:out value='${product.price}'/>" name="price">
		</fieldset>
		
		<input type='submit' value="Submit">
		</form>
	</div>
	<br>
	<a href="index.jsp"><button>Back to Main</button></a>
</body>

</html>