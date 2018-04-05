package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.junit.Test;

/*[题干]防抱死制动系统（ABS）在什么情况下可以最大限度发挥制动器效能?
[类型]单选
[选项]{A:间歇制动},{B:持续制动},{C:紧急制动},{D:缓踏制动踏板}
[答案]C
[解析]ABS的目的就是为了防止刹车的时候一脚踩死，导致翻车什么的。 不过刹车刹死就比较慢（速度N快的时候），效果等于踩下刹车，再松下刹车，反复几次！*/
public class ExportTemUtils {

	private static File outFile = new File("test.doc");

	/**
	 * 产生单选模板
	 * 
	 * @param num
	 *            单选数量
	 */
	public void danxuan(int num) {

		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile,true), "utf-8"), 10240);
			for (int i = 0; i < num; i++) {
				out.write(
						"[题干]请在这里写题干?\n[类型]单选\n[选项]{A:请在这里写A选项},{B:请在这里写B选项},{C:请在这里写C选项},{D:请在这里写D选项}\n[答案]请在这里填写正确答案\n[解析]:在这里写解析");
				out.write("\n\n");
			}
			out.flush();
			out.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 产生多选
	 * 
	 * @param num
	 *            多选题数量
	 */
	public void duoxuan(int num) {
		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile,true), "utf-8"), 10240);
			for (int i = 0; i < num; i++) {
				out.write(
						"[题干]请在这里写题干?\n[类型]多选\n[选项]{A:请在这里写A选项},{B:请在这里写B选项},{C:请在这里写C选项},{D:请在这里写D选项}\n[答案]请在这里填写正确答案\n[解析]:在这里写解析");
				out.write("\n\n");
			}
			out.flush();
			out.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void panduan(int num){
		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile,true), "utf-8"), 10240);
			for (int i = 0; i < num; i++) {
				out.write(
						"[题干]请在这里写题干?\n[类型]判断题\n[答案]请在这里填写正确答案\n[解析]在这里写解析");
				out.write("\n\n");
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
	public void test1(){
		ExportTemUtils exportTemUtils=new ExportTemUtils();
		exportTemUtils.danxuan(1);
		exportTemUtils.duoxuan(1);
		exportTemUtils.panduan(1);
//		System.out.println(System.currentTimeMillis());
	}
}
