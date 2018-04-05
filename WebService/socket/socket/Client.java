package socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		// 1: 创建一个基于TCP协议的socket服务,在建立对象时,要指定连接服务器和端口号
		Socket s = new Socket("127.0.0.1", 9999);
		// 2: 通过建立的Socket对象获取Socket中的输出流,的调用getOutStream方法
		OutputStream out = s.getOutputStream();
		System.out.println("请输入要转化的字母,或者单词!");
		// 3: 写入到Socket输出流中
		String word = input.next();
		out.write(word.getBytes());
		// 4: 通过建立的Socket对象获取Socket中的输入流,输入流会接受来自服务器端数据
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		// 5: 获取输入字节流的数据,注意此方法是堵塞的,如果没有获取数据会一直等待
		int len = in.read(buf);
		String str = new String(buf, 0, len);
		System.out.println("服务返回来的结果如下:");
		System.out.println(str);
		// 关闭Socket
		s.close();
	}

}
