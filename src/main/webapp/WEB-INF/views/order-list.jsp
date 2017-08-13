<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предыдущие заказы</title>
</head>
<body>
    <h1>Предыдущие заказы</h1>
    <c:if test="${orders.size() == 0}">
        Истоиря заказов на данный момент отсутствует
    </c:if>
    <c:forEach items="${orders}" var="order">
        <p>
            <strong>Дата:</strong> ${order.dateTime.format(dateTimeFormatter)} <br/>
            <strong>Общая сумма:</strong> ${order.totalAmount} <br/>
            <strong>Товары:</strong> <br/>
            <c:forEach items="${order.products}" var="product">
                ${product.name} <br/>
            </c:forEach>
        </p>
    </c:forEach>
</body>
</html>
