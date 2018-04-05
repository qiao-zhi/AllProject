package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.user.UserService;

/**
 * 删除用户角色
 * @author Hao Shasha
 *
 */
@Component
public class DeleteUserRoleAction extends ActionSupport {

	private static final long serialVersionUID = -745140785473757381L;
	
	private String userId;	//用户编号
	private String roleId;	//角色编号
	private boolean result;
	
	@Resource
	private UserService userService;
	/**
	 * 删除用户角色
	 * @return
	 */
	public String deleteRoleFromUser() {

		Map<String,Object> userRole = new HashMap<String,Object>();
		
		userRole.put("userId", userId);  //按照用户编号删除用户所持有的所有角色
		
		try {
			 this.result = userService.deleteRoleFromUser(userRole);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(result){
			
			return SUCCESS;
		}else{
			
			return ERROR;
		}
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	
}
