<%--
  Created by IntelliJ IDEA.
  User: PhuSyLee
  Date: 5/26/2021
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/discount" method="post">
    <h1>Product Discount Calculator</h1>
    <p>Product Description</p>
    <input type="text" name="description" placeholder="Product Description">
    <p>List Price</p>
    <input type="text" placeholder=">List Price" value="0" name="listprice">
    <p>Discount Percent</p>
    <input type="text" placeholder="%" name="percent" value="0">
    <input type="submit" value="Calculate Discount">
  </form>
  </body>
</html>
