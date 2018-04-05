package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
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

public class FreeMarkerExportWord {

	@Test
	public void exportSimpleWord() throws Exception {
		// 要填充的数据, 注意map的key要和word中${xxx}的xxx一致
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("username", "张三");
		dataMap.put("password", "男");

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

		List<TestFreemarkerBean> list = new ArrayList<>();
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		dataMap.put("mylist", list);
		// 输出文档路径及名称
		File outFile = new File("F:/test.doc");

		// 以utf-8的编码读取ftl文件
		Template t = configuration.getTemplate("test2.ftl", "utf-8");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
		t.process(dataMap, out);
		out.close();
	}
}
