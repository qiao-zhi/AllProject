package ognl;

import java.util.ArrayList;
import java.util.List;

public class OGNL5 {
	/*
	 * 
	 * **/
	
//beanUtils工具可以完成这个功能
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OgnlContext context = new OgnlContext();
		humen hu = new humen();
		hu.setAge(22);
		hu.setName("QLQ");
		hu.setSex("nan");
		hu.getFriends().add(new humen("hu111111","nan",25));
		hu.getFriends().add(new humen("hu2","nan",26));
		hu.getFriends().add(new humen("hu3","nan",27));
		hu.getFriends().add(new humen("hu4","nan",28));
		hu.getFriends().add(new humen("hu5","nan",29));
		
		context.put("humen", hu);
		context.setRoot(hu);
	
		try {
			//取名字长度大于7的对象
			Object obj1 = Ognl.getValue("friends.{?#this.name.length()>7}", context, context.getRoot());
			System.out.println(obj1);
			
			//取名字所有name属性集合
			Object obj2 = Ognl.getValue("friends.{name}", context, context.getRoot());
			System.out.println(obj2);
			
			
		} catch (OgnlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

class humen{
	private String name;
	private String sex;
	private int  age;
	private List<humen> friends = new ArrayList<humen>();
	public String getName() {
		return name;
	}

	
	protected humen(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}


	public humen() {

	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<humen> getFriends() {
		return friends;
	}
	public void setFriends(List<humen> friends) {
		this.friends = friends;
	}


	@Override
	public String toString() {
		return "humen [name=" + name + ", sex=" + sex + ", age=" + age + ", friends=" + friends + "]";
	}
	
	
}
