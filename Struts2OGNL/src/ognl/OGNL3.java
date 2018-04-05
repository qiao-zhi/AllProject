package ognl;

import java.util.HashMap;
import java.util.Map;

public class OGNL3 {
	/*
	 * 前面带#person1代表取普通对象的值，不在集合中就取不到报异常。（带#的对象必须在容器中）
	 * 前面不带#,直接name表示取根对象的name属性，在不在容器中都能取出来
	 * 
	 * **/
	
//beanUtils工具可以完成这个功能
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	OgnlContext context = new OgnlContext();
	Person person1 = new Person();
	person1.setName("zhangsan");
	
	Person person2 = new Person();
	person2.setName("wangwu");
	
	Person person3 = new Person();
	person3.setName("zhaosi");
		
	context.put("person1", person1);
	context.put("person2", person2);
	context.put("person3", person3);
	
	context.setRoot(person1);
	
	try {
		/*****调用成员方法****/
		Object obj1 = Ognl.getValue("name.length()", context, context.getRoot());
		System.out.println("person1 name 的长度是:"+obj1);
		
		//访问不是根对象的对象属性
		Object obj2 = Ognl.getValue("#person2.name.toUpperCase()", context, context.getRoot());
		System.out.println("person2 name 大写是:"+obj2);
		
		Object obj3 = Ognl.getValue("name.charAt(2)", context, context.getRoot());
		System.out.println("person1 name charAt(2) is :"+obj3);	
		
  	    //调用静态方法
		Object obj4 = Ognl.getValue("@java.lang.Math@min(4,10)",context, context.getRoot());
		System.out.println("调用静态方法取4与10 的较小值是:"+obj4);
		
  	    //调用静态变量
		Object obj5 = Ognl.getValue("@java.lang.Math@E",context, context.getRoot());
		System.out.println("调用静态变量取Mth中E值是:"+obj5);

	} catch (OgnlException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
