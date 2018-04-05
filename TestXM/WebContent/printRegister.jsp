<%@page import="java.io.OutputStream"%>
<%@page import="ExcelUtil"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>print</title>

</head>

<body>
<%
/* 	out.clear();
	out = pageContext.pushBody();
	ProjectCondition condition = new ProjectCondition(); 
	
	 condition.setProjectName(request.getParameter("projectName"));
	 condition.setApplicant(request.getParameter("applicant"));
	 condition.setDomain(request.getParameter("domain"));
	 condition.setRecordDate(request.getParameter("recordDate"));
	
	condition.setPageSize(0);
	
	if (condition.getProjectName().equals("")) {
		condition.setProjectName(null);
	}
	if (condition.getApplicant().equals("")) {
		condition.setApplicant(null);
	}
	if (condition.getRecordDate().equals("")) {
		condition.setRecordDate(null);
	} else {
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(new Date());
		 int a=Integer.parseInt(condition.getRecordDate());
		 calendar.add(calendar.DATE, -a);
		 Date date = calendar.getTime();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String newDate=df.format(date);
		 condition.setRecordDate(newDate);
	}
	
	if (condition.getDomain().equals("")) {
		condition.setDomain(null);
	} 
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IProjectMapper mapper = context.getBean(IProjectMapper.class);
	List<Project> projects = mapper.getProjectInfoByIf2(condition); */
	
	response.setCharacterEncoding("iso-8859-1");
	String fileName = "验收资料登记信息导出表.xls";
	response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "iso-8859-1"));
	response.setContentType("application/x-download;charset=iso-8859-1");
	OutputStream os = response.getOutputStream(); 
	
	String[] excelHeader = {"会议名称", "项目编号", "申请验收单位", "所属领域", "申请日期", "联系人", "联系电话"};
	String sheetName = "项目基本信息";
	HSSFWorkbook wb = ExcelUtilForRegister.exportExcel(excelHeader, sheetName, null);
	wb.write(os);
%>
</body>
</html>
