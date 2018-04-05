package com.thinkPro.steap.action.meeting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.springframework.stereotype.Component;

import com.lowagie2.text.BadElementException;
import com.lowagie2.text.Document;
import com.lowagie2.text.Image;
import com.lowagie2.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.material.Picture;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.db.service.material.PictureService;

@SuppressWarnings("serial")
@Component
public class AuditReport extends ActionSupport{
	private File file;
	private String name;
	private String size;
	private Picture picture;
	private String uid;
	@Resource
	private PictureService pictureService;
	
	
	@Override
	public String execute(){


		picture = new Picture();

		/* 对picture进行赋值 */
		picture.setProjectId(uid);
		picture.setOriginalName(name);
		String currentName = CommonTools.getNewFileName(name);
		
		picture.setCurrentName(currentName);
		
		picture.setPictureSize(size);
		picture.setUploadTime(new Timestamp(System.currentTimeMillis()));
		
		picture.setPictureType("审计报告");

		/* 得到保存审计信息的图片 */
		String AuditPath = CommonTools.getauditReprtFullPath(currentName);
		
		ServletContext sc = ServletActionContext.getServletContext();
		String realPath = sc.getRealPath(AuditPath);
		
		File target = new File(realPath);
		boolean savePicture = false;

		try {
			/* 将图片保存到服务器上 */
			FileUtils.copyFile(file, target);
			
			
			  
		} catch (IOException e) {
			e.printStackTrace();
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

	private boolean status;
	private List<Picture> pictureList;// 审计报告
	private String projectId;
	private String realPdfPath;
	private String pdfPath;
	public String pictureToPdf(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("projectId", projectId);
		map.put("pictureType", "400004");
		try {
			pictureList = pictureService.getPicture(map);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        if (pictureList.size() != 0) {
			
			for (Picture picture : pictureList) {
				
				picture.setCurrentName(CommonTools.getauditReprtFullPath(picture.getCurrentName()));	
			}
		}
		
		
		    Document doc = new Document();
		    try {   
		        //定义输出文件的位置   
		        try {
		        	pdfPath=CommonTools.getAuditReportWordAndPdf(projectId+".pdf");
		        	realPdfPath=ServletActionContext.getServletContext().getRealPath(pdfPath);
					PdfWriter.getInstance(doc, new FileOutputStream(realPdfPath));
				} catch (com.lowagie2.text.DocumentException e) {
					e.printStackTrace();
				}
		        //开启文档   
		        doc.open();   
		       
		        //向文档中加入图片  
		        for(int i=0;i<pictureList.size();i++)
		        {
		        	//取得图片~~~图片格式：
		        	Image jpg1;
					try {
						jpg1 = Image.getInstance(ServletActionContext.getServletContext().getRealPath(pictureList.get(i).getCurrentName()));
						float heigth=jpg1.height();
			        	float width=jpg1.width();
			        	//统一按照宽度压缩
			        	int percent=getPercent(heigth, width);
			        	//设置图片居中显示
			        	jpg1.setAlignment(Image.MIDDLE);
			        	//直接设置图片的大小~~~~~~~第三种解决方案，按固定比例压缩
			        	//jpg1.scaleAbsolute(210.0f, 297.0f);
			        	//按百分比显示图片的比例
			        	jpg1.scalePercent(percent);//表示是原来图像的比例;
			        	//可设置图像高和宽的比例
			        	//jpg1.scalePercent(50, 100);
			            try {
						  doc.add(jpg1);
							 
						 
						} catch (com.lowagie2.text.DocumentException e) {
							e.printStackTrace();
						}
					} catch (BadElementException e) {
						e.printStackTrace();
					} 
		        
		        
		        }
		        //关闭文档并释放资源   
		        doc.close();   
		    } catch (FileNotFoundException e) {   
		        e.printStackTrace();   
		    } catch (IOException e) {   
		        e.printStackTrace();   
		    }  
		    
		    
		    return SUCCESS;
			}
		
	public int getPercent(float h,float w)
	{
		int p=0;
		float p2=0.0f;
		if(h>w)
		{
			p2=297/h*100;
		}
		else
		{
			p2=210/w*100;
		}
		p=Math.round(p2);
		return p;
	}	
	
	public int getPercent2(float h,float w)
	{
		int p=0;
		float p2=0.0f;
		p2=530/w*100;
		p=Math.round(p2);
		return p;
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


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<Picture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getRealPdfPath() {
		return realPdfPath;
	}

	public void setRealPdfPath(String realPdfPath) {
		this.realPdfPath = realPdfPath;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}
}
