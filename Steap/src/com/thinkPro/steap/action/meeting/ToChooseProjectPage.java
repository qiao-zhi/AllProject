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
public class ToChooseProjectPage extends ActionSupport {

	private ProjectCondition projectCondition;// 项目条件类
	private List<ProjectInfoResult> projectInfoResultList;// 项目信息结果list
	List<String> domainList;// 所有领域
	// 分页
	private int totalPage;
	private int currentPages;
	private int pageBegin = 0;
	private int pageSize = 8;

	@Resource
	private MeetingService meetingService;// 会议服务类
	@Resource
	private ProjectService projectService;// 项目服务类
	@Resource
	private DictionaryService dictionaryService;

	// 点击“创建会议”时，先默认查询项目
	public String toChooseProjectPage() {

		projectCondition = new ProjectCondition();
		projectCondition.setPageBegin(pageBegin);
		projectCondition.setPageSize(pageSize);
		projectCondition.setProjectStatus("已现场考察");

		try {
			projectInfoResultList = projectService.getInspectedProjects(projectCondition);
			domainList = dictionaryService.getDomain("领域");

			// System.out.println(projectCondition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 设置页码

		try {
			int projectCount = projectService.getMeetingProjectCount(projectCondition);
			// System.out.println(projectCount);
			if (projectCount % projectCondition.getPageSize() == 0) {
				totalPage = projectCount / projectCondition.getPageSize();

			} else {
				totalPage = projectCount / projectCondition.getPageSize() + 1;
			}

			currentPages = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 分页
	public String searchProjectForPage() {
//		projectCondition = new ProjectCondition();
		projectCondition.setPageSize(pageSize);
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
		if (projectCondition.getDomain().equals("不限")) {
			projectCondition.setDomain(null);
		}
		
		

		int temp = (currentPages - 1) * projectCondition.getPageSize();
		if (temp == 0) {
			projectCondition.setPageBegin(0);
		} else {
			projectCondition.setPageBegin(temp);
		}

		projectCondition.setProjectStatus("已现场考察");
		try {
			projectInfoResultList = projectService.getInspectedProjects(projectCondition);
			// session=(Map) ActionContext.getContext().getSession();
			// session.put("rowNumber", projectInfoResultList.size());

//			int projectCount = projectService.getMeetingProjectCount(projectCondition);
//			if (projectCount % projectCondition.getPageSize() == 0) {
//				totalPage = projectCount / projectCondition.getPageSize();
//
//			} else {
//
//				totalPage = projectCount / projectCondition.getPageSize() + 1;
//				// System.out.println("jingu"+totalPage);
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	private Map<String, Object> map = new HashMap<String, Object>();

	// 创建会议界面 “查询”项目信息
	public String searchProjectInfo2() {

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
			if (projectCondition.getDomain().equals("不限")) {
				projectCondition.setDomain(null);
			}

			projectInfoResultList = projectService.getInspectedProjects(projectCondition);
			// domainList=new DictionaryService().getDomain("领域");
			map.put("projectInfoResultList", projectInfoResultList);
			// map.put("domainList", domainList);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			int projectCount = projectService.getMeetingProjectCount(projectCondition);

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

	public List<String> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<String> domainList) {
		this.domainList = domainList;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
