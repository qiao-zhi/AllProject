
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import org.junit.Test;

public class MapListVector {

	@Test
	public void testVector() {
		System.out.println("-------------------vector------------------");
		Vector<String> v = new Vector<String>();
		v.add("sss");
		v.add("sssss");
		System.out.println("-------普通for循环----");
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
		System.out.println("-------增强for循环----");
		for (String x : v) {
			System.out.println(x);

		}
		System.out.println("-------迭代器遍历----");
		Iterator<String> iterator = v.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Test
	public void testMap() {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(1, "s");
		m.put(2, "s");
		m.put(3, "s");
		m.put(4, "s");
		System.out.println("-------------------map------------------");
		System.out.println("--------循环遍历键取值---------");
		for (Map.Entry<Integer, String> entry : m.entrySet()) {
			System.out.println(entry.getKey() + "   " + entry.getValue());
		}
		System.out.println("--------根据键取值(键正好为整数)---------");
		for (int i = 0; i < m.size(); i++) {
			System.out.println(m.get(i + 1));
		}
	}

	@Test
	public void testList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println("-------------------list------------------");
		System.out.println("-------增强for循环list----");
		for (int i : list) {
			System.out.println(i);
		}
		System.out.println("-------for循环list----");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-------迭代器遍历list----");
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	
	@Test
	public void testSet() {
		Set<Integer> set = new HashSet();
		set.add(1);
		set.add(2);
		System.out.println("-------------------set------------------");
		System.out.println("-------增强for循环----");
		for (int i : set) {
			System.out.println(i);
		}
		System.out.println("-------迭代器遍历----");
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
