package com.thinkPro.steap.action.meeting;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class DownloadAuditReport extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession seesion=req.getSession();
		
		//相对路径
		String downLoadName=new String(req.getParameter("pdfPath").getBytes("iso-8859-1"),"utf-8");
	
	    ServletContext context=getServletContext();
	    ServletConfig config=getServletConfig();
	    
	    //根路径
	    String downloadPath=context.getRealPath(File.separator)+File.separator;
	    
	    java.io.File file = new java.io.File(downloadPath + downLoadName.trim());  
	    // 获得文件的长度       
	    long filesize = file.length();     
	    // 设置输出格式    
	    resp.addHeader("content-type", "application/x-msdownload;"); 
	    
	    resp.addHeader("Content-Disposition", "attachment; filename="+ resp.encodeURL("auditReport.pdf"));
	    
	
	    resp.addHeader("content-length", Long.toString(filesize)); 
	    
	    java.io.FileInputStream fin = new java.io.FileInputStream(file);
	    byte[] b = new byte[1];  
	    int j = 0;    
	    while ((j = fin.read(b)) > 0) {      
	    	resp.getOutputStream().write(b);    
	    	}      
	    fin.close();
	}
	

}
