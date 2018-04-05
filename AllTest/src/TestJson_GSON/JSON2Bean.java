package TestJson_GSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSON2Bean {
//	测试json转单个对象
	@Test
	public void test1(){
		String json = "{'id':'1','name':'QIAOZHI','age':25,'address':'山西太原'}";
		Gson gson = new Gson();
		User user = gson.fromJson(json, User.class);
		System.out.println(user);  
//		User [id=1, name=QIAOZHI, age=25, address=山西太原]
	}
	
	
	
//	测试JSON转list
	@SuppressWarnings("unchecked")
	@Test
	public void test2(){
		String json = "[{'id':'1','name':'QIAOZHI','age':25,'address':'山西太原'},{'id':'2','name':'QIAOZHI','age':25,'address':'山西太原'},{'id':'3','name':'QIAOZHI','age':25,'address':'山西太原'}]";
		List<User> list = new ArrayList<User>();
		Gson gson = new Gson();
		list = (List<User>) gson.fromJson(json, new TypeToken<List<User>>(){}.getType());
		System.out.println(list);
		for(User user:list){
			System.out.println(user);
		}
//		[{id=1, name=QIAOZHI, age=25.0, address=山西太原}, {id=2, name=QIAOZHI, age=25.0, address=山西太原}, {id=3, name=QIAOZHI, age=25.0, address=山西太原}]
		System.out.println(list.get(1));
//		{id=2, name=QIAOZHI, age=25.0, address=山西太原}
	}
	
	
//	测试JSON转Map
	@Test
	public void test3(){
		String json = "{'3':{'id':'3','name':'QIAOZHI','age':25,'address':'山西太原'},'2':{'id':'2','name':'QIAOZHI','age':25,'address':'山西太原'},'1':{'id':'1','name':'QIAOZHI','age':25,'address':'山西太原'}}";
		Map<String,User> map = new HashMap<String,User>();
		Gson gson = new Gson();
		map = (Map<String,User>) gson.fromJson(json, new TypeToken<Map<String,User>>(){}.getType());
		System.out.println(map);
//		{3={id=3, name=QIAOZHI, age=25.0, address=山西太原}, 2={id=2, name=QIAOZHI, age=25.0, address=山西太原}, 1={id=1, name=QIAOZHI, age=25.0, address=山西太原}}
		User user = map.get("1");
		System.out.println(user);
//		{id=1, name=QIAOZHI, age=25.0, address=山西太原}
	}
	
	
//	测试JSON转list<map>对象
	@SuppressWarnings("unchecked")
	@Test
	public void test4(){
		String json = "[{'map12':{'id':'2','name':'QIAOZHI','age':25,'address':'山西太原'},'map11':{'id':'1','name':'QIAOZHI','age':25,'address':'山西太原'}},{'21':{'id':'11','name':'QIAOZHI','age':25,'address':'山西太原'},'22':{'id':'21','name':'QIAOZHI','age':25,'address':'山西太原'}}]";
		List<Map<String,User>> list = new ArrayList<>();
		Gson gson = new Gson();
		list = gson.fromJson(json, new TypeToken<List<Map<String,User>>>(){}.getType());
		System.out.println(list);
//		[{map12={id=2, name=QIAOZHI, age=25.0, address=山西太原}, map11={id=1, name=QIAOZHI, age=25.0, address=山西太原}}, {21={id=11, name=QIAOZHI, age=25.0, address=山西太原}, 22={id=21, name=QIAOZHI, age=25.0, address=山西太原}}]
		System.out.println(list.get(1));
//		{21={id=11, name=QIAOZHI, age=25.0, address=山西太原}, 22={id=21, name=QIAOZHI, age=25.0, address=山西太原}}
	}
}
