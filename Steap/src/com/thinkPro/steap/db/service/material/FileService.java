package com.thinkPro.steap.db.service.material;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkPro.steap.bean.material.Material;


public interface FileService {
	
	/* -------------------------START BY HaoShaSha -------------------*/
	/**
	 * 添加文件
	 * @param file 文件
	 * @return 是否添加成功
	 * @throws SQLException
	 */
	public boolean addFile(Material file) throws SQLException;
	
	public boolean addFileIndex(Material file) throws SQLException;
	
	/**
	 * 插入项目资料表
	 * @param material
	 * @return
	 */
	public int addProjectMaterial(Map<String,Object> material)throws SQLException;
		
	/**
	 * 根据文件编号删除文件, 级联删除项目材料信息
	 * @param fileId
	 * @return
	 */
	public boolean deleteFile(String fileId) throws SQLException;
	/**
	 * 根据文件类型和项目编号查询项目中文件资料
	 * @param condition(projectId,fileType)
	 * (项目名称，文件类型)
	 * @return
	 */
	public Material getFile(Map<String,Object> condition) throws SQLException;

	/* -------------------------END BY HaoShaSha -------------------*/
	
	/**
	 * 根据项目编号获取项目资料信息
	 * @param projectId 项目编号
	 * @return 当前项目全部资料信息
	 */
	public List<Material> getOriginalMaterialsBy(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号获取项目原始材料树
	 * @param projectId 项目编号
	 * @return 当前项目的原始材料数
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getOriginalMaterialsTree(String projectId) throws SQLException;
	
	/**
	 * 获取文件类型名称集合 :7份文件
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getMaterialTypeList() throws SQLException;
	
	/**
	 * 根据项目编号获取项目全部原始资料
	 * @param projectId 项目编号
	 * @return 材料集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getOriginalMaterialSet(String projectId) throws SQLException;
	
	/**
	 * 根据项目编号和完善文件数获取审核文件
	 * @param project_complete 项目编号、完善文件数
	 * @return 审核文件信息
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getCompleteMaterials(Map<String, Object> project_complete) throws SQLException;
	
	/**
	 * 通过fileId删除complete_material中的信息 
	 **/
	public boolean deletePerfectFile(String fileId) throws SQLException;
	
	/**
	 * 完善项目资料上传
	 * 更改数据库中状态 
	 **/
	public boolean addPerfectExplain(Map<String, Object> projectExplain) throws SQLException;
	
	public String findNowVerifyId(String projectId) throws SQLException;
	
	public boolean addCompleteVerify(Map<String, Object> completeVerify) throws SQLException;

	public List<Material> getPerfectMaterial(Map<String, Object> searchFile) throws SQLException;

	public boolean addCompleteTable(Map<String, String> completeInfo) throws SQLException;
	
	public List<Material> getAllPerfectMaterialsByPId(String projectId) throws SQLException;
	
	public boolean updateFileVerifyRemark(Map<String, Object> fileVerify) throws SQLException;
}
