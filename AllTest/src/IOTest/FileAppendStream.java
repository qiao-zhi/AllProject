package IOTest;

import java.io.*;
public class FileAppendStream {
	public static void main(String[] args)throws IOException {
		String str="Welcom to Java!";
		FileWriter fw;
		fw=new FileWriter(".\\filestream.txt",true); //打开输出流
		fw.write(str); //写字符串到文件输出流
		fw.close(); //关闭文件输出流
		FileReader fr;
		fr=new FileReader(".\\filestream.txt"); //打开输入流
		int value;
		while((value=fr.read())!=-1)  //从文件输入流读数据
			System.out.print((char)value);  
		fr.close(); //关闭文件输入流
	}
}