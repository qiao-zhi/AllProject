package com.thinkPro.steap.action.evaluation.current;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.EvaluationService;

/**
 * 获取当前专家的待评审项目数
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class FindEvaluatedCountAction extends ActionSupport {
	Logger log = Logger.getLogger(FindEvaluatedCountAction.class);
			
	private String specialistId;
	private int count;
	
	@Resource
	private EvaluationService evaluationService;

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String execute() throws Exception {
		try {
			System.out.println("specialistId: " + specialistId);
			if(ValidateCheck.isNotNull(specialistId)) {
				Map<String, Object> meeting_specialist = new HashMap<String, Object>();
				meeting_specialist.put("specialistId", specialistId);
				meeting_specialist.put("meetingStatus", "召开中");
				
				int evaluatedProjectCount = evaluationService.getEvaluatedProjectCount(meeting_specialist);
				
				meeting_specialist.put("remark", "1");
				int evaluatingProjectCount = evaluationService.getEvaluatingProjectCount(meeting_specialist);
				
				count = evaluatedProjectCount - evaluatingProjectCount;
				
				log.info("============================================================");
				log.info("count: " + count);
			}
		} catch(SQLException ex) {
			count = 0;
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
}
