package com.thinkPro.steap.action.meeting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.meeting.ProjectInfoResult;
import com.thinkPro.steap.bean.project.ProjectCondition;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@SuppressWarnings("serial")
@Component
public class WaitProjectManage extends ActionSupport {

	private ProjectCondition projectCondition;// 项目条件类
	private List<ProjectInfoResult> projectInfoResultList;// 项目信息结果list
	List<String> domainList;// 所有领域
	// 分页
	private int totalPage;
	private int currentPages;
	private int pageBegin = 0;
	private int pageSize = 8;
	private Map<String, Object> map = new HashMap<String, Object>();

	@Resource
	private MeetingService meetingService;// 会议服务类
	@Resource
	private ProjectService projectService;// 项目服务类
	@Resource
	private DictionaryService dictionaryService;

	// 点击“创建会议”时，先默认查询项目
	public String toProjectManagePage() {

		projectCondition = new ProjectCondition();
		projectCondition.setPageBegin(pageBegin);
		projectCondition.setPageSize(pageSize);
		projectCondition.setProjectStatus("已现场考察");

		try {
			projectInfoResultList = projectService.getInspectedProjects(projectCondition);
			domainList = dictionaryService.getDomain("领域");
			map.put("projectInfoResultList", projectInfoResultList);
			map.put("domainList", domainList);
			// System.out.println(projectCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 设置页码

		try {
			int projectCount = projectService.getProjectCount(projectCondition);
			// System.out.println(projectCount);
			if (projectCount % projectCondition.getPageSize() == 0) {
				totalPage = projectCount / projectCondition.getPageSize();
				map.put("totalPage", totalPage);

			} else {
				totalPage = projectCount / projectCondition.getPageSize() + 1;
				map.put("totalPage", totalPage);
			}

			currentPages = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 待验收项目管理的查询
	public String ProjectManage() {

		try {
			projectCondition.setPageBegin(pageBegin);
			projectCondition.setPageSize(pageSize);
			projectCondition.setProjectStatus("已现场考察");
			if (projectCondition.getProjectName().equals("")) {
				projectCondition.setProjectName(null);
			}
			if (projectCondition.getApplicant().equals("")) {
				projectCondition.setApplicant(null);
			}
			if (projectCondition.getDomain().equals("")) {
				projectCondition.setDomain(null);
			}

			if (projectCondition.getProjectFunds().equals("全部")) {
				projectCondition.setProjectFunds(null);
			}

			projectInfoResultList = projectService.getInspectedProjects(projectCondition);
			domainList = dictionaryService.getDomain("领域");

			map.put("projectInfoResultList", projectInfoResultList);
			map.put("domainList", domainList);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			int projectCount = projectService.getProjectCount(projectCondition);

			if (projectCount % projectCondition.getPageSize() == 0) {
				totalPage = projectCount / projectCondition.getPageSize();
				map.put("totalPage", totalPage);

			} else {
				totalPage = projectCount / projectCondition.getPageSize() + 1;
				map.put("totalPage", totalPage);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public ProjectCondition getProjectCondition() {
		return projectCondition;
	}

	public void setProjectCondition(ProjectCondition projectCondition) {
		this.projectCondition = projectCondition;
	}

	public List<ProjectInfoResult> getProjectInfoResultList() {
		return projectInfoResultList;
	}

	public void setProjectInfoResultList(List<ProjectInfoResult> projectInfoResultList) {
		this.projectInfoResultList = projectInfoResultList;
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public List<String> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<String> domainList) {
		this.domainList = domainList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPages() {
		return currentPages;
	}

	public void setCurrentPages(int currentPages) {
		this.currentPages = currentPages;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
