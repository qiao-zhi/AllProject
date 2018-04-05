package TestJson_JSONlib;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 手动创建JSONObject与JSONArray
* @author: qlq
* @date :  2017年8月1日下午11:27:58
 */
public class CreateJSONObject {

	@Test
	public void test1(){
//		手动创建一个JSONObject
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "11");
		jsonObject.put("name", "qiaozhi");
		jsonObject.put("age", 30);
		jsonObject.put("address", "山西太原");
		System.out.println(jsonObject);
//		{"id":"11","name":"qiaozhi","age":30,"address":"山西太原"}
		
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("id", "12");
		jsonObject1.put("name", "qiaozhi");
		jsonObject1.put("age", 30);
		jsonObject1.put("address", "山西太原");
		System.out.println(jsonObject1);
//		{"id":"12","name":"qiaozhi","age":30,"address":"山西太原"}
		
		
//		产生一个JSONArray
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject1);
		System.out.println(jsonArray);
//		[{"id":"11","name":"qiaozhi","age":30,"address":"山西太原"},{"id":"12","name":"qiaozhi","age":30,"address":"山西太原"}]
		
		
//		用上述方法转成Java对象与List集合，用于处理数据
	}
}
