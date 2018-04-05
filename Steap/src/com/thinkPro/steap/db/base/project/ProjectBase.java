package com.thinkPro.steap.db.base.project;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.meeting.ProjectInfoResult;
import com.thinkPro.steap.bean.meeting.ProjectPreMaterialInfo;
import com.thinkPro.steap.bean.project.AuditInfo;
import com.thinkPro.steap.bean.project.EnterpriseInspect;
import com.thinkPro.steap.bean.project.IssueCertificate;
import com.thinkPro.steap.bean.project.Project;
import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.bean.project.ProjectCensor;
import com.thinkPro.steap.bean.project.ProjectCharge;
import com.thinkPro.steap.bean.project.ProjectCondition;
import com.thinkPro.steap.bean.project.ProjectInfoOfPrepared;
import com.thinkPro.steap.bean.project.ProjectQuery;
import com.thinkPro.steap.bean.project.ProjectReceive;
import com.thinkPro.steap.bean.project.ProjectRecord;
import com.thinkPro.steap.db.mapper.project.IProjectMapper;

public class ProjectBase implements IProjectMapper {
	
	private ApplicationContext applicationContext;

	private IProjectMapper projectMapper;

	public ProjectBase() {

		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		projectMapper = (IProjectMapper) applicationContext
				.getBean("IProjectMapper");
	}
	/**
	 * 添加项目基本信息
	 * @param project 项目基本信息
	 * @return 插入成功的记录数
	 * @throws Exception
	 */
	public int addProject(Project project) throws SQLException{
		return projectMapper.addProject(project);
	}
	
	/**
	 * 修改项目信息
	 * @param project 项目信息
	 * @return
	 * @throws SQLException
	 */
	public int updateProject(Project project) throws SQLException{
		return projectMapper.updateProject(project);
	}
	
	/**
	 * 删除项目信息
	 * @param projectId 项目Id
	 * @return
	 * @throws SQLException
	 */
	public int deleteProject(String projectId) throws SQLException{
		return projectMapper.deleteProject(projectId);
	}
	/**
	 * 添加项目登记信息
	 * @param projectRecord 项目登记信息
	 * @return 插入成功的记录数
	 * @throws Exception
	 */
	public int addProjectRecord(ProjectRecord projectRecord)throws SQLException{
		return projectMapper.addProjectRecord(projectRecord);
	}
	/**
	 * 添加确认项目负责部门信息
	 * @param projectCharge 项目负责部门信息
	 * @return 插入成功的记录数
	 * @throws Exception
	 */
	public int addProjectCharge(ProjectCharge projectCharge)throws SQLException{
		return projectMapper.addProjectCharge(projectCharge);
	}
	/**
	 * 添加领取项目资料信息
	 * @param projectReceive 项目领取资料信息
	 * @return 插入成功的记录数
	 * @throws Exception
	 */
	public int addProjectReceive(ProjectReceive projectReceive)throws SQLException{
		return projectMapper.addProjectReceive(projectReceive);
	}
	
	/**
	 * 添加审查项目资料信息(审查人，审查时间，审查结果)
	 * @param projectCensor审查项目资料信息
	 * @return
	 * @throws SQLException
	 */
	public int addProjectCensor(ProjectCensor projectCensor)throws SQLException{
		return projectMapper.addProjectCensor(projectCensor);
	}
	
	/**
	 * 修改审查项目资料信息(审查人，审查时间，审查结果)
	 * @param projectCensor审查项目资料信息
	 * @return
	 * @throws SQLException
	 */
	public boolean updateProjectCensor(ProjectCensor projectCensor)throws SQLException{
		return projectMapper.updateProjectCensor(projectCensor);
	}
	
	/**
	 * 添加企业现场考察信息(考察人，考察时间，考察结果)
	 * @param enterpriseInspect 企业现场考察时间
	 * @return
	 * @throws SQLException
	 */
	public int addEnterpriseInspect(EnterpriseInspect enterpriseInspect)throws SQLException{
		return projectMapper.addEnterpriseInspect(enterpriseInspect);
	}
	
	/**
	 * 添加项目审计信息(审计人，审计单位，审计结果)
	 * @param auditInfo
	 * @return
	 * @throws SQLException
	 */

	public int addAuditInfo(AuditInfo auditInfo)throws SQLException{
		return projectMapper.addAuditInfo(auditInfo);
	}
	
