package com.thinkPro.steap.action.meeting;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.meeting.MeetingTemplate;
import com.thinkPro.steap.common.UUIDUtil;
import com.thinkPro.steap.common.WordToPDF2;
import com.thinkPro.steap.db.service.meeting.TemplateService;

@SuppressWarnings("serial")
@Component
public class MeetingNotify extends ActionSupport {
    
	private Meeting meeting;
	private String htmlContent;
	private boolean status=false;
	private MeetingTemplate meetingTemplate;
	private List<MeetingTemplate> templateList;
	
	@Resource
	private TemplateService templateService;
	
	public String toCreateNotifyPage(){
		try {
			templateList=templateService.getAllTemplate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	//得到会议模板
	private String path;
	public String getTemplate() throws IOException{
		try {
			meetingTemplate=templateService.getTemplateById(meetingTemplate.getTemplateId());
			
			
			ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word
			try {
			app.setProperty("Visible", new Variant(false));
			//设置word不可见
			Dispatch docs = app.getProperty("Documents").toDispatch();
			Dispatch doc = Dispatch.invoke(docs,"Open",Dispatch.Method,new Object[]
			{ meetingTemplate.getTemplateURL(), new Variant(false),new Variant(true) }, new int[1]).toDispatch();
			
			//System.out.println("罗"+meetingTemplate.getTemplateURL());
			// 打开word文件
			path=ServletActionContext.getServletContext().getRealPath("/fileLibrary/originalFile/sevenMaterial/2.html");
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {path,
			new Variant(8) }, new int[1]);
			// 作为html格式保存到临时文件
			Variant f = new Variant(false);
			Dispatch.call(doc, "Close", f);
			} catch (Exception e) {
			e.printStackTrace();
			} finally {
			app.invoke("Quit", new Variant[]{});
			}
			/*ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word
			try {
			app.setProperty("Visible", new Variant(false));
			//设置word不可见
			Dispatch docs = app.getProperty("Documents").toDispatch();
			Dispatch doc = Dispatch.invoke(docs,"Open",Dispatch.Method,new Object[]
			{ "F://tomcat//webapps//Steap//notice//会议通知7e6c8682-3654-4581-b8ad-3c5c3408738d.doc", new Variant(false),new Variant(true) }, new int[1]).toDispatch();
			// 打开word文件
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {"F://2.html",
			new Variant(8) }, new int[1]);
			// 作为html格式保存到临时文件
			Variant f = new Variant(false);
			Dispatch.call(doc, "Close", f);
			} catch (Exception e) {
			e.printStackTrace();
			} finally {
			app.invoke("Quit", new Variant[]{});
			}*/
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
          
		
		
		  File file = new File(path);

	        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
	        try {
	          

	            int tempbyte;
	            htmlContent="";
	            while ((tempbyte = br.read()) != -1) {
	            	htmlContent+=(char)tempbyte;
	              
	            }
	            br.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	           
	        }
	
	//	System.out.println(htmlContent);
		return SUCCESS;
	}
	
	public  String saveMeetingNotice() throws UnsupportedEncodingException{
		
		  boolean w = false;
		 //String realPath = "F:/tomcat/webapps/Steap/notice";
		  String realPath = ServletActionContext.getServletContext().getRealPath("/notice");
		  String fileName = "会议通知"+UUIDUtil.getUUID() + ".doc";
		
		  
		  if(!"".equals(realPath)){
			 File file=new File(realPath);
			 file.mkdirs();
				
			 htmlContent="<html>"+"<head> </head>"+"<body>"+htmlContent+"</body></html>";
			 
			System.out.println(htmlContent);
				   byte b[] = htmlContent.getBytes("GB2312");
				     ByteArrayInputStream bais = new ByteArrayInputStream(b);
				     POIFSFileSystem poifs = new POIFSFileSystem();
				     DirectoryEntry directory = poifs.getRoot();
				     try {
						  DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
						  FileOutputStream ostream = new FileOutputStream(realPath+"/"+fileName+"/");
						
						     poifs.writeFilesystem(ostream);
						     bais.close();
						     ostream.close();
						    
						   
					} catch (IOException e) {
						e.printStackTrace();
					}
				   
			 }
		  try {							   
				new WordToPDF2().wordToPDF(realPath+'/'+fileName,realPath+'/'+fileName.substring(0,fileName.length()-4));
				
				templateList=templateService.getAllTemplate();
				meetingTemplate=new MeetingTemplate();
				meetingTemplate.setTemplateName("模板"+(templateList.size()+1));
				meetingTemplate.setTemplateURL(realPath+'/'+fileName);
				meetingTemplate.setRemark("会议通知");
				status=templateService.addTemplate(meetingTemplate);
			    
		  } catch (Exception e) {
			
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

	public MeetingTemplate getMeetingTemplate() {
		return meetingTemplate;
	}

	public void setMeetingTemplate(MeetingTemplate meetingTemplate) {
		this.meetingTemplate = meetingTemplate;
	}

	public List<MeetingTemplate> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<MeetingTemplate> templateList) {
		this.templateList = templateList;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
}
