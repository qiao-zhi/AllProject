package cn.qlq.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


//这四个注解将类注入到配置文件中，等价于<bean name="user" class="cn.qlq.injection.User" ></bean>

//@Component("user")   //没有分层
//@Service("user")    //service层
//@Controller("user")    //控制层
@Repository("user")       //dao层
@Scope("singleton")   //修改对象的作用范围，默认是singleton
public class User {

	@Value("QLQ")
	private String name;
	private int age;
/*	@Autowired   //自动装配，有多个对象时不知道该装配哪个对象，需配合下面的
	@Qualifier("car")   //告诉spring容器自动装配哪个对象
*/	
	@Resource(name="car")  //手动注入，指定注入对象的名称
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
	@Value("19")
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
	@PostConstruct
	public void init(){
		System.out.println("我是初始化方法");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("我是销毁方法");
	}
	
	
}
