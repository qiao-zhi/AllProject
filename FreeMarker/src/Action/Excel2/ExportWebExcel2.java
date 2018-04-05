package Action.Excel2;

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

public class ExportWebExcel2 extends ActionSupport {

	private  String fileName ;
	private int danxuan;
	private int duoxuan;
	private int panduan;
	
	
	public int getDanxuan() {
		return danxuan;
	}
	public void setDanxuan(int duanxuan) {
		this.danxuan = duanxuan;
	}
	public int getDuoxuan() {
		return duoxuan;
	}
	public void setDuoxuan(int duoxuan) {
		this.duoxuan = duoxuan;
	}
	public int getPanduan() {
		return panduan;
	}
	public void setPanduan(int panduan) {
		this.panduan = panduan;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public InputStream getInputStream() throws Exception {
		create();
		String path = ServletActionContext.getServletContext().getRealPath("/template/ExcelExportTemplate");
		String filepath = path +"\\" + fileName + ".xls";
		File file = new File(filepath);
		//只用返回一个输入流
		return FileUtils.openInputStream(file);
	}


	//产生模板到文件夹下面
	public  void create(){
		//获取工程下的路径
		String path = ServletActionContext.getServletContext().getRealPath("/template/ExcelExportTemplate");
		String filepath = path +"\\" + fileName + ".xls";
//		同一个工作簿创建的才可以创建不同的工作表到同一个文件
//		通过毫秒数获取唯一的名字
		GenerateExcelTemplate.createPemplate(filepath);
	}
	
	
	//文件下载名
	public String getDownloadFileName(){
		String downloadFileName = "";
		String filename = fileName + ".xls";
		try {
			downloadFileName = URLEncoder.encode(filename,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downloadFileName;
	}
	
	
	@Override
	public String execute() throws Exception {
		this.setFileName(String.valueOf(System.currentTimeMillis()));
		return super.execute();
	}
}
