<%@page import="java.io.OutputStream"%>
<%@page import="com.thinkPro.steap.common.ExcelUtil"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="com.thinkPro.steap.db.service.impl.project.ProjectServiceImpl"%>
<%@page import="com.thinkPro.steap.bean.project.Project" %>
<%@page import="com.thinkPro.steap.bean.project.ProjectCondition" %>
<%@page import="com.thinkPro.steap.db.mapper.project.IProjectMapper" %>
<%@page import="org.springframework.context.ApplicationContext" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@page import="com.thinkPro.steap.action.perfectMaterial.excelUtils.ExcelUnitForSearch" %>
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
	out.clear();
	out = pageContext.pushBody();
	ProjectCondition condition = new ProjectCondition(); 
	
	condition.setProjectName(request.getParameter("projectName"));
	 condition.setApplicant(request.getParameter("applicant"));
	 condition.setDomain(request.getParameter("domain"));
	 condition.setRecordDate(request.getParameter("recordDate"));
	 condition.setChargePerson(request.getParameter("chargePerson"));
	
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
	if (condition.getChargePerson() == null) {
		condition.setChargePerson("未知");
	}
	
	condition.setProjectStatus("100008");
	condition.setPageSize(0);
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IProjectMapper mapper = context.getBean(IProjectMapper.class);
	List<Project> projects = mapper.getProjectInfoByIf(condition);
	
	response.setCharacterEncoding("iso-8859-1");
	String fileName = "完善项目信息导出表.xls";
	response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "iso-8859-1"));
	response.setContentType("application/x-download;charset=iso-8859-1");
	OutputStream os = response.getOutputStream(); 
	
	String[] excelHeader = {"项目名称", "项目编号", "申请验收单位", "所属领域", "登记日期", "经费", "联系电话"};
	String sheetName = "项目基本信息";
	HSSFWorkbook wb = ExcelUnitForSearch.exportExcel(excelHeader, sheetName, projects);
	wb.write(os);
%>
</body>
</html>
