package FileDownload;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownLoad extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String contentType;
	private long contentLength;
	private String contentDisposition;
	private InputStream inputStream;
	
	
	public String getContentType() {
		return contentType;
	}


	public long getContentLength() {
		return contentLength;
	}


//	在getter方法中设置所需要的参数
	public String getContentDisposition() {
		contentDisposition = "attachment;filename=download.html";
		return contentDisposition;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	@Override
	public String execute() throws Exception {
		
		//确定各个成员变量的值
		contentType = "application/x-download";
		
		ServletContext servletContext = 
				ServletActionContext.getServletContext();
		String fileName = servletContext.getRealPath("/files/filesUp.html");
//		打开输入流
		inputStream = new FileInputStream(fileName);
		contentLength = inputStream.available();
				
		
		return super.execute();
	}
}
