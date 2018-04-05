package www.x.com;

import java.awt.image.VolatileImage;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import www.x.com.utils.CheckCookie;

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

	/**
	 * 验证登录信息
	 * 
	 * @throws IOException
	 */
	public void doLogin() throws IOException {
		boolean OK = this.check();
		String result = "0";
		if (OK) {
			result = "1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();
	}

	public void checkCookie() throws IOException {
		String result = "0";
		if ("ssocookie".equals(cookieName) && "sso".equals(cookieValue)) {
			result = "1";
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
