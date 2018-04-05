<%@page import="javafx.beans.property.SetProperty"%>
<%@page import="javabean.Person"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JavaBean的简单用法</title>
</head>
<body>


<%--这句之后肯定有一个person，如果能找到就创建一个，对象名字是id对应的名字.如果找不到就创建一个空的对象。scope定义对象的域，4个域范围  --%>
<%-- 两个标签中间的代码只在第一次实例化对象的时候才有效，第二次调用时无效(标签体) --%>
<jsp:useBean id="person" class="javabean.Person" scope="page" >aaa</jsp:useBean>

<%--获取上面对象的属性与方法 --%>
<%=person.getName() %>




</body>
</html>