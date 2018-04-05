package Action.Excel2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.bcel.internal.generic.Type;

import bean.Question;

public class JSON2BeanList {
	
	
	
//	测试JSON转list
	/**
	 * 将字符串转为list集合对象
	 *@param json json数组字符串
	 *@return list集合
	 */
	@SuppressWarnings("unchecked")
	public static  List<Question> json2list(String json){
		List<Question> list = new ArrayList<Question>();
		Gson gson = new Gson();
		list = (List<Question>) gson.fromJson(json, new TypeToken<List<Question>>(){}.getType());
		return list;
	}
	
}
