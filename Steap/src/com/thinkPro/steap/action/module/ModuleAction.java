package com.thinkPro.steap.action.module;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.module.Module;
import com.thinkPro.steap.db.service.sys.module.ModuleService;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
@Component
public class ModuleAction extends ActionSupport{
	private String moduleId; //模块编号  查询条件
	private String moduleName;//模块名称 查询条件
	private String searchResult;//返回的结果
	private String nextId;
	private List<Map<String, Object>> moduleTree;
	private String id;//Ajax传过来的值（部门编号）
	private String deleteResult;
	private Module module = new Module();
	private String addResult;
	private Module result;
	private Boolean updateResult;
	private String str;
	private String upModuleId;//上级模块Id
	private boolean deleteSingleResult;
	
	@Resource
	private ModuleService moduleService;
	
	public boolean isDeleteSingleResult() {
		return deleteSingleResult;
	}
	public void setDeleteSingleResult(boolean deleteSingleResult) {
		this.deleteSingleResult = deleteSingleResult;
	}
	public String getUpModuleId() {
		return upModuleId;
	}
	public void setUpModuleId(String upModuleId) {
		this.upModuleId = upModuleId;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Module getResult() {
		return result;
	}
	public void setResult(Module result) {
		this.result = result;
	}
	public Boolean getUpdateResult() {
		return updateResult;
	}
	public void setUpdateResult(Boolean updateResult) {
		this.updateResult = updateResult;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}

	public String getAddResult() {
		return addResult;
	}
	public void setAddResult(String addResult) {
		this.addResult = addResult;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeleteResult() {
		return deleteResult;
	}
	public void setDeleteResult(String deleteResult) {
		this.deleteResult = deleteResult;
	}
	public List<Map<String, Object>> getModuleTree() {
		return moduleTree;
	}
	public void setModuleTree(List<Map<String, Object>> moduleTree) {
		this.moduleTree = moduleTree;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(String searchResult) {
		this.searchResult = searchResult;
	}
	public String getNextId() {
		return nextId;
	}
	public void setNextId(String nextId) {
		this.nextId = nextId;
	}
	
	public String searchModuleByCondition(){
		List<Module> module;
		try {
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("moduleId", moduleId);
			condition.put("moduleName", moduleName);
			module = moduleService.getModuleByCondition(condition);
			//将java对象转化为json对象
			JSONArray jsonArray = JSONArray.fromObject(module);
			//返回给Ajax
			searchResult = jsonArray.toString();
		} catch (SQLException e) {
		}
		return SUCCESS;
	}
	
	public String  searchTree(){
		Map<String,Object> mapTree;
		List<Map<String, Object>> treeList = new ArrayList<>();
		try {
			List<Map<String,Object>> moduleClass = moduleService.getModuleTree2();
			for(Map<String,Object> module:moduleClass){
				mapTree = new HashMap<String, Object>();
				if(module.get("menuClass").equals(1)){
					mapTree.put("upModuleId","0");
					mapTree.put("moduleId", (String)module.get("moduleId"));
					mapTree.put("moduleName", (String)module.get("moduleName"));
				}else{
					mapTree.put("moduleId", (String)module.get("moduleId"));
					mapTree.put("upModuleId",((String) module.get("moduleId")).substring(0,2));
					mapTree.put("moduleName", (String)module.get("moduleName"));
				}
				treeList.add(mapTree);
			}
			mapTree = new HashMap<String, Object>();
			mapTree.put("moduleId","0");
			mapTree.put("moduleName","菜单列表");
			treeList.add(mapTree);
			moduleTree =treeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	 }
	
	public String searchModuleByModuleId(){
		List<Module> module;
			try {
				//返回自己的子节点
				module = moduleService.getNextModuleByModuleId(moduleId);
//				Module m=moduleService.getModuleByModuleId(moduleId);
				//返回自己本身
//				module.add(m);
				//将java对象转化为json对象
				JSONArray jsonArray = JSONArray.fromObject(module);
				//返回给Ajax
				searchResult = jsonArray.toString();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return SUCCESS;
	}
	
	public String searchNextId(){
		try {
			nextId =moduleService.getNextId(moduleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String searchOneNextId(){
		try {
			nextId =moduleService.getOneNextId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String deleteModule() {
		boolean deleteResult = false;
		List<String> moduleIdList = java.util.Arrays.asList(moduleId.split(","));
		//通过迭代达到批量删除用户的目的
		for(String moduleId:moduleIdList){
			try {
				deleteResult = moduleService.deleteModule(moduleId);
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(deleteResult){
			return SUCCESS;
		}
			return ERROR;
	}
	
	public String deleteSingleModule(){
		boolean deleteResult = false;
		try {
			deleteResult = moduleService.deleteModule(moduleId);
			deleteSingleResult = deleteResult;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (deleteResult) {
			return SUCCESS;
		}
			return ERROR;
	}
	
	
	public String addModule(){
		boolean addResult2 = false;
		try {
			String currentModuleId = moduleService.getNextId(upModuleId);
			module.setModuleId(currentModuleId);
			addResult2 = moduleService.addModule(module);
			addResult = module.getModuleId();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Logger logger = Logger.getLogger(ModuleAction.class);
			logger.info(logger);
		}
		if (addResult2) {
			return SUCCESS;
		} 
		return ERROR;
	}
	
	public String updateModule(){
		List<Module> modules = new ArrayList<>();
		boolean upResult = false;
		try {
			upResult = moduleService.updateModule(module);
			this.updateResult = module.getInUse();
			if (!module.getInUse()) {
				modules = moduleService.getNextModuleByModuleId(module.getModuleId());
				
				if (modules != null) {
					for (int i = 0; i < modules.size(); i++) {
						modules.get(i).setInUse(false);
						upResult = moduleService.updateModule(modules.get(i));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(upResult){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String getUpdateModule(){
		try {
			this.result = moduleService.getModuleByModuleId(moduleId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}