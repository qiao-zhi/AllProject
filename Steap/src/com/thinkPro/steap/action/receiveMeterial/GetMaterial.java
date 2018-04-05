package com.thinkPro.steap.action.receiveMeterial;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.project.ProjectReceive;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class GetMaterial extends ActionSupport{
	@Resource
	private ProjectService projectService;
	private ProjectReceive projectReceive;
	private boolean result;
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public ProjectReceive getProjectReceive() {
		return projectReceive;
	}

	public void setProjectReceive(ProjectReceive projectReceive) {
		this.projectReceive = projectReceive;
	}

	@Override
	public String execute() throws Exception {
		Map<String, String> projectStatus = new HashMap<String, String>();
		projectStatus.put("projectId",projectReceive.getProjectId());
//		projectStatus.put("status", "100003");
		result = projectService.addProjectReceive(projectReceive);
		if (result) {
//			projectService.updateProjectStatus(projectStatus);
			return SUCCESS;
		}
		return ERROR;
	}
}
