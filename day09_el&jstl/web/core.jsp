<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
<C:set/>标签
作用：可以往域中保存数据
 域对象.setAttribute(key,value)
   scope 表示使用哪个域对象
    page         表示pageContext域
    request      表示request域
    session      表示session域
    application  表示ServletContext域
   var 表示key值
   value 表示要保存的值
--%>
保存之前:${requestScope.key1}<br>
<c:set scope="request" value="世上已千年" var="key1"/>
保存之后:${requestScope.key1}<br>
<hr>
<%--
<c:if/>标签
if标签专门用于做if判断
  test属性表示判断的表达式(要使用el表达式来写)
--%>
<c:if test="${12>11}">
<h2>上九天揽月</h2>
</c:if>
<hr>
<%
request.setAttribute("height",188);
%>
<%--
choose 表示选择判断
when 表示判断的一种条件
   test属性 表示判断条件(也是使用el表达式)
otherwise 表示剩下的情况
--%>
<%
    // 保存一个分数
    pageContext.setAttribute("score", 90);
%>
<%-- 开始判断 --%>
<c:choose>
    <%-- 如果成绩大于等于 90分 --%>
    <c:when test="${ pageScope.score >= 90 }">
        成绩为A
    </c:when>
    <%-- 如果成绩大于等于 80分 --%>
    <c:when test="${ pageScope.score >= 80 }">
        成绩为B
    </c:when>
    <%-- 如果成绩大于等于 70分 --%>
    <c:when test="${ pageScope.score >= 70 }">
        成绩为C
    </c:when>
    <%-- 如果成绩大于等于 60分 --%>
    <c:when test="${ pageScope.score >= 60 }">
        成绩为D
    </c:when>
    <%-- 其他情况 --%>
    <c:otherwise>
        成绩为E，不及格
    </c:otherwise>
</c:choose>
<hr>
<hr>
</body>
</html>
