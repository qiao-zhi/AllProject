package com.thinkPro.steap.action.sys.opinion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.specialist.EvaluationService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
@Component
public class OpinionAction extends ActionSupport {
	private String projectId;
	private String specialistId;
	private JSONArray result;
	private Map<String, Object> resp;

	@Resource
	private MeetingService meetingService;
	@Resource
	private SpecialistService specialistService;
	@Resource
	private EvaluationService evaluationService;

	@Override
	public String execute() throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("meetingStatus", "召开中");

		List<Map<String, Object>> projectList = meetingService.getProjectListByMStatus(condition);
		result = JSONArray.fromObject(projectList);

		return SUCCESS;
	}

	public String getSpecialistOpinionListByPId() throws Exception {
		List<Map<String, Object>> specialistList = specialistService.getSpecialistOpinionListByPId(projectId);

		for (Map<String, Object> specialist : specialistList) {
			String str = (String) specialist.get("remark");
			if (str != null) {
				if (str.equals("1")) {
					specialist.put("remark", "已提交");
				} else if (str.equals("0")) {
					specialist.put("remark", "已保存");
				}
			} else {
				specialist.put("remark", "未保存");
			}
		}

		System.out.println("specialistList: " + specialistList);
		result = JSONArray.fromObject(specialistList);

		return SUCCESS;
	}

	public String updateOpinionStatus() throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("projectId", projectId);
		condition.put("specialistId", specialistId);
		/**
		 * @modifier yachao
		 * @time 2017/02/08
		 * @description 去除专家评审意见中的个人签名
		 * 
		 */
		String reviewSuggestion = evaluationService.getSpecialistEvaluation(condition);
		int index = reviewSuggestion.lastIndexOf("<img");
		StringBuffer opinion = new StringBuffer("");
		
		String main_content = reviewSuggestion.substring(0, index);
		opinion.append(main_content);
		
		String sub_content = reviewSuggestion.substring(reviewSuggestion.length() - 6);
		opinion.append(sub_content);
		
		condition.put("reviewSuggestion", opinion.toString());
		/**
		 * OK
		 */
		
		condition.put("remark", "0");

		int updateRows = evaluationService.updateOpinionStatus(condition);

		boolean stateNo = updateRows > 0 ? true : false;
		resp = new HashMap<String, Object>();
		resp.put("stateNo", stateNo);
		return SUCCESS;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	public Map<String, Object> getResp() {
		return resp;
	}

	public void setResp(Map<String, Object> resp) {
		this.resp = resp;
	}

}
