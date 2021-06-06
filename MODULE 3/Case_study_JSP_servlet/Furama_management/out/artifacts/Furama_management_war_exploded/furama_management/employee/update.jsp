<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 6/2/2021
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Employees</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
            crossorigin="anonymous"></script>
</head>
<body>
<div style="width: 40%; margin-left: 30%;border: 1px solid black">
    <c:if test="${message!=null}">
        <p>${message}</p>
    </c:if>
    <form method="post" style="padding: 3%">
        <div>
            <h4 >Update Employee</h4>
        </div>
        <div >
            <div class="form-group">
                <label>Id</label>
                <input disabled type="text" value="${employee.id}" name="id" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Name</label>
                <input type="text" value="${employee.name}" name="name" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Birthday</label>
                <input type="text" value="${employee.birthday}" name="birthday" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Id Card</label>
                <input type="text" value="${employee.idCard}" name="idCard" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Salary</label>
                <input type="text" value="${employee.salary}" name="salary" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Phone</label>
                <input type="text" value="${employee.phone}" name="phone" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" value="${employee.email}" name="email" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Address</label>
                <input type="text" value="${employee.address}" name="address" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Position</label>
                <select name="position" class="form-control">
                    <c:forEach items="${positions}" var="position">
                        <option value="${position}" ${employee.position.equals(position)?"selected":""}>${position}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Education Degree</label>
                <select name="degree" class="form-control">
                    <c:forEach items="${degrees}" var="degree">
                        <option value="${degree}" ${employee.degree.equals(degree)?"selected":""}>${degree}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Division</label>
                <select name="division" class="form-control">
                    <c:forEach items="${divisions}" var="division">
                        <option value="${division}" ${employee.division.equals(division)?"selected":""}>${division}</option>
<%--                        <c:choose>--%>
<%--                            <c:when test="${employee.division.equals(division)}">--%>
<%--                                <option value="${division}" selected>${division}</option>--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <option value="${division}">${division}</option>--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>User Name</label>
                <input disabled type="text" value="${employee.username}" name="user" class="form-control" required>
            </div>
        </div>
        <div>
            <a href="/employee"><input type="button" class="btn btn-danger w-25" value="Cancel"></a>
            <input type="submit" class="btn btn-success w-25" value="Update">
        </div>
    </form>
</div>
</body>
</html>
