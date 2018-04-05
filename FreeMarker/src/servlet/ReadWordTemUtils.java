package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

import org.junit.Test;

public class ReadWordTemUtils {
	
	@Test
	public void test1() throws Exception{
				
		String str;
		FileInputStream fis;
		fis=new FileInputStream("E:\\EclipseWorkspace\\FreeMarker\\test.doc"); //打开文件输入流
		Reader in = new BufferedReader(new InputStreamReader(fis, "utf-8"));
		 char[] cbuf = new char[1024];  
         //用于保存实际读取的字符数  
         int hasRead = 0;  
         StringBuffer sb = new StringBuffer();
         //使用循环读取数据  
         while((hasRead = in.read(cbuf)) > 0){  
               
             //将字符数组转化为字符串输出  
//             System.out.println(new String(cbuf,0,hasRead)); 
             sb.append(new String(cbuf,0,hasRead));
               
         } 
//         将读出的数据进行处理
         String all = sb.toString();
         String s[] = all.split("\n\n");
 		System.out.println("共有:" + s.length + "道题");
 		// 对每一道题进行处理
 		for (int i = 0; i < s.length; i++) {
 			// 将题再分成题目选项什么的,抽取成一道一道的题
 			String[] question = s[i].split("\n");
 			System.out.println("第" + (i + 1) + "道题共有" + question.length + "项");
 			if (question.length == 5) {
 				String tigan = question[0].substring(4);
 				System.out.println("题干\t" + tigan);
 				String leixing = question[1].substring(4);
 				System.out.println("类型\t" + leixing);
 				String xuanxiang = question[2].substring(4);
 				System.out.println("选项\t" + xuanxiang);
 				String daan = question[3].substring(4);
 				System.out.println("答案\t" + daan);
 				String jiexi = question[4].substring(4);
 				System.out.println("解析\t" + jiexi);
 			}
 			if (question.length == 4) {
 				String tigan = question[0].substring(4);
 				System.out.println("题干\t" + tigan);
 				String leixing = question[1].substring(4);
 				System.out.println("类型\t" + leixing);
 				String daan = question[2].substring(4);
 				System.out.println("答案\t" + daan);
 				String jiexi = question[3].substring(4);
 				System.out.println("解析\t" + jiexi);
 			}
 			System.out.println();
 		}
         
	}
	
}
