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

	<header>
		<nav>
			<div>
				<a href="index.jsp"> Main Menu </a>
			</div>

			<ul class="navbar">
				<li><a href="<%=request.getContextPath()%>/list_employee">List of Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Products</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new_product">Add New Product</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${productList}">

						<tr>
							<td><c:out value="${product.id}" /></td>
							<td><c:out value="${product.name}" /></td>
							<td><c:out value="${product.price}" /></td>
							<td><a href="edit_product?id=<c:out value='${product.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="delete_product?id=<c:out value='${product.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>

</html>