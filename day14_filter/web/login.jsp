<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/22
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    这是login.jsp登录页面
    <form action="http://localhost:8080/14_filter/login" method="get">
      用户名:<input type="text" name="username" id="username"/> <br>
      密码: <input type="password" name="password" id="password" /> <br>
      <input type="submit" value="登录">
    </form>
  </body>
</html>
