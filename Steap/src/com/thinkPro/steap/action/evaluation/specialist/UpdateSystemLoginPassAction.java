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
 * 修改专家登录密码
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class UpdateSystemLoginPassAction extends ActionSupport {
	Logger log = Logger.getLogger(UpdateSystemLoginPassAction.class);
	
	private String specialistId;
	private String oldLoginPass;
	private String newLoginPass;
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(specialistId) && ValidateCheck.isNotNull(oldLoginPass) && ValidateCheck.isNotNull(newLoginPass)) {
				String password = specialistService.getLibraryPassBySpecialistId(specialistId);
				
				if(password != null && !"".equals(password) && password.equals(oldLoginPass)) {
					Map<String, Object> specialist_password = new HashMap<String, Object>();
					specialist_password.put("specialistId", specialistId);
					specialist_password.put("password", newLoginPass);

					int updateRows = specialistService.updateSpecialistPassword(specialist_password);
					boolean updateResult = updateRows != 0 ? true : false;
					result.put("updateResult", updateResult);
				}
			}
		} catch(SQLException ex) {
			result.put("updateResult", false);
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

	public String getOldLoginPass() {
		return oldLoginPass;
	}

	public void setOldLoginPass(String oldLoginPass) {
		this.oldLoginPass = oldLoginPass;
	}

	public String getNewLoginPass() {
		return newLoginPass;
	}

	public void setNewLoginPass(String newLoginPass) {
		this.newLoginPass = newLoginPass;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
