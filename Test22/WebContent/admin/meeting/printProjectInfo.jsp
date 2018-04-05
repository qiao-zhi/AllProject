<%@page import="java.io.OutputStream"%>

<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="com.thinkPro.steap.db.service.impl.project.ProjectServiceImpl"%>
<%@page import="com.thinkPro.steap.bean.project.ProjectCondition" %>
<%@page import="com.thinkPro.steap.bean.meeting.ProjectInfoResult" %>
<%@page import="com.thinkPro.steap.db.mapper.project.IProjectMapper" %>
<%@page import="org.springframework.context.ApplicationContext" %>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@page import="com.thinkPro.steap.action.meeting.excelUtils.ExcelUtilForProjectInfo" %>
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

	condition.setProjectStatus("已现场考察");
	condition.setPageSize(0);
	
	String meetingStatus = request.getParameter("meetingStatus");
	String meetingTime = request.getParameter("meetingTime");
	condition.setProjectName(request.getParameter("projectName"));
	condition.setApplicant(request.getParameter("applicant"));
	condition.setDomain(request.getParameter("domain"));
	condition.setProjectFunds(request.getParameter("projectFunds"));
	
	
	if( condition.getProjectName().equals("")){
			  condition.setProjectName(null);
		  }
		  if( condition.getApplicant().equals("")){
			  condition.setApplicant(null);
		  }
		  if( condition.getDomain().equals("")){
			  condition.setDomain(null);
		  }
		 
		  
		 if(condition.getProjectFunds().equals("全部")){
 			 condition.setProjectFunds(null);
 		} 
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IProjectMapper mapper = context.getBean(IProjectMapper.class);
	List<ProjectInfoResult> project = mapper.getInspectedProjects(condition);
	
	response.setCharacterEncoding("iso-8859-1");
	String fileName = "项目信息导出表.xls";
	response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "iso-8859-1"));
	response.setContentType("application/x-download;charset=iso-8859-1");
	OutputStream os = response.getOutputStream(); 
	
	String[] excelHeader = {"项目名称", "项目编号", "申请验收单位", "所属领域","登记日期","经费","考察日期"};
	String sheetName = "项目基本信息";
	HSSFWorkbook wb = ExcelUtilForProjectInfo.exportExcel(excelHeader, sheetName, project);
	wb.write(os);
%>
</body>
</html>
