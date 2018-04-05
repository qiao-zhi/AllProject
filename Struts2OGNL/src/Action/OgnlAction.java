package Action;

import com.opensymphony.xwork2.ActionContext;
import com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException;

public class OgnlAction {

	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute(){
		ActionContext ac = ActionContext.getContext();
		ac.put("req", "request");
		ac.getSession().put("ses", "Session");
		ac.getApplication().put("app", "application");
		message="hello1!";
		return "success";
	}
}
