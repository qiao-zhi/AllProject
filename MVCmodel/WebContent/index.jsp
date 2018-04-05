<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/JSP/CSS/index.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/JSP/JS/index.js">
			
		</script>
	</head>
	<body onload="startTime()">
		<div id="container">
			
			
			
			<div id="d2">
			<p id="name">太原易承信息科技有限公司</p>
			<span id="txt" style="margin-left: 0px;float: left;"></span>
			
			<%--下面这个代表用户登录 --%>
			<c:if test="${user!=null }"> 
			<span class="loginBtn">欢迎您:${user.nickname }&nbsp;&nbsp;&nbsp; </span>
			<a  href="javascript:void(0)" onclick="logout()">注销</a>
			
			</c:if>
			
			<%--用户未登录 --%>
             <c:if test="${user==null }"><a class="loginBtn" href="${pageContext.request.contextPath}/JSP/login.jsp">请您登录！</a></c:if>       
			</div>
			
			
			<div id="d1">
				<ul>
					<li><a href="">首页</a></li>
					<li><a href="">公司介绍</a></li>
					<li><a href="">产品信息</a></li>
					<li><a href="">诚聘英才</a></li>
					<li><a href="">新闻公告</a></li>
					<li><a href="">友情链接</a></li>
					<li><a href="">公司留言</a></li>
					<li><a href="">联系我们</a></li>
				</ul>
			</div>
			
			<div id="d3">
				<div id="d31">
				<table>
					<tr>
						<td><img src="../img/search.gif" alt="" /></td>
					</tr>
					<tr>
						<td>
						关键字：<input type="text" />
					    </td>
					</tr>
						<tr>
						<td>
						栏目：<select>
							<option value="xinwen">新闻/文章</option>
							<option value="chanpin">产品</option>
						</select>
					    </td>
					</tr>
					<tr>
						<td id="fenjie"><img src="../img/sear.gif" alt="" / id='sousuo'></td>
					</tr>
					<tr>
						<td><img src="../img/1.gif" alt="" / id='sousuo'>
						</td>
					</tr>
				</table>
				</div>
				<div id="d32">
					<table id="table2">
						<tr>
							<td>名称：太原易承信息科技有限公司</td>
						</tr>
							<tr>
							<td>电话:5941888</td>
						</tr>
							<tr>
							<td>地址：太原市迎泽区朝阳街北一巷8号1幢1单元1001号</td>
						</tr>
							<tr>
							<td>邮编：030024</td>
						</tr>
					</tab>
				</div>
			</div>
			
			<div id="d4">
			    <div id="d41">
				<img src="../img/logo.jpg" alt="" id="logo1"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;太原易承信息科技有限公司位于太原市迎泽区朝阳街北一巷8号1幢1单元1001号，成立于2014年5月，总投资
				一千万。坚持“客户的微笑是我们全力以赴的理由”是我们的服务理念。“天行健，君子以自强不息；地势坤，君子以厚德载物”这是龙文化，
				是中国民族文化和民族精神精髓，这也是我们所推荐的企业文化和精神。我们站在高速发展与创新的今天,创意将一如既往延续创意精神
				打造一流品牌,与客户共进退,与市场共发展。公司发展的首要目标就是让每一个员工获得可持续、更全面的发展。
			    </div>	
			
			</div>
			
			
			<div id="d5">
				地址：太原市迎泽区朝阳街北一巷8号1幢1单元1001号 &nbsp;&nbsp;&nbsp;&nbsp;  邮编：030024&nbsp;&nbsp;&nbsp;&nbsp;电话：5941888<br/>
				太原易承信息科技有限公司&nbsp;&nbsp;Copyright@ &nbsp;71AB.COM&nbsp; 版权所有 &nbsp;网络维护:&nbsp; 中国企业在线
					
			</div>
			
			
		</div>
		
		
		
	</body>
</html>