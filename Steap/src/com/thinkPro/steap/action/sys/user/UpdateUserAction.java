package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.db.service.sys.user.UserService;

/**
 * 修改用户信息
 * @author Hao Shasha
 *
 */
@Component
public class UpdateUserAction extends ActionSupport {
	
	private static final long serialVersionUID = 519320461749415712L;
	
	private TBaseUserInfo user = new TBaseUserInfo();
	
	private TBaseUserInfo result;
	
	private boolean updateResult;
	
	@Resource
	private UserService userService;
	
	/**
	 * 更新/修改用户的信息
	 * @return
	 */
	public String updateUserInfo(){
		try {
			
			this.updateResult = userService.updateUserInfo(user);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 获得需要修改的用户的原始信息(暂时没有用)
	 * @return
	 */
	public String getUpdateUserInfo(){
		
		try {
			
			this.result = userService.getUserById(user.getUserId());
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public TBaseUserInfo getUser() {
		return user;
	}

	public void setUser(TBaseUserInfo user) {
		this.user = user;
	}

	public TBaseUserInfo getResult() {
		return result;
	}

	public void setResult(TBaseUserInfo result) {
		this.result = result;
	}

	public boolean isUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(boolean updateResult) {
		this.updateResult = updateResult;
	}
	
}
