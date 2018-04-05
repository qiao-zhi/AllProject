package POI;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIReadExcel {

	public static void main(String[] args) {
		File file = new File("e:/POI_TEST1.xls");
		try {
//			获取一个工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
//			获取一个工作表两种方式
//			HSSFSheet sheet = workbook.getSheet("sheet0");
//			获取工作表的第二种方式
			HSSFSheet sheet = workbook.getSheetAt(0);
			int firstRow = 0;
//			获取sheet的最后一行
			int lastRow = sheet.getLastRowNum();
			for(int i=firstRow;i<=lastRow;i++){
				HSSFRow row = sheet.getRow(i);
				int lastCol = row.getLastCellNum();
				for(int j=0;j<lastCol;j++){
					HSSFCell cell= row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value+"  ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
