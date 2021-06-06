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
    <title>Add Contract</title>
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
            <h4 >Add Contract</h4>
        </div>
        <div >
            <div class="form-group">
                <label>Start Date</label>
                <input type="text" name="startDate" class="form-control" required>
            </div>
            <div class="form-group">
                <label>End Date</label>
                <input type="text" name="endDate" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Deposit</label>
                <input type="text" name="deposit" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Total  Money</label>
                <input type="text" name="total" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Employee contract</label>
                <select name="employeeId" class="form-control">
                    <option selected></option>
                    <c:forEach items="${employees}" var="employee">
                        <option value="${employee.id}">${employee.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Customer contract</label>
                <select name="customerId" class="form-control">
                    <option selected></option>
                    <c:forEach items="${customers}" var="customer">
                        <option value="${customer.id}">${customer.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Service is contracted </label>
                <select name="serviceId" class="form-control">
                    <c:forEach items="${services}" var="service">
                        <option value="${service.id}">${service.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div>
            <a href="/contract"><input type="button" class="btn btn-danger w-25" value="Cancel"></a>
            <input type="submit" class="btn btn-success w-25" value="Add">
        </div>
    </form>
</div>
</body>
</html>
