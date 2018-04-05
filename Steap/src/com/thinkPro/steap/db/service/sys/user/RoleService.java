package com.thinkPro.steap.db.service.sys.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.sys.user.TBaseRoleInfo;

public interface RoleService {
	/**
	 * 查询角色信息
	 * @return 角色信息(List<TBaseRoleInfo>)
	 * @throws SQLException
	 */
	public List<TBaseRoleInfo> getRoleInfos(String roleName) throws SQLException;
	
	/**
	 * 获取全部角色部分信息
	 * @return 角色信息集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllRolePartInfoByUserId(String userId) throws SQLException;
	
	/**
	 * 根据用户编号获取该用户角色信息
	 * @param userId 用户编号
	 * @return 当前用户的角色信息
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getRolesByUserId(String userId) throws SQLException;
	
	/**
	 * 修改角色信息
	 * @param roleInfo 角色信息(TBaseRoleInfo)
	 * @return 修改的记录数 (int)
	 * @throws SQLException
	 */
	public int updateRoleInfo(TBaseRoleInfo roleInfo) throws SQLException;
	/**
	 * 删除角色信息
	 * @param roleId 角色Id(String)
	 * @return 删除的记录数(int)
	 * @throws SQLException
	 */
	public int deleteRoleInfo(String roleId) throws SQLException;
	/**
	 * 添加角色信息
	 * @param roleInfo 角色信息(TBaseRoleInfo)
	 * @return 插入的记录数(int)
	 * @throws SQLException
	 */
	public int addRoleInfo(TBaseRoleInfo roleInfo) throws SQLException;
	
	/**
	 * 添加角色的权限(给角色分配的权限)
	 * @param roleModul 角色Id，权限Id (Map<String,String>)
	 * @return 
	 * @throws SQLException
	 */
	public int addRoleModule(Map<String, String> roleModul) throws SQLException;

	/**
	 * 根据角色Id查看拥有的权限Id
	 * @param roleId 角色Id(String)
	 * @return  权限Id (List<String>)
	 * @throws SQLException
	 */
	public List<String>  getRoleModule(String roleId) throws SQLException;

	/**
	 * 获得构建菜单树的信息
	 * @param inUse String 菜单是否启用
	 * @return 菜单Id，菜单名称，菜单等级 (List<Map<String,Object>>)
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getModuleTree(String inUse) throws SQLException;
	
	/**
	 * 删除角色的权限(收回分配给角色的权限)
	 * @param roleModul (Map<String,String>)
	 * @return
	 * @throws SQLException
	 */
	public int deleteRoleModule(Map<String, String> roleModul)throws SQLException;
	
	/**
	 * 根据角色Id删除拥有的所有权限
	 * @param roleId 角色Id
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteModuleById(String roleId)throws SQLException;
}
