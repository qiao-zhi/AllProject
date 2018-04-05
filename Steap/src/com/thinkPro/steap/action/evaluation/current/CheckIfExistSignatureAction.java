package com.thinkPro.steap.action.evaluation.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class CheckIfExistSignatureAction extends ActionSupport {
	Logger log = Logger.getLogger(CheckIfExistSignatureAction.class);

	private String specialistId;
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(specialistId)) {
				
				boolean exist = specialistService.ifExistSignature(specialistId);
				result.put("exist", exist);
				
				String signaturePass = specialistService.getLibrarySignaturePassBySpecialistId(specialistId);
				if(signaturePass != null) {
					result.put("signaturePass", signaturePass);
				}
			}
			
		} catch(SQLException ex) {
			result.put("exist", false);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	public String checkIfExistSignPass() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(specialistId)) {
				
				String signaturePass = specialistService.getLibrarySignaturePassBySpecialistId(specialistId);
				boolean exist = signaturePass != null ? true : false;
				result.put("exist", exist);
			}
		} catch(SQLException ex) {
			result.put("exist", false);
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

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
}
