package cn.qlq.web.Action;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.qlq.Service.UserService;

public class UserAction extends ActionSupport{

	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute(){
		userService.findUserById(0);
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		String ss = request.getParameter("name");
		request.setAttribute("username", ss);
		System.out.println(userService);
		return "success";
	}
}
