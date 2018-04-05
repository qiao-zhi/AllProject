package com.thinkPro.steap.action.issue;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.PageConstants;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class FindProjectSetAction extends ActionSupport {
	Logger log = Logger.getLogger(FindProjectSetAction.class);
	
	private Map<String, Object> condition = new HashMap<String, Object>();
	private Map<String, Object> result;
	private String projectName;
	private String applicant;
	private String domain;
	private int projectStandard;
	private String chargePerson;
	private int pageBegin;
	private int pageSize;
	
	@Resource
	private ProjectService projectService;

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(condition.size() != 0) {
				condition.put("projectFunds", 50);
				condition.put("status", "已通过审核");
				
				List<Map<String, Object>> projects = projectService.getAllProjectByConditionWithPaging(condition);
				int totalCount = projectService.getAllProjectsCountWithPaging(condition);
				
				PageConstants paging = new PageConstants();
				paging.setPageSize(pageSize);
				int pageCount = paging.getPages(totalCount);
				
				result.put("projects", projects);
				result.put("currentPage", pageBegin + 1);
				result.put("pageCount", pageCount);
			}
		} catch(SQLException | NullPointerException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}	
	
	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
		condition.put("projectName", projectName);
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
		condition.put("applicant", applicant);
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
		condition.put("domain", domain);		
	}

	public int getProjectStandard() {
		return projectStandard;
	}

	public void setProjectStandard(int projectStandard) {
		this.projectStandard = projectStandard;
		condition.put("projectStandard", projectStandard);
	}

	public String getChargePerson() {
		return chargePerson;
	}

	public void setChargePerson(String chargePerson) {
		this.chargePerson = chargePerson;
		condition.put("chargePerson", chargePerson);
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
		condition.put("pageBegin", pageBegin);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		condition.put("pageSize", pageSize);
	}
}
