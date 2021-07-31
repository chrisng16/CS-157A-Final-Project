<%--
  Created by IntelliJ IDEA.
  User: jeremymoudy
  Date: 7/28/21
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Add</title>--%>

<%--</head>--%>
<%--<body>--%>
<%--<h1>Hello</h1>--%>
<%--</body>--%>
<%--</html>--%>

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head><!DOCTYPE html>

<html>
<body>
<form action="employee" method="post">
    <label>Employee ID:</label>
    <input type="text" id="id" name="empID"> <br>

    <label>Name: </label>
    <input type="text" id="input_id" name="name" value=""> <br>

    <label>Total Hours Worked:</label>
    <input type="text" id="w" name="hours"><br>

    <label>Salary: </label>
    <input type="text" id="id3" name="salary" value=""> <br> <br>

    <div id="alert" style="color: blue"></div>
    <div id="alert2" style="color: blue"></div>

    <input type="submit" value="send">
</form>
<a href="index.jsp"><button>Return home</button></a>

<div id="confirmation">

    <%--the <%=%> tag allows you to embed java code into the .jsp file. --%>
    <%=session.getAttribute("response")%>
</div>

</body>

</html>