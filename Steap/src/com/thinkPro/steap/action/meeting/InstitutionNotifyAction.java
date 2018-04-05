package com.thinkPro.steap.action.meeting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.meeting.InstitutionNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@SuppressWarnings("serial")
@Component
public class InstitutionNotifyAction extends ActionSupport {

	private String meetingId;// 会议编号
	private Meeting meeting;// 会议类
	private List<InstitutionNotify> institutionNotifyList;// 机构通知类
	private List<String> institution;
	
	@Resource
	private MeetingService meetingService;// 会议服务类
	@Resource
	private DictionaryService dictionaryService;

	// 保存通知
	private boolean status = false;// 状态值
	private String info;// 保存通知信息的字符串
	
	// 删除通知
	private String deleteNotifyId; 
	

	// 得到机构通知
	public String institutionNotify() {
		
		try {
     
			meeting.setMeetingId(meetingId);
			institutionNotifyList = meetingService
					.getInstitutionNotify(meetingId);
			
			institution=dictionaryService.getDomain("机构");
			//System.out.println("institutionNotifyList"+institutionNotifyList);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// 保存会议通知
	public String saveNotice2() {

		// 将通知信息分割成数组
		String[] array = info.split(",");

		// 将数组中的信息封装成List<Map>类型
		List<Map<String, Object>> infoList = new ArrayList<Map<String, Object>>();
		institutionNotifyList = new ArrayList<InstitutionNotify>();
		for (int i = 0; i < array.length; i = i + 7) {
			if (array[i].length() > 0) {
				// 根据info里是否有“通知编号”来判断,如果有编号则进行更新，没有则进行插入
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("notifyId", array[i]);
				map.put("meetingId", meetingId);
				map.put("notifyDate", array[4]);
				map.put("notifyMethod", array[5].trim());
				map.put("notifyResult", array[6]);
				infoList.add(map);
//				try {
//
//					status = meetingService.updateInstitutionNotify(infoList);
//                   
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}

			} else {
				// 插入
				institutionNotifyList.clear();
				InstitutionNotify institutionNotify = new InstitutionNotify();
				institutionNotify.setMeetingId(meetingId);
				institutionNotify.setInstitutionName(array[i + 1]);
				institutionNotify.setNotifier(array[i + 2]);
				institutionNotify.setContactPerson(array[i + 3]);
				institutionNotify.setNotifyDate(array[i + 4]);
				institutionNotify.setNotifyMethod(array[i + 5].trim());
				institutionNotify.setNotifyResult(array[i + 6]);
				institutionNotifyList.add(institutionNotify);
				try {
					System.out.println(institutionNotifyList);
					status = meetingService.addInstitutionNotify(institutionNotifyList);
                    
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			
		}
		

		return SUCCESS;
	}
	
	/* 删除一条通知 */
	public String deleteNotify(){
		
		int num = 0;
		
		try {
			num = meetingService.deleteNotifyById(deleteNotifyId.trim());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(num > 0){
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	public String getDeleteNotifyId() {
		return deleteNotifyId;
	}

	public void setDeleteNotifyId(String deleteNotifyId) {
		this.deleteNotifyId = deleteNotifyId;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public List<InstitutionNotify> getInstitutionNotifyList() {
		return institutionNotifyList;
	}

	public void setInstitutionNotifyList(
			List<InstitutionNotify> institutionNotifyList) {
		this.institutionNotifyList = institutionNotifyList;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<String> getInstitution() {
		return institution;
	}

	public void setInstitution(List<String> institution) {
		this.institution = institution;
	}

}
