package com.thinkPro.steap.action.meeting;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingCondition;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.sys.user.UserService;

@SuppressWarnings("serial")
@Component
public class MeetingManage extends ActionSupport {
	private Meeting meeting;//会议类
	private MeetingCondition meetingCondition=new MeetingCondition();//会议类
	private List<Meeting> meetingInfoList;//会议信息list
	private boolean status=false;
	private int totalPage;
	private int currentPages;
	private int pageBegin=0;
	private int pageSize=8;
	
	private String meetingId;
	
	@Resource
	private MeetingService meetingService;//会议服务类
	@Resource
	private UserService userService;
	
 	//到达会议管理页面
 	public String toMeetingManagePage() throws SQLException {
		//设置时间和状态值为“全部”
		meetingCondition.setPageBegin(pageBegin);
		meetingCondition.setPageSize(pageSize);
		meetingInfoList=meetingService.getMeetingInfos(meetingCondition);
		
		//默认显示的页码
		
		
        int meetingCount=meetingService.getMeetingCount(meetingCondition);
       // System.out.println("meetingCount"+meetingCount);
        if(meetingCount%meetingCondition.getPageSize()==0){
        	 totalPage=meetingCount/meetingCondition.getPageSize();
        	
        }else{
        	totalPage=meetingCount/meetingCondition.getPageSize()+1;
        }
       
        currentPages=1;
		return SUCCESS;
	}
 	
 	
 	
	
 	//修改会议信息
 	public String updateMeetingInfo(){
 		
 	//	meeting.setHostId("U100005");
 		
 		try {
			meeting.setHostId(userService.getUserIdByName(meeting.getHostId()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
 	  try {
 			status=meetingService.updateMeeting(meeting);
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		
 		return SUCCESS;
 	}
 	
 	
 	//点击修改会议信息按钮
 	 Map<String, Object> map;
 	public String getMeetingInfoById(){
 		try {
 			map=meetingService.getMeetingById(meetingId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
 		return SUCCESS;
 	}
	
 	
 	
 	public String searchMeetingForPage2(){
		
		   
		try {
			
			meetingCondition=new MeetingCondition();
			meetingCondition.setPageSize(pageSize);
			int temp=(currentPages-1)*meetingCondition.getPageSize();
			 if(temp==0){
				 meetingCondition.setPageBegin(0);
			 }else{
				 meetingCondition.setPageBegin(temp);
			 }
			

			meetingInfoList = meetingService.getMeetingInfos(meetingCondition);
			
			int meetingCount = meetingService.getMeetingCount(meetingCondition);
			 // System.out.println("meetingCount"+meetingCount);
	        if(meetingCount%meetingCondition.getPageSize()==0){
	        	 totalPage=meetingCount/meetingCondition.getPageSize();
	        	
	        }else{
	        	totalPage=meetingCount/meetingCondition.getPageSize()+1;
	        }
		       
		     
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
	
	return SUCCESS;
}
 	
 	
	public List<Meeting> getMeetingInfoList() {
		return meetingInfoList;
	}

	public void setMeetingInfoList(List<Meeting> meetingInfoList) {
		this.meetingInfoList = meetingInfoList;
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




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
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




	public String getMeetingId() {
		return meetingId;
	}




	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}




	public Map<String, Object> getMap() {
		return map;
	}




	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	
}
