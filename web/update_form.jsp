<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/12/2020
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<fieldset>
    <legend>Update product</legend>
    <form method="post">
        <input type="hidden" name="id" value="${product.getProductId()}">
        <p>Product Name</p><br>
        <input type="text" name="name" value="${product.getProductName()}">
        <p>Product Price</p><br>
        <input type="text" name="price" value="${product.getPrice()}">
        <p>Product Quantity</p><br>
        <input type="text" name="quantity" value="${product.getQuantity()}">
        <p>Product Color</p><br>
        <input type="text" name="color" value="${product.getColor()}">

        <input type="submit">

    </form>
</fieldset>
</body>
</html>
