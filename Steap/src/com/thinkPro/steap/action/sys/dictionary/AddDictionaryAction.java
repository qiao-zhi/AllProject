package com.thinkPro.steap.action.sys.dictionary;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.sys.dic.SystemDictionary;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;
/**
 * 添加字典信息
 * @author Hao Shasha
 *
 */
@Component
public class AddDictionaryAction extends ActionSupport {
	
	private static final long serialVersionUID = -606136789052608951L;

	private SystemDictionary systemDictionary = new SystemDictionary();
	
	private boolean addResult;
	
	@Resource
	private DictionaryService dictionaryService;
	
	/**
	 * 增加字典信息
	 * @return
	 */
	public String addDictionary(){

		
		boolean result = false;
		try {
			result = dictionaryService.addDictionary(systemDictionary);
			
			this.addResult = result;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			Logger logger = Logger.getLogger(AddDictionaryAction.class);
			logger.info(logger);
		}
		if (result) {
			
			return SUCCESS;
		} 
		return ERROR;
	}

	public boolean isAddResult() {
		
		return addResult;
	}

	public void setAddResult(boolean addResult) {
		
		this.addResult = addResult;
	}

	
	public SystemDictionary getSystemDictionary() {
		
		return systemDictionary;
	}

	public void setSystemDictionary(SystemDictionary systemDictionary) {
		
		this.systemDictionary = systemDictionary;
	}

}
