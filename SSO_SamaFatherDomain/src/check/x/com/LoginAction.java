package check.x.com;

import java.awt.image.VolatileImage;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import check.x.com.utils.CheckCookie;

public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	private String gotoUrl;
	private String cookieName;
	private String cookieValue;

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public String getCookieValue() {
		return cookieValue;
	}

	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}

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
			// 设置cookie的作用范围是父域(.x.com)
			cookie.setDomain(".x.com");
			// 斜杠代表设置到父域的顶层，也就是父域下的所有应用都可访问
			cookie.setPath("/");
			HttpServletResponse response = ServletActionContext.getResponse();
			// 增加cookie，未设置生命周期默认为一次会话
			response.addCookie(cookie);
			return SUCCESS;
		}
		return null;
	}
	
	
	public void checkCookie() throws IOException{
		String result="0";
		if(CheckCookie.checkCookie(cookieName, cookieValue)){
			result="1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();
	}

	public boolean check() {
		if ("user".equals(username) && "123".equals(password))
			return true;
		return false;
	}

}
