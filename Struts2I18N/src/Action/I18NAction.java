package Action;

import com.opensymphony.xwork2.ActionSupport;

public class I18NAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7879257373274577104L;

	public String execute(){
		System.out.println("开始执行");
		System.out.println(this.getText("welcome",new String[]{"乔利强","学习"}));
		String ss=this.getText("aa");
		System.out.println(this.getText("package"));
		System.out.println(ss);
		return "success";
	}
}
