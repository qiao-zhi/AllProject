package JXL;
import java.io.File;
import java.io.IOException;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * JXL导出excel
* @author: qlq
* @date :  2017年7月14日下午9:08:40
* @description:
 */
public class JXLExcel {

	public static void main(String[] args) throws Exception {
//		数组用于存放标题
		String[] title = {"id","name","sex"};
		File file = new File("E:/JXL_TEST.xls");
		try {
			file.createNewFile();
//			创建工作簿
			WritableWorkbook workbook  = Workbook.createWorkbook(file);
//			创建sheet页,0代表索引
			WritableSheet sheet = workbook.createSheet("sheet 1", 0);
//			在第一行列入列的名称
			Label label=null;
			for(int i=0;i<title.length;i++){
//				i代表第几列，0代表第一行。后面是插入的数据
				label = new Label(i,0,title[i]);
				sheet.addCell(label);
			}
//			插入数据
			for(int i=1;i<10;i++){
//				第一个参数是列号。第二个是行号
				label = new Label(0,i,"a"+i);
				sheet.addCell(label);
				label = new Label(1,i,"user"+i);
				sheet.addCell(label);
				label = new Label(2,i,"男");
				sheet.addCell(label);
			}
//			写入数据
			workbook.write();
			workbook.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
