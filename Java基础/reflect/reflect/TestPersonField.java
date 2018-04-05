package reflect;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Test;

public class TestPersonField {


	//反射字段:public String name;
	@Test
	public void test() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	
		Person p = new Person();
		Class clazz = Class.forName("Person");   //加载类
		Field f= clazz.getField("name");
		//获取字段类型
		Class type = f.getType();
		System.out.println(type);
		
		//获取字段值
		String name = (String) f.get(p);
		System.out.println(name);
		
		
		//给字段设置值
		f.set(p, "QLQ");
		System.out.println((String) f.get(p));
		
	}
	
	
	
	//反射字段:private String sex="男";
	@Test
	public void test1() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	
		Person p = new Person();
		Class clazz = Class.forName("Person");   //加载类
		Field f= clazz.getDeclaredField("sex");   //访问私有化时要加declared,之后强制使其可见
		f.setAccessible(true);   //暴力反射
		//获取字段类型
		Class type = f.getType();
		System.out.println(type);
		
		//获取字段值
		String name = (String) f.get(p);
		System.out.println(name);
		
		
		//给字段设置值
		f.set(p, "女");
		System.out.println((String) f.get(p));
		
	}

}
