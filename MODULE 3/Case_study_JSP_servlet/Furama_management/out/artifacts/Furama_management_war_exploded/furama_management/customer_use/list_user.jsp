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
    <title>Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/webapp/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/webapp/datatables/css/dataTables.bootstrap4.min.css">
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
                <a class="nav-link" href="/employee">Employee</a>
            </li>
            <li class="nav-item mx-3">
                <a class="nav-link" href="/customer">Customer</a>
            </li>
            <li class="nav-item mx-3">
                <a class="nav-link" href="/service">Service</a>
            </li>
            <li class="nav-item mx-3">
                <a class="nav-link" href="/contract">Contract</a>
            </li>
            <li class="nav-item mx-3">
                <a class="nav-link" href="/contract">Customer Used Service</a>
            </li>
        </ul>
        <div class="flex-fill"></div>
        <form class="form-inline" action="/contract?action=search" method="post">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" name="nameFind">
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
                        <h2>Manage <b>Customers using service</b></h2>
                    </div>
                    <div class="col-sm-2">

                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover" id="tableCustomeruser" style="width: 100%">
                <thead>
                <tr>
                    <th>Id Customer</th>
                    <th>Name Customer</th>
                    <th>Name Service</th>
                    <th>Attach Service</th>
                    <th>Id Contract</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="contract" items="${contracts}">
                    <tr>
                        <td><c:out value="${contract.idCustomer}"/></td>
                        <td><c:out value="${contract.nameCustomer}"/></td>
                        <td><c:out value="${contract.nameService}"/></td>
                        <td><c:out value="${contract.nameAttachService}"/></td>
                        <td><c:out value="${contract.id}"/></td>
                        <td>
                            <a href="/service?action=editService&id=${contract.id}" class="edit"><button class="material-icons bg-success" data-original-title="Edit">Edit</button></a>
                            <a href="#deleteServiceModal" class="delete" data-toggle="modal"><button onclick="deleteService('${contract.id}','${contract.nameService}')" class="material-icons bg-danger" data-toggle="tooltip" title="" data-original-title="Edit">Del</button></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteServiceModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/service?action=delete">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <input hidden name="id" id="idservice" type="text">
                    <p>Are you sure you want to delete these Records with name is <span id="nameservice"></span>?</p>
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
<script>
    function deleteService(id,name) {
        document.getElementById("nameservice").innerText = name;
        document.getElementById("idservice").value = id;
    }
</script>
<script src="/webapp/jquery/jquery-3.5.1.min.js"></script>
<script src="/webapp/datatables/js/jquery.dataTables.min.js"></script>
<script src="/webapp/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomeruser').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
        });
    });
</script>
</body>
</html>