package com.thinkPro.steap.bean.sys.user;

public class UserAccount {

	private String uaid;
	private String u_id;
	private String account;
	private String password;

	public String getUaid() {
		return uaid;
	}

	public void setUaid(String uaid) {
		this.uaid = uaid;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserAccount [uaid=" + uaid + ", u_id=" + u_id + ", account=" + account + ", password=" + password + "]";
	}

}
