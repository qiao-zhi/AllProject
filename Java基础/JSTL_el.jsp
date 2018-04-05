<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="javabean.Person,javabean.Address,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EL迭代List与Map集合</title>
</head>
<body>
<%--访问一个list集合 --%>
<%
List<Person> list=new ArrayList<Person>();
list.add(new Person("aaa"));
list.add(new Person("bbb"));
list.add(new Person("ccc"));
list.add(new Person("ddd"));
list.add(new Person("eee"));
request.setAttribute("list", list);
%>


<%--items用于迭代的变量，var代表每次迭代之后存放名字 --%>
<c:forEach items="${list }" var="person"> 
${person.name }
</c:forEach>

<br/>--------------<br/>
<%--EL访问一个Map集合，存放对象的.El表达式用集合的关键字可以取到关键字对应的对象  --%>
<%
Map<String,Person> map=new HashMap<String,Person>();
map.put("aaa", new Person("q1"));
map.put("bbb", new Person("w1"));
map.put("ccc", new Person("e1"));
map.put("111", new Person("r1"));
request.setAttribute("map", map);
%>
<c:forEach var="entry" items="${map }"> 
<%--上面取出来的是Set(Map.entry)集合，即使关键字加对象组成的集合。再取出关键字（.key），再用.value取出一个对象，用.name取出对象的名字 --%>
${entry.key }:${entry.value.name }--------
</c:forEach>



//代表用户登录
<c:if test="${user!=null }">
欢迎您:${user.name }
</c:if>


//代表用户没有登录
<c:if test="${user==null }">
请您登录！
</c:if>



</body>
</html>