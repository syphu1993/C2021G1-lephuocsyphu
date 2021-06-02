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
<div style="width: 40%; margin-left: 30%">
    <form>
        <div>
            <h4 >Add Service</h4>
        </div>
        <div >
            <div class="form-group">
                <label>Id</label>
                <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Name of service</label>
                <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Area</label>
                <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Number of  floor</label>
                <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Max number of people</label>
                <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Fee</label>
                <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Type of rent</label>
                <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Type of service</label>
                <input type="text" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Status</label>
                <input type="text" class="form-control" required>
            </div>
        </div>
        <div>
            <a href="list.jsp"><input type="button" class="btn btn-danger w-25" value="Cancel"></a>
            <input type="submit" class="btn btn-success w-25" value="Add">
        </div>
    </form>
</div>
</body>
</html>
