package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAnnotationParser {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		获取字节码对象
		Class clazz = UseMyAnnotion.class;
		Method method = clazz.getMethod("show", String.class);
//		获取方法上面的注解
		MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
//		获取注解属性值
		System.out.println(annotation.name()+"\t"+annotation.value());
		
//		取到值就可以根据业务处理数据
		
		//激活方法，也就是让方法执行
		method.invoke(new UseMyAnnotion(), "HH");
	}
}
