package socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// 1:建立服务器端的tcp socket服务,必须监听一个端口
		ServerSocket ss = new ServerSocket(9999);
		// 2: 通过服务器端的socket对象的accept方法获取连接上的客户端对象
		Socket s = null;
		// 3：获取客户端的数据
		while (true) {
			// 接受Socket服务,如果有,没有则堵塞,等待
			s = ss.accept();
			System.out.println("accept success.......");
			// 从Socekt输入流中获取客户端发送过来的输出流
			InputStream in = s.getInputStream();
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String str = new String(buf, 0, len);
			System.out.println("从客户端传送来的数据如下:");
			System.out.println(str);
			// 通过服务器端Socket输出流,写数据,会传送到客户端Socket输入流中
			OutputStream out = s.getOutputStream();
			// 把字母转化为大写
			out.write(str.toUpperCase().getBytes());
			s.close();
		}
	}

}
