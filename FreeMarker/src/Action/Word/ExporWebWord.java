package Action.Word;

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

public class ExporWebWord extends ActionSupport {

	private  String fileName ;
	private int danxuan;
	private int duoxuan;
	private int panduan;
	
	
	public int getDanxuan() {
		return danxuan;
	}
	public void setDanxuan(int danxuan) {
		this.danxuan = danxuan;
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
		String path = ServletActionContext.getServletContext().getRealPath("/template/WordExportTemplate");
		String filepath = path +"\\" + fileName + ".doc";
		//完整的路径名
		File file = new File(filepath);
		//只用返回一个输入流
		return FileUtils.openInputStream(file);
	}


	//产生模板到文件夹下面
	public  void create(){
		//获取工程下的路径
		String path = ServletActionContext.getServletContext().getRealPath("/template/WordExportTemplate");
		String filepath = path +"\\" + fileName + ".doc";
//		将文件名字传到下面
		ExportTemUtils exportTemUtils=new ExportTemUtils(filepath);
//		产生不同数量的题目模板
		exportTemUtils.exportWord(danxuan, duoxuan, panduan);
	}
	
	
	//文件下载名
	public String getDownloadFileName(){
		String downloadFileName = "";
		String filename = fileName + ".doc";
		try {
			//�����������
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
