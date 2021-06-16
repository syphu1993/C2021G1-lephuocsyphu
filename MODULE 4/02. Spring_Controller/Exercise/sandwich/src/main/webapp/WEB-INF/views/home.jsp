<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 6/16/2021
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/choose">
    Sandwich Condiments:<br/>
    <label><input name="condiment" value="letutce" type="checkbox" checked/> Letutce</label> <br/>
    <label><input name="condiment" value="tomato" type="checkbox"/> Tomato</label> <br/>
    <label><input name="condiment" value="mustard" type="checkbox"/> Mustard</label> <br/>
    <label><input name="condiment" value="sprouts" type="checkbox"/> Sprouts</label> <br/>
    <input type="submit" value="Save">
</form>
</body>
</html>
