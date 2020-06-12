<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/12/2020
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<fieldset>
    <legend>Add new product</legend>
    <form method="post">
        <p>Product Name</p><br>
        <input type="text" name="name">
        <p>Product Price</p><br>
        <input type="text" name="price">
        <p>Product Quantity</p><br>
        <input type="text" name="quantity">
        <p>Product Color</p><br>
        <input type="text" name="color">
        <p>Product Category</p><br>
        <select name="category">
            <option value="mobile">Mobile</option>
            <option value="television">Television</option>
        </select>
        <input type="submit">

    </form>
</fieldset>
</body>
</html>
