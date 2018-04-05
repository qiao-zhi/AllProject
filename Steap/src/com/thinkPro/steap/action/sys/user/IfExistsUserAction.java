package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.sys.user.UserService;

@SuppressWarnings("serial")
@Component
public class IfExistsUserAction extends ActionSupport {
	Logger log = Logger.getLogger(IfExistsUserAction.class);

	private String telephone;
	private Map<String, Object> result;
	
	@Resource
	private UserService userService;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
			if(ValidateCheck.isNotNull(telephone)) {
				boolean exist = userService.isExistsUserByTelephone(telephone);
				
				result = new HashMap<String, Object>();
				result.put("exist", exist);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		
		return SUCCESS;
	}
}
