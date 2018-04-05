<%@page import="com.thinkPro.steap.db.mapper.project.IProjectMapper"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.thinkPro.steap.db.service.impl.project.ProjectServiceImpl"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.thinkPro.steap.common.ExcelUtil"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="com.thinkPro.steap.db.service.project.ProjectService"%>
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
	Map<String, Object> condition = new HashMap<String, Object>();

	String projectName = request.getParameter("projectName");
	String applicant = request.getParameter("applicant");
	String domain = request.getParameter("domain");
	
	condition.put("status", "已通过审核");
	condition.put("projectName", projectName);
	condition.put("applicant", applicant);
	condition.put("domain", domain);
	
	String standard = request.getParameter("projectStandard");
	if(standard != null && !"".equals(standard)) {
		int projectStandard = Integer.parseInt(standard);
		condition.put("projectStandard", projectStandard);
	}
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	IProjectMapper mapper = ctx.getBean(IProjectMapper.class);
	List<Map<String, Object>> projects = mapper.getAllProjectsNoPaging(condition);
	
	response.setCharacterEncoding("iso-8859-1");
	String fileName = "发放证书项目信息表" + UUID.randomUUID().toString() + ".xls";
	response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "iso-8859-1"));
	response.setContentType("application/x-download;charset=iso-8859-1");
	OutputStream os = response.getOutputStream(); 
	
	String[] header = {"项目名称", "项目编号", "申请验收单位", "所属领域", "登记日期", "验收日期", "会议主持人", "证书是否发放", "项目状态"};
	String[] headerAlias = {"projectName", "projectId", "applicant", "domain", "recordDate", "checkDate", "name", "certificate", "projectStatus"};
	String sheetName = "发放证书项目信息表";
	HSSFWorkbook wb = ExcelUtil.exportExcel(header, headerAlias, sheetName, projects);
	wb.write(os);
%>
</body>
</html>
