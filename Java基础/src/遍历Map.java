

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
public class 遍历Map {
	@Test
	public void test1(){
		Map map=new LinkedHashMap();
		map.put("111", "aaa");
		map.put("222", "bbb");
		map.put("333", "ccc");
		Set set=map.entrySet();//取出其key值作为一个Set集合
		Iterator it = set.iterator();
		while (it.hasNext()){
			Map.Entry entry=(Entry) it.next();
			System.out.println(entry.getKey()+"  "+entry.getValue());
			
		}
		
	}
	
	
	@Test
	public void test2(){
		Map map=new HashMap();
		map.put("111", "aaa");
		map.put("222", "bbb");
		map.put("333", "ccc");
		Set set=map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()){
			String key = (String) it.next();
			String value = (String) map.get(key);
			System.out.println(key+"  "+value);
			
		}
		
	}
		
	@Test
	public void test3(){
		Map map1=new HashMap();
		map1.put("111", "aaa");
		map1.put("222", "bbb");
		map1.put("333", "ccc");
		for(Object obj:map1.keySet()){  //将键映射为set集合
		String key = (String) obj;	
		System.out.println(map1.get(key));
		}
		}
	
	@Test
	public void test4(){
		Map map1=new HashMap();
		map1.put("111", "aaa");
		map1.put("222", "bbb");
		map1.put("333", "ccc");
		for(Object obj:map1.entrySet()){   //将键-值映射为set集合，存的是Entry类对象（键值映射）
		Map.Entry entry= (Entry) obj;	
		System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		}
	
}
