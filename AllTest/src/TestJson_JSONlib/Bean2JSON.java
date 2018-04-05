package TestJson_JSONlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.UnmarshallerHandler;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Bean2JSON {

//	测试单个对象转JSON,转单个对象用JSONObject
	@Test
	public void test1(){
		User user = new User("1", "QIAOZHI",25,"山西太原");
		JSONObject jsonObject =  JSONObject.fromObject(user);
		String json = jsonObject.toString();
		System.out.println(json);   
		//{"id":"1","name":"QIAOZHI","age":25,"address":"山西太原"}
	}
	
	
	
//	测试list转JSON，转集合用JSONArray，会产生[]
	@Test
	public void test2(){
		List<User> list = new ArrayList<User>();
		list.add(new User("1", "QIAOZHI",25,"山西太原"));
		list.add(new User("2", "QIAOZHI",25,"山西太原"));
		list.add(new User("3", "QIAOZHI",25,"山西太原"));
		JSONArray jsonArray =  JSONArray.fromObject(list);
		String json = jsonArray.toString();
		System.out.println(json);
//		[{"id":"1","name":"QIAOZHI","age":25,"address":"山西太原"},{"id":"2","name":"QIAOZHI","age":25,"address":"山西太原"},{"id":"3","name":"QIAOZHI","age":25,"address":"山西太原"}]
	}
	
//	测试map对象转JSON,转单个对象用JSONObject
	@Test
	public void test3(){
		Map<String,User> map = new HashMap<String,User>();
		map.put("1", new User("1", "QIAOZHI",25,"山西太原"));
		map.put("2", new User("2", "QIAOZHI",25,"山西太原"));
		map.put("3", new User("3", "QIAOZHI",25,"山西太原"));
		JSONObject jsonObject=  JSONObject.fromObject(map);
		String json = jsonObject.toString();
		System.out.println(json);
//		{"3":{"address":"山西太原","age":25,"id":"3","name":"QIAOZHI"},"2":{"address":"山西太原","age":25,"id":"2","name":"QIAOZHI"},"1":{"address":"山西太原","age":25,"id":"1","name":"QIAOZHI"}}
	}
	
//	测试list<map>对象转JSON，转集合用JSONArray，会产生[]
	@Test
	public void test4(){
		List<Map<String,User>> list = new ArrayList<>();
		Map<String,User> map1 = new HashMap<String,User>();
		Map<String,User> map2 = new HashMap<String,User>();
		map1.put("map11", new User("1", "QIAOZHI",25,"山西太原"));
		map1.put("map12", new User("2", "QIAOZHI",25,"山西太原"));
		map2.put("21", new User("11", "QIAOZHI",25,"山西太原"));
		map2.put("22", new User("21", "QIAOZHI",25,"山西太原"));
		list.add(map1);
		list.add(map2);
		JSONArray jsonArray =  JSONArray.fromObject(list);
		String json = jsonArray.toString();
		System.out.println(json);
//		[{"map12":{"id":"2","name":"QIAOZHI","age":25,"address":"山西太原"},"map11":{"id":"1","name":"QIAOZHI","age":25,"address":"山西太原"}},{"21":{"id":"11","name":"QIAOZHI","age":25,"address":"山西太原"},"22":{"id":"21","name":"QIAOZHI","age":25,"address":"山西太原"}}]
	}
	
}
