import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList; 
public class readXML2 {
	public static void main(String arg[]){

long lasting =System.currentTimeMillis();
try{
String path=readXML2.class.getClassLoader().getResource("NewFile.xml").getPath();
System.out.println(path);;
File f= new File(path);
DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
DocumentBuilder builder=factory.newDocumentBuilder();
Document doc=builder.parse(f);
Element root=doc.getDocumentElement();
NodeList nl=doc.getElementsByTagName("VALUE"); //����������VALUE�ı�ǩ
for (int i=0;i<nl.getLength();i++){//iȡ0,1
System.out.println("编号:"+doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue()); //���ݱ�ǩ���ֶ�ȡ����
System.out.println("地址:"+doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
System.out.println("时间"+(System.currentTimeMillis()-lasting));


Element ccc=doc.createElement("Value");
ccc.setTextContent("QLQ");
root.appendChild(ccc);
System.out.println("SSSSSSSSSS");



}
}catch(Exception e){
e.printStackTrace();
}
}
}