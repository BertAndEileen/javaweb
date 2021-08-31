<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/20
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="http://localhost:8080/tmp/userServlet" method="post">
    用户名： <input type="text" name="username" id="username" /> <br>
    验证码：<input type="text" name="code" id="code" style="width: 80px;" />
    <img src="http://localhost:8080/tmp/kaptcha.jpg" style="width: 90px; height: 26px;" /> <br>
    <input type="submit" value="注册">
  </form>
  </body>
</html>
