package Action.Excel2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.catalina.connector.Request;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Question;

public class ExportExcelPaper extends ActionSupport {

	private String fileName;
	private List<Question> list = new ArrayList<>();

	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() throws Exception {
		create();
		String path = ServletActionContext.getServletContext().getRealPath("/template/ExcelPaper");
		String filepath = path + "\\" + fileName + ".xls";
		File file = new File(filepath);
		// 只用返回一个输入流
		return FileUtils.openInputStream(file);
	}

	// 产生模板到文件夹下面
	public void create() {
		// 获取工程下的路径
		String path = ServletActionContext.getServletContext().getRealPath("/template/ExcelPaper");
		String filepath = path + "\\" + fileName + ".xls";
		// 同一个工作簿创建的才可以创建不同的工作表到同一个文件
		// 通过毫秒数获取唯一的名字
		GenerateExcelPaper.exportExcelPaper(list, filepath);

	}

	// 文件下载名
	public String getDownloadFileName() {
		String downloadFileName = "";
		String filename = fileName + ".xls";
		try {
			downloadFileName = URLEncoder.encode(filename, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downloadFileName;
	}

	@Override
	public String execute() throws Exception {
		this.setFileName(String.valueOf(System.currentTimeMillis()));
//		从会话中读取数据
		List<Question> list2 = (List<Question>)ServletActionContext.getRequest().getSession().getAttribute("list");
		if (list2 != null) {
			this.setList(list2);
		}
		return super.execute();
	}
}
