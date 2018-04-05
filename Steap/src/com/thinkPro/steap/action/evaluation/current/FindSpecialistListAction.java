package com.thinkPro.steap.action.evaluation.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class FindSpecialistListAction extends ActionSupport {
	Logger log = Logger.getLogger(FindSpecialistListAction.class);
	
	private String specialistId;
	private String meetingId;
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

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
		try {
			result = new HashMap<String, Object>();
			
			if(ValidateCheck.isNotNull(meetingId) && ValidateCheck.isNotNull(specialistId)) {
				
				List<Specialist> specialists = specialistService.getSpecialistsByMeetingId(meetingId);
				
				Map<String, Object> meeting_specialist = new HashMap<String, Object>();
				meeting_specialist.put("meetingId", meetingId);
				meeting_specialist.put("specialistId", specialistId);
				
				boolean signResult = specialistService.getSignCommitmentResult(meeting_specialist);
				result.put("specialists", specialists);
				result.put("signResult", signResult);
			}
		} catch(SQLException | NullPointerException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
