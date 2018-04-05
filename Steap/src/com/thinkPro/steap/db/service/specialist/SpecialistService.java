package com.thinkPro.steap.db.service.specialist;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.specialist.Specialist;

public interface SpecialistService {
	
	/**
	 * 查询专家是否设置初始密码
	 * @param specialistId
	 * @return
	 * @throws SQLException
	 */
	public String isSetInitailPass(String specialistId)throws SQLException;

	/**
	 * 验证添加的专家是否已在专家库存在
	 * @param specialist 专家信息
	 * @return 不存在 返回false 存在 返回true
	 * @throws SQLException
	 */
	public boolean isLibrarySpecialist(Specialist specialist) throws SQLException;

	/**
	 * 查询专家签名用于检测是否已经上传专家签名
	 * @param specialistId 专家编号
	 * @return 专家签名存在与否
	 * @throws SQLException
	 */
	public boolean ifExistSignature(String specialistId) throws SQLException;
	
	/**
	 * 根据专家编号获取专家个人签名
	 * @param specialistId 专家编号
	 * @return 专家签名
	 * @throws SQLException
	 */
	public String getSpecialistSignature(String specialistId) throws SQLException;
	
	/**
	 * 插入会议安排的专家
	 * @param specialists
	 * map中的内容为(meetingId,specialistId,source)
	 * 会议编号,专家编号,专家来源
	 * @return
	 */
	public int insertArrangedSpecialist(List<Map<String,Object>> specialists) throws SQLException;
	
	/**
	 * 修改会议安排的专家的信息  是否是组长  数据库中默认是不是组长
	 * @param Leader
	 * map中包括(meetingId,specialistId,isLeader)
	 * @return
	 */
	public int updateLeader(Map<String,Object> leader) throws SQLException;
	
	/**
	 * 添加企业推荐专家的信息
	 * @param specialists 企业推荐专家的信息(List)
	 * @return 如果全部添加成功，返回true；其中一条插入失败，之前添加全部撤销，返回false
	 * @throws Exception
	 */
	public boolean insertRecommendSpecialistList(List<Specialist> specialists) throws SQLException;

	/**
	 * 根据项目返回Id返回专家信息
	 * @param projectId 项目Id
	 * @return 推荐专家信息(List)
	 * @throws Exception
	 */
	public List<Specialist> getRecommendSpecialistList(String projectId) throws SQLException;
	
	/*--------------------Start: 专家推荐 by yachao----------------------------*/
	
	/**
	 * 根据会议编号获取全部专家信息
	 * @param meetingId 会议编号
	 * @return 会议全部专家基本信息
	 */
	public List<Specialist> getSpecialistsByMeetingId(String meetingId) throws SQLException;
	
	/**
	 * 根据专家编号获取专家基本信息(当不清楚专家来源时，通过ID进行模糊查询)
	 * @param object 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getSpecialistById(String specialistId) throws SQLException;
	
	/**
	 * 根据专家编号从专家推荐表中获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getRecommendSpecialistById(String specialistId) throws SQLException;

	/**
	 * 根据专家编号从专家库中获取专家基本信息
	 * @param specialistId 专家编号
	 * @return 专家基本信息
	 * @throws SQLException
	 */
	public Specialist getLibrarySpecialistById(String specialistId) throws SQLException;
	
	/**
	 * 根据会议编号查询专家组名单
	 * @param meetingId 会议编号
	 * @return 专家组名单
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getSpecialistGroupByMeetingId(String meetingId) throws SQLException;
	
	public List<Specialist> getSpecialistsByIf(Map<String, Object> specialistCon) throws SQLException;
	
	/**
	 * 根据专家编号、会议编号获取专家是否签订承诺书
	 * @param meeting_specialist 专家编号、会议编号
	 * @return 承诺书签订结果
	 * @throws SQLException
	 */
	public boolean getSignCommitmentResult(Map<String, Object> meeting_specialist) throws SQLException;
	
	/**
	 * 根据专家编号获取专家登录密码
	 * @param specialistId 专家编号
	 * @return 系统登录密码
	 * @throws SQLException
	 */
	public String getLibraryPassBySpecialistId(String specialistId) throws SQLException;
	
	/**
	 * 根据专家编号获取专家签名密码
	 * @param specialistId 专家编号
	 * @return 签名密码
	 * @throws SQLException
	 */
	public String getLibrarySignaturePassBySpecialistId(String specialistId) throws SQLException, NullPointerException;
	
	/**
	 * 根据专家编号获取专家姓名，手机号，密码
	 * @param specialistId 专家编号 
	 * @return 专家部分信息
	 * @throws SQLException
	 */
	public Map<String, Object> getRSPartInfoById(String specialistId) throws SQLException;
	
