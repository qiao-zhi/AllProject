package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.sys.user.RoleService;

@SuppressWarnings("serial")
@Component
public class FindRoleSetAction extends ActionSupport {
	Logger log = Logger.getLogger(FindRoleSetAction.class);

	private String userId;
	private Map<String, Object> result;
	
	@Resource
	private RoleService roleService;

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

	@Override
	public String execute() throws Exception {
		try {
			if(ValidateCheck.isNotNull(userId)) {
				List<Map<String, Object>> roles =  roleService.getAllRolePartInfoByUserId(userId);
				
				result = new HashMap<String, Object>();
				result.put("roles", roles);
			}
			
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
