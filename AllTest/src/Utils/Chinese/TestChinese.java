package Utils.Chinese;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class TestChinese {

	@Test
	public void test2() throws UnsupportedEncodingException{
//		System.out.println(ChineseConvertAll.ConvertAll("这是什么意思!我bu明白"));
//		System.out.println(ChineseConvertFrist.convertFrist("这是什么意思！！！"));
//		System.out.println(ChineseConvertFrist.getPYChar("好"));
//		System.out.println(ChineseUtil.isEnglish("是不是全英文"));
		
//		System.out.println(ChineseUtil.isEnglish("is english"));
		
		String ss="中国",ss1="zhong";
		
		System.out.println(ss.getBytes().length);
		System.out.println(ss.getBytes().length);
		System.out.println(ss.getBytes("gbk").length);
		System.out.println(ss.length());
		System.out.println(ss1.getBytes().length);
		System.out.println(ss1.length());
		
		
	}
}
