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
 * 添加用户角色
 * @author Hao Shasha
 *
 */
@Component
public class AddUserRoleAction extends ActionSupport {

	private static final long serialVersionUID = -796140785473757381L;
	
	private String userId;  //Ajax传过来的值（用户编号）
	private String roleIds; //角色编号
	private boolean result;
	
	@Resource
	private UserService userService;
	
	/**
	 * 添加用户角色
	 * @return
	 */
	public String addUserRole() {
		
		//roleIds = roleIds.substring(0, roleIds.length()-1);
		
		//将得到的用户编号的字符串变为列表
		List<String> roleIdList = java.util.Arrays.asList(roleIds.split(","));
		//通过迭代达到批量更新用户角色的目的
		for(String roleId:roleIdList){
			
			Map<String,Object> userRole = new HashMap<String,Object>();
			
			userRole.put("userId", userId);
			
			userRole.put("roleId", roleId);
			
			try {
				
				this.result = userService.addRoleToUser(userRole);
				
				if(!result){
					
					return ERROR;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
