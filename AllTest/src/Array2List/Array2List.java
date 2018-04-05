package Array2List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Array2List {

	/**
	 * 错误的做法 此种方法返回的list不具有任何添加或移除元素的任何方法。因为该类的大小(size)是固定的。
	 */
	@Test
	public void test1() {
		String attr[] = { "1", "2", "3" };
		List<String> list = Arrays.asList(attr);
		list.add("4");// 报错
		for (String s : list) {
			System.out.println(s);
		}
	}

	/**
	 * 正确的做法 
	 * ArrayList的构造方法可以接受一个Collection类型的对象，而我们的 java.util.Arrays.ArrayList正好也是它的一个子类
	 */
	@Test
	public void test2() {
		String attr[] = { "1", "2", "3" };
		List<String> list = new ArrayList<String>(Arrays.asList(attr));
		list.add("4");// 不会报错
		for (String s : list) {
			System.out.println(s);// 1234
		}
	}

	/**
	 * 更加高效的做法
	 *  ArrayList的构造方法可以接受一个Collection类型的对象，而我们的 java.util.Arrays.ArrayList正好也是它的一个子类
	 */

	@Test
	public void test3() {
		String attr[] = { "1", "2", "3" };
		List<String> list = new ArrayList<String>(attr.length);
		Collections.addAll(list, attr);
		list.add("4");// 不会报错
		for (String s : list) {
			System.out.println(s);// 1234
		}
		System.out.println("sss");
	}

}
