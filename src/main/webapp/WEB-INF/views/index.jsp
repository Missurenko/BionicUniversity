<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Магазин iShop</title>
</head>
<body>
<h1>Welcome to iShop</h1>
<ul>
    <li><a href="<c:url value="/products"/>">Каталог товаров</a></li>
    <li><a href="<c:url value="/orders"/> ">Предыдущие заказы</a></li>
</ul>
</body>
</html>
