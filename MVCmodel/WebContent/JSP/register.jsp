<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/JSP/JS/jedate.js">	</script>				
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/JSP/CSS/register.CSS"/>
	</head>
	<body>
		<!--先用一个大的div把网页页面圈起来，网页居中，内容居左-->
	<div id="container">
              
      <form action="${pageContext.request.contextPath }/Servlet/RegisterServlet" method="post">
      	  <br/><br/><br/> 请填写注册信息。（带<span>*</span>的为必填）<br/><br/><br/>
                       用 户 名：	<input type="text" name="username" value="${form.username }"/><span>* ${form.errors.username }</span><br/><br/>
                       密 &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 	码: <input type="password" name="password" value="${form.password }"/><span> *  ${form.errors.password }</span><br/><br/>
                      确认密码: <input type="password" name="password2" value="${form.password2 }"/><span> * ${form.errors.password2 } </span><br/><br/>             
                       邮&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 箱：<input type="text" name="email" value="${form.email }"/><span> * ${form.errors.email } </span><br/><br/>
                       生&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 日：	<input  value="${form.birthday }" class="datainp" id="datebut" name="birthday" type="text" placeholder="请选择" onClick="jeDate({dateCell:'#datebut',isTime:false,format:'YYYY-MM-DD'})" readonly><span> ${form.errors.birthday }</span> 
              <br/>  <br/>   匿&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 名: <input type="text" name="nickname" value="${form.nickname }"/><span> ${form.errors.nickname }</span><br/><br/><br />
              <input type="submit" style="width:80px;margin-right: 10px" id="" value="提交" />
              <!--添加一个返回按钮-->
              <input style="width:80px"  type="button" name="" id="" value="返回"  onclick="window.location='${pageContext.request.contextPath}/JSP/login.jsp'"/>
      </form>   
      
    
    
              

	</div>								
	</body>
</html>