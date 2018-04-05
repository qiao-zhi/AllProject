package IOTest;

import java.io.*;
public class BuffereStream_1 {
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		FileWriter fout = new FileWriter(".\\buffer.txt");//打开文本文件写
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
		FileReader fin=new FileReader(".\\buffer.txt");//打开文本文件读
		BufferedReader bin=new BufferedReader(fin);//字符流转换为缓冲流	
		while((str=bin.readLine())!=null)//从文件中读一行字符
			System.out.println(str); //显示
		bin.close();
	}
}