package com.thinkPro.steap.action.issue;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.bean.sys.user.UserAccount;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.sys.user.AccountService;
import com.thinkPro.steap.db.service.sys.user.UserService;

@SuppressWarnings("serial")
@Component
public class FindUserInfoAction extends ActionSupport {
	
	Logger log = Logger.getLogger(FindUserInfoAction.class);
	
	private String userId;
	private Map<String, Object> result;
	
	@Resource
	private UserService userService;
	
	@Resource
	private AccountService accountService;
	
	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if (ValidateCheck.isNotNull(userId)) {
				TBaseUserInfo user = userService.getUserById(userId);
				result.put("success", true);
				result.put("user", user);
			}
		} catch(SQLException ex) {
			result.put("success", false);
			log.error(ex.getMessage(), ex);
		}
		
		return SUCCESS;
	}
	
	public String selectAccountById() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if (ValidateCheck.isNotNull(userId)) {
				UserAccount userAccount = accountService.selectAccountById(userId);
				result.put("success", true);
				result.put("user", userAccount);
			}
		} catch(SQLException ex) {
			result.put("success", false);
			log.error(ex.getMessage(), ex);
		}
		
		return SUCCESS;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

}
