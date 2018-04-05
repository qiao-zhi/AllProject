package com.thinkPro.steap.action.meeting;

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
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class SearchProject extends ActionSupport {
	private List<ProjectAccept> result;
	private List<Project> projects;
	private ProjectCondition condition;
	private int totalPage = 1;
	private int currentPage = 1;
	private Map<String, Object> session;
	private String projectId;
	private Project param;
	private String currentPages = "1";

	@Resource
	private ProjectService projectService;

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

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
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
			int a = Integer.parseInt(condition.getRecordDate());
			calendar.add(calendar.DATE, -a);
			Date date = calendar.getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
			String newDate = df.format(date);
			condition.setRecordDate(newDate);
		}
		// if (condition.getRecordPerson().equals("")) {
		// return SUCCESS;
		// }

		if (condition.getDomain().equals("")) {
			condition.setDomain(null);
		}

		if (currentPages.equals("")) {
			currentPages = "1";
		}

		condition.setPageSize(new PageConstants().getPageSize());
		condition.setPageBegin(new PageConstants().getRecordNums(Integer.parseInt(currentPages)));

		condition.setProjectStatus("已评估");
		projects = new ArrayList<Project>();
		try {
			projects = projectService.getProjectInfoByIf(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(CommonRM.class);
			logger.info(logger);
		}

		/* 改变字符串 */
		// for (int i = 0; i < projects.size(); i++) {
		// if (projects.get(i).getStatus().equals("已登记") ) {
		// projects.get(i).setStatus("确定负责部门");
		// }else {
		// projects.get(i).setStatus("查看");
		// }
		// }

		/* 得到总页数 */
		// try {
		// int recordNums = new ProjectService().getProjectCount(condition);
		// System.out.println(recordNums);
		// this.totalPage = new PageConstants().getPages(recordNums);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } finally {
		// Logger logger = Logger.getLogger(CommonRM.class);
		// logger.info(logger);
		// }

		return SUCCESS;
	}

	public String perfectProjectM() {

		return SUCCESS;
	}

	public String savePerfectFile() {
		return SUCCESS;
	}

	/* 通过projectId，跳转到查看项目明细页面 */
	public String searchProjectDetail() {
		param = new Project();
		param.setProjectId(projectId);
		return SUCCESS;
	}
}
