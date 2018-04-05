package com.thinkPro.steap.action.host.revene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Material;
import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.InstitutionNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.PageConstants;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.material.FileService;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;

@SuppressWarnings("serial")
@Component
public class ReveneMeetingAction extends ActionSupport {

	Logger log = Logger.getLogger(ReveneMeetingAction.class);

	private Map<String, Object> condition = new HashMap<String, Object>();
	private Map<String, Object> result;

	private String hostId;
	private int pageBegin;
	private int pageSize;
	private String meetingId;

	@Resource
	private MeetingService meetingService;
	@Resource
	private SpecialistService specialistService;
	@Resource
	private ProjectService projectService;
	@Resource
	private FileService fileService;

	public String reveneMeetingList() throws Exception {
		result = new HashMap<String, Object>();

		try {
			if (condition.size() != 0) {
				condition.put("meetingStatus", "准备中");
				List<Meeting> meetings = meetingService.getAllMeetingsWithPaging(condition);
				int totalPage = meetingService.getAllMeetingsCountWithPaging(condition);

				PageConstants paging = new PageConstants();
				paging.setPageSize(pageSize);
				int pageCount = paging.getPages(totalPage);

				result.put("meetings", meetings);
				result.put("currentPage", pageBegin + 1);
				result.put("pageCount", pageCount);
			}

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

		return SUCCESS;
	}

	public String checkReveneMeetingCount() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if (ValidateCheck.isNotNull(hostId)) {
				condition.put("meetingStatus", "召开中");
				int meetingCount = meetingService.getAllMeetingsCountWithPaging(condition);

				result.put("meetingCount", meetingCount);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			if (ValidateCheck.isNotNull(meetingId)) {
				/* The code is from Guo Fei */
				List<DocumentTip> meetingDoc = new ArrayList<DocumentTip>();
				List<DocumentTip> projectDoc = new ArrayList<DocumentTip>();
				DocumentTip t_doc = null;

				Map<String, Object> meetingBaseInfo = meetingService.getMeetingById(meetingId);
				// 专家组名单
				List<Specialist> specialistList = specialistService.getSpecialistsByMeetingId(meetingId);
				// 机构通知记录
				List<InstitutionNotify> iNotifyList = meetingService.getInstitutionNotify(meetingId);
				// 通知企业记录
				List<EnterpriseNotify> eNotifyList = meetingService.getEnterpriseNotify(meetingId);

				Map<String, Object> meetingInfo = new HashMap<String, Object>();
				meetingInfo.put("meetingId", meetingId);
				meetingInfo.put("acceptance", "验收意见初稿");
				meetingInfo.put("authenticityCommitment", "真实性承诺书");

				// 项目基本信息+验收意见初稿、真实性承诺书的数量
				List<Map<String, Object>> projectMaterialList = projectService.getProjectPreMaterialInfo2(meetingInfo);

				// 分别存储不同项目的材料
				List<ArrayList<Material>> tempList = new ArrayList<ArrayList<Material>>();

				// 获取到项目材料
				for (int i = 0; i < eNotifyList.size(); i++) {
					String t_projectId = eNotifyList.get(i).getProjectId();
					List<Material> materialList = fileService.getOriginalMaterialsBy(t_projectId);

					if (materialList == null || materialList.size() == 0) {
						t_doc = new DocumentTip(t_projectId,
								(String) projectService.getProjectPartByProjectId(t_projectId).get("projectName"),
								"项目的 <七份材料> 均未上传");
						projectDoc.add(t_doc);
					}

					tempList.add((ArrayList<Material>) materialList);
				}

				/**
				 * @modifier Zychaowill
				 * @date 2017/3/16
				 */
				if (specialistList.size() <= 0) {
					t_doc = new DocumentTip(meetingId, meetingBaseInfo.get("meetingName").toString(), "会议评审专家组尚未确定");
					meetingDoc.add(t_doc);
				}

				if (iNotifyList.size() > 0) {
					for (int i = 0; i < iNotifyList.size(); i++) {
						if (iNotifyList.get(i).getNotifyMethod() == null
								|| iNotifyList.get(i).getNotifyDate() == null) {
							t_doc = new DocumentTip(meetingId, meetingBaseInfo.get("meetingName").toString(),
									"尚未通知参加会议的相关人员");
							meetingDoc.add(t_doc);
							break;
						}
					}
				} else {
					t_doc = new DocumentTip(meetingId, meetingBaseInfo.get("meetingName").toString(), "尚未通知参加会议的相关人员");
					meetingDoc.add(t_doc);
				}

				if (eNotifyList.size() > 0) {
					for (int i = 0; i < eNotifyList.size(); i++) {
						if (eNotifyList.get(i).getNotifyMethod() == null
								|| eNotifyList.get(i).getNotifyDate() == null) {
							t_doc = new DocumentTip(eNotifyList.get(i).getProjectId(),
									eNotifyList.get(i).getProjectName(), "尚未通知该项目所属企业");
							projectDoc.add(t_doc);
						}
					}
				}

				if (projectMaterialList != null && projectMaterialList.size() > 0) {
					for (int i = 0; i < projectMaterialList.size(); i++) {
						String t_projectId = (String) projectMaterialList.get(i).get("projectId");
						String t_projectName = (String) projectMaterialList.get(i).get("projectName");

						if (!(Boolean)projectMaterialList.get(i).get("checkOpinion")) {
							t_doc = new DocumentTip(t_projectId, t_projectName, "<验收意见初稿> 尚未上传");
							projectDoc.add(t_doc);
						}
						if (!(Boolean)projectMaterialList.get(i).get("promise")) {
							t_doc = new DocumentTip(t_projectId, t_projectName, "<真实性承诺书> 尚未上传");
							projectDoc.add(t_doc);
						}
					}
				} else {
					t_doc = new DocumentTip("-", "-", "会议中全部项目的 <真实性承诺书> 和 <真实性承诺书> 均未上传");
					projectDoc.add(t_doc);
				}

				if (tempList != null && tempList.size() > 0) {
					for (int i = 0; i < tempList.size(); i++) {
						List<Material> materials = tempList.get(i);
						// 第 i 个项目的材料集合
						List<String> types = null;
						if (materials.size() < 7 && materials.size() > 0) {
							types = FileType.getValues();
							
							for (int j = 0; j < materials.size(); j++) {
								String type = materials.get(j).getFileType();
								
								for (int k = 0; k < types.size(); k++) {
									if (types.get(k).equals(type)) {
										types.remove(k);
									}
								}
							}
							if (types != null && types.size() > 0) {
								String projectId = materials.get(0).getProjectId();
								String projectName = (String) projectService.getProjectPartByProjectId(projectId).get("projectName");
								for (int m = 0; m < types.size(); m++) {
									t_doc = new DocumentTip(projectId, projectName, "<" + types.get(m) + "> 尚未上传");
									projectDoc.add(t_doc);
								}
							}
						}
					}
				}

				result.put("meetingDoc", meetingDoc);
				result.put("projectDoc", projectDoc);

				if (meetingDoc.size() == 0 && projectDoc.size() == 0) {
					condition.put("meetingStatus", "召开中");
					boolean update = meetingService.updateMeetingCurrentStatus(condition);

					result.put("update", update);
				}
			}
		} catch (Exception ex) {
			result.put("update", false);
			log.error(ex.getMessage(), ex);
		}

		return SUCCESS;
	}

	public class DocumentTip {
		private String no;
		private String name;
		private String unfinished;

		public DocumentTip(String no, String name, String unfinished) {
			this.no = no;
			this.name = name;
			this.unfinished = unfinished;
		}

		public String getNo() {
			return no;
		}

		public String getName() {
			return name;
		}

		public String getUnfinished() {
			return unfinished;
		}

		@Override
		public String toString() {
			return "DocumentTip [no=" + no + ", name=" + name + ", unfinished=" + unfinished + "]";
		}
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
		condition.put("hostId", hostId);
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
		condition.put("pageBegin", pageBegin);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		condition.put("pageSize", pageSize);
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
		condition.put("meetingId", meetingId);
	}
}
