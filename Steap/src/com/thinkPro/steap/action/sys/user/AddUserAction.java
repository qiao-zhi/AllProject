package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.db.service.sys.user.UserService;
/**
 * 添加用户
 * @author Hao Shasha
 *
 */
@Component
public class AddUserAction extends ActionSupport {
	
	private static final long serialVersionUID = -606136789052608961L;

	private TBaseUserInfo user = new TBaseUserInfo();
	
	private String userId;
	
	@Resource
	private UserService userService;

	/**
	 * 添加用户
	 * @return
	 */
	public String addUser(){

		boolean result = false;
		try {
			
			result = userService.addUser(user);
			
			this.userId = user.getUserId();     
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			
			Logger logger = Logger.getLogger(AddUserAction.class);
			
			logger.info(logger);
		}
		if (result) {
			
			return SUCCESS;
		} 
		
		return ERROR;
	}
	
	
	public TBaseUserInfo getUser() {
		return user;
	}

	public void setUser(TBaseUserInfo user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
