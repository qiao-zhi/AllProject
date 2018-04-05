package com.thinkPro.steap.action.evaluation.project;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class FindEvaluatedProjectAction extends ActionSupport {
	Logger log = Logger.getLogger(FindEvaluatedProjectAction.class);
	
	private String meetingId;
	private Map<String, Object> result;
	
	@Resource
	private ProjectService projectService;

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
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
			if(ValidateCheck.isNotNull(meetingId)) {
				List<Map<String, Object>> projects = projectService.getProjectsByMeetingId(meetingId);
				
				result.put("projects", projects);
			}
		} catch(SQLException | NullPointerException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	public String getProjectNames() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(meetingId)) {
				List<String> projectNames = projectService.getMeetingProjectNames(meetingId);
				
				int size = projectNames.size();
				StringBuffer names = new StringBuffer();
				for(int i = 0; i < size; i++) {
					names.append(projectNames.get(i) + "、");
				}
				names.deleteCharAt(names.toString().lastIndexOf("、"));
				result.put("names", names.toString());
			}
		} catch(SQLException ex) {
			result.put("names", null);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
