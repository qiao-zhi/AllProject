package com.thinkPro.steap.action.perfectMaterial;

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
import com.thinkPro.steap.action.receiveMeterial.CommonRM;
import com.thinkPro.steap.bean.project.Project;
import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.bean.project.ProjectCondition;
import com.thinkPro.steap.common.PageConstants;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.verify.VerifyService;

@SuppressWarnings("serial")
@Component("SearchProject2")
public class SearchProject extends ActionSupport{
	private List<ProjectAccept> result;
	private List<Project> projects;
	private ProjectCondition condition;
	private int totalPage = 1;
	private int currentPage = 1;
	private Map<String, Object> session;
	private String projectId;
	private Project param;
	private String currentPages = "1";
	private List<Map<String,Object>> fileClass;
	private String completeDescription; 
	
	@Resource
	private ProjectService projectService;
	@Resource
	private FileService fileService;
	@Resource
	private VerifyService verifyService;
	
	public String getCompleteDescription() {
		return completeDescription;
	}

	public void setCompleteDescription(String completeDescription) {
		this.completeDescription = completeDescription;
	}

	public List<Map<String, Object>> getFileClass() {
		return fileClass;
	}

	public void setFileClass(List<Map<String, Object>> fileClass) {
		this.fileClass = fileClass;
	}

	public String getCurrentPages() {
		return currentPages;
	}

	public void setCurrentPages(String currentPages) {
		this.currentPages = currentPages;
	}

	public Project getParam() {
		return param;
	}

	public void setParam(Project param) {
		this.param = param;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	/* 通过四个条件查询待完善的项目 */ 
	@SuppressWarnings("static-access")
	public String execute() throws Exception {
		
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
		 if (condition.getChargePerson().equals("")) {
		 return SUCCESS;
		 }
		
		
		if (condition.getDomain().equals("")) {
			condition.setDomain(null);
		} 

		if (currentPages.equals("")) {
			currentPages = "1";
		}

		condition.setPageSize(new PageConstants().getPageSize());
		condition.setPageBegin(new PageConstants().getRecordNums(Integer.parseInt(currentPages)));
		
		/*
		* 设置项目状态
		*/
		condition.setProjectStatus("100008");
		
		projects = new ArrayList<Project>();
		try {
			projects = projectService.getProjectInfoByIf(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(CommonRM.class);
			logger.info(logger);
		}

		
		return SUCCESS;
	}
	
	/*通过条件查询出所有页数*/
	@SuppressWarnings("static-access")
	public String getPageNums(){
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
		
		condition.setProjectStatus("100008");
		
		 if (condition.getChargePerson().equals("")) {
			 return SUCCESS;
		 }
		
//		projectService = new ProjectService();
		
		/* 得到总页数 */
		try {
		int recordNums = projectService.getProjectCount(condition);
		this.totalPage = new PageConstants().getPages(recordNums);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(CommonRM.class);
			logger.info(logger);
		}
		
		return SUCCESS;
	}
	
	public String perfectProjectM(){
		try {
			Map<String, Object> verifyMap = verifyService.getLastVerifyInfoByPid(projectId);
			fileClass = fileService.getMaterialTypeList();
			if(verifyMap != null){
				completeDescription = (String) verifyMap.get("completeDescription");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String savePerfectFile(){
		return SUCCESS;
	}
	
	/* 通过projectId，跳转到查看项目明细页面 */
	public String searchProjectDetail(){
		param = new Project();
		param.setProjectId(projectId);
		return SUCCESS;
	}
}
