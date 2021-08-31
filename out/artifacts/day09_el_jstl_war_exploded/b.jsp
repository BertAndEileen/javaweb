<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
pageContext.setAttribute("key","pageContext");
request.setAttribute("key","request");
session.setAttribute("key","session");
application.setAttribute("key","application");
%>
${key}
</body>
</html>
