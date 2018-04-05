package DRDCExcelTemplates.DCExcelPaper;

import org.junit.Test;

public class test1 {
	
	@Test
	public void test1() throws Exception{
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.exportExcel(new String[]{"A"}, "B",new Object[][]{{"1"},{"2"}} );
	}

}
