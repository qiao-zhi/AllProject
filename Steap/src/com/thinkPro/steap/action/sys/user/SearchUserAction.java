package com.thinkPro.steap.action.sys.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.user.TBaseUserInfo;
import com.thinkPro.steap.common.PageConstants;
import com.thinkPro.steap.db.service.sys.user.UserService;

/**
 * 查询用户信息
 * @author Hao Shasha
 *
 */
@Component
public class SearchUserAction extends ActionSupport {

	private static final long serialVersionUID = -2718753766487238403L;
	
	private TBaseUserInfo user;
	
	private String unitId;    //部门编号
	
	private String telephone; //用户联系方式
	
	private String userId;    //用户编号
	
	private String result;    //返回的结果
	
	private String name;      //用户姓名
	
	private String duty;      //用户职务
	
	private String currentPage; 	     //当前页码
	
	private int totalPage;               //总页数
	
	@Resource
	private UserService userService;
	
	/**
	 * 根据用户编号查询用户信息
	 * @return
	 */
	public String searchUserByUserId(){
		
		TBaseUserInfo user = new TBaseUserInfo();
		
		try {
			
			user =userService.getUserById(userId);
			
			JSONArray jsonArray = JSONArray.fromObject(user);

			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 根据用户联系方式查询用户信息
	 * @return
	 */
	public String searchUserByTelephone(){
		
		TBaseUserInfo user = new TBaseUserInfo();
		
		try {
			
			System.out.println(telephone);
			
			user =userService.getUserByTelephone(telephone);
			
			JSONArray jsonArray = JSONArray.fromObject(user);

			this.result = jsonArray.toString();
			
			System.out.println(result);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(this.result!=null){
			
			return SUCCESS;
		
		}else{
			
			return ERROR;
		}
		
	}
	
	/**
	 * 根据部门编号查询用户
	 * @return
	 */
	public String searchUserByUnitId(){
		
		List<TBaseUserInfo> users = new ArrayList<TBaseUserInfo>();
		
		Map<String,Object> condition = new HashMap<String,Object>();
		
		Object pageSize = new PageConstants().getPageSize();
		
		Object pageBegin = new PageConstants().getRecordNums(Integer.parseInt(currentPage));
		
		condition.put("unitId",unitId);
		
		condition.put("pageBegin", pageBegin);
		
		condition.put("pageSize", pageSize);
		
		System.out.println(condition);
		
		try {
			
			users =userService.getUsersByUnitId(condition);
			
			JSONArray jsonArray = JSONArray.fromObject(users);

			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 根据查询条件查询用户（姓名，职务）
	 * @return
	 */
	public String searchUserByCondition(){
		
		List<TBaseUserInfo> users = new ArrayList<TBaseUserInfo>();
		
		Map<String,Object> condition = new HashMap<String,Object>();
		
		Object pageSize = new PageConstants().getPageSize();
		
		Object pageBegin = new PageConstants().getRecordNums(Integer.parseInt(currentPage));
		
		if(name!=null && ("").equals(name)){
			
			name = null;
		}
		if(duty!=null && ("").equals(duty)){
			
			duty = null;
		}
		condition.put("name", name);     
		
		condition.put("duty", duty);  
		
		condition.put("pageBegin", pageBegin);
		
		condition.put("pageSize", pageSize);
		
		System.out.println(condition);
		
		try {
			
			users=userService.getUsersByCondition(condition);
			
			JSONArray jsonArray = JSONArray.fromObject(users);

			this.result = jsonArray.toString();
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	/**
	 * 根据查询条件查询用户（姓名，职务）
	 * @return
	 */
	public String getUserCountByCondition(){
		
		Map<String,Object> condition = new HashMap<String,Object>();
		
		if(name!=null && ("").equals(name)){
			
			name = null;
		}
		if(duty!=null && ("").equals(duty)){
			
			duty = null;
		}
		
		if(unitId!=null && ("").equals(unitId)){
			
			unitId  = null;
		}
		condition.put("name", name);     
		
		condition.put("duty", duty);  
		
		condition.put("unitId", unitId);
		System.out.println("==============================================");
		System.out.println(condition);
		
		try {
			
			int totalCount = userService.getUserCountByCondition(condition);
			
			this.totalPage = new PageConstants().getPages(totalCount);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public TBaseUserInfo getUser() {
		return user;
	}

	public void setUser(TBaseUserInfo user) {
		this.user = user;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
