package LoadSequence;

/**
 * 父类
 * 
 * @author: qlq
 * @date : 2018年4月9日下午1:49:15
 */
public class Parent {
	static {
		System.out.println("父类静态代码块");
	}
	{
		System.out.println("父类代码块");
	}
	public static String string = "父类静态属性";
	 String string_1 = "父类属性";

	protected Parent(String string_1) {
		System.out.println("父类构造方法");
	}

}
