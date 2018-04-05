package com.thinkPro.steap.action.host.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class FindSpecialistGroupAction extends ActionSupport {
	Logger log = Logger.getLogger(FindSpecialistGroupAction.class);
	
	private String meetingId;
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;

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
			
			if (ValidateCheck.isNotNull(meetingId)) {
				List<Map<String, Object>> specialists =  specialistService.getSpecialistGroupByMeetingId(meetingId);
				
				result.put("specialists", specialists);
			}
		} catch (SQLException | NullPointerException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
