package com.thinkPro.steap.db.mapper.meeting;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.InstitutionNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingCondition;
/**
 * 这个类主要负责三方面的数据库最底层操作
 * 1.关于会议增删改查的数据库操作
 * 2.通知负责项目的企业 的数据库操作
 * 3.通知机构相关人员    的数据库操作  
 * 
 */
public interface IMeetingMapper{
	
	/*****************************************************************************/
	/*******************     1.关于会议增删改查的数据库操作               ***************************/
	/*****************************************************************************/
	/**
	 * 获取下一个会议Id
	 * @return
	 * @throws SQLException
	 */
	public String getNextMeetingId()throws SQLException;
	/**
	 * 创建会议
	 * @param meeting
	 * @return
	 */
	public int addMeeting(Meeting meeting)throws SQLException;
	
	/**
	 * 插入新创建的会议对应的项目信息
	 * @param projectMeeting
	 * @return
	 */
	
	public int addProjectMeeting(Map<String,Object> projectMeeting)throws SQLException;
	
	/**
	 * 删除会议(Delete)+级联删除会议项目信息(Delete)
	 * @return
	 */
	public int deleteMeeting(String meetingId)throws SQLException;
	
	/**
	 * 修改会议的状态 
	 * @param meetingStatus
	 * @return
	 */
	public int updateMeetingStatus(Map<String,Object> meetingStatus)throws SQLException;
	/**
	 * 修改会议的通知
	 * @param meetingNotice
	 * @return
	 */
	public int updateMeetingNotice(Map<String,Object> meetingNotice)throws SQLException;

	/**
	 * 按条件分页查询会议基本信息
	 * （会议状态+会议日期+页码+每页显示的行数）
	 * @param meetingCondition
	 * @return
	 */
	public List<Meeting> getMeetingInfos(MeetingCondition condition)throws SQLException;
	
	/**
	 * 查询满足条件的会议的数量
	 * @param condition （会议状态+会议日期）
	 * @return 返回满足条件的会议的数量
	 * @throws SQLException
	 */
	public int getMeetingCount(MeetingCondition condition)throws SQLException;
	/**
	 * 修改会议基本信息
	 * @param meeting 修改后的会议的基本信息
	 * @return
	 * @throws SQLException
	 */
	public int updateMeeting(Meeting meeting)throws SQLException;
	/*****************************************************************************/
	/*******************     2.通知负责项目的企业 的数据库操作           ***************************/
	/*****************************************************************************/
	
	
	/**
	 * 根据meetingId查询某一个会议涉及到的项目的信息 主要是针对项目信息+通知日期+通知方式 
	 * @param meetingId
	 * @return
	 */
	public List<EnterpriseNotify> getEnterpriseNotify(String meetingId)throws SQLException;

	/**
	 * 根据meetingId查询某一个会议涉及到的项目的信息 主要是针对项目信息+通知日期+通知方式 
	 * @param meetingId
	 * @return
	 */
	public List<EnterpriseNotify> getProjectInEnterpriseNotify(Map<String,Object> ids)throws SQLException;
	/**
	 * 批量更新通知企业的信息(通知方式,通知时间)
	 * @param enterpriseNotify（map里面的信息是  会议编号，项目编号，通知日期，通知方式）
	 * @return
	 */
	public int updateProjectMeeting(List<Map<String,Object>> enterpriseNotify)throws SQLException;
	
	/*****************************************************************************/
	/*******************     3.关于通知机构相关人员的数据库操作        ***************************/
	/*****************************************************************************/

	/**
	 * 查询通知相关人员的基本情况
	 * @return
	 */
	public List<InstitutionNotify> getInstitutionNotify(String meetingId)throws SQLException;
	
	/**
	 * 批量插入通知相关人员的基本情况
	 * @param institutionNotify
	 * @return
	 */
	public int addInstitutionNotify(List<InstitutionNotify> institutionNotify)throws SQLException;
	
	/**
	 * 删除通知相关人员
	 * @param institutionNotify
	 * @return
	 */
	public int deleteNotifyById(String deleteNotifyId)throws SQLException;
	
	/**
	 * 批量更新通知相关人员的基本情况
	 * 这部分暂时不用
	 * @param enterpriseNotify
	 * @return
	 */
	public int updateInstitutionNotify(List<Map<String,Object>> enterpriseNotify)throws SQLException;
	
	/**
	 * 根据专家编号和会议状态查询参加的会议信息
	 * @param mapInfo 专家编号、会议状态
	 * @return 会议信息
	 * @throws SQLException
	 */
	public Map<String, Object> getMeetingByMapInfo(Map<String, Object> mapInfo) throws SQLException;

	/**
	 * 根据会议主持人编号和会议状态查询已经主持过的会议信息集合
	 * @param meeting_host 主持人编号、会议状态
	 * @return 主持过的会议信息
	 * @throws SQLException
	 */
	public List<Meeting> getMeetingListByHostId(Map<String, Object> meeting_host) throws SQLException;
	
	/**
	 * 根据会议主持人编号和会议状态查询会议主持人当前要主持的会议
	 * @param meeting_host 主持人编号、会议状态
	 * @return 待主持的会议信息
	 * @throws SQLException
	 */
	public Meeting getMeetingByHostId(Map<String, Object> meeting_host) throws SQLException;
	
	/**
	 * 根据会议编号获取当前会议基本信息
	 * @param meetingId 会议编号
	 * @return 会议基本信息
	 * @throws SQLException
	 */
	public Map<String, Object> getMeetingById(String meetingId) throws SQLException;
	
	/**
	 * 根据项目编号查询企业通知方式和通知日期
	 * @param projectId 项目编号
	 * @return 企业通知信息
	 * @throws SQLException
	 */
	public Map<String, Object> getProjectNotifyByProjectId(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号查询会议信息
	 * @param project_meeting 项目编号、会议状态
	 * @return 会议信息
	 * @throws SQLException
	 */
	public Map<String, Object> getMeetingByProjectId(Map<String, Object> project_meeting) throws SQLException;
	
	/**
	 * 更新会议的当前状态
	 * @param meetingStatus 会议编号、会议状态
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateMeetingCurrentStatus(Map<String, Object> meetingStatus) throws SQLException;
	
	/**
	 * 分页查询全部会议信息
	 * @param condition （pageBegin + pageSize + hostId）
	 * @return 分页查询得到的全部会议信息
	 * @throws SQLException
	 */
	public List<Meeting> getAllMeetingsWithPaging(Map<String, Object> condition) throws SQLException;
	
	/**
	 * 获取全部符合条件的会议记录数
	 * @param condition (pageBegin + pageSize + hostId)
	 * @return 符合条件的会议记录数
	 * @throws SQLException
	 */
	public int getAllMeetingsCountWithPaging(Map<String, Object> condition) throws SQLException;
	
	public List<Map<String, Object>> getProjectListByMStatus(Map<String, Object> condition) throws SQLException;
}
