package com.thinkPro.steap.action.sys.dictionary;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.common.PageConstants;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

/**
 * 查询字典相关信息
 * @author Hao Shasha
 *
 */
@Component
public class SearchDictionaryAction extends ActionSupport {

	private static final long serialVersionUID = -2718753766487238403L;
	
	private SystemDictionary systemDictionary;
	
	private String upDictionaryOptionId; //上级字典编号  方法一和方法二公用
	
	private String result;               //返回的结果
	
	private String nextId;               //下级中下一个字典的编号 
	
	private String dictionaryOptionId;   //字典的编号  查询条件
	
	private String dictionaryOptionName; //字典的名字 查询条件
	
	private String currentPage; 	     //当前页码
	
	private int totalPage;               //总页数
	
	@Resource
	private DictionaryService dictionaryService;
	
	/**
	 * 按照上级字典编号查询字典信息
	 * @return  
	 */
	public String searchDictionaryByUpId(){
		
		List<SystemDictionary> systemDictionary;
		
		try {
			
			Object pageSize = new PageConstants().getPageSize();
			
			Object pageBegin = new PageConstants().getRecordNums(Integer.parseInt(currentPage));
			
			Map<String,Object> dicCondition = new HashMap<String,Object>();
			
			dicCondition.put("upDictionaryOptionId",upDictionaryOptionId);
			
			dicCondition.put("pageBegin", pageBegin);
			
			dicCondition.put("pageSize", pageSize);
			//返回自己的子节点
			systemDictionary = dictionaryService.getDictionaryByConditon(dicCondition);
			
//			//字典的根节点不能修改和删除
//			if(!"1".equals(upDictionaryOptionId)){
//				
//				//返回自己本身
//				SystemDictionary dictionary=ditionaryService.getDictionaryById(upDictionaryOptionId);
//				
//				systemDictionary.add(dictionary);
//			}
			
			//将java对象转化为json对象
			JSONArray jsonArray = JSONArray.fromObject(systemDictionary);
			
			//返回给Ajax
			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 按条件查询字典信息
	 * @return
	 */
	public String searchDictionaryByCondition(){
		
		List<SystemDictionary> systemDictionary;
		
		try {
			
			Object pageSize = new PageConstants().getPageSize();
			
			Object pageBegin = new PageConstants().getRecordNums(Integer.parseInt(currentPage));
			
			Map<String,Object> condition = new HashMap<String,Object>();
			
			if(dictionaryOptionId!=null && ("").equals(dictionaryOptionId)){
				
				dictionaryOptionId = null;
			}
			if(dictionaryOptionName!=null && ("").equals(dictionaryOptionName)){
				
				dictionaryOptionName = null;
			}
			if(upDictionaryOptionId!=null && ("").equals(upDictionaryOptionId)){
				
				upDictionaryOptionId = null;
			}
			condition.put("dictionaryOptionId", dictionaryOptionId);     //字典编号
			
			condition.put("dictionaryOptionName", dictionaryOptionName); //字典名称
			
			condition.put("pageBegin", pageBegin);
			
			condition.put("pageSize", pageSize);
			
			condition.put("upDictionaryOptionId", upDictionaryOptionId);
			
			systemDictionary = dictionaryService.getDictionaryByConditon(condition);
			
			//将java对象转化为json对象
			JSONArray jsonArray = JSONArray.fromObject(systemDictionary);
			
			//返回给Ajax
			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String searchDicCountByCondition(){
		
		try {
			
			Map<String,Object> condition = new HashMap<String,Object>();
			
			
			if(dictionaryOptionId!=null && ("").equals(dictionaryOptionId)){
				
				dictionaryOptionId = null;
			}
			if(dictionaryOptionName!=null && ("").equals(dictionaryOptionName)){
				
				dictionaryOptionName = null;
			}
			if(upDictionaryOptionId!=null && ("").equals(upDictionaryOptionId)){
				
				upDictionaryOptionId = null;
			}
			
			condition.put("dictionaryOptionId", dictionaryOptionId);     //字典编号
			
			condition.put("dictionaryOptionName", dictionaryOptionName); //字典名称
			
			condition.put("upDictionaryOptionId", upDictionaryOptionId); //上级字典编号
			
			int totalCount = dictionaryService.getDicCountByConditon(condition);
			
			this.totalPage = new PageConstants().getPages(totalCount);
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 查询即将新增的字典的编号
	 * @return  
	 */
	public String searchNextId(){
		
		try {
			
			this.nextId = (dictionaryService.getNextDictionaryId(upDictionaryOptionId));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String getDictionaryOptionId() {
		return dictionaryOptionId;
	}

	public void setDictionaryOptionId(String dictionaryOptionId) {
		this.dictionaryOptionId = dictionaryOptionId;
	}

	public String getDictionaryOptionName() {
		return dictionaryOptionName;
	}

	public void setDictionaryOptionName(String dictionaryOptionName) {
		this.dictionaryOptionName = dictionaryOptionName;
	}

	public SystemDictionary getSystemDictionary() {
		return systemDictionary;
	}

	public void setSystemDictionary(SystemDictionary systemDictionary) {
		this.systemDictionary = systemDictionary;
	}

	public String getUpDictionaryOptionId() {
		return upDictionaryOptionId;
	}

	public void setUpDictionaryOptionId(String upDictionaryOptionId) {
		this.upDictionaryOptionId = upDictionaryOptionId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
