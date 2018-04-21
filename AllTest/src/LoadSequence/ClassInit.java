package LoadSequence;

public class ClassInit {

	/**
	 * @Title: main @Description: 类初始化顺序测试 @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {

		new B();
	}

}

class A {
	static {
		System.out.println("A的static代码块...");// 1
	}
	{
		System.out.println("A的代码块...");// 1
	}
	public String s1 = prtString("A的成员变量...");
	public static String s2 = prtString("A的static变量...");// 2

	public A() {
		System.out.println("A的构造函数...");
	}

	public static String prtString(String str) {
		System.out.println(str);
		return null;
	}
}

class B extends A {
	public String ss1 = prtString("B的成员变量...");
	{
		System.out.println("B的代码块...");
	}
	public static String ss2 = prtString("B的static变量...");// 3.

	public B() {
		System.out.println("B的构造函数...");
	}

	private static A a = new A();// 4.
	static {
		System.out.println("B的static代码块...");
	}
}