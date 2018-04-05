package com.thinkPro.steap.action.sys.dictionary;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;
/**
 * 删除字典信息
 * @author Hao Shasha
 *
 */
@Component
public class DeleteDictionaryAction extends ActionSupport {

	private static final long serialVersionUID = -796150785473757381L;
	
	private String dictionaryOptionIds;      //Ajax传过来的值（字典编号）
	
	private boolean result;

	@Resource
	private DictionaryService dictionaryService;
	
	public boolean getResult() {
		
		return result;
	}

	public void setResult(boolean result) {
		
		this.result = result;
	}

	public String getDictionaryOptionIds() {
		
		return dictionaryOptionIds;
	}

	public void setDictionaryOptionIds(String dictionaryOptionIds) {
		
		this.dictionaryOptionIds = dictionaryOptionIds;
	}
	
	/**
	 * 批量删除字典信息
	 * @return
	 */
	public String deleteDictionary() {
		
		//得到需要删除的用户的编号
		//dictionaryOptionIds = dictionaryOptionIds.substring(0, dictionaryOptionIds.length()-1);
		
		//System.out.println(dictionaryOptionIds);
		
		//将得到的用户编号的字符串变为列表
		List<String> dictionaryOptionIdList = java.util.Arrays.asList(dictionaryOptionIds.split(","));
		
		this.result = true;
		//通过迭代达到批量删除用户的目的
		for(String dictionaryId:dictionaryOptionIdList){
			
			try {
				this.result = this.result && dictionaryService.deleteDictionary(dictionaryId);
				
/*				if(!result){
					
					return ERROR;
				}*/
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		return SUCCESS;
	}
}