	/**
	 * 修改项目状态
	 * @param projectStatus 项目状态
	 * @return
	 * @throws SQLException
	 */
	public int updateProjectStatus(Map<String,String> projectStatus)throws SQLException{
		return projectMapper.updateProjectStatus(projectStatus);
	}
	
	/**
	 * 返回项目记录数(用于分页)
	 * @return 项目记录数
	 * @throws SQLException
	 */
	public int getProjectCount(ProjectCondition condition)throws SQLException{
		return projectMapper.getProjectCount(condition);
	}

	/**
	 * 返回项目记录数(用于分页)
	 * @return 项目记录数
	 * @throws SQLException
	 */
	public int getProjectCount2(ProjectCondition condition)throws SQLException{
		return projectMapper.getProjectCount2(condition);
	}
	
	/**
	 * 根据项目Id查询企业现场考察信息
	 * @param projectId 项目Id
	 * @return 某个项目的企业现场考察信息
	 * @throws SQLException
	 */
	public String getNextInspectId()throws SQLException{
		return projectMapper.getNextInspectId();
	}

	/**
	 * 根据项目Id查询审计信息
	 * @param projectId 项目Id
	 * @return
	 * @throws SQLException
	 */
	public EnterpriseInspect getInspectByProjectId(String projectId)throws SQLException{
		return projectMapper.getInspectByProjectId(projectId);
	}
	
	/**
	 * 根据项目信息查询项目负责部门信息
	 * @param projectId 项目Id
	 * @return 项目负责部门信息
	 * @throws SQLException
	 */
	public AuditInfo getAuditInfoByProjectId(String projectId)throws SQLException{
		return projectMapper.getAuditInfoByProjectId(projectId);
	}
	
	/**
	 * 查询企业现场考察信息下一条记录的Id
	 * @return 企业现场考察Id
	 * @throws SQLException
	 */
	public ProjectCharge getChargeByProjectId(String projectId)throws SQLException{
		return projectMapper.getChargeByProjectId(projectId);
	}
	
	/**
	 * 根据条件分页查询项目信息
	 * @param condition 查询条件(项目名称，申请单位，所属领域，登记时间)
	 * @return 项目基本信息(List)
	 * @throws SQLException
	 */
	public List<Project> getProjectInfoByIf(ProjectCondition condition)throws SQLException{
		return projectMapper.getProjectInfoByIf(condition);
	}
	
	/**
	 * 根据条件分页查询项目信息
	 * @param condition 查询条件(项目名称，申请单位，所属领域，登记时间)
	 * @return 项目基本信息(List)
	 * @throws SQLException
	 */
	public List<Project> getProjectInfoByIf2(ProjectCondition condition)throws SQLException{
		return projectMapper.getProjectInfoByIf2(condition);
	}
	
	/**
	 * 根据项目Id查询项目接受信息
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public ProjectAccept getAcceptInfoByProjectId(String projectId)throws SQLException{
		return projectMapper.getAcceptInfoByProjectId(projectId);
	}
	/**
	 * 根据条件分页查询项目接收信息
	 * @param condition 查询条件(项目名称，申请单位，所属领域，登记时间)
	 * @return 项目接收信息(List)
	 * @throws SQLException
	 */
	public List<ProjectAccept> getProjectAcceptInfoByIf(ProjectCondition condition)throws SQLException{
		return projectMapper.getProjectAcceptInfoByIf(condition);
	}
	
	/**
	 * 添加项目发放证书信息
	 * @param issueCertificate 项目证书发放信息
	 * @return
	 * @throws SQLException
	 */
	public int addCertificate(IssueCertificate issueCertificate)throws SQLException{
		return projectMapper.addCertificate(issueCertificate);
	}
	
	/*------------------START BY HaoShaSha ----------------------------*/
	/**
	 * 查询所有已考察项目的部分待验收信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，经费，起始行数，记录数)
	 * @return
	 */
	public List<ProjectInfoResult> getInspectedProjects(ProjectCondition condition) throws SQLException{
		
		return projectMapper.getInspectedProjects(condition); 
	}
	
	/**
	 * 查询所有已现场考察项目的数量
	 * @param condition 查询条件(项目名称，项目编号，所属领域，经费，起始行数，记录数)
	 * @return 所有已现场考察项目的数量
	 * @throws SQLException
	 */
	public int getInspectedProsCount(ProjectCondition condition)throws SQLException{
		
		return projectMapper.getInspectedProsCount(condition);
	}
	
