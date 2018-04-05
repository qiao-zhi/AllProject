package com.thinkPro.steap.action.evaluation.specialist;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

/**
 * 修改专家签名密码
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class UpdateSignaturePassAction extends ActionSupport {
	Logger log = Logger.getLogger(UpdateSignaturePassAction.class);

	private String specialistId;
	private String oldPass;
	private String signaturePass;
	private boolean result;
	
	@Resource
	private SpecialistService specialistService;

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getSignaturePass() {
		return signaturePass;
	}

	public void setSignaturePass(String signaturePass) {
		this.signaturePass = signaturePass;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		try {
			
			if(ValidateCheck.isNotNull(signaturePass) && ValidateCheck.isNotNull(specialistId)) {
				
				try {
					String oldSignaturePass = specialistService.getLibrarySignaturePassBySpecialistId(specialistId);
				
					log.info("specialistId: " + specialistId + ", signaturePass: " + signaturePass + ", oldPass: " + oldPass);
					log.info("oldSignaturePass: " + oldSignaturePass);
					
					if((oldSignaturePass == null && (oldPass == null || "".equals(oldPass))) || (oldSignaturePass != null && oldPass != null && oldSignaturePass.equals(oldPass))) {
						Map<String, Object> specialist_signaturePass = new HashMap<String, Object>();
						specialist_signaturePass.put("specialistId", specialistId);
						specialist_signaturePass.put("signaturePass", signaturePass);
						int updateRows = specialistService.updateLibrarySpecialistSignaturePass(specialist_signaturePass);
						
						result = updateRows != 0 ? true : false;
						log.info("result: " + result);
					}
				} catch(NullPointerException ex) {
					result = false;
					log.error(ex.getMessage(), ex);
				}
			}
		} catch (SQLException ex) {
			result = false;
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
