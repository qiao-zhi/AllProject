<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.*,javabean.Person" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.even{background-color: #FF99FF;}
.odd{background-color: #FF6633;}
tr:HOVER {
	background-color: black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<br/>-------out标签，设置default时若value==null，则输出默认值。escapeXml是是否将值进行特殊字符的转义------------------------<br/>
<% request.setAttribute("ss",null); %>
<c:out value="<a href=''>对对对</a>" escapeXml="true"></c:out>
<c:out value="${ss }" default="默认" ></c:out>


<br/>-------set标签------------------------<br/>
<%--要往域中存数据，var代表名字，value代表存的数据，scope制定存的域.----target属性指定存入的对象或者map集合,property指定属性或者对应map的关键字 --%>
<c:set var="data1"   value="xxx"  scope="page"></c:set>
${data1}
<%
Map map=new HashMap();
request.setAttribute("map",map);
%>
<c:set target="${map}" property="map数据" value="YYYY"></c:set>
${map.map数据}


<%
Person p=new Person();
request.setAttribute("person",p);
%>
<!-- 给对象增加属性 -->
<c:set target="${person}" property="name" value="狗屎"></c:set>
<!-- 删除域中数据 -->
<c:remove var="person" scope="request"/>
${person.name}



<br/>-------catch标签(捕捉异常，var指定存入域中异常对象的名字，可以用EL取出对象的message属性)------------------------<br/>
<c:catch var="myexception">
<%
int i=1/0;
%>
</c:catch>
${myexception.message}

<br/>-------choose  与  when   other wise(If...else标签)-----------------------<br/>
<c:choose>
  <c:when test="${1>3}"> ssssssssssss</c:when>
  <c:otherwise>wwwwwwwwwwwwwww</c:otherwise>
</c:choose>


<% 
List list=new ArrayList();
list.add("aaa");
list.add("bbb");
list.add("ccc");
list.add("ddd");
list.add("eee");
list.add("fff");
list.add("ggg");
request.setAttribute("list", list);
%>
<br/>-------forEach标签(迭代集合、)-----------------------<br/>
<c:forEach var="str" items="${list}">
${str}
</c:forEach>
<br/>
<!-- 用在分页时候（点的时候实现分页） -->
<c:forEach begin="1" end="10" var="num" step="1">${num  } </c:forEach>

<!-- 记住迭代信息的对象(实现表格建设) -->
<table border="1" width="20%">
<c:forEach var="str" items="${list}" varStatus="status">
<tr class="${status.count%2==0?'even':'odd' }">   <!-- ${status}获取迭代次数对象，有一个属性为count记住当前是第几次迭代 -->
<td> ${str}</td>
</tr>

</c:forEach>
</table>



<br/>------url（自动添加session的id号，防止浏览器关闭cookie。且自动在value前面加工程名字）-----------------------<br/>
<c:url var="url" value="/index.jsp">
<!-- param自动对URL进行编码 -->
<c:param name="name" value="中国"></c:param>
</c:url>
 <a href='${url}'>点击购买</a>
 
 <br/>------forTokens分割字符串-----------------------<br/>
<%request.setAttribute("data2", "aa,bb,cc,dd"); %>
<c:forTokens var='sss' items="${data2 }" delims=",">
${sss }
</c:forTokens>
 
 
</body>
</html>