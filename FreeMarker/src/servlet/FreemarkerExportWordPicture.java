package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import sun.misc.BASE64Encoder;

public class FreemarkerExportWordPicture {

	@Test
	public  void test1() throws Exception {
		Map<String,Object> dataMap = new HashMap<String,Object>();  
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(this.getClass(),""); 
		File outFile = new File("F:/test4.doc");  
		dataMap.put("img", getImageStr());
	     //以utf-8的编码读取ftl文件  
	     Template t =  configuration.getTemplate("test4.ftl","utf-8");  
	     Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);  
	     t.process(dataMap, out);  
	     out.close();
	}
	
	
	//下面这段代码对图片进行base64编码
	private String getImageStr() throws Exception {
		String imgFile = "C:/Users/liqiang/Desktop/kdmt.jpg";
		InputStream inputStream = null;
		byte []data=null;
		inputStream = new FileInputStream(imgFile);
		data = new byte[inputStream.available()];
		inputStream.read(data);
		inputStream .close();
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
		
	}
}
