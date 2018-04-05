<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	// 获取请求的上下文(项目名字)
	String context = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分页查询</title>
</head>
<link href="css/pagination.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" charset="utf-8">
<link href="../css/pagination.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="../js/jquery.pagination.js"></script>
	<script type="text/javascript">

	var $j = jQuery.noConflict(); 
	// 点击分页按钮以后触发的动作
	function handlePaginationClick(new_page_index, pagination_container) {
	    $j("#stuForm").attr("action", "<%=context %>/jdbcSql/JdbcSqlServlet?pageNum=" + (new_page_index+1));
	    $j("#stuForm").submit();
	    return false;
	}

	$j(function(){
		$j("#News-Pagination").pagination(${result.totalRecord}, {
	        items_per_page:${result.pageSize}, // 每页显示多少条记录
	        current_page:${result.currentPage} - 1, // 当前显示第几页数据
	        num_display_entries:8, // 分页显示的条目数
	        next_text:"下一页",
	        prev_text:"上一页",
	        num_edge_entries:2, // 连接分页主体，显示的条目数
	        callback:handlePaginationClick
		});

	});
	</script>
</script>
<body>


 	<form action="<%=context %>/sublist/SublistServlet"   id="stuForm"  method="post">    
       <input type="submit" value="查询">    
    </form>
    
    学生信息列表:<br/>
   <c:if test="${fn:length(result.dataList) eq 0 }">
    <span>查询的结果不存在</span>
   </c:if>
   
  	<c:if test="${fn:length(result.dataList) gt 0 }">
         <table border="1" width="40%" >
           <tr>    
              <td>id</td>  
              <td>名字</td>  
              <td>性别</td>  
              <td>年龄</td>         
              <td>地址</td>     
           </tr>
           <c:forEach items="${result.dataList}" var="student">
               <tr>
                  <td><c:out value="${student.id }"></c:out> </td>
                  <td><c:out value="${student.stuName }"></c:out> </td>
                  <td><c:if test="${ student.gender eq 1}">男</c:if>
					   <c:if test="${ student.gender eq 2}">女</c:if>
				  </td>
                  <td><c:out value="${student.age }"></c:out> </td>
                  <td><c:out value="${student.address }"></c:out> </td>
               </tr>
           </c:forEach>
         </table>   
         <br> 共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
         <div id="News-Pagination"></div>
   	</c:if>
</body>
</html>