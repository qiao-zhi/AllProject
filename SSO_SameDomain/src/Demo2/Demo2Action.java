package Demo2;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import utils.CheckCookie;

/**
 * Demo2主页，访问主页要先验证cookie
 * 
 * @author: qlq
 * @date : 2017年8月29日下午12:02:31
 */
public class Demo2Action extends ActionSupport {

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
		if (CheckCookie.checkCookie(request))
			return SUCCESS;
		// 登陆失败后将gotoUrl写到JSP页面
		gotoUrl = "/demo2/main.action";
		return LOGIN;
	}

}
