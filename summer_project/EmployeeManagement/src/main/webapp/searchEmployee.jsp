<%--
  Created by IntelliJ IDEA.
  User: jeremymoudy
  Date: 7/28/21
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Employee</title>
</head>
<body>
    <form action="employee" method="get">
        <label>Name: </label>
        <input type="text" id="input_id" name="name" value=""> <br>
        <label>Employee ID: </label>
        <input type="text" id="id2" name="id" value=""> <br>
        <label>Salary: </label>
        <input type="text" id="id3" name="salary" value=""> <br> <br>
    <!--    <input type="button" value="Submit" onclick="wawa()" /> -->
<%--        <div id="alert" style="color: blue"></div>--%>
<%--        <div id="alert2" style="color: blue"></div>--%>

        <input type="submit" value="search">
    </form>
    <a href="index.jsp"><button>Return home</button></a><br> <br>

   <br>

    <div id="results">
        Search Results:
        <%=session.getAttribute("list")%>
    </div>
</body>

</html>