package com.thinkPro.steap.db.service.verify;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.bean.project.ProjectVerify;

public interface VerifyService {

	/**
	 * 根据项目编号查询完善说明
	 * 
	 * @param projectId
	 *            项目编号
	 * @return completeDescription 完善说明
	 * @throws SQLException
	 * */
	public String getCompleteDescription(String projectId) throws SQLException;

	/**
	 * 根据项目编号查询完善资料
	 * 
	 * @param projectId
	 *            项目编号
	 * @return List<Material>
	 * @throws SQLException
	 * */
	public List<Material> getMaterial(String projectId) throws SQLException;

	/**
	 * 添加完善资料的审核信息(有完善资料的情况下)
	 * 
	 * @param projectVerify
	 *            完善资料信息
	 *            需要的字段：projectId,verifyId,verifyPerson,verifyDate,verifyResult
	 * @return
	 * */
	public boolean updateVerify(ProjectVerify projectVerify)
			throws SQLException;

	/**
	 * 添加完善资料的审核信息(没有完善资料的情况下)
	 * 
	 * @param projectVerify
	 *            完善资料信息 需要的字段：projectId,verifyPerson,verifyDate,verifyResult
	 * @return
	 * */
	public boolean insertVerify(ProjectVerify projectVerify)
			throws SQLException;
	
	/**
	 * 查询指定项目上传的最新完善资料
	 * @param projectId 项目Id
	 * @return  Map中的键分别为originalName,uploadTime,fileSize,fileId
	 *  fileType,currentName,remark
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getLastCompleteMByPid(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号查询最新的审核信息
	 * @param projectId  Map<String,Object>
	 * Map 的键值:verifyId,completeDescription,verifyPerson,verifyDate,verifyResult,remark
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> getLastVerifyInfoByPid(String projectId)throws SQLException;
	
	public List<Map<String, Object>> getVerifyInfoList(String projectId) throws SQLException;

	// 新增表结构后的sql语句-----------------------------------------------------针对审核进行的操作
	// by yachao 2016/9/14 at 01:22
	/**
	 * 录入完善审核关联集合
	 * @param complete_verify(verifyId + materialId) List集合形式
	 * @return
	 * @throws SQLException
	 */
	public int insertCompleteVerify(Map<String, Object> complete_verify) throws SQLException;
	
	/**
	 * 根据材料Id删除完善资料审核记录
	 * @param materialId
	 * @return
	 * @throws SQLException
	 */
	public int deleteCompleteVerifyByMaterialId(String materialId) throws SQLException;
	
	/**
	 * 根据审核Id删除全部完善资料文件审核记录
	 * @param verifyId
	 * @return
	 * @throws SQLException
	 */
	public int deleteCompleteVerifyByVerifyId(String verifyId) throws SQLException;
	
	/**
	 * 根据项目Id获取最新的项目审核材料
	 * @param projectId
	 * @return 最新的项目审核资料集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getLatestVMByProjectId(String projectId) throws SQLException;
	
	/**
	 * 根据项目Id查询出来全部项目审核记录
	 * @param projectId
	 * @return 全部项目审核记录集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllVerifyInfoByProjectId(String projectId) throws SQLException;
	
	/**
	 * 根据项目Id查询出来全部项目审核材料
	 * @param projectId
	 * @return 全部项目审核资料集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllVMByProjectId(String projectId) throws SQLException;
}
