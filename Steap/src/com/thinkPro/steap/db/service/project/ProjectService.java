package com.thinkPro.steap.db.service.project;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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


/**
 * 关于项目的基本操作，包括
 * 添加项目信息
 * 添加项目登记信息
 * 添加项目确定负责部门信息
 * 添加项目领取材料信息
 * 添加项目审查信息
 * 添加企业现场考察信息
 * 获得项目信息总记录树
 * 根据条件查询项目基本信息
 * 根据项目ID查询确定负责部门信息
 * 根据条件查询项目接收信息本信息
 * @author mei
 *
 */
public interface ProjectService {

	
	/**
	 * 更改项目的状态
	 * '已登记':'100001'
	 * '已确定负责部门':'100002'
	 * '已领取项目资料':'100003'
	 * '已审查':'100004'
	 * '考察中':'100005'
	 * '已提交':'100006'
	 * @param projectStatus (Map) 项目编号，状态编号
	 * @return 修改的记录数
	 * @throws SQLException
	 */
	public boolean updateProjectStatus(Map<String,String> projectStatus)throws SQLException;
	/**
	 * 登记项目信息，同时记录登记人、登记时间
	 * @param project 项目信息
	 * @param projectRecord 项目登记信息
	 * @return 如果项目信息和项目登记信息同时添加成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addProject(Project project,ProjectRecord projectRecord)throws SQLException;
	
	/**
	 * 修改项目信息
	 * @param project 项目信息
	 * @return
	 * @throws SQLException
	 */
	public boolean updateProject(Project project) throws SQLException;
	
	/**
	 * 删除项目信息
	 * @param projectId 项目Id
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteProject(String projectId) throws SQLException;
	
	/**
	 * 添加项目确定负责部门信息，并修改项目状态为‘已确定负责部门’
	 * @param projectCharge 确定负责部门信息
	 * @return 如果添加确定负责部门信息和修改项目状态同时成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addProjectCharge(ProjectCharge projectCharge)throws SQLException;
	
	/**
	 * 添加领取项目资料信息，并修改项目状态为‘已领取’
	 * @param projectReceive 领取项目资料信息
	 * @return 如果添加领取项目资料信息和修改项目状态同时成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addProjectReceive(ProjectReceive projectReceive)throws SQLException;
	
	/**
	 * 添加项目资料审查信息，并修改项目状态为‘已审查’
	 * @param projectCensor 项目资料审查信息
	 * @return 如果添加领取项目资料信息和修改项目状态同时成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addProjectCensor(ProjectCensor projectCensor) throws SQLException;
	
	/**
	 * 修改项目资料审查信息
	 * @param projectCensor 项目资料审查信息
	 * @throws SQLException
	 */
	public boolean updateProjectCensor(ProjectCensor projectCensor) throws SQLException;
	
	/**
	 * 添加企业现场考察信息
	 * @param enterpriseInspect
	 * @return 如果添加企业现场考察信息和修改项目状态同时成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addEnterpriseInspect(EnterpriseInspect enterpriseInspect) throws SQLException;
	
	/**
	 * 添加审计信息
	 * @param auditInfo 审计信息
	 * @return 如果添加审计信息成功，返回true；否则，返回false
	 * @throws SQLException
	 */
	public boolean addAuditInfo(AuditInfo auditInfo) throws SQLException;
	
	/**
	 * 返回项目信息总记录数(用于分页)
	 * @param countCondition 查询条件(projectName,applicant,domain,recordDate)
	 * @return
	 * @throws SQLException
	 */
	public int getProjectCount(ProjectCondition condition) throws SQLException;
	
	/**
	 * 返回项目信息总记录数(用于分页)
	 * @param countCondition 查询条件(projectName,applicant,domain,recordDate)
	 * @return
	 * @throws SQLException
	 */
	public int getProjectCount2(ProjectCondition condition) throws SQLException;
	
	/**
	 * 根据项目Id查询企业现场考察信息
	 * @param projectId 项目Id
	 * @return 企业现场考察信息(EnterpriseInspect)
	 * @throws SQLException
	 */
	public EnterpriseInspect getInspectByProjectId(String projectId)throws SQLException;
	
	/**
	 * 根据项目Id查询审计信息
	 * @param projectId 项目Id
	 * @return 审计信息(AuditInfo)
	 * @throws SQLException
	 */
	public AuditInfo getAuditInfoByprojectId(String projectId)throws SQLException;
	/**
	 * 根据条件分页查询项目信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，登记时间)
	 * @return 项目信息(List)
	 * @throws SQLException
	 */
	public List<Project> getProjectInfoByIf(ProjectCondition condition) throws SQLException;
	
