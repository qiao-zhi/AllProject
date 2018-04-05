package com.thinkPro.steap.db.base.material;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.db.mapper.material.IFileMapper;

public class FileBase {
	
	private ApplicationContext applicationContext;

	private IFileMapper iFileMapper;

	public FileBase() {

		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		iFileMapper = (IFileMapper) applicationContext
				.getBean("IFileMapper");
	}
	
	/**
	 * 插入文件
	 * @return
	 */
	public int addFile(Material file) throws SQLException{
		
		return iFileMapper.addFile(file);
	}
	
	/**
	 * 插入项目资料表
	 * @param material
	 * @return
	 */
	public int addProjectMaterial(Map<String,Object> material) throws SQLException{
		
		return iFileMapper.addProjectMaterial(material);
	}
	
	/**
	 * 根据文件编号删除文件, 级联删除项目材料信息
	 * @param fileId
	 * @return
	 */
	public int deleteFile(String fileId) throws SQLException{
		
		return iFileMapper.deleteFile(fileId);
	}
	/**
	 * 根据文件类型和项目编号查询项目中文件资料
	 * @param condition
	 * @return
	 */
	public Material getFile(Map<String,Object> condition)  throws SQLException{
		
		return iFileMapper.getFile(condition);
	}
	
	/**
	 * 根据项目编号获取项目全部原始资料信息
	 * @param projectId 项目编号
	 * @return 当前项目全部原始资料信息
	 */
	public List<Material> getOriginalMaterialsBy(String projectId) throws SQLException {
		return iFileMapper.getOriginalMaterialsBy(projectId);
	}
	
	/**
	 * 根据项目编号获取项目原始材料树
	 * @param projectId 项目编号
	 * @return 当前项目的原始材料数
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getOriginalMaterialsTree(String projectId) throws SQLException {
		return iFileMapper.getOriginalMaterialsTree(projectId);
	}
	
	public List<Map<String,Object>> getMaterialTypeList() throws SQLException {
		return iFileMapper.getMaterialTypeList();
	}
	
	/**
	 * 根据项目编号获取项目全部原始资料
	 * @param projectId 项目编号
	 * @return 材料集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getOriginalMaterialSet(String projectId) throws SQLException {
		return iFileMapper.getOriginalMaterialSet(projectId);
	}
	
	
	public List<Map<String, Object>> getCompleteMaterials(Map<String, Object> project_complete) throws SQLException {
		return iFileMapper.getCompleteMaterials(project_complete);
	}
	
	/**
	 * 通过fileId删除complete_material中的信息 
	 **/
	public boolean deletePerfectFile(String fileId) throws SQLException{
		return iFileMapper.deletePerfectFile(fileId);
	}
	
	/**
	 * 完善项目资料上传
	 * 更改数据库中状态 
	 **/
	public boolean addPerfectExplain(Map<String, Object> projectExplain) throws SQLException{
		
		return iFileMapper.addPerfectExplain(projectExplain);
	}
	
	public String findNowVerifyId(String projectId) throws SQLException{
	
		return iFileMapper.findNowVerifyId(projectId);
	}
	
	public boolean addCompleteVerify(Map<String, Object> completeVerify) throws SQLException{
		
		return iFileMapper.addCompleteVerify(completeVerify);
	}

	public List<Material> getPerfectMaterial(Map<String, Object> searchFile) throws SQLException {
		
		return iFileMapper.getPerfectMaterial(searchFile);
	}

	public boolean addCompleteTable(Map<String, String> completeInfo) throws SQLException {
		return iFileMapper.addCompleteTable(completeInfo);
	}
	
	public List<Material> getAllPerfectMaterialsByPId(String projectId) throws SQLException {
		return iFileMapper.getAllPerfectMaterialsByPId(projectId);
	}
	
	public boolean updateFileVerifyRemark(Map<String, Object> fileVerify) throws SQLException {
		return iFileMapper.updateFileVerifyRemark(fileVerify);
	}
}
