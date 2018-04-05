package com.thinkPro.steap.action.issue.detail;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.verify.VerifyService;

@SuppressWarnings("serial")
@Component
public class FindBIProjectCompleteAction extends ActionSupport {
	Logger log = Logger.getLogger(FindBIProjectCompleteAction.class);

	private String projectId;
	private Map<String, Object> result;
	
	@Resource
	private ProjectService projectService;
	@Resource
	private FileService fileService;
	@Resource
	private VerifyService verifyService;

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
//				Map<String, Object> verifyInfo = projectService.getVerifyInfoByProjectId(projectId);
				Map<String, Object> verifyInfo = verifyService.getLastVerifyInfoByPid(projectId);
				result.put("verifyInfo", verifyInfo);
				
//				Integer verifyFileNum = 0;
//				try {
//					if(verifyInfo.size() > 0) {
//						verifyFileNum = (Integer) verifyInfo.get("verifyFileNum");
//					}
//				} catch(NullPointerException ex) {
//					verifyFileNum = 0;
//				}
				
//				if(verifyFileNum != null && verifyFileNum.intValue() != 0 ) {
//					Map<String, Object> project_complete = new HashMap<String, Object>();
//					project_complete.put("projectId", projectId);
//					project_complete.put("verifyFileNum", verifyFileNum);
//					
//					fileService = new FileService();
//					List<Map<String, Object>> materials =  fileService.getCompleteMaterials(project_complete);
//					
//					if(materials.size() > 0) {
//						makeUpFullPath(materials, true);
//						result.put("materials", materials);
//					}
//					
//				}
				if(verifyInfo != null && verifyInfo.size() > 0) {
					List<Material> materials = fileService.getAllPerfectMaterialsByPId(projectId);
					if(materials.size() > 0) {
						makeUpFullPath(materials, true);
						result.put("materials", materials);
					}
				}
			}
			
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	private void makeUpFullPath(List<Material> materials, boolean flag) {
		int size = materials.size();
		String path = CommonTools.getPerfectmaterialFullPath();
		
		for(int i = 0; i < size; i++) {
			Material material = materials.get(i);
			String currentName = (String) material.getCurrentName();
			currentName = path + File.separator + currentName;
			material.setCurrentName(currentName);
		}
	}
}
