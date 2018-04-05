import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class RedDb {
public static void main(String s[]) throws IOException{
	
//	//第一种方法，通过类装载器读取资源文件，只在类加载时读取，不能读取到更新后的文件（直接读取）
//	InputStream in=RedDb.class.getClassLoader().getResourceAsStream("db.properties");
//	Properties po=new Properties();
//	po.load(in);
//	System.out.println(po.getProperty("url"));
//	System.out.println(po.getProperty("username"));

	
	//第二种读取方法，通过类加载器读取到资源路径，再通过路径读取文件，可以读取到更新后的文件（先读取路径再读取文件）
	//包名为X.Y.Z，经过编译后变为文件夹X/Y/Z
	String path=RedDb.class.getClassLoader().getResource("./util/ha/ha/db.properties").getPath();
	FileInputStream file=new FileInputStream(path);
	Properties po=new Properties();
	po.load(file);
	System.out.println(po.getProperty("url"));
	System.out.println(po.getProperty("username"));
	
	
	
	
}
}
