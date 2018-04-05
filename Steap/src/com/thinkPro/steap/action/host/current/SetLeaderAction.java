package com.thinkPro.steap.action.host.current;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

/**
 * 设置专家组组长
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class SetLeaderAction extends ActionSupport {
	Logger log = Logger.getLogger(SetLeaderAction.class);
	
	private String meetingId;
	private SpecialistLeader specialistLeader = new SpecialistLeader();
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;
	
	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(meetingId) && specialistLeader != null) {
				// 去除原先的专家组长
				List<Map<String, Object>> fromSpecialistLeaders = specialistLeader.toRemoveMap();
				if(fromSpecialistLeaders != null) {
					for (Map<String, Object> fromSpecialistLeader : fromSpecialistLeaders) {
						specialistService.updateLeader(fromSpecialistLeader);
					}
				}
				
				// 添加新的专家组长
				Map<String, Object> toSpecialistLeader = specialistLeader.toUpdateMap();
				specialistService.updateLeader(toSpecialistLeader);
				
				result.put("updateResult", true);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}  
		return SUCCESS;
	}

	class SpecialistLeader {
		private String newSpecialistId;
		private String oldSpecialistId;
		private String leader;
		
		public SpecialistLeader() {
			super();
		}

		public String getNewSpecialistId() {
			return newSpecialistId;
		}

		public void setNewSpecialistId(String newSpecialistId) {
			this.newSpecialistId = newSpecialistId;
		}

		public String getOldSpecialistId() {
			return oldSpecialistId;
		}

		public void setOldSpecialistId(String oldSpecialistId) {
			this.oldSpecialistId = oldSpecialistId;
		}

		public String getLeader() {
			return leader;
		}

		public void setLeader(String leader) {
			this.leader = leader;
		}

		public Map<String, Object> toUpdateMap() {
			Map<String, Object> newSL = new HashMap<String, Object>();
			newSL.put("meetingId", meetingId);
			newSL.put("specialistId", newSpecialistId);
			newSL.put("leader", leader);
			
			return newSL;
		}
		
		public List<Map<String, Object>> toRemoveMap() {
			if(oldSpecialistId != null && !"".equals(oldSpecialistId)) {
				List<Map<String, Object>> oldSLs = new ArrayList<Map<String, Object>>();
				String[] specialistIds = oldSpecialistId.split(",");
				for (String specialistId : specialistIds) {
					Map<String, Object> oldSL = new HashMap<String, Object>();
					oldSL.put("meetingId", meetingId);
					oldSL.put("specialistId", specialistId);
					oldSL.put("leader", null);
					oldSLs.add(oldSL);
				}
				return oldSLs;
			}
			return null;
		}
		
		@Override
		public String toString() {
			return "SpecialistLeader [newSpecialistId=" + newSpecialistId
					+ ", oldSpecialistId=" + oldSpecialistId + ", leader="
					+ leader + "]";
		}

	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public SpecialistLeader getSpecialistLeader() {
		return specialistLeader;
	}

	public void setSpecialistLeader(SpecialistLeader specialistLeader) {
		this.specialistLeader = specialistLeader;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
