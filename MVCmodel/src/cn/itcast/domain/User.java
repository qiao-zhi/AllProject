package cn.itcast.domain;

import java.util.Date;

public class User {

	private String username;
	private String password;
	private String email;
	private Date birthday;
	private String nickname;
	public User() {
	}
	
	
	public User(String username, String password, String email, Date birthday, String nickname) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.nickname = nickname;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
