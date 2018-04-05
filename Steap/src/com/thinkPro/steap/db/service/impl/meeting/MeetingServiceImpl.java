package com.thinkPro.steap.db.service.impl.meeting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.InstitutionNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingCondition;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.meeting.IMeetingMapper;
import com.thinkPro.steap.db.service.meeting.MeetingService;

@Service("meetingService")
public class MeetingServiceImpl implements MeetingService {

	@Resource
	private IMeetingMapper meetingMapper;

	/* -------------------------START BY HaoShaSha ------------------- */

	/*****************************************************************************/
	/******************* 1.关于会议增删改查的数据库操作 ***************************/
	/*****************************************************************************/

	/**
	 * 创建会议+创建的会议对应的项目信息
	 * 
	 * @param meeting
	 * @return
	 */
	public boolean addMeeting(Meeting meeting, List<String> projectIds)
			throws SQLException {

		if (meeting != null && projectIds != null && projectIds.size() > 0) {

			// 创建一条会议信息
			String meetingId = meetingMapper.getNextMeetingId();
			if (meetingId == null || meetingId.equals("")) {
				meetingId = "M100001";
			}
			meeting.setMeetingId(meetingId);
			boolean result = meetingMapper.addMeeting(meeting) > 0 ? true : false;

			if (result) {

				// 创建会议对应的项目信息（会议项目表）

				Map<String, Object> projectMeeting = new HashMap<String, Object>();

				projectMeeting.put("meetingId", meetingId);

				projectMeeting.put("projectIds", projectIds);

				result = meetingMapper.addProjectMeeting(projectMeeting) > 0 ? true
						: false;

			}
			return result;

		} else {

			return false;
		}

	}

	/**
	 * 根据会议编号删除会议项目信息(Delete)
	 * 
	 * @return
	 */
	public boolean deleteMeeting(String meetingId) throws SQLException {

		boolean result = ValidateCheck.isNotNull(meetingId);

		if (result) {

			return meetingMapper.deleteMeeting(meetingId) > 0 ? true : false;

		} else {

			return false;
		}

	}

	/**
	 * 修改会议的状态
	 * 
	 * @param meetingStatus中的值应该是
	 *            (会议编号，会议状态) （meetingId,meetingStatus）
	 * @return
	 */
	public boolean updateMeetingStatus(Map<String, Object> meetingStatus)
			throws SQLException {

		if (meetingStatus != null && meetingStatus.size() == 2) {

			// 此处应该补充，需要先从字典表中查找出对应的状态，再进行更新操作

			return meetingMapper.updateMeetingStatus(meetingStatus) > 0 ? true
					: false;

		} else {

			return false;
		}

	}

	/**
	 * 修改会议的通知
	 * 
	 * @param meetingNotice中的值应该是
	 *            (会议编号，会议通知) （meetingId,meetingNotice）
	 * @return
	 */
	public boolean updateMeetingNotice(Map<String, Object> meetingNotice)
			throws SQLException {

		if (meetingNotice != null && meetingNotice.size() == 2) {

			return meetingMapper.updateMeetingNotice(meetingNotice) > 0 ? true
					: false;

		} else {

			return false;
		}

	}

	/**
	 * 根据条件查询会议信息
	 * 
	 * @param meetingCondition
	 *            （会议状态+会议日期+页码+每页显示的行数）
	 *            (meetingStatus,meetingTime,pageBegin,pageSize)
	 * @return
	 */
	public List<Meeting> getMeetingInfos(MeetingCondition condition)
			throws SQLException {

		// 此处应该补充，需要先从字典表中查找出对应的状态，再进行更新操作

		if (condition != null) {

			return meetingMapper.getMeetingInfos(condition);

		} else {

			return null;
		}

	}

	/**
	 * 查询满足条件的会议的数量
	 * 
	 * @param condition
	 *            （会议状态+会议日期）
	 * @return 返回满足条件的会议的数量
	 * @throws SQLException
	 */
	public int getMeetingCount(MeetingCondition condition) throws SQLException {

		if (condition != null) {

			return meetingMapper.getMeetingCount(condition);

		} else {

			return 0;
		}

	}

