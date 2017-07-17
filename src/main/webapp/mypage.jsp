<%--
  Created by IntelliJ IDEA.
  User: bm
  Date: 14.07.17
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edu.bionic.presentation</title>
</head>
<body>
<p>You are <em>beginning to learn </em> HTML.</p>

<img src="forest-1.jpg" alt="Forest" >
<img src="forest-1.jpg" alt="Forest" >
<p>Animal</p>

<em>I <strong>really</strong> mean that</em>.

<h1>Hello ${ip}</h1>

<h1>Second  ${second}</h1>

<form action="" method="POST">
    Это будут кнопки:
    <br/><input type="radio" name="answer" value="a1">Кнопка один
    <br/><input type="radio" name="answer" value="a2">Кнопка два
    <br/><input type="radio" name="answer" value="a3">Кнопка три
    <br/>А это будет текстовое поле. Например сюда можно вводить логин
    <br/><input type="text" name="login" style="width:400px;" value="Значение по умолчанию">
    <br/>А это будет большое текстовое поле. Например сюда можно ввести информацию о себе
    <br/><input style="width:400px; height:150px" type="textarea" name="osebe" value="">
    <br/>После всего перечисленного будет кнопка ОК
    <br/><input type="submit" value="OK">
</form>

</body>
</html>
