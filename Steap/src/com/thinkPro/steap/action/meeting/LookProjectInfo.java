package com.thinkPro.steap.action.meeting;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.bean.meeting.ProjectInfoResult;
import com.thinkPro.steap.bean.project.ProjectInfoOfPrepared;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.db.service.material.PictureService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class LookProjectInfo extends ActionSupport {
	private ProjectInfoResult projectInfoResult = new ProjectInfoResult();// 项目信息结果集
	private String projectId;// 项目编号
	private List<Specialist> listSpecialist;// 专家组名单
	private ProjectInfoOfPrepared projectInfoOfPrepared;// 项目信息
	private List<Picture> pictureList;// 考察照片
	private List<Picture> pictureList2;// 廉洁承诺书照片

	@Resource
	private PictureService pictureService;
	@Resource
	private ProjectService projectService;
	@Resource
	private SpecialistService specialistService;

	// 查看项目信息
	public String lookProjectInfo() {
		try {
			// 项目信息
			projectInfoOfPrepared = projectService.getProjectInfoByProjectId(projectId);

			// 专家信息
			listSpecialist = specialistService.getRecommendSpecialistList(projectId);

			// //考察图片信息
			// Map<String,Object> map=new HashMap<String,Object>();
			// map.put("projectId", projectId);
			// map.put("pictureType", "400001");
			// pictureList=pictureService.getPicture(map);
			//
			// //廉洁承诺书
			// Map<String,Object> map2=new HashMap<String,Object>();
			// map2.put("projectId", projectId);
			// map2.put("pictureType", "400002");
			// pictureList2=pictureService.getPicture(map2);

			// 考察图片信息
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("projectId", projectId);
			map.put("pictureType", "400001");
			pictureList = pictureService.getPicture(map);

			/* 设置当前文件的相对路径 */
			if (pictureList.size() != 0) {
				for (Picture picture : pictureList) {
					picture.setCurrentName(CommonTools.getinvestigatePictureFullPath(picture.getCurrentName()));
				}
			}

			// 廉洁承诺书
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("projectId", projectId);
			map2.put("pictureType", "400002");
			pictureList2 = pictureService.getPicture(map2);

			/* 设置当前文件的相对路径 */
			if (pictureList2.size() != 0) {
				for (Picture picture : pictureList2) {
					picture.setCurrentName(CommonTools.getauditPictureFullPath(picture.getCurrentName()));
				}
			}
			// System.out.println(pictureList);
			// System.out.println(pictureList2);
			// System.out.println("----------------------------------------------------------------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public ProjectInfoResult getProjectInfoResult() {
		return projectInfoResult;
	}

	public void setProjectInfoResult(ProjectInfoResult projectInfoResult) {
		this.projectInfoResult = projectInfoResult;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Specialist> getListSpecialist() {
		return listSpecialist;
	}

	public void setListSpecialist(List<Specialist> listSpecialist) {
		this.listSpecialist = listSpecialist;
	}

	public ProjectInfoOfPrepared getProjectInfoOfPrepared() {
		return projectInfoOfPrepared;
	}

	public void setProjectInfoOfPrepared(ProjectInfoOfPrepared projectInfoOfPrepared) {
		this.projectInfoOfPrepared = projectInfoOfPrepared;
	}

	public List<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}

	public List<Picture> getPictureList2() {
		return pictureList2;
	}

	public void setPictureList2(List<Picture> pictureList2) {
		this.pictureList2 = pictureList2;
	}

}
