package reflect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;


public class TestPersonMethod {

	//反射类的方法:	public void aa1() 
    @Test
	public void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Person p = new Person();
		Class clazz = Class.forName("Person");   //加载类
		Method method = clazz.getMethod("aa1", null); //获得名字为aa1，无参数的方法
		method.invoke(p, null);	//调用p对象的该方法，无参数u
	}
    

    
    //反射类的方法:public void aa1(String name,int password)
    @Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Person p = new Person();
		Class clazz = Class.forName("Person");   //加载类
		Method method = clazz.getMethod("aa1", String.class,int.class); //获得名字为aa1，无参数的方法
		method.invoke(p, "QLQ",25);	//调用p对象的该方法，无参数u
	}
    
    
    
    //反射类的方法:public Class[] aa1(String name,int[] password) 
    @Test
	public void test3() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Person p = new Person();
		Class clazz = Class.forName("Person");   //加载类
		Method method = clazz.getMethod("aa1", String.class,int[].class); //获得名字为aa1，无参数的方法
		Class[] c=(Class[]) method.invoke(p, "QLQ",new int[]{1,2,3});	//调用p对象的该方法，无参数u
		System.out.println(c[0]);
	}
    
    
    
    //反射类的方法:	public void aa1(InputStream in) 
    @Test
	public void test4() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException{
		Person p = new Person();
		Class clazz = Class.forName("Person");   //加载类
		Method method = clazz.getMethod("aa1", InputStream.class); //获得名字为aa1，无参数的方法
		method.invoke(p, new FileInputStream("F:\\1.txt"));	//调用p对象的该方法，无参数u
	}
    
    
    
    
    
    //反射类的方法:private void aa1(int in) {
    @Test
	public void test5() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException{
		Person p = new Person();
		Class clazz = Class.forName("Person");   //加载类
		Method method = clazz.getDeclaredMethod("aa1", int.class); //获得名字为aa1，无参数的方法
		method.setAccessible(true);  //访问其私有化方法
		method.invoke(p,4);//调用p对象的该方法，无参数u
	}
    
    
    
    //反射类的方法:public static void aa1(boolean in) 
    @Test
	public void test6() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException{
		Class clazz = Class.forName("Person");   //加载类
		Method method = clazz.getMethod("aa1", boolean.class); //获得名字为aa1，无参数的方法
		method.invoke(null,true);//调用静态方法
	}
    
    
}
