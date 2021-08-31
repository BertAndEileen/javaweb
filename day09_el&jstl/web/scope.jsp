<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
request.setAttribute("a","a1");
session.setAttribute("b","b1");
//java里这样取值
request.getAttribute("a");
%>
<%--EL里这样取值--%>
 ${requestScope.a}
${sessionScope.b}
</body>
</html>
