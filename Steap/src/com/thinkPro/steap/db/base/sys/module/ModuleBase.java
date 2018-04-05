package com.thinkPro.steap.db.base.sys.module;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.sys.module.Module;
import com.thinkPro.steap.db.mapper.sys.module.IModuleMapper;

public class ModuleBase implements IModuleMapper {
	
	private ApplicationContext applicationContext;
	private IModuleMapper moduleMapper;
	
	public ModuleBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		moduleMapper = (IModuleMapper) applicationContext.getBean("IModuleMapper");
	}

	/**
	 * 查询模块树信息
	 * @return
	 */
	public List<Map<String, Object>> getModuleTree2() {
		return moduleMapper.getModuleTree2();
	}
	
	/**
	 * 添加模块 
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public int addModule(Module module) throws SQLException {
		return moduleMapper.addModule(module);
	}

	/**
	 *  根据模块id删除模块
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteModule(String moduleId) throws SQLException {
		return moduleMapper.deleteModule(moduleId);
	}

	/**
	 * 修改模块信息
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public int updateModule(Module module) throws SQLException {
		return moduleMapper.updateModule(module);
	}

	/**
	 * 查询模块信息列表
	 * @return
	 * @throws SQLException
	 */
	/*public List<Module> getAllModule() throws SQLException {
		return moduleMapper.getAllModule();
	}*/

	/**
	 * 按条件查询模块 moduleId, moduleName
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<Module> getModuleByCondition(Map<String, Object> condition)
			throws SQLException {
		return moduleMapper.getModuleByCondition(condition);
	}

	/**
	 * 根据moduleId查询模块信息
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public Module getModuleByModuleId(String moduleId) throws SQLException {
		return moduleMapper.getModuleByModuleId(moduleId);
	}

	/**
	 * 根据模块id查询下一级所有模块信息
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public List<Module> getNextModuleByModuleId(String moduleId)
			throws SQLException {
		return moduleMapper.getNextModuleByModuleId(moduleId);
	}

	/**
	 * 根据模块id查询下一个要插入的模块id（二级）
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public String getNextId(String moduleId) throws SQLException {
		return moduleMapper.getNextId(moduleId);
	}

	/**
	 * 根据模块id查询下一个要插入的模块id（一级）
	 * @return
	 * @throws SQLException
	 */
	public String getOneNextId() throws SQLException {
		return moduleMapper.getOneNextId();
	}
}