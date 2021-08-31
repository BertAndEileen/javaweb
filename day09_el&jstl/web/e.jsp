<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    1.值为null的情况.
    request.setAttribute("emptyNull",null);
//    2.值为空串
    request.setAttribute("emptyStr","");
//    3.值是Object类型的数组,且长度为零
    request.setAttribute("emptyArr",new Object[]{});
//    4.list集合,元素个数为零
    List<String> list=new ArrayList<>();
    request.setAttribute("emptyList",list);
//    5. map集合,元素个数为零
    Map<String,Object> map=new HashMap<>();
    request.setAttribute("emptyMap",map);

%>
${empty emptyNull}<br> <%--true--%>
${empty emptyStr}<%--true--%>
${empty emptyArr}
${empty emptyList}
${empty emptyMap}
${12==12 ? "时间淹没众生" : "英雄必将永存"}
</body>
</html>
