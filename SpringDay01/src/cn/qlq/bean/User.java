package cn.qlq.bean;

public class User {

	private String name;
	private int age;
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public User() {
		System.out.println("空参构造方法被调用！！！！");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	public void init(){
		System.out.println("我是初始化方法");
	}
	
	public void destroy(){
		System.out.println("我是销毁方法");
	}
	
	
}
