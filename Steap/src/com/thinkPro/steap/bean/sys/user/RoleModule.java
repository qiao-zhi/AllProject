package com.thinkPro.steap.bean.sys.user;


public class RoleModule {

	private String roleId;
	private String moduleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleId() {
		return moduleId;
	}

	@Override
	public String toString() {
		return "RoleModule [roleId=" + roleId + ", moduleId=" + moduleId + "]";
	}
	

}
