import java.io.InputStream;
import java.util.List;

import org.xml.sax.InputSource;

public class Person {
	public String name;
	public int age=28;
	private String sex="男";
	private  static String id="25";
	public Person() {
		System.out.println("无参被调用");
	}
	

	public Person(String name) {
		System.out.println("一个参数被调用"+name);
		this.name = name;
	}


	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("两个参数的构造方法被调用"+name+"\t"+age);
	}
	
	

	private Person(List list) {

		System.out.println("List私有化参数");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public void aa1() {
		System.out.println("aa1");
	}
	
	
	public void aa1(String name,int password) {
		System.out.println(name+":"+password);
	}
	
	public Class[] aa1(String name,int[] password) {
		System.out.println(name+":"+password);
		return new Class[]{String.class,int.class};
	}
	
	public void aa1(InputStream in) {
		
		System.out.println(in);

	}
	
	
	
	
	private void aa1(int in) {
		
		System.out.println(in);

	}
		
	public static void aa1(boolean in) {
		
		System.out.println(in);

	}
	
	
	
	

}
