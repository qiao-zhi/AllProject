package cn.qlq.bean;

public class User {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
//	空参构造方法
	public User() {
		
	}
//	带字段构造方法
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	

}