	/**
	 * 录入专家基本信息到推荐表中
	 * @param specialist 专家基本信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertRecommendSpecialist(Specialist specialist) throws SQLException;
	
	/**
	 * 录入专家基本信息到专家库中
	 * @param specialist 专家基本信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertLibrarySpecialist(Specialist specialist) throws SQLException;

	/**
	 * 修改推荐专家的密码
	 * @param specialist_password 专家编号和密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistPassword(Map<String, Object> specialist_password) throws SQLException;

	/**
	 * 修改库专家的密码
	 * @param specialist_password 专家编号和密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistPassword(Map<String, Object> specialist_password) throws SQLException;
	
	/**
	 * 修改专家密码。注:当不知道专家来源是什么时，采用该方法进行修改
	 * @param specialist_password 专家编号、密码
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateSpecialistPassword(Map<String, Object> specialist_password) throws SQLException;
	
	/**
	 * 设置推荐专家签名和签名密码
	 * @param signature 专家编号、签名、签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignatureInfo(Map<String, Object> signature) throws SQLException;
	
	/**
	 * 设置库专家签名和签名密码
	 * @param signature 专家编号、签名、签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignatureInfo(Map<String, Object> signature) throws SQLException;
	
	/**
	 * 修改推荐专家签名
	 * @param specialist_signature 专家编号和签名
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignature(Map<String, Object> specialist_signature) throws SQLException;
	
	/**
	 * 修改库专家签名
	 * @param specialist_signarure 专家编号和签名
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignature(Map<String, Object> specialist_signarure) throws SQLException;

	/**
	 * 修改专家签名
	 * @param specialist_signature 专家编号和签名
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateSpecialistSignature(Map<String, Object> specialist_signature) throws SQLException;
	
	/**
	 * 设置推荐专家签名密码
	 * @param specialist_signaturePass 专家编号和签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException;
	
	/**
	 * 设置库专家签名密码
	 * @param specialist_signaturePass 专家编号和签名密码
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException;
	
	/**
	 * 修改专家签名密码
	 * @param specialist_signaturePass 专家编号和签名面貌
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateSpecialistSignaturePass(Map<String, Object> specialist_signaturePass) throws SQLException;
	
	/**
	 * 专家签订承诺书
	 * @param specialist_agree 专家编号、同意承诺书与否(specialistId + isAgree + isPromise)
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateSpecialistGignAgree(Map<String, Object> specialist_agree) throws SQLException;
	
	/**
	 * 修改专家库专家基本信息
	 * @param specialist 专家基本信息
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateLibrarySpecialist(Specialist specialist) throws SQLException;
	
	/**
	 * 修改企业推荐专家信息
	 * @param specialist 专家基本信息
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateRecommendSpecialist(Specialist specialist) throws SQLException;
	
	/**
	 * 修改专家信息。当不知道专家来源时使用该方法进行修改专家信息
	 * @param specialist 专家基本信息
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public int updateSpecialist(Specialist specialist) throws SQLException;
	
	/**
	 * 根据专家编号删除推荐专家信息
	 * @param specialistId 推荐专家编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteRecommendSpecialistById(String specialistId) throws SQLException;
	
	/**
	 * 根据专家编号删除库专家信息
	 * @param specialistId 库专家编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteLibrarySpecialistById(String specialistId) throws SQLException;

	/**
	 * 删除会议确定的全部专家
	 * @param meetingId 会议编号
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteSpecialistsByMeetingId(String meetingId) throws SQLException;

	/**
	 * 删除会议安排的某个专家
	 * @param arrangedSpecialist 会议编号、专家编号 
	 * @return 删除的记录数
	 * @throws SQLException
	 */
	public int deleteArrangedSpecialist(Map<String, Object> arrangedSpecialist) throws SQLException;
	
	/*--------------------End: 专家推荐 by yachao----------------------------*/

	/*----------------Start by HaoShaSha--------------------*/
	/**
	 * 查询满足条件的专家的数量
	 * @param condition(name,engageDomain) 专家姓名，所属领域
	 * @return 返回满足条件的专家的数量
	 * @throws SQLException
	 */
	public int getSpecialistCount(Map<String, Object> condition)throws SQLException;
	/*----------------End by HaoShaSha--------------------*/
	
	public int getMeetingSpecialistCount(String meetingId) throws SQLException;
	
	public boolean selectSpecAccountById(String specialistId) throws SQLException;

	public boolean addAccountForSpec(Map<String, Object> accountInfo) throws SQLException;

	public boolean deleteAccountForSpec(String specialistId) throws SQLException;
	
	public List<Map<String, Object>> getSpecialistOpinionListByPId(String projectId) throws SQLException;
}
