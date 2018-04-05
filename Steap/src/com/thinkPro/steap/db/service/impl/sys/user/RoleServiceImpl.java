package com.thinkPro.steap.db.service.impl.sys.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.sys.user.TBaseRoleInfo;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.sys.user.IRoleMapper;
import com.thinkPro.steap.db.service.sys.user.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private IRoleMapper roleMapper;
	
	/**
	 * 查询角色信息
	 * @return 角色信息(List<TBaseRoleInfo>)
	 * @throws SQLException
	 */
	public List<TBaseRoleInfo> getRoleInfos(String roleName) throws SQLException {
			return roleMapper.getRoleInfos(roleName);
	}
	
	/**
	 * 获取全部角色部分信息
	 * @return 角色信息集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllRolePartInfoByUserId(String userId) throws SQLException {
		if(ValidateCheck.isNotNull(userId)) {
			return roleMapper.getAllRolePartInfoByUserId(userId);
		}
		return null;
	}
	
	/**
	 * 根据用户编号获取该用户角色信息
	 * @param userId 用户编号
	 * @return 当前用户的角色信息
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getRolesByUserId(String userId) throws SQLException {
		if(ValidateCheck.isNotNull(userId)) {
			return roleMapper.getRolesByUserId(userId);
		}
		return null;
	}
	
	/**
	 * 修改角色信息
	 * @param roleInfo 角色信息(TBaseRoleInfo)
	 * @return 修改的记录数 (int)
	 * @throws SQLException
	 */
	public int updateRoleInfo(TBaseRoleInfo roleInfo) throws SQLException {
		if(roleInfo != null){
			return roleMapper.updateRoleInfo(roleInfo);
		}
		return -1;
		
	}
	/**
	 * 删除角色信息
	 * @param roleId 角色Id(String)
	 * @return 删除的记录数(int)
	 * @throws SQLException
	 */
	public int deleteRoleInfo(String roleId) throws SQLException {
		if(ValidateCheck.isNotNull(roleId)){
			return roleMapper.deleteRoleInfo(roleId);			
		}
		return -1;
	}
	/**
	 * 添加角色信息
	 * @param roleInfo 角色信息(TBaseRoleInfo)
	 * @return 插入的记录数(int)
	 * @throws SQLException
	 */
	public int addRoleInfo(TBaseRoleInfo roleInfo) throws SQLException {
		if(roleInfo != null){
			return roleMapper.addRoleInfo(roleInfo);			
		}
		return -1;
	}
	/**
	 * 添加角色的权限(给角色分配的权限)
	 * @param roleModul 角色Id，权限Id (Map<String,String>)
	 * @return 
	 * @throws SQLException
	 */
	public int addRoleModule(Map<String, String> roleModul) throws SQLException {
		if(roleModul.size()>0){
			return roleMapper.addRoleModule(roleModul);
		}
		return -1;
	}
	/**
	 * 根据角色Id查看拥有的权限Id
	 * @param roleId 角色Id(String)
	 * @return  权限Id (List<String>)
	 * @throws SQLException
	 */
	public List<String>  getRoleModule(String roleId) throws SQLException {
		if(ValidateCheck.isNotNull(roleId)){
			return roleMapper.getRoleModule(roleId);			
		}
		return null;
	}

	/**
	 * 获得构建菜单树的信息
	 * @param inUse String 菜单是否启用
	 * @return 菜单Id，菜单名称，菜单等级 (List<Map<String,Object>>)
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getModuleTree(String inUse) throws SQLException {
		if(ValidateCheck.isNull(inUse)){
			return roleMapper.getModuleTree(inUse);
		}
		return null;
	}
	/**
	 * 删除角色的权限(收回分配给角色的权限)
	 * @param roleModul (Map<String,String>)
	 * @return
	 * @throws SQLException
	 */
	public int deleteRoleModule(Map<String, String> roleModul)throws SQLException {
		if(roleModul != null && roleModul.size()>0){
			return roleMapper.deleteRoleModule(roleModul);
		}
		return -1;
	}
	/**
	 * 根据角色Id删除拥有的所有权限
	 * @param roleId 角色Id
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteModuleById(String roleId)throws SQLException{
		if(ValidateCheck.isNull(roleId)){
			return -1;
		}
		return roleMapper.deleteModuleById(roleId);			
	}
}
