package com.thinkPro.steap.action.evaluation.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class SignCommitmentAction extends ActionSupport {
	Logger log = Logger.getLogger(SignCommitmentAction.class);

	private String specialistId;
	private String meetingId;
	private int isAgree;
	private int isPromise;
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if (ValidateCheck.isNotNull(meetingId)
					&& ValidateCheck.isNotNull(specialistId)) {
				Map<String, Object> specialist_agree = new HashMap<String, Object>();

				specialist_agree.put("meetingId", meetingId);
				specialist_agree.put("specialistId", specialistId);
				if (isAgree == 1) {
					specialist_agree.put("isAgree", true);
				} else {
					specialist_agree.put("isAgree", false);
				}
				
				boolean promise = isPromise == 1 ? true : false;
				specialist_agree.put("isPromise", promise);

				log.info("specialist_agree: " + specialist_agree);

				int updateRows = specialistService.updateSpecialistGignAgree(specialist_agree);
				boolean update = updateRows > 0 ? true : false;
				result.put("update", update);
				
				String signature = specialistService.getSpecialistSignature(specialistId);
				signature = CommonTools.getSignatureFullPath(signature);
				
				result.put("signature", signature);
			}
		} catch (SQLException ex) {
			result.put("update", false);
			result.put("signature", null);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}

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

	public int getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(int isAgree) {
		this.isAgree = isAgree;
	}

	public int getIsPromise() {
		return isPromise;
	}

	public void setIsPromise(int isPromise) {
		this.isPromise = isPromise;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
