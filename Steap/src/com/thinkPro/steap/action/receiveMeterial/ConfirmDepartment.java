package com.thinkPro.steap.action.receiveMeterial;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.project.ProjectCharge;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.sys.unit.UnitService;
import com.thinkPro.steap.db.service.sys.user.UserService;

@SuppressWarnings("serial")
@Component
public class ConfirmDepartment extends ActionSupport{
	
	@Resource
	private ProjectService projectService;
	@Resource
	private UnitService unitService;
	@Resource
	private UserService userService;
	
	private ProjectCharge projectCharge;
	private ProjectCharge result;
	private List<Map<String,Object>> unitInfos;
	private String unitName;
	private List<Map<String,Object>> userList;
	private String a;
	private boolean save;
	
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public List<Map<String, Object>> getUserList() {
		return userList;
	}
	public void setUserList(List<Map<String, Object>> userList) {
		this.userList = userList;
	}
	public ProjectCharge getResult() {
		return result;
	}
	public void setResult(ProjectCharge result) {
		this.result = result;
	}
	public ProjectCharge getProjectCharge() {
		return projectCharge;
	}
	public void setProjectCharge(ProjectCharge projectCharge) {
		this.projectCharge = projectCharge;
	}
	public List<Map<String, Object>> getUnitInfos() {
		return unitInfos;
	}
	public void setUnitInfos(List<Map<String, Object>> unitInfos) {
		this.unitInfos = unitInfos;
	}
	
	/* 保存确定负责部门的信息 */
	@Override
	public String execute() throws Exception {
//		projectService = new ProjectService();
		Map<String,String> projectStatus;
		projectStatus = new HashMap<String, String>();
		projectStatus.put("projectId",projectCharge.getProjectId());
		projectStatus.put("status", "100002");
		
		/* 添加时间 */
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		projectCharge.setDestributionDate(df.format(date));
		
		save = projectService.addProjectCharge(projectCharge);
		if (save) {
			projectService.updateProjectStatus(projectStatus);
			return SUCCESS;
		}
		return ERROR;
	}
	
	/* 根据项目信息得到负责部门的信息 */
	public String getCharge(){
//		projectService = new ProjectService();
		result = new ProjectCharge();
		try {
			this.result = projectService.getChargeByProjectId(projectCharge.getProjectId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/* 得到部门的list 做成ztree */
	public String searchTree(){
//		UnitService unitService = new UnitService();
		unitInfos = new ArrayList<>();
		try {
			unitInfos = unitService.getUnitTree2();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/* 通过部门查询员工 */
	public String searchUsers(){
//		UserService userService = new UserService();
		userList = new ArrayList<Map<String,Object>>();
		try {
			this.userList = userService.getUsersByUnit(unitName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
