<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 6/15/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Convert USD to VND</p>
<form method="post" action="/convertCash">
    <label>USD</label>
    <input type="text" name="usd">
    <label>RATE</label>
    <input type="text" name="rate">
    <input type="submit" value="Convert">
</form>

</body>
</html>
