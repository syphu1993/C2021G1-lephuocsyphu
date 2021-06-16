<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 6/16/2021
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>No.</th>
        <th>Condiment</th>
    </tr>
<c:forEach  var="x" items="${condiment}" varStatus="no">
    <tr>
        <td>${no.count}</td>
        <td>${x}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
