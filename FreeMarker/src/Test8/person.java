package Test8;

public class person {

	private String name;
	private String img;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public person(String name, String img, String password) {
		super();
		this.name = name;
		this.img = img;
		this.password = password;
	}
	public  person(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
}
