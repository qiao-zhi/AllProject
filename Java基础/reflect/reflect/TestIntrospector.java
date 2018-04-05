package reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestIntrospector {

	//获取Bean的所有属性
	@Test
	public void test() throws IntrospectionException{
		BeanInfo bi = Introspector.getBeanInfo(Person.class, Object.class);  //BeanInfo相当于bean的所有属性
		PropertyDescriptor pd[] = bi.getPropertyDescriptors();//拿到每一个属性的属性描述器
		for(PropertyDescriptor pd1:pd){
			System.out.println(pd1.getName());
		}
	}
	
	
	//操纵Bean的特定属性:age
	@Test
	public void test1() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//获得特定属性的属性描述器
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		Method me = pd.getReadMethod();//获取其get方法
		System.out.println("第一次读取属性:"+me.invoke(p, null));
		
		Method me1 = pd.getWriteMethod();//获取其set方法
		me1.invoke(p, 84);//调用其set方法
		System.out.println("第一次读取属性:"+me.invoke(p, null));
		System.out.println(p.getAge());
		
	}
	
	
	
}
