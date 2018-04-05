package Test;

import org.junit.Test;

public class TestDemo {

	@Test
	public void test1(){
		System.out.println("这是测试1");
	}
	@MyTest
	public void test2(){
		System.out.println("这是测试2");
	}
	@MyTest
	public void test3(){
		System.out.println("这是测试3");
	}
}
