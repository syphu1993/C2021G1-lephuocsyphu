
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Service</title>
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
            <h4 >Add Service</h4>
        </div>
        <div >
            <div class="form-group">
                <label>Id</label>
                <input type="text" name="id" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Area</label>
                <input type="text" name="area" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Cost</label>
                <input type="text" name="cost" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Max People</label>
                <input type="text" name="maxPeople" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Rent type</label>
                <select name="rentType" class="form-control">
                    <option>Hour</option>
                    <option>Day</option>
                    <option>Month</option>
                </select>
            </div>
            <div class="form-group">
                <label>Service type</label>
                <select name="serviceType" class="form-control">
                    <option>VIP</option>
                    <option>Normal</option>
                </select>
            </div>
            <div class="form-group">
                <label>Standard room</label>
                <input type="text" name="standard" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Decription other convenient</label>
                <input type="text" name="decription" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Area pool</label>
                <input type="text" name="pool" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Number of floor</label>
                <input type="text" name="floor" class="form-control" required>
            </div>
        </div>
        <div>
            <a href="/service"><input type="button" class="btn btn-danger w-25" value="Cancel"></a>
            <input type="submit" class="btn btn-success w-25" value="Add">
        </div>
    </form>
</div>
</body>
</html>