	/**
	 * 修改会议基本信息
	 * 
	 * @param meeting
	 *            修改后的会议的基本信息
	 * @return
	 * @throws SQLException
	 */
	public boolean updateMeeting(Meeting meeting) throws SQLException {

		if (meeting != null) {

			return meetingMapper.updateMeeting(meeting) > 0 ? true : false;

		} else {

			return false;
		}
	}

	/*****************************************************************************/
	/******************* 2.通知负责项目的企业 的数据库操作 ***************************/
	/*****************************************************************************/

	/**
	 * 根据meetingId查询某一个会议涉及到的项目的信息 主要是针对项目信息+通知日期+通知方式
	 * 
	 * @param meetingId
	 * @return
	 */
	public List<EnterpriseNotify> getEnterpriseNotify(String meetingId)
			throws SQLException {

		boolean result = ValidateCheck.isNotNull(meetingId);

		if (result) {

			return meetingMapper.getEnterpriseNotify(meetingId);

		} else {

			return null;
		}

	}

	/**
	 * 批量更新通知企业的信息(通知方式,通知时间)
	 * 
	 * @param enterpriseNotify
	 *            （map里面的信息是 会议编号，项目编号，通知日期，通知方式）
	 *            (meetingId,projectId,notifyDate,notifyMethod)
	 * @return
	 */
	public boolean updateProjectMeeting(
			List<Map<String, Object>> enterpriseNotify) throws SQLException {

		if (enterpriseNotify != null && enterpriseNotify.size() > 0) {

			return meetingMapper.updateProjectMeeting(enterpriseNotify) > 0 ? true
					: false;

		} else {

			return false;
		}

	}

	/*****************************************************************************/
	/******************* 3.关于通知机构相关人员的数据库操作 ***************************/
	/*****************************************************************************/

	/**
	 * 根据会议编号查询 通知相关人员 的基本情况
	 * 
	 * @param meetingId
	 *            会议编号
	 * @return InstitutionNotify 通知机构相关人员
	 */
	public List<InstitutionNotify> getInstitutionNotify(String meetingId)
			throws SQLException {

		// 机构的话，如果数据库字段保持不变的话，(即机构通知表使用的是institutionName)
		// 查询字典的操作可以跳过，如果要变为 institutionId 则需要先关联字典表
		boolean result = ValidateCheck.isNotNull(meetingId);

		if (result) {

			return meetingMapper.getInstitutionNotify(meetingId);

		} else {

			return null;
		}

	}

	/**
	 * 批量插入通知相关人员的基本情况
	 * 
	 * @param institutionNotify
	 * @return
	 */
	public boolean addInstitutionNotify(
			List<InstitutionNotify> institutionNotify) throws SQLException {

		// 机构的话，如果数据库字段保持不变的话，(即机构通知表使用的是institutionName)
		// 查询字典的操作可以跳过，如果要变为 institutionId 则需要先关联字典表 包装后再保存
		// 但是这样会严重影响性能
		if (institutionNotify != null && institutionNotify.size() > 0) {

			return meetingMapper.addInstitutionNotify(institutionNotify) > 0 ? true
					: false;

		} else {

			return false;
		}

	}
	
	/**
	 * 删除通知相关人员
	 * @param institutionNotify
	 * @return
	 */
	public int deleteNotifyById(String deleteNotifyId)throws SQLException{
		
		if(deleteNotifyId != null){
			return meetingMapper.deleteNotifyById(deleteNotifyId);
		}
		return 0;
	}

	/**
	 * 批量更新 通知相关人员 的基本情况
	 * 
	 * @param enterpriseNotify
	 *            （map里面的信息是 会议编号，项目编号，通知日期，通知方式）
	 *            (notifyId,notifyDate,notifyMethod)
	 * @return 暂时不需要
	 */
	public boolean updateInstitutionNotify(
			List<Map<String, Object>> enterpriseNotify) throws SQLException {

		if (enterpriseNotify != null && enterpriseNotify.size() > 0) {

			return meetingMapper.updateInstitutionNotify(enterpriseNotify) > 0 ? true
					: false;

		} else {

			return false;
		}

	}

	/* -------------------------END BY HaoShaSha ------------------- */
	/**
	 * 根据专家编号和会议状态查询参加的会议信息
	 * 
	 * @param mapInfo
	 *            专家编号、会议状态
	 * @return 会议信息
	 * @throws SQLException
	 */
	public Map<String, Object> getMeetingByMapInfo(Map<String, Object> mapInfo)
			throws SQLException {
		if (mapInfo.size() != 0) {
			return meetingMapper.getMeetingByMapInfo(mapInfo);
		}
		return null;
	}

