package com.thinkPro.steap.action.sys.dictionary;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

/**
 * 查询字典树
 * @author Hao Shasha
 *
 */
@Component("SearchTreeAction2")
public class SearchTreeAction extends ActionSupport {
	
	private static final long serialVersionUID = -1404070192571387531L;

	private String treeList2;           //返回的json对象
	
	List<Map<String, Object>> treeList; //得到java对象

	@Resource
	private DictionaryService dictionaryService;
	
	/**
	 * 查询字典树
	 * @return
	 */
	public String  searchTree(){
		
	     try {
	    	 
			this.treeList = dictionaryService.getDictionaryTree();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		JSONArray jsonArray = JSONArray.fromObject(treeList);
		
		this.treeList2 = jsonArray.toString();

		return SUCCESS;
	 }
	public String getTreeList2() {
		
		return treeList2;
	}

	public void setTreeList2(String treeList2) {
		
		this.treeList2 = treeList2;
	}

	public List<Map<String, Object>> getTreeList() {
		
		return treeList;
	}

	public void setTreeList(List<Map<String, Object>> treeList) {
		
		this.treeList = treeList;
	}
	
}
