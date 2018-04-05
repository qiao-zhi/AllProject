package StrutsJSON;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import freemarker.template.utility.NormalizeNewlines;


public class JSONtest {
	
	private Map<String,Object> map;
	private String name;
	private String password;
	List<User> list ;
	
	
	

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String execute(){
		System.out.println(11);
		System.out.println(name+"  "+password);
		map = new LinkedHashMap<String,Object>();
//		测试布尔类型
		map.put("boob", 222);
//		测试集合类型
		list = new ArrayList<>();
		list.add(new User("qlq", "123456"));
		list.add(new User("qz", "78910"));
		map.put("list", list);
//		测试字符串类型
		map.put("str", "20");
		this.setMap(map);
//		测试对象
		map.put("obj", new User("wlw", "22222"));
		return Action.SUCCESS;
	}
}
