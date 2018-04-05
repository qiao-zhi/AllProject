package bean;

public class TestFreemarkerBean {

	private String name;
	private String password;
	private String sex;
	private String photo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public TestFreemarkerBean(String name, String password, String sex, String photo) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.photo = photo;
	}
	
	
}