	/**
	 * 根据meetingId某一个会议涉及到的所有项目的信息 主要是针对项目信息+验收意见初稿+真实性承诺书
	 * 
	 * @param meetingCondition  mapmeetingId  acceptance  authenticityCommitment
	 *            					会议编号    	         验收意见初稿		    真实性承诺书
	 * @return
	 */
	public List<ProjectPreMaterialInfo> getProjectPreMaterialInfo(Map<String,Object> meetingCondition) throws SQLException{
		
		return projectMapper.getProjectPreMaterialInfo(meetingCondition);
	}
	
	/**
	 * 根据meetingId某一个会议涉及到的所有项目的信息 主要是针对项目信息+验收意见初稿+真实性承诺书
	 * @param meetingId 会议编号
	 * @return 项目信息和基本提示
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getProjectPreMaterialInfo2(Map<String, Object> meetingInfo) throws SQLException {
		return projectMapper.getProjectPreMaterialInfo2(meetingInfo);
	}
	
	/**
	 * 根据项目编号查询项目第一阶段的所有信息
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public ProjectInfoOfPrepared getProjectInfoByProjectId(String projectId)throws SQLException{
		
		return projectMapper.getProjectInfoByProjectId(projectId);
	}
	/*------------------END BY HaoShaSha ----------------------------*/
	/**
	 * 根据会议编号获取全部项目信息
	 * @param meetingId 会议编号
	 * @return 全部项目基本信息
	 */
	public List<Map<String, Object>> getProjectsByMeetingId(String meetingId) throws SQLException {
		return projectMapper.getProjectsByMeetingId(meetingId);
	}
	
	/**
	 * 根据专家编号查询当前专家已经评审过的项目基本信息
	 * @param specialistId 专家编号
	 * @return 全部评审过的项目
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getPastProjectsBySpecialistId(String specialistId) throws SQLException {
		return projectMapper.getPastProjectsBySpecialistId(specialistId);
	}

	/**
	 * 根据项目编号获取项目的部分信息
	 * @param projectId 项目编号
	 * @return 项目的部分信息
	 * @throws SQLException
	 */
	public Map<String, Object> getProjectPartByProjectId(String projectId) throws SQLException {
		return projectMapper.getProjectPartByProjectId(projectId);
	}
	
	/**
	 * 发放证书：组合条件查询项目信息：（项目名称、申请单位、所属领域、项目经费）
	 * @param condition 项目名称、申请单位、所属领域、项目经费、项目状态("已通过审核") 
	 * @return 项目信息集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllProjectByConditionWithPaging(Map<String, Object> condition) throws SQLException {
		return projectMapper.getAllProjectByConditionWithPaging(condition);
	}
	
	/**
	 * 导出表格：项目信息 
	 * @param condition 组合条件
	 * @return 项目集合信息
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllProjectsNoPaging(Map<String, Object> condition) throws SQLException {
		return projectMapper.getAllProjectsNoPaging(condition);
	}
	
	/**
	 * 发放证书
	 * @param issueCertificate 发放证书信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertIssueCertificate(IssueCertificate issueCertificate) throws SQLException {
		return projectMapper.insertIssueCertificate(issueCertificate);
	}
	
	/**
	 * 发放证书:针对某一要发放证书的项目查询信息
	 * @param projectId 项目编号   status 項目状态("已评估")
	 * @return 项目信息
	 * @throws SQLException
	 */
	public Map<String, Object> getIssueProjectInfoByProjectId(Map<String,Object> projectCondition) throws SQLException {
		return projectMapper.getIssueProjectInfoByProjectId(projectCondition);
	}
	
	/**
	 * 根据项目编号查询项目的审查信息
	 * @param projectId 项目编号
	 * @return 项目信息
	 * @throws SQLException
	 */
	public Map<String, Object> getVerifyInfoByProjectId(String projectId) throws SQLException {
		return projectMapper.getVerifyInfoByProjectId(projectId);
	}
	
	/**
	 * 根据项目编号 to 查询切换板一中需要的  to 项目基本信息结果
	 * @param projectId 项目编号
	 * @return 项目基本信息
	 * @throws SQLException
	 */
	public Map<String, Object> getBIProjectByProjectId(String projectId) throws SQLException {
		return projectMapper.getBIProjectByProjectId(projectId);
	}
	
	/**
	 * 根据项目编号  to 查询切换版二中需要的  to 现场考察相关信息
	 * @param projectId 项目编号
	 * @return 企业考察基本信息
	 * @throws SQLException
	 */
	public EnterpriseInspect getBIEInspectByProjectId(String projectId) throws SQLException {
		return projectMapper.getBIEInspectByProjectId(projectId);
	}
	
