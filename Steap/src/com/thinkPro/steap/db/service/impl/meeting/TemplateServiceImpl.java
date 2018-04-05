package com.thinkPro.steap.db.service.impl.meeting;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.meeting.MeetingTemplate;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.meeting.ITemplateMapper;
import com.thinkPro.steap.db.service.meeting.TemplateService;

/**
 * 这个类主要负责会议通知的数据库服务层操作
 */
@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
	
	@Resource
	private ITemplateMapper templateMapper;
	
	/* -------------------------START BY HaoShaSha -------------------*/
	/**
	 * 查询所有的会议通知的模板
	 * @return
	 */
	public List<MeetingTemplate> getAllTemplate() throws SQLException{
		
		return templateMapper.getAllTemplate();
	}
	
	/**
	 * 根据条件进行查询会议通知的模板
	 * @param templateId
	 * @return
	 */
	public MeetingTemplate getTemplateById(String templateId) throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(templateId);
		
		if(result){
			
			return templateMapper.getTemplateById(templateId);
		
		}else{
			
			return null;
		}
		
	}
	
	/**
	 * 创建会议通知的模板 
	 * @param meetingTemplate
	 * @return
	 */
	public boolean addTemplate(MeetingTemplate meetingTemplate) throws SQLException{
		
		if(meetingTemplate!=null){
			
			return templateMapper.addTemplate(meetingTemplate) > 0 ? true : false;
		
		}else{
			
			return false;
		}
		
	}
	
	/**
	 * 修改会议通知的模板
	 * @param meetingTemplate
	 * @return
	 */
	public boolean updateTrainPlanInfo(MeetingTemplate meetingTemplate) throws SQLException{
		
		if(meetingTemplate!=null){
			
			return templateMapper.updateTrainPlanInfo(meetingTemplate) > 0 ? true : false;
		
		}else{
			
			return false;
		}
		
	}
	
	/**
	 * 删除会议通知的模板
	 * @param templateId
	 * @return
	 */
	public boolean deleteTemplate(String templateId) throws SQLException{
		
		boolean result = ValidateCheck.isNotNull(templateId);
		
		if(result){
		
			return templateMapper.deleteTemplate(templateId) > 0 ? true : false;
		
		}else{
			
			return false;
		}
	}
	
	/* -------------------------END BY HaoShaSha -------------------*/
}
