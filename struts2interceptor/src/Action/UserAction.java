package Action;

import com.opensymphony.xwork2.ActionContext;

public class UserAction {

	public String addUI(){
		ActionContext.getContext().put("msg", "成功执行了addUI操作");
		System.out.println("执行addui操作");
		return "success";
	}

	public String update(){
		ActionContext.getContext().put("msg", "成功执行了update操作");
		System.out.println("执行update操作");
		return "success";
	}
}
