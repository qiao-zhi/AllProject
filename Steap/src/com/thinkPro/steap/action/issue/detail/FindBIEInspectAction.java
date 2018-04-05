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
import com.thinkPro.steap.bean.project.EnterpriseInspect;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.PictureService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class FindBIEInspectAction extends ActionSupport {
	Logger log = Logger.getLogger(FindBIEInspectAction.class);

	private String projectId;
	private int flag;
	private Map<String, Object> result;
	
	@Resource
	private ProjectService projectService;
	@Resource
	private SpecialistService specialistService;
	@Resource
	private PictureService pictureService;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
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
				EnterpriseInspect inspect = projectService.getBIEInspectByProjectId(projectId);
				result.put("inspect", inspect);
				
				List<Specialist> specialists = specialistService.getRecommendSpecialistList(projectId);
				result.put("specialists", specialists);
				
				if(inspect.isAudit()) {
					Map<String, Object> audit = projectService.getBIAuditByInspectId(inspect.getInspectId());
					result.put("audit", audit);
				}
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	public String getPictureSet() throws Exception {
		try {
			if(ValidateCheck.isNotNull(projectId)) {
				Map<String, Object> project_picture = new HashMap<String, Object>();
				project_picture.put("projectId", projectId);
				project_picture.put("pictureType", "考察照片");
				
				List<Map<String, Object>> inspectPictures = pictureService.getPictureSet(project_picture);
				makeUpFullPath(inspectPictures, true);
					
				result = new HashMap<String, Object>();
				result.put("inspectPictures", inspectPictures);
				
				if(flag != 0) {
					project_picture.put("pictureType", "廉洁承诺书");
					List<Map<String, Object>> auditPictures = pictureService.getPictureSet(project_picture);
					makeUpFullPath(auditPictures, false);
					
					result.put("auditPictures", auditPictures);
				}
			}
			
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	private void makeUpFullPath(List<Map<String, Object>> pictures, boolean flag) {
		String path = "";
		if(flag) {
			path = CommonTools.getInvestigatePictureFullPath();
		} else {
			path = CommonTools.getAuditPictureFullPath();
		}
		int size = pictures.size();
		for(int i = 0; i < size; i++) {
			Map<String, Object> picture = pictures.get(i);
			String currentName = (String) picture.get("currentName");
			currentName = path + File.separator + currentName;
			picture.put("currentName", currentName);
		}
	}
}
