package com.thinkPro.steap.action.unit;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.unit.UnitService;

@SuppressWarnings("serial")
@Component
public class DeleteUnitAction extends ActionSupport {

	private String unitId;//Ajax传过来的值（部门编号）
	private String deleteResult;
	
	@Resource
	private UnitService unitService;
	
	public String getDeleteResult() {
		return deleteResult;
	}
	
	public void setDeleteResult(String deleteResult) {
		this.deleteResult = deleteResult;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	
	public String deleteUnit() {
		boolean deleteResult = false;
		try {
			deleteResult = unitService.deleteUnit(unitId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(deleteResult){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}