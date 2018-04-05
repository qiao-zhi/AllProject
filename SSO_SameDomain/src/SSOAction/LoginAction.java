package SSOAction;

import java.awt.image.VolatileImage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	private String gotoUrl;
	
	


	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
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

	@Override
	public String execute() throws Exception {
		boolean OK = this.check();
		if (OK) {
			Cookie cookie = new Cookie("ssocookie", "sso");
			// 设置cookie的作用范围是顶层(localhost),在localhost域下的应用可见
			cookie.setPath("/");
			HttpServletResponse response = ServletActionContext.getResponse();
			// 增加cookie，未设置生命周期默认为一次会话
			response.addCookie(cookie);
			return SUCCESS;
		}
		return null;
	}

	public boolean check() {
		if ("user".equals(username) && "123".equals(password))
			return true;
		return false;
	}

}
