<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

    </style>
</head>
<body>
<%--  遍历1-10
begin属性 设置遍历的开始索引
end属性   设置遍历的结束索引
var属性   设置当前遍历到的数据
--%>
<c:forEach begin="1" end="10" var="i">
   ${i}
</c:forEach>

<%--遍历对象数组--%>
<%
request.setAttribute("arr",new String[]{"西游记","水浒传","红楼梦"});
%>
<c:forEach items="${requestScope.arr}" var="item">
${item}
</c:forEach>
<hr>

<%
    Map<String,Object> map=new HashMap<>();
    map.put("a","avalue");
    map.put("b","bvalue");
    request.setAttribute("map",map);
%>
<%--遍历map集合--%>
<c:forEach items="${requestScope.map}" var="entry">
    ${entry}<br>
</c:forEach>
<hr>
<%--遍历list集合--%>
<%
    List<Student> studentList=new ArrayList<>();
    for (int i = 1; i <=20 ; i++) {
        studentList.add(new Student(i,"name"+i,"pass"+i,18+i,"phone"+i));
    }
    request.setAttribute("stus",studentList);
%>
<%--
 items表示遍历到的数据源
 var 表示当前遍历到的数据
--%>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>电话</th>
        <th>操作</th>
    </tr>
<c:forEach items="${requestScope.stus}" var="stu">
    <tr>
        <td> ${stu.id}</td>
        <td>${stu.name}</td>
        <td>${stu.password}</td>
        <td>${stu.age}</td>
        <td>${stu.phone}</td>
        <td>删除，修改</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
