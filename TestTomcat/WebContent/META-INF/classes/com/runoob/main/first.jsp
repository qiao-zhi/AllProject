<%--page指令定义与页面相关的信息，JSP可以通过include指令来包含其他文件。被包含的文件可以是JSP文件、HTML文件或文本文件。包含的文件就好像是该JSP文件的一部分，会被同时编译执行。 --%>>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第一个JSP页面</title>
</head>

<body>
<h1>这是一个段落！</h1>

<%	out.println("Hello World!");%>   <br/>
   <%  out.println("\nHello World!");  %>      <br/>
   <%  out.println("实验！");  %> <br/>
    
   <% out.println("Your IP address is " + request.getRemoteAddr());%>
   
   <p>今天的日期是:<%= (new java.util.Date()).toLocaleString()%></p>
   <%--这是一个注释,在网页中不会显示 --%>
   
   
   
    <%--JSP的IF..ELSE语句--%>
   <h3>IF...ELSE 实例</h3>
   <%! int day = 3; %>
<% if (day == 1 | day == 7) { %>
      <p>今天是周末</p>
<% } else { %>
      <p>今天不是周末</p>
<% } %>


<h3>SWITCH...CASE 实例</h3>
<% 
switch(day) {
case 0:
   out.println("星期天");
   break;
case 1:
   out.println("星期一");
   break;
case 2:
   out.println("星期二");
   break;
case 3:
   out.println("星期三");
   break;
case 4:
   out.println("星期四");
   break;
case 5:
   out.println("星期五");
   break;
default:
   out.println("星期六");
}
%>


<h3>For 循环实例</h3>
<%!int fontSize;%>
<%for ( fontSize = 1; fontSize <= 3; fontSize++){ %>
   <font color="green" size="<%= fontSize %>">
    菜鸟教程
   </font><br />
<%}%>



<h3>While 循环实例</h3>
<%!int fontSize1;%>
<%while ( fontSize1 <= 3){ %>
   <font color="green" size="<%= fontSize1 %>">
    菜鸟教程
   </font><br />
<%fontSize1++;%>
<%}%>





<h2>Jsp 使用 JavaBean 实例</h2>
<jsp:useBean id="test" class="TestBean" />
 
<jsp:setProperty name="test" 
                    property="message" 
                    value="菜鸟教程..." />
 
<p>输出信息....</p>
 
<jsp:getProperty name="test" property="message" />



</body>
</html>