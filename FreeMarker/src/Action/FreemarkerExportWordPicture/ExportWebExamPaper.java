package Action.FreemarkerExportWordPicture;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

import FreemarkExWord.Dxt;
import FreemarkExWord.Oxt;
import FreemarkExWord.Pdt;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import sun.misc.BASE64Encoder;

public class ExportWebExamPaper extends ActionSupport{
	private  String fileName ;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String execute() throws Exception {
		this.setFileName(String.valueOf(System.currentTimeMillis()));
		return super.SUCCESS;
	}
//	用于文件下载的输入流
	public InputStream getInputStream() throws Exception {
		CreatePaper();
		String path = ServletActionContext.getServletContext().getRealPath("/Paper");
		String filepath = path +"\\" + fileName + ".doc";
		File file = new File(filepath);
		//只用返回一个输入流
		return FileUtils.openInputStream(file);
	}
	
	//文件下载名
		public String getDownloadFileName(){
			String downloadFileName = "";
			String filename = fileName + ".doc";
			try {
				downloadFileName = URLEncoder.encode(filename,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return downloadFileName;
		}

	private void CreatePaper() throws Exception, TemplateNotFoundException, MalformedTemplateNameException,
		ParseException, IOException, UnsupportedEncodingException, FileNotFoundException, TemplateException {
		String path = ServletActionContext.getServletContext().getRealPath("/Paper");
		String filePath = path+"\\"+fileName+".doc";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("sjmc", "电厂第一次考试");
		List<Dxt> dlist = new ArrayList<Dxt>();
		List<Oxt> olist = new ArrayList<Oxt>();
		List<Pdt> plist = new ArrayList<Pdt>();
		dlist.add(
				new Dxt("1", "你喜欢吃什么()", "大米", "面条", "面板", "猪肉", getImageStr("C:/Users/liqiang/Desktop/tupian/1.jpg")));
		dlist.add(
				new Dxt("2", "你喜欢吃什么()", "大米", "面条", "面板", "猪肉", getImageStr("C:/Users/liqiang/Desktop/tupian/2.jpg")));
		dlist.add(
				new Dxt("3", "你喜欢吃什么()", "大米", "面条", "面板", "猪肉", getImageStr("C:/Users/liqiang/Desktop/tupian/3.jpg")));
		dlist.add(
				new Dxt("4", "你喜欢吃什么()", "大米", "面条", "面板", "猪肉", getImageStr("C:/Users/liqiang/Desktop/tupian/4.jpg")));
		dlist.add(
				new Dxt("5", "<p>你喜欢吃什么()", "大米", "面条", "面板", "猪肉", getImageStr("C:/Users/liqiang/Desktop/tupian/5.jpg")));
		dlist.add(
				new Dxt("6", "你喜欢吃什么()", "大米", "面条", "面板", "猪肉",getImageStr("C:/Users/liqiang/Desktop/tupian/6.jpg")));

		olist.add(new Oxt("1", "你喜欢的运动是什么()", "篮球", "足球", "羽毛球", "游戏",
				getImageStr("C:/Users/liqiang/Desktop/tupian/1.jpg")));
		olist.add(new Oxt("2", "你喜欢的运动是什么()", "篮球", "足球", "羽毛球", "游戏",
				getImageStr("C:/Users/liqiang/Desktop/tupian/2.jpg")));
		olist.add(new Oxt("3", "你喜欢的运动是什么()", "篮球", "足球", "羽毛球", "游戏",
				getImageStr("C:/Users/liqiang/Desktop/tupian/3.jpg")));
		olist.add(new Oxt("4", "你喜欢的运动是什么()", "篮球", "足球", "羽毛球", "游戏",
				getImageStr("C:/Users/liqiang/Desktop/tupian/4.jpg")));
		olist.add(new Oxt("5", "你喜欢的运动是什么()", "篮球", "足球", "羽毛球", "游戏",
				getImageStr("C:/Users/liqiang/Desktop/tupian/5.jpg")));
		olist.add(new Oxt("6", "你喜欢的运动是什么()", "篮球", "足球", "羽毛球", "游戏",
				getImageStr("C:/Users/liqiang/Desktop/tupian/6.jpg")));

		plist.add(new Pdt("1", "你是人？", getImageStr("C:/Users/liqiang/Desktop/tupian/kdmt.jpg")));
		plist.add(new Pdt("2", "你是人？", getImageStr("C:/Users/liqiang/Desktop/tupian/mvc.png")));
		plist.add(new Pdt("3", "你是人？", getImageStr("C:/Users/liqiang/Desktop/tupian/kdmt.jpg")));
		plist.add(new Pdt("4", "你是人？", getImageStr("C:/Users/liqiang/Desktop/tupian/kdmt.jpg")));
		plist.add(new Pdt("5", "你是人？", getImageStr("C:/Users/liqiang/Desktop/tupian/kdmt.jpg")));

		dataMap.put("dlist", dlist);
		dataMap.put("olist", olist);
		dataMap.put("plist", plist);
		dataMap.put("img", getImageStr("C:/Users/liqiang/Desktop/tupian/kdmt.jpg"));
		// dataMap.put("img1",
		// getImageStr("C:/Users/liqiang/Desktop/tupian/web.png"));
		// dataMap.put("img2",
		// getImageStr("C:/Users/liqiang/Desktop/tupian/mvc.png"));

		// Configuration用于读取ftl文件
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");

		/*
		 * 以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是 指定ftl文件所在目录的路径,而不是ftl文件的路径
		 */
		// 指定路径的第一种方式(根据某个类的相对路径指定)
		configuration.setClassForTemplateLoading(this.getClass(), "");

		// 指定路径的第二种方式,我的路径是C:/a.ftl
		// configuration.setServletContextForTemplateLoading(getServletContext(),
		// "/WEB-INF/templates");
		// 输出文档路径及名称
		File outFile = new File(filePath);
		// 以utf-8的编码读取ftl文件
		Template t = configuration.getTemplate("test7.ftl", "utf-8");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
		t.process(dataMap, out);
		out.close();
	}

	// 下面这段代码对图片进行base64编码
	private String getImageStr(String imgFile) throws Exception {
		InputStream inputStream = null;
		byte[] data = null;
		inputStream = new FileInputStream(imgFile);
		data = new byte[inputStream.available()];
		inputStream.read(data);
		inputStream.close();
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);

	}
}
