package Dom4j_XMLParser;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo3 {
	/**
	 * 测试path
	 *@throws Exception
	 */
	@Test
	public void xpathTest() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		
		
//		获取所有节点
       List<Node> selectNodes = document.selectNodes( "//*" );
       for(Node node :selectNodes){
    	   System.out.println(node.asXML());
       }
		
//		取第一个书节点
        Element node = (Element) document.selectSingleNode( "//书名" );
        System.out.println(node.asXML());    //<书名 name="ww">一本烂书！！</书名>
        System.out.println(node.attributeValue("name"));   
        System.out.println(node.getText());
        
//		取第二个书的书名
        Node node1 = document.selectSingleNode( "/书架/书[last()]/书名" );
        System.out.println(node1.getText());
        
        
	}
}
