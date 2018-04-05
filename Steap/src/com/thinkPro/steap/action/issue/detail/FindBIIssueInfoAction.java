package com.thinkPro.steap.action.issue.detail;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class FindBIIssueInfoAction extends ActionSupport {
	Logger log = Logger.getLogger(FindBIIssueInfoAction.class);

	private String projectId;
	private Map<String, Object> result;
	
	@Resource
	private ProjectService projectService;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(projectId)) {
				Map<String, Object> issue = projectService.getIssueCertificateByProjectId(projectId);
				
				result.put("issue", issue);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}