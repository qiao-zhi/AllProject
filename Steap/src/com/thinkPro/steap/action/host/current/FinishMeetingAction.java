package com.thinkPro.steap.action.host.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class FinishMeetingAction extends ActionSupport {
	Logger log = Logger.getLogger(FinishMeetingAction.class);

	private String meetingId;
	private String projectIds;
	private Map<String, Object> result;
	
	@Resource
	private MeetingService meetingService;
	@Resource
	private ProjectService projectService;

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(String projectIds) {
		this.projectIds = projectIds;
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
			if(ValidateCheck.isNotNull(meetingId) && ValidateCheck.isNotNull(projectIds)) {
				boolean checkResult = checkProjectStatus();
				if(checkResult) {
					
					Map<String, Object> meetingStatus = new HashMap<String, Object>();
					meetingStatus.put("meetingId", meetingId);
					meetingStatus.put("meetingStatus", "已完成");
					
					boolean updateResult = meetingService.updateMeetingCurrentStatus(meetingStatus);
					result.put("updateResult", updateResult);
				} else {
					result.put("updateResult", false);
				}
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	private boolean checkProjectStatus() throws Exception {
		boolean result = true;
		try {
			String[] projectIdList = projectIds.split(",");
			for (String projectId : projectIdList) {
				String status = projectService.getProjectCurrentStatusById(projectId);
				if(!"已评估".equals(status)) {
					result = result && false;
				}
			}
		} catch(SQLException ex) {
			result = false;
			log.error(ex.getMessage(), ex);
		}
		return result;
	} 
}
