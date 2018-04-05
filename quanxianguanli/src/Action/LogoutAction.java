package Action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Bean.Menu;

public class LogoutAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8811002388179279535L;

	@Override
	public String execute() throws Exception {
		System.out.println("注销");
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 session.removeAttribute("user");
		return super.execute();
	}

}
