package Action.txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ExportTxtPemplate extends ActionSupport {

	private  String fileName ;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public InputStream getInputStream() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/template/ExportTxtTemplates");
		String filepath = path +"\\" + fileName + ".txt";
		File file = new File(filepath);
		//只用返回一个输入流
		return FileUtils.openInputStream(file);
	}

	
	//文件下载名
	public String getDownloadFileName(){
		String downloadFileName = "";
		String filename = fileName + ".txt";
		try {
			downloadFileName = URLEncoder.encode(filename,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downloadFileName;
	}
	
	
	@Override
	public String execute() throws Exception {
		this.setFileName("试题模板");
		return super.execute();
	}
}
