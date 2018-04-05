package Equals;

import java.util.ArrayList;
import java.util.List;

public class equalsTest {
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
		List list = new ArrayList();
		String str = null;
		System.out.println("0".equals(str));
//		System.out.println(str.equals("0"));
//		System.out.println("0".equals(list.get(2)));
		System.out.println(list.get(2).equals("0"));
	}
}
