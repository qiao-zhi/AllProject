package com.thinkPro.steap.action.meeting;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.InstitutionNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingCondition;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.UUIDUtil;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.material.PictureService;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@SuppressWarnings("serial")
@Component
public class MeetingManage2 extends ActionSupport {

	private Meeting meeting;// 会议类
	private MeetingCondition meetingCondition = new MeetingCondition();// 会议类
	private List<Meeting> meetingInfoList;// 会议信息list
	List<EnterpriseNotify> enterpriseNotifyList;// 项目信息（通知日期+通知方式）
	List<Map<String, Object>> projectPreMaterialInfo;
	private Material material; // 验收意见初稿
	private String projectId;

	private List<Picture> pictureList;
	private String meetingId;
	private String notifyDate;
	private String notifyMethod;
	private boolean saveResult = false;

	private int totalPage;
	private int currentPages;
	private int pageBegin = 0;
	private int pageSize = 8;

	@Resource
	private MeetingService meetingService;// 会议服务类
	@Resource
	private DictionaryService dictionaryService;
	@Resource
	private FileService fileService;
	@Resource
	private PictureService pictureService;
	@Resource
	private ProjectService projectService;
	@Resource
	private SpecialistService specialistService;

	// 到达会议管理页面
	public String toMeetingManagePage2() throws SQLException {
		// 设置时间和状态值为“全部”
		meetingCondition.setPageBegin(pageBegin);
		meetingCondition.setPageSize(pageSize);
		meetingInfoList = meetingService.getMeetingInfos(meetingCondition);

		int meetingCount = meetingService.getMeetingCount(meetingCondition);
		// System.out.println("meetingCount"+meetingCount);
		if (meetingCount % meetingCondition.getPageSize() == 0) {
			totalPage = meetingCount / meetingCondition.getPageSize();

		} else {
			totalPage = meetingCount / meetingCondition.getPageSize() + 1;
		}

		currentPages = 1;
		return SUCCESS;
	}

