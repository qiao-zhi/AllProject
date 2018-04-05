package com.thinkPro.steap.action.unit;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.db.service.sys.unit.UnitService;


@SuppressWarnings("serial")
@Component
public class UpdateUnitAction extends ActionSupport  implements ModelDriven<TBaseUnitInfo>{
	
	private TBaseUnitInfo baseUnitInfo = new TBaseUnitInfo();
	private TBaseUnitInfo result;
	private boolean updateResult;
   
	@Resource
	private UnitService unitService;
	
	public boolean isUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(boolean updateResult) {
		this.updateResult = updateResult;
	}

	public TBaseUnitInfo getBaseUnitInfo() {
		return baseUnitInfo;
	}

	public void setBaseUnitInfo(TBaseUnitInfo baseUnitInfo) {
		this.baseUnitInfo = baseUnitInfo;
	}

	public TBaseUnitInfo getResult() {
		return result;
	}

	public void setResult(TBaseUnitInfo result) {
		this.result = result;
	}


	public String updateUnit(){
		try {
			updateResult = unitService.updateUnit(baseUnitInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(updateResult){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	public String getUpdateUnit(){
		try {
			this.result = unitService.getUnitByUnitId(baseUnitInfo.getUnitId());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public TBaseUnitInfo getModel() {
		return baseUnitInfo;
	}
}