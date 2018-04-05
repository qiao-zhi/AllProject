package com.thinkPro.steap.action.evaluation.specialist;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

/**
 * 查询专家基本信息
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class FindSpecialistInfoAction extends ActionSupport {
	Logger log = Logger.getLogger(FindSpecialistInfoAction.class);
	
	private String specialistId;
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;

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
		result = new HashMap<String, Object>();
		log.info("find specialistId: " + specialistId);
		try {
			if (specialistId != null && !"".equals(specialistId)) {
				Specialist specialist = specialistService.getLibrarySpecialistById(specialistId);
				
				String signature = specialist.getSignature();
				if(signature != null && signature != "") {
					signature = CommonTools.getSignatureFullPath(signature);
					specialist.setSignature(signature);
				}
				result.put("specialist", specialist);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	public String getSignaturePass() throws Exception {
		result = new HashMap<String, Object>();
		log.info("find specialistId: " + specialistId);
		try {
			if(specialistId != null && !"".equals(specialistId)) {
				
				String signaturePass = specialistService.getLibrarySignaturePassBySpecialistId(specialistId);
				result.put("signaturePass", signaturePass);
			}
		} catch(SQLException ex) {
			result.put("signaturePass", null);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	public String getSignature() throws Exception {
		result = new HashMap<String, Object>();
		log.info("find specialistId: " + specialistId);
		try {
			if(specialistId != null && !"".equals(specialistId)) {
				
				String signature = specialistService.getSpecialistSignature(specialistId);
				signature = CommonTools.getSignatureFullPath(signature);
				result.put("signature", signature);
			}
		} catch(SQLException ex) {
			result.put("signature", null);
			log.error(ex.getMessage(), ex);
		}		
		return SUCCESS;
	}
	
}
