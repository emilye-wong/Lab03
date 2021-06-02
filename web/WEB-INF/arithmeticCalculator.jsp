<%-- 
    Document   : arithmeticCalculator
    Created on : May 28, 2021, 10:45:17 PM
    Author     : emily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            <label>First: </label>
            <input type="text" name="firstNum" value="${firstNum}"></input>
            <br>
            <label>Second: </label>
            <input type="text" name="secondNum" value="${secondNum}"></input>
            <br>
            <input type="submit" name="add" value="+"></input>
            <input type="submit" name="minus" value="-"></input>
            <input type="submit" name="multiply" value="*"></input>
            <input type="submit" name="remainder" value="%"></input>
            <br>
            <div>Result: ${result}</div>
            <a href="age">Age Calculator</a>
        </form>
    </body>
</html>