	/**
	 * 根据条件分页查询项目信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，登记时间)
	 * @return 项目信息(List)
	 * @throws SQLException
	 */
	public List<Project> getProjectInfoByIf2(ProjectCondition condition) throws SQLException;
	
	/**
	 * 根据项目Id返回项目确认负责部门信息
	 * @param projectId 项目Id
	 * @return 确认负责部门信息
	 */
	public ProjectCharge getChargeByProjectId(String projectId)throws SQLException;
	
	/**
	 * 根据项目Id查询项目接受信息
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public ProjectAccept getAcceptInfoByProjectId(String projectId)throws SQLException;
	/**
	 * 根据条件分页查询项目接受信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，登记时间)
	 * @return 项目接受信息(List)
	 * @throws SQLException
	 */
	public List<ProjectAccept> getProjectAcceptInfoByIf(ProjectCondition condition) throws SQLException;
	
	/*------------------START BY HaoShaSha ----------------------------*/
	
	/**
	 * 查询所有已考察项目的部分待验收信息
	 * @param condition 查询条件(项目名称，项目编号，所属领域，经费，起始行数，记录数)
	 * @return
	 */
	public List<ProjectInfoResult> getInspectedProjects(ProjectCondition condition) throws SQLException;
	
	/**
	 * 查询所有已现场考察项目的数量
	 * @param condition 查询条件(项目名称，项目编号，所属领域，经费，起始行数，记录数)
	 * @return 所有已现场考察项目的数量
	 * @throws SQLException
	 */
	public int getInspectedProsCount(ProjectCondition condition)throws SQLException;
	
	/**
	 * 根据meetingId某一个会议涉及到的所有项目的信息 主要是针对项目信息+验收意见初稿+真实性承诺书
	 * 
	 * @param meetingCondition  mapmeetingId  acceptance  authenticityCommitment
	 *            					会议编号    	         验收意见初稿		    真实性承诺书
	 * @return
	 */
	public List<ProjectPreMaterialInfo> getProjectPreMaterialInfo(Map<String,Object> meetingCondition) throws SQLException;
	
	/**
	 * 根据meetingId某一个会议涉及到的所有项目的信息 主要是针对项目信息+验收意见初稿+真实性承诺书
	 * @param meetingId 会议编号
	 * @return 项目信息和基本提示
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getProjectPreMaterialInfo2(Map<String, Object> meetingInfo) throws SQLException;
	
	/**
	 * 根据项目编号查询项目第一阶段的所有信息
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public ProjectInfoOfPrepared getProjectInfoByProjectId(String projectId)throws SQLException;
	
	/*------------------END BY HaoShaSha ----------------------------*/
	
	
	/**
	 * 根据会议编号获取全部项目信息
	 * @param meetingId 会议编号
	 * @return 全部项目基本信息
	 */
	public List<Map<String, Object>> getProjectsByMeetingId(String meetingId) throws SQLException, NullPointerException;
	
	/**
	 * 根据专家编号查询当前专家已经评审过的项目基本信息
	 * @param specialistId 专家编号
	 * @return 全部评审过的项目
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getPastProjectsBySpecialistId(String specialistId) throws SQLException, NullPointerException;
	
	/**
	 * 根据项目编号获取项目的部分信息
	 * @param projectId 项目编号
	 * @return 项目的部分信息
	 * @throws SQLException
	 */
	public Map<String, Object> getProjectPartByProjectId(String projectId) throws SQLException, NullPointerException;
	
	/**
	 * 发放证书：组合条件查询项目信息：（项目名称、申请单位、所属领域、项目经费）
	 * @param condition 项目名称、申请单位、所属领域、项目经费、项目状态("已通过审核") 
	 * @return 项目信息集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllProjectByConditionWithPaging(Map<String, Object> condition) throws SQLException, NullPointerException;
	
	/**
	 * 导出表格：项目信息 
	 * @param condition 组合条件
	 * @return 项目集合信息
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllProjectsNoPaging(Map<String, Object> condition) throws SQLException;
	
	/**
	 * 发放证书
	 * @param issueCertificate 发放证书信息
	 * @return 录入记录数
	 * @throws SQLException
	 */
	public int insertIssueCertificate(IssueCertificate issueCertificate) throws SQLException;
	
