package Action.Excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Question;

public class ImportWebExcel  extends ActionSupport{

	private File fileName;
	private String fileNameContentType;
	private String fileNameFileName;
	
	public String execute() throws Exception{
		
		ServletContext servletContext = ServletActionContext.getServletContext();
//		fileNameFileName表示文件上传时候的名字，也可以自己用UUID定义一个新的名字
		String dir = servletContext.getRealPath("/template/ExcelImportTemplate/"+fileNameFileName);
		System.out.println(dir);
//		文件输出流，写到dir指定的目录与名字
		FileOutputStream outputStream = new FileOutputStream(dir);
//		打开上传的文件的输入流
		FileInputStream inputStream = new FileInputStream(fileName);
		byte[] buffer = new byte[1024];
		int len = 0;
//		从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中.读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
		while((len = inputStream.read(buffer))!=-1){
//			将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
			outputStream.write(buffer, 0, len);
		}
		inputStream.close();
		outputStream.close();
//		读取上传上来的Excel数据
		POIReadExcelTemplatesData excelTemplatesData = new POIReadExcelTemplatesData();
		List<Question> list = excelTemplatesData.readData(dir);
//		将上传上来的试题加入域中
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	public File getFileName() {
		return fileName;
	}

	public void setFileName(File fileName) {
		this.fileName = fileName;
	}

	public String getFileNameContentType() {
		return fileNameContentType;
	}

	public void setFileNameContentType(String fileNameContentType) {
		this.fileNameContentType = fileNameContentType;
	}

	public String getFileNameFileName() {
		return fileNameFileName;
	}

	public void setFileNameFileName(String fileNameFileName) {
		this.fileNameFileName = fileNameFileName;
	}


	
}
