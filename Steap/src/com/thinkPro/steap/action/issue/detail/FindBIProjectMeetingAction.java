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
import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.material.PictureService;
import com.thinkPro.steap.db.service.meeting.MeetingService;

@SuppressWarnings("serial")
@Component
public class FindBIProjectMeetingAction extends ActionSupport {
	Logger log = Logger.getLogger(FindBIProjectMeetingAction.class);

	private String projectId;
	private Map<String, Object> result;
	
	@Resource
	private MeetingService meetingService;
	@Resource
	private FileService fileService;
	@Resource
	private PictureService pictureService;

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
				Map<String, Object> notifyInfo = meetingService.getProjectNotifyByProjectId(projectId);
				result.put("notifyInfo", notifyInfo);
				
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("projectId", projectId);
				condition.put("fileType", "验收意见初稿");
				
				Material material = fileService.getFile(condition);
				
				result.put("material", material);
				
				condition.put("pictureType", "真实性承诺书");
				List<Picture> pictures = pictureService.getPictureByIf(condition);
				if(pictures.size() > 0) {
					makeUpFullPath(pictures, true);
				}
				
				result.put("pictures", pictures);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	private void makeUpFullPath(List<Picture> pictures, boolean flag) {
		String path = CommonTools.getPromiseFileFullPath();
		int size = pictures.size();
		
		for(int i = 0; i < size; i++) {
			Picture picture = pictures.get(i);
			String currentName = picture.getCurrentName();
			currentName = path + File.separator + currentName;
			picture.setCurrentName(currentName);
		}
	}	
}
