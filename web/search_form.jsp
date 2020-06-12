<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/12/2020
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<form method="post">
    <input type="text" name="name"><br>
    <input type="submit">
</form>
<c:if test='${requestScope["products"] != null}'>
    <fieldset>
        <legend>Product Result</legend>
        <table border="1" class="table-hover">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Quantity</th>
                <th>Product Color</th>
                <th>Product Category</th>
                <th colspan="2">Action</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.getProductId()}</td>
                    <td>${product.getProductName()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getQuantity()}</td>
                    <td>${product.getColor()}</td>
                    <td>${product.getCategory()}</td>
                    <td><a href="/command?action=update&id=${product.getProductId()}">Update Product</a></td>
                    <td><a href="/command?action=delete&id=${product.getProductId()}">Delete Product</a></td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</c:if>
</body>
</html>
