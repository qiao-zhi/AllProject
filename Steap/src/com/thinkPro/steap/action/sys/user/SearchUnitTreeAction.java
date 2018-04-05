package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.unit.UnitService;

/**
 * 查询部门树
 * @author Hao Shasha
 *
 */
@Component
public class SearchUnitTreeAction extends ActionSupport {
	
	private static final long serialVersionUID = -8512406781138952393L;

	private String treeList2;           //返回的json对象
	
	List<Map<String, Object>> treeList; //得到java对象
	
	@Resource
	private UnitService unitService;
	
	/**
	 * 查询部门树
	 * @return
	 */
	public String  searchTree(){
		 
	     try {
	    	 
			this.treeList = unitService.getUnitTree2();
			
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
