package com.thinkPro.steap.db.service.impl.material;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.mapper.material.IFileMapper;
import com.thinkPro.steap.db.service.material.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService {
	
	@Resource
	private IFileMapper fileMapper;
	
	/* -------------------------START BY HaoShaSha -------------------*/
	/**
	 * 添加文件
	 * @param file 文件
	 * @return 是否添加成功
	 * @throws SQLException
	 */
	public boolean addFile(Material file) throws SQLException{
		
		if(file == null){
			
			return false;
			
		}else{
			
			boolean result =  fileMapper.addFile(file) >0 ? true:false;
			 
			 if(result){
				 
				 Map<String,Object> material = new HashMap<String,Object>();
				 
				 //System.out.println("存入的文件的编号是"+file.getFileId());
				 
				 String fileId = file.getFileId();
				 
				 material.put("projectId", file.getProjectId());
				 
				 material.put("fileId", fileId);
				 
				 result = fileMapper.addProjectMaterial(material)>0 ? true:false;
			 }
			 
			 return result;
		}
		 
	}
	
	public boolean addFileIndex(Material file) throws SQLException{

		
		if(file == null){
			
			return false;
			
		}else{
			
			if (fileMapper.addFile(file) > 0) {
				return true;
			};
			
		}
		 
	return false;
	}
		
	/**
	 * 根据文件编号删除文件, 级联删除项目材料信息
	 * @param fileId
	 * @return
	 */
	public boolean deleteFile(String fileId) throws SQLException{
		
		boolean validate = ValidateCheck.isNotNull(fileId);
		
		if(validate){
			
			return fileMapper.deleteFile(fileId) >0 ? true:false;
		
		}else{
			
			return false;
		}
		
	}
	/**
	 * 根据文件类型和项目编号查询项目中文件资料
	 * @param condition(projectId,fileType)
	 * (项目名称，文件类型)
	 * @return
	 */
	public Material getFile(Map<String,Object> condition) throws SQLException{
		
		//有问题  待完善 
		if(condition!=null && condition.size()>0){
			
			return fileMapper.getFile(condition);
			
		}else{
			
			return null;
		}
	}

	/* -------------------------END BY HaoShaSha -------------------*/
	
	/**
	 * 根据项目编号获取项目资料信息
	 * @param projectId 项目编号
	 * @return 当前项目全部资料信息
	 */
	public List<Material> getOriginalMaterialsBy(String projectId) throws SQLException {
		
		if(projectId != null) {
			
			return fileMapper.getOriginalMaterialsBy(projectId);
		}
		return null;
	}
	
	/**
	 * 根据项目编号获取项目原始材料树
	 * @param projectId 项目编号
	 * @return 当前项目的原始材料数
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getOriginalMaterialsTree(String projectId) throws SQLException {
		if(projectId != null && !"".equals(projectId)) {
			return fileMapper.getOriginalMaterialsTree(projectId);
		}
		return null;
	}
	
	/**
	 * 获取文件类型名称集合 :7份文件
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> getMaterialTypeList() throws SQLException {
		return fileMapper.getMaterialTypeList();
	}
	
	/**
	 * 根据项目编号获取项目全部原始资料
	 * @param projectId 项目编号
	 * @return 材料集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getOriginalMaterialSet(String projectId) throws SQLException {
		if(ValidateCheck.isNotNull(projectId)) {
			return fileMapper.getOriginalMaterialSet(projectId);
		}
		return null;
	}
	
	/**
	 * 根据项目编号和完善文件数获取审核文件
	 * @param project_complete 项目编号、完善文件数
	 * @return 审核文件信息
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getCompleteMaterials(Map<String, Object> project_complete) throws SQLException {
		if(project_complete.size() != 0) {
			return fileMapper.getCompleteMaterials(project_complete);
		}
		return null;
	}
	
	/**
	 * 通过fileId删除complete_material中的信息 
	 **/
	public boolean deletePerfectFile(String fileId) throws SQLException{
		if (fileId != null) {
			return fileMapper.deletePerfectFile(fileId);
		}
		return false;
	}
	
	/**
	 * 完善项目资料上传
	 * 更改数据库中状态 
	 **/
	public boolean addPerfectExplain(Map<String, Object> projectExplain) throws SQLException{
		
		return fileMapper.addPerfectExplain(projectExplain);
	}
	
	public String findNowVerifyId(String projectId) throws SQLException{
		
		return fileMapper.findNowVerifyId(projectId);
	}
	
	public boolean addCompleteVerify(Map<String, Object> completeVerify) throws SQLException{
		
		return fileMapper.addCompleteVerify(completeVerify);
	}

	public List<Material> getPerfectMaterial(Map<String, Object> searchFile) throws SQLException {
		
		return fileMapper.getPerfectMaterial(searchFile);
	}

	public boolean addCompleteTable(Map<String, String> completeInfo) throws SQLException {
		return fileMapper.addCompleteTable(completeInfo);
	}

	@Override
	public List<Material> getAllPerfectMaterialsByPId(String projectId) throws SQLException {
		return fileMapper.getAllPerfectMaterialsByPId(projectId);
	}

	@Override
	public boolean updateFileVerifyRemark(Map<String, Object> fileVerify) throws SQLException {
		return fileMapper.updateFileVerifyRemark(fileVerify);
	}

	@Override
	public int addProjectMaterial(Map<String, Object> material) throws SQLException {
		return fileMapper.addProjectMaterial(material);
	}
}
