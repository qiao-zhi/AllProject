package Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestParser {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
//		获得字节码对象
		Class clazz = TestDemo.class;
//		获取全部方法
		Method[] methods = clazz.getMethods();
//		提取注解为MyTest的方法
		for(Method method:methods){
			boolean annotationPresent = method.isAnnotationPresent(MyTest.class);	
			if(annotationPresent){
				method.invoke(clazz.newInstance(), null);
			}
		}
	}
}