	/**
	 * 根据企业考察编号获取审计信息
	 * @param inspectId 企业考察编号
	 * @return 审计信息
	 * @throws SQLException
	 */
	public Map<String, Object> getBIAuditByInspectId(String inspectId) throws SQLException {
		return projectMapper.getBIAuditByInspectId(inspectId);
	}
	
	/**
	 * 更新项目发放证书状态
	 * @param project_certificate 项目编号、发放证书与否
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateProjectCertificate(Map<String, Object> project_certificate) throws SQLException {
		return projectMapper.updateProjectCertificate(project_certificate);
	}
	
	/**
	 * 根据项目编号获取项目证书发放信息
	 * @param projectId 项目编号
	 * @return 证书发放信息
	 * @throws SQLException
	 */
	public Map<String, Object> getIssueCertificateByProjectId(String projectId) throws SQLException {
		return projectMapper.getIssueCertificateByProjectId(projectId);
	}
	
	/**
	 * 通过项目Id查询得到 ，当前的考察Id 
	 *  projectId
	 */
	public String getInspectIdByProjectId(String projectId) throws SQLException{
		return projectMapper.getInspectIdByProjectId(projectId);
	}

	/**
	 *通过projectId查找出项目，并进行更新
	 * EnterpriseInspect
	 **/
	public boolean updateEnterPriseInspect(EnterpriseInspect enterpriseInspect)
			throws SQLException {
		return projectMapper.updateEnterPriseInspect(enterpriseInspect);
	}
	
	/**
	 *通过 auditId 查找出项目，并进行更新
	 *  AuditInfo
	 **/
	public boolean updateInspectInfo(AuditInfo auditInfo) throws SQLException {
		return projectMapper.updateInspectInfo(auditInfo);
	}

	
	/**
	 * 更新项目的当前状态
	 * @param projectStatus 项目编号、项目状态（文字形式）
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateProjectCurrentStatus(Map<String, Object> projectStatus) throws SQLException {
		return projectMapper.updateProjectCurrentStatus(projectStatus);
	}
	
	/**
	 * 根据项目编号获取到项目当前所处的状态
	 * @param projectId 项目编号
	 * @return 项目当前所处状态
	 * @throws SQLException
	 */
	public String getProjectCurrentStatusById(String projectId) throws SQLException {
		return projectMapper.getProjectCurrentStatusById(projectId);
	}
	
	/**
	 * 发放证书：组合条件查询项目时获取全部记录数
	 * @param condition 组合条件
	 * @return 项目记录数
	 * @throws SQLException
	 */
	public int getAllProjectsCountWithPaging(Map<String, Object> condition) throws SQLException {
		return projectMapper.getAllProjectsCountWithPaging(condition);
	}
	
	/**
	 * 根据会议编号查询会议安排的全部项目名称
	 * @param meetingId 会议编号
	 * @return 会议安排的全部项目名称
	 * @throws SQLException
	 */
	public List<String> getMeetingProjectNames(String meetingId) throws SQLException {
		return projectMapper.getMeetingProjectNames(meetingId);
	}
	
	@Override
	public String isProjectId(Map<String, Object> projectId)
			throws SQLException {
		return projectMapper.isProjectId(projectId);
	}
	@Override
	public List<Map<String, Object>> getProjectInAddPage(
			ProjectCondition condition) throws SQLException {
		return projectMapper.getProjectInAddPage(condition);
	}
	
	/**
	 * 提供查询用户权限，可以查看到所有项目状态
	 * @param 項目Id,项目名称，领域，项目经费，登记日期
	 * @return map
	 * @throws SQLException
	 */
	@Override
	public List<Map<String, Object>> getAllProjectInfo(ProjectQuery project) throws SQLException {
		return projectMapper.getAllProjectInfo(project);
	}
	
	/**
	 * 提供查询用户权限，可以查看到所有项目状态
	 * @param 項目Id,项目名称，领域，项目经费，登记日期
	 * @return 数量
	 * @throws SQLException
	 */
	@Override
	public int getAllProjectNum(ProjectQuery project) throws SQLException {
		return projectMapper.getAllProjectNum(project);
	}
	@Override
	public int getMeetingProjectCount(ProjectCondition project) throws SQLException {
		return projectMapper.getMeetingProjectCount(project);
	}
}
