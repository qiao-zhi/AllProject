package Sax_XMLParse;

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

public class Demo3 {

	public static void main(String[] args) throws Exception {
		// 1.创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.得到解析器
		SAXParser sParser = factory.newSAXParser();
		// 3.得到读取器
		XMLReader reader = sParser.getXMLReader();
		// 4.设置内容处理器
		reader.setContentHandler(new TagValueHandler_1());
		// 5.读取xml文件
		reader.parse("src/Book.xml");
	}
}

//读取指定的标签（读取书名）
class TagValueHandler_1 extends DefaultHandler{

	private String currentTag;  //记住当前的标签是那个
	private int needNum = 2;    //记住需要第几个
	private int currentNum;     //记住当前是第几个
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("书名".equals(qName)){
			currentTag="书名";
			currentNum++;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		currentTag=null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("书名".equals(currentTag)&&needNum==currentNum){
			System.out.println(new String(ch,start,length));
		}
	}
	
	
	
}
