<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<style>
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

table.table {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>

<body>
	<div class="container" align="center">
		<h3 class="text-center">List of Products</h3>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${productList}">

					<tr>
						<td><c:out value="${product.id}" /></td>
						<td><c:out value="${product.name}" /></td>
						<td><c:out value="${product.price}" /></td>
					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>

		</table>
		<br>
		<div>
			<a href="customer.jsp">
				<button>Back</button>
			</a>
		</div>
	</div>
</body>

</html>