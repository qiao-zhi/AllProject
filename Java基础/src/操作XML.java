import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class 操作XML {
	/*********先写好获取document的方法与写入XML的方法，然后获取根节点，在根节点的基础上添加节点与属性，
	 在根节点的基础上查询节点属性，同时可以将查询的节点存到List集合中，然后循环遍历该节点，得到多个同名节点
	 的信息
	 * *********/
	
	
private static String path;
static {
	path=操作XML.class.getClassLoader().getResource("NewFile.xml").getPath();
}
         /****先获取XML的document********/
	public static Document getDocument() throws Exception{
		
		 SAXReader reader = new SAXReader();
	     Document document = reader.read(new File(path));
	     return document;
		
		
	}
	
	
	/**************将数据写入XML文件中********/
	public static void write(Document document) throws Exception{
		  // lets write to a file
		 OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(  new FileWriter(path ),format    );
        writer.write( document );
        writer.close();
	}
	
	
	public static void main(String[] args) {
		try {
//			AddXml();
//			Document document=操作XML.getDocument();
//			Element root=document.getRootElement();
//			Element e4=(Element) root.selectSingleNode("//User[@MINGZI='qqq'and @sss='sssssssss']");
			search();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/***************查询节点信息**/
    public static void search() {
    	
		Document document;
		try {
			document = 操作XML.getDocument();
			Element root=document.getRootElement();  //获取根节点
			Element e2=root.element("VALUE");        //获取根节点下的第一个节点
			
			System.out.println(e2.element("ADDR").getText());     //获取节点的内容(标签中间内容)
			System.out.println(e2.getText());
			
			List list=(List) root.elements("VALUE");     //获取多个名字相同的节点，遍历其属性与内容
            for(int i=0;i<list.size();i++){
            	Element e=(Element) list.get(i);          
            	System.out.println(e.element("ADDR").getText());
            	
            }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
/******************向XML中增加标签***/
	private static void AddXml() throws Exception {
		Document document=操作XML.getDocument();
		Element root=document.getRootElement();  //获取根节点
		Element ee=root.addElement("User");          //增加节点
		Element e1=ee.addElement("Name");          //增加节点
		e1.setText("子节点");                     //设置节点内容（ee下面添加一个e1节点）
		

		
		ee.setAttributeValue("MINGZI", "qqq");       //设置节点属性
		ee.setAttributeValue("sss","sssssssss");
		
		String sss=ee.attributeValue("sss");  //获取节点属性(前提是先获取到节点)
		String ss=ee.attributeValue("MINGZI");  //获取节点属性(前提是先获取到节点)
		
		Element e3=root.element("VALUE");
		System.out.println(e3.attributeValue("ADDR"));

		操作XML.write(document);       //这一句将添加到XML文件中
		System.out.println("ssss");
		
		
	
	}
	
	
}
