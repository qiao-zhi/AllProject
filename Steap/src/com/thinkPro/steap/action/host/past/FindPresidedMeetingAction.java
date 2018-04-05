package com.thinkPro.steap.action.host.past;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
public class FindPresidedMeetingAction extends ActionSupport {
	Logger log = Logger.getLogger(FindPresidedMeetingAction.class);
	
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
				meeting_host.put("meetingStatus", "已完成");

				List<Meeting> meetings = meetingService.getMeetingListByHostId(meeting_host);
				
				result.put("meetings", meetings);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
