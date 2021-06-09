
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Student</title>
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
<div style="width: 40%; margin-left: 30% ;border: 1px solid black">
    <c:if test="${message!=null}">
        <p class="text-success">${message}</p>
    </c:if>
    <form method="post" style="padding: 3%">
        <div>
            <h4 >Edit Student</h4>
        </div>
        <div >
            <div class="form-group">
                <label>Id</label>
                <input readonly value="${student.id}" type="text" name="id" class="form-control" >
            </div>
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" value="${student.name}" class="form-control" >
            </div>
            <div class="form-group">
                <label>Birthday</label>
                <input type="date" value="${student.birthday}" name="birthday" class="form-control" >
            </div>
        </div>
        <div>
            <a href="/student"><input type="button" class="btn btn-danger w-25" value="Cancel"></a>
            <input type="submit" class="btn btn-success w-25" value="Update">
        </div>
    </form>
</div>
</body>
</html>
