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
				<a href="index.jsp"> User Management App </a>
			</div>

			<ul class="navbar">
				<li><a href="<%=request.getContextPath()%>/list">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new">Add New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Salary</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${employeeList}">

						<tr>
							<td><c:out value="${employee.id}" /></td>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.salary}" /></td>
							<td><a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="delete?id=<c:out value='${employee.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>

</html>