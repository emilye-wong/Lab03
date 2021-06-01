<%-- 
    Document   : ageCalculator
    Created on : May 28, 2021, 6:00:01 PM
    Author     : emily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            <label>Enter your age: </label>
            <input type="text" name="age" value="${age}">
            <br>
            <input type="submit" name="calculate" value="Age next birthday">
            <br>
            <div>${message}</div>
            <div>${newAge}</div>
            <a href="arithmetic">Arithmetic Calculator</a>
        </form>
    </body>
</html>
