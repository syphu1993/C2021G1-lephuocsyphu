<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 5/27/2021
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/calculate" method="get">
    <p>First operand</p>
    <input type="text" name="a" placeholder="Nhập a">
    <p>Operator</p>
    <select name="operator">
        <option value="plus" name="plus">PLUS</option>
        <option value="sub" name="sub">SUB</option>
        <option value="mul" name="mul">MUL</option>
        <option value="div" name="div">DIV</option>
    </select>
    <p>First second</p>
    <input type="text" name="b" placeholder="Nhập b"> <br> <br>
    <input type="submit" value="Caculate">
</form>
<h1> Result : ${result}</h1>
</body>
</html>
