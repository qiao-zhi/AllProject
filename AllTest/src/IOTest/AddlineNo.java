package IOTest;
import java.io.*;
public class AddlineNo {
	public static void main(String[] args) {
		String str=null;
		try{
			FileReader file=new FileReader(".\\buffer.txt");
			LineNumberReader in=new LineNumberReader(file);
			while((str=in.readLine())!=null)
				System.out.println(in.getLineNumber()+":"+str);
			in.close();
		}catch(IOException e){
			System.out.println("文件打不开或读文件错误！");
		}
	}
}
