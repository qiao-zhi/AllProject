package com.thinkPro.steap.action.receiveMeterial;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class AddSpecialistLib extends ActionSupport{
	private Specialist specialist;
	private String result;
	@Resource
	private SpecialistService specialistService;
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Specialist getSpecialist() {
		return specialist;
	}

	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}

	@Override
	public String execute() throws Exception {
		Logger logger = Logger.getLogger(AddSpecialistLib.class);
//		SpecialistService service = new SpecialistService();

			try {
				if (specialistService.isLibrarySpecialist(specialist)) {
					if (specialistService.insertLibrarySpecialist(specialist) > -1) {
						this.result = "保存成功";
						return SUCCESS;
					}
				} else {
					result = "该专家已存在";
					return SUCCESS;
				}
				
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			} 
		return ERROR;
	}
}
