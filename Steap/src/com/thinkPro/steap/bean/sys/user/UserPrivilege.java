package com.thinkPro.steap.bean.sys.user;

public class UserPrivilege {

	private String moduleId;  //模块Id
	private String moduleName; //模块名字
	private String moduleURL;
	private String menuClass;
	
	public String getMenuClass() {
		return menuClass;
	}
	public void setMenuClass(String menuClass) {
		this.menuClass = menuClass;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleURL() {
		return moduleURL;
	}
	public void setModuleURL(String moduleURL) {
		this.moduleURL = moduleURL;
	}
	@Override
	public String toString() {
		return "UserPrivilege [moduleId=" + moduleId + ", moduleName="
				+ moduleName + ", moduleURL=" + moduleURL + ", menuClass="
				+ menuClass + "]";
	}
	
}