package com.thinkPro.steap.action.meeting;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.UUIDUtil;
import com.thinkPro.steap.common.WordToPDF2;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class MaterialManage extends ActionSupport {

	// 根据会议编号得到项目资料信息
	private Meeting meeting;// 会议类
	private List<EnterpriseNotify> enterInfo;// 企业信息
	// List<String> fileClass;// 文件类型
	List<Map<String, Object>> fileClass;

	// 查询项目信息
	private String projectId;// 项目编号
	private ProjectAccept projectAccept;// 项目接收信息
	private List info;// 存放包装好的返回信息
	private List<Material> materialList;// 资料list

	// 删除文件
	private String fileId;// 文件编号
	private boolean status = false;// 状态
	
	@Resource
	private MeetingService meetingService;
	@Resource
	private FileService fileService;
	@Resource
	private ProjectService projectService;
	

	// 到达资料编制界面
	public String toMaterialManagePage() {

		try {
			ActionContext context = ActionContext.getContext();
			Map params = context.getSession();
			String userid = (String) params.get("userId");

			Map map = new HashMap();
			map.put("meetingId", meeting.getMeetingId());
			map.put("chargePerson", userid);
			enterInfo = meetingService.getProjectInEnterpriseNotify(map);
			materialList = fileService.getOriginalMaterialsBy(enterInfo.get(0).getProjectId());
			fileClass = fileService.getMaterialTypeList();

			for (int j = 0; j < materialList.size(); j++) {

				materialList.get(j).setCurrentName(
						CommonTools.getSevenMaterialPdf(materialList.get(j).getCurrentName()).toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;

	}

	// 查询项目信息
	private Map mapInfo;

	public String searchProjectInfo() {

		try {
			mapInfo = new HashMap<>();
			projectAccept = projectService.getAcceptInfoByProjectId(projectId);
			materialList = fileService.getOriginalMaterialsBy(projectId);
			for (int j = 0; j < materialList.size(); j++) {

				materialList.get(j).setCurrentName(
						CommonTools.getSevenMaterialPdf(materialList.get(j).getCurrentName()).toString());

			}
			mapInfo.put("projectAccept", projectAccept);
			mapInfo.put("materialList", materialList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	// 删除文件
	private String path;

	public String deleteFile() {
		try {

			// 删除服务器上的pdf
			String absolutePath = ServletActionContext.getServletContext().getRealPath("/" + path);
			File file = new File(absolutePath);
			if (file.exists()) {
				file.delete();
			}

			// 删除服务器上的文件
			String path2 = path.substring(path.lastIndexOf("/") + 1);

			// fileLibrary/originalFile/sevenMaterial
			String path3 = path2.substring(0, path2.length() - 4) + ".doc";
			String docPath = ServletActionContext.getServletContext()
					.getRealPath("/fileLibrary/originalFile/sevenMaterial/" + path3);
			File file2 = new File(docPath);
			if (file2.exists()) {
				file2.delete();
			}

			status = fileService.deleteFile(fileId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	private String fileType;
	private File materialFile;
	private String materialFileFileName;
	// private String fileName;
	private Material material = new Material();
	private String realPath;
	private Material material2;

	private Material toPageMaterial = new Material();

	public String saveMaterialFile() {
		// tempFileType=fileType;
		try {
			fileClass = fileService.getMaterialTypeList();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < fileClass.size(); i++) {
			if (fileClass.get(i).get("dictionaryOptionName").equals(fileType)) {
				fileType = (String) fileClass.get(i).get("dictionaryOptionId");
			}
		}

     	/* 
     	 * @modifier yachao
     	 * @time 2016/02/01
     	 * 全部上传文件格式修改为pdf
     	 * 
     	 * */
		String uuid = UUIDUtil.getUUID();
//		String currentName = uuid + ".doc";
		String currentName = uuid + ".pdf";

		String path = CommonTools.getSevenMaterial(currentName);
		realPath = ServletActionContext.getServletContext().getRealPath("/" + path);

		File target2 = new File(
				ServletActionContext.getServletContext().getRealPath("/fileLibrary/originalFile/sevenMaterial"));

		// 保存文件到服务器
		try {

			if (!target2.exists()) {
				target2.mkdir();
				File target = new File(realPath);
				FileUtils.copyFile(materialFile, target);
			} else if (target2.exists()) {
				File target = new File(realPath);
				FileUtils.copyFile(materialFile, target);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// 生成pdf
		try {
			// 保存pdf图片到服务器
			String currentName2 = uuid + ".pdf";
			String pdfPath = CommonTools.getSevenMaterialPdf(currentName2);
			String realPath2 = ServletActionContext.getServletContext().getRealPath("/" + pdfPath);

			File target3 = new File(ServletActionContext.getServletContext()
					.getRealPath("/fileLibrary/originalFile/PDFFile/sevenMaterialPdf"));
			if (!target3.exists()) {
				target3.mkdir();
//				new WordToPDF2().wordToPDF(realPath, realPath2.substring(0, realPath2.length() - 4));
				/***************************************************************/
				File backuptarget = new File(realPath2);
				FileUtils.copyFile(materialFile, backuptarget);
				/***************************************************************/
			} else if (target3.exists()) {
//				new WordToPDF2().wordToPDF(realPath, realPath2.substring(0, realPath2.length() - 4));
				File backuptarget = new File(realPath2);
				FileUtils.copyFile(materialFile, backuptarget);
			}

			// 记录word与pdf对应的关系
			material2 = new Material();
			material2.setCurrentName(currentName2);
			material2.setOriginalName(materialFileFileName);
			material2.setProjectId(projectId);
			material2.setFileType(fileType);

			material2.setFileSize(materialFile.length() / 1000 + "KB");
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date2 = format.format(date);
			material2.setUploadTime(Timestamp.valueOf(date2));
			// 保存word与pdf对应的关系到数据库
			status = fileService.addFile(material2);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return SUCCESS;
	}

	public String searchMaterialForAjax() {

		try {
			materialList = fileService.getOriginalMaterialsBy(projectId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int j = 0; j < materialList.size(); j++) {

			materialList.get(j)
					.setCurrentName(CommonTools.getSevenMaterialPdf(materialList.get(j).getCurrentName()).toString());

		}

		return SUCCESS;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public List<EnterpriseNotify> getEnterInfo() {
		return enterInfo;
	}

	public void setEnterInfo(List<EnterpriseNotify> enterInfo) {
		this.enterInfo = enterInfo;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public ProjectAccept getProjectAccept() {
		return projectAccept;
	}

	public void setProjectAccept(ProjectAccept projectAccept) {
		this.projectAccept = projectAccept;
	}

	public List getInfo() {
		return info;
	}

	public void setInfo(List info) {
		this.info = info;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

	public List<Map<String, Object>> getFileClass() {
		return fileClass;
	}

	public void setFileClass(List<Map<String, Object>> fileClass) {
		this.fileClass = fileClass;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public File getMaterialFile() {
		return materialFile;
	}

	public void setMaterialFile(File materialFile) {
		this.materialFile = materialFile;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Material getMaterial2() {
		return material2;
	}

	public void setMaterial2(Material material2) {
		this.material2 = material2;
	}

	public Material getToPageMaterial() {
		return toPageMaterial;
	}

	public void setToPageMaterial(Material toPageMaterial) {
		this.toPageMaterial = toPageMaterial;
	}

	public Map getMapInfo() {
		return mapInfo;
	}

	public void setMapInfo(Map mapInfo) {
		this.mapInfo = mapInfo;
	}

	public String getMaterialFileFileName() {
		return materialFileFileName;
	}

	public void setMaterialFileFileName(String materialFileFileName) {
		this.materialFileFileName = materialFileFileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
