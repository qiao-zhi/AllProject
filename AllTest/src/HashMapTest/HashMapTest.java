package HashMapTest;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
/*		map.put("SSS", "SSS");
		map.put("5845", "RGFD");
		map.put("F", "SSS");
		map.put("5845", "SSS");
		map.put("GGGGGG", "SSS");*/
		for (int i=0;i<5;i++){
			map.put(""+i, i+"");
		}
		System.out.println("sss");//此时大小是16
		for (int i=5;i<18;i++){
			map.put(""+i, i+"");
		}
		System.out.println("sss");//此时大小是32
		for (int i=18;i<34;i++){
			map.put(""+i, i+"");
		}
		System.out.println("sss");//此时大小是64
	}
}
