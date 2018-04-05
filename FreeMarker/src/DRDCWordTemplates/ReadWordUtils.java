package DRDCWordTemplates;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

import bean.Question;

/**
 * 读取word上传上来的题目时候在最后多出一道空题，读取记事本编辑的上传上来的正常
* @author: qlq
* @date :  2017年7月25日上午9:04:12
 */
public class ReadWordUtils {
	private static List<Question> list = new ArrayList<Question>();
	@Test
	public List<Question> readWordData(String fileName) throws Exception{
				
		String str;
		FileInputStream fis;
		fis=new FileInputStream(""); //打开文件输入流
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
         String s[] = all.split("\t");
// 		System.out.println("共有:" + (s.length) + "道题");
 		// 对每一道题进行处理
/* 		for (int i = 0; i < s.length; i++) {
 			Question questionBank= new Question();
 			// 将题再分成题目选项什么的,抽取成一道一道的题
 			String[] question = s[i].split("\r\n");
// 			System.out.println("第" + (i + 1) + "道题共有" + question.length + "项");
// 			System.out.println(s[i]);
 			if (question.length == 6) {
// 				处理题干
 				String tigan = question[1].substring(4);
 				questionBank.setTimu(question[1].substring(4));
 				System.out.println("题干\t" + tigan);
// 				处理类型
 				String leixing = question[2].substring(4);
 				questionBank.setLeixing(leixing);
 				System.out.println("类型\t" + leixing);
// 				处理选项
 				String xuanxiang = question[3].substring(4);
// 				对选项进行分割处理
 				String xuanxiangarr[] = xuanxiang.split(",");
 				System.out.println(xuanxiangarr.length);
 				int cd = xuanxiangarr.length;
 				for(int k=0;k<cd;k++){
 					questionBank.setAxuanxiang(xuanxiangarr[0].substring(3, xuanxiangarr[0].length()-1));
 					questionBank.setBxuanxiang(xuanxiangarr[1].substring(3, xuanxiangarr[1].length()-1));
 					questionBank.setCxuanxiang(xuanxiangarr[2].substring(3, xuanxiangarr[2].length()-1));
 					questionBank.setDxuanxiang(xuanxiangarr[3].substring(3, xuanxiangarr[3].length()-1));
 				}
 				System.out.println("选项\t" + xuanxiang);
// 				处理答案
 				String daan = question[4].substring(4);
 				questionBank.setDaan(daan);
 				System.out.println("答案\t" + daan);
// 				处理解析
 				String jiexi = question[5].substring(4);
 				questionBank.setJiexi(jiexi);
 				System.out.println("解析\t" + jiexi);
 			}
 			if (question.length == 5) {
// 				处理题干
 				String tigan = question[1].substring(4);
 				questionBank.setTimu(tigan);
 				System.out.println("题干\t" + tigan);
// 				处理类型
 				String leixing = question[2].substring(4);
 				questionBank.setLeixing(leixing);
 				System.out.println("类型\t" + leixing);
// 				处理答案
 				String daan = question[3].substring(4);
 				questionBank.setDaan(daan);
 				System.out.println("答案\t" + daan);
// 				处理解析
 				String jiexi = question[4].substring(4);
 				questionBank.setJiexi(jiexi);
 				System.out.println("解析\t" + jiexi);
 			}
 			list.add(questionBank);
 			System.out.println();
 		}*/
 		return list;
         
	}
	
}
