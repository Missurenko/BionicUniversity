<%@ page import="edu.bionic.domain.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: bm
  Date: 17.07.17
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Каталог товаров</title>
</head>
<body>
<h1>Katalog tovarov</h1>
<ul>
<% List<Product> products = (List<Product>) request.getAttribute("products");
for(Product product:products){
   %>
    <li> =<% product.printInfo(); %> </li>
    <%

};
  %>


</ul>
</body>
</html>
