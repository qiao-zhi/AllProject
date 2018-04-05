package com.thinkPro.steap.action.host.current;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

/**
 * 为非来自专家库的专家提供生成登录密码的功能
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class GeneratePassAction extends ActionSupport {
	Logger log = Logger.getLogger(GeneratePassAction.class);

	private String specialistIds;
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;

	public String getSpecialistIds() {
		return specialistIds;
	}

	public void setSpecialistIds(String specialistIds) {
		this.specialistIds = specialistIds;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if(ValidateCheck.isNotNull(specialistIds)) {
				String[] ids = specialistIds.split(",");
				
				List<Map<String, Object>> specialists = new ArrayList<Map<String, Object>>();
				Map<String, Object> specialist_password = new HashMap<String, Object>();
				
				for (String specialistId : ids) {
					specialist_password.put("specialistId", specialistId);
					String password = genRandomNum(10);
					specialist_password.put("password", password);
					
					log.info("======specialistId: " + specialistId + " , password: " + password + "======");
					
					specialistService.updateRecommendSpecialistPassword(specialist_password);
					Map<String, Object> specialist = specialistService.getRSPartInfoById(specialistId);
					specialists.add(specialist);
				}
				result.put("specialists", specialists);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}
	
	private String genRandomNum(int pwd_len) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
		'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
		'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，
	
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
	
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}
}
