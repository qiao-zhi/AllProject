package reflect;
import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.Test;


public class TestPersonConstructor {

	@Test
	public void test() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		Class clazz1 = Class.forName("Person");   //Class 类的实例表示正在运行的 Java 应用程序中的类和接口（类加载）
		Constructor  c=clazz1.getConstructor(null);    //获取其无参构造方法
		Person p = (Person) c.newInstance();           //默认调用其无参构造方法
		System.out.println(p.age);
	}
	
	@Test
	public void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		Class clazz2 = Class.forName("Person");   //Class 类的实例表示正在运行的 Java 应用程序中的类和接口（类加载）
		Constructor  c2=clazz2.getConstructor(String.class);    //获取其带一个String类型参数的构造方法
		Person p2 = (Person) c2.newInstance("WWWWWWWWW");//默认调用其无参构造方法
		System.out.println(p2.age);
	}
	
	@Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		Class clazz2 = Class.forName("Person");   //Class 类的实例表示正在运行的 Java 应用程序中的类和接口（类加载）
		Constructor  c2=clazz2.getConstructor(String.class,int.class);    //获取其带两个参数的构造方法
		Person p2 = (Person) c2.newInstance("WWWWWWWWW",89);//拿上面的构造方法创建一个实例对象
		System.out.println(p2.age);
//		Java里面任何一个类都是用Class表示的
		
	}
	
	
//	用私有化构造方法创造实例(强制访问私有化构造方法)
	@Test
	public void test3() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		Class clazz2 = Class.forName("Person");   //Class 类的实例表示正在运行的 Java 应用程序中的类和接口（类加载）
		Constructor  c2=clazz2.getDeclaredConstructor(List.class);    //获取其private方法
		c2.setAccessible(true);   //暴力反射
		Person p2 = (Person) c2.newInstance(new ArrayList());//拿上面的构造方法创建一个实例对象
//		Java里面任何一个类都是用Class表示的
		
	}

}
