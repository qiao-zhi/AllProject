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
public class SaveUserRoleAction extends ActionSupport {
	Logger log = Logger.getLogger(SaveUserRoleAction.class);

	private String userId;
	private String roleIds;
	private boolean result;
	
	@Resource
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		try {
			if(ValidateCheck.isNotNull(userId)) {
				boolean tipInfo = clearOldUserRoles();
				if(tipInfo) {
					//将得到的用户编号的字符串变为列表
					String[] roleIdList = roleIds.split(",");
					
					result = true;
					if(roleIdList.length != 0) {
						Map<String,Object> userRole = new HashMap<String,Object>();
						
						//通过迭代达到批量更新用户角色的目的
						for(String roleId:roleIdList){
							userRole.put("userId", userId);
							userRole.put("roleId", roleId);
								
							result = result && userService.addRoleToUser(userRole);
							log.info("<userId=" + userId + ", roleId=" + roleId + ">" + "======result: " + result + "======");
						}					
						log.info("======insert user role is ok!======");
					}
				}
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	private boolean clearOldUserRoles() throws SQLException {
		try {
			userService.deleteUserRoleByUserId(userId);
			log.info("======Clear user roles is ok!======");
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
			return false;
		}
		return true;
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

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
