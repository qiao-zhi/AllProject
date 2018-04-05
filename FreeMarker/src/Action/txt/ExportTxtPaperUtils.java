package Action.txt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.Question;

/*[题干]防抱死制动系统（ABS）在什么情况下可以最大限度发挥制动器效能?
[类型]单选
[选项]{A:间歇制动},{B:持续制动},{C:紧急制动},{D:缓踏制动踏板}
[答案]C
[解析]ABS的目的就是为了防止刹车的时候一脚踩死，导致翻车什么的。 不过刹车刹死就比较慢（速度N快的时候），效果等于踩下刹车，再松下刹车，反复几次！*/
public class ExportTxtPaperUtils {


/**
 * 将题目导入到txt中
 *@param list 数据 
 *@param fileName  txt文件
 */
	public static void  exportTxtPaper(List<Question> list,String fileName) {
//		"test.txt"
		File outFile = new File(fileName);
		Writer out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile,true), "utf-8"), 10240);
			for (int i = 0; i < list.size(); i++) {
				if(!list.get(i).getLeixing().equals("判断")){
					out.write(
							(i+1)+".  "+list.get(i).getTimu()+"("+list.get(i).getLeixing()+")"
							+ "\r\nA"+list.get(i).getAxuanxiang()
							+ "\r\nB"+list.get(i).getBxuanxiang()
							+ "\r\nC"+list.get(i).getCxuanxiang()
							+ "\r\nD"+list.get(i).getDxuanxiang()
							+ "\r\n答案:"+list.get(i).getDaan()
							+ "\r\n解析:"+list.get(i).getJiexi()+"\r\n");
					out.write("\r\n");
				}else{
					out.write(
							(i+1)+".  "+list.get(i).getTimu()+"("+list.get(i).getLeixing()+")"
							+ "\r\n答案:"+list.get(i).getDaan()
							+ "\r\n解析:"+list.get(i).getJiexi()+"\r\n");
					out.write("\r\n");
				}
				
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
		
		List<Question> list = new ArrayList<>();
		list.add(new Question("你喜欢吃什么", "单选", "老司机", "方便吗", "辣条", "牛奶", "老司机", "我是老司机"));
		list.add(new Question("你喜欢吃什么", "单选", "老司机", "方便吗", "辣条", "牛奶", "老司机", "我是老司机"));
		list.add(new Question("你喜欢吃什么", "单选", "老司机", "方便吗", "辣条", "牛奶", "老司机", "我是老司机"));
		list.add(new Question("你喜欢吃什么", "单选", "老司机", "方便吗", "辣条", "牛奶", "老司机", "我是老司机"));
		Question q = new Question();
		q.setTimu("这是一个测试");
		q.setLeixing("判断");
		q.setDaan("对");
		q.setJiexi("没理由");
		list.add(q);
		list.add(new Question("你是人", "判断", "", "", "", "", "是", "我是老司机"));
		list.add(new Question("你是人", "判断", "", "", "", "", "是", "我是老司机"));
		ExportTxtPaperUtils .exportTxtPaper(list,"test.txt");
	}
}
