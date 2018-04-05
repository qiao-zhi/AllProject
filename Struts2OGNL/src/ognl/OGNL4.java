package ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OGNL4 {
	/***
	 * OGNL可以创建List集合，认为List与Arrays一样的
	 * Ognl创建List时直接{'value1','value2','value3'}
	 * Ognl创建Map时直接#{'key1':'value1','key2':'value2'}
	 * **/
//beanUtils工具可以完成这个功能
	public static void main(String[] args) {

		OgnlContext context = new OgnlContext();
		ClassRoom classRoom = new ClassRoom();
		classRoom.getStudents().add("zhangsan");
		classRoom.getStudents().add("lisi");
		classRoom.getStudents().add("wangwu");
		classRoom.getStudents().add("zhaoliu");
		
		Student student = new Student();
		student.getContactWays().put("phoneNumber", "110");
		student.getContactWays().put("companyNumber", "120");
		student.getContactWays().put("mobileNumber", "112");
		
		
		context.put("classRoom", classRoom);
		context.put("student", student);
		
		context.setRoot(classRoom);
		

		try {
			//获取classRoom的students集合
			Object obj1 = Ognl.getValue("students", context, context.getRoot());
			System.out.println(obj1);
			//获取classRoom的students集合中第一个元素
			Object obj2 = Ognl.getValue("students[0]", context, context.getRoot());
			System.out.println(obj2);
			
			//获取classRoom的students集合的大小(获取集合中元素个数)
			Object obj3 = Ognl.getValue("students.size()", context, context.getRoot());
			System.out.println(obj3);	
			
			
			System.out.println("------------------飘逸的分割线-----------------");
			//获取不是根对象的集合
			Object obj4 = Ognl.getValue("#student.contactWays", context, context.getRoot());
			System.out.println(obj4);	
			
			//获取student对象中connectWays集合中键为mobileNumber的值
			Object obj5 = Ognl.getValue("#student.contactWays['mobileNumber']", context, context.getRoot());
			System.out.println(obj5);	
			
			//创建List集合
			Object obj6 = Ognl.getValue("{'aa','bb','cc'}", context, context.getRoot());
			System.out.println(obj6.getClass());
			System.out.println(obj6);
			
			//创建Map集合
			Object obj7 = Ognl.getValue("#{'aa':'AA','bb':'BB','cc':'CC'}", context, context.getRoot());
			System.out.println(obj7.getClass());
			System.out.println(obj7);
			
		} catch (OgnlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		}

}
class ClassRoom{
	private List<String> students = new ArrayList<String>();

	public List<String> getStudents() {
		return students;
	}

	public void setStudents(List<String> students) {
		this.students = students;
	}
	
}

class Student{
	private Map<String,Object> contactWays = new HashMap<String, Object>();

	public Map<String, Object> getContactWays() {
		return contactWays;
	}

	public void setContactWays(Map<String, Object> contactWays) {
		this.contactWays = contactWays;
	}
	
}