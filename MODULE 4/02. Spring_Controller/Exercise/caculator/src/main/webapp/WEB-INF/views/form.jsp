<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 6/16/2021
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/act", method="post">
    <input type="text" name="a">
    <input type="text" name="b"> <br> <br> <br>
    <input type="submit" name="operate" value="Add(+)">
    <input type="submit" name="operate" value="Sub(-)">
    <input type="submit" name="operate" value="Mul(*)">
    <input type="submit" name="operate" value="Div(/)">
</form>
<p>Result: ${result} </p>
</body>
</html>
