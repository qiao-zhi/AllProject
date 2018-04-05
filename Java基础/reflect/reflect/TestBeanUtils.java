package reflect;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class TestBeanUtils {

	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException{
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "QLQ");
		System.out.println(p.getName());
	}
	
	
	//BeanUtils给对象封装属性，只支持基本数据类型转换，特殊的需要注册转换器
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException{
		
		String name="QLQ";
		String sex="nan";
		String age="26";
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "sex", sex);
		BeanUtils.setProperty(p, "age", age);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getSex());
	}
	
	
	//BeanUtils给对象封装属性，带有特殊的日期类型的字段
	@Test
	public void test3() throws IllegalAccessException, InvocationTargetException{
		
		String name="QLQ";
		String sex="nan";
		String age="26";
		String date="1995-02-03";
		//注册一个本地日期转换器，存在Bug，为空时抛异常
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "sex", sex);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", date);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getSex());
		System.out.println(p.getBirthday());
	}
	
	
	//BeanUtils给对象封装属性，带有特殊的日期类型的字段（自己写的日期转换器）
	@Test
	public void test4() throws IllegalAccessException, InvocationTargetException{
		
		String name="QLQ";
		String sex="nan";
		String age="26";
		String date="1995-02-03";
		//注册一个本地日期转换器，存在Bug，为空时抛异常
		ConvertUtils.register(new Converter(){
			//value指定要转的值，下面Date.class指定要转成date类型
			@Override
			public Object convert(Class type, Object value) {
				
				if(value==null){
					return null;
					}
				if(!(value instanceof String)){throw new ConversionException("只支持字符串转date");}
                String value1 = (String) value;
                if(value1.trim().equals("")){return null;}
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                	System.out.println("日期转换器");
                	return df.parse(value1); //覆盖父类的方法只能抓，不能比父类抛出更多的异常
				} catch (ParseException e) {

					throw new RuntimeException(e);
				}
			
			}
			
		},Date.class);
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "sex", sex);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", date);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getSex());
		System.out.println(p.getBirthday());
	}
	
	
	//BeanUtils给对象封装属性，用Map中值封装
	@Test
	public void test5() throws IllegalAccessException, InvocationTargetException{
		
		Map map = new HashMap();
        map.put("name", "qiaoliqiang");
        map.put("age", "80");
        map.put("sex", "nan");
        map.put("birthday", "1995-02-03");
		//注册一个本地日期转换器，存在Bug，为空时抛异常
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		Person p = new Person();
		//使用map的值封装对象属性
		BeanUtils.populate(p, map);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getSex());
		System.out.println(p.getBirthday().toLocaleString());
	}
	
}
