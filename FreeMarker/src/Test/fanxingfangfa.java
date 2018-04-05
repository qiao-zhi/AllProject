package Test;

import org.junit.Test;

public class fanxingfangfa {

	/**
	 * 定义一个泛型类，泛型方法也可以声明为static
	 *@param t1
	 */
//	public static <T> void testFanxing(T t1){
	public <T> void testFanxing(T t1){
		System.out.println(t1);
	}
	
	
	//测试泛型类
	@Test
	public void test1(){
		fanxingfangfa fx=new fanxingfangfa();
		fx.testFanxing(2);
		fx.testFanxing("字符串");
		fx.testFanxing(new User("1", "QLQ"));
	}
}

//用于测试泛型类的类
class User{
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	protected User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}