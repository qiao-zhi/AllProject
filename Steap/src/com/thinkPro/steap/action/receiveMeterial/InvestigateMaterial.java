package com.thinkPro.steap.action.receiveMeterial;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.project.ProjectCensor;
import com.thinkPro.steap.common.UUIDUtil;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class InvestigateMaterial extends ActionSupport{
	@Resource
	private ProjectService projectService;
	private ProjectCensor projectCensor;
	private boolean result;
	private String isUpdate;
	
	public String getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public ProjectCensor getProjectCensor() {
		return projectCensor;
	}

	public void setProjectCensor(ProjectCensor projectCensor) {
		this.projectCensor = projectCensor;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(isUpdate);
		
		/*更新*/
		if (isUpdate.equals("是")) {
			result = projectService.updateProjectCensor(projectCensor);
			if (result) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		}
		
		/*添加*/
		projectCensor.setCensorId(UUIDUtil.getUUID());
		
		Map<String, String> projectStatus = new HashMap<String, String>();
		projectStatus.put("projectId", projectCensor.getProjectId());
		projectStatus.put("status", "100004");
		
		result = projectService.addProjectCensor(projectCensor);
		if (result) {
			projectService.updateProjectStatus(projectStatus);
			return SUCCESS;
		}
			return ERROR;
	}
	

}
