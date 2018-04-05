package com.thinkPro.steap.action.host.pass;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.sys.user.AccountService;

@SuppressWarnings("serial")
@Component
public class UpdateHostLoginPassAction extends ActionSupport {
	Logger log = Logger.getLogger(UpdateHostLoginPassAction.class);
	
	private String hostId;
	private String oldLoginPass;
	private String newLoginPass;
	private Map<String, Object> result;
	
	@Resource
	private AccountService accountService;
	
	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(hostId) && ValidateCheck.isNotNull(oldLoginPass) && ValidateCheck.isNotNull(newLoginPass)) {
				
				String password = accountService.getPassByUserId(hostId);
				if(password != null && !"".equals(password) && password.equals(oldLoginPass)) {
					Map<String, Object> user_account = new HashMap<String, Object>();
					user_account.put("userId", hostId);
					user_account.put("password", newLoginPass);
					
					int updateResult = accountService.updateAccountPass(user_account);
					boolean update = updateResult !=0 ? true : false;
					result.put("update", update);	
				}
				
			}
		} catch(SQLException ex) {
			result.put("update", false);
			log.error(ex.getMessage(), ex);
		}
		
		return SUCCESS;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
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
