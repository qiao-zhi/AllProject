package TestChuanzhi;

import org.junit.Test;

public class Demo1 {

	// 测试基本数据类型传值
	@Test
	public void test1() {
		int a=5;
		int b=a;
		b=6;
		System.out.println("b="+b);
		System.out.println("a="+a);
	}
	// 测试引用数据类型传值
	@Test
	public void test2() {
		User a = new User();
		User b=a;
		System.out.println("-----------未改变----------------");
		System.out.println("a的i是"+a.i);
		System.out.println("b的i是"+b.i);
		System.out.println("-----------改变b的i后----------------");
		b.setI(9);
		System.out.println("a的i是"+a.i);
		System.out.println("b的i是"+b.i);
	}
}

class User {
	int i = 1;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
