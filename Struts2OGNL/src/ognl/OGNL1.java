package ognl;

public class OGNL1 {
//beanUtils工具可以完成这个功能
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person = new Person();
		person.setName("QLQ");
		person.setAge(30);
		Object obj;
		try {
			//获取根对象的属性值
			obj = Ognl.getValue("name", person);
			System.out.println(obj);
			//类似于反射中的根据属性名获取属性值
			System.out.println(Ognl.getValue("age", person));
		} catch (OgnlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
