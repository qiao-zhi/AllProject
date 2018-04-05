package IOTest;

import java.io.*;
public class FileInputOutputStream {
	public static void main(String[] args)throws IOException {
		FileOutputStream fos;
		fos=new FileOutputStream(".\\test.txt"); //打开文件输出流
		byte[] array={1,3,5,7,9,11,13,15,17,19};
		for(int i=0;i<array.length ;i++)
			fos.write(array[i]); //写数据到文件输出流，也就是写入文件
		fos.close(); //关闭文件输出流，即关闭文件
		FileInputStream fis;
		fis=new FileInputStream(".\\test.txt"); //打开文件输入流
		int value;
		while((value=fis.read())!=-1)  //从文件输入流读数据，也就是从文件读数据
			System.out.print(value+" ");  
		fis.close(); //关闭文件输入流，即关闭文件
	}
}
