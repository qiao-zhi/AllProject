package com.thinkPro.steap.db.service.sys.module;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.sys.module.Module;


public interface ModuleService {
	
	/**
	 * 查询模块树信息
	 * @return
	 */
	public List<Map<String,Object>> getModuleTree2() throws SQLException;
	
	/**
	 * 添加模块 
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public boolean addModule(Module module) throws SQLException ;
		
	/**
	 *  根据模块id删除模块
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteModule(String moduleId) throws SQLException;
	

	/**
	 * 修改模块信息
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public boolean updateModule(Module module) throws SQLException ;

	/**
	 * 查询模块信息列表
	 * @return
	 * @throws SQLException
	 */
	/*public List<Module> getAllModule() throws SQLException ;*/
	
	/**
	 * 按条件查询模块 moduleId, moduleName
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<Module> getModuleByCondition(Map<String, Object> condition) throws SQLException ;
	
	/**
	 * 根据moduleId查询模块信息
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public Module getModuleByModuleId(String moduleId) throws SQLException ;
	
	/**
	 * 根据模块id查询下一级所有模块信息
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public List<Module> getNextModuleByModuleId(String moduleId) throws SQLException ;

	/**
	 * 根据模块id查询下一个要插入的模块id（二级）
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public String getNextId(String moduleId) throws SQLException ;
	
	/**
	 * 根据模块id查询下一个要插入的模块id（一级）
	 * @return
	 * @throws SQLException
	 */
	public String getOneNextId() throws SQLException ;
}