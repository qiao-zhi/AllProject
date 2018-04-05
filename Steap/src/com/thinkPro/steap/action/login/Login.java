package com.thinkPro.steap.action.login;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.db.service.sys.user.UserService;

@SuppressWarnings("serial")
@Component
public class Login extends ActionSupport implements SessionAware{
	private String username;
	private String password;
	private List<Map<String, Object>> userPrivileges2;
	@SuppressWarnings("unused")
	private Map<String, Object> session;
	private String isChecked;

	@Resource
	private UserService userService;

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	public List<Map<String, Object>> getUserPrivileges2() {
		return userPrivileges2;
	}

	public void setUserPrivileges2(List<Map<String, Object>> userPrivileges2) {
		this.userPrivileges2 = userPrivileges2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String execute() throws Exception {

		
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("account", username);
		loginInfo.put("password", password);

//		String prefix = username.substring(0, 2);
		Map session = ActionContext.getContext().getSession();
		
		session.put("userName", "");
		session.put("userId", "");
		session.put("specialistId", "");
		
		/*保存账号密码*/
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie nameCookie = new Cookie("loginName", "");
		Cookie passwCookie = new Cookie("loginPassw", "");
		
		
		if (isChecked != null && isChecked.equals("yes")) {
			nameCookie = new Cookie("loginName", URLEncoder.encode(username, "utf-8"));
			passwCookie = new Cookie("loginPassw", password);
			nameCookie.setMaxAge(60*60*24*7);
			passwCookie.setMaxAge(60*60*24*7);
		}
		else {
			nameCookie.setMaxAge(0);
			passwCookie.setMaxAge(0);
		}
		response.addCookie(nameCookie);
		response.addCookie(passwCookie);
		
		/*验证专家库专辑登陆*/
			String specialistLibId = userService.isSpecialistLib(loginInfo);
			if (specialistLibId != null) {
				session.put("userName", username);
				session.put("specialistId", specialistLibId);
				return "specialist";
			}
		
		/*验证用户登陆*/
		userPrivileges2 = new ArrayList<>();
		String userId = userService.isUser(loginInfo);
		TBaseUserInfo userInfo;
		
		if (userId == null) {
			session.put("msg", "用户账号或密码错误");
			return LOGIN;
		}else {
			userInfo = userService.getUserById(userId);
		}
		
		userPrivileges2 = userService.getPrivilegeByUserId2(userId);
		
		
		session.put("userName", userInfo.getName());
		session.put("userId", userId);
		session.put("menuUrl", userPrivileges2);
		return SUCCESS;
	
	}
	
	public String logout() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		SessionMap<String, Object> sessionMap = (SessionMap<String, Object>) session;
		sessionMap.invalidate();
		return SUCCESS;
	}
	
}
