package com.thinkPro.steap.action.sys.dictionary;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

/**
 * 更新字典信息
 * @author Hao Shasha
 *
 */
@Component
public class UpdateDictionaryAction extends ActionSupport {
	
	private static final long serialVersionUID = 519320461749415711L;
	
	private SystemDictionary systemDictionary = new SystemDictionary();
	
	private SystemDictionary result;
	
	private boolean updateResult;
   
	@Resource
	private DictionaryService dictionaryService;
	
	/**
	 * 更新字典信息
	 * @return
	 */
	public String updateDictionary(){
		
		//System.out.println(systemDictionary);
		
		boolean updateResult = false;
		
		try {
			
			updateResult = dictionaryService.updateDictionary(systemDictionary);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(updateResult){
			
			return SUCCESS;
		}else{
			
			return ERROR;
		}
		
	}
	
	/**
	 * 查找要更新的字典信息
	 * @return
	 */
	public String getUpdateDictionary(){
		
		try {
			
			this.result = dictionaryService.getDictionaryById(systemDictionary.getDictionaryOptionId());
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public boolean isUpdateResult() {
		
		return updateResult;
	}

	public SystemDictionary getSystemDictionary() {
		return systemDictionary;
	}

	public void setSystemDictionary(SystemDictionary systemDictionary) {
		this.systemDictionary = systemDictionary;
	}

	public SystemDictionary getResult() {
		return result;
	}

	public void setResult(SystemDictionary result) {
		this.result = result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUpdateResult(boolean updateResult) {
		this.updateResult = updateResult;
	}
	
}
