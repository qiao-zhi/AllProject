package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.RoleModule;
import com.thinkPro.steap.bean.sys.user.TBaseRoleInfo;
import com.thinkPro.steap.db.service.sys.user.RoleService;

@SuppressWarnings("serial")
@Component
public class RoleAction extends ActionSupport {

	private List<TBaseRoleInfo> roleInfos; // 角色信息列表，显示到界面
	private List<Map<String, String>> moduleTree; // 构建菜单树所需的信息(菜单Id，菜单名称，菜单等级)，转换以后显示到界面
	private TBaseRoleInfo role; // 角色信息，添加角色时从界面传回
	private List<String> moduleIds; // 角色所拥有的权限对应的菜单Id，显示到界面
	private List<RoleModule> nodes; // 修改角色权限时，从界面传回的角色Id，勾选的菜单Id数组
	private String roleId; // 删除角色时，从界面传回
	List<String> checkModuIds;
	List<String> commonModuleIds;
	List<String> tempModuleIds;
	
	@Resource
	private RoleService roleService;
	
	public List<RoleModule> getNodes() {
		return nodes;
	}

	public void setNodes(List<RoleModule> nodes) {
		this.nodes = nodes;
	}

	public List<TBaseRoleInfo> getRoleInfos() {
		return roleInfos;
	}

	public void setRoleInfos(List<TBaseRoleInfo> roleInfos) {
		this.roleInfos = roleInfos;
	}

	public List<Map<String, String>> getModuleTree() {
		return moduleTree;
	}

	public void setModuleTree(List<Map<String, String>> moduleTree) {
		this.moduleTree = moduleTree;
	}

	public TBaseRoleInfo getRole() {
		return role;
	}

	public void setRole(TBaseRoleInfo role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<String> getModuleIds() {
		return moduleIds;
	}

	public void setModuleIds(List<String> moduleIds) {
		this.moduleIds = moduleIds;
	}

	/**
	 * 查询数据库中的角色信息
	 * 
	 * @return
	 */
	public String showRole() {
		try {
			String roleName = roleId;
			if (roleName.equals("")) {
				roleName = null;
			}
			roleInfos = roleService.getRoleInfos(roleName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(RoleAction.class);
			logger.info(logger);
		}
		return SUCCESS;
	}

	/**
	 * 添加角色信息
	 * 
	 * @return 添加成功，返回SUCCESS；添加失败，返回ERROR
	 */
	public String addRole() {
		try {
			if (roleService.addRoleInfo(role) > 0) {
				roleId = role.getRoleId();
				return SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(RoleAction.class);
			logger.info(logger);
		}
		return ERROR;
	}

	/**
	 * 修改角色信息
	 * 
	 * @return 修改成功，SUCCESS；修改失败，ERROR
	 */
	public String updateRole() {
		try {
			if (roleService.updateRoleInfo(role) > 0) {
				return SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(RoleAction.class);
			logger.info(logger);
		}
		return ERROR;
	}

	/**
	 * 删除专家信息
	 * 
	 * @return 删除成功，SUCCESS；删除失败，ERROR
	 */
	public String deleteInfo() {
		try {
			if (roleService.deleteRoleInfo(roleId) > 0) {
				return SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(RoleAction.class);
			logger.info(logger);
		}
		return ERROR;
	}

	/**
	 * 得到菜单树 将数据库返回的菜单I的，菜单名称，菜单等级根据菜单等级转换为上级菜单Id，菜单Id，菜单名称
	 * 
	 * @return
	 */
	public String getTree() {
		try {
			String isUse = "1";
			Map<String, String> tree = null;
			List<Map<String, String>> moduleTemp = new ArrayList<Map<String, String>>();
			List<Map<String, Object>> moduleClass = roleService.getModuleTree(isUse);
			for (Map<String, Object> module : moduleClass) {
				tree = new HashMap<String, String>();
				if (module.get("menuClass").equals(1)) {
					tree.put("upModuleId", "0");
					tree.put("moduleId", (String) module.get("moduleId"));
					tree.put("moduleName", (String) module.get("moduleName"));
				} else {
					tree.put("moduleId", (String) module.get("moduleId"));
					tree.put("upModuleId",((String) module.get("moduleId")).substring(0, 2));
					tree.put("moduleName", (String) module.get("moduleName"));
				}
				moduleTemp.add(tree);
			}
			moduleTree = moduleTemp;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(RoleAction.class);
			logger.info(logger);
		}
		return SUCCESS;
	}

	/**
	 * 根据角色Id查询它所拥有的权限
	 * 
	 * @return
	 */
	public String getRoleModule() {
		try {
			moduleIds = roleService.getRoleModule(roleId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(RoleAction.class);
			logger.info(logger);
		}
		return SUCCESS;
	}

	/**
	 * 保存修改以后的角色权限信息 将界面传回的角色权限信息和数据库中的进行对比 界面传回的角色权限信息中有的而数据库没有的，是新增的权限
	 * 数据库中有而界面传回的角色权限信息中没有的，是删除的权限
	 * 
	 * @return
	 */
	public String saveRoleModule() {
		try {
			if(nodes != null){
				checkModuIds = new ArrayList<String>();
				commonModuleIds = new ArrayList<String>();
				String tempRoleId = nodes.get(0).getRoleId();
				tempModuleIds = roleService.getRoleModule(tempRoleId);
				for (int i = 0; i < nodes.size(); i++) {
					checkModuIds.add(nodes.get(i).getModuleId());
				}
				if(tempModuleIds.size()>0){
					for (String cId : checkModuIds) {
						for (String id : tempModuleIds) {
							if (cId.equals(id)) {
								commonModuleIds.add(id);
							}
						}
					}
				}
				if (commonModuleIds.size() > 0) {
					checkModuIds.removeAll(commonModuleIds);
					tempModuleIds.removeAll(commonModuleIds);
				}
				Iterator<String> checkIterator = checkModuIds.iterator();
				Map<String, String> temp1 = new HashMap<String, String>();
				temp1.put("roleId", nodes.get(0).getRoleId());
				while (checkIterator.hasNext()) {
					temp1.put("moduleId", checkIterator.next());
					roleService.addRoleModule(temp1);
				}
				Iterator<String> iterator = tempModuleIds.iterator();
				Map<String, String> temp2 = new HashMap<String, String>();
				temp2.put("roleId", nodes.get(0).getRoleId());
				while (iterator.hasNext()) {
					temp2.put("moduleId", iterator.next());
					roleService.deleteRoleModule(temp2);
				}
			}else{
				roleService.deleteModuleById(roleId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
