package com.thinkPro.steap.action.receiveMeterial;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.unit.UnitService;

@SuppressWarnings("serial")
@Component
public class ChooseUser extends ActionSupport{

//	private List<Map<String, List<Map<String, Object>>>> users;
	private Map<String,List<Map<String, Object>>> userMapper = new HashMap<String, List<Map<String,Object>>>();
	private String result;
	@Resource
	private UnitService unitService;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Map<String, List<Map<String, Object>>> getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(Map<String, List<Map<String, Object>>> userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public String execute(){
//		UnitService unitService = new UnitService();
		
		/*存放从数据库查出的数据*/
		List<Map<String,Object>> unitList = new ArrayList<>();
		List<Map<String, Object>> userList = new ArrayList<>();
		
		
		try {
			unitList = unitService.getUnitTree2();
			userList = unitService.getAllUsers();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < unitList.size(); i++) {
			List<Map<String, Object>> users = new ArrayList<>();
			if (unitList.get(i).get("upUnitId") == null || unitList.get(i).get("upUnitId").equals("")) {
				continue;
			}
			for (int j = 0; j < userList.size(); j++) {
				if (unitList.get(i).get("unitName").equals(userList.get(j).get("unitName"))) {
					users.add(userList.get(j));
				}
			}
			userMapper.put((String) unitList.get(i).get("unitName"), users);
		}
		
		
		JSONArray array = JSONArray.fromObject(userMapper);
		result = array.toString();
		return SUCCESS;
}
}
