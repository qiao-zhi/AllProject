package com.thinkPro.steap.db.service.impl.verify;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.bean.project.ProjectVerify;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.verify.VerifyMapper;
import com.thinkPro.steap.db.service.verify.VerifyService;

@Service("verifyService")
public class VerifyServiceImpl implements VerifyService{
	
	@Resource
	private VerifyMapper verifyMapper; 
	
	/**
	 * 根据项目编号查询完善说明
	 * 
	 * @param projectId
	 *            项目编号
	 * @return completeDescription 完善说明
	 * @throws SQLException
	 * */
	public String getCompleteDescription(String projectId) throws SQLException {
		boolean validate = ValidateCheck.isNotNull(projectId);
		if (validate) {
			return verifyMapper.getCompleteDescription(projectId);
		} else {
			return null;
		}
	}

	/**
	 * 根据项目编号查询完善资料
	 * 
	 * @param projectId
	 *            项目编号
	 * @return List<Material>
	 * @throws SQLException
	 * */
	public List<Material> getMaterial(String projectId) throws SQLException {
		boolean validate = ValidateCheck.isNotNull(projectId);
		if (validate) {
			return verifyMapper.getMaterial(projectId);
		} else {
			return null;
		}

	}

	/**
	 * 添加完善资料的审核信息(有完善资料的情况下)
	 * 
	 * @param projectVerify
	 *            完善资料信息
	 *            需要的字段：projectId,verifyId,verifyPerson,verifyDate,verifyResult
	 * @return
	 * */
	public boolean updateVerify(ProjectVerify projectVerify)
			throws SQLException {
		boolean result = false;
		if (projectVerify == null) {
			return false;
		} else {
			result = verifyMapper.updateVerify(projectVerify) > 0 ? true : false;
		}
		return result;
	}

	/**
	 * 添加完善资料的审核信息(没有完善资料的情况下)
	 * 
	 * @param projectVerify
	 *            完善资料信息 需要的字段：projectId,verifyPerson,verifyDate,verifyResult
	 * @return
	 * */
	public boolean insertVerify(ProjectVerify projectVerify)
			throws SQLException {
		boolean result = false;
		if (projectVerify == null) {
			return false;
		} else {
			result = verifyMapper.insertVerify(projectVerify) > 0 ? true : false;
		}
		return result;
	}
	
	/**
	 * 查询指定项目上传的最新完善资料
	 * @param projectId 项目Id
	 * @return  Map中的键分别为originalName,uploadTime,fileSize,fileId
	 *  fileType,currentName,remark
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getLastCompleteMByPid(String projectId) throws SQLException{
		String mapNum = verifyMapper.getLastCompleteMnum(projectId);
		int fileNum;
		if(mapNum == null ||mapNum.equals("")){
			fileNum = 0;
		}else{
			fileNum= Integer.parseInt(mapNum) ;
		}
		Map<String,Object> lastInfo = new HashMap<String, Object>();
		lastInfo.put("projectId", projectId);
		lastInfo.put("fileNum", fileNum);
		return verifyMapper.getLastCompleteMByPid(lastInfo);
	}
	
	/**
	 * 根据项目编号查询最新的审核信息
	 * @param projectId  Map<String,Object>
	 * Map 的键值:verifyId,completeDescription,verifyPerson,verifyDate,verifyResult,remark
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> getLastVerifyInfoByPid(String projectId)throws SQLException{
		return verifyMapper.getLastVerifyInfoByPid(projectId);
	}
	
	public List<Map<String, Object>> getVerifyInfoList (String projectId )throws SQLException{
		return verifyMapper.getVerifyInfoList(projectId);
	}

	// 新增表结构后的sql语句-----------------------------------------------------针对审核进行的操作
	// by yachao 2016/9/14 at 01:22
	/**
	 * 录入完善审核关联集合
	 * @param complete_verify(verifyId + materialId) List集合形式
	 * @return
	 * @throws SQLException
	 */
	public int insertCompleteVerify(Map<String, Object> complete_verify) throws SQLException {
		if(complete_verify.size() > 0) {
			return verifyMapper.insertCompleteVerify(complete_verify);
		}
		return 0;
	}
	
	/**
	 * 根据材料Id删除完善资料审核记录
	 * @param materialId
	 * @return
	 * @throws SQLException
	 */
	public int deleteCompleteVerifyByMaterialId(String materialId) throws SQLException {
		if(ValidateCheck.isNotNull(materialId)) {
			return verifyMapper.deleteCompleteVerifyByMaterialId(materialId);
		}
		return 0;
	}
	
	/**
	 * 根据审核Id删除全部完善资料文件审核记录
	 * @param verifyId
	 * @return
	 * @throws SQLException
	 */
	public int deleteCompleteVerifyByVerifyId(String verifyId) throws SQLException {
		if(ValidateCheck.isNotNull(verifyId)) {
			return verifyMapper.deleteCompleteVerifyByVerifyId(verifyId);
		}
		return 0;
	}
	
	/**
	 * 根据项目Id获取最新的项目审核材料
	 * @param projectId
	 * @return 最新的项目审核资料集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getLatestVMByProjectId(String projectId) throws SQLException {
		if(ValidateCheck.isNotNull(projectId)) {
			return verifyMapper.getLatestVMByProjectId(projectId);
		}
		return null;
	}
	
	/**
	 * 根据项目Id查询出来全部项目审核记录
	 * @param projectId
	 * @return 全部项目审核记录集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllVerifyInfoByProjectId(String projectId) throws SQLException {
		if(ValidateCheck.isNotNull(projectId)) {
			return verifyMapper.getAllVerifyInfoByProjectId(projectId);
		}
		return null;
	}
	
	/**
	 * 根据项目Id查询出来全部项目审核材料
	 * @param projectId
	 * @return 全部项目审核资料集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAllVMByProjectId(String projectId) throws SQLException {
		if(ValidateCheck.isNotNull(projectId)) {
			return verifyMapper.getAllVMByProjectId(projectId);
		}
		return null;
	}
}
