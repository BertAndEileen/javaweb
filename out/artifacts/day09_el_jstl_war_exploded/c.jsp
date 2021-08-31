<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/5
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setId(100);
    person.setPhones(new String[]{"182290930","2128782178"});
    List<String> cities=new ArrayList<>();
    cities.add("北京");
    cities.add("上海");
    cities.add("广州");
    cities.add("深圳");
    person.setCities(cities);
    Map<String,Object> map=new HashMap<>();
    map.put("a","avalue");
    map.put("b","bvalue");
    map.put("c","cvalue");
    person.setMap(map);
    request.setAttribute("p",person);
%>
输出person对象:${p}<br>
输出id属性：${p.id}<%--100--%>
输出phones属性的值:${p.phones[0]}<%--182290930--%>
输出list集合的值：${p.cities}<%--[北京, 上海, 广州, 深圳]--%>
输出list元素的值：${p.cities[0]}<%--北京--%>
输出map集合的值：${p.map}<%--{a=avalue, b=bvalue, c=cvalue}--%>
输出map集合某个key的值：${p.map.a}<%--avalue--%>

</body>
</html>
