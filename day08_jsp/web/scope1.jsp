<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/2
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope1.jsp页面</h1>
<%
//向四个域中保存数据
    pageContext.setAttribute("key1","pageContext");
    request.setAttribute("key1","request");
    session.setAttribute("key1","session");
    application.setAttribute("key1","application");
%>

pageContext 域:<%=pageContext.getAttribute("key1")%>
request 域:<%=request.getAttribute("key1")%>
session 域:<%=session.getAttribute("key1")%>
application 域:<%=application.getAttribute("key1")%>

</body>
</html>
