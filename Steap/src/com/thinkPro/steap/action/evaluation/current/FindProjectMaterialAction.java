package com.thinkPro.steap.action.evaluation.current;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.project.ProjectService;

/**
 * 获取项目材料供专家评审查看（待完善：用ajax还是boostrap处理request？？？）
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class FindProjectMaterialAction extends ActionSupport implements RequestAware {
	Logger log = Logger.getLogger(FindProjectMaterialAction.class);
	
	private String projectId;
	private List<Map<String, Object>> materialTree;
	private Map<String, Object> request;
	
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

	public List<Map<String, Object>> getMaterialTree() {
		return materialTree;
	}

	public void setMaterialTree(List<Map<String, Object>> materialTree) {
		this.materialTree = materialTree;
	}

	@Override
	public String execute() throws Exception {
		try {
			if(ValidateCheck.isNotNull(projectId)) {
				Map<String, Object> project = projectService.getProjectPartByProjectId(projectId);
				materialTree = fileService.getOriginalMaterialsTree(projectId);
				getFileFullPath();
				
				request.put("project", project);
				request.put("materialTree", materialTree); // 暂时放进request中，后面可能作修改
				log.info("materialTree: " + materialTree);
			}
		
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
			return ERROR;
		}
		return SUCCESS;
	}

	private void getFileFullPath() {
		int size = materialTree.size();
		String rootPath = CommonTools.getSevenMaterialPdf();
		for(int i = 0; i < size; i++) {
			Map<String, Object> material = materialTree.get(i);
			String currentName = (String) material.get("currentName");
			currentName = rootPath + "/" + currentName;
			material.put("currentName", currentName);
		}
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