	/**
	 * 发放证书:针对某一要发放证书的项目查询信息
	 * @param projectId 项目编号   status 項目状态("已评估")
	 * @return 项目信息
	 * @throws SQLException
	 */
	public Map<String, Object> getIssueProjectInfoByProjectId(Map<String,Object> projectCondition) throws SQLException;
	
	/**
	 * 根据项目编号查询项目的审查信息
	 * @param projectId 项目编号
	 * @return 项目信息
	 * @throws SQLException
	 */
	public Map<String, Object> getVerifyInfoByProjectId(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号 to 查询切换板一中需要的  to 项目基本信息结果
	 * @param projectId 项目编号
	 * @return 项目基本信息
	 * @throws SQLException
	 */
	public Map<String, Object> getBIProjectByProjectId(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号  to 查询切换版二中需要的  to 现场考察相关信息
	 * @param projectId 项目编号
	 * @return 企业考察基本信息
	 * @throws SQLException
	 */
	public EnterpriseInspect getBIEInspectByProjectId(String projectId) throws SQLException;
	
	/**
	 * 根据企业考察编号获取审计信息
	 * @param inspectId 企业考察编号
	 * @return 审计信息
	 * @throws SQLException
	 */
	public Map<String, Object> getBIAuditByInspectId(String inspectId) throws SQLException;
	
	
	/**
	 * 更新项目发放证书状态
	 * @param project_certificate 项目编号、发放证书与否
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateProjectCertificate(Map<String, Object> project_certificate) throws SQLException;
	
	/**
	 * 根据项目编号获取项目证书发放信息
	 * @param projectId 项目编号
	 * @return 证书发放信息
	 * @throws SQLException
	 */
	public Map<String, Object> getIssueCertificateByProjectId(String projectId) throws SQLException;
	
	/**
	 * 通过项目Id查询得到 ，当前的考察Id 
	 *  projectId
	 */
	public String getInspectIdByProjectId(String projectId) throws SQLException;
	
	/**
	 *通过projectId查找出项目，并进行更新
	 * EnterpriseInspect
	 **/
	public boolean updateEnterPriseInspect(EnterpriseInspect enterpriseInspect) throws SQLException;
	
	/**
	 *通过 auditId 查找出项目，并进行更新
	 *  AuditInfo
	 **/
	public boolean updateInspectInfo(AuditInfo auditInfo) throws SQLException;
	
	
	/**
	 * 更新项目的当前状态
	 * @param projectStatus 项目编号、项目状态（文字形式）
	 * @return 修改记录数
	 * @throws SQLException
	 */
	public int updateProjectCurrentStatus(Map<String, Object> projectStatus) throws SQLException;
	
	/**
	 * 根据项目编号获取到项目当前所处的状态
	 * @param projectId 项目编号
	 * @return 项目当前所处状态
	 * @throws SQLException
	 */
	public String getProjectCurrentStatusById(String projectId) throws SQLException, NullPointerException;
	
	/**
	 * 发放证书：组合条件查询项目时获取全部记录数
	 * @param condition 组合条件
	 * @return 项目记录数
	 * @throws SQLException
	 */
	public int getAllProjectsCountWithPaging(Map<String, Object> condition) throws SQLException;
	
	/**
	 * 根据会议编号查询会议安排的全部项目名称
	 * @param meetingId 会议编号
	 * @return 会议安排的全部项目名称
	 * @throws SQLException
	 */
	public List<String> getMeetingProjectNames(String meetingId) throws SQLException;
	
	public boolean isProjectId(Map<String, Object> projectId)
			throws SQLException;
	
	/**
	 * 获得进入登记项目页面时，需要显示的项目信息
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getProjectInAddPage(
			ProjectCondition condition) throws SQLException;
	
	/**
	 * 提供查询用户权限，可以查看到所有项目状态
	 * @param 項目Id,项目名称，领域，项目经费，登记日期
	 * @return map
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllProjectInfo(ProjectQuery project) throws SQLException;
	
	/**
	 * 提供查询用户权限，可以查看到所有项目状态
	 * @param 項目Id,项目名称，领域，项目经费，登记日期
	 * @return 数量
	 * @throws SQLException
	 */
	public int getAllProjectNum(ProjectQuery project) throws SQLException;
	
	public int getMeetingProjectCount(ProjectCondition project) throws SQLException ;
}
