<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 5/27/2021
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>Table Customers</h1>
<table class="table">
    <tr>
        <td>Tên</td>
        <td>Ngày sinh</td>
        <td>Địa chỉ</td>
        <td>Ảnh</td>
    </tr>
    <c:forEach var="customer" items="${customers}">
      <tr>
          <td><c:out value="${customer.name}"></c:out> </td>
          <td><c:out value="${customer.birthday}"></c:out> </td>
          <td><c:out value="${customer.adress}"></c:out> </td>
          <td><img src="<c:out value="${customer.picture}"></c:out>"></td>
      </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
