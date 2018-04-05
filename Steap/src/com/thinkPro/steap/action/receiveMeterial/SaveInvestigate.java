package com.thinkPro.steap.action.receiveMeterial;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.bean.meeting.ProjectInfoResult;
import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.bean.project.ProjectInfoOfPrepared;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.db.service.material.PictureService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class SaveInvestigate extends ActionSupport {
	private ProjectInfoResult projectInfoResult = new ProjectInfoResult();// 项目信息结果集
	private String projectId;// 项目编号
	private List<Specialist> listSpecialist;// 专家组名单
	private List<Picture> pictureList;// 考察照片
	private List<Picture> pictureList2;// 廉洁承诺书照片'
	private ProjectAccept projectAccept;
	private String projectIdT;
	private String result;
	private String specialistId;
	private String deletePictureName;
	private ProjectInfoOfPrepared projectInfoOfPrepared;// 考察信息，审计信息
	
	@Resource
	private ProjectService projectService;
	@Resource
	private PictureService pictureService;
	@Resource
	private SpecialistService specialistService;
	
	public String getDeletePictureName() {
		return deletePictureName;
	}

	public void setDeletePictureName(String deletePictureName) {
		this.deletePictureName = deletePictureName;
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

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getProjectIdT() {
		return projectIdT;
	}

	public void setProjectIdT(String projectIdT) {
		this.projectIdT = projectIdT;
	}

	public ProjectInfoOfPrepared getProjectInfoOfPrepared() {
		return projectInfoOfPrepared;
	}

	public void setProjectInfoOfPrepared(
			ProjectInfoOfPrepared projectInfoOfPrepared) {
		this.projectInfoOfPrepared = projectInfoOfPrepared;
	}

	public ProjectAccept getProjectAccept() {
		return projectAccept;
	}

	public void setProjectAccept(ProjectAccept projectAccept) {
		this.projectAccept = projectAccept;
	}

	
	// 查看项目信息
	public String execute() throws Exception {
		try {
			// 项目信息
			projectAccept = projectService
					.getAcceptInfoByProjectId(projectId);
			projectInfoOfPrepared = projectService
					.getProjectInfoByProjectId(projectId);

			// 专家信息
			listSpecialist = new ArrayList<Specialist>();
			listSpecialist = specialistService
					.getRecommendSpecialistList(projectId);

//			System.out.println(listSpecialist);
//			System.out
//					.println("------------------------------------------------------------------");

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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	
	
	/*删除企业推荐表中的专家*/
	public String deleteSpecialistRe(){
		try {
			if (specialistService.deleteRecommendSpecialistById(specialistId) != 0) {
				result = "删除成功";
				return SUCCESS;
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result = "未删除当前记录";
		return SUCCESS;
	}
	
	/*删除图片*/
	@Test
	public void dfsdf() throws Exception{
		String a = "fileLibrary/originalFile/investigatePicture/109956a5-d40a-4f27-ba2e-b798cd517e19.jpg";
		String c = a.substring(a.lastIndexOf("/") + 1);
		System.out.println(c);

	}
	
	/*删除图片*/
	public String deletePicture(){
		Map<String, Object> deleteInfo = new HashMap<>();
		String realPictureName = deletePictureName.substring(deletePictureName.lastIndexOf("/") + 1);

		deleteInfo.put("projectId", projectId);
		deleteInfo.put("currentName", realPictureName);
		
		try {
			pictureService.deletePictureByPidAndCName(deleteInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
