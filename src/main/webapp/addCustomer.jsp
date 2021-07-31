<%--
  Created by IntelliJ IDEA.
  User: jeremymoudy
  Date: 7/31/21
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="customer" method="post">
    <label>Customer ID:</label>
    <input type="text" id="id" name="custID"> <br>

    <label>Name: </label>
    <input type="text" id="input_id" name="name" value=""> <br>

    <label>Orders:</label>
    <input type="text" id="w" name="orders"><br>

    <label>Email: </label>
    <input type="text" id="id3" name="email" value=""> <br> <br>

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
