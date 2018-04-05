package com.thinkPro.steap.action.meeting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.project.ProjectVerify;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.verify.VerifyService;

@SuppressWarnings("serial")
@Component
public class UpdateVerify extends ActionSupport {

	private String fileIds;
	private String projectId;// 项目编号
	private Map<String, Object> verifyInfo;
	List<Map<String, Object>> materialList;// 资料信息
	private ProjectVerify projectVerify;// 项目审核
	private boolean status;
	private String updateStatus;
	private int fileNum;

	@Resource
	private VerifyService verifyService;// 审核服务类
	@Resource
	private ProjectService projectService;
	@Resource
	private FileService fileService;

	// 查询项目完善资料说明
	public String execute() {
		try {
			// System.out.println(projectId);
			verifyInfo = verifyService.getLastVerifyInfoByPid(projectId);
			
//			List<Map<String, Object>> verifyList = verifyService.getVerifyInfoList(projectId);
//			String completeDescriptionList = "&#13;&#10;" ;
//			if (verifyList.size() > 0) {
//				for (int i = 0; i < verifyList.size(); i++) {
//					if (verifyList.get(i) != null && !verifyList.get(i).equals("")) {
//						int a = i - (-1);
//						if (verifyList.get(i).get("completeDescription") == null || verifyList.get(i).get("completeDescription").equals("")) {
//							completeDescriptionList += a + "、" + "空" + "&#13;&#10;";
//						} else{
//							completeDescriptionList += a + "、" + verifyList.get(i).get("completeDescription") + "&#13;&#10;";
//						}
//					}
//				}
//				verifyInfo.put("completeDescription", completeDescriptionList);
//			} 
			
			materialList = verifyService.getLastCompleteMByPid(projectId);
			if (materialList.size() > 0) {
				for (int i = 0; i < materialList.size(); i++) {
					materialList.get(i).put("currentName",
							CommonTools.getperfectMaterialFullPath(materialList.get(i).get("currentName").toString()));

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// 添加审核资料说明
	public String AddVerify() {
		System.out.println("projectVerify.getVerifyId()" + projectVerify.getVerifyId());
		// fileNum<=0&&

		if (projectVerify.getVerifyId().equals("0")) {

			projectVerify.setProjectId(projectId);
			try {
				status = verifyService.insertVerify(projectVerify);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} else {
			// &&fileNum>0

			projectVerify.setProjectId(projectId);
			try {
				status = verifyService.updateVerify(projectVerify);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (updateStatus.equals("同意")) {
			Map<String, String> projectStatus = new HashMap<String, String>();
			projectStatus.put("projectId", projectId);
			projectStatus.put("status", "100009");
			try {
				projectService.updateProjectStatus(projectStatus);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			String[] fileIdStr = fileIds.split(",");
			if (fileIdStr.length > 0) { 
				Map<String, Object> fileVerify = new HashMap<String, Object>();
				for (int i = 0; i < fileIdStr.length; i++) {
					if (ValidateCheck.isNotNull(fileIdStr[i])) {
						fileVerify.put("fileId", Integer.parseInt(fileIdStr[i]));
						fileVerify.put("remark", 1);
						fileService.updateFileVerifyRemark(fileVerify);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String getFileIds() {
		return fileIds;
	}

	public void setFileIds(String fileIds) {
		this.fileIds = fileIds;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public ProjectVerify getProjectVerify() {
		return projectVerify;
	}

	public void setProjectVerify(ProjectVerify projectVerify) {
		this.projectVerify = projectVerify;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Map<String, Object> getVerifyInfo() {
		return verifyInfo;
	}

	public void setVerifyInfo(Map<String, Object> verifyInfo) {
		this.verifyInfo = verifyInfo;
	}

	public String getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(String updateStatus) {
		this.updateStatus = updateStatus;
	}

	public List<Map<String, Object>> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Map<String, Object>> materialList) {
		this.materialList = materialList;
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

}
