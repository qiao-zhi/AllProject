package com.thinkPro.steap.action.issue.detail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.verify.VerifyService;
/**
 * 查询当前项目全部的审核信息+审核资料
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class FindBICompleteVerifyAction extends ActionSupport {
	Logger log = Logger.getLogger(FindBICompleteVerifyAction.class);

	private String projectId;
	private Map<String, Object> result;
	
	@Resource
	private VerifyService verifyService;

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(projectId)) {
				// 根据项目编号获取全部的审核信息
				List<Map<String, Object>> verifyInfos = verifyService.getAllVerifyInfoByProjectId(projectId);
				// 根据项目编号获取全部的审核资料
				List<Map<String, Object>> materials = verifyService.getAllVMByProjectId(projectId);
				// 用于存放构建的项目审核信息和审核资料
				Map<Map<String, Object>, List<Map<String, Object>>> complete_verify = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
				
				// 遍历全部的项目审核信息
				int sizeOfVerifyInfos = verifyInfos.size();
				for(int i = 0; i < sizeOfVerifyInfos; i++) {
					Map<String, Object> verifyInfo = verifyInfos.get(i);
					// 用于保存和审核信息相对应的审核资料集合
					List<Map<String, Object>> verifyMaterials = new ArrayList<Map<String, Object>>();
					
					// 遍历项目审核资料
					int sizeOfMaterials = materials.size(); // 项目审核资料集合的大小，是动态变化的
					for(int j = 0; j < sizeOfMaterials; j++) {
						Map<String, Object> material = materials.get(j);
						
						if(material.get("verifyId").equals(verifyInfo.get("verifyId"))) {
							verifyMaterials.add(material); // 将项目审核信息相对应的审核资料进行整合，统一管理
							materials.remove(material); // 将已经整合管理的材料从材料集合中移除
						}
					}
					// 构造项目审核信息和审核资料的关联
					complete_verify.put(verifyInfo, verifyMaterials);
				}
				result.put("complete_verify", complete_verify);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

}
