<%@page import="javafx.beans.property.SetProperty"%>
<%@page import="javabean.Person"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JavaBean的简单用法</title>
</head>
<body>

<jsp:useBean id="person" class="javabean.Person" scope="page" />

<br/>-----1----<br/>
<!-- 给上面的javaBean赋值 -->
<jsp:setProperty name="person" property="name" value="qlq" />
<jsp:setProperty name="person" property="age" value="25" />
<%--读取上面javaBean的属性 --%>>
<%=person.getName() %>
<%=person.getAge() %>


<br/><br/><br/><br/>-----2----<br/>

<!-- 给上面的javaBean赋值 (根据传过来的参数给bean赋值)。param是根据请求中的参数赋值-->
<!-- 支持8种基本数据类型的转换(把客户机提交的字符串转换成8种基本数据类型赋给javaBean的属性)-->
<jsp:setProperty name="person" property="name" param="name" />
<jsp:setProperty name="person" property="age" param="age" />
<jsp:setProperty name="person" property="birth" value="<%= new Date() %>" />

<!-- 根据对象名字与属性名字输出对应属性，等价于   person.getName()-->
<jsp:getProperty name="person" property="name"/>
<jsp:getProperty name="person" property="age"/>


<br/><br/><br/><br/>-----3----<br/>
<!--param="*"是给所有的属性赋值，没有为null -->
<jsp:setProperty name="person" property="name" param="*" />


<jsp:getProperty name="person" property="name"/>
<jsp:getProperty name="person" property="age"/>
<!-- 如果参数没有就输出null。因此取数据用EL表达式-->
<jsp:getProperty name="person" property="birth"/>

<br/>---------EL表达式读取，以下两种读取方式是等价的----<br/>
${person.name}  + ${person["name"]}

</body>
</html>