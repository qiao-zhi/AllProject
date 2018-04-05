package com.thinkPro.steap.action.host.meeting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.meeting.MeetingService;

@SuppressWarnings("serial")
@Component
public class FindMeetingInfoAction extends ActionSupport {
	Logger log = Logger.getLogger(FindMeetingInfoAction.class);
	
	private String hostId;
	private Map<String, Object> result;
	
	@Resource
	private MeetingService meetingService;

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
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
			if(ValidateCheck.isNotNull(hostId)) {
				Map<String, Object> meeting_host = new HashMap<String, Object>();
				meeting_host.put("hostId", hostId);
				meeting_host.put("meetingStatus", "召开中");
				
				Meeting meeting = meetingService.getMeetingByHostId(meeting_host);
				
				result.put("meeting", meeting);
			}
		} catch(SQLException | NullPointerException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
