package Action.txt;

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

import org.apache.log4j.Logger;
import org.junit.Test;

import bean.Question;

/**
 * 读取word上传上来的题目时候在最后多出一道空题，读取记事本编辑的上传上来的正常
 * 
 * @author: qlq
 * @date : 2017年7月25日上午9:04:12
 */
public class ReadTxtData {
	private static Logger log = Logger.getLogger(ReadTxtData.class);
	private static List<Question> list = new ArrayList<Question>();
	
	/**
	 * 传下来txt文件路径与名字，返回list<Question>
	 *@param fileName
	 *@return
	 *@throws Exception
	 */
	public static List<Question> readTxtData(String fileName) throws Exception {
		String str;
		FileInputStream fis;
//		"E:\\EclipseWorkspace\\FreeMarker\\test.txt"
		fis = new FileInputStream(fileName); // 打开文件输入流
		BufferedReader in = new BufferedReader(new InputStreamReader(fis, "utf-8"));

		// 用于保存实际读取的字符数

		StringBuffer sb = new StringBuffer();
		// 使用循环读取数据
		String line = "";
		while ((line = in.readLine()) != null) {
			if (!line.equals("")) {
				sb.append(line);
			}
		}

		String all = sb.toString().trim();
	/*	System.out.println(all);
		System.out.println("--------------------------------------");*/
//		System.out.println(all.trim());
//		System.out.println("--------------------------------------");
		
		List<Question> list = new ArrayList<>();
		
		// 分割题，以[题干]分割,注意第一个前面还有一道空的
		String ti[] = all.split("\\[题干\\]");
//		System.out.println(ti.length);
//		substring(start,end) 简单理解为从int开始取end-start个
		for (int i=1;i<ti.length;i++) {
			Question question = new Question();
			// 提取题干
			String tigan = ti[i].substring(0, ti[i].indexOf("[类型]"));
			question.setTimu(tigan);
//			System.out.println(tigan);
			// 提取类型
			int leixing_start = ti[i].indexOf("[类型]")+4;
			int leixing_end = leixing_start+2;
			String leixing = ti[i].substring(leixing_start,leixing_end);
			question.setLeixing(leixing);
//			System.out.println(leixing);
			// 提取ABCD
			if(leixing.equals("判断")){  //如果是判断题
//				提取答案，从[答案]后开始，取一个
				int daan_start = ti[i].indexOf("[答案]")+4;
				String daan = ti[i].substring(daan_start, daan_start+1);
				question.setDaan(daan);
//				System.out.println(daan);
//				提取解析
				int jiexi_start = ti[i].indexOf("[解析]")+4;
				String jiexi = ti[i].substring(jiexi_start);
				question.setJiexi(jiexi);
//				System.out.println(jiexi);
			}else{
//				提取ABCD选项:
				int a_start = ti[i].indexOf("[A选项]")+5;
				int a_end = ti[i].indexOf("[B选项]");
				String axuanxiang=ti[i].substring(a_start, a_end);
				question.setAxuanxiang(axuanxiang);
//				System.out.println(axuanxiang);
				
				int b_start = ti[i].indexOf("[B选项]")+5;
				int b_end = ti[i].indexOf("[C选项]");
				String bxuanxiang=ti[i].substring(b_start, b_end);
				question.setBxuanxiang(bxuanxiang);
//				System.out.println(bxuanxiang);
				
				int c_start = ti[i].indexOf("[C选项]")+5;
				int c_end = ti[i].indexOf("[D选项]");
				String cxuanxiang=ti[i].substring(c_start, c_end);
				question.setCxuanxiang(cxuanxiang);
//				System.out.println(cxuanxiang);
				
				int d_start = ti[i].indexOf("[D选项]")+5;
				int d_end = ti[i].indexOf("[答案]");
				String dxuanxiang=ti[i].substring(d_start, d_end);
				question.setDxuanxiang(dxuanxiang);
//				System.out.println(dxuanxiang);
				
//				提取答案
				int daan_start = ti[i].indexOf("[答案]")+4;
				int daan_end = ti[i].indexOf("[解析]");
				String daan = ti[i].substring(daan_start, daan_end);
				question.setDaan(daan);
//				System.out.println(daan);
//				提取解析
				int jiexi_start = ti[i].indexOf("[解析]")+4;
				String jiexi = ti[i].substring(jiexi_start);
				question.setJiexi(jiexi);
//				System.out.println(jiexi);
			}
			list.add(question);
		}
		return list;

	}
	
	@Test
	public void test1() throws Exception{
		List<Question> list1 = ReadTxtData.readTxtData("C:/Users/liqiang/Desktop/1.txt");
		System.out.println(list1);
	}
	

}
