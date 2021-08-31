<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
   request.setAttribute("key","data");
   %>
jsp表达式脚本输出：<%=request.getAttribute("key")%><br>
El表达式输出：${key}<br>
</body>
</html>
