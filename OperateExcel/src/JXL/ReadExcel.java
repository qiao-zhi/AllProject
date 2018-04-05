package JXL;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
	public static void main(String[] args) {
		try {
			Workbook workbook = Workbook.getWorkbook(new File("e:/JXL_TEST.xls"));
			Sheet sheet = workbook.getSheet(0);
			for (int i=0;i<sheet.getRows();i++){
				for(int j=0;j<sheet.getColumns();j++){
					Cell cell = sheet.getCell(j, i);
					System.out.print(cell.getContents()+"  ");
				}
				System.out.println();
			}
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
