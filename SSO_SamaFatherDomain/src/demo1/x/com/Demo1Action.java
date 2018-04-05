package demo1.x.com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Demo1主页，访问主页要先验证cookie
 * 
 * @author: qlq
 * @date : 2017年8月29日下午12:02:31
 */
public class Demo1Action extends ActionSupport {

	private String gotoUrl;

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
					String result = this.doGet("http://check.x.com:8080/sso/checkCookie.action", cookie.getName(),
							cookie.getValue());
					if ("1".equals(result)) {
						return SUCCESS;
					}
				}
			}
		}
		// 登陆失败后将gotoUrl写到JSP页面
		gotoUrl = "http://demo1.x.com:8080/demo1/main.action";
		return LOGIN;
	}

	public String doGet(String url, String cookieName, String cookieValue) {
		// 用于接收返回的数据
		StringBuffer sb = new StringBuffer();
		// 创建一个连接的请求
		HttpURLConnection httpURLConnection = null;
		try {
			// 包装请求的地址
			URL urls = new URL(url + "?cookieName=" + cookieName + "&cookieValue=" + cookieValue);
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
