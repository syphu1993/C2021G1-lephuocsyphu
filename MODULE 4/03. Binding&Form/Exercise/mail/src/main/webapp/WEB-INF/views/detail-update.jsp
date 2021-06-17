<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 6/17/2021
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Deatail and update mail</h1>

<form:form action="/update" method="post" modelAttribute="mail">
    <form:hidden path="id"></form:hidden>

    <label>Language:</label>
    <form:select path="language">
        <form:option value="English" >English</form:option>
        <form:option value="France" >France</form:option>
        <form:option value="Japanese" >Japanese</form:option>
        <form:option value="VietNamese" >VietNamese</form:option>
    </form:select> <br><br>
    <label>Page Size:</label>
    <form:select path="pageSize">
        <form:option value="10" >10</form:option>
        <form:option value="15" >15</form:option>
        <form:option value="25" >25</form:option>
        <form:option value="50" >50</form:option>
    </form:select> <br><br>
    <label>Spam:</label>
    <form:checkbox path="enable" value="${mail.enable}"></form:checkbox><label>Enable Spam</label><br><br>
    <label>Content:</label>
    <form:textarea path="signature"></form:textarea> <br><br>

    <input type="submit" value="Update">
</form:form>
<a  href="/"><button>Cancel</button></a>
</body>
</html>