	/**
	 * 根据会议主持人编号和会议状态查询已经主持过的会议信息集合
	 * 
	 * @param hostId
	 * @return
	 * @throws SQLException
	 */
	public List<Meeting> getMeetingListByHostId(Map<String, Object> meeting_host)
			throws SQLException {
		if (meeting_host.size() != 0) {
			return meetingMapper.getMeetingListByHostId(meeting_host);
		}
		return null;
	}

	/**
	 * 根据会议主持人编号和会议状态查询会议主持人当前要主持的会议
	 * 
	 * @param meeting_host
	 *            主持人编号、会议状态
	 * @return 待主持的会议信息
	 * @throws SQLException
	 */
	public Meeting getMeetingByHostId(Map<String, Object> meeting_host)
			throws SQLException {
		if (meeting_host.size() != 0) {
			return meetingMapper.getMeetingByHostId(meeting_host);
		}
		return null;
	}

	/**
	 * 根据会议编号获取当前会议基本信息
	 * 
	 * @param meetingId
	 *            会议编号
	 * @return 会议基本信息
	 * @throws SQLException
	 */
	public Map<String, Object> getMeetingById(String meetingId)
			throws SQLException {
		if (ValidateCheck.isNotNull(meetingId)) {
			return meetingMapper.getMeetingById(meetingId);
		}
		return null;
	}

	/**
	 * 根据项目编号查询企业通知方式和通知日期
	 * 
	 * @param projectId
	 *            项目编号
	 * @return 企业通知信息
	 * @throws SQLException
	 */
	public Map<String, Object> getProjectNotifyByProjectId(String projectId)
			throws SQLException {
		if (ValidateCheck.isNotNull(projectId)) {
			return meetingMapper.getProjectNotifyByProjectId(projectId);
		}
		return null;
	}

	/**
	 * 根据项目编号查询会议信息
	 * 
	 * @param project_meeting
	 *            项目编号、会议状态
	 * @return 会议信息
	 * @throws SQLException
	 */
	public Map<String, Object> getMeetingByProjectId(
			Map<String, Object> project_meeting) throws SQLException {
		if (project_meeting.size() != 0) {
			return meetingMapper.getMeetingByProjectId(project_meeting);
		}
		return null;
	}

	/**
	 * 更新会议的当前状态
	 * 
	 * @param meetingStatus
	 *            会议编号、会议状态
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public boolean updateMeetingCurrentStatus(Map<String, Object> meetingStatus)
			throws SQLException {
		boolean result = true;
		if (meetingStatus != null && meetingStatus.size() == 2) {
			result = meetingMapper.updateMeetingCurrentStatus(meetingStatus) != 0 ? true
					: false;
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 分页查询全部会议信息
	 * 
	 * @param condition
	 *            （pageBegin + pageSize + hostId）
	 * @return 分页查询得到的全部会议信息
	 * @throws SQLException
	 */
	public List<Meeting> getAllMeetingsWithPaging(Map<String, Object> condition)
			throws SQLException {
		if (condition != null && condition.size() != 0) {
			return meetingMapper.getAllMeetingsWithPaging(condition);
		}
		return null;
	}

	/**
	 * 获取全部符合条件的会议记录数
	 * 
	 * @param condition
	 *            (pageBegin + pageSize + hostId)
	 * @return 符合条件的会议记录数
	 * @throws SQLException
	 */
	public int getAllMeetingsCountWithPaging(Map<String, Object> condition)
			throws SQLException {
		if (condition != null && condition.size() != 0) {
			return meetingMapper.getAllMeetingsCountWithPaging(condition);
		}
		return 0;
	}

	public List<EnterpriseNotify> getProjectInEnterpriseNotify(
			Map<String, Object> ids) throws SQLException {
		return meetingMapper.getProjectInEnterpriseNotify(ids);
	}
	
	/**
	 * 根据会议状态获取项目列表
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getProjectListByMStatus(Map<String, Object> condition) throws SQLException {
		if (condition.size() > 0) {
			return meetingMapper.getProjectListByMStatus(condition);
		}
		return null;
	}
}
