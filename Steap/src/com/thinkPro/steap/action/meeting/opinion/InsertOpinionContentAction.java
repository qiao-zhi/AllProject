package com.thinkPro.steap.action.meeting.opinion;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.common.UUIDUtil;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@SuppressWarnings("serial")
public class InsertOpinionContentAction extends ActionSupport {
	Logger log = Logger.getLogger(InsertOpinionContentAction.class);

	private String projectId;
	private Material material;
	private Map<String, Object> result;

	@Resource
	private FileService fileService;
	@Resource
	private DictionaryService dictionaryService;

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if (ValidateCheck.isNotNull(projectId)) {
				material.setCurrentName(UUIDUtil.getUUID());
				material.setOriginalName(UUIDUtil.getUUID());
				material.setFileSize("0KB");

				String uploadTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				material.setUploadTime(Timestamp.valueOf(uploadTime));
				material.setFileType(dictionaryService.getCodeByName("验收意见初稿"));
				material.setProjectId(projectId);
				
				boolean success = fileService.addFile(material);

				result.put("success", success);
			}
		} catch (SQLException ex) {
			result.put("success", false);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}

	public String findCheckOpinionContent() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if (ValidateCheck.isNotNull(projectId)) {
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("projectId", projectId);
				condition.put("fileType", "验收意见初稿");

				Material materialInfo = fileService.getFile(condition);
				result.put("success", true);
				result.put("material", materialInfo);
			}
		} catch (SQLException ex) {
			result.put("success", false);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}

	public String deleteCheckOpinionContent() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if (ValidateCheck.isNotNull(projectId)) {
				Map<String, Object> condition = new HashMap<String, Object>();
				condition.put("projectId", projectId);
				condition.put("fileType", "验收意见初稿");
				
				Material materialInfo = fileService.getFile(condition);
				boolean success = fileService.deleteFile(materialInfo.getFileId());
				result.put("success", success);
			}
		} catch(SQLException ex) {
			result.put("success", false);
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
