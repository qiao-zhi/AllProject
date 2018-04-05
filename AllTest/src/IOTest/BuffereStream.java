package IOTest;

import java.io.*;
public class BuffereStream {
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStream os=new FileOutputStream(".\\buffer.bin");//打开字节文件写
		OutputStreamWriter fout = new OutputStreamWriter(os);//字节流转换字符流
		BufferedWriter bout=new BufferedWriter(fout);//字符流转换为缓冲流
		String str;
		while(true){
			str=br.readLine(); //从键盘读一行字符
			if(str.equals("end"))
				break;
			bout.write(str); //将读入的字符写入文件中
			bout.newLine(); //写行分隔符到文件中
		}
		bout.close(); //关闭文件
		InputStream is=new FileInputStream(".\\buffer.bin");//打开字节文件读
		InputStreamReader fin = new InputStreamReader(is);//字节流转换字符流
		BufferedReader bin=new BufferedReader(fin);//字符流转换为缓冲流	
		while((str=bin.readLine())!=null)//从文件中读一行字符
			System.out.println(str); //显示
		bin.close();
	}
}
