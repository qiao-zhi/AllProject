package Java_ClassLoader;

public class JVMtest1 {

	public static void main(String[] args) {
//		通知JVM开辟1024字节内存，1k大小
		byte b[] = new byte[1024];
		
//		通知JVM开辟1005M内存(内存溢出异常)
		byte b1[] = new byte[1024*1024*1005];
	}
	
}
