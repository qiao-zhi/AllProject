package cn.itcast.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
//  ����������ȫ��String����
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
	
     
	//��֤�û�����Ϊ��
	//��֤���벻��Ϊ��
	//��֤ȷ�����벻��Ϊ�գ����Һ͵�һ��һ��
	//��֤���䲻��Ϊ���ҺϷ�
	//���տ���Ϊ�գ��еĻ�����Ϸ�
	//�ǳƲ���Ϊ�գ�����Ҫ�Ǻ���
	public boolean validate() {
		boolean isOK=true;
		if(this.username==null||this.username.trim().equals("")){
			isOK=false;
			errors.put("username", "ֵ����Ϊ�գ�");
		}else{
			if(!this.username.matches("[a-zA-Z0-9]{3,8}")){
				isOK=false;
				errors.put("username", "������3-8����ĸ������");
			}
		}
		
		
		
		if(this.password==null||this.password.trim().equals("")){
			isOK=false;
			errors.put("password", "ֵ����Ϊ�գ�");
		}else{
			if(!this.password.matches("[a-zA-Z0-9]{3,8}")){
				isOK=false;
				errors.put("password", "������3-8����ĸ������");
			}
		}
		
		
		if(this.password2==null||this.password2.trim().equals("")){
			isOK=false;
			errors.put("password2", "ֵ����Ϊ�գ�");
		}else{
			if(!this.password2.equals(this.password)){
				isOK=false;
				errors.put("password2", "��������Ҫһ��");
			}
		}
		
		
		if(this.email==null||this.email.trim().equals("")){
			isOK=false;
			errors.put("email", "ֵ����Ϊ�գ�");
		}else{
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK=false;
				errors.put("email", "������Ϸ��������ʽ");
			}
		}
		
		
		//����ֻ�Էǿս���У��
		if(this.birthday!=null&&!this.birthday.trim().equals("")){
         try{
			DateLocaleConverter dlc=new DateLocaleConverter();
			dlc.convert(birthday, "yyyy-MM-dd");
			}
         catch(Exception e){
        	 isOK=false;
        	 errors.put("birthday", "���ڸ�ʽ����");
        	 
         }
         
		}
		
		//��֤����
		if(this.nickname==null||this.nickname.trim().equals("")){
			isOK=false;
			errors.put("nickname", "ֵ����Ϊ�գ�");
		}else{
			if(!this.nickname.matches("^([\u4e00-\u9fa5]+)$")){
				isOK=false;
				errors.put("nickname", "�����뺺��");
			}
		}
		
		
		return isOK;
	}
	

}
