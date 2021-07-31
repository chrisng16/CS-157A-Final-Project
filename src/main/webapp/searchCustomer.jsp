<%--
  Created by IntelliJ IDEA.
  User: jeremymoudy
  Date: 7/31/21
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <%--Form caputers user input. Action needs to match the repsective servlet. For example, this is for the employee
    servlet, so it is employee, and the servlet is listening for a call on /employee. Method is used to tell the
    servlet whether we're sending data to it or we want data from it. get = get data, post = send data. --%>
<form action="customer" method="get">
    <label>Name: </label>
    <input type="text" id="input_id" name="name" value=""> <br>

    <label>Customer ID: </label>
    <input type="text" id="id2" name="id" value=""> <br>

    <label>Orders:</label>
    <input type="text" id="id3" name="order" value=""> <br> <br>

    <label>Email:</label>
    <input type="text" id="id4" name="email" value=""> <br> <br>

    <input type="submit" value="search">
</form>

<%--Link to go back to the home page. Must be OUTSIDE of the form to work correctly. --%>
<a href="index.jsp"><button>Return home</button></a><br> <br>

<br>

<%--Container to hold and display results sent from back-end.--%>
<div id="results">
    Search Results:
    <%=session.getAttribute("list")%>
</div>
</body>
</html>
