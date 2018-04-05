package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.user.UserService;
/**
 * 重置密码
 * @author Hao Shasha
 *
 */
@Component
public class UpdateUserPasswordAction extends ActionSupport {

	private static final long serialVersionUID = -796150785473757389L;
	
	private String userIds; //用户编号
	private String password;//密码
	private boolean result;
	
	@Resource
	private UserService userService;
	
	/**
	 * 重置密码
	 * @return
	 */
	public String updateUserPassword() {
		
		userIds = userIds.substring(0,  userIds.length()-1);
		
		List<String> resetIds = java.util.Arrays.asList(userIds.split(","));
		
		Map<String,Object> userPassword = new HashMap<String,Object>();
		
		try {
			
			for(String resetId:resetIds){

				userPassword.put("userId", resetId);

				userPassword.put("password", password);

				this.result = userService.updateUserPassword(userPassword);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(result){
			
			return SUCCESS;
			
		}else{
			
			return ERROR;
		}
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
