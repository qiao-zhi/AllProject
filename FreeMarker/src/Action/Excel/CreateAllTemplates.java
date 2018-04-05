package Action.Excel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class CreateAllTemplates {

	/**
	 * 单选为 sheet1
	 * 多选为 sheet2
	 * 判断为 sheet3
	 */
	@Test
	public void test1(){
//		同一个工作簿创建的才可以创建不同的工作表到同一个文件
//		通过毫秒数获取唯一的名字
		String name = String.valueOf(System.currentTimeMillis());
		HSSFWorkbook wb = new HSSFWorkbook();
		CreteDanXuanTemplate.createDanXuan(wb,2,name);
		CreteDuoXuanTemplate.createDuoXuan(wb,2,name);
		CretePanDuanTemplate.createPanDuan(wb,2,name);
	}
}
