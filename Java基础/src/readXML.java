import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList; 
public class readXML {
	public static void main(String arg[]){

long lasting =System.currentTimeMillis();
try{
File f= new File("NewFile.xml");
DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
DocumentBuilder builder=factory.newDocumentBuilder();
Document doc=builder.parse(f);
NodeList nl=doc.getElementsByTagName("VALUE"); //����������VALUE�ı�ǩ
for (int i=0;i<nl.getLength();i++){//iȡ0,1
System.out.println("编号:"+doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue()); //���ݱ�ǩ���ֶ�ȡ����
System.out.println("地址:"+doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
System.out.println("时间"+(System.currentTimeMillis()-lasting));
}
}catch(Exception e){
e.printStackTrace();
}
}
}