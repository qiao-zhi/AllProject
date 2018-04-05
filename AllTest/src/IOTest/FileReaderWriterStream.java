package IOTest;

import java.io.*;
public class FileReaderWriterStream {
	public static void main(String[] args)throws IOException {
		FileWriter fw;
		fw=new FileWriter(".\\filestream.txt"); //打开文件输出流
		char array[]={'文','本','输','入','输','出','示','例','。'};
		for(int i=0;i<array.length ;i++)
			fw.write(array[i]); //写数据到文件输出流，也就是写入文件
		fw.close(); //关闭文件输出流，即关闭文件
		FileReader fr;
		fr=new FileReader(".\\filestream.txt"); //打开文件输入流
		int value;
		while((value=fr.read())!=-1)  //从文件输入流读数据，也就是从文件读数据
			System.out.print((char)value);  
		fr.close(); //关闭文件输入流，即关闭文件
	}
}