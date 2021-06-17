
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Mail</h1>
<p style="color: green">${msg}</p>
<table border="1px">
    <tr>
        <th>No.</th>
        <th>Language</th>
        <th>Page size</th>
        <th>Status Spam</th>
        <th>Action</th>
    </tr>
    <c:forEach var="m" items="${mails}">
        <tr>
            <th>${m.id}</th>
            <th>${m.language}</th>
            <th>${m.pageSize}</th>
            <th>${m.enable?"Enable":"Disenable"}</th>
            <th><a href="/detail?id=${m.id}">Update</a></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
