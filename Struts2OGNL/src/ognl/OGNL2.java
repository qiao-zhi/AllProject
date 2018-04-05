package ognl;

import java.util.HashMap;
import java.util.Map;

public class OGNL2 {
	/*
	 * 前面带#person1代表取普通对象的值，不在集合中就取不到报异常。（带#的对象必须在容器中）
	 * 前面不带#,直接name表示取根对象的name属性，在不在容器中都能取出来
	 * 
	 * **/
	
//beanUtils工具可以完成这个功能
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Map<String,Object> context = new HashMap<String, Object>();	
	Person person1 = new Person();
	person1.setName("zhangsan");
	
	Person person2 = new Person();
	person2.setName("wangwu");
	
	Person person3 = new Person();
	person3.setName("zhaosi");
	
	Person person4 = new Person();
	person4.setName("sunliu");	
	
	context.put("person1", person1);
	context.put("person2", person2);
	context.put("person3", person3);
	
	try {
		//将person3作为一个根对象获取name属性，取根对象的属性时不用加#
		Object obj1 = Ognl.getValue("name", context, person3);
		System.out.println("person3 name:"+obj1);
		
		//将person2作为一个根对象获取name属性，取根对象的属性时不用加#
		//将person2作为根对象取person2对象的属性
		Object obj2 = Ognl.getValue("#person2.name", context, person2);
		System.out.println("person2 name:"+obj2);
		
		//将person2作为一个根对象获取name属性，取根对象的属性时不用加#
		//将person2作为根对象取person2对象的属性
		Object obj3 = Ognl.getValue("#person1.name", context, person2);
		System.out.println("person1 name:"+obj3);	
		
        //将person4作为根对象取根对象的值,可以取到值
		Object obj4 = Ognl.getValue("name", context, person4);
		System.out.println("person4 name:"+obj4);
		
        //将person4作为根对象取根person4的值会出异常，person4不在集合中
		Object obj5 = Ognl.getValue("#person4.name", context, person4);
		System.out.println("person5 name:"+obj5);			
		
        //将person4作为根对象取根person4的值会出异常，person4不在集合中
//		Object obj5 = Ognl.getValue("#person4.name", context, person4);
//		System.out.println("person5 name:"+obj5);
		
        //将person1作为根对象取根person4的值会出异常，person4不在集合中
//		Object obj6 = Ognl.getValue("#person4.name", context, person1);
//		System.out.println("person4 name:"+obj6);
		
	} catch (OgnlException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
