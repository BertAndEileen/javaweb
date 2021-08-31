<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--java获取信息方式
    request.getScheme()  获取请求的协议
    request.getServername() 获取服务器的ip
    request.getServerPort() 获取服务器的端口号
    request.getContextPath() 获取工程的路径
    request.getMethod() 获取请求的方法get和method
    request.getRemoteHost() 获取客户端ip地址
    session.getId() 获取会话的id
--%>
<%=request.getScheme()%><br>
<%
pageContext.setAttribute("req",request);//为了下面el简短
%>
<%--el获取信息方式--%>
1.协议：${req.scheme}<br>
2.服务器ip：${pageContext.request.serverName}<br>
3.服务器端口：${pageContext.request.serverPort}<br>
4.获取工程路径：${pageContext.request.contextPath}<br>
5.获取请求方法：${pageContext.request.method}<br>
6.获取客户端ip地址：${pageContext.request.remoteHost}<br>
7.获取会话的id编号：${pageContext.request.id}<br>
</body>
</html>
