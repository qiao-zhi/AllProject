<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
Success!
<!-- 取国际化文件内容 ,取键为aa的内容-->
<s:text name="aa"></s:text><br/>
<s:text name="welcome">
<s:param>乔利强2</s:param>
<s:param>学习吧</s:param>
</s:text><br/>


<!-- struts的自定义文本框，前面带的为aa在properties文件中对应的值 -->
<s:textfield name="username" key="aa"></s:textfield>

<br/>-----------访问包范围-----<br/>
<s:i18n name="Action/package">
	<s:text name="package"></s:text>
</s:i18n>

<br/>-----------访问全局资源文件----<br/>
<s:i18n name="aa">
	<s:text name="aa"></s:text><br/>
	<s:text name="welcome">
		<s:param>乔利强</s:param>
		<s:param>学习</s:param>
	</s:text>
</s:i18n>
</body>
</html>