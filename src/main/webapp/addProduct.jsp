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
<form>
    <label>Product name: </label>
    <input type="text" id="input_id" value=""> <br>
    <label>Part Number: </label>
    <input type="number" id="id2" value=""> <br>
    <label>Price: </label>
    <input type="number" id="id3" value=""> <br> <br>
    <input type="button" value="Submit" onclick="wawa()" />
    <div id="alert" style="color: blue"></div>
    <div id="alert2" style="color: blue"></div>

</form>
<a href="index.jsp"><button>Return home</button></a>
</body>

<script>
    function wawa() {
        var variable1 = document.getElementById('input_id').value + " ";
        var variable2 = document.getElementById('id2').value + " ";
        var variable3 = document.getElementById('id3').value + " ";
        var variable = variable1 + variable2 +variable3;
        document.getElementById('alert').innerHTML = 'Sending input to the server...';
        console.log(variable)
        document.getElementById('alert2').innerHTML = 'Done.'



        // var json = JSON.stringify(variable);
        // console.log({json});
    }
</script>
<!-- <script>
    function handleSubmit(event) {
        event.preventDefault();
        var name = document.getElementById("name").value;
        console.log ({name});
        // const data = new FormData(event.target);
        // const value = Object.fromEntries(data.entries());
        // console.log({ value });
    }

const form = document.querySelector('form');
form.addEventListener('submit', handleSubmit);
</script> -->
</body>
</html>