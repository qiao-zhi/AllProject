package com.thinkPro.steap.action.unit;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thinkPro.steap.bean.sys.unit.TBaseUnitInfo;
import com.thinkPro.steap.db.service.sys.unit.UnitService;

@SuppressWarnings("serial")
@Component
public class AddUnitAction extends ActionSupport implements ModelDriven<TBaseUnitInfo>{
	
	private TBaseUnitInfo baseUnitInfo = new TBaseUnitInfo();
	private boolean addResult;

	@Resource
	private UnitService unitService;

	public boolean isAddResult() {
		return addResult;
	}

	public void setAddResult(boolean addResult) {
		this.addResult = addResult;
	}

	public TBaseUnitInfo getBaseUnitInfo() {
		return baseUnitInfo;
	}

	public void setBaseUnitInfo(TBaseUnitInfo baseUnitInfo) {
		this.baseUnitInfo = baseUnitInfo;
	}

	
	public String addUnit(){
		boolean addResult = false;
		
		try {
			String currentUnitId = unitService.getNextUnitId(baseUnitInfo.getUpUnitId());
			baseUnitInfo.setUnitId(currentUnitId);
			addResult = unitService.addUnit(baseUnitInfo);
			this.addResult = addResult;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Logger logger = Logger.getLogger(AddUnitAction.class);
			logger.info(logger);
		}
		if (addResult) {
			return SUCCESS;
		} 
		return ERROR;
	}

	public TBaseUnitInfo getModel() {
		return baseUnitInfo;
	}
}