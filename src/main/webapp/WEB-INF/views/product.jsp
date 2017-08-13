<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iShop - ${product.name}</title>
</head>
<body>
    <h2>${product.name}</h2>
    <h3>Цена: ${product.price} USD</h3>
    <div>
        <p>
            <strong>Характеристики:</strong> <br/>
            Цвет: ${product.color} <br/>
            Экран: ${product.display} <br/>
            Память: ${product.capacity} GB<br/>
        </p>
        <form method="post" action="<c:url value="/products/${product.id}/addToBasket"/>">
            <button type="submit">Добавить в корзину</button>
        </form>
    </div>
    <hr/>
    <div>
        <h4>Отзывы:</h4>
        <c:forEach items="${comments}" var="comment">
            <p>
                <i>${comment.dateTime.format(dateTimeFormatter)}</i>
                <strong>${comment.author}</strong> <br/>
                ${comment.text} <br/>
                <u>Оценка: ${comment.rating}</u>
            </p>
        </c:forEach>
        <h4>Оставить свой отзыв</h4>
        <form method="post" action="<c:url value="/comments"/>" >
            <p>
                <label for="name">Имя:</label>
                <input type="text" id="name" name="author"/>
            </p>
            <p>
                <label for="comment">Комментарий:</label>
                <br/>
                <textarea id="comment" name="text" rows="10" cols="30"></textarea>
            </p>
            <p>
                <label for="rating">Выставить оценку:</label>
                <select id="rating" name="rating">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option selected>5</option>
                </select>
            </p>

            <input type="hidden" name="productId" value="${product.id}">
            <button type="submit">Отправить</button>
        </form>
    </div>
</body>
</html>
