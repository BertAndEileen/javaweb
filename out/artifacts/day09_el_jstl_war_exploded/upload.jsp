<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/6
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/day09_el&jstl/upload" method="post"
      enctype="multipart/form-data">
    用户名：<input type="text" name="username" id="username"><br>
    头像：<input type="file" name="photo" id="photo"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
