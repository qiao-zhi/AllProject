package com.thinkPro.steap.action.receiveMeterial;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.bean.project.AuditInfo;
import com.thinkPro.steap.bean.project.EnterpriseInspect;
import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.db.service.material.PictureService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
/* 企业现场考察 */
@Component
public class EnterpriseInvestigate extends ActionSupport implements SessionAware{
	private File file;
	private String name;
	private String size;
	private Picture picture;
	private String uid;
	private EnterpriseInspect enterpriseInspect;
	private AuditInfo auditInfo;
	private List<Specialist> specialists;
	private String projectIdT;
	private String projectIdS;
	private String sourceT;
	private float projectFundsT;
	private ProjectAccept projectAccept;
	private String isSubmit;
	private Map<String, Object> session;
	@Resource
	private PictureService pictureService;
	@Resource
	private ProjectService projectService;
	@Resource
	private SpecialistService specialistService;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}

	public String getProjectIdS() {
		return projectIdS;
	}

	public void setProjectIdS(String projectIdS) {
		this.projectIdS = projectIdS;
	}

	public ProjectAccept getProjectAccept() {
		return projectAccept;
	}

	public void setProjectAccept(ProjectAccept projectAccept) {
		this.projectAccept = projectAccept;
	}

	public float getProjectFundsT() {
		return projectFundsT;
	}

	public void setProjectFundsT(float projectFundsT) {
		this.projectFundsT = projectFundsT;
	}

	public String getProjectIdT() {
		return projectIdT;
	}

	public void setProjectIdT(String projectIdT) {
		this.projectIdT = projectIdT;
	}

	public String getSourceT() {
		return sourceT;
	}

	public void setSourceT(String sourceT) {
		this.sourceT = sourceT;
	}

	public EnterpriseInspect getEnterpriseInspect() {
		return enterpriseInspect;
	}

	public void setEnterpriseInspect(EnterpriseInspect enterpriseInspect) {
		this.enterpriseInspect = enterpriseInspect;
	}

	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}

	public List<Specialist> getSpecialists() {
		return specialists;
	}

	public void setSpecialists(List<Specialist> specialists) {
		this.specialists = specialists;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	/* 保存企业考察信息 */
	public String saveEnterpriseInfo() {
		
//		ProjectService projectService = new ProjectService();
//		SpecialistService specialistService = new SpecialistService();
		session.put("error", "");
		String inspectId = "";
		try {
			inspectId = projectService.getInspectIdByProjectId(projectIdT);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		/* 判断数据库中是否已经保存过 */
		if (inspectId == null) {
		
		boolean saveEnterprise = false;
		boolean saveSpecialists = false;
		boolean saveAudit = false;
		
		/* 设置企业考察的项目Id */
		enterpriseInspect.setProjectId(projectIdT);

		if (projectFundsT >= 50) {
			enterpriseInspect.setAudit(true);
		} else {
			enterpriseInspect.setAudit(false);
		}
		enterpriseInspect.setInspectStatus("已提交");

		try {
			/* 保存考察信息 */
			saveEnterprise = projectService
					.addEnterpriseInspect(enterpriseInspect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/* 设置审计Id */
		if (enterpriseInspect.isAudit()) {
			if (saveEnterprise) {
				inspectId = enterpriseInspect.getInspectId();
				auditInfo.setInspectId(inspectId);
			} else {
				session.put("error", "保存考察信息失败，请重试");
				return ERROR;
			}
		} 

		/* 设置专家来源 */
		if (specialists != null) {
			for (Specialist specialist : specialists) {
				specialist.setSource(sourceT);
			}
			try {
				/* 保存专家信息 */
				saveSpecialists = specialistService
						.insertRecommendSpecialistList(specialists);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (!saveSpecialists) {
				session.put("error", "保存专家信息失败，请重试");
				return ERROR;
			}
		}

		/* 判断是否需要审计 */
		if (projectFundsT >= 50) {
			try {
				/* 保存审计信息 */
				saveAudit = projectService.addAuditInfo(auditInfo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!saveAudit && enterpriseInspect.isAudit()) {
			session.put("error", "保存审计信息失败，请重试");
			return ERROR;
		}
		
	} 
		/* 这个是已经保存过的，有记录了 */
		else {
		
			boolean saveEnterprise = false;
			boolean saveSpecialists = false;
			boolean saveAudit = false;
			
			/* 设置企业考察的项目Id */
			enterpriseInspect.setProjectId(projectIdT);
			enterpriseInspect.setInspectId(inspectId);
			
			if (projectFundsT >= 50) {
				enterpriseInspect.setAudit(true);
			} else {
				enterpriseInspect.setAudit(false);
			}

			try {
				/* 更新考察信息 */
				saveEnterprise = projectService.updateEnterPriseInspect(enterpriseInspect);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/* 设置审计Id */
			if (enterpriseInspect.isAudit()) {
				if (saveEnterprise) {
					auditInfo.setInspectId(inspectId);
				} else {
					session.put("error", "保存考察信息失败，请重试");
					return ERROR;
				}
			} 

			/* 设置专家来源 */
			if (specialists != null) {
				for (Specialist specialist : specialists) {
					specialist.setSource(sourceT);
				}
				try {
					/* 保存专家信息 */
					saveSpecialists = specialistService
							.insertRecommendSpecialistList(specialists);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (!saveSpecialists) {
					session.put("error", "保存专家信息失败，请重试");
					return ERROR;
				}
			}

			/* 判断是否需要审计 */
			if (projectFundsT >= 50) {
				try {
					/* 更新审计信息 */
					saveAudit = projectService.updateInspectInfo(auditInfo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (!saveAudit && enterpriseInspect.isAudit()) {
				session.put("error", "保存审计信息失败，请重试");
				return ERROR;
			}
			
		
	}
		
		/* 判断是保存还是提交，在数据库中保存不同的状态 */
		if (isSubmit.equals("submit")) {
			Map<String, String> projectStatus = new HashMap<String, String>();
			projectStatus.put("projectId", projectIdT);
			projectStatus.put("status", "100005");
			try {
				projectService.updateProjectStatus(projectStatus);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (isSubmit.equals("save")) {
			Map<String, String> projectStatus = new HashMap<String, String>();
			projectStatus.put("projectId", projectIdT);
			projectStatus.put("status", "100004");
			try {
				projectService.updateProjectStatus(projectStatus);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			session.put("error", "保存失败，请重试");
			return ERROR;
		}
		
		return ERROR;
	}

	/* 保存企业考察图片 */
	public String saveInvestigatePicture() {

//		pictureService = new PictureService();
		picture = new Picture();

		/* 对picture进行赋值 */
		picture.setProjectId(uid);
		picture.setOriginalName(name);
//		String suffix = name.substring(name.lastIndexOf(".") + 1);
//		String currentName = UUIDUtil.getUUID() + "." + suffix;
		String currentName = CommonTools.getNewFileName(name);
		
		picture.setCurrentName(currentName);
		picture.setPictureType("考察照片");
		picture.setPictureSize(size);
		picture.setUploadTime(new Timestamp(System.currentTimeMillis()));

		/* 得到保存企业考察信息的图片 */
//		ReadProperties rp = new ReadProperties();
//		String InvestigatePath = rp.getInvestigatePath();
		String InvestigatePath = CommonTools.getInvestigatePictureFullPath();
//				getinvestigatePictureFullPath(currentName);
		
		ServletContext sc = ServletActionContext.getServletContext();
		String realPath = sc.getRealPath("/" + InvestigatePath);
		
		File target = new File(realPath + "/" + currentName);
//		if(!target.exists()) {
//			target.mkdirs();
//		}
		boolean savePicture = false;

		try {
			/* 将图片保存到服务器上 */
			FileUtils.copyFile(file, target);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		try {
			/* 将图片信息保存到数据库中 */
			savePicture = pictureService.addPicture(picture);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (savePicture) {
			return SUCCESS;
		}

		return ERROR;
	}

	/* 保存审计图片 */
	public String saveAuditPicture() {

//		pictureService = new PictureService();
		picture = new Picture();

		/* 对picture进行赋值 */
		picture.setProjectId(uid);
		picture.setOriginalName(name);
//		String suffix = name.substring(name.lastIndexOf(".") + 1);
//		String currentName = UUIDUtil.getUUID() + "." + suffix;
		String currentName = CommonTools.getNewFileName(name);
		
		picture.setCurrentName(currentName);
		picture.setPictureType("廉洁承诺书");
		picture.setPictureSize(size);
		picture.setUploadTime(new Timestamp(System.currentTimeMillis()));

		/* 得到保存审计信息的图片 */
//		ReadProperties rp = new ReadProperties();
//		String AuditPath = rp.getAuditPath();
		String AuditPath = CommonTools.getAuditPictureFullPath();
		
		ServletContext sc = ServletActionContext.getServletContext();
		String realPath = sc.getRealPath("/" + AuditPath);
		
		File target = new File(realPath + "/" + currentName);
//		if(!target.exists()) {
//			target.mkdirs();
//		}
		boolean savePicture = false;

		try {
			/* 将图片保存到服务器上 */
			FileUtils.copyFile(file, target);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		try {
			/* 将图片信息保存到数据库中 */
			savePicture = pictureService.addPicture(picture);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (savePicture) {
			return SUCCESS;
		}

		return ERROR;
	}

	/* 跳转到录入企业现场考察信息的页面 */
	public String goToEntering() {
//		ProjectService projectService = new ProjectService();

		try {
			this.projectAccept = projectService
					.getAcceptInfoByProjectId(projectIdS);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	/* 查询出当前项目以录入的信息并继续录入 */
	public String searchSavedInfo(){
		
		return SUCCESS;
	}

}
