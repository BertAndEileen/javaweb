<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/20
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="http://localhost:8080/13_cookie_session/userServlet"
          method="post">
        用户名：<input type="text" name="username" id="username"
                   value="${cookie.username.value}"/> <br>
        密码：<input type="password" name="password" id="password" /> <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
