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
    <label>Part Number: </label>
    <input type="text" id="id2" value="" name="partNum"> <br>
    <label>Price: </label>
    <input type="text" id="id3" value="" name="price"> <br> <br>
<%--    <input type="button" value="Submit" onclick="wawa()" />--%>
    <div id="alert" style="color: blue"></div>
    <div id="alert2" style="color: blue"></div>
    <input type="submit" value="Submit">

</form>
<a href="index.jsp"><button>Return home</button></a>

</body>
</html>