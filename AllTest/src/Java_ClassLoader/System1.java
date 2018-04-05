package Java_ClassLoader;

public class System1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(System.getProperty("java.version"));
System.out.println(System.getProperty("java.vendor"));
System.out.println(System.getProperty("java.home"));
System.out.println(System.getProperty("java.library.path"));
System.out.println(System.getProperty("user.dir"));   //获取当前类工作目录
System.out.println(System.getProperty("os.version"));
System.out.println(System.getProperty("os.name"));
System.out.println(System.getenv("path"));
	}

}
