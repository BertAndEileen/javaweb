<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/30
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    //全局变量
 private Integer id;
 private static Map<String,Object> map;
   //静态代码块
    static{
        map=new HashMap<>();
        map.put("key","1value");
        map.put("key","2value");
   }
%>
<%!
//声明方法
    public int fun(){
       return 18;
    }
%>
<%!
//声明内部类
    public static class T

    {
        private Integer id;
        private String name;
    }
%>


<%=12%><br>
<%=12.12%><br>
<%="我是字符串"%><br>
<%=map%>


<%
//1.代码脚本，if语句，
    int i=12;
    if(i==12){
        System.out.println("时间淹没众生");
    }else {
        System.out.println("，英雄才能永存");
    }
%>
<%
//2.代码脚本，for循环语句，
    for(int j=0;j<=10;j++){
        System.out.println("j="+j);
    }
%>
</body>
</html>
