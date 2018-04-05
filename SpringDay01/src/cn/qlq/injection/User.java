package cn.qlq.injection;

public class User {

	private String name;
	private int age;
	private Car car;
	
	protected User(String name, Car car) {
		System.out.println("User(String name, Car car)");
		this.name = name;
		this.car = car;
	}
	
	protected User( Car car,String name) {
		System.out.println("User( Car car,String name)");
		this.name = name;
		this.car = car;
	}
	protected User( Car car,Integer name) {
		System.out.println("User( Car car,Integer name)");
		this.name = name+"";
		this.car = car;
	}
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

	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	public void init(){
		System.out.println("我是初始化方法");
	}
	
	public void destroy(){
		System.out.println("我是销毁方法");
	}
	
	
}
