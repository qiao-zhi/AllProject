package com.thinkPro.steap.action.evaluation.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.meeting.MeetingService;

/**
 * 查询会议基本信息
 * 
 * @author yachao
 * 
 */
@SuppressWarnings("serial")
@Component
public class FindEvaluationMeetingInfoAction extends ActionSupport {
	Logger log = Logger.getLogger(FindEvaluationMeetingInfoAction.class);
	
	private String specialistId;
	private Map<String, Object> result;
	
	@Resource
	private MeetingService meetingService;

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
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
			
			if(ValidateCheck.isNotNull(specialistId)) {
				log.info("specialistId: " + specialistId);
				Map<String, Object> mapInfo = new HashMap<String, Object>();
				mapInfo.put("specialistId", specialistId);
				mapInfo.put("meetingStatus", "召开中");

				Map<String, Object> meeting = meetingService.getMeetingByMapInfo(mapInfo);
				result.put("meeting", meeting);
			}
		} catch(SQLException | NullPointerException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
