package com.thinkPro.steap.action.host.current;

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
public class FindProjectCurrentStatusAction extends ActionSupport {
	Logger log = Logger.getLogger(FindProjectCurrentStatusAction.class);

	private String projectId;
	private Map<String, Object> result;
	
	@Resource
	private ProjectService projectService;

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(projectId)) {
				String projectStatus = projectService.getProjectCurrentStatusById(projectId);
				result.put("projectStatus", projectStatus);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
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
	
}
