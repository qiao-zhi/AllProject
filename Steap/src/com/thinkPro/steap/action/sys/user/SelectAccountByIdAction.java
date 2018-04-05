package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.UserAccount;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.sys.user.AccountService;

@SuppressWarnings("serial")
@Component
public class SelectAccountByIdAction extends ActionSupport {
	Logger log = Logger.getLogger(SelectAccountByIdAction.class);

	private String u_id;
	private Map<String, Object> result;
	
	@Resource
	private AccountService accountService;

	@Override
	public String execute() throws Exception {
		boolean exist = false;
		result = new HashMap<String, Object>();
		
		try {
			
			if (ValidateCheck.isNotNull(u_id)) {
				
				UserAccount ua = accountService.selectAccountById(u_id);
				
				exist = ua != null ? true : false;
			}
			
			result.put("exist", exist);
			log.info("==============exist:" + exist);
		} catch (SQLException ex) {
			result.put("exist", exist);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}


}
