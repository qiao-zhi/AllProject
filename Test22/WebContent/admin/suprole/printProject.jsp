<%@page import="com.thinkPro.steap.common.ValidateCheck"%>
<%@page import="com.thinkPro.steap.bean.project.ProjectQuery"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.thinkPro.steap.common.ExcelUtil"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page
	import="com.thinkPro.steap.db.service.impl.project.ProjectServiceImpl"%>
<%@page import="com.thinkPro.steap.bean.project.Project"%>
<%@page import="com.thinkPro.steap.bean.project.ProjectCondition"%>
<%@page import="com.thinkPro.steap.db.mapper.project.IProjectMapper"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page
	import="com.thinkPro.steap.action.receiveMeterial.execelUtils.ExcelUtilForRegister"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
		ProjectQuery project = new ProjectQuery();

		project.setPageBegin(0);
		project.setPageSize(0);
		
		String projectId = request.getParameter("projectId");
		if (ValidateCheck.isNotNull(projectId)) {
			project.setProjectId(projectId);
		} else {
			project.setProjectId(null);
		}
		
		String projectName = request.getParameter("projectName");
		if (ValidateCheck.isNotNull(projectName)) {
			project.setProjectName(projectName);
		} else {
			project.setProjectName(null);
		}
		
		String domain = request.getParameter("domain");
		if (ValidateCheck.isNotNull(domain)) {
			project.setDomain(domain);
		} else {
			project.setDomain(null);
		}
		
		String projectFunds = request.getParameter("projectFunds");
		project.setProjectFunds(projectFunds);
		
		String startDate = request.getParameter("startDate");
		if (ValidateCheck.isNotNull(startDate)) {
			project.setStartDate(startDate);			
		} else {
			project.setStartDate(null);
		}
		
		String endDate = request.getParameter("endDate");
		if (ValidateCheck.isNotNull(endDate)) {
			project.setEndDate(endDate);			
		} else {
			project.setEndDate(null);
		}
		
		String applicant = request.getParameter("applicant");
		if (ValidateCheck.isNotNull(applicant)) {
			project.setApplicant(applicant);			
		} else {
			project.setApplicant(null);
		}
		
		String status = request.getParameter("status");
		if (ValidateCheck.isNotNull(status)) {
			project.setStatus(status);			
		} else {
			project.setStatus(null);
		}
		System.out.println(project.toString());

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IProjectMapper mapper = context.getBean(IProjectMapper.class);
		List<Map<String, Object>> projects = mapper.getAllProjectInfo(project);

		response.setCharacterEncoding("iso-8859-1");
		String fileName = "快速查询项目信息表.xls";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gb2312"), "iso-8859-1"));
		response.setContentType("application/x-download;charset=iso-8859-1");
		OutputStream os = response.getOutputStream();

		String[] header = { "项目名称", "项目编号", "申请验收单位", "所属领域", "项目负责人", "会议主持人", "项目经费(万元)", "项目状态" };
		String[] headerAlias = { "projectName", "projectId", "applicant", "domain", "chargePerson", "hostPerson",
				"projectFunds", "status" };
		String sheetName = "快速查询项目信息表";
		HSSFWorkbook wb = ExcelUtil.exportExcel(header, headerAlias, sheetName, projects);
		wb.write(os);
	%>
</body>
</html>
