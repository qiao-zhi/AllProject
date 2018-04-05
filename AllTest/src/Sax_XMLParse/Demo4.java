package Sax_XMLParse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang.Validate;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo4 {

	public static void main(String[] args) throws Exception {
		// 1.创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.得到解析器
		SAXParser sParser = factory.newSAXParser();
		// 3.得到读取器
		XMLReader reader = sParser.getXMLReader();
		// 4.设置内容处理器
		ListBeanHandler listBeanHandler = new ListBeanHandler();
		reader.setContentHandler(listBeanHandler);
		// 5.读取xml文件
		reader.parse("src/Book.xml");
		List<Book> list = listBeanHandler.getList();
		System.out.println(list);
		
	}
}

// 读取指定的标签（读取书名）
class ListBeanHandler extends DefaultHandler {

	private String currentTag; // 记住当前的标签是那个
	private List<Book> list = new ArrayList<Book>();
	private Book book;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentTag = qName;
		if ("书".equals(qName)) {
			book = new Book();
		}
	}

	@Override 
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("书名".equals(currentTag)){
			book.setName(new String(ch, start, length));
		}
		if("作者".equals(currentTag)){
			book.setAuthor(new String(ch, start, length));
		}
		if("价格".equals(currentTag)){
			book.setPrice(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		currentTag = null;
		if("书".equals(qName)){
			list.add(book);
			book=null;
		}
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	
}
