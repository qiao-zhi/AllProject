<%@page import="java.io.OutputStream"%>
<%@page import="com.thinkPro.steap.common.ExcelUtil"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="com.thinkPro.steap.db.service.impl.meeting.MeetingServiceImpl"%>
<%@page import="com.thinkPro.steap.bean.meeting.MeetingCondition" %>
<%@page import="com.thinkPro.steap.bean.meeting.Meeting" %>
<%@page import="com.thinkPro.steap.db.mapper.meeting.IMeetingMapper" %>
<%@page import="org.springframework.context.ApplicationContext" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@page import="com.thinkPro.steap.action.meeting.excelUtils.ExcelUtilForMeetingInfo" %>
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
	MeetingCondition condition = new MeetingCondition();

	String meetingStatus = request.getParameter("meetingStatus");
	String meetingTime = request.getParameter("meetingTime");

	condition.setMeetingStatus( meetingStatus);
	condition.setMeetingTime( meetingTime);
	condition.setPageSize(0);

	if ("全部".equals(condition.getMeetingStatus())) {
			condition.setMeetingStatus(null);

	}

	if ("全部".equals(condition.getMeetingTime().trim())) {
		condition.setMeetingTime(null);

	} else {

		// 将页面上的时间条件（近一个月,近三个月等）转换为对应的时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int a = Integer.parseInt(condition.getMeetingTime());
		calendar.add(calendar.DATE, -a);
		Date date = calendar.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newDate = df.format(date);

		condition.setMeetingTime(newDate);

	}
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IMeetingMapper mapper = context.getBean(IMeetingMapper.class);
	List<Meeting> meeting = mapper.getMeetingInfos(condition);
	
	response.setCharacterEncoding("iso-8859-1");
	String fileName = "会议信息导出表.xls";
	response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "iso-8859-1"));
	response.setContentType("application/x-download;charset=iso-8859-1");
	OutputStream os = response.getOutputStream(); 
	
	String[] excelHeader = {"会议名称", "会议时间", "会议地点", "会议状态"};
	String sheetName = "会议基本信息";
	HSSFWorkbook wb = ExcelUtilForMeetingInfo.exportExcel(excelHeader, sheetName, meeting);
	wb.write(os);
%>
</body>
</html>
