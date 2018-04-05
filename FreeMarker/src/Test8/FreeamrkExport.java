package Test8;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import bean.TestFreemarkerBean;
import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

/**
 * 如果图片不为空才显示图片，为空则不显示。
* @author: qlq
* @date :  2017年7月26日下午4:44:59
 */
public class FreeamrkExport {

	@Test
	public void exportSimpleWord() throws Exception {
		// 要填充的数据, 注意map的key要和word中${xxx}的xxx一致
		Map<String, Object> dataMap = new HashMap<String, Object>();
		

		// Configuration用于读取ftl文件
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");

		/*
		 * 以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是 指定ftl文件所在目录的路径,而不是ftl文件的路径
		 */
		// 指定路径的第一种方式(根据某个类的相对路径指定)
		configuration.setClassForTemplateLoading(this.getClass(), "");
		// 指定路径的第二种方式,我的路径是C:/a.ftl
		// configuration.setDirectoryForTemplateLoading(new File("C:/"));

		List<person> mylist = new ArrayList<person>();
		mylist.add(new person("QQQ", getImageStr("C:/Users/liqiang/Desktop/tupian/kdmt.jpg"), "11111111111111"));
		mylist.add(new person("QQQ", getImageStr("C:/Users/liqiang/Desktop/tupian/2.jpg"), "11111111111111"));
		mylist.add(new person("QQQ", getImageStr("C:/Users/liqiang/Desktop/tupian/1.jpg"), "11111111111111"));
		mylist.add(new person("QQQ", getImageStr("C:/Users/liqiang/Desktop/tupian/3.jpg"), "11111111111111"));
		mylist.add(new person("QQQ", getImageStr("C:/Users/liqiang/Desktop/tupian/4.jpg"), "11111111111111"));
		mylist.add(new person("QQQ", "11111111111111"));
		mylist.add(new person("QQQ", "11111111111111"));
		dataMap.put("mylist", mylist);
		// 输出文档路径及名称
		File outFile = new File("F:/test8.doc");

		// 以utf-8的编码读取ftl文件
		Template t = configuration.getTemplate("test8.ftl", "utf-8");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
		t.process(dataMap, out);
		out.close();
	}
	private String getImageStr(String imgFile) throws Exception {
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
