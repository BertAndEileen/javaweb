<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/15
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--添加base标签,
base标签一定在title标签的下面,紧跟着title标签
baase标签的值,一般在项目中,都设置到工程路径.也就是映射到IDEA代码的web目录
-->
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath", basePath);
%>

<base href="${ basePath }">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/script/jquery-1.7.2.js"></script>

