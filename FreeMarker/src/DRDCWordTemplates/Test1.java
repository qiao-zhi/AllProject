package DRDCWordTemplates;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/*[题干]防抱死制动系统（ABS）在什么情况下可以最大限度发挥制动器效能?
[类型]单选
[选项]{A:间歇制动},{B:持续制动},{C:紧急制动},{D:缓踏制动踏板}
[答案]C
[解析]ABS的目的就是为了防止刹车的时候一脚踩死，导致翻车什么的。 不过刹车刹死就比较慢（速度N快的时候），效果等于踩下刹车，再松下刹车，反复几次！*/
public class Test1 {

	private static File outFile = new File("test2.doc");

	/**
	 * 产生单选模板
	 * 
	 * @param num
	 *            单选数量
	 */
	public void danxuan(int num) {

		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile, true), "utf-8"), 10240);
			for (int i = 0; i < num; i++) {
				out.write("WWW\rWWWWWWWWWWWW汉字");
			}
			out.flush();
			out.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 测试产生模板
	 */
	@Test
	public void test1() {
		Test1 exportTemUtils = new Test1();
		exportTemUtils.danxuan(2);
		// System.out.println(System.currentTimeMillis());
	}

	public void read() throws Exception {
		FileInputStream fis;
		fis = new FileInputStream("E:\\EclipseWorkspace\\FreeMarker\\test2.doc"); // 打开文件输入流
		Reader in = new BufferedReader(new InputStreamReader(fis, "utf-8"));
		char[] cbuf = new char[1024];
		// 用于保存实际读取的字符数
		int hasRead = 0;
		StringBuffer sb = new StringBuffer();
		// 使用循环读取数据
		while ((hasRead = in.read(cbuf)) > 0) {

			// 将字符数组转化为字符串输出
			// System.out.println(new String(cbuf,0,hasRead));
			sb.append(new String(cbuf, 0, hasRead));

		}
		System.out.println(sb.toString());
	}

	@Test
	public void test4(){
		String string="121212121";
		String s[]=string.split("1");
		System.out.println(s.length);
		for(int i=0;i<s.length;i++){
			System.out.println("第"+(i+1)+"个元素"+s[i]);
		}
		
	}
	
	
//	对于/n划分原则保留前面的空，不保留后面的
/*	第1个元素
	第2个元素1
	第3个元素2*/
	@Test
	public void test2(){
		String string="\n1\n2\n";
		String s[]=string.split("\n");
		System.out.println(s.length);
		for(int i=0;i<s.length;i++){
			System.out.print("第"+(i+1)+"个元素"+s[i]);
		}
		
	}
//	对于/t划分原则
	@Test 
	public void test3(){
		String str="\n1\t2\t\n";
		String s1[]=str.split("\t");
		System.out.println(s1.length);
		for(int i=0;i<s1.length;i++){
			System.out.println("第"+(i+1)+"个元素"+s1[i]);
		}
		
	}
}
