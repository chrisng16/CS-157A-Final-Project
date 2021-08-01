<%--
  Created by IntelliJ IDEA.
  User: angela
  Date: 7/30/2021
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
    <div class="container">
        <h3 class="text-center">List of Employees</h3>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Hours Worked</th>
                <th>Salary</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="employee" items="${listEmployees}">

                <tr>
                    <td>
                        <c:out value="${employee.employeeid}" />
                    </td>
                    <td>
                        <c:out value="${employee.name}" />
                    </td>
                    <td>
                        <c:out value="${employee.hoursworked}" />
                    </td>
                    <td>
                        <c:out value="${employee.salary}" />
                    </td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
    </form>
</div>
<a href="index.jsp"><button>Return home</button></a><br> <br>
</body>

</html>