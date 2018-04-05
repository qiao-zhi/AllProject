package Dom4j_XMLParser;

import java.io.File;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo1 {

//	获取第二本书的书名
	@Test
	public void read() throws Exception {
//		创建SAX读取器
		SAXReader reader = new SAXReader();
//		加载文档
		Document document = reader.read(new File("src/book.xml"));
//		获取根节点(书架)
		Element root =  document.getRootElement();
//		获取根节点下的书节点，带s返回一个数组，再取数组的第二个
		Element book = (Element) root.elements("书").get(1);
//		获取树下面的书名属性
		Element shuming = book.element("书名");
//		获取书名开始标签与结束标签之间的值
		String value = shuming.getText();
		System.out.println(value);
		
	}
	
	
//	获取第二本书的书名中的属性  <书名 name="xxxxxxxxxxx">Java中级</书名>
	@Test
	public void readAttribute() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element root =  document.getRootElement();
		
		Element book = (Element) root.elements("书").get(1);
		
//		第一中方法
		Element shuming = book.element("书名");
//		获取name属性
		Attribute attribute = shuming.attribute("name");
//		获取name属性的值
		String attrValue = attribute.getValue();
//		获取书名开始标签与结束标签之间的值
		System.out.println(attrValue);   //xxxxxxxxx
		
//		第二种方法(获取书名节点的name属性的值)
		System.out.println(shuming.attributeValue("name"));  //xxxxxxxx
		
	}
}
