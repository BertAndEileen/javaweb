<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String,Object> map=new HashMap<>();
    map.put("a+b","a1");
    map.put("b-b","b1");
    map.put("c*b","c1");
    request.setAttribute("map",map);
%>
${map}<br>
${map.["a+b"]}<br>
${map.['b-b']}<br>
${map.['c*b']}<br>
</body>
</html>
