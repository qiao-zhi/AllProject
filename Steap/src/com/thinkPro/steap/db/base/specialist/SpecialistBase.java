package com.thinkPro.steap.db.base.specialist;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.db.mapper.specialist.ISpecialistMapper;

public class SpecialistBase implements ISpecialistMapper{
	private ApplicationContext applicationContext;
	private ISpecialistMapper iSpecialistMapper;

	public SpecialistBase() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		iSpecialistMapper = (ISpecialistMapper) applicationContext.getBean("ISpecialistMapper");
	}
	
	/**
	 * 获取专家库专家下一个Id
	 * @return
	 * @throws SQLException
	 */
	public String getNextLibraryId()throws SQLException{
		return iSpecialistMapper.getNextLibraryId();
	}
	/**
	 * 插入会议安排的专家
	 * @param specialists
	 * map中的内容为(meetingId,specialistId,source)
	 * 会议编号,专家编号,专家来源
	 * @return
	 */
	public int insertArrangedSpecialist(List<Map<String,Object>> specialists) throws SQLException{
		
		return iSpecialistMapper.insertArrangedSpecialist(specialists);
	}
	
	/**
	 * 修改会议安排的专家的信息  是否是组长  数据库中默认是不是组长
	 * @param Leader
	 * map中包括(meetingId,specialistId,isLeader)
	 * @return
	 */
	public int updateLeader(Map<String,Object> leader) throws SQLException{
		
		return iSpecialistMapper.updateLeader(leader);
	}
	
	public String getNextRecommendSpecialistId() throws SQLException{
		return iSpecialistMapper.getNextRecommendSpecialistId();
	}
	
	public List<Specialist> getRecommendSpecialistList(String projectId) throws SQLException{
		return iSpecialistMapper.getRecommendSpecialistList(projectId);
	}

	/* --------------Start: 专家推荐 by yachao----------------*/
	
	/**
	 * 根据会议编号获取全部专家信息
	 * @param meetingId 会议编号
	 * @return 会议全部专家基本信息
	 */
	public List<Specialist> getSpecialistsByMeetingId(String meetingId) throws SQLException{
		return iSpecialistMapper.getSpecialistsByMeetingId(meetingId);
	}

	/**
	 * 根据专家编号从专家推荐表中获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getRecommendSpecialistById(String specialistId)
			throws SQLException {
		return iSpecialistMapper.getRecommendSpecialistById(specialistId);
	}

	/**
	 * 根据专家编号从专家库中获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getLibrarySpecialistById(String specialistId)
			throws SQLException {
		return iSpecialistMapper.getLibrarySpecialistById(specialistId);
	}
	
	/**
	 * 根据会议编号查询专家组名单
	 * @param meetingId 会议编号
	 * @return 专家组名单
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getSpecialistGroupByMeetingId(String meetingId) throws SQLException {
		return iSpecialistMapper.getSpecialistGroupByMeetingId(meetingId);
	}
	
	public List<Specialist> getSpecialistsByIf(Map<String, Object> specialistCon) throws SQLException {
		return iSpecialistMapper.getSpecialistsByIf(specialistCon);
	}
	
	public boolean getSignCommitmentResult(Map<String, Object> meeting_specialist) throws SQLException {
		return iSpecialistMapper.getSignCommitmentResult(meeting_specialist);
	}
	
	public String getLibraryPassBySpecialistId(String specialistId) throws SQLException {
		return iSpecialistMapper.getLibraryPassBySpecialistId(specialistId);
	}
	
	public String getLibrarySignaturePassBySpecialistId(String specialistId) throws SQLException, NullPointerException {
		return iSpecialistMapper.getLibrarySignaturePassBySpecialistId(specialistId);
	}
	
	public String getRecommendSignaturePassBySpecialistId(String specialistId) throws SQLException, NullPointerException {
		return iSpecialistMapper.getRecommendSignaturePassBySpecialistId(specialistId);
	}
	
	public Map<String, Object> getRSPartInfoById(String specialistId) throws SQLException {
		return iSpecialistMapper.getRSPartInfoById(specialistId);
	}
	/**
	 * 录入专家基本信息到推荐表中
	 * @param specialist 专家基本信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertRecommendSpecialist(Specialist specialist) throws SQLException {
		return iSpecialistMapper.insertRecommendSpecialist(specialist);
	}
	
	/**
	 * 录入专家基本信息到专家库中
	 * @param specialist 专家基本信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertLibrarySpecialist(Specialist specialist) throws SQLException {
		return iSpecialistMapper.insertLibrarySpecialist(specialist);
	}

	/**
	 * 设置推荐专家的密码
	 * @param specialist_password 专家编号和密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistPassword(
			Map<String, Object> specialist_password) throws SQLException {
		return iSpecialistMapper.updateRecommendSpecialistPassword(specialist_password);
	}

	/**
	 * 设置推荐专家签名
	 * @param specialist_signature 专家编号和签名
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignature(Map<String, Object> specialist_signature) throws SQLException {
		return iSpecialistMapper.updateRecommendSpecialistSignature(specialist_signature);
	}
	
	/**
	 * 设置推荐专家签名和签名密码
	 * @param signature 专家编号、签名、签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignatureInfo(Map<String, Object> signature) throws SQLException {
		return iSpecialistMapper.updateRecommendSpecialistSignatureInfo(signature);
	}
	
	/**
	 * 设置推荐专家签名密码
	 * @param specialist_signaturePass 专家编号和签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException {
		return iSpecialistMapper.updateRecommendSpecialistSignaturePass(specialist_signaturePass);
	}
	
	/**
	 * 设置库专家签名和签名密码
	 * @param signature 专家编号、签名、签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignatureInfo(Map<String, Object> signature) throws SQLException {
		return iSpecialistMapper.updateLibrarySpecialistSignatureInfo(signature);
	}
	
	/**
	 * 设置库专家签名
	 * @param specialist_signarure 专家编号和签名
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignature(Map<String, Object> specialist_signarure) throws SQLException {
		return iSpecialistMapper.updateLibrarySpecialistSignature(specialist_signarure);
	}
	
	/**
	 * 设置库专家签名密码
	 * @param specialist_signaturePass 专家编号和签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException {
		return iSpecialistMapper.updateLibrarySpecialistSignaturePass(specialist_signaturePass);
	}
	
	/**
	 * 设置库专家的密码
	 * @param specialist_password 专家编号和密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistPassword(
			Map<String, Object> specialist_password) throws SQLException {
		return iSpecialistMapper.updateLibrarySpecialistPassword(specialist_password);
	}
	
	/**
	 * 专家签订承诺书
	 * @param specialist_agree 专家编号、同意承诺书与否(specialistId + isAgree + isPromise)
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateSpecialistGignAgree(Map<String, Object> specialist_agree) throws SQLException {
		return iSpecialistMapper.updateSpecialistGignAgree(specialist_agree);
	}
	
	/**
	 * 修改专家库专家基本信息
	 * @param specialist 专家基本信息
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialist(Specialist specialist) throws SQLException {
		return iSpecialistMapper.updateLibrarySpecialist(specialist);
	}
	
	/**
	 * 修改企业推荐专家信息
	 * @param specialist 专家基本信息
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialist(Specialist specialist) throws SQLException {
		return iSpecialistMapper.updateRecommendSpecialist(specialist);
	}
	
	/**
	 * 根据专家编号删除推荐专家信息
	 * @param specialistId 推荐专家编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteRecommendSpecialistById(String specialistId) throws SQLException {
		return iSpecialistMapper.deleteRecommendSpecialistById(specialistId);
	}
	
	/**
	 * 根据专家编号删除库专家信息
	 * @param specialistId 库专家编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteLibrarySpecialistById(String specialistId) throws SQLException {
		return iSpecialistMapper.deleteLibrarySpecialistById(specialistId);
	}
	
	/**
	 * 删除会议确定的全部专家
	 * @param meetingId 会议编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteSpecialistsByMeetingId(String meetingId) throws SQLException {
		return iSpecialistMapper.deleteSpecialistsByMeetingId(meetingId);
	}
	
	/**
	 * 删除会议安排的某个专家
	 * @param arrangedSpecialist 会议编号、专家编号 
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteArrangedSpecialist(Map<String, Object> arrangedSpecialist) throws SQLException {
		return iSpecialistMapper.deleteArrangedSpecialist(arrangedSpecialist);
	}
	
	/* --------------End: 专家推荐 by yachao----------------*/
	
	
	/*----------------Start by HaoShaSha--------------------*/
	/**
	 * 查询满足条件的专家的数量
	 * @param condition(name,engageDomain) 专家姓名，所属领域
	 * @return 返回满足条件的专家的数量
	 * @throws SQLException
	 */
	public int getSpecialistCount(Map<String, Object> condition)throws SQLException{
		
		return iSpecialistMapper.getSpecialistCount(condition);
	}
	/*----------------End by HaoShaSha--------------------*/

	public int getMeetingSpecialistCount(String meetingId) throws SQLException {
		return iSpecialistMapper.getMeetingSpecialistCount(meetingId);
	}

	/**
	 * 验证添加的专家是否已在专家库存在
	 * @param specialist 专家信息
	 * @return
	 * @throws SQLException
	 */
	public String isLibrarySpecialist(Specialist specialist)
			throws SQLException {
		return iSpecialistMapper.isLibrarySpecialist(specialist);
	}
	/**
	 * 查询专家是否设置初始密码
	 * @param specialistId
	 * @return
	 * @throws SQLException
	 */
	public String isSetInitailPass(String specialistId)throws SQLException{
		return iSpecialistMapper.isSetInitailPass(specialistId);
	}
	/**
	 * 查询专家签名
	 * @param specialistId 专家编号
	 * @return 专家签名
	 * @throws SQLException
	 */
	public String getSpecialistSignature(String specialistId) throws SQLException {
		return iSpecialistMapper.getSpecialistSignature(specialistId);
	}

	@Override
	public String selectSpecAccountById(String specialistId)
			throws SQLException {
		return iSpecialistMapper.selectSpecAccountById(specialistId);
	}

	@Override
	public int addAccountForSpec(Map<String, Object> accountInfo)
			throws SQLException {
		return iSpecialistMapper.addAccountForSpec(accountInfo);
	}

	@Override
	public int deleteAccountForSpec(String specialistId) throws SQLException {
		return iSpecialistMapper.deleteAccountForSpec(specialistId);
	}
	
	@Override
	public List<Map<String, Object>> getSpecialistOpinionListByPId(String projectId) throws SQLException {
		return iSpecialistMapper.getSpecialistOpinionListByPId(projectId);
	}
}
