package dto;

public class userInformationDTO {
	private String user_Name; 
	private String user_password;  
	private String user_password_1; 
	private String user_real_name;
	private String user_phone_num ;    
	private int user_age;         
	private String user_sex;
	
	
	public userInformationDTO() {
		
	}


	public userInformationDTO(String user_Name, String user_password, String user_password_1, String user_real_name,
			String user_phone_num, int user_age, String user_sex) {
		super();
		this.user_Name = user_Name;
		this.user_password = user_password;
		this.user_password_1 = user_password_1;
		this.user_real_name = user_real_name;
		this.user_phone_num = user_phone_num;
		this.user_age = user_age;
		this.user_sex = user_sex;
	}


	public String getUser_Name() {
		return user_Name;
	}


	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getUser_password_1() {
		return user_password_1;
	}


	public void setUser_password_1(String user_password_1) {
		this.user_password_1 = user_password_1;
	}


	public String getUser_real_name() {
		return user_real_name;
	}


	public void setUser_real_name(String user_real_name) {
		this.user_real_name = user_real_name;
	}


	public String getUser_phone_num() {
		return user_phone_num;
	}


	public void setUser_phone_num(String user_phone_num) {
		this.user_phone_num = user_phone_num;
	}


	public int getUser_age() {
		return user_age;
	}


	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}


	public String getUser_sex() {
		return user_sex;
	}


	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	
	
	
	
}
