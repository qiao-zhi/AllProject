package cn.itcast.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
//  表单传过来的全是String类型
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private Map<String, String> errors=new HashMap<String, String>();
	
	
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public RegisterForm() {
		// TODO Auto-generated constructor stub
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
     
	//验证用户名不为空
	//验证密码不能为空
	//验证确认密码不能为空，并且和第一个一样
	//验证邮箱不能为空且合法
	//生日可以为空，有的话必须合法
	//昵称不能为空，并且要是汉字
	public boolean validate() {
		boolean isOK=true;
		if(this.username==null||this.username.trim().equals("")){
			isOK=false;
			errors.put("username", "值不能为空！");
		}else{
			if(!this.username.matches("[a-zA-Z0-9]{3,8}")){
				isOK=false;
				errors.put("username", "请输入3-8个字母或数字");
			}
		}
		
		
		
		if(this.password==null||this.password.trim().equals("")){
			isOK=false;
			errors.put("password", "值不能为空！");
		}else{
			if(!this.password.matches("[a-zA-Z0-9]{3,8}")){
				isOK=false;
				errors.put("password", "请输入3-8个字母或数字");
			}
		}
		
		
		if(this.password2==null||this.password2.trim().equals("")){
			isOK=false;
			errors.put("password2", "值不能为空！");
		}else{
			if(!this.password2.equals(this.password)){
				isOK=false;
				errors.put("password2", "两次密码要一致");
			}
		}
		
		
		if(this.email==null||this.email.trim().equals("")){
			isOK=false;
			errors.put("email", "值不能为空！");
		}else{
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK=false;
				errors.put("email", "请输入合法的邮箱格式");
			}
		}
		
		
		//生日只对非空进行校验
		if(this.birthday!=null&&!this.birthday.trim().equals("")){
         try{
			DateLocaleConverter dlc=new DateLocaleConverter();
			dlc.convert(birthday, "yyyy-MM-dd");
			}
         catch(Exception e){
        	 isOK=false;
        	 errors.put("birthday", "日期格式不对");
        	 
         }
         
		}
		
		//验证邮箱
		if(this.nickname==null||this.nickname.trim().equals("")){
			isOK=false;
			errors.put("nickname", "值不能为空！");
		}else{
			if(!this.nickname.matches("^([\u4e00-\u9fa5]+)$")){
				isOK=false;
				errors.put("nickname", "请输入汉字");
			}
		}
		
		
		return isOK;
	}
	

}
