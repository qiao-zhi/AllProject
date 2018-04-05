package ss;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;

public class User1 implements ServletRequestAware,ServletResponseAware,ServletContextAware{

	private HttpServletResponse response;
	private HttpServletRequest request ;
	private ServletContext context;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute(){
		ActionContext ac = ActionContext.getContext();
		
        /*第一中
         * ac.put("req", "request");   //向request域中存
        ac.getSession().put("sess", "session");//向session域中存
        ac.getApplication().put("app", "application");//向application域中存
*/      

/*		
 *         第二种
 *      HttpServletRequest request = ServletActionContext.getRequest();
		PageContext page = ServletActionContext.getPageContext();
		HttpSession session = request.getSession();
		session.setAttribute("sess", "123456");
		HttpServletResponse response = ServletActionContext.getResponse();*/
		System.out.println(user.getUsername()+"\t"+user.getBirthday());
		request.setAttribute("req", "自动设置值");
		return "success";
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.context=arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
}
