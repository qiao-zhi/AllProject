<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>taglib.jsp</title>
</head>
<body>

<!-- a标签 -->
<s:a href="javascript:void(0)" onclick="ss();">AAAAAAA</s:a><br/>-------------<br/>

<!-- url标签 -->
<s:url action="books" namespace="/" ></s:url><br/>-------------<br/>
<!-- property标签输出信息 -->
<s:property escape="true" value="'<a href=\"www.baidu.com\">AAA</a>'"/>

<s:sort comparator="#priceCoparator" source="#books">
   <s:property value="price"/>
</s:sort>

<%--action指定books.action --%>
<s:form action="books" namespace="/" method="post">
<!-- 可以用key代替label实现国际化 -->

<!-- label指定文本框前面的名字，不用加冒号，JSP自动添加 -->
<s:textfield label="名字" name="username"></s:textfield>
<s:password label="密码" name="password"></s:password>

<s:textarea label="评论" cols="10" rows="5"></s:textarea>
<!-- 多选框 -->
<s:checkbox name="fav" value="0" label="体育"></s:checkbox>
<s:checkbox name="fav" value="1" label="音乐" ></s:checkbox>

<!-- 多选框2 List -->
<s:checkboxlist list="{'Java','PHP','struts'}" name="list" value="{'Java','PHP'}"></s:checkboxlist>
<s:submit value="提交"></s:submit>

<!-- 多选框2(map) -->
<s:checkboxlist list="#{1:'大王',2:'小王',3:'王炸'}" name="map" listKey="key"
 listValue="value" value="{1,3}"
 ></s:checkboxlist>
 
 
 <!-- 单选框1List -->
<s:radio list="{'Java','PHP','struts'}" name="list" value="{'Java'}"></s:radio>


<!-- 单选框2(map) -->
<s:radio list="#{1:'大王',2:'小王',3:'王炸'}" name="map" listKey="key"
 listValue="value" value="{3}"
 ></s:radio>
 
 <!-- 下拉列表框，默认C选中 -->
 <s:select list="{'Java','C++','C'}" name="language" value="{'C'}"></s:select>
 
 
 
 
<s:submit value="提交"></s:submit>

</s:form>

</body>
</html>