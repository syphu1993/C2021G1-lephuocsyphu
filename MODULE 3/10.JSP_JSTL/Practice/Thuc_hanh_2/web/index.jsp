<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 5/27/2021
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form action="/search" method="post">
    <input type="text" name="search" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
  </form>
  <h1> Result : ${result}</h1>
  </body>
</html>
