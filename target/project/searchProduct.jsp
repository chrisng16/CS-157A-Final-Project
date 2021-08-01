<%--
  Created by IntelliJ IDEA.
  User: angela
  Date: 7/31/2021
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<html>
<head>
    <title>Search Products</title>
</head>
<body>
<form action="product" method="get" >
    <label>Name: </label>
    <input type="text" id="input_id" name="name" value=""> <br>
    <input type="submit" value="Search by Name">
</form>
<br>
<form action="product" method="get">
    <label>ID: </label>
    <input type="text" id="id1" name="id" value=""> <br>
    <input type="submit" value="Search by ID">
</form>
<a href="index.jsp"><button>Return home</button></a><br> <br>

<br>

<div id="results">
    Search Results:
    <%=session.getAttribute("list")%>
</div>
</body>

</html>
