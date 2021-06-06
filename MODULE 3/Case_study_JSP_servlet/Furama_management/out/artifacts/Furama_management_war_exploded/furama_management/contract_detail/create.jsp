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
    <title>Add Contract Detail</title>
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
            <h4 >Add Contract Detail</h4>
        </div>
        <div >
            <div class="form-group">
                <label>Contract Id</label>
                <input type="text" value="${contract.id}" name="idContract" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Attach service</label>
                <select name="aContract" class="form-control">
                    <c:forEach items="${aContracts}" var="aContract">
                        <option value="${aContract[0]}">${aContract[1]}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Quantity</label>
                <input type="text" name="quantity" class="form-control" required>
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
