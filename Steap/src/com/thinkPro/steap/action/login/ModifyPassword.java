package com.thinkPro.steap.action.login;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.user.UserService;

@SuppressWarnings("serial")
@Component
public class ModifyPassword extends ActionSupport{
	private String oldLoginPass;
	private String newLoginPass;
	private String userId;
	private String result;
	
	@Resource
	private UserService userService;
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	/*修改密码*/
	public String execute() throws Exception {
		
		Map<String, String> loginInfo = new HashMap<>();
		Map<String,Object> userPassword = new HashMap<>();
		
		loginInfo.put("uId", userId);
		loginInfo.put("password", oldLoginPass);
		
		/*查询用户名，密码是否正确*/
		String dbUserId = userService.isUser2(loginInfo);
		if (userId.equals(dbUserId)) {
			userPassword.put("uId", dbUserId);
			userPassword.put("password", newLoginPass);
			if (userService.updateUserPassword(userPassword)) {
				result = "修改密码成功";
				return SUCCESS;
			}
			result = "修改密码失败";
			return ERROR;
		}
		result = "原密码错误，请重试";
		return SUCCESS;
	}
	
}
