<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
获取请求参数username的值：${param.username}<br>
${paramValues.username[0]}<br>
<hr>
<hr>
获取请求头host的值：${header.host}<br>
获取请求头user-Agent的值：${header.['user-agent']}<br>
获取请求头Accept的值：${header.Accept}<br>
<hr>
</body>
</html>
