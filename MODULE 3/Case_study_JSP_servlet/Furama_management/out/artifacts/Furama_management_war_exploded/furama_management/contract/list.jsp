<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 5/31/2021
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contract</title>
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
    <div class="container-fluid bg-success" style="height: 80px">
        <div class="row">
            <div class="card col-lg-2 ">
                <img src="/img/logo.PNG" style="height: 80px">
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
            <li class="nav-item ml-5 mr-3">
                <a class="navbar-brand text-white" href="/index.jsp">Home</a>
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
        <div class="flex-fill"></div>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-success" type="submit">Search</button>
        </form>
    </nav>
</header>

<div class="container-fluid" style="padding-top: 163px">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-10">
                        <h2>Manage <b>Contract</b></h2>
                    </div>
                    <div class="col-sm-2">
                        <a href="/furama_management/contract/create.jsp" class="btn btn-success"><i class="material-icons"></i> <span>Add New Contract</span></a>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Start Date</th>
                    <th>Finish Date</th>
                    <th>Deposit</th>
                    <th>Extra Fee</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>1</th>
                    <th>01-01-2018</th>
                    <th>05-05-2018</th>
                    <th>2000000</th>
                    <th>200000</th>
                    <td>
                        <a href="/furama_management/contract/update.jsp" class="edit"><button class="material-icons bg-success" data-original-title="Edit">Edit</button></a>
                        <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><button class="material-icons bg-danger" data-toggle="tooltip" title="" data-original-title="Edit">Del</button></a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
