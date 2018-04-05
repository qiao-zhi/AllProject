package Dao;

import java.util.List;

import Bean.Role;
import Bean.RoleMenu;
import Bean.UserRole;

public interface RoleDao {
	/**
	 * 根据用户角色集合中用户角色的用户id查询角色
	 *@param list  用户角色集合对象
	 *@return  用户所具有的角色
	 *@throws
	 */
	public List<Role> findRoleByUserRole(List<UserRole> list) throws Exception;
	/**
	 * 根据角色查询角色功能
	 *@param list 用户角色
	 *@return 角色功能
	 *@throws Exception 
	 *@throws
	 */
	public List<RoleMenu> findRoleMenuByRole(List<Role> list) throws Exception;

}
