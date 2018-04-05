package Dom4j_XMLParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo2 {

	// 在第一本书后增加一个 <描述 name="xxxxxx">一本好书！</描述>
	@Test
	public void addElementAndAttr() throws Exception {
		// 创建SAX读取器
		SAXReader reader = new SAXReader();
		// 加载文档
		Document document = reader.read(new File("src/book.xml"));
		// 获取根节点(书架)
		Element root = document.getRootElement();
		// 获取根节点下的书节点，带s返回一个数组，再取数组的第二个
		Element book = (Element) root.elements("书").get(0);
		// 获取树下面的书名属性
		book.addElement("描述").addAttribute("name", "xxxxxx").setText("一本好书！");

		// 格式化输出流，同时指定编码格式。也可以在FileOutputStream中指定。
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");

		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		writer.write(document);
		writer.close();
	}

	// 在指定位置添加一个节点
	@Test
	public void addElementAndAttr1() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element root = document.getRootElement();

		// 获取第一个书节点
		Element shu = (Element) root.elements("书").get(0);
		// 获取第一个节点下的所有节点
		List list = shu.elements(); // [书名，作者，价格]

		// 创建一个节点
		Element miaoshu = DocumentHelper.createElement("miaoshu");
		miaoshu.setText("一本好书");
		list.add(2, miaoshu);

		// 格式化输出流，同时指定编码格式。也可以在FileOutputStream中指定。
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");

		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		writer.write(document);
		writer.close();
	}

	// 删除节点
	@Test
	public void delete() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element root = document.getRootElement();

		// 获取第一个书节点
		Element shu = (Element) root.elements("书").get(0);
		Element miaoshu = (Element) shu.element("miaoshu");
		// 获取到miaoshu节点的父节点并删除miaoshu节点
		miaoshu.getParent().remove(miaoshu);

		// 格式化输出流，同时指定编码格式。也可以在FileOutputStream中指定。
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");

		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		writer.write(document);
		writer.close();

	}

	// 修改节点
	@Test
	public void update() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element root = document.getRootElement();

		// 获取第一个书节点
		Element shu = (Element) root.elements("书").get(0);
		Element shuming = (Element) shu.element("书名");
		// 获取到miaoshu节点的父节点并删除miaoshu节点
		shuming.setText("一本烂书！！");

		// 格式化输出流，同时指定编码格式。也可以在FileOutputStream中指定。
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");

		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		writer.write(document);
		writer.close();

	}

}
