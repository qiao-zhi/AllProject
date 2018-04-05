<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="/WEB-INF/TagExample.tld" prefix="qlq" %>
  <%@ page import="java.util.*" %>
  
  
  <!-- 防盗链 -->
  <%--site是防盗链的网站(上一个网站不是以site开头跳到page)，page是要跳转到那个网站 --%>
 <qlq:referer site="http://localhost" page="/index.jsp"></qlq:referer>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>凤姐日记</title>
</head>
<body>

<%--模仿用户登录 --%>
<%
session.setAttribute("user","sssssss");
%>


<!-- if标签 -->
<%-- IF标签，判断标签--%>
 <qlq:if test="${user!=null }">
凤姐 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  凤姐
</qlq:if>




<!-- 自定义的If..else标签 -->
<qlq:choose>
  <qlq:ChooseIf test="${ssss==null }">AAAAAAAAAAAAAAAAAA</qlq:ChooseIf>
  <qlq:else>BBBBBBBBBBBBBBBB</qlq:else>
</qlq:choose>

<%
List list = new ArrayList();
list.add("aaaaaaaaaaaaaaa");list.add("bbbbbbbbbbbbbb");
list.add("cccccccccccccccc");list.add("ddddddddddddddd");
request.setAttribute("list", list);

%>



<%--迭代List集合标签 --%>
<qlq:IteratorList items="${list}" var="str">
${str }
</qlq:IteratorList>
<br/>---------------迭代list集合-------------------------<br/>

<%--foreach迭代器迭代LiSt\map\array --%>
<%
List list1 = new ArrayList();
list1.add("aaaaaaaaaaaaaaa");list1.add("bbbbbbbbbbbbbb");
list1.add("cccccccccccccccc");list1.add("ddddddddddddddd");
request.setAttribute("list1", list1);
%>
<qlq:foreach items="${list}" var="str">
${str }
</qlq:foreach>


<br/>---------------迭代int基本数据类型集合-------------------------<br/>
<%--foreach迭代器迭代LiSt\map\array --%>
<%
int a[]={1,1,5,1,4};
request.setAttribute("a", a);
%>
<qlq:foreach items="${a}" var="str">
${str }
</qlq:foreach>



<br/>---------------迭代map集合-------------------------<br/>
<%--foreach迭代器迭代LiSt\map\array --%>
<%
Map map=new HashMap();
map.put("1", "aaaa");map.put("2", "bbbb");map.put("3", "cccc");map.put("4", "dddd");
request.setAttribute("map", map);
%>
<qlq:foreach items="${map}" var="entry">
${entry.key}=${entry.value}
</qlq:foreach>


<br/>---------------迭代char[]数组-------------------------<br/>
<%--foreach迭代器迭代LiSt\map\array --%>
<%
char ch[]={'s','s','d'};
request.setAttribute("ch", ch);
%>
<qlq:foreach items="${ch}" var="ch">
${ch }
</qlq:foreach>

<br/>---------------输出HTML标签-------------------------<br/>

<qlq:html>
<a href="">diandian</a>
</qlq:html>


</body>
</html>