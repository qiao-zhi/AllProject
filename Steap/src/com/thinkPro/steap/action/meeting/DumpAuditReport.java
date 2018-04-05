package com.thinkPro.steap.action.meeting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.db.service.material.PictureService;

@SuppressWarnings("serial")
@Component
public class DumpAuditReport extends ActionSupport{
	private String projectId;// 项目编号
	private List<Picture> pictureList;// 审计报告
	
	@Resource
	private PictureService pictureService;
	
	
	@Override
	public String execute() throws Exception {
	
		/*审计报告*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("projectId", projectId);
		map.put("pictureType", "400004");
		pictureList = pictureService.getPicture(map);
		
		/* 设置当前文件的相对路径 */
		if (pictureList.size() != 0) {
			
			for (Picture picture : pictureList) {
				
				picture.setCurrentName(CommonTools.getauditReprtFullPath(picture.getCurrentName()));	
			}
		}
		
		return SUCCESS;
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
}
