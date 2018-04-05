package com.thinkPro.steap.action.receiveMeterial;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.project.Project;
import com.thinkPro.steap.bean.project.ProjectRecord;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class RegisterMaterial extends ActionSupport{
	private Project project;
	private ProjectRecord projectRecord;
	private String projectId;
	private String isRepeat;
	@Resource
	private ProjectService projectService;
	
	public String getIsRepeat() {
		return isRepeat;
	}

	public void setIsRepeat(String isRepeat) {
		this.isRepeat = isRepeat;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProjectRecord getProjectRecord() {
		return projectRecord;
	}

	public void setProjectRecord(ProjectRecord projectRecord) {
		this.projectRecord = projectRecord;
	}

	
	/* 保存登记信息 */
	@Override
	public String execute() throws Exception {
		boolean result = false;
		/* 将项目里的projectId传给登记类 */
		projectRecord.setProjectId(project.getProjectId());
		
		if (project != null && !project.equals("")) {
			result = projectService.addProject(project, projectRecord);
			if (result) {
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	/*通过项目Id删除项目*/
	public String deleteProject(){
		
		try {
			if (projectService.deleteProject(projectId)) {
				return SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/*通验证 projectId是否重复*/
	public String isProjectIdRepeat(){
		Map<String, Object> idMap = new HashMap<String, Object>();
		boolean result = false;
		idMap.put("projectId", projectId);
		
		try {
			result = projectService.isProjectId(idMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result) {
			isRepeat = "可登记";
		} else{
			isRepeat = "已存在";
		}
		return SUCCESS;
	}
	
}
