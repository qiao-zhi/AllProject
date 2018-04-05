package POIword;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class POIReadWord {
	/**
	 * @param 用POI读取word文件中的内容
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// word 2003： 图片不会被读取

		InputStream is = new FileInputStream(new File("F:\\11.doc"));

		@SuppressWarnings("resource")
		WordExtractor ex = new WordExtractor(is);
		String text2007 = ex.getText();
		System.out.println(text2007);

		// word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后

		/*
		 * OPCPackage opcPackage =
		 * POIXMLDocument.openPackage("E:/EclipseWorkspace/FreeMarker/test1.doc"
		 * ); POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
		 * String text2007 = extractor.getText();
		 */

		// 分割题 划分为一道一道的题
		String s[] = text2007.split("\n\n");
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
