package com.thinkPro.steap.action.evaluation.specialist;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

/**
 * 修改专家信息
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class UpdateSpecialistInfoAction extends ActionSupport {
	Logger log = Logger.getLogger(UpdateSpecialistInfoAction.class);
	
	private Specialist specialist;
	
	@Resource
	private SpecialistService specialistService;
	
	public Specialist getSpecialist() {
		return specialist;
	}

	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		try {
			log.info("specialist: " + specialist);
			System.out.println("specialist: " + specialist);
			if (specialist != null) {
				specialistService.updateLibrarySpecialist(specialist);
				String oldResultTip = (String) session.get("oldResultTip");
				session.put("oldResultTip", oldResultTip);
				session.put("newResultTip", "信息修改成功!&" + System.currentTimeMillis());
			}
		} catch (SQLException ex) {
			session.put("newResultTip", "信息修改失败!&" +  + System.currentTimeMillis());
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
