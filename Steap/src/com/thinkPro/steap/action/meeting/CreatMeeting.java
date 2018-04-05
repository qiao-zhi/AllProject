package com.thinkPro.steap.action.meeting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.sys.user.UserService;

@SuppressWarnings("serial")
@Component
public class CreatMeeting extends ActionSupport {
        private Meeting meeting;//会议
        private List projectIdList=new ArrayList();//项目编号list
        private String id;//保存项目编号的字符串
        private boolean status;//状态值
        
        @Resource
        private MeetingService meetingService;//会议服务类
        @Resource
        private UserService userService;
        @Resource
        private ProjectService projectService;
        
        //保存新创建的会议
        public String saveMeeting(){
        	
        	//将前台传过来的id生成list
        	 String[] array= new String[100];
        	 array=id.toString().split(",");    	
        	 for(String a :array){
        		
        		 projectIdList.add(a) ;
        	 
        	 }
        	
        	try {
        		//得到会议主持人名字对应id
           	     meeting.setHostId(userService.getUserIdByName(meeting.getHostId()));
        		status=meetingService.addMeeting(meeting, projectIdList);
        		status=true;
        		if(status){
        			for(int i=0;i<projectIdList.size();i++){
        				Map<String,String> projectStatus;
            			projectStatus = new HashMap<String, String>();
            			projectStatus.put("projectId",projectIdList.get(i).toString());
            			projectStatus.put("status", "100006");
            		    projectService.updateProjectStatus(projectStatus);
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

		

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public List getProjectIdList() {
			return projectIdList;
		}

		public void setProjectIdList(List projectIdList) {
			this.projectIdList = projectIdList;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		

	

		
        
}
