package TestFor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		long start_1 = System.currentTimeMillis();
		System.out.println("第一种方法开始:");
		Student stu = null;
		Map map = null;
		for (int i = 0; i < 10; i++) {
			map = new HashMap<>();
			map.put("第" + i + "个", i + 10);
			result.add(map);
		}
		long end_1 = System.currentTimeMillis();
		System.out.println("程序结束，用时:" + (end_1 - start_1));
	}

	@Test
	public void test2() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		long start_1 = System.currentTimeMillis();
		System.out.println("第一种方法开始:");

		for (int i = 0; i < 10; i++) {
			Map map = new HashMap<>();
			map.put("第" + i + "个", i + 10);
			result.add(map);
		}
		long end_1 = System.currentTimeMillis();
		System.out.println("程序结束，用时:" + (end_1 - start_1));
	}

}
