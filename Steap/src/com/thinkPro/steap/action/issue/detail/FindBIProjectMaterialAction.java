package com.thinkPro.steap.action.issue.detail;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class FindBIProjectMaterialAction extends ActionSupport {
	Logger log = Logger.getLogger(FindBIProjectMaterialAction.class);

	private String projectId;
	private Map<String, Object> result;
	
	@Resource
	private ProjectService projectService;
	@Resource
	private FileService fileService;

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
				Map<String, Object> project = projectService.getProjectPartByProjectId(projectId);
				
				result.put("project", project);
				
				List<Map<String, Object>> materials = fileService.getOriginalMaterialSet(projectId);
				
				if(materials.size() > 0) {
					for (Map<String, Object> material : materials) {
						String currentName = (String) material.get("currentName");
						currentName = CommonTools.getSevenMaterialPdf(currentName);
						material.put("currentName", currentName);
					}
					
					result.put("materials", materials);
				}
			}
			
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
