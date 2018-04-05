package Action;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport {

	private String username;
	private String password;
	private String mobile;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String login(){
		System.out.println("执行了login操作");
		return "success";
	}
	
	public String update(){
		System.out.println("执行了update操作");
		return "success";
	}
/*	//所有的方法,login,update均会进行验证
		@Override
		public void validate() {

			if(username==null||username.equals("")){
				this.addFieldError("username", "username不能为空");
			}
			if(password==null||password.equals("")){
				this.addFieldError("password", "password不能为空");
			}
			if(mobile==null||mobile.equals("")){
				this.addFieldError("mobile", "mobile不能为空");
			}
		}
		*/
		
/*		//单独验证login方法
		public void validateLogin() {

			if(username==null||username.equals("")){
				this.addFieldError("username", "username不能为空");
			}
			if(password==null||password.equals("")){
				this.addFieldError("password", "password不能为空");
			}
			if(mobile==null||mobile.equals("")){
				this.addFieldError("mobile", "mobile不能为空");
			}
		}*/
}

