package com.thinkPro.steap.action.perfectMaterial;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;

@SuppressWarnings("serial")
public class FindPastMaterialAction extends ActionSupport {

	Logger log = Logger.getLogger(FindPastMaterialAction.class);
	
	private Map<String, Object> result;
	private String projectId;

	@Resource
	private FileService fileService;

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		
		try {
			if (ValidateCheck.isNotNull(projectId)) {
				List<Material> materials = fileService.getAllPerfectMaterialsByPId(projectId);
				
				for (int i = 0; i < materials.size(); i++) {
					String currentName = materials.get(i).getCurrentName();
					currentName = CommonTools.getperfectMaterialFullPath(currentName);
					materials.get(i).setCurrentName(currentName);
				}
				
				result.put("success", true);
				result.put("materials", materials);
			}
		} catch(SQLException ex) {
			result.put("success", false);
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
