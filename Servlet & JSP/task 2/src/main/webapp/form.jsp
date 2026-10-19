<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Data Form</title>
</head>
<body>
    <h2>Data Input Form</h2>
    <form action="result.jsp" method="POST">
        <label>Full Name:</label>
        <input type="text" name="fullName"><br><br>

        <label>Password:</label>
        <input type="text" name="password"><br><br>

        <label>Age:</label>
        <input type="text" name="age"><br><br>

        <label>Address (Radio):</label>
        <input type="radio" name="addressRadio" value="cairo"> Cairo
        <input type="radio" name="addressRadio" value="alex"> Alex
        <input type="radio" name="addressRadio" value="menofia"> Menofia<br><br>

        <label>Address (Select):</label>
        <select name="addressSelect">
            <option value="cairo">Cairo</option>
            <option value="alex">Alex</option>
            <option value="menofia">Menofia</option>
        </select><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>