package com.thinkPro.steap.action.issue.detail;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.specialist.EvaluationService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class FindBIProjectCheckAction extends ActionSupport {
	Logger log = Logger.getLogger(FindBIProjectCheckAction.class);

	private String projectId;
	private Map<String, Object> result;
	
	@Resource
	private MeetingService meetingService;
	@Resource
	private SpecialistService specialistService;
	@Resource
	private EvaluationService evaluationService;

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
				Map<String, Object> erAndState = evaluationService.getEvaluationResultByProjectId(projectId);

				if(erAndState != null) {
					result.put("evaluateResult", erAndState.get("evaluateResult"));
				} else {
					result.put("evaluateResult", null);
				}
				
				Map<String, Object> project_meeting = new HashMap<String, Object>();
				project_meeting.put("projectId", projectId);
				project_meeting.put("meetingStatus", "已完成");
				Map<String, Object> meeting = meetingService.getMeetingByProjectId(project_meeting);
				
				result.put("meeting", meeting);
				
				if(meeting != null) {
					String meetingId = (String) meeting.get("meetingId");
					List<Map<String, Object>> specialists = specialistService.getSpecialistGroupByMeetingId(meetingId);
					result.put("specialists", specialists);
				}
			}
			
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
