package Java_ClassLoader;

public class GetClass {

	public static void main(String[] args) {
		try {
			// 前面加上包名
//			Class clazz = Class.forName("Java_ClassLoader.Sub");
			Class clazz = Java_ClassLoader.Sub.class;
			Base base = (Base) clazz.newInstance();
			base.f();
		} catch (Exception e) {

		}
	}
}

class Base {

	public void f() {
		System.out.println("Base");
	}
}

class Sub extends Base {

	public void f() {
		System.out.println("Sub");
	}
}
