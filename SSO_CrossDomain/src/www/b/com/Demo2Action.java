package www.b.com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Demo1主页，访问主页要先验证cookie
 * 
 * @author: qlq
 * @date : 2017年8月29日下午12:02:31
 */
public class Demo2Action extends ActionSupport {

	private String gotoUrl;
	private String username;
	private String password;
	private String path;
	private List<String> hiddenurls;

	
	public List<String> getHiddenurls() {
		return hiddenurls;
	}

	public void setHiddenurls(List<String> hiddenurls) {
		this.hiddenurls = hiddenurls;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("ssocookie".equals(cookie.getName())) {
					HashMap<String, Object> map = new HashMap<>();
					map.put("cookieName", cookie.getName());
					map.put("cookieValue", cookie.getValue());
					String result = this.doGet("http://www.x.com/sso/checkCookie.action", map);
					if ("1".equals(result)) {
						return SUCCESS;
					}
				}
			}
		}

		// 登陆失败后将gotoUrl写到JSP页面
		path = "demo2";
		gotoUrl = "http://www.b.com/demo2/main.action";
		return LOGIN;
	}

	/**
	 * 增加cookie
	 */
	public void addCookie() {
		Cookie cookie = new Cookie("ssocookie", "sso");
		cookie.setPath("/");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addCookie(cookie);
	}

	/**
	 * 登录方法
	 * 
	 * @return
	 */
	public String doLogin() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		String result = this.doGet("http://www.x.com/sso/doLogin.action", map);
		if ("1".equals(result)) {
			hiddenurls = new ArrayList<>();
			hiddenurls.add("http://www.a.com/demo1/addCookie.action");
			hiddenurls.add("http://www.b.com/demo2/addCookie.action");
			return SUCCESS;
		}
		return LOGIN;
	}

	/*
	 * 验证方法
	 */
	public String doGet(String url, Map<String, Object> map) {
		// 用于接收返回的数据
		StringBuffer sb = new StringBuffer();
		// 创建一个连接的请求
		HttpURLConnection httpURLConnection = null;
		try {
			StringBuffer t_s = new StringBuffer(url).append("?");
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				t_s.append(entry.getKey() + "=" + entry.getValue() + "&");
			}
			url = t_s.substring(0, t_s.length() - 1);
			// 包装请求的地址
			URL urls = new URL(url);
			// 打开连接
			httpURLConnection = (HttpURLConnection) urls.openConnection();
			httpURLConnection.setRequestMethod("GET");
			// 通过BufferReader读取数据
			InputStream iStream = httpURLConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(iStream);
			BufferedReader bReader = new BufferedReader(inputStreamReader);
			String temp = null;
			while ((temp = bReader.readLine()) != null) {
				sb.append(temp);
			}
			// 关闭流(先开后关，后开先关)
			bReader.close();
			inputStreamReader.close();
			iStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (httpURLConnection != null) {
				// 关闭连接
				httpURLConnection.disconnect();
			}
		}
		return sb.toString();
	}

}
