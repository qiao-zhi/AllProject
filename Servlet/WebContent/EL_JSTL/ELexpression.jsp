<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="javabean.Person,javabean.Address,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<%request.setAttribute("data", "abcdc"); %>
${data }   <%--pageContext.findAttribute("data")    request\session\page\application域中查找名为data的对象 --%>
<br/>

<%//取域中对象，并读取属性 %>
<%Person person=new Person("QLQ"); %>
<%request.setAttribute("person", person); %>
${person.name }  <%//内部是  pageContext.findAyyribute("person"),然后调用get方法获取属性 %>

<br>
<%--JavaBean中包含复杂类型的读取 --%>
<%
Person person1=new Person("QLQ1");
Address address=new Address();
address.setCity("上海");
person1.setAddress(address);
request.setAttribute("person1", person1);
%>
${person1.address.city }  <%--先根据关键字person1得到person对象，再得到address属性（一个对象），再得到address的city属性 --%>
<br/>--------------------------


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
${list[0].name }---
${list[2].name }---
${list[3].name }
<br/>



<%--EL访问一个Map集合，存放对象的.El表达式用集合的关键字可以取到关键字对应的对象  --%>
<%
Map map=new HashMap();
map.put("aaa", new Person("q1"));
map.put("bbb", new Person("w1"));
map.put("ccc", new Person("e1"));
map.put("111", new Person("r1"));
request.setAttribute("map", map);
%>
${map.aaa.name }
---------${map.bbb.name }----${map.ccc.name }
<%--取关键字是数字的map集合不能用上面的EL，上面的EL适用于带字母的关键字。关键字是数字用下面的EL --%>
------${map['111'].name }  <%--EL取数据时通常用.号，.号取不出来时用[] --%>



<br/>
${pageContext.request.contextPath }   <%--取到当前工程的名字，防止工程名字写死 --%>

</body>
</html>