<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/Oraclefenye/themes/default/easyui.css" type="text/css" rel="stylesheet">
<link href="/Oraclefenye/themes/icon.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<title>easyui+Oracle分页</title>
</head>
<body>
<table id="dg"></table>  
<script type="text/javascript">
$('#dg').datagrid({    
    url:'/Oraclefenye/EmpServlet?time=' + new Date().getTime(),  
    columns:[[    
        {field:'id',title:'编号',width:100},    
        {field:'name',title:'姓名',width:100},    
        {field:'hiredate',title:'入职时间',width:100}    
    ]],
    fitColumns:true,
    pagination:true,
    singleSelect:true,
    pageSize:5,
    pageList:[5]
});  
</script>

</body>
</html>