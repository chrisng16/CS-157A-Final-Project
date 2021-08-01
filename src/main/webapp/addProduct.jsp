<%--
  Created by IntelliJ IDEA.
  User: jeremymoudy
  Date: 7/28/21
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head><!DOCTYPE html>

<html>
<body>
<form action="product" method="post">
    <label>Product name: </label>
    <input type="text" id="input_id" value="" name="name"> <br>

    <label>Product ID: </label>
    <input type="text" id="id2" value="" name="id"> <br>

    <label>Category: </label>
    <input type="text" id="id3" value="" name="category"> <br>

    <label>Price: </label>
    <input type="text" id="id4" value="" name="price"> <br> <br>

    <label>Rating:  </label>
    <input type="text" id="id5" value="" name="rating"> <br>

    <label>Manufacturer: </label>
    <input type="text" id="id6" value="" name="manufacturer"> <br>

<%--    <input type="button" value="Submit" onclick="wawa()" />--%>
    <div id="alert" style="color: blue"></div>
    <div id="alert2" style="color: blue"></div>
    <input type="submit" value="Submit">

</form>
<a href="index.jsp"><button>Return home</button></a>

<div id="confirmation">
        <%=session.getAttribute("response")%>
</body>
</html>