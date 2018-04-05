package com.thinkPro.steap.db.service.impl.sys.module;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.sys.module.Module;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.sys.module.IModuleMapper;
import com.thinkPro.steap.db.service.sys.module.ModuleService;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{

	@Resource
	private IModuleMapper moduleMapper;
	
	/**
	 * 查询模块树信息
	 * @return
	 */
	public List<Map<String,Object>> getModuleTree2() throws SQLException{
		
		return moduleMapper.getModuleTree2();
	}
	
	/**
	 * 添加模块 
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public boolean addModule(Module module) throws SQLException {
		if(module!=null){
			int addUnitResult = moduleMapper.addModule(module);
			boolean result = addUnitResult>-1?true:false;
			return result;
		}
			return false;
	}
		
	/**
	 *  根据模块id删除模块
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteModule(String moduleId) throws SQLException {
		if(moduleId!=null&&!"".equals(moduleId)) {
			return moduleMapper.deleteModule(moduleId)>0 ? true:false;
		}else{
			return false;
		}
	}
	

	/**
	 * 修改模块信息
	 * @param module
	 * @return
	 * @throws SQLException
	 */
	public boolean updateModule(Module module) throws SQLException {
		if(module!= null) {
			boolean updateResult = false;
			updateResult = moduleMapper.updateModule(module)>0?true:false;
			return updateResult;
		}else{
			return false;
		}
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
		if(condition!=null && condition.size()>0){
			return moduleMapper.getModuleByCondition(condition);
		}else{
			return null;
		}
	}
	
	/**
	 * 根据moduleId查询模块信息
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public Module getModuleByModuleId(String moduleId) throws SQLException {
		if(moduleId != null && !"".equals(moduleId)) {
			return moduleMapper.getModuleByModuleId(moduleId);
		}
		return null;
	}
	
	/**
	 * 根据模块id查询下一级所有模块信息
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public List<Module> getNextModuleByModuleId(String moduleId)
			throws SQLException {
		if(moduleId != null && !"".equals(moduleId)){
			return moduleMapper.getNextModuleByModuleId(moduleId);
		}
		return null;
	}

	/**
	 * 根据模块id查询下一个要插入的模块id（二级）
	 * @param moduleId
	 * @return
	 * @throws SQLException
	 */
	public String getNextId(String moduleId) throws SQLException {
		boolean result = ValidateCheck.isNotNull(moduleId);
		if(result){
			String nextId = moduleMapper.getNextId(moduleId);
			if(nextId==null){
				nextId = moduleId + "001";
			}
//			else{
//				nextId = Integer.toString(Integer.parseInt(nextId)+1);
//			}
			return nextId;
		}else{
			return null;
		}
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
