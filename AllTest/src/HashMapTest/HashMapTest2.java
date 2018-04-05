package HashMapTest;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest2 {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		for (int i=0;i<5;i++){
			map.put(i, i+"");
		}
		System.out.println("sss");//此时大小是16
		for (int i=5;i<14;i++){
			map.put(i, i+"");
			if(i==13)map.put(i, "第二个3");
		}
		System.out.println("sss");//此时大小是32
		for (int i=18;i<30;i++){
			map.put(i, i+"");
		}
		System.out.println("sss");//此时大小是64
	}
}
