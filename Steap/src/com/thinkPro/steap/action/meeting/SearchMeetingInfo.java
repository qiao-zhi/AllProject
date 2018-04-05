package com.thinkPro.steap.action.meeting;

/**
 * 查询会议基本信息和查看会议的详细信息
 * */
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingCondition;
import com.thinkPro.steap.bean.project.ProjectInfoOfPrepared;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.material.PictureService;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class SearchMeetingInfo extends ActionSupport {
	private Meeting meeting;// 会议类
	private List<Meeting> meetingInfoList;// 会议信息list
	private MeetingCondition meetingCondition;// 会议条件类

	// 查看会议详细信息
	private List<Specialist> listSpecialist;// 专家list
	private List<Map<String, Object>> listProjectMaterial;// 项目材料信息list
	private ProjectInfoOfPrepared projectInfoOfPrepared;// 全部的项目关联的信息

	// 查看会议信息时的查询项目信息
	private String projectID;// 项目编号
	private Map<String, Object> mapInfo;// project和material的封装
	private List<Material> materialList;// 资料list
	private List<Picture> pictureList;// 文件list 真实性承诺书
	private List<Picture> pictureList2; //企业考察图片
	private List<Picture> pictureList3; //审计，真实性承诺书
	private Material material;

	// 分页
	private int totalPage;
	private int currentPages;
	private int pageBegin = 0;
	private int pageSize = 8;
	
	@Resource
	private MeetingService meetingService;// 会议服务类
	@Resource
	private ProjectService projectService;// 项目服务类
	@Resource
	private SpecialistService specialistService;
	@Resource
	private FileService fileService;
	@Resource
	private PictureService pictureService;
	

	// 查询会议基本信息
	public String searchMeetingInfo() throws SQLException {

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

		meetingInfoList = meetingService.getMeetingInfos(meetingCondition);

		// 设置页码
//		int meetingCount = meetingInfoList.size();
		int meetingCount=meetingService.getMeetingCount(meetingCondition);
		// System.out.println("meetingCount"+meetingCount);
		if (meetingCount % meetingCondition.getPageSize() == 0) {
			totalPage = meetingCount / meetingCondition.getPageSize();

		} else {
			totalPage = meetingCount / meetingCondition.getPageSize() + 1;
		}

		currentPages = 1;

		return SUCCESS;

	}

	// 查看会议详细信息，默认查询的信息
	public String lookMeetingInfo() {

		try {
			listSpecialist = specialistService.getSpecialistsByMeetingId(meeting.getMeetingId());
			Map<String, Object> meetingInfo = new HashMap<String, Object>();
			meetingInfo.put("meetingId", meeting.getMeetingId());
			meetingInfo.put("acceptance", "验收意见初稿");
			meetingInfo.put("authenticityCommitment", "真实性承诺书");

			listProjectMaterial = projectService.getProjectPreMaterialInfo2(meetingInfo);
			String projectId = (String) listProjectMaterial.get(0).get("projectId");
			
			/*查询出项目企业考察的具体信息*/
			projectInfoOfPrepared = projectService.getProjectInfoByProjectId(projectId);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("projectId", projectId);
			map.put("fileType", "验收意见初稿");
			material = fileService.getFile(map);

			/*真实性承诺书*/
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("projectId", projectId);
			map2.put("pictureType", "400003");
			pictureList = pictureService.getPicture(map2);
			if (pictureList.size() > 0) {
				for (int i = 0; i < pictureList.size(); i++) {
					pictureList.get(i)
							.setCurrentName(CommonTools.getPromiseFileFullPath(pictureList.get(i).getCurrentName()));
				}
			}
			
			/*企业现场考察图片*/
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("projectId", projectId);
			map3.put("pictureType", "400001");
			pictureList2 = pictureService.getPicture(map3);

			if (pictureList2.size() > 0) {
				for (int i = 0; i < pictureList2.size(); i++) {
					pictureList2.get(i)
							.setCurrentName(CommonTools.getinvestigatePictureFullPath(pictureList2.get(i).getCurrentName()));
				}
			}
			
			/*审计 廉洁承诺书图片*/
			Map<String, Object> map4 = new HashMap<String, Object>();
			map4.put("projectId", projectId);
			map4.put("pictureType", "400002");
			pictureList3 = pictureService.getPicture(map4);

			if (pictureList3.size() > 0) {
				for (int i = 0; i < pictureList3.size(); i++) {
					pictureList3.get(i)
							.setCurrentName(CommonTools.getauditPictureFullPath(pictureList3.get(i).getCurrentName()));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 查看会议信息时的查询项目信息，点击项目按钮时的操作
	public String lookMeetingProjectInfo() {

		try {
			mapInfo = new HashMap<String, Object>();
			
			/*查询出项目企业考察的具体信息*/
			projectInfoOfPrepared = projectService.getProjectInfoByProjectId(projectID);

			mapInfo.put("project", projectInfoOfPrepared);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("projectId", projectID);
			map.put("fileType", "验收意见初稿");
			material = fileService.getFile(map);
			mapInfo.put("material", material);

			/*真实性承诺书*/
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("projectId", projectID);
			map2.put("pictureType", "400003");
			pictureList = pictureService.getPicture(map2);

			if (pictureList.size() > 0) {
				for (int i = 0; i < pictureList.size(); i++) {
					pictureList.get(i)
							.setCurrentName(CommonTools.getPromiseFileFullPath(pictureList.get(i).getCurrentName()));
				}

				mapInfo.put("picture", pictureList);
			}
			
			/*企业现场考察图片*/
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("projectId", projectID);
			map3.put("pictureType", "400001");
			pictureList2 = pictureService.getPicture(map3);

			if (pictureList2.size() > 0) {
				for (int i = 0; i < pictureList2.size(); i++) {
					pictureList2.get(i)
							.setCurrentName(CommonTools.getinvestigatePictureFullPath(pictureList2.get(i).getCurrentName()));
				}
				mapInfo.put("picture2", pictureList2);
			}
			
			/*审计 廉洁承诺书图片*/
			Map<String, Object> map4 = new HashMap<String, Object>();
			map4.put("projectId", projectID);
			map4.put("pictureType", "400002");
			pictureList3 = pictureService.getPicture(map4);

			if (pictureList3.size() > 0) {
				for (int i = 0; i < pictureList3.size(); i++) {
					pictureList3.get(i)
							.setCurrentName(CommonTools.getauditPictureFullPath(pictureList3.get(i).getCurrentName()));
				}
				mapInfo.put("picture3", pictureList3);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 点击页码时候的查询

	public String searchMeetingForPage() {

		try {

			meetingCondition = new MeetingCondition();
			meetingCondition.setPageSize(pageSize);
			int temp = (currentPages - 1) * meetingCondition.getPageSize();
			if (temp == 0) {
				meetingCondition.setPageBegin(0);
			} else {
				meetingCondition.setPageBegin(temp);
			}

			meetingInfoList = meetingService.getMeetingInfos(meetingCondition);

			int meetingCount = meetingService.getMeetingCount(meetingCondition);
			// System.out.println("meetingCount"+meetingCount);
			if (meetingCount % meetingCondition.getPageSize() == 0) {
				totalPage = meetingCount / meetingCondition.getPageSize();

			} else {
				totalPage = meetingCount / meetingCondition.getPageSize() + 1;
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

	public List<Meeting> getMeetingInfoList() {
		return meetingInfoList;
	}

	public void setMeetingInfoList(List<Meeting> meetingInfoList) {
		this.meetingInfoList = meetingInfoList;
	}

	public List<Specialist> getListSpecialist() {
		return listSpecialist;
	}

	public void setListSpecialist(List<Specialist> listSpecialist) {
		this.listSpecialist = listSpecialist;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public MeetingCondition getMeetingCondition() {
		return meetingCondition;
	}

	public void setMeetingCondition(MeetingCondition meetingCondition) {
		this.meetingCondition = meetingCondition;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public ProjectInfoOfPrepared getProjectInfoOfPrepared() {
		return projectInfoOfPrepared;
	}

	public void setProjectInfoOfPrepared(ProjectInfoOfPrepared projectInfoOfPrepared) {
		this.projectInfoOfPrepared = projectInfoOfPrepared;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

	public Map<String, Object> getMapInfo() {
		return mapInfo;
	}

	public void setMapInfo(Map<String, Object> mapInfo) {
		this.mapInfo = mapInfo;
	}

	public List<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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

	public List<Map<String, Object>> getListProjectMaterial() {
		return listProjectMaterial;
	}

	public void setListProjectMaterial(List<Map<String, Object>> listProjectMaterial) {
		this.listProjectMaterial = listProjectMaterial;
	}

	public List<Picture> getPictureList2() {
		return pictureList2;
	}

	public void setPictureList2(List<Picture> pictureList2) {
		this.pictureList2 = pictureList2;
	}

	public List<Picture> getPictureList3() {
		return pictureList3;
	}

	public void setPictureList3(List<Picture> pictureList3) {
		this.pictureList3 = pictureList3;
	}

}
