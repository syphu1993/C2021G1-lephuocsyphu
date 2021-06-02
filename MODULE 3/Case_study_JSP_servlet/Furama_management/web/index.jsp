<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 5/30/2021
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Furama Home Page</title>
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
<header class="position-fixed w-100" style="top: 0">
  <div class="container-fluid bg-info" style="height: 80px">
    <div class="row">
      <div class="card col-lg-2 ">
        <img src="img/logo.PNG" style="height: 80px">
      </div>
      <div class="col-lg-8">

      </div>
      <div class="col-lg-2 d-flex justify-content-center text-center my-4">
        <h4> Nguyễn văn A</h4>
      </div>
    </div>
  </div>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark align-self-end justify-content-between">
    <ul class="navbar-nav">
      <li class="nav-item" style="margin-left:62px">
        <a class="navbar-brand text-white" href="/">Home</a>
      </li>
      <li class="nav-item mr-3" style="margin-left:75px ">
        <a class="nav-link" href="/furama_management/employee/list.jsp">Employee</a>
      </li>
      <li class="nav-item mx-3">
        <a class="nav-link" href="/furama_management/customer/list.jsp">Customer</a>
      </li>
      <li class="nav-item mx-3">
        <a class="nav-link" href="/furama_management/service/list.jsp">Service</a>
      </li>
      <li class="nav-item mx-3">
        <a class="nav-link" href="/furama_management/contract/list.jsp">Contract</a>
      </li>
    </ul>
    <form class="form-inline my-2" action="/">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-success" type="submit">Search</button>
    </form>
  </nav>
</header>

<div class="container-fluid" style="padding-top: 150px;">
  <div class="row">
    <div class="col-lg-2 bg-info"
         style="height: calc(100vh - 176px); overflow: auto;">
      <div>
        <h1> Item 1</h1>
      </div>
      <div>
        <h1> Item 2</h1>
      </div>
      <div>
        <h1> Item 3</h1>
      </div>
    </div>
    <div class="col-lg-10">

    </div>
  </div>
</div>

<footer>
  <div class="container-fluid bg-dark position-fixed text-center" style="height: 40px ; bottom: 0">
    <h6 class="mt-2">Footer</h6>
  </div>
</footer>

</body>
</html>
