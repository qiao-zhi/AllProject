package com.thinkPro.steap.action.unit;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.db.service.sys.unit.UnitService;


@SuppressWarnings("serial")
@Component
public class SearchUnitAction extends ActionSupport {

	private TBaseUnitInfo baseUnitInfo;
	private String upUnitId;//上级部门编号 
	private String result;//返回的结果
	private String nextId;//下级中下一个部门的编号 
	private String unitId; //部门的编号--查询条件
	private String unitName;//部门的名称 --查询条件
	
	@Resource
	private UnitService unitService;
	
	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}

	public TBaseUnitInfo getBaseUnitInfo() {
		return baseUnitInfo;
	}

	public void setBaseUnitInfo(TBaseUnitInfo baseUnitInfo) {
		this.baseUnitInfo = baseUnitInfo;
	}

	public String getUpUnitId() {
		return upUnitId;
	}

	public void setUpUnitId(String upUnitId) {
		this.upUnitId = upUnitId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}


	public String searchUnitByUpId(){
		List<TBaseUnitInfo> baseUnitInfo;
		try {
			//返回自己的子节点
			baseUnitInfo = unitService.getUnitByUpUnitId(upUnitId);
			TBaseUnitInfo unit=unitService.getUnitByUnitId(upUnitId);
			//返回自己本身
			baseUnitInfo.add(unit);
			//将java对象转化为json对象
			JSONArray jsonArray = JSONArray.fromObject(baseUnitInfo);
			//返回给Ajax
			this.result = jsonArray.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String searchUnitByCondition(){
		List<TBaseUnitInfo> baseUnitInfo;
		try {
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("unitId", unitId);
			condition.put("unitName", unitName);
			System.out.println("map"+condition);
			baseUnitInfo = unitService.getUnitByConditon(condition);
			//将java对象转化为json对象
			JSONArray jsonArray = JSONArray.fromObject(baseUnitInfo);
			//返回给Ajax
			this.result = jsonArray.toString();
		} catch (SQLException e) {
		}
		return SUCCESS;
	}
	

	public String searchNextUnitId(){
		try {
			nextId =unitService.getNextUnitId(upUnitId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}