	// 企业通知
	public String enterNotify() {

		try {
			ActionContext context = ActionContext.getContext();
			Map params = context.getSession();
			String userid = (String) params.get("userId");
			Map map = new HashMap();
			map.put("meetingId", meeting.getMeetingId());
			map.put("chargePerson", userid);
			enterpriseNotifyList = meetingService.getProjectInEnterpriseNotify(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 到达企业准备资料上传页面
	public String enterPreMaterial() {
		try {
			Map<String, Object> meetingInfo = new HashMap<String, Object>();
			meetingInfo.put("meetingId", meeting.getMeetingId());
			meetingInfo.put("acceptance", "验收意见初稿");
			meetingInfo.put("authenticityCommitment", "真实性承诺书");

			ActionContext context = ActionContext.getContext();
			Map params = context.getSession();
			String userid = (String) params.get("userId");
			// System.out.println(params+"userid"+userid);
			// Map map=new HashMap();
			// map.put("meetingId", meetingId);
			meetingInfo.put("chargePerson", userid);
			projectPreMaterialInfo = projectService.getProjectPreMaterialInfo2(meetingInfo);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 保存意见初稿
	private String fileType;
	private File materialFile;
	// private String fileName;
	private String materialFileFileName;

	public String saveOpinionFile() {

		material = new Material();
		try {
			String str = dictionaryService.getCodeByName(fileType);
			material.setFileType(str);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		material.setProjectId(projectId);
		material.setOriginalName(materialFileFileName);
		material.setFileSize(materialFile.length() / 1000 + "KB");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date2 = format.format(date);
		material.setUploadTime(Timestamp.valueOf(date2));

		String uuid = UUIDUtil.getUUID();
		// String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		String currentName = uuid + ".doc";

		String currentName2 = uuid + ".doc";
		material.setCurrentName(currentName2);
		// String realPath =
		// ServletActionContext.getServletContext().getRealPath("/opinion");
		String docPath = ServletActionContext.getServletContext()
				.getRealPath("/" + CommonTools.getSevenMaterial(currentName));
		File target = new File(docPath);

		// 保存文件到服务器
		try {
			File target2 = new File(
					ServletActionContext.getServletContext().getRealPath("/fileLibrary/originalFile/sevenMaterial"));
			if (!target2.exists()) {
				target2.mkdir();
				FileUtils.copyFile(materialFile, target);
			} else if (target2.exists()) {
				FileUtils.copyFile(materialFile, target);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		String pdfPath = CommonTools.getSevenMaterialPdf(currentName2);
		String pdfRealPath = ServletActionContext.getServletContext().getRealPath("/" + pdfPath);
		File file = new File(ServletActionContext.getServletContext()
				.getRealPath("/fileLibrary/originalFile/PDFFile/sevenMaterialPdf"));
		File file2 = new File(ServletActionContext.getServletContext()
				.getRealPath("/fileLibrary/originalFile/PDFFile/sevenMaterialPdf") + "/" + currentName2); 

		try {

			if (!file.exists()) {
				file.mkdir();
				FileUtils.copyFile(materialFile, file2);
//				WordToPDF.convert(docPath, pdfRealPath.substring(0, pdfRealPath.length() - 4));
			} else if (file.exists()) {
				FileUtils.copyFile(materialFile, file2);
//				WordToPDF.convert(docPath, pdfRealPath.substring(0, pdfRealPath.length() - 4));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 保存文件信息到数据库
		try {
			saveResult = fileService.addFile(material);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;

	}

	// 保存真实性承诺书
	private File materialFile2;
	private String materialFile2FileName;

	public String saveCommitment() {
		Picture picture = new Picture();
		picture.setPictureType(fileType);
		picture.setProjectId(projectId);
		picture.setOriginalName(materialFile2FileName);
		picture.setPictureSize(materialFile2.length() / 1000 + "KB");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date2 = format.format(date);
		picture.setUploadTime(Timestamp.valueOf(date2));

		String suffix = materialFile2FileName.substring(materialFile2FileName.lastIndexOf(".") + 1);
		String currentName = UUIDUtil.getUUID() + "." + suffix;
		picture.setCurrentName(currentName);

		// String realPath =
		// ServletActionContext.getServletContext().getRealPath("/commitment");
		// String path=CommonTools.getOriginalWordFileFullPath(currentName);
		String realPath = ServletActionContext.getServletContext().getRealPath("/fileLibrary/originalFile/promiseFile");
		File target = new File(realPath + "/" + currentName);

		// 保存文件到服务器
		try {
			File target2 = new File(realPath);
			if (!target2.exists()) {

				target2.mkdir();
				FileUtils.copyFile(materialFile2, target);
			} else if (target2.exists()) {
				FileUtils.copyFile(materialFile2, target);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// 保存文件信息到数据库
		try {
			saveResult = pictureService.addPicture(picture);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	/* 通过项目Id得到验收意见初稿 */
	public String getMaterialInfo() {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("projectId", projectId);

		String str;
		// try {
		// str = new DictionaryService().getCodeByName("验收意见初稿");
		condition.put("fileType", "验收意见初稿");
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }

		try {
			material = fileService.getFile(condition);
			if (material != null) {
				material.setCurrentName(CommonTools.getSevenMaterialPdf(material.getCurrentName()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 删除意见初稿
	private String fileId;
	private boolean delateStatus = false;
	private String path;

	public String delateMaterial() {

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

			// 删除数据库上的信息
			delateStatus = fileService.deleteFile(fileId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/* 通过项目Id得到真是性承诺书 */
	private List<Map<String, Object>> pictureListMap;

	public String getPictures() {

		Map<String, Object> pictureInfo = new HashMap<>();
		pictureInfo.put("projectId", projectId);
		pictureInfo.put("pictureType", "真实性承诺书");

		try {
			pictureListMap = pictureService.getPictureSet(pictureInfo);
			for (int i = 0; i < pictureListMap.size(); i++) {
				String path = CommonTools.getPromiseFileFullPath((String) pictureListMap.get(i).get("currentName"));
				pictureListMap.get(i).put("currentName", path);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	private String currentName;
	private String projectId2;
	private String status;

	public String deletePictures() {

		// 删除服务器上的图片

		String docPath = ServletActionContext.getServletContext().getRealPath("/" + currentName);
		File file2 = new File(docPath);
		if (file2.exists()) {
			file2.delete();
		}

		// 删除数据库中的信息
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("projectId", projectId2);
		String array[] = currentName.split("/");

		// System.out.println("疏忽"+array[3]);
		map.put("currentName", array[3]);
		// System.out.println(projectId2+array[3]);
		try {

			status = pictureService.deletePictureByPidAndCName(map) + "";
			System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	@SuppressWarnings("static-access")
	public String searchMeetingInfo2() {
		// 如果条件属性是“全部”，则将其设置为null
		if ("全部".equals(meetingCondition.getMeetingStatus())) {
			meetingCondition.setMeetingStatus(null);

		}

		if ("全部".equals(meetingCondition.getMeetingTime().trim())) {
			meetingCondition.setMeetingTime(null);

		} else {

			// 将页面上的时间条件（近一个月,近三个月等）转换为对应的时间
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int a = Integer.parseInt(meetingCondition.getMeetingTime());
			calendar.add(calendar.DATE, -a);
			Date date = calendar.getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newDate = df.format(date);

			meetingCondition.setMeetingTime(newDate);

		}

		// 设置初始现实的记录数
		meetingCondition.setPageBegin(pageBegin);
		meetingCondition.setPageSize(pageSize);

		try {
			meetingInfoList = meetingService.getMeetingInfos(meetingCondition);

			int meetingCount = meetingService.getMeetingCount(meetingCondition);
			System.out.println("meetingCount" + meetingCount);
			if (meetingCount % meetingCondition.getPageSize() == 0) {
				totalPage = meetingCount / meetingCondition.getPageSize();

			} else {
				totalPage = meetingCount / meetingCondition.getPageSize() + 1;
			}

			currentPages = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	/* 通过ajax保存通知方式 */
	public String saveNotice() {
		List<Map<String, Object>> enterpriseNotify = new ArrayList<>();
		Map<String, Object> proje = new HashMap<>();
		proje.put("meetingId", meetingId);
		proje.put("projectId", projectId);
		proje.put("notifyDate", notifyDate);
		proje.put("notifyMethod", notifyMethod);
		enterpriseNotify.add(proje);

		try {
			saveResult = meetingService.updateProjectMeeting(enterpriseNotify);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 召开会议
	List<String> listMap;

	public String conveneMeeting() {
		try {
			listMap = new ArrayList<>();
			List<Specialist> list = specialistService.getSpecialistsByMeetingId(meetingId);
			List<InstitutionNotify> list2 = meetingService.getInstitutionNotify(meetingId);

			ActionContext context = ActionContext.getContext();
			Map params = context.getSession();
			String userid = (String) params.get("userId");

			Map map2 = new HashMap();
			map2.put("meetingId", meetingId);
			map2.put("chargePerson", userid);
			List<EnterpriseNotify> list3 = meetingService.getProjectInEnterpriseNotify(map2);

			Map<String, Object> meetingInfo = new HashMap<String, Object>();
			meetingInfo.put("meetingId", meetingId);
			meetingInfo.put("acceptance", "验收意见初稿");
			meetingInfo.put("authenticityCommitment", "真实性承诺书");

			List<Map<String, Object>> list4 = projectService.getProjectPreMaterialInfo2(meetingInfo);
			List<ArrayList<Material>> tempList = new ArrayList<ArrayList<Material>>();
			for (int i = 0; i < list3.size(); i++) {
				List<Material> materialList = fileService.getOriginalMaterialsBy(list3.get(i).getProjectId());
				tempList.add((ArrayList<Material>) materialList);
			}

			if (list.size() > 0) {

			} else {

				listMap.add("专家还没有确定,请先确定完会议专家;");
			}

			for (int i = 0; i < list2.size(); i++) {
				Map<String, String> map = new HashMap<>();
				if (!(list2.get(i).getNotifyMethod() == null) && !(list2.get(i).getNotifyDate() == null)) {

				} else {

					listMap.add("通知相关人员还没有完成，请先完成此工作;");
					break;
				}
			}

			for (int i = 0; i < list3.size(); i++) {
				Map<String, String> map = new HashMap<>();
				if (!(list3.get(i).getNotifyMethod() == null) && !(list3.get(i).getNotifyDate() == null)) {

				} else {

					listMap.add("通知企业还没有完成，请先完成此工作;");
					break;
				}
			}

			for (int i = 0; i < list4.size(); i++) {
				Map<String, String> map = new HashMap<>();
				if (list4.get(i).get("checkOpinion") != null && list4.get(i).get("promise") != null) {

				} else {

					listMap.add("验收意见初稿和真实性承诺书还没有上传完整，请先完成;");
					break;
				}

			}

			for (int i = 0; i < tempList.size(); i++) {
				if (tempList.get(i).size() != 7) {

					listMap.add("项目" + (i + 1) + "7种资料还未齐全，请先完善");
				}
			}

			// 修改会议状态
			if (listMap.size() > 0) {

			} else {
				Map<String, Object> meetingStatus = new HashMap<>();
				meetingStatus.put("meetingId", meetingId);
				meetingStatus.put("meetingStatus", "200002");
				boolean status = meetingService.updateMeetingStatus(meetingStatus);
				if (status) {
					listMap.add("会议状态修改完成");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public MeetingCondition getMeetingCondition() {
		return meetingCondition;
	}

	public void setMeetingCondition(MeetingCondition meetingCondition) {
		this.meetingCondition = meetingCondition;
	}

	public List<Meeting> getMeetingInfoList() {
		return meetingInfoList;
	}

	public void setMeetingInfoList(List<Meeting> meetingInfoList) {
		this.meetingInfoList = meetingInfoList;
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public List<EnterpriseNotify> getEnterpriseNotifyList() {
		return enterpriseNotifyList;
	}

	public void setEnterpriseNotifyList(List<EnterpriseNotify> enterpriseNotifyList) {
		this.enterpriseNotifyList = enterpriseNotifyList;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getNotifyDate() {
		return notifyDate;
	}

	public void setNotifyDate(String notifyDate) {
		this.notifyDate = notifyDate;
	}

	public String getNotifyMethod() {
		return notifyMethod;
	}

	public void setNotifyMethod(String notifyMethod) {
		this.notifyMethod = notifyMethod;
	}

	public boolean isSaveResult() {
		return saveResult;
	}

	public void setSaveResult(boolean saveResult) {
		this.saveResult = saveResult;
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

	public File getMaterialFile2() {
		return materialFile2;
	}

	public void setMaterialFile2(File materialFile2) {
		this.materialFile2 = materialFile2;
	}

	public List<Map<String, Object>> getPictureListMap() {
		return pictureListMap;
	}

	public void setPictureListMap(List<Map<String, Object>> pictureListMap) {
		this.pictureListMap = pictureListMap;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPages() {
		return currentPages;
	}

	public void setCurrentPages(int currentPages) {
		this.currentPages = currentPages;
	}

	public List<Map<String, Object>> getProjectPreMaterialInfo() {
		return projectPreMaterialInfo;
	}

	public void setProjectPreMaterialInfo(List<Map<String, Object>> projectPreMaterialInfo) {
		this.projectPreMaterialInfo = projectPreMaterialInfo;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public boolean isDelateStatus() {
		return delateStatus;
	}

	public void setDelateStatus(boolean delateStatus) {
		this.delateStatus = delateStatus;
	}

	public List<String> getListMap() {
		return listMap;
	}

	public void setListMap(List<String> listMap) {
		this.listMap = listMap;
	}

	public String getMaterialFileFileName() {
		return materialFileFileName;
	}

	public void setMaterialFileFileName(String materialFileFileName) {
		this.materialFileFileName = materialFileFileName;
	}

	public String getMaterialFile2FileName() {
		return materialFile2FileName;
	}

	public void setMaterialFile2FileName(String materialFile2FileName) {
		this.materialFile2FileName = materialFile2FileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCurrentName() {
		return currentName;
	}

	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}

	public String getProjectId2() {
		return projectId2;
	}

	public void setProjectId2(String projectId2) {
		this.projectId2 = projectId2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
