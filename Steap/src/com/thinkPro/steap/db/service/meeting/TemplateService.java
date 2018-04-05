package com.thinkPro.steap.db.service.meeting;

import java.sql.SQLException;
import java.util.List;

import com.thinkPro.steap.bean.meeting.MeetingTemplate;

/**
 * 这个类主要负责会议通知的数据库服务层操作
 */
public interface TemplateService {
	
	/* -------------------------START BY HaoShaSha -------------------*/
	/**
	 * 查询所有的会议通知的模板
	 * @return
	 */
	public List<MeetingTemplate> getAllTemplate() throws SQLException;
	
	/**
	 * 根据条件进行查询会议通知的模板
	 * @param templateId
	 * @return
	 */
	public MeetingTemplate getTemplateById(String templateId) throws SQLException;
	
	/**
	 * 创建会议通知的模板 
	 * @param meetingTemplate
	 * @return
	 */
	public boolean addTemplate(MeetingTemplate meetingTemplate) throws SQLException;
	
	/**
	 * 修改会议通知的模板
	 * @param meetingTemplate
	 * @return
	 */
	public boolean updateTrainPlanInfo(MeetingTemplate meetingTemplate) throws SQLException;
	
	/**
	 * 删除会议通知的模板
	 * @param templateId
	 * @return
	 */
	public boolean deleteTemplate(String templateId) throws SQLException;
	
	/* -------------------------END BY HaoShaSha -------------------*/
}
