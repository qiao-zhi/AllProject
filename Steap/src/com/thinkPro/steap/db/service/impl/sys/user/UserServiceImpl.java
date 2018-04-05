package com.thinkPro.steap.db.service.impl.sys.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.sys.user.TBaseRoleInfo;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.bean.sys.user.UserPrivilege;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.sys.user.IUserMapper;
import com.thinkPro.steap.db.service.sys.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private IUserMapper userMapper;
	
	/**
	 * 删除用户全部角色
	 * @param userId 用户编号
	 * @return 删除记录数
	 * @throws SQLException
	 */
	public int deleteUserRoleByUserId(String userId) throws SQLException {
		if(ValidateCheck.isNotNull(userId)) {
			return userMapper.deleteUserRoleByUserId(userId);
		}
		return 0;
	}
	
	/**
	 * 根据用户Id查询用户信息
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public TBaseUserInfo getUserById(String userId)throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(userId);

		if(result){

			return userMapper.getUserById(userId);
		}else{
			
			return null;
		}
	}
	
	/**
	 * 判断用户是否存在
	 * @param loginInfo 登录信息(userName,password)
	 * @return 如果用户存在，但会用户的Id(userId)
	 * @throws SQLException
	 */
	public String isUser(Map<String, String> loginInfo) throws SQLException {
		if(loginInfo != null && loginInfo.size()>0){
			return userMapper.isUser(loginInfo);
		}
		return null;
	}
	
	public String isUser2(Map<String, String> loginInfo) throws SQLException {
		if(loginInfo != null && loginInfo.size()>0){
			return userMapper.isUser2(loginInfo);
		}
		return null;
	}

	/*判断专家库专家是否存在*/
	public String isSpecialistLib(Map<String, String> loginInfo) throws SQLException {
		if(loginInfo != null && loginInfo.size()>0){
			return userMapper.isSpecialistLib(loginInfo);
		}
		return null;
	}
	
	/**
	 * 根据用户(userId)查询用户所拥有的权限(可以进入的页面)
	 * @param userId 用户的Id
	 * @return 模块(菜单)的名称，模块的URL，模块的等级
	 * @throws SQLException
	 */
	public List<UserPrivilege> getPrivilegeByUserId(String userId) throws SQLException {
		if(userId != null && !"".equals(userId)) {
			return userMapper.getPrivilegeByUserId(userId);
		}
		return null;
	}
	
	public List<Map<String, Object>> getPrivilegeByUserId2(String userId) throws SQLException{
		if(userId != null && !"".equals(userId)) {
			return userMapper.getPrivilegeByUserId2(userId);
		}
		return null;
	}
	
	/**
	 * 根据部门返回用户信息
	 * @param unitName 部门名称
	 * @return 部门名称(unitName)，用户Id(userId)，用户姓名(name)，职务(duty)(List<Map>)
	 */
	public List<Map<String,Object>> getUsersByUnit(String unitName)throws SQLException{
		if(ValidateCheck.isNotNull(unitName)) {
			return userMapper.getUsersByUnit(unitName);
		}
		return null;
	}
	
	
	
	/******************************* START BY HAOSHASHA *****************************************/
	
	/**
	 * 根据用户电话查询用户信息
	 * @param telephone电话号码
	 * @return 用户基本信息
	 * @throws SQLException
	 */
	public TBaseUserInfo getUserByTelephone(String telephone) throws SQLException{
		
	boolean result = ValidateCheck.isNotNull(telephone);
		
		if(result){
			
			return userMapper.getUserByTelephone(telephone);
		}
		
		return null;
	}
	
	public boolean isExistsUserByTelephone(String telephone) throws SQLException {
		boolean result = false;
		if(ValidateCheck.isNotNull(telephone)) {
			TBaseUserInfo user = userMapper.getUserByTelephone(telephone);
			result = user != null ? true : false;
		}
		return result;
	}
	
	/**
	 * 添加用户基本信息
	 * @param user
	 * @throws SQLException
	 */
	public boolean addUser(TBaseUserInfo user)throws SQLException{
		
		if(user!=null){
			String userId = userMapper.getNextUserId();
			if(userId == null || userId.equals("")){
				userId ="U100001";
			}
			user.setUserId(userId);
			return userMapper.addUser(user)>0 ?true:false;
		
		}else{
			
			return false;
		}
		
	}
	
	/**
	 * 根据用户编号删除用户
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteUserById(String userId)throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(userId);
		
		if(result){
			
			result = userMapper.deleteUserById(userId)>0?true:false;
		}
		
		return result;
	}
	
	/**
	 * 修改用户基本信息(不包括密码)
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public boolean updateUserInfo(TBaseUserInfo user)throws SQLException{
		
		if(user!=null){

			return userMapper.updateUserInfo(user)>0 ?true:false;

		}else{

			return false;
		}
		
	}
	
	/**
	 * 修改用户密码
	 * @param userPassword map里面包括(userId,password)
	 * @return
	 * @throws SQLException
	 */
	public boolean updateUserPassword(Map<String,Object> userPassword)throws SQLException{
		
		boolean result = false;
		
		if(userPassword!=null && userPassword.size()==2){ //此处两个字段必须都存在才能进行更新操作??待完善
			
			result = userMapper.updateUserPassword(userPassword)>0? true:false;
		}
		return result;
	}
	
	/**
	 * 根据部门Id查询该部门下的用户
	 * @param unitId 部门编号 pageBegin 其实记录数 pageSize 需要访问的记录数
	 * @return List<TBaseUserInfo> 用户基本信息 
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUsersByUnitId(Map<String,Object> condition)throws SQLException{
		
		if(condition!=null && condition.size() > 0){

			return userMapper.getUsersByUnitId(condition);
		}else{
			
			return null;
		}

		
	}
	
	/**
	 * 给用户分配角色
	 * @param userRole map里面应该包含（用户编号，角色编号）
	 * (userId,roleId)
	 * @return
	 * @throws SQLException
	 */
	public boolean addRoleToUser(Map<String,Object> userRole)throws SQLException{
		boolean result = false;
		if(userRole != null && userRole.size() != 0 && userRole.size() == 2) {
			result = userMapper.addRoleToUser(userRole)>0? true:false;
		}
		return result;
	}
	
	/**
	 * 撤销分配给用户的角色
	 * @param userRole map里面应该包含（用户编号，角色编号）
	 * (userId,roleId)
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteRoleFromUser(Map<String,Object> userRole)throws SQLException{
		
		if(userRole==null){
			return true;
		}
		return	userMapper.deleteRoleFromUser(userRole)>=0? true:false;
		
	}
	
	
	/**
	 * 根据用户编号查询该用户所扮演的角色
	 * @param userId 用户编号
	 * @return 角色基本信息
	 * @throws SQLException
	 */
	public List<TBaseRoleInfo> getRoleByUserId(String userId)throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(userId);

		if(result){

			return userMapper.getRoleByUserId(userId);
		}else{
			
			return null;
		}
		
	}
	
	/**
	 * 根据用户编号查询该用户不扮演的角色
	 * @param userId 用户编号
	 * @return 角色基本信息
	 * @throws SQLException
	 */
	public List<TBaseRoleInfo> getLeftRoleByUserId(String userId)throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(userId);

		if(result){

			return userMapper.getLeftRoleByUserId(userId);
		}else{
			
			return null;
		}
		
	}
	
	/**
	 * 根据角色编号查询该角色下的所有用户
	 * @param unitId
	 * @return List<TBaseUserInfo> 用户基本信息 
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUserByRoleId(String roleId)throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(roleId);

		if(result){

			return userMapper.getUserByRoleId(roleId);
		}else{
			
			return null;
		}
	}
	
	/**
	 * 根据条件查询用户(用户姓名，用户职务，起始记录数，需要得到的记录数)
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<TBaseUserInfo> getUsersByCondition(Map<String,Object> condition)throws SQLException{

		if(condition != null && condition.size() > 0) {
			return userMapper.getUsersByCondition(condition);
		}
		return null;
	}
	
	/**
	 * 根据条件查询用户的总记录数(用户姓名，用户职务， 部门编号)
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public int getUserCountByCondition(Map<String,Object> condition)throws SQLException{
		if(condition != null && condition.size() > 0) {
			return userMapper.getUserCountByCondition(condition);
		}
		return 0;
	}
	
	/******************************* END BY HAOSHASHA *******************************************/
	
	/**
	 * 根据用户名称获取用户Id
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public String getUserIdByName(String name) throws SQLException {
		if(ValidateCheck.isNotNull(name)) {
			return userMapper.getUserIdByName(name);
		}
		return null;
	}
	
	/**
	 * 根据用户Id查询用户的登录密码
	 * @param userId 用户Id
	 * @return 系统登录密码
	 * @throws SQLException
	 */
	public String getPasswordByUserId(String userId) throws SQLException {
		if(ValidateCheck.isNotNull(userId)) {
			return userMapper.getPasswordByUserId(userId);
		}
		return null;
	}
}
