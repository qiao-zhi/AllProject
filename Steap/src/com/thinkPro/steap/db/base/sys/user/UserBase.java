package com.thinkPro.steap.db.base.sys.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.sys.user.TBaseRoleInfo;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.bean.sys.user.UserPrivilege;
import com.thinkPro.steap.db.mapper.sys.user.IUserMapper;

public class UserBase implements IUserMapper{

	private ApplicationContext applicationContext;
	private IUserMapper userMapper;
	
	public UserBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		userMapper = (IUserMapper) applicationContext.getBean("IUserMapper");
	}
	
	/**
	 * 删除用户全部角色
	 * @param userId 用户编号
	 * @return 删除记录数
	 * @throws SQLException
	 */
	public int deleteUserRoleByUserId(String userId) throws SQLException {
		return userMapper.deleteUserRoleByUserId(userId);
	}
	
	/**
	 * 根据用户Id查询用户信息
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public TBaseUserInfo getUserById(String userId)throws SQLException{
		return userMapper.getUserById(userId);
	}
	
	/**
	 * 判断用户是否存在
	 * @param loginInfo 登录信息(userName,password)
	 * @return 如果用户存在，但会用户的Id(userId)
	 * @throws SQLException
	 */
	public String isUser(Map<String,String> loginInfo)throws SQLException{
		return userMapper.isUser(loginInfo);
	}
	
	public String isUser2(Map<String,String> loginInfo)throws SQLException{
		return userMapper.isUser2(loginInfo);
	}
	
	public String isSpecialistLib(Map<String,String> loginInfo)throws SQLException{
		return userMapper.isSpecialistLib(loginInfo);
	}
	
	/**
	 * 根据用户(userId)查询用户所拥有的权限(可以进入的页面)
	 * @param userId 用户的Id
	 * @return 模块(菜单)的名称，模块的URL，模块的等级
	 * @throws SQLException
	 */
	public List<UserPrivilege> getPrivilegeByUserId(String userId)throws SQLException{
		return userMapper.getPrivilegeByUserId(userId);
	}
	
	public List<Map<String, Object>> getPrivilegeByUserId2(String userId) throws SQLException{
		return userMapper.getPrivilegeByUserId2(userId);
	}
	/**
	 * 根据部门返回用户信息
	 * @param unitName 部门名称
	 * @return 部门名称(unitName)，用户Id(userId)，用户姓名(name)，职务(duty)(List<Map>)
	 */
	public List<Map<String,Object>> getUsersByUnit(String unitName)throws SQLException{
		return userMapper.getUsersByUnit(unitName);
	}
	
	/******************************* START BY HAOSHASHA *****************************************/
	/**
	 * 根据用户电话查询用户信息
	 * @param telephone电话号码
	 * @return 用户基本信息
	 * @throws SQLException
	 */
	public TBaseUserInfo getUserByTelephone(String telephone) throws SQLException{
		
		return userMapper.getUserByTelephone(telephone);
	}
	public String getNextUserId()throws SQLException{
		return userMapper.getNextUserId();
	}
	/**
	 * 添加用户基本信息
	 * @param user
	 * @throws SQLException
	 */
	public int addUser(TBaseUserInfo user)throws SQLException{
		
		return userMapper.addUser(user);
	}
	
	/**
	 * 根据用户编号删除用户
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public int deleteUserById(String userId)throws SQLException{
		
		return userMapper.deleteUserById(userId);
	}
	
	/**
	 * 修改用户基本信息(不包括密码)
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int updateUserInfo(TBaseUserInfo user)throws SQLException{
		
		return userMapper.updateUserInfo(user);
	}
	
	/**
	 * 修改用户密码
	 * @param userPassword map里面包括(userId,password)
	 * @return
	 * @throws SQLException
	 */
	public int updateUserPassword(Map<String,Object> userPassword)throws SQLException{
		
		return userMapper.updateUserPassword(userPassword);
	}
	
	/**
	 * 根据部门Id查询该部门下的用户
	 * @param unitId 部门编号 pageBegin 其实记录数 pageSize 需要访问的记录数
	 * @return List<TBaseUserInfo> 用户基本信息 
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUsersByUnitId(Map<String,Object> condition)throws SQLException{
		
		return userMapper.getUsersByUnitId(condition);
	}
	
	/**
	 * 给用户分配角色
	 * @param userRole map里面应该包含（用户编号，角色编号）
	 * (userId,roleId)
	 * @return
	 * @throws SQLException
	 */
	public int addRoleToUser(Map<String,Object> userRole)throws SQLException{
		
		return userMapper.addRoleToUser(userRole);
	}
	
	/**
	 * 撤销分配给用户的角色
	 * @param userRole map里面应该包含（用户编号，角色编号）
	 * (userId,roleId)
	 * @return
	 * @throws SQLException
	 */
	public int deleteRoleFromUser(Map<String,Object> userRole)throws SQLException{
		
		return userMapper.deleteRoleFromUser(userRole);
	}
	
	
	/**
	 * 根据用户编号查询该用户所扮演的角色
	 * @param userId 用户编号
	 * @return 角色基本信息
	 * @throws SQLException
	 */
	public List<TBaseRoleInfo> getRoleByUserId(String userId)throws SQLException{
		
		return userMapper.getRoleByUserId(userId);
	}
	
	/**
	 * 根据用户编号查询该用户不扮演的角色
	 * @param userId 用户编号
	 * @return 角色基本信息
	 * @throws SQLException
	 */
	public List<TBaseRoleInfo> getLeftRoleByUserId(String userId)throws SQLException{
		
		return userMapper.getLeftRoleByUserId(userId);
	}
	
	/**
	 * 根据角色编号查询该角色下的所有用户
	 * @param unitId
	 * @return List<TBaseUserInfo> 用户基本信息 
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUserByRoleId(String roleId)throws SQLException{
		
		return userMapper.getUserByRoleId(roleId);
	}
	
	/**
	 * 根据条件查询用户(用户姓名，用户职务，起始记录数，需要得到的记录数)
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUsersByCondition(Map<String,Object> condition)throws SQLException{
		
		return userMapper.getUsersByCondition(condition);
	}
	
	/**
	 * 根据条件查询用户的总记录数(用户姓名，用户职务， 部门编号)
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public int getUserCountByCondition(Map<String,Object> condition)throws SQLException{

		return userMapper.getUserCountByCondition(condition);
	}
	/******************************* END BY HAOSHASHA *******************************************/
	
	/**
	 * 根据用户名称获取用户Id
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public String getUserIdByName(String name) throws SQLException {
		return userMapper.getUserIdByName(name);
	}
	
	/**
	 * 根据用户Id查询用户的登录密码
	 * @param userId 用户Id
	 * @return 系统登录密码
	 * @throws SQLException
	 */
	public String getPasswordByUserId(String userId) throws SQLException {
		return userMapper.getPasswordByUserId(userId);
	}
}
