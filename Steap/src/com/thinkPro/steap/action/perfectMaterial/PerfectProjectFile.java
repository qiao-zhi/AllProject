package com.thinkPro.steap.action.perfectMaterial;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.UUIDUtil;
import com.thinkPro.steap.db.service.material.FileService;

@SuppressWarnings("serial")
@Component
public class PerfectProjectFile extends ActionSupport {
	private File materialFile;
	private String projectId;
	private String materialFileFileName;
	private String result;
	private String perfectProjectInfo;
	private List<Material> materials;
	private boolean deleteResult = false;
	private String fileId;
	private String verifyFileNum = "0";
	private String fileTypes;
	private String completeIdList;

	@Resource
	private FileService fileService;

	public String getCompleteIdList() {
		return completeIdList;
	}

	public void setCompleteIdList(String completeIdList) {
		this.completeIdList = completeIdList;
	}

	public String getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(String fileTypes) {
		this.fileTypes = fileTypes;
	}

	public String getVerifyFileNum() {
		return verifyFileNum;
	}

	public void setVerifyFileNum(String verifyFileNum) {
		this.verifyFileNum = verifyFileNum;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public boolean isDeleteResult() {
		return deleteResult;
	}

	public void setDeleteResult(boolean deleteResult) {
		this.deleteResult = deleteResult;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public String getPerfectProjectInfo() {
		return perfectProjectInfo;
	}

	public void setPerfectProjectInfo(String perfectProjectInfo) {
		this.perfectProjectInfo = perfectProjectInfo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMaterialFileFileName() {
		return materialFileFileName;
	}

	public void setMaterialFileFileName(String materialFileFileName) {
		this.materialFileFileName = materialFileFileName;
	}

	public File getMaterialFile() {
		return materialFile;
	}

	public void setMaterialFile(File materialFile) {
		this.materialFile = materialFile;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Override
	public String execute() throws Exception {

		Material material = new Material();
		material.setFileSize(materialFile.length() / 1000 + "KB");
		// material.setFileType(fileTypes);
		material.setOriginalName(materialFileFileName);
		material.setProjectId(projectId);

		/* 设置当前的时间 */
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date2 = format.format(date);
		material.setUploadTime(Timestamp.valueOf(date2));

		/* 设置当前文件名 */
		// String suffix =
		// materialFileFileName.substring(materialFileFileName.lastIndexOf(".")
		// + 1);
		// String currentName = UUIDUtil.getUUID() + "." + suffix;
		String currentName = CommonTools.getNewFileName(materialFileFileName);

		material.setCurrentName(currentName);

		String perfectMPath = CommonTools.getPerfectmaterialFullPath();
//				getperfectMaterialFullPath(currentName);
		ServletContext sc = ServletActionContext.getServletContext();
		String realPath = sc.getRealPath("/" + perfectMPath);

		File target = new File(realPath + "/" + currentName);
		Map<String, String> completeInfo = new HashMap<String, String>();
		completeInfo.put("projectId", projectId);
		boolean saveCompleteInfo = false;
		boolean saveFileInfo = false;
		List<Map<String, Object>> fileClass = new ArrayList<>();

		String suffix = currentName.substring(0, currentName.lastIndexOf("."));
		String currentName2 = suffix;
		String pdfPath = CommonTools.getPerfectMaterialPDFPath(currentName2);
		String realpdfPath = sc.getRealPath("/" + pdfPath);

		// 保存文件到服务器
		try {
			FileUtils.copyFile(materialFile, target);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileClass = fileService.getMaterialTypeList();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < fileClass.size(); i++) {
			if (fileClass.get(i).get("dictionaryOptionName").equals(fileTypes)) {
				fileTypes = (String) fileClass.get(i).get("dictionaryOptionId");
				material.setFileType(fileTypes);
			}
		}

		// 保存文件信息到数据库
		try {
			saveFileInfo = fileService.addFileIndex(material);
			completeInfo.put("fileId", material.getFileId());
			// result = material.getFileId();
			result = UUIDUtil.getUUID();
			completeInfo.put("completeId", result);
			saveCompleteInfo = fileService.addCompleteTable(completeInfo);
			result = result + "." + material.getFileId();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String toPdf = currentName.substring(currentName.lastIndexOf('.') + 1);
		String realPdfPath = pdfPath + ".pdf";

		if (saveFileInfo && saveCompleteInfo) {
//			if (toPdf.equals("doc") || toPdf.equals("docx")) {
//				WordToPDF.convert(realPath + "/" + currentName, realpdfPath);
//			}
			FileUtils.copyFile(materialFile, new File(realpdfPath + ".pdf"));
			return SUCCESS;
		}
		return ERROR;
	}

	/* 保存完善资料的说明 */
	public String savePerfectInfo() {
		Map<String, Object> projectExplain = new HashMap<>();
		projectExplain.put("projectId", projectId);
		projectExplain.put("completeDescription", perfectProjectInfo);
		projectExplain.put("verifyFileNum", Integer.valueOf(verifyFileNum));
		// projectExplain.put("verifyPerson", "");
		// projectExplain.put("verifyDate", "2000-1-1");
		// projectExplain.put("verifyResult", "");

		String verifyId = "";
		String[] completeIds = completeIdList.split(",");

		try {
			fileService.addPerfectExplain(projectExplain);

			verifyId = fileService.findNowVerifyId(projectId);

			for (int i = 0; i < completeIds.length; i++) {
				if (!completeIds[i].equals("")) {

					String completeIdNew = completeIds[i].substring(0, completeIds[i].lastIndexOf("."));

					Map<String, Object> completeVerify = new HashMap<>();
					completeVerify.put("verifyId", verifyId);
					completeVerify.put("completeId", completeIdNew);
					fileService.addCompleteVerify(completeVerify);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	/* 通过projectId查询数据库，得到所有，当前项目上传的完善项目资料 */
	public String searchPerfectFile() {
		materials = new ArrayList<Material>();
		Map<String, Object> searchFile = new HashMap<>();
		searchFile.put("projectId", projectId);
		try {
			materials = fileService.getPerfectMaterial(searchFile);
			for (Material m : materials) {
				String currentPdfName = m.getCurrentName().substring(0, m.getCurrentName().lastIndexOf(".")) + ".pdf";
				m.setCurrentName(CommonTools.getPerfectMaterialPDFPath(currentPdfName));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/* 通过fileId来删除当前的 */
	public String deletePerfectFile() {
		boolean deletePerfect = false;
		try {
			deletePerfect = fileService.deletePerfectFile(fileId);
			if(deletePerfect){
				deleteResult = fileService.deleteFile(fileId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (deletePerfect && deleteResult) {
			return SUCCESS;
		}
		return ERROR;
	}
}
