package com.thinkPro.steap.action.receiveMeterial;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.project.Project;
import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.bean.project.ProjectCensor;
import com.thinkPro.steap.bean.project.ProjectCharge;
import com.thinkPro.steap.bean.project.ProjectCondition;
import com.thinkPro.steap.bean.project.ProjectReceive;
import com.thinkPro.steap.bean.project.ProjectRecord;
import com.thinkPro.steap.common.PageConstants;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
	/* 接收验收项目资料中查询共用的类 */
@Component
public class CommonRM extends ActionSupport{
	private List<ProjectAccept> result;
	private List<Project> projects;
	private ProjectCondition condition;
	private int totalPage = 1;
	private int currentPage = 1;
	private String currentPages = "1";
	private List<Map<String, Object>> projectsList;
	
	@Resource
	private ProjectService projectService;
	

	public List<Map<String, Object>> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(List<Map<String, Object>> projectsList) {
		this.projectsList = projectsList;
	}

	public String getCurrentPages() {
		return currentPages;
	}

	public void setCurrentPages(String currentPages) {
		this.currentPages = currentPages;
	}

	public List<ProjectAccept> getResult() {
		return result;
	}

	public void setResult(List<ProjectAccept> result) {
		this.result = result;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public ProjectCondition getCondition() {
		return condition;
	}

	public void setCondition(ProjectCondition condition) {
		this.condition = condition;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/* 前一个页面查询得出的某一页的数据 */
	@SuppressWarnings("static-access")
	public String searchProject() {
		
		/* 判断传过来的值是否为空 */
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
		if (currentPages.equals("")) {
			currentPages = "1";
		}

		condition.setPageSize(new PageConstants().getPageSize());
		condition.setPageBegin(new PageConstants().getRecordNums(Integer.parseInt(currentPages)));
		

//		projectService = new ProjectService();
		projects = new ArrayList<Project>();
		try {
			projects = projectService.getProjectInfoByIf2(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(CommonRM.class);
			logger.info(logger);
		}

		/* 改变字符串 */
		for (int i = 0; i < projects.size(); i++) {
			if (projects.get(i).getStatus().equals("已登记") ) {
				projects.get(i).setRemark("确定负责部门");
			} else if(projects.get(i).getStatus().equals("已创建项目会议")
					|| projects.get(i).getStatus().equals("已评审")
					||projects.get(i).getStatus().equals("已评估")
					|| projects.get(i).getStatus().equals("已通过审核")){
				projects.get(i).setRemark("只查看");
				
			} else if(projects.get(i).getStatus().equals("已确定验收负责部门")){
				projects.get(i).setRemark("已确定");
			} else {
				projects.get(i).setRemark("查看");
			}
		}
		
		
		return SUCCESS;
	}
	
	/*第二个界面 确定负责部门查询结果*/
	@SuppressWarnings("static-access")
	public String projectInAddPage() {
		
		/* 判断传过来的值是否为空 */
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
		if (currentPages.equals("")) {
			currentPages = "1";
		}

		condition.setPageSize(new PageConstants().getPageSize());
		condition.setPageBegin(new PageConstants().getRecordNums(Integer.parseInt(currentPages)));
		

		projectsList = new ArrayList<>();
		try {
			projectsList = projectService.getProjectInAddPage(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(CommonRM.class);
			logger.info(logger);
		}
		

		/* 改变字符串 */
		for (int i = 0; i < projectsList.size(); i++) {
			if (projectsList.get(i).get("status").equals("已登记") ) {
				projectsList.get(i).put("remark", "确定负责部门");
			} else if(projectsList.get(i).get("status").equals("已创建项目会议")
					|| projectsList.get(i).get("status").equals("已评审")
					|| projectsList.get(i).get("status").equals("已评估")
					|| projectsList.get(i).get("status").equals("已通过审核")){
				projectsList.get(i).put("remark", "只查看");
				
			} else if(projectsList.get(i).get("status").equals("已确定验收负责部门")){
				projectsList.get(i).put("remark", "已确定");
			} else {
				projectsList.get(i).put("remark", "只查看");
			}
			
			if (projectsList.get(i).get("chargeUnit") == null) {
				projectsList.get(i).put("chargeUnit", "");
				projectsList.get(i).put("chargePerson", "");
				projectsList.get(i).put("distributionDate", "");
			}
		}
		
		
		return SUCCESS;
	}
	
	@SuppressWarnings("static-access")
	public String getpPageNums(){
		/* 判断传过来的值是否为空 */
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
//		 if (condition.getRecordPerson() == null) {
//			 condition.setRecordPerson("没有");
//		 }
		
//		projectService = new ProjectService();
		
		/* 得到总页数 */
		try {
		int recordNums = projectService.getProjectCount2(condition);
		this.totalPage = new PageConstants().getPages(recordNums);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(CommonRM.class);
			logger.info(logger);
		}
		
		return SUCCESS;
	}

	/* 后两个页面查询得到某一页的数据 */
	@SuppressWarnings("static-access")
	public String searchProject2() {
		
		/* 判断传过来的值是否为空 */
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
		
		if (currentPages.equals("")) {
			currentPages = "1";
		}
		
		condition.setPageSize(new PageConstants().getPageSize());
		condition.setPageBegin(new PageConstants().getRecordNums(Integer.parseInt(currentPages)));
		

//		projectService = new ProjectService();
		result = new ArrayList<>();
		try {
			this.result = projectService.getProjectAcceptInfoByIf(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (ProjectAccept projectAccept : result) {
			if (projectAccept.getProjectRecord() == null) {
				ProjectRecord projectRecord = new ProjectRecord();
				projectAccept.setProjectRecord(projectRecord);
			} if (projectAccept.getProjectCharge() == null) {
				ProjectCharge projectCharge = new ProjectCharge();
				projectAccept.setProjectCharge(projectCharge);
			} if (projectAccept.getProjectReceive() == null) {
				ProjectReceive projectReceive = new ProjectReceive();
				projectReceive.setReceiveDate("");
				projectAccept.setProjectReceive(projectReceive);
			} if (projectAccept.getProjectCensor() == null) {
				ProjectCensor projectCensor = new ProjectCensor();
				projectCensor.setCensorDate("");
				projectAccept.setProjectCensor(projectCensor);
			}
		}
		
		/* 修改显示到页面的状态  */
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getStatus().equals("已确定验收负责部门")) {
//				result.get(i).setStatus("领取验收资料");
				result.get(i).getProjectRecord().setRemark1("领取验收资料");
			} else if (result.get(i).getStatus().equals("已领取验收项目资料")) {
//				result.get(i).setStatus("审查验收资料");
				result.get(i).getProjectRecord().setRemark1("审查验收资料");
			}  else if (result.get(i).getStatus().equals("已创建项目会议")
					|| result.get(i).getStatus().equals("已评审")
					|| result.get(i).getStatus().equals("已评估")
					|| result.get(i).getStatus().equals("已通过审核")
					|| result.get(i).getStatus().equals("已发放证书")) {
//				result.get(i).setStatus("仅查看");
				result.get(i).getProjectRecord().setRemark1("仅查看");
			}  else {
//				result.get(i).setStatus("查看");
				result.get(i).getProjectRecord().setRemark1("查看");
			}
			
			/*判断查询出来的结果是否为null，设置为空*/
			if (result.get(i).getProjectReceive().getReceivePerson() == null) {
				result.get(i).getProjectReceive().setReceivePerson("");
			}
			if (result.get(i).getProjectCensor().getCensorPerson() == null) {
				result.get(i).getProjectCensor().setCensorPerson("");
			}
			if (result.get(i).getProjectCensor().getCensorResult() == null) {
				result.get(i).getProjectCensor().setCensorResult("");
			}
		}
		

		return SUCCESS;
	}
	
	/* 最后一个页面查询得到某一页的数据 */
	@SuppressWarnings("static-access")
	public String searchProject3() {

		/* 判断传过来的值是否为空 */
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
		 if (condition.getRecordPerson() == null) {
			 condition.setRecordPerson("");
		 }
		
		if (currentPages.equals("")) {
			currentPages = "1";
		}
		if (condition.getChargePerson() == null) {
			 condition.setChargePerson("未知");
		 }
		
		condition.setPageSize(new PageConstants().getPageSize());
		condition.setPageBegin(new PageConstants().getRecordNums(Integer.parseInt(currentPages)));
		

//		projectService = new ProjectService();
		result = new ArrayList<>();
		try {
			this.result = projectService.getProjectAcceptInfoByIf(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (ProjectAccept projectAccept : result) {
			if (projectAccept.getProjectRecord() == null) {
				ProjectRecord projectRecord = new ProjectRecord();
				projectRecord.setRecordDate("");
				projectAccept.setProjectRecord(projectRecord);
			} if (projectAccept.getProjectCharge() == null) {
				ProjectCharge projectCharge = new ProjectCharge();
				projectCharge.setDestributionDate("");
				projectAccept.setProjectCharge(projectCharge);
			} 
		}
		
		/* 修改显示到页面的状态  */
		for (int i = 0; i < result.size(); i++) {
			
			if (result.get(i).getStatus().equals("已审查")) {
//				result.get(i).setStatus("录入企业考察信息");
				result.get(i).getProjectRecord().setRemark1("录入企业考察信息");
			} else if (result.get(i).getStatus().equals("已登记")) {
//				result.get(i).setStatus("当前不能操作");
				result.get(i).getProjectRecord().setRemark1("当前不能操作");
			} else if (result.get(i).getStatus().equals("已确定验收负责部门")) {
//				result.get(i).setStatus("当前不能操作");
				result.get(i).getProjectRecord().setRemark1("当前不能操作");
			} else if (result.get(i).getStatus().equals("已领取验收项目资料")) {
//				result.get(i).setStatus("当前不能操作");
				result.get(i).getProjectRecord().setRemark1("当前不能操作");
			} else {
//				result.get(i).setStatus("查看");
				result.get(i).getProjectRecord().setRemark1("查看");
			}
		}

		return SUCCESS;
	}

}
