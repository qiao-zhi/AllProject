package FreemarkExWord;

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

public class TestExam {

	 @Test  
	   public void exportSimpleWord() throws Exception{  
	       // 要填充的数据, 注意map的key要和word中${xxx}的xxx一致  
	      Map<String,Object> dataMap = new HashMap<String,Object>();  
	      dataMap.put("sjmc", "电厂第一次考试");  
	      List<Dxt> dlist = new ArrayList<Dxt>(); 
	      List<Oxt> olist = new ArrayList<Oxt>(); 
	      List<Pdt> plist = new ArrayList<Pdt>(); 
	      dlist.add(new Dxt("1", "这是一个单选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      dlist.add(new Dxt("2", "这是一个单选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      dlist.add(new Dxt("3", "这是一个单选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      dlist.add(new Dxt("4", "这是一个单选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      dlist.add(new Dxt("5", "这是一个单选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      dlist.add(new Dxt("6", "这是一个单选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	       
	      
	      olist.add(new Oxt("1", "这是一个多选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      olist.add(new Oxt("2", "这是一个多选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      olist.add(new Oxt("3", "这是一个多选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      olist.add(new Oxt("4", "这是一个多选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      olist.add(new Oxt("5", "这是一个多选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	      olist.add(new Oxt("6", "这是一个多选题，请选择答案", "fdsf佛挡杀佛多少分的多少的", "第三方的地方第三方反倒是多少多少", "dsf ds  sd fds的分的", "ds ds fsd你的说法的"));
	       
	      
	      plist.add(new Pdt("1", "你是人？"));
	      plist.add(new Pdt("2", "你是人？"));
	      plist.add(new Pdt("3", "你是人？"));
	      plist.add(new Pdt("4", "你是人？"));
	      plist.add(new Pdt("5", "你是人？"));
	      
	      dataMap.put("dlist", dlist); 
	      dataMap.put("olist", olist); 
	      dataMap.put("plist", plist); 
	      
	    //Configuration用于读取ftl文件  
	      Configuration configuration = new Configuration();  
	      configuration.setDefaultEncoding("utf-8");  
	        
	      /*以下是两种指定ftl文件所在目录路径的方式, 注意这两种方式都是 
	       * 指定ftl文件所在目录的路径,而不是ftl文件的路径 
	       */  
	      //指定路径的第一种方式(根据某个类的相对路径指定)  
	      configuration.setClassForTemplateLoading(this.getClass(),"");  
	        
	      //指定路径的第二种方式,我的路径是C:/a.ftl  
//	      configuration.setServletContextForTemplateLoading(getServletContext(), "/WEB-INF/templates");  
	        
	      // 输出文档路径及名称  
	     File outFile = new File("F:/test3.doc");  
	       
	     //以utf-8的编码读取ftl文件  
	     Template t =  configuration.getTemplate("paper.ftl","utf-8");  
	     Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);  
	     t.process(dataMap, out);  
	     out.close();  
	   } 
}
