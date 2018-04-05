package TestJson_JSONlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSON2Bean {
//	测试json转单个对象
	@Test
	public void test1(){
		String json = "{\"id\":\"1\",\"name\":\"QIAOZHI\",\"age\":25,\"address\":\"山西太原\"}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		System.out.println(jsonObject);  //产生一个json格式的json对象
//		{"id":"1","name":"QIAOZHI","age":25,"address":"山西太原"}
		User user = (User) JSONObject.toBean(jsonObject, User.class);
		System.out.println(user);  
//		User [id=1, name=QIAOZHI, age=null, address=山西太原]
	}
	
	
	
//	测试JSON转list(太反复杂了)
	@SuppressWarnings("unchecked")
	@Test
	public void test2(){
		String json = "[{'id':'1','name':'QIAOZHI','age':25,'address':'山西太原'},{'id':'2','name':'QIAOZHI','age':25,'address':'山西太原'},{'id':'3','name':'QIAOZHI','age':25,'address':'山西太原'}]";
		List<User> list = new ArrayList<User>();
		JSONArray jsonArray = JSONArray.fromObject(json);
		System.out.println(jsonArray);   //产生一个JSON格式的数组
//		[{"id":"1","name":"QIAOZHI","age":25,"address":"山西太原"},{"id":"2","name":"QIAOZHI","age":25,"address":"山西太原"},{"id":"3","name":"QIAOZHI","age":25,"address":"山西太原"}]
		list = (List<User>) JSONArray.toList(jsonArray,User.class);
		System.out.println(list);
//		[User [id=1, name=QIAOZHI, age=null, address=山西太原], User [id=2, name=QIAOZHI, age=null, address=山西太原], User [id=3, name=QIAOZHI, age=null, address=山西太原]]
		System.out.println(list.get(1));
//		User [id=2, name=QIAOZHI, age=null, address=山西太原]
	}
	
	
/*//	测试JSON转Map
	@Test
	public void test3(){
		String json = "{'3':{'id':'3','name':'QIAOZHI','age':25,'address':'山西太原'},'2':{'id':'2','name':'QIAOZHI','age':25,'address':'山西太原'},'1':{'id':'1','name':'QIAOZHI','age':25,'address':'山西太原'}}";
		Map<String,User> map = new HashMap<String,User>();
		JSONObject jsonObject = JSONObject.fromObject(json);
		map = (Map<String,User>) JSONObject.toBean(jsonObject, User.class, map);
		System.out.println(map);
//		{3={id=3, name=QIAOZHI, age=25.0, address=山西太原}, 2={id=2, name=QIAOZHI, age=25.0, address=山西太原}, 1={id=1, name=QIAOZHI, age=25.0, address=山西太原}}
		System.out.println(map.get("1"));
//		{id=1, name=QIAOZHI, age=25.0, address=山西太原}
	}
	
	
//	测试JSON转list<map>对象
	@SuppressWarnings("unchecked")
	@Test
	public void test4(){
		String json = "[{'map12':{'id':'2','name':'QIAOZHI','age':25,'address':'山西太原'},'map11':{'id':'1','name':'QIAOZHI','age':25,'address':'山西太原'}},{'21':{'id':'11','name':'QIAOZHI','age':25,'address':'山西太原'},'22':{'id':'21','name':'QIAOZHI','age':25,'address':'山西太原'}}]";
		List<Map<String,User>> list = new ArrayList<>();
		Gson gson = new Gson();
		list = gson.fromJson(json, List.class);
		System.out.println(list);
//		[{map12={id=2, name=QIAOZHI, age=25.0, address=山西太原}, map11={id=1, name=QIAOZHI, age=25.0, address=山西太原}}, {21={id=11, name=QIAOZHI, age=25.0, address=山西太原}, 22={id=21, name=QIAOZHI, age=25.0, address=山西太原}}]
		System.out.println(list.get(1));
//		{21={id=11, name=QIAOZHI, age=25.0, address=山西太原}, 22={id=21, name=QIAOZHI, age=25.0, address=山西太原}}
	}*/
